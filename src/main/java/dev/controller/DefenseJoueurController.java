package dev.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.entites.joueur.DefenseJoueur;
import dev.services.DefenseJoueurService;

@RestController
@RequestMapping("defensesJoueur")
public class DefenseJoueurController {

	private DefenseJoueurService defenseJoueurService;

	/**
	 * @param defenseJoueurService
	 */
	public DefenseJoueurController(DefenseJoueurService defenseJoueurService) {
		this.defenseJoueurService = defenseJoueurService;
	}
	
	@GetMapping
	public List<DefenseJoueur> listerMesDefenses() {
		return this.defenseJoueurService.listerMesDefenses();
	}
	
	
}
