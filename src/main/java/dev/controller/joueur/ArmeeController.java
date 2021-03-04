package dev.controller.joueur;

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

import dev.controller.dto.batiment.BatimentJoueurDto;
import dev.controller.dto.joueur.ArmeeDto;
import dev.controller.dto.joueur.ArmeeJoueurCreationDto;
import dev.services.joueur.ArmeeService;

@RestController
@RequestMapping("armee")
public class ArmeeController {
	ArmeeService armeeService;

	/**
	 * @param armeeService
	 */
	public ArmeeController(ArmeeService armeeService) {
		super();
		this.armeeService = armeeService;
	}

	/**
	 * CREATION ARMEE DU JOUEUR (Nouvelles unitées)
	 * */
	@PostMapping
	public ResponseEntity<?> produireUnitee(@RequestBody ArmeeJoueurCreationDto batimentJoueurCreationDto) {
		ArmeeJoueurCreationDto saveUnitee = armeeService.produireUnitee(batimentJoueurCreationDto);
		return ResponseEntity.status(HttpStatus.ACCEPTED).header("resultat", "Unitée construite").body(saveUnitee);
	}
	
	/**
	 * LISTER LES ARMEES DU JOUEURS
	 * */
	@GetMapping("/listerArmeesDuJoueur")
	public List<ArmeeDto> listerArmeesDuJoueur() {
		return this.armeeService.listerArmeesDuJoueur();
	}
	
	
	
	/**
	 * ACCELERATION FORMATION DES UNITES (Contre gemmes)
	 */
	@PutMapping("/accelerationFormationUnite")
	public ArmeeDto accelerationFormationUnite(@RequestBody @Valid ArmeeDto armeeDto, @RequestParam("id") Integer id) {
		return this.armeeService.accelerationFormationUnite(armeeDto, id);
	}
	
}
