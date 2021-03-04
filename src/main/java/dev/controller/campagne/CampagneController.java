package dev.controller.campagne;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.dto.campagne.CampagneDto;
import dev.entites.campagne.Campagne;
import dev.services.campagne.CampagneService;

@RestController
@RequestMapping("campagne")
public class CampagneController {

	private CampagneService campagneService;
	
	public CampagneController(CampagneService campagneService) {
		this.campagneService = campagneService;
	}
	
	/**
	 * LISTER TOUTES LES CAMPAGNES EXISTANTES
	 */
	@GetMapping
	public List<Campagne> listerLesCampagnes() {
		return this.campagneService.listerLesCampagnes();
	}
}
