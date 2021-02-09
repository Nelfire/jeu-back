package dev.controller.batiment;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.dto.batiment.DefenseDto;
import dev.controller.dto.unitee.UniteeDto;
import dev.entites.batiment.Defense;
import dev.services.batiment.DefenseService;

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
	
	
	/**
	 * DETAIL D'UN UNITEE (Via ID)
	 */
	@GetMapping("/detailsDefense")
	public DefenseDto detailsDefense(@RequestParam("id") Integer idDefense) {
		return this.defenseService.detailsDefense(idDefense);
	}

}
