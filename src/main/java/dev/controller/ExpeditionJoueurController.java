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

import dev.controller.dto.CompositionArmeeExpedition;
import dev.entites.joueur.ExpeditionJoueur;
import dev.services.ExpeditionJoueurService;

@RestController
@RequestMapping("expeditionJoueur")
public class ExpeditionJoueurController {

	ExpeditionJoueurService expeditionJoueurService;
	
	public ExpeditionJoueurController(ExpeditionJoueurService expeditionJoueurService) {
		this.expeditionJoueurService = expeditionJoueurService;
	}
	
	/**
	 * LISTES TOUTES LES EXPEDITIONS DU JOUEUR
	 */
	@GetMapping
	public List<ExpeditionJoueur> listerExpeditionJoueur() {
		return this.expeditionJoueurService.listerExpeditionJoueur();
	}
	
	/**
	 * ENVOI D'UNITEES EN EXPEDITION
	 */
	@PostMapping
	public ResponseEntity<?> envoiUniteeEnExpedition(@RequestBody CompositionArmeeExpedition compositionArmeeExpedition) {
		CompositionArmeeExpedition composition = expeditionJoueurService.envoiUniteeEnExpedition(compositionArmeeExpedition);
		return ResponseEntity.status(HttpStatus.ACCEPTED).header("resultat", "Expédition lancée").body(composition);
	}
	
	/**
	 * RECUPERATION DE LA RECOMPENSE D'EXPEDITION
	 */
	@GetMapping("/recupererRecompense")
	public String recupererRecompense(@RequestParam("idExpedition") Integer idExpedition) {
		return this.expeditionJoueurService.recupererRecompense(idExpedition);
	}
}
