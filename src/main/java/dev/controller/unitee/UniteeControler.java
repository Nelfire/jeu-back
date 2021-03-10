package dev.controller.unitee;

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
import dev.controller.dto.unitee.UniteeDto;
import dev.entites.unitee.Unitee;
import dev.services.unitee.UniteeService;

@RestController
@RequestMapping("unitee")
public class UniteeControler {

	private UniteeService uniteeService;

	/**
	 * @param uniteeService
	 */
	public UniteeControler(UniteeService uniteeService) {
		this.uniteeService = uniteeService;
	}

	/**
	 * CREATION D'UN NOUVEAU TYPE D'UNITE (Menu administrateur)
	 */
	@PostMapping
	public ResponseEntity<?> administrationCreerUnitee(@RequestBody Unitee unitee) {
		Unitee creerUnitee = uniteeService.administrationCreerUnitee(unitee);
		return ResponseEntity.status(HttpStatus.ACCEPTED).header("resultat", "Unitee Créée").body(creerUnitee);
	}

	/**
	 * LISTER TOUTES LES UNITES EXISTANTES
	 */
	@GetMapping
	public List<UniteeDto> listerDifferentesUnitees() {
		return this.uniteeService.listerDifferentesUnitees();
	}

	/**
	 * LISTER QUE LES UNITES DE TYPE DIVERS = 1
	 */
	@GetMapping("/listerUniteeDivers")
	public List<UniteeDto> listerUniteeDivers() {
		return this.uniteeService.listerUniteeDivers();
	}

	/**
	 * LISTER QUE LES UNITES DE TYPE INFANTERIE = 2
	 */
	@GetMapping("/listerUniteeInfanterie")
	public List<UniteeDto> listerUniteeInfanterie() {
		return this.uniteeService.listerUniteeInfanterie();
	}

	/**
	 * LISTER QUE LES UNITES DE TYPE CAVALERIE = 3
	 */
	@GetMapping("/listerUniteeCavalerie")
	public List<UniteeDto> listerUniteeCavalerie() {
		return this.uniteeService.listerUniteeCavalerie();
	}

	/**
	 * LISTER QUE LES UNITES DE TYPE SIEGE = 4
	 */
	@GetMapping("/listerUniteeSiege")
	public List<UniteeDto> listerUniteeSiege() {
		return this.uniteeService.listerUniteeSiege();
	}

	/**
	 * LISTER QUE LES UNITES DE TYPE NAVALE = 5
	 */
	@GetMapping("/listerUniteeNavale")
	public List<UniteeDto> listerUniteeNavale() {
		return this.uniteeService.listerUniteeNavale();
	}

	/**
	 * DETAIL D'UNE UNITE (Via ID)
	 */
	@GetMapping("/detailsUnitee")
	public UniteeDto detailsUnitee(@RequestParam("id") Integer idUnitee) {
		return this.uniteeService.detailsUnitee(idUnitee);
	}

	/**
	 * MODIFICATION D'UN TYPE D'UNITE (Menu administrateur, Via ID)
	 */
	@PutMapping("/modificationUnitee")
	public UniteeDto administrationModificationUnitee(@RequestBody @Valid UniteeDto uniteeDto,
			@RequestParam("id") Integer id) {
		return this.uniteeService.administrationModificationUnitee(uniteeDto, id);
	}

}
