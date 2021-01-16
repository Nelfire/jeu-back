package dev.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.dto.UniteeDto;
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

	// Production d'une ou plusieures unitées pour l'armée du joueur
	@PutMapping("/production")
	public Integer produireUnitee(@RequestBody @Valid Integer quantitee, @RequestParam("id") Integer idUnitee) {
		return this.armeeService.produireUnitee(quantitee,idUnitee);
	}
	
}
