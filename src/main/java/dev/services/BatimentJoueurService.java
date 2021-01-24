package dev.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Service;
import dev.controller.dto.BatimentJoueurCreationDto;
import dev.controller.dto.BatimentJoueurDto;
import dev.entites.Joueur;
import dev.entites.batiment.Batiment;
import dev.entites.joueur.BatimentJoueur;
import dev.exceptions.BatimentJoueurNonRecupereException;
import dev.exceptions.RessourceManquanteException;
import dev.repository.JoueurRepo;
import dev.repository.batiment.BatimentRepo;
import dev.repository.joueur.BatimentJoueurRepo;

/*
 * Dans creationBatimentJoueur, prendre en compte le cas ou "Lvl batiment insufisant" (Je crois)
 */
@Service
public class BatimentJoueurService {

	private BatimentJoueurRepo batimentJoueurRepo;
	private BatimentRepo batimentRepo;
	private JoueurRepo joueurRepo;
	private JoueurService joueurService;

	/**
	 * @param batimentJoueurRepo
	 */
	public BatimentJoueurService(BatimentJoueurRepo batimentJoueurRepo, BatimentRepo batimentRepo, JoueurRepo joueurRepo, JoueurService joueurService) {
		this.batimentJoueurRepo = batimentJoueurRepo;
		this.batimentRepo = batimentRepo;
		this.joueurRepo = joueurRepo;
		this.joueurService = joueurService;
	}
	
	/**
	 * LISTAGE DE TOUS LES BATIMENTS QUE POSSEDE LE JOUEUR
	 */
	public List<BatimentJoueurDto> listerMesBatiments() {
		// RÉCUPÉRATION DU JOUEUR CONNECTÉ
		Joueur jou = joueurService.recuperationJoueur();
		
		List<BatimentJoueurDto> listeMesBatiments = new ArrayList<>();
		for (BatimentJoueur batiment : batimentJoueurRepo.findByJoueurId(jou.getId())) {
			BatimentJoueurDto batimentJoueurDto = new BatimentJoueurDto(batiment.getId(), batiment.getJoueur(), batiment.getBatiment(),batiment.getNiveau(),batiment.getNombreExploitantsActif(), batiment.getDateDebutConstruction(), batiment.getDateFinConstruction());
			listeMesBatiments.add(batimentJoueurDto);	
		}
		return listeMesBatiments;
	}
	
	/**
	 * DETAILS D'UN BATIMENT JOUEUR (Via ID)
	 */
	public BatimentJoueurDto rechercheBatimentJoueur(Integer idBatiment) {
		// RÉCUPÉRATION DU JOUEUR CONNECTÉ.
		Joueur jou = joueurService.recuperationJoueur();
		
		BatimentJoueurDto batimentJoueurDto = new BatimentJoueurDto();
		for (BatimentJoueur batiment : batimentJoueurRepo.findByJoueurId(jou.getId())) {
			if(batiment.getBatiment().getIdTypeBatiment() == idBatiment) 
			{
				batimentJoueurDto.setId(batiment.getId());
				batimentJoueurDto.setJoueur(batiment.getJoueur());
				batimentJoueurDto.setBatiment(batiment.getBatiment());
				batimentJoueurDto.setNiveau(batiment.getNiveau());
				batimentJoueurDto.setOuvrierNecessaireAmelioration(batiment.getOuvrierNecessaireAmelioration());
				batimentJoueurDto.setTempsAmelioration(batiment.getTempsAmelioration());
				batimentJoueurDto.setCoutPierreAmelioration(batiment.getCoutPierreAmelioration());
				batimentJoueurDto.setCoutBoisAmelioration(batiment.getCoutBoisAmelioration());
				batimentJoueurDto.setCoutOreAmelioration(batiment.getCoutOreAmelioration());
				batimentJoueurDto.setCoutNourritureAmelioration(batiment.getCoutNourritureAmelioration());
				batimentJoueurDto.setQuantiteeStockagePierre(batiment.getQuantiteeStockagePierre());
				batimentJoueurDto.setQuantiteeStockageBois(batiment.getQuantiteeStockageBois());
				batimentJoueurDto.setQuantiteeStockageOre(batiment.getQuantiteeStockageOre());
				batimentJoueurDto.setQuantiteeStockageNourriture(batiment.getQuantiteeStockageNourriture());
				batimentJoueurDto.setNombreExploitantsAutorise(batiment.getNombreExploitantsAutorise());
				batimentJoueurDto.setNombreExploitantsActif(batiment.getNombreExploitantsActif());
				batimentJoueurDto.setApportPierreHeure(batiment.getApportPierreHeure());
				batimentJoueurDto.setApportBoisHeure(batiment.getApportBoisHeure());
				batimentJoueurDto.setApportOreHeure(batiment.getApportOreHeure());
				batimentJoueurDto.setApportNourritureHeure(batiment.getApportNourritureHeure());
				batimentJoueurDto.setDateDebutConstruction(batiment.getDateDebutConstruction());
				batimentJoueurDto.setDateFinConstruction(batiment.getDateFinConstruction());
			}
		}
		
		//RETOUR
		return batimentJoueurDto;
	}

