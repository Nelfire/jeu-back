package dev.controller.social;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import dev.controller.dto.social.AjoutAmiDto;
import dev.entites.social.ListeAmis;
import dev.services.social.ListeAmisService;

@RestController
@RequestMapping("listeAmis")
public class ListeAmisController {

	private ListeAmisService listeAmisService;

	public ListeAmisController(ListeAmisService listeAmisService) {
		super();
		this.listeAmisService = listeAmisService;
	}
	
	/**
	 * AJOUTER UN NOUVEL AMI
	 */
	@PostMapping
	public ResponseEntity<?> ajouterAmi(@RequestBody AjoutAmiDto idAmi) {
		AjoutAmiDto ami = listeAmisService.ajouterAmi(idAmi);
		return ResponseEntity.status(HttpStatus.ACCEPTED).header("resultat", "Ami ajouté").body(ami);
	}
	
	/**
	 * LISTER LES AMIS DU JOUEUR
	 */
	@GetMapping("/lister")
	public ListeAmis lister() {
		return this.listeAmisService.lister();
	}
	

	/**
	 * MODIFICATION LISTE AMI (Retrait d'un ami)
	 */
	@PutMapping("/retirerAmi")
	public AjoutAmiDto retirerAmi(@RequestBody @Valid AjoutAmiDto idAmis, @RequestParam("id") Integer id) {
		return this.listeAmisService.retirerAmi(idAmis, id);
	}
}
