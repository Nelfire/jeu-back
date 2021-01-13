package dev.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.controller.dto.BatimentDto;
import dev.controller.dto.BatimentJoueurCreationDto;
import dev.controller.dto.BatimentJoueurDto;
import dev.entites.Joueur;
import dev.entites.batiment.Batiment;
import dev.entites.joueur.BatimentJoueur;
import dev.exceptions.BatimentJoueurNonRecupereException;
import dev.exceptions.JoueurAuthentifieNonRecupereException;
import dev.exceptions.RessourceManquanteException;
import dev.repository.JoueurRepo;
import dev.repository.batiment.BatimentRepo;
import dev.repository.joueur.BatimentJoueurRepo;
import dev.services.JoueurService;

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
	
	public List<BatimentJoueurDto> listerMesBatiments(Integer idJoueur) {
		
		List<BatimentJoueurDto> listeMesBatiments = new ArrayList<>();
		for (BatimentJoueur batiment : batimentJoueurRepo.findByJoueurId(idJoueur)) {
			BatimentJoueurDto batimentJoueurDto = new BatimentJoueurDto(batiment.getId(), batiment.getJoueur(), batiment.getBatiment(),batiment.getNiveau(),batiment.getNombreExploitantsActif(), batiment.getDateDebutConstruction(), batiment.getDateFinConstruction());
			listeMesBatiments.add(batimentJoueurDto);	
		}
		return listeMesBatiments;
	}
	
	public BatimentJoueurDto rechercheBatimentJoueur(Integer idBatiment) {
		
		// Récupération du joueur connecté.
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
		return batimentJoueurDto;
		
	}


	
	public BatimentJoueurDto rechercheBatimentJoueurParId(Integer id) {
		BatimentJoueur batimentJoueur = batimentJoueurRepo.findById(id).orElseThrow(() -> new BatimentJoueurNonRecupereException("Le joueur authentifié n'a pas pu être récupéré"));
		
		BatimentJoueurDto bat = new BatimentJoueurDto(id,batimentJoueur.getJoueur(),batimentJoueur.getBatiment(),batimentJoueur.getNiveau(),batimentJoueur.getNombreExploitantsActif(), batimentJoueur.getDateDebutConstruction(), batimentJoueur.getDateFinConstruction());
	
		return bat;
	}
	
	/**
	 * CREATION D'UN BATIMENT JOUEUR (Construction)
	 */
	public BatimentJoueurCreationDto creationBatimentJoueur(BatimentJoueurCreationDto batimentJoueurCreationDto) {
		Integer quantiteePierreManquante;
		Integer quantiteeBoisManquant;
		Integer quantiteeOrManquant;
		Integer quantiteeNourritureManquante;
		// Récupération du joueur connecté.
		Joueur jou = joueurService.recuperationJoueur();
		
		// Recherche du batiment correspondant à la création
		Batiment batiment = batimentRepo.findByIdTypeBatiment(batimentJoueurCreationDto.getIdBatiment());
		System.out.println(batiment.toString());
		// Création de la ligne batimentJoueur
		// Retrait ressource

		// -------- /!\ TESTES A FAIRE : -------- 
		// - SI RESSOURCES INSUFFISANTES 
		// -- Pierre manquante :
		if(jou.getPierrePossession() < batiment.getCoutPierreConstruction()) {
			quantiteePierreManquante = batiment.getCoutPierreConstruction()-jou.getPierrePossession();
			throw new RessourceManquanteException("Il vous manque "+quantiteePierreManquante+" de pierre pour construire ce bâtiment.");
		}		
		// -- Bois manquant :
		else if(jou.getBoisPossession() < batiment.getCoutBoisConstruction()) {
			quantiteeBoisManquant = batiment.getCoutBoisConstruction()-jou.getBoisPossession();
			throw new RessourceManquanteException("Il vous manque "+quantiteeBoisManquant+" de bois pour construire ce bâtiment.");
		}
		// -- Or manquant :
		else if(jou.getOrPossession() < batiment.getCoutOrConstruction()) {
			quantiteeOrManquant = batiment.getCoutOrConstruction()-jou.getOrPossession();
			throw new RessourceManquanteException("Il vous manque "+quantiteeOrManquant+" d'or pour construire ce bâtiment.");
		}
		// -- Nourriture manquante :
		else if(jou.getNourriturePossession() < batiment.getCoutNourritureConstruction()) {
			quantiteeNourritureManquante = batiment.getCoutNourritureConstruction()-jou.getNourriturePossession();
			throw new RessourceManquanteException("Il vous manque "+quantiteeNourritureManquante+" de nourriture pour construire ce bâtiment.");
		}
		// - SI OUVRIERS SUFFISANTS 
		// - SI LVL HDV SUFFISANTS 
		jou.setPierrePossession(jou.getPierrePossession()-batiment.getCoutPierreConstruction());
		jou.setBoisPossession(jou.getBoisPossession()-batiment.getCoutBoisConstruction());
		jou.setOrPossession(jou.getOrPossession()-batiment.getCoutOrConstruction());
		jou.setNourriturePossession(jou.getNourriturePossession()-batiment.getCoutNourritureConstruction());
		
		// -- Temps d'amélioration
		// -- Temps d'amélioration
		long debut = new Date().getTime();
		long fin = new Date().getTime()+(batiment.getTempsDeConstruction()*1000);

		System.out.println(debut);
		System.out.println(fin);
		
		Joueur joueur = new Joueur(jou.getArmee(),jou.getIcone(),jou.getPseudo(),jou.getEmail(),jou.getMotDePasse(),jou.getDescriptif(),jou.getNiveau(),jou.getExperience(),jou.getPierrePossession(),jou.getBoisPossession(),jou.getOrPossession(),jou.getNourriturePossession(),jou.getGemmePossession(),jou.getPierreMaximum(),jou.getBoisMaximum(),jou.getOrMaximum(),jou.getNourritureMaximum(),jou.getPierreBoostProduction(),jou.getBoisBoostProduction(),jou.getOrBoostProduction(),jou.getNourritureBoostProduction(),jou.getTempsDeJeu(),jou.getRoles());
		joueur.setId(jou.getId());
		BatimentJoueur batimentJoueur = new BatimentJoueur(jou,batiment,1,0,debut,fin);
		
		jou.setPierreMaximum(jou.getPierreMaximum()+batiment.getQuantiteeStockagePierre());
		jou.setBoisMaximum(jou.getBoisMaximum()+batiment.getQuantiteeStockageBois());
		jou.setOrMaximum(jou.getOrMaximum()+batiment.getQuantiteeStockageOre());
		jou.setNourritureMaximum(jou.getNourritureMaximum()+batiment.getQuantiteeStockageNourriture());
		
		// Sauvegarde 
		this.batimentJoueurRepo.save(batimentJoueur);
		this.joueurRepo.save(jou);
		System.out.println(batimentJoueur.toString());
		// Return
		return new BatimentJoueurCreationDto(batimentJoueur.getBatiment().getIdTypeBatiment());
	}
	
	
	
	
	/**
	 * MODIFICATION D'UN BATIMENT JOUEUR (Amélioration)
	 */
	public BatimentJoueurDto putBatimentJoueur(@Valid BatimentJoueurDto shelb, Integer id) {
		Integer quantiteePierreManquante;
		Integer quantiteeBoisManquant;
		Integer quantiteeOrManquant;
		Integer quantiteeNourritureManquante;
		// Récupération du joueur connecté.
		Joueur jou = joueurService.recuperationJoueur();
		
		BatimentJoueurDto batimentJoueurDto = this.rechercheBatimentJoueurParId(id);
		batimentJoueurDto.setNiveau(batimentJoueurDto.getNiveau()+1);
		batimentJoueurDto.setCoutBoisAmelioration(batimentJoueurDto.getCoutBoisAmelioration());
		
		BatimentJoueur batimentJoueur = new BatimentJoueur(batimentJoueurDto.getJoueur(),
				batimentJoueurDto.getBatiment(),
				batimentJoueurDto.getNiveau(),
				batimentJoueurDto.getNombreExploitantsActif(),
				batimentJoueurDto.getDateDebutConstruction(),
				batimentJoueurDto.getDateFinConstruction());
		batimentJoueur.setId(batimentJoueurDto.getId());
		// -- Temps d'amélioration
		long debut = new Date().getTime();
		long fin = new Date().getTime()+(batimentJoueurDto.getTempsAmelioration()*1000);
		// -- Détermine la date de fin de l'amélioration
//		fin.setSeconds(fin.getSeconds()+batimentJoueurDto.getTempsAmelioration());
		batimentJoueur.setDateDebutConstruction(debut);
		batimentJoueur.setDateFinConstruction(fin);
		
		// - SI RESSOURCES SUFFISANTES 
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
		
		jou.setPierrePossession(jou.getPierrePossession()-batimentJoueurDto.getCoutPierreAmelioration());
		jou.setBoisPossession(jou.getBoisPossession()-batimentJoueurDto.getCoutBoisAmelioration());
		jou.setOrPossession(jou.getOrPossession()-batimentJoueurDto.getCoutOreAmelioration());
		jou.setNourriturePossession(jou.getNourriturePossession()-batimentJoueurDto.getCoutNourritureAmelioration());

		jou.setPierreMaximum(jou.getPierreMaximum()+batimentJoueurDto.getQuantiteeStockagePierre());
		jou.setBoisMaximum(jou.getBoisMaximum()+batimentJoueurDto.getQuantiteeStockageBois());
		jou.setOrMaximum(jou.getOrMaximum()+batimentJoueurDto.getQuantiteeStockageOre());
		jou.setNourritureMaximum(jou.getNourritureMaximum()+batimentJoueurDto.getQuantiteeStockageNourriture());
		
		Joueur joueur = new Joueur(jou.getArmee(),jou.getIcone(),jou.getPseudo(),jou.getEmail(),jou.getMotDePasse(),jou.getDescriptif(),jou.getNiveau(),jou.getExperience(),jou.getPierrePossession(),jou.getBoisPossession(),jou.getOrPossession(),jou.getNourriturePossession(),jou.getGemmePossession(),jou.getPierreMaximum(),jou.getBoisMaximum(),jou.getOrMaximum(),jou.getNourritureMaximum(),jou.getPierreBoostProduction(),jou.getBoisBoostProduction(),jou.getOrBoostProduction(),jou.getNourritureBoostProduction(),jou.getTempsDeJeu(),jou.getRoles());
		joueur.setId(jou.getId());

		System.out.println(debut);
		System.out.println(fin);
		System.out.println(batimentJoueur.toString());
		this.joueurRepo.save(joueur);
		this.batimentJoueurRepo.save(batimentJoueur);
		return batimentJoueurDto;
	}
	
	public Integer RecherchePopulationMaximaleJoueur() {
		Integer populationMaximaleJoueur = 0;
		Joueur jou = joueurService.recuperationJoueur();
		System.out.println("Coucou"+populationMaximaleJoueur);
		List<BatimentJoueur> batimentsJoueur = batimentJoueurRepo.findByJoueurId(jou.getId());
		for (BatimentJoueur batimentJoueur : batimentsJoueur) {
			if(batimentJoueur.getBatiment().getIdTypeBatiment()==1 || batimentJoueur.getBatiment().getIdTypeBatiment()==2) {
				populationMaximaleJoueur = populationMaximaleJoueur + batimentJoueur.getApportPopulation();
			}
		}

		System.out.println("Coucou"+populationMaximaleJoueur);
		return populationMaximaleJoueur;
	}
	
	
}