	/**
	 * RECUPERATION DONNES D'UN BATIMENT (Via ID) : Utilisé dans "putBatimentJoueur"
	 */
	public BatimentJoueurDto rechercheBatimentJoueurParId(Integer id) {
		BatimentJoueur batimentJoueur = batimentJoueurRepo.findById(id).orElseThrow(() -> new BatimentJoueurNonRecupereException("Le bâtiment n'a pas pu être récupéré"));
		BatimentJoueurDto bat = new BatimentJoueurDto(id,batimentJoueur.getJoueur(),batimentJoueur.getBatiment(),batimentJoueur.getNiveau(),batimentJoueur.getNombreExploitantsActif(), batimentJoueur.getDateDebutConstruction(), batimentJoueur.getDateFinConstruction());
		
		// RETOUR
		return bat;
	}
	
	/**
	 * CREATION D'UN NOUVEAU BATIMENT JOUEUR (Construction)
	 */
	public BatimentJoueurCreationDto creationBatimentJoueur(BatimentJoueurCreationDto batimentJoueurCreationDto) {
		// RÉCUPÉRATION DU JOUEUR CONNECTÉ.
		Joueur jou = joueurService.recuperationJoueur();
		
		// RECHERCHE DU BATIMENT CORRESPONDANT À LA CRÉATION
		Batiment batiment = batimentRepo.findByIdTypeBatiment(batimentJoueurCreationDto.getIdBatiment());
		
		// INITIALISATIONS
		Integer quantiteePierreManquante;
		Integer quantiteeBoisManquant;
		Integer quantiteeOrManquant;
		Integer quantiteeNourritureManquante;
		long debut = new Date().getTime();
		long fin = new Date().getTime()+(batiment.getTempsDeConstruction()*1000);

		// SI RESSOURCES INSUFFISANTES 
		// - Pierre manquante :
		if(jou.getPierrePossession() < batiment.getCoutPierreConstruction()) {
			quantiteePierreManquante = batiment.getCoutPierreConstruction()-jou.getPierrePossession();
			throw new RessourceManquanteException("Il vous manque "+quantiteePierreManquante+" de pierre pour construire ce bâtiment.");
		}		
		// - Bois manquant :
		else if(jou.getBoisPossession() < batiment.getCoutBoisConstruction()) {
			quantiteeBoisManquant = batiment.getCoutBoisConstruction()-jou.getBoisPossession();
			throw new RessourceManquanteException("Il vous manque "+quantiteeBoisManquant+" de bois pour construire ce bâtiment.");
		}
		// - Or manquant :
		else if(jou.getOrPossession() < batiment.getCoutOrConstruction()) {
			quantiteeOrManquant = batiment.getCoutOrConstruction()-jou.getOrPossession();
			throw new RessourceManquanteException("Il vous manque "+quantiteeOrManquant+" d'or pour construire ce bâtiment.");
		}
		// - Nourriture manquante :
		else if(jou.getNourriturePossession() < batiment.getCoutNourritureConstruction()) {
			quantiteeNourritureManquante = batiment.getCoutNourritureConstruction()-jou.getNourriturePossession();
			throw new RessourceManquanteException("Il vous manque "+quantiteeNourritureManquante+" de nourriture pour construire ce bâtiment.");
		}
		
		// - SI OUVRIERS SUFFISANTS 
		// - SI LVL HDV SUFFISANTS 
		// RETRAIT DES RESSOURCES AU JOUEUR
		jou.setPierrePossession(jou.getPierrePossession()-batiment.getCoutPierreConstruction());
		jou.setBoisPossession(jou.getBoisPossession()-batiment.getCoutBoisConstruction());
		jou.setOrPossession(jou.getOrPossession()-batiment.getCoutOrConstruction());
		jou.setNourriturePossession(jou.getNourriturePossession()-batiment.getCoutNourritureConstruction());
		
		// MISE A JOUR DU JOUEUR
		Joueur joueur = new Joueur(jou.getArmee(),jou.getIcone(),jou.getPseudo(),jou.getEmail(),jou.getMotDePasse(),jou.getDescriptif(),jou.getNiveau(),jou.getExperience(),jou.getPierrePossession(),jou.getBoisPossession(),jou.getOrPossession(),jou.getNourriturePossession(),jou.getGemmePossession(),jou.getPierreMaximum(),jou.getBoisMaximum(),jou.getOrMaximum(),jou.getNourritureMaximum(),jou.getPierreBoostProduction(),jou.getBoisBoostProduction(),jou.getOrBoostProduction(),jou.getNourritureBoostProduction(),jou.getTempsDeJeu(),jou.getRoles());
		joueur.setId(jou.getId());
		jou.setPierreMaximum(jou.getPierreMaximum()+batiment.getQuantiteeStockagePierre());
		jou.setBoisMaximum(jou.getBoisMaximum()+batiment.getQuantiteeStockageBois());
		jou.setOrMaximum(jou.getOrMaximum()+batiment.getQuantiteeStockageOre());
		jou.setNourritureMaximum(jou.getNourritureMaximum()+batiment.getQuantiteeStockageNourriture());
		
		// MISE A JOUR DE BATIMENT JOUEUR
		BatimentJoueur batimentJoueur = new BatimentJoueur(jou,batiment,1,0,debut,fin);
		
		System.out.println(batimentJoueur.toString());
		// SAUVEGARDES
		this.batimentJoueurRepo.save(batimentJoueur);
		this.joueurRepo.save(jou);
		
		// RETOUR
		return new BatimentJoueurCreationDto(batimentJoueur.getBatiment().getIdTypeBatiment());
	}
	
