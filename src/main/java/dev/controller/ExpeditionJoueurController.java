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
	 * LISTES TOUTES LES EXPEDITIONS DU JOUEUR, TOUT CONFONDU
	 */
	@GetMapping
	public List<ExpeditionJoueur> listerExpeditionJoueur() {
		return this.expeditionJoueurService.listerExpeditionJoueur();
	}
	
	/**
	 * LISTER UNIQUEMENT LES EXPEDITIONS JOUEUR TERMINEES EN ECHEC = 3
	 */
	@GetMapping("/listerExpeditionJoueurTermineesEchec")
	public List<ExpeditionJoueur> listerExpeditionJoueurTermineesEchec() {
		return this.expeditionJoueurService.listerExpeditionJoueurTermineesEchec();
	}
	
	/**
	 * LISTER UNIQUEMENT LES EXPEDITIONS JOUEUR VICTORIEUSE + RECOMPENSE EN ATTENTE DE RECUPERATION = 1
	 */
	@GetMapping("/listerExpeditionJoueurRecompenseEnAttente")
	public List<ExpeditionJoueur> listerExpeditionJoueurRecompenseEnAttente() {
		return this.expeditionJoueurService.listerExpeditionJoueurRecompenseEnAttente();
	}
	
	/**
	 * LISTER UNIQUEMENT LES EXPEDITIONS JOUEUR VICTORIEUSE + RECOMPENSE DEJA RECUPEREE = 2
	 */
	@GetMapping("/listerExpeditionJoueurTermineesVictoire")
	public List<ExpeditionJoueur> listerExpeditionJoueurTermineesVictoire() {
		return this.expeditionJoueurService.listerExpeditionJoueurTermineesVictoire();
	}
	
	/**
	 * LISTER UNIQUEMENT LES EXPEDITIONS JOUEUR EN COURS = 0
	 */
	@GetMapping("/listerExpeditionJoueurEnCours")
	public List<ExpeditionJoueur> listerExpeditionJoueurEnCours() {
		return this.expeditionJoueurService.listerExpeditionJoueurEnCours();
	}
	
	
	
	/**
	 * ENVOI D'UNITEES EN EXPEDITION (Création)
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
