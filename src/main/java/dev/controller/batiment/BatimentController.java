package dev.controller.batiment;

import java.util.List;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import dev.controller.dto.batiment.BatimentDto;
import dev.services.batiment.BatimentService;

@RestController
@RequestMapping("batiment")
public class BatimentController {

	// Déclarations
	private BatimentService batimentService;

	/**
	 * Constructeur
	 * 
	 * @param joueurService
	 */
	public BatimentController(BatimentService batimentService) {
		this.batimentService = batimentService;
	}

	/**
	 * LISTER TOUS LES BATIMENTS EXISTANTS
	 */
	@GetMapping
	public List<BatimentDto> getAllBatiments() {
		return this.batimentService.listerBatiments();
	}
	
	/**
	 * LISTER QUE LES BATIMENTS DE TYPE DIVERS = 0
	 */
	@GetMapping("/listerBatimentsDivers")
	public List<BatimentDto> listerBatimentsDivers() {
		return this.batimentService.listerBatimentsDivers();
	}
	/**
	 * LISTER QUE LES BATIMENTS DE TYPE RECOLTE = 1
	 */
	@GetMapping("/listerBatimentsRecolte")
	public List<BatimentDto> listerBatimentsRecolte() {
		return this.batimentService.listerBatimentsRecolte();
	}

	/**
	 * LISTER QUE LES BATIMENTS DE TYPE STOCKAGE = 2
	 */
	@GetMapping("/listerBatimentsStockage")
	public List<BatimentDto> listerBatimentsStockage() {
		return this.batimentService.listerBatimentsStockage();
	}

	/**
	 * LISTER QUE LES BATIMENTS DE TYPE MILLITAIRE = 3
	 */
	@GetMapping("/listerBatimentsMillitaire")
	public List<BatimentDto> listerBatimentsMillitaire() {
		return this.batimentService.listerBatimentsMillitaire();
	}

	/**
	 * DETAIL D'UN BATIMENT (Via ID)
	 */
	@GetMapping("/idTypeBatiment")
	public BatimentDto detailsBatiment(@RequestParam("idTypeBatiment") Integer idTypeBatiment) {
		return this.batimentService.detailsBatiment(idTypeBatiment);
	}
	
	/**
	 * MODIFICATION D'UN BÂTIMENT (Menu administrateur, Via ID)
	 */
	@PutMapping("/modificationBatiment")
	public BatimentDto administrationModificationBatiment (@RequestBody @Valid BatimentDto batimentDto, @RequestParam("id") Integer id) {
		return this.batimentService.administrationModificationBatiment(batimentDto,id);
	}
}
