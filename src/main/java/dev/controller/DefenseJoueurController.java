package dev.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.controller.dto.DefenseJoueurCreationDto;
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
	
	/**
	 * LISTER DIFFERENTES DEFENSES DU JOUEUR
	 */
	@GetMapping
	public List<DefenseJoueur> listerMesDefenses() {
		return this.defenseJoueurService.listerMesDefenses();
	}
	
	/**
	 * CREATION D'UNE DEFENSE JOUEUR (Nouvelles défense)
	 * */
	@PostMapping
	public ResponseEntity<?> construireDefense(@RequestBody DefenseJoueurCreationDto defenseJoueurCreationDto) {
		DefenseJoueurCreationDto saveDefense = defenseJoueurService.construireDefense(defenseJoueurCreationDto);
		return ResponseEntity.status(HttpStatus.ACCEPTED).header("resultat", "Défense construite").body(saveDefense);
	}
	
}
