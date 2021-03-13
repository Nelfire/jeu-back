package dev.controller.joueur;

import java.util.List;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import dev.controller.dto.divers.EchangeRessourceDto;
import dev.controller.dto.divers.GainRessourceDto;
import dev.controller.dto.joueur.InformationRessourcesJoueur;
import dev.controller.dto.joueur.JoueurDto;
import dev.controller.dto.joueur.JoueurInfoDto;
import dev.controller.dto.joueur.JoueurInfoMinimaleDto;
import dev.controller.dto.joueur.ModificationJoueurDto;
import dev.entites.joueur.Joueur;
import dev.services.joueur.JoueurService;

@RestController
@RequestMapping("joueur")
public class JoueurController {

	private JoueurService joueurService;

	/**
	 * @param joueurService
	 */
	public JoueurController(JoueurService joueurService) {
		this.joueurService = joueurService;
	}

	/**
	 * RECUPERER TOUS LES JOUEURS
	 */
	@GetMapping
	public List<JoueurDto> getAllJoueur() {
		return this.joueurService.getAllJoueurs();
	}

	/**
	 * RECUPERATION DES INFORMATIONS DES JOUEURS
	 */
	@GetMapping("/all")
	public List<JoueurInfoMinimaleDto> getAllInfoJoueur() {
		return this.joueurService.getAllInfoJoueurs();
	}

	/**
	 * RECUPERATION INFORMATIONS JOUEUR CONNECTE
	 */
	@GetMapping("/infosJoueur")
	public JoueurInfoDto getInfoJoueur() {
		return this.joueurService.getInfoJoueur();
	}

	/**
	 * RECUPERATION INFORMATIONS JOUEUR VIA ID
	 */
	@GetMapping("/informationJoueurById")
	public JoueurInfoMinimaleDto informationJoueurById(@RequestParam("id") Integer id) {
		return this.joueurService.informationJoueurById(id);
	}

	/**
	 * MODIFICATION INFORMATIONS DU JOUEUR
	 */
	@PutMapping("/modifierInformationsJoueur")
	public Joueur modifierInformationsJoueur(@RequestBody @Valid ModificationJoueurDto modificationJoueurDto) {
		return this.joueurService.modifierInformationsJoueur(modificationJoueurDto);
	}

	/**
	 * RECAPITULATIF DES INFORMATIONS RESSOURCE DU JOUEUR
	 */
	@GetMapping("/informationRessourcesJoueur")
	public InformationRessourcesJoueur informationRessourcesJoueur() {
		return this.joueurService.informationRessourcesJoueur();
	}

	/**
	 * ATTRIBUTION DES RESSOURCES
	 */
	@PostMapping("/attributionRessources")
	public GainRessourceDto attributionRessources(@RequestBody @Valid GainRessourceDto gainRessourceDto) {
		return this.joueurService.attributionRessources(gainRessourceDto);
	}

	/**
	 * MODIFICATION D'UN JOUEUR (Menu administrateur, Via ID)
	 */
	@PutMapping("/administrationModificationJoueur")
	public JoueurDto administrationModificationJoueur(@RequestBody @Valid JoueurDto joueurDto,
			@RequestParam("id") Integer id) {
		return this.joueurService.administrationModificationJoueur(joueurDto, id);
	}

	/**
	 * ECHANGE DE RESSOURCES (Via marché)
	 */
	@PostMapping("/echangeRessource")
	public EchangeRessourceDto echangeRessource(@RequestBody @Valid EchangeRessourceDto echangeRessourceDto) {
		return this.joueurService.echangeRessource(echangeRessourceDto);
	}

}
