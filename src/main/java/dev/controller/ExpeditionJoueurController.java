package dev.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.entites.joueur.ExpeditionJoueur;
import dev.services.ExpeditionJoueurService;

@RestController
@RequestMapping("expeditionJoueur")
public class ExpeditionJoueurController {

	ExpeditionJoueurService expeditionJoueurService;
	
	public ExpeditionJoueurController(ExpeditionJoueurService expeditionJoueurService) {
		this.expeditionJoueurService = expeditionJoueurService;
	}
	
	// Lister les expéditions
	@GetMapping
	public List<ExpeditionJoueur> listerExpeditionJoueur() {
		return this.expeditionJoueurService.listerExpeditionJoueur();
	}
	
	
}
