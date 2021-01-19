/**
 * 
 */
package dev.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.dto.JoueurDto;
import dev.controller.dto.JoueurInfoDto;
import dev.services.JoueurService;

@RestController
@RequestMapping("joueur")
public class JoueurController {

	// Déclarations
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
	 * RECUPERER TOUS LES COLLEGUES
	 * 
	 * @return
	 */
	@GetMapping
	public List<JoueurDto> getAllJoueur() {
		return this.joueurService.getAllJoueurs();
	}
	

	@GetMapping("/all")
	public List<JoueurInfoDto> getAllInfoJoueur() {
		return this.joueurService.getAllInfoJoueurs();
	}
	

	@GetMapping("/infosJoueur")
	public JoueurInfoDto getInfoJoueur() {
		return this.joueurService.getInfoJoueur();
	}

}
