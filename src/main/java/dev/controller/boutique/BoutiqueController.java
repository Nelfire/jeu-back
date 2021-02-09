package dev.controller.boutique;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@PostMapping("/achat10PourcentPierre")
	public void achat10PourcentPierre() {
		System.out.println("Achat 10% pierre controller");
		this.boutiqueService.achat10PourcentPierre();
	}
	@PostMapping("/achat50PourcentPierre")
	public void achat50PourcentPierre() {
		this.boutiqueService.achat50PourcentPierre();
	}
	@PostMapping("/achat100PourcentPierre")
	public void achat100PourcentPierre() {
		this.boutiqueService.achat100PourcentPierre();
	}
	
	
	@PostMapping("/achat10PourcentBois")
	public void achat10PourcentBois() {
		this.boutiqueService.achat10PourcentBois();
	}
	@PostMapping("/achat50PourcentBois")
	public void achat50PourcentBois() {
		this.boutiqueService.achat50PourcentBois();
	}
	@PostMapping("/achat100PourcentBois")
	public void achat100PourcentBois() {
		this.boutiqueService.achat100PourcentBois();
	}
	
	
	@PostMapping("/achat10PourcentOr")
	public void achat10PourcentOr() {
		this.boutiqueService.achat10PourcentOr();
	}
	@PostMapping("/achat50PourcentOr")
	public void achat50PourcentOr() {
		this.boutiqueService.achat50PourcentOr();
	}
	@PostMapping("/achat100PourcentOr")
	public void achat100PourcentOr() {
		this.boutiqueService.achat100PourcentOr();
	}
	
	
	@PostMapping("/achat10PourcentNourriture")
	public void achat10PourcentNourriture() {
		this.boutiqueService.achat10PourcentNourriture();
	}
	@PostMapping("/achat50PourcentNourriture")
	public void achat50PourcentNourriture() {
		this.boutiqueService.achat50PourcentNourriture();
	}
	@PostMapping("/achat100PourcentNourriture")
	public void achat100PourcentNourriture() {
		this.boutiqueService.achat100PourcentNourriture();
	}


}
