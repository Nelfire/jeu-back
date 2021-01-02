package dev.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.dto.BatimentDto;
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
		@GetMapping("/idJoueur")
		public List<BatimentJoueurDto> listerMesBatiments(@RequestParam("idJoueur") Integer idJoueur) {
			return this.batimentJoueurService.listerMesBatiments(idJoueur);
		}
		
//		// http://localhost:8080/batimentsJoueur/idJoueur?idJoueur=1
//		@PostMapping
//		public Integer creationBatimentJoueur(@RequestBody Integer idTypeBatiment, Integer idJoueur) {
//			//BatimentJoueurDto saveBatiment = batimentService.creationBatimentJoueur(batimentJoueurDto);
//			//return ResponseEntity.status(HttpStatus.ACCEPTED).header("resultat", "Batiment construit").body(saveBatiment);
//			return idTypeBatiment;
//		}
		
		

}
