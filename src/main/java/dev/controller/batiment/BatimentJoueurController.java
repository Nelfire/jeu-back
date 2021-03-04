package dev.controller.batiment;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.dto.batiment.BatimentJoueurCreationDto;
import dev.controller.dto.batiment.BatimentJoueurDto;
import dev.services.batiment.BatimentJoueurService;

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

	/**
	 * LISTAGE DE TOUS LES BATIMENTS QUE POSSEDE LE JOUEUR
	 */
	@GetMapping
	public List<BatimentJoueurDto> listerMesBatiments() {
		return this.batimentJoueurService.listerMesBatiments();
	}

	/**
	 * DETAILS D'UN BATIMENT JOUEUR (Via ID)
	 */
	@GetMapping("/idTypeBatiment")
	public BatimentJoueurDto rechercheBatimentJoueur(@RequestParam("idTypeBatiment") Integer idTypeBatiment) {
		return this.batimentJoueurService.rechercheBatimentJoueur(idTypeBatiment);
	}
	
	
	/**
	 * CREATION D'UN NOUVEAU BATIMENT JOUEUR (Construction)
	 */
	@PostMapping
	public ResponseEntity<?> creationBatimentJoueur(@RequestBody BatimentJoueurCreationDto batimentJoueurCreationDto) {
		BatimentJoueurCreationDto saveBatiment = batimentJoueurService.creationBatimentJoueur(batimentJoueurCreationDto);
		return ResponseEntity.status(HttpStatus.ACCEPTED).header("resultat", "Batiment construit").body(saveBatiment);
	}
	
	/**
	 * MODIFICATION D'UN BATIMENT JOUEUR (Amélioration)
	 */
	@PutMapping("/modification")
	public BatimentJoueurDto putBatimentJoueur(@RequestBody @Valid BatimentJoueurDto batimentJoueurDto, @RequestParam("id") Integer id) {
		return this.batimentJoueurService.putBatimentJoueur(batimentJoueurDto, id);
	}
	/**
	 * ACCELERATION CONSTRUCTION D'UN BATIMENT JOUEUR (Contre gemmes)
	 */
	@PutMapping("/accelerationConstructionBatiment")
	public BatimentJoueurDto accelerationConstructionBatiment(@RequestBody @Valid BatimentJoueurDto batimentJoueurDto, @RequestParam("id") Integer id) {
		return this.batimentJoueurService.accelerationConstructionBatiment(batimentJoueurDto, id);
	}
	
	
	
	
//	/**
//	 * RECHERCHE POPULATION MAXIMALE DU JOUEUR
//	 */
//	@GetMapping("/popultationMaximale")
//	public Integer RecherchePopulationMaximaleJoueur() {
//		return this.batimentJoueurService.RecherchePopulationMaximaleJoueur();
//	}
}
