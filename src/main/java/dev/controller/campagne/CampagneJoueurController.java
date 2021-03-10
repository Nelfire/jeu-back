package dev.controller.campagne;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.dto.campagne.CompositionArmeeCampagneDto;
import dev.entites.campagne.CampagneJoueur;
import dev.services.campagne.CampagneJoueurService;

@RestController
@RequestMapping("campagneJoueur")
public class CampagneJoueurController {

	private CampagneJoueurService campagneJoueurService;

	/**
	 * @param campagneJoueurService
	 */
	public CampagneJoueurController(CampagneJoueurService campagneJoueurService) {
		this.campagneJoueurService = campagneJoueurService;
	}

	/**
	 * LISTES TOUTES LES CAMPAGNES DU JOUEUR, TOUT CONFONDU
	 */
	@GetMapping
	public List<CampagneJoueur> listerCampagneJoueur() {
		return this.campagneJoueurService.listerCampagneJoueur();
	}

	/**
	 * ENVOI D'UNITES EN CAMPAGNE (Création)
	 */
	@PostMapping
	public ResponseEntity<?> envoiUniteeEnCampagne(@RequestBody CompositionArmeeCampagneDto compositionArmeeCampagne) {
		CompositionArmeeCampagneDto composition = campagneJoueurService.envoiUniteeEnCampagne(compositionArmeeCampagne);
		return ResponseEntity.status(HttpStatus.ACCEPTED).header("resultat", "Campagne lancée").body(composition);
	}

	/**
	 * RECUPERATION DE LA RECOMPENSE
	 */
	@GetMapping("/recupererRecompense")
	public CampagneJoueur recupererRecompense(@RequestParam("idCampagne") Integer idCampagne) {
		return this.campagneJoueurService.recupererRecompense(idCampagne);
	}

}
