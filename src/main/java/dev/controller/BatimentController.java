package dev.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.dto.BatimentDto;
import dev.controller.dto.JoueurDto;
import dev.services.BatimentService;
import dev.services.JoueurService;

@RestController
@RequestMapping("batiment")
public class BatimentController {

	// Déclarations
	private BatimentService batimentService;

	/**
	 * Constructeur
	 * 
	 * @param joueurService
	 */
	public BatimentController(BatimentService batimentService) {
		this.batimentService = batimentService;
	}
	
	@GetMapping
	public List<BatimentDto> getAllBatiments() {
		return this.batimentService.listerBatiments();
	}
}