	/**
	 * MODIFICATION D'UN BATIMENT JOUEUR (Amélioration)
	 */
	public BatimentJoueurDto putBatimentJoueur(@Valid BatimentJoueurDto batt, Integer id) {
		// RÉCUPÉRATION DU JOUEUR CONNECTÉ.
		Joueur jou = joueurService.recuperationJoueur();
		
		// RECUPERATION DU BATIMENT JOUEUR CONCERNÉ PAR L'AMELIORATION
		BatimentJoueurDto batimentJoueurDto = this.rechercheBatimentJoueurParId(id);
		batimentJoueurDto.setNiveau(batimentJoueurDto.getNiveau()+1);
		batimentJoueurDto.setCoutBoisAmelioration(batimentJoueurDto.getCoutBoisAmelioration());
		
		// INITIALISATIONS
		Integer quantiteePierreManquante;
		Integer quantiteeBoisManquant;
		Integer quantiteeOrManquant;
		Integer quantiteeNourritureManquante;
		// - Détermine la date de fin de l'amélioration
		long debut = new Date().getTime();
		long fin = new Date().getTime()+(batimentJoueurDto.getTempsAmelioration()*1000);

		BatimentJoueur batimentJoueur = new BatimentJoueur(batimentJoueurDto.getJoueur(),
				batimentJoueurDto.getBatiment(),
				batimentJoueurDto.getNiveau(),
				batimentJoueurDto.getNombreExploitantsActif(),
				batimentJoueurDto.getDateDebutConstruction(),
				batimentJoueurDto.getDateFinConstruction());
		batimentJoueur.setId(batimentJoueurDto.getId());
		batimentJoueur.setDateDebutConstruction(debut);
		batimentJoueur.setDateFinConstruction(fin);
		
		// - SI RESSOURCES SUFFISANTES : EXCEPTION
		// -- Pierre manquante :
		if(jou.getPierrePossession() < batimentJoueurDto.getCoutPierreAmelioration()) {
			quantiteePierreManquante = batimentJoueurDto.getCoutPierreAmelioration()-jou.getPierrePossession();
			throw new RessourceManquanteException("Il vous manque "+quantiteePierreManquante+" de pierre pour améliorer ce bâtiment.");
		}		
		// -- Bois manquant :
		else if(jou.getBoisPossession() < batimentJoueurDto.getCoutBoisAmelioration()) {
			quantiteeBoisManquant = batimentJoueurDto.getCoutBoisAmelioration()-jou.getBoisPossession();
			throw new RessourceManquanteException("Il vous manque "+quantiteeBoisManquant+" de bois pour améliorer ce bâtiment.");
		}
		// -- Or manquant :
		else if(jou.getOrPossession() < batimentJoueurDto.getCoutOreAmelioration()) {
			quantiteeOrManquant = batimentJoueurDto.getCoutOreAmelioration()-jou.getOrPossession();
			throw new RessourceManquanteException("Il vous manque "+quantiteeOrManquant+" d'or pour améliorer ce bâtiment.");
		}
		// -- Nourriture manquante :
		else if(jou.getNourriturePossession() < batimentJoueurDto.getCoutNourritureAmelioration()) {
			quantiteeNourritureManquante = batimentJoueurDto.getCoutNourritureAmelioration()-jou.getNourriturePossession();
			throw new RessourceManquanteException("Il vous manque "+quantiteeNourritureManquante+" de nourriture pour améliorer ce bâtiment.");
		}
		
		// MISE A JOUR DU JOUEUR 
		// - Retrait ressources
		jou.setPierrePossession(jou.getPierrePossession()-batimentJoueurDto.getCoutPierreAmelioration());
		jou.setBoisPossession(jou.getBoisPossession()-batimentJoueurDto.getCoutBoisAmelioration());
		jou.setOrPossession(jou.getOrPossession()-batimentJoueurDto.getCoutOreAmelioration());
		jou.setNourriturePossession(jou.getNourriturePossession()-batimentJoueurDto.getCoutNourritureAmelioration());
		// - Augmentation limite
		jou.setPierreMaximum(jou.getPierreMaximum()+batimentJoueurDto.getQuantiteeStockagePierre());
		jou.setBoisMaximum(jou.getBoisMaximum()+batimentJoueurDto.getQuantiteeStockageBois());
		jou.setOrMaximum(jou.getOrMaximum()+batimentJoueurDto.getQuantiteeStockageOre());
		jou.setNourritureMaximum(jou.getNourritureMaximum()+batimentJoueurDto.getQuantiteeStockageNourriture());
		
		Joueur joueur = new Joueur(jou.getArmee(),jou.getIcone(),jou.getPseudo(),jou.getEmail(),jou.getMotDePasse(),jou.getDescriptif(),jou.getNiveau(),jou.getExperience(),jou.getPierrePossession(),jou.getBoisPossession(),jou.getOrPossession(),jou.getNourriturePossession(),jou.getGemmePossession(),jou.getPierreMaximum(),jou.getBoisMaximum(),jou.getOrMaximum(),jou.getNourritureMaximum(),jou.getPierreBoostProduction(),jou.getBoisBoostProduction(),jou.getOrBoostProduction(),jou.getNourritureBoostProduction(),jou.getTempsDeJeu(),jou.getRoles());
		joueur.setId(jou.getId());

		// SAUVEGARDES
		this.joueurRepo.save(joueur);
		this.batimentJoueurRepo.save(batimentJoueur);
		
		// RETOUR
		return batimentJoueurDto;
	}
	
	/**
	 * RECHERCHE POPULATION MAXIMALE DU JOUEUR
	 */
	public Integer RecherchePopulationMaximaleJoueur() {
		// INITIALISATION
		Integer populationMaximaleJoueur = 0;
		
		Joueur jou = joueurService.recuperationJoueur();
		List<BatimentJoueur> batimentsJoueur = batimentJoueurRepo.findByJoueurId(jou.getId());
		for (BatimentJoueur batimentJoueur : batimentsJoueur) {
			if(batimentJoueur.getBatiment().getIdTypeBatiment()==1 || batimentJoueur.getBatiment().getIdTypeBatiment()==2) {
				populationMaximaleJoueur = populationMaximaleJoueur + batimentJoueur.getApportPopulation();
			}
		}
		
		// RETOUR
		return populationMaximaleJoueur;
	}
	
	
}
