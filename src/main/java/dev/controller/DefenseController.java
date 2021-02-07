package dev.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.entites.batiment.Defense;
import dev.services.DefenseService;

@RestController
@RequestMapping("defense")
public class DefenseController {
	
	private DefenseService defenseService;

	public DefenseController(DefenseService defenseService) {
		this.defenseService = defenseService;
	}
	
	/**
	 * LISTE LES DIFFERENTS TYPES DE DEFENSE
	 */
	
	@GetMapping("/listerDefense")
	public List<Defense> listerDefense() {
		return this.defenseService.listerDefense();
	}
	

}
