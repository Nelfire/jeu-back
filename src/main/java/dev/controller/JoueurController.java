/**
 * 
 */
package dev.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.dto.CompositionArmeeExpedition;
import dev.controller.dto.InformationRessourcesJoueur;
import dev.controller.dto.JoueurDto;
import dev.controller.dto.JoueurInfoDto;
import dev.controller.dto.ModificationJoueurDto;
import dev.entites.Joueur;
import dev.services.JoueurService;

@RestController
@RequestMapping("joueur")
public class JoueurController {

	private JoueurService joueurService;

	/**
	 * Constructeur
	 * 
	 * @param joueurService
	 */
	public JoueurController(JoueurService joueurService) {
		this.joueurService = joueurService;
	}

	/**
	 * RECUPERER TOUS LES JOUEURS
	 */
	@GetMapping
	public List<JoueurDto> getAllJoueur() {
		return this.joueurService.getAllJoueurs();
	}
	
	/**
	 * RECUPERATION DES INFORMATIONS DES JOUEURS
	 */
	@GetMapping("/all")
	public List<JoueurInfoDto> getAllInfoJoueur() {
		return this.joueurService.getAllInfoJoueurs();
	}
	
	/**
	 * RECUPERATION INFORMATIONS JOUEUR CONNECTE
	 */
	@GetMapping("/infosJoueur")
	public JoueurInfoDto getInfoJoueur() {
		return this.joueurService.getInfoJoueur();
	}
	
	/**
	 * RECUPERATION INFORMATIONS JOUEUR CONNECTE
	 */
	@GetMapping("/informationJoueurById")
	public JoueurInfoDto informationJoueurById(@RequestParam("id") Integer id) {
		return this.joueurService.informationJoueurById(id);
	}
	
	
	@PutMapping("/modifierInformationsJoueur")
	public Joueur modifierInformationsJoueur(@RequestBody @Valid ModificationJoueurDto modificationJoueurDto) {
		return this.joueurService.modifierInformationsJoueur(modificationJoueurDto);
	}
	
	/**
	 * RECAPITULATIF DES INFORMATIONS RESSOURCE DU JOUEUR
	 */
	@GetMapping("/informationRessourcesJoueur")
	public InformationRessourcesJoueur informationRessourcesJoueur() {
		return this.joueurService.informationRessourcesJoueur();
	}

}
