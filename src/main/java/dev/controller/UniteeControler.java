package dev.controller;

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

import dev.controller.dto.UniteeDto;
import dev.entites.unitee.Unitee;
import dev.services.UniteeService;

@RestController
@RequestMapping("unitee")
public class UniteeControler {

	private UniteeService uniteeService;

	public UniteeControler(UniteeService uniteeService) {
		this.uniteeService = uniteeService;
	}

	@PostMapping
	public ResponseEntity<?> administrationCreerUnitee(@RequestBody Unitee unitee) {
		Unitee creerUnitee = uniteeService.administrationCreerUnitee(unitee);
		return ResponseEntity.status(HttpStatus.ACCEPTED).header("resultat", "Unitee Créée").body(creerUnitee);
	}
	
	@GetMapping
	public List<UniteeDto> listerDifferentesUnitees() {
		return this.uniteeService.listerDifferentesUnitees();
	}
	
	@GetMapping("/detailsUnitee")
	public UniteeDto detailsUnitee(@RequestParam("id") Integer idUnitee) {
		return this.uniteeService.detailsUnitee(idUnitee);
	}
	
	@PutMapping("/modificationUnitee")
	public UniteeDto administrationModificationUnitee (@RequestBody @Valid UniteeDto uniteeDto, @RequestParam("id") Integer id) {
		System.out.println("Ligne 49");
		System.out.println(uniteeDto.toString());
		return this.uniteeService.administrationModificationUnitee(uniteeDto,id);
	}

}
