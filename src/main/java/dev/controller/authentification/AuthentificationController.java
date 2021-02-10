package dev.controller.authentification;


import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.dto.joueur.JoueurDto;
import dev.repository.JoueurRepo;

@RestController
public class AuthentificationController {

	// Déclarations
	private JoueurRepo joueurRepo;

	/**
	 * Constructeur
	 * 
	 * @param joueurRepo
	 */
	public AuthentificationController(JoueurRepo joueurRepo) {
		this.joueurRepo = joueurRepo;
	}

	/**
	 * QUI SUIS-JE ?
	 * 
	 * @return
	 */
	@GetMapping("/me")
	public ResponseEntity<?> quiSuisJe() {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		return this.joueurRepo.findByEmail(email).map(JoueurDto::new).map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
	}
}