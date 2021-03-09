package dev.controller.batiment;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import dev.controller.dto.batiment.DefenseDto;
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
	
	
	/**
	 * MODIFICATION D'UNE DEFENSE (Menu administrateur, Via ID)
	 */
	@PutMapping("/modificationDefense")
	public DefenseDto administrationModificationDefense (@RequestBody @Valid DefenseDto defenseDto, @RequestParam("id") Integer id) {
		return this.defenseService.administrationModificationDefense(defenseDto,id);
	}
	
	/**
	 * LISTER QUE LES DEFENSES DE TYPE OFFENSIVE = 1
	 */
	@GetMapping("/listerDefensesOffensive")
	public List<Defense> listerDefensesOffensive() {
		return this.defenseService.listerDefensesOffensive();
	}
	
	/**
	 * LISTER QUE LES DEFENSES DE TYPE DEFENSIVE = 2
	 */
	@GetMapping("/listerDefensesDefensive")
	public List<Defense> listerDefensesDefensive() {
		return this.defenseService.listerDefensesDefensive();
	}

}
