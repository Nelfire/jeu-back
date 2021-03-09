package dev.controller.campagne;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	/**
	 * LISTER LES CAMPAGNES DU MONDE 1
	 */
	@GetMapping("/listerLesCampagnesMonde")
	public List<Campagne> listerLesCampagnesMonde(@RequestParam("numeroMonde") Integer numeroMonde) {
		return this.campagneService.listerLesCampagnesMonde(numeroMonde);
	}
	
	/**
	 * DETAILS D'UNE CAMPAGNE (Via ID)
	 */
	@GetMapping("/detailsCampagne")
	public Campagne detailsCampagne(@RequestParam("id") Integer idCampagne) {
		return this.campagneService.detailsCampagne(idCampagne);
	}
	
	/**
	 * CREATION D'UNE CAMPAGNE (Menu administrateur)
	 */
	@PostMapping
	public ResponseEntity<?> administrationCreerCampagne(@RequestBody CampagneDto campagne) {
		CampagneDto creerUnitee = campagneService.administrationCreerCampagne(campagne);
		return ResponseEntity.status(HttpStatus.ACCEPTED).header("resultat", "Campagne Créée").body(creerUnitee);
	}
	
	/**
	 * MODIFICATION D'UNE CAMPAGNE (Menu administrateur, Via ID)
	 */
	@PutMapping("/modificationCampagne")
	public CampagneDto administrationModificationCampagne (@RequestBody @Valid CampagneDto campagneDto, @RequestParam("id") Integer id) {
		return this.campagneService.administrationModificationCampagne(campagneDto,id);
	}
}
