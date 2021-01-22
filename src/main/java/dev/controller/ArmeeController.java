package dev.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.dto.ArmeeDto;
import dev.controller.dto.ArmeeJoueurCreationDto;
import dev.services.ArmeeService;

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
	
}
