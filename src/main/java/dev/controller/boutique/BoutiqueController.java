package dev.controller.boutique;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.services.boutique.BoutiqueService;

@RestController
@RequestMapping("boutique")
public class BoutiqueController {

	private BoutiqueService boutiqueService;

	/**
	 * @param boutiqueService
	 */
	public BoutiqueController(BoutiqueService boutiqueService) {
		super();
		this.boutiqueService = boutiqueService;
	}

	/**
	 * [Pierre] Achat 10% des réserves
	 */
	@PostMapping("/achat10PourcentPierre")
	public void achat10PourcentPierre() {
		this.boutiqueService.achat10PourcentPierre();
	}

	/**
	 * [Pierre] Achat 50% des réserves
	 */
	@PostMapping("/achat50PourcentPierre")
	public void achat50PourcentPierre() {
		this.boutiqueService.achat50PourcentPierre();
	}

	/**
	 * [Pierre] Achat 100% des réserves
	 */
	@PostMapping("/achat100PourcentPierre")
	public void achat100PourcentPierre() {
		this.boutiqueService.achat100PourcentPierre();
	}

	/**
	 * [Bois] Achat 10% des réserves
	 */
	@PostMapping("/achat10PourcentBois")
	public void achat10PourcentBois() {
		this.boutiqueService.achat10PourcentBois();
	}

	/**
	 * [Bois] Achat 50% des réserves
	 */
	@PostMapping("/achat50PourcentBois")
	public void achat50PourcentBois() {
		this.boutiqueService.achat50PourcentBois();
	}

	/**
	 * [Bois] Achat 100% des réserves
	 */
	@PostMapping("/achat100PourcentBois")
	public void achat100PourcentBois() {
		this.boutiqueService.achat100PourcentBois();
	}

	/**
	 * [Or] Achat 10% des réserves
	 */
	@PostMapping("/achat10PourcentOr")
	public void achat10PourcentOr() {
		this.boutiqueService.achat10PourcentOr();
	}

	/**
	 * [Or] Achat 50% des réserves
	 */
	@PostMapping("/achat50PourcentOr")
	public void achat50PourcentOr() {
		this.boutiqueService.achat50PourcentOr();
	}

	/**
	 * [Or] Achat 100% des réserves
	 */
	@PostMapping("/achat100PourcentOr")
	public void achat100PourcentOr() {
		this.boutiqueService.achat100PourcentOr();
	}

	/**
	 * [Nourriture] Achat 10% des réserves
	 */
	@PostMapping("/achat10PourcentNourriture")
	public void achat10PourcentNourriture() {
		this.boutiqueService.achat10PourcentNourriture();
	}

	/**
	 * [Nourriture] Achat 50% des réserves
	 */
	@PostMapping("/achat50PourcentNourriture")
	public void achat50PourcentNourriture() {
		this.boutiqueService.achat50PourcentNourriture();
	}

	/**
	 * [Nourriture] Achat 100% des réserves
	 */
	@PostMapping("/achat100PourcentNourriture")
	public void achat100PourcentNourriture() {
		this.boutiqueService.achat100PourcentNourriture();
	}

}
