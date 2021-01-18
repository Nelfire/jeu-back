package dev.controller;

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

import dev.controller.dto.BatimentDto;
import dev.controller.dto.BatimentJoueurCreationDto;
import dev.controller.dto.BatimentJoueurDto;
import dev.entites.Joueur;
import dev.entites.batiment.Batiment;
import dev.services.BatimentJoueurService;
import dev.services.BatimentService;

@RestController
@RequestMapping("batimentsJoueur")
public class BatimentJoueurController {

	// Déclarations
	private BatimentJoueurService batimentJoueurService;
	private BatimentService batimentService;

	/**
	 * Constructeur
	 * 
	 * @param joueurService
	 */
	
	public BatimentJoueurController(BatimentJoueurService batimentJoueurService) {
		this.batimentJoueurService = batimentJoueurService;
	}

	// http://localhost:8080/batimentsJoueur/idJoueur?idJoueur=1
	@GetMapping
	public List<BatimentJoueurDto> listerMesBatiments() {
		return this.batimentJoueurService.listerMesBatiments();
	}

	// http://localhost:8080/batimentsJoueur/idBatiment?idBatiment=1
	@GetMapping("/idTypeBatiment")
	public BatimentJoueurDto rechercheBatimentJoueur(@RequestParam("idTypeBatiment") Integer idTypeBatiment) {
		return this.batimentJoueurService.rechercheBatimentJoueur(idTypeBatiment);
	}
	
	
	// http://localhost:8080/batimentsJoueur/idJoueur?idJoueur=1
	@PostMapping
	public ResponseEntity<?> creationBatimentJoueur(@RequestBody BatimentJoueurCreationDto batimentJoueurCreationDto) {
		BatimentJoueurCreationDto saveBatiment = batimentJoueurService.creationBatimentJoueur(batimentJoueurCreationDto);
		return ResponseEntity.status(HttpStatus.ACCEPTED).header("resultat", "Batiment construit").body(saveBatiment);
	}
	
	@PutMapping("/modification")
	public BatimentJoueurDto putBatimentJoueur(@RequestBody @Valid BatimentJoueurDto batimentJoueurDto, @RequestParam("id") Integer id) {
		System.out.println("Modifications COntroller");
		return this.batimentJoueurService.putBatimentJoueur(batimentJoueurDto, id);
	}
	
	// Recherche de la population maximale du joueur
	@GetMapping("/popultationMaximale")
	public Integer RecherchePopulationMaximaleJoueur() {
		return this.batimentJoueurService.RecherchePopulationMaximaleJoueur();
	}
		
		

}
