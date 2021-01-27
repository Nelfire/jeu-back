package dev.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.dto.BatimentDto;
import dev.services.BatimentService;

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

	/**
	 * LISTER TOUS LES BATIMENTS EXISTANTS
	 */
	@GetMapping
	public List<BatimentDto> getAllBatiments() {
		return this.batimentService.listerBatiments();
	}
	
	/**
	 * LISTER QUE LES BATIMENTS DE TYPE DIVERS = 0
	 */
	@GetMapping("/listerbatimentsDivers")
	public List<BatimentDto> listerbatimentsDivers() {
		return this.batimentService.listerbatimentsDivers();
	}
	/**
	 * LISTER QUE LES BATIMENTS DE TYPE RECOLTE = 1
	 */
	@GetMapping("/listerbatimentsRecolte")
	public List<BatimentDto> listerbatimentsRecolte() {
		return this.batimentService.listerbatimentsRecolte();
	}

	/**
	 * LISTER QUE LES BATIMENTS DE TYPE STOCKAGE = 2
	 */
	@GetMapping("/listerbatimentsStockage")
	public List<BatimentDto> listerbatimentsStockage() {
		return this.batimentService.listerbatimentsStockage();
	}

	/**
	 * LISTER QUE LES BATIMENTS DE TYPE MILLITAIRE = 3
	 */
	@GetMapping("/listerbatimentsMillitaire")
	public List<BatimentDto> listerbatimentsMillitaire() {
		return this.batimentService.listerbatimentsMillitaire();
	}

	/**
	 * DETAIL D'UN BATIMENT (Via ID)
	 */
	@GetMapping("/idTypeBatiment")
	public BatimentDto detailsBatiment(@RequestParam("idTypeBatiment") Integer idTypeBatiment) {
		return this.batimentService.detailsBatiment(idTypeBatiment);
	}
}
