package dev.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.dto.BatimentJoueurDto;
import dev.entites.Joueur;
import dev.services.BatimentJoueurService;

@RestController
@RequestMapping("batimentsJoueur")
public class BatimentJoueurController {

	// Déclarations
	private BatimentJoueurService batimentJoueurService;

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
}