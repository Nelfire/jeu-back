package dev.services.batiment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Service;

import dev.controller.dto.batiment.BatimentJoueurCreationDto;
import dev.controller.dto.batiment.BatimentJoueurDto;
import dev.entites.batiment.Batiment;
import dev.entites.batiment.BatimentJoueur;
import dev.entites.joueur.Joueur;
import dev.exceptions.BatimentJoueurNonRecupereException;
import dev.exceptions.RessourceManquanteException;
import dev.repository.JoueurRepo;
import dev.repository.batiment.BatimentRepo;
import dev.repository.joueur.BatimentJoueurRepo;
import dev.services.joueur.JoueurService;

@Service
public class BatimentJoueurService {

	private BatimentJoueurRepo batimentJoueurRepo;
	private BatimentRepo batimentRepo;
	private JoueurRepo joueurRepo;
	private JoueurService joueurService;

	/**
	 * @param batimentJoueurRepo
	 * @param batimentRepo
	 * @param joueurRepo
	 * @param joueurService
	 */
	public BatimentJoueurService(BatimentJoueurRepo batimentJoueurRepo, BatimentRepo batimentRepo,
			JoueurRepo joueurRepo, JoueurService joueurService) {
		this.batimentJoueurRepo = batimentJoueurRepo;
		this.batimentRepo = batimentRepo;
		this.joueurRepo = joueurRepo;
		this.joueurService = joueurService;
	}

	/**
	 * LISTAGE DE TOUS LES BATIMENTS QUE POSSEDE LE JOUEUR
	 */
	public List<BatimentJoueurDto> listerMesBatiments() {

		// INITIALISATIONS
		List<BatimentJoueurDto> listeMesBatiments = new ArrayList<>();

		// RÉCUPÉRATION DU JOUEUR CONNECTÉ
		Joueur jou = joueurService.recuperationJoueur();

		// RECHERCHE BATIMENT JOUEUR
		for (BatimentJoueur batiment : batimentJoueurRepo.findByJoueurId(jou.getId())) {
			BatimentJoueurDto batimentJoueurDto = new BatimentJoueurDto(batiment.getId(), batiment.getJoueur(),
					batiment.getBatiment(), batiment.getNiveau(), batiment.getOuvrierNecessaireAmelioration(),
					batiment.getTempsAmelioration(), batiment.getCoutPierreAmelioration(),
					batiment.getCoutBoisAmelioration(), batiment.getCoutOreAmelioration(),
					batiment.getCoutNourritureAmelioration(), batiment.getQuantiteeStockagePierre(),
					batiment.getQuantiteeStockageBois(), batiment.getQuantiteeStockageOre(),
					batiment.getQuantiteeStockageNourriture(), batiment.getApportPierreHeure(),
					batiment.getApportBoisHeure(), batiment.getApportOreHeure(), batiment.getApportNourritureHeure(),
					batiment.getDateDebutConstruction(), batiment.getDateFinConstruction());

			// AJOUT TABLEAU
			listeMesBatiments.add(batimentJoueurDto);
		}

		// RETOUR
		return listeMesBatiments;
	}

	/**
	 * DETAILS D'UN BATIMENT JOUEUR (Via ID)
	 */
	public BatimentJoueurDto rechercheBatimentJoueur(Integer idBatiment) {

		// INITIALISATIONS
		BatimentJoueurDto batimentJoueurDto = new BatimentJoueurDto();

		// RÉCUPÉRATION DU JOUEUR CONNECTÉ.
		Joueur jou = joueurService.recuperationJoueur();

		for (BatimentJoueur batiment : batimentJoueurRepo.findByJoueurId(jou.getId())) {
			if (batiment.getBatiment().getIdTypeBatiment() == idBatiment) {
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
				batimentJoueurDto.setApportPierreHeure(batiment.getApportPierreHeure());
				batimentJoueurDto.setApportBoisHeure(batiment.getApportBoisHeure());
				batimentJoueurDto.setApportOreHeure(batiment.getApportOreHeure());
				batimentJoueurDto.setApportNourritureHeure(batiment.getApportNourritureHeure());
				batimentJoueurDto.setDateDebutConstruction(batiment.getDateDebutConstruction());
				batimentJoueurDto.setDateFinConstruction(batiment.getDateFinConstruction());
			}
		}

		// RETOUR
		return batimentJoueurDto;
	}

	/**
	 * RECUPERATION DONNES D'UN BATIMENT (Via ID) : Utilisé dans "putBatimentJoueur"
	 */
	public BatimentJoueurDto rechercheBatimentJoueurParId(Integer id) {

		// RECHERCHE BATIMENT JOUEUR
		BatimentJoueur batimentJoueur = batimentJoueurRepo.findById(id)
				.orElseThrow(() -> new BatimentJoueurNonRecupereException("Le bâtiment n'a pas pu être récupéré"));

		BatimentJoueurDto bat = new BatimentJoueurDto(id, batimentJoueur.getJoueur(), batimentJoueur.getBatiment(),
				batimentJoueur.getNiveau(), batimentJoueur.getOuvrierNecessaireAmelioration(),
				batimentJoueur.getTempsAmelioration(), batimentJoueur.getCoutPierreAmelioration(),
				batimentJoueur.getCoutBoisAmelioration(), batimentJoueur.getCoutOreAmelioration(),
				batimentJoueur.getCoutNourritureAmelioration(), batimentJoueur.getQuantiteeStockagePierre(),
				batimentJoueur.getQuantiteeStockageBois(), batimentJoueur.getQuantiteeStockageOre(),
				batimentJoueur.getQuantiteeStockageNourriture(), batimentJoueur.getApportPierreHeure(),
				batimentJoueur.getApportBoisHeure(), batimentJoueur.getApportOreHeure(),
				batimentJoueur.getApportNourritureHeure(), batimentJoueur.getDateDebutConstruction(),
				batimentJoueur.getDateFinConstruction());

		// RETOUR
		return bat;
	}

	/**
	 * CREATION D'UN NOUVEAU BATIMENT JOUEUR (Construction)
	 */
	public BatimentJoueurCreationDto creationBatimentJoueur(BatimentJoueurCreationDto batimentJoueurCreationDto) {
		this.joueurService.getInfoJoueur();

		// RÉCUPÉRATION DU JOUEUR CONNECTÉ.
		Joueur jou = joueurService.recuperationJoueur();

		// RECHERCHE DU BATIMENT CORRESPONDANT À LA CRÉATION
		Batiment batiment = batimentRepo.findByIdTypeBatiment(batimentJoueurCreationDto.getIdBatiment());

		// INITIALISATIONS
		Long quantiteePierreManquante;
		Long quantiteeBoisManquant;
		Long quantiteeOrManquant;
		Long quantiteeNourritureManquante;
		long debut = new Date().getTime();
		long fin = new Date().getTime() + (batiment.getTempsDeConstruction() * 1000);

		// SI RESSOURCES INSUFFISANTES
		// - Pierre manquante :
		if (jou.getPierrePossession() < batiment.getCoutPierreConstruction()) {
			quantiteePierreManquante = batiment.getCoutPierreConstruction() - jou.getPierrePossession();
			throw new RessourceManquanteException(
					"Il vous manque " + quantiteePierreManquante + " de pierre pour construire ce bâtiment.");
		}
		// - Bois manquant :
		else if (jou.getBoisPossession() < batiment.getCoutBoisConstruction()) {
			quantiteeBoisManquant = batiment.getCoutBoisConstruction() - jou.getBoisPossession();
			throw new RessourceManquanteException(
					"Il vous manque " + quantiteeBoisManquant + " de bois pour construire ce bâtiment.");
		}
		// - Or manquant :
		else if (jou.getOrPossession() < batiment.getCoutOrConstruction()) {
			quantiteeOrManquant = batiment.getCoutOrConstruction() - jou.getOrPossession();
			throw new RessourceManquanteException(
					"Il vous manque " + quantiteeOrManquant + " d'or pour construire ce bâtiment.");
		}
		// - Nourriture manquante :
		else if (jou.getNourriturePossession() < batiment.getCoutNourritureConstruction()) {
			quantiteeNourritureManquante = batiment.getCoutNourritureConstruction() - jou.getNourriturePossession();
			throw new RessourceManquanteException(
					"Il vous manque " + quantiteeNourritureManquante + " de nourriture pour construire ce bâtiment.");
		}

		// RETRAIT DES RESSOURCES AU JOUEUR
		jou.setPierrePossession(jou.getPierrePossession() - batiment.getCoutPierreConstruction());
		jou.setBoisPossession(jou.getBoisPossession() - batiment.getCoutBoisConstruction());
		jou.setOrPossession(jou.getOrPossession() - batiment.getCoutOrConstruction());
		jou.setNourriturePossession(jou.getNourriturePossession() - batiment.getCoutNourritureConstruction());
		jou.setExperience(jou.getExperience() + batiment.getApportExperience());

		// DETERMINE LE NIVEAU DU JOUEUR EN FONCTION DE SON XP
		Integer niveau = this.joueurService.determinerNiveau(jou.getExperience());
		jou.setNiveau(niveau);

		// MISE A JOUR DU JOUEUR
		Joueur joueur = new Joueur(jou.getArmee(), jou.getIcone(), jou.getPseudo(), jou.getEmail(), jou.getMotDePasse(),
				jou.getDescriptif(), jou.getNiveau(), jou.getExperience(), jou.getPierrePossession(),
				jou.getBoisPossession(), jou.getOrPossession(), jou.getNourriturePossession(), jou.getGemmePossession(),
				jou.getPierreMaximum(), jou.getBoisMaximum(), jou.getOrMaximum(), jou.getNourritureMaximum(),
				jou.getPierreBoostProduction(), jou.getBoisBoostProduction(), jou.getOrBoostProduction(),
				jou.getNourritureBoostProduction(), jou.getTempsDeJeu(), jou.getRoles(), jou.getDerniereConnexion(),
				jou.getDonateur(), jou.getPositionX(), jou.getPositionY());
		joueur.setId(jou.getId());

		// INITIALISATION DONNEES
		Integer ouvrierNecessaireAmelioration = 0;
		Integer tempsAmelioration = 0;
		Long coutPierreAmelioration = 0L;
		Long coutBoisAmelioration = 0L;
		Long coutOreAmelioration = 0L;
		Long coutNourritureAmelioration = 0L;
		Long quantiteeStockagePierre = 0L;
		Long quantiteeStockageBois = 0L;
		Long quantiteeStockageOre = 0L;
		Long quantiteeStockageNourriture = 0L;
		Integer apportPierreHeure = 0;
		Integer apportBoisHeure = 0;
		Integer apportOreHeure = 0;
		Integer apportNourritureHeure = 0;

		/////////////////////////////////////
		///// DEFINIR COUT D'AMELIORATION/////
		/////////////////////////////////////

		ouvrierNecessaireAmelioration = batiment.getOuvrierNecessaireConstruction();
		tempsAmelioration = batiment.getTempsDeConstruction();
		coutPierreAmelioration = batiment.getCoutPierreConstruction();
		coutBoisAmelioration = batiment.getCoutBoisConstruction();
		coutOreAmelioration = batiment.getCoutOrConstruction();
		coutNourritureAmelioration = batiment.getCoutNourritureConstruction();
		quantiteeStockagePierre = batiment.getQuantiteeStockagePierre();
		quantiteeStockageBois = batiment.getQuantiteeStockageBois();
		quantiteeStockageOre = batiment.getQuantiteeStockageOre();
		quantiteeStockageNourriture = batiment.getQuantiteeStockageNourriture();
		apportPierreHeure = batiment.getApportPierreHeure();
		apportBoisHeure = batiment.getApportBoisHeure();
		apportOreHeure = batiment.getApportOreHeure();
		apportNourritureHeure = batiment.getApportNourritureHeure();

		// MISE A JOUR DE BATIMENT JOUEUR
		BatimentJoueur batimentJoueur = new BatimentJoueur(jou, batiment, 1, ouvrierNecessaireAmelioration,
				tempsAmelioration, coutPierreAmelioration, coutBoisAmelioration, coutOreAmelioration,
				coutNourritureAmelioration, quantiteeStockagePierre, quantiteeStockageBois, quantiteeStockageOre,
				quantiteeStockageNourriture, apportPierreHeure, apportBoisHeure, apportOreHeure, apportNourritureHeure,
				debut, fin);

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
		this.joueurService.getInfoJoueur();

		// RÉCUPÉRATION DU JOUEUR CONNECTÉ.
		Joueur jou = joueurService.recuperationJoueur();

		// RECUPERATION DU BATIMENT JOUEUR CONCERNÉ PAR L'AMELIORATION
		BatimentJoueurDto batimentJoueurDto = this.rechercheBatimentJoueurParId(id);
		batimentJoueurDto.setNiveau(batimentJoueurDto.getNiveau() + 1);

		// INITIALISATION DES DONNEES
		Integer ouvrierNecessaireAmelioration = 0;
		Integer tempsAmelioration = 0;
		Long coutPierreAmelioration = 0L;
		Long coutBoisAmelioration = 0L;
		Long coutOreAmelioration = 0L;
		Long coutNourritureAmelioration = 0L;
		Long quantiteeStockagePierre = 0L;
		Long quantiteeStockageBois = 0L;
		Long quantiteeStockageOre = 0L;
		Long quantiteeStockageNourriture = 0L;
		Integer apportPierreHeure = 0;
		Integer apportBoisHeure = 0;
		Integer apportOreHeure = 0;
		Integer apportNourritureHeure = 0;

		/////////////////////////////////////
		///// DEFINIR COUT D'AMELIORATION/////
		/////////////////////////////////////

		ouvrierNecessaireAmelioration = (int) (batimentJoueurDto.getBatiment().getMultiplicateurCout()
				* (batimentJoueurDto.getOuvrierNecessaireAmelioration()));
		tempsAmelioration = (int) (batimentJoueurDto.getBatiment().getMultiplicateurTemps()
				* (batimentJoueurDto.getTempsAmelioration()));
		coutPierreAmelioration = (long) (batimentJoueurDto.getBatiment().getMultiplicateurCout()
				* (batimentJoueurDto.getCoutPierreAmelioration()));
		coutBoisAmelioration = (long) (batimentJoueurDto.getBatiment().getMultiplicateurCout()
				* (batimentJoueurDto.getCoutBoisAmelioration()));
		coutOreAmelioration = (long) (batimentJoueurDto.getBatiment().getMultiplicateurCout()
				* (batimentJoueurDto.getCoutOreAmelioration()));
		coutNourritureAmelioration = (long) (batimentJoueurDto.getBatiment().getMultiplicateurCout()
				* (batimentJoueurDto.getCoutNourritureAmelioration()));
		quantiteeStockagePierre = (long) (batimentJoueurDto.getBatiment().getMultiplicateurApport()
				* (batimentJoueurDto.getQuantiteeStockagePierre()));
		quantiteeStockageBois = (long) (batimentJoueurDto.getBatiment().getMultiplicateurApport()
				* (batimentJoueurDto.getQuantiteeStockageBois()));
		quantiteeStockageOre = (long) (batimentJoueurDto.getBatiment().getMultiplicateurApport()
				* (batimentJoueurDto.getQuantiteeStockageOre()));
		quantiteeStockageNourriture = (long) (batimentJoueurDto.getBatiment().getMultiplicateurApport()
				* (batimentJoueurDto.getQuantiteeStockageNourriture()));
		apportPierreHeure = (int) (batimentJoueurDto.getBatiment().getMultiplicateurApport()
				* (batimentJoueurDto.getApportPierreHeure()));
		apportBoisHeure = (int) (batimentJoueurDto.getBatiment().getMultiplicateurApport()
				* (batimentJoueurDto.getApportBoisHeure()));
		apportOreHeure = (int) (batimentJoueurDto.getBatiment().getMultiplicateurApport()
				* (batimentJoueurDto.getApportOreHeure()));
		apportNourritureHeure = (int) (batimentJoueurDto.getBatiment().getMultiplicateurApport()
				* (batimentJoueurDto.getApportNourritureHeure()));

		batimentJoueurDto.setOuvrierNecessaireAmelioration(ouvrierNecessaireAmelioration);
		batimentJoueurDto.setTempsAmelioration(tempsAmelioration);
		batimentJoueurDto.setCoutPierreAmelioration(coutPierreAmelioration);
		batimentJoueurDto.setCoutBoisAmelioration(coutBoisAmelioration);
		batimentJoueurDto.setCoutOreAmelioration(coutOreAmelioration);
		batimentJoueurDto.setCoutNourritureAmelioration(coutNourritureAmelioration);
		batimentJoueurDto.setQuantiteeStockagePierre(quantiteeStockagePierre);
		batimentJoueurDto.setQuantiteeStockageBois(quantiteeStockageBois);
		batimentJoueurDto.setQuantiteeStockageOre(quantiteeStockageOre);
		batimentJoueurDto.setQuantiteeStockageNourriture(quantiteeStockageNourriture);
		batimentJoueurDto.setApportPierreHeure(apportPierreHeure);
		batimentJoueurDto.setApportBoisHeure(apportBoisHeure);
		batimentJoueurDto.setApportOreHeure(apportOreHeure);
		batimentJoueurDto.setApportNourritureHeure(apportNourritureHeure);

		// INITIALISATIONS
		Long quantiteePierreManquante;
		Long quantiteeBoisManquant;
		Long quantiteeOrManquant;
		Long quantiteeNourritureManquante;

		// - Détermine la date de fin de l'amélioration
		long debut = new Date().getTime();
		long fin = new Date().getTime() + (batimentJoueurDto.getTempsAmelioration() * 1000);

		BatimentJoueur batimentJoueur = new BatimentJoueur(batimentJoueurDto.getJoueur(),
				batimentJoueurDto.getBatiment(), batimentJoueurDto.getNiveau(),
				batimentJoueurDto.getOuvrierNecessaireAmelioration(), batimentJoueurDto.getTempsAmelioration(),
				batimentJoueurDto.getCoutPierreAmelioration(), batimentJoueurDto.getCoutBoisAmelioration(),
				batimentJoueurDto.getCoutOreAmelioration(), batimentJoueurDto.getCoutNourritureAmelioration(),
				batimentJoueurDto.getQuantiteeStockagePierre(), batimentJoueurDto.getQuantiteeStockageBois(),
				batimentJoueurDto.getQuantiteeStockageOre(), batimentJoueurDto.getQuantiteeStockageNourriture(),
				batimentJoueurDto.getApportPierreHeure(), batimentJoueurDto.getApportBoisHeure(),
				batimentJoueurDto.getApportOreHeure(), batimentJoueurDto.getApportNourritureHeure(),
				batimentJoueurDto.getDateDebutConstruction(), batimentJoueurDto.getDateFinConstruction());
		batimentJoueur.setId(batimentJoueurDto.getId());
		batimentJoueur.setDateDebutConstruction(debut);
		batimentJoueur.setDateFinConstruction(fin);

		// - SI RESSOURCES SUFFISANTES : EXCEPTION
		// -- Pierre manquante :
		if (jou.getPierrePossession() < batimentJoueurDto.getCoutPierreAmelioration()) {
			quantiteePierreManquante = batimentJoueurDto.getCoutPierreAmelioration() - jou.getPierrePossession();
			throw new RessourceManquanteException(
					"Il vous manque " + quantiteePierreManquante + " de pierre pour améliorer ce bâtiment.");
		}
		// -- Bois manquant :
		else if (jou.getBoisPossession() < batimentJoueurDto.getCoutBoisAmelioration()) {
			quantiteeBoisManquant = batimentJoueurDto.getCoutBoisAmelioration() - jou.getBoisPossession();
			throw new RessourceManquanteException(
					"Il vous manque " + quantiteeBoisManquant + " de bois pour améliorer ce bâtiment.");
		}
		// -- Or manquant :
		else if (jou.getOrPossession() < batimentJoueurDto.getCoutOreAmelioration()) {
			quantiteeOrManquant = batimentJoueurDto.getCoutOreAmelioration() - jou.getOrPossession();
			throw new RessourceManquanteException(
					"Il vous manque " + quantiteeOrManquant + " d'or pour améliorer ce bâtiment.");
		}
		// -- Nourriture manquante :
		else if (jou.getNourriturePossession() < batimentJoueurDto.getCoutNourritureAmelioration()) {
			quantiteeNourritureManquante = batimentJoueurDto.getCoutNourritureAmelioration()
					- jou.getNourriturePossession();
			throw new RessourceManquanteException(
					"Il vous manque " + quantiteeNourritureManquante + " de nourriture pour améliorer ce bâtiment.");
		}

		jou.setExperience((long) (jou.getExperience() + (batimentJoueurDto.getBatiment().getApportExperience()
				* (Math.pow(batimentJoueurDto.getBatiment().getMultiplicateurExperience(),
						batimentJoueurDto.getNiveau() - 1)))));

		// DETERMINE LE NIVEAU DU JOUEUR EN FONCTION DE SON XP
		Integer niveau = this.joueurService.determinerNiveau(jou.getExperience());
		jou.setNiveau(niveau);

		// MISE A JOUR DU JOUEUR
		// - Retrait ressources
		jou.setPierrePossession(jou.getPierrePossession() - batimentJoueurDto.getCoutPierreAmelioration());
		jou.setBoisPossession(jou.getBoisPossession() - batimentJoueurDto.getCoutBoisAmelioration());
		jou.setOrPossession(jou.getOrPossession() - batimentJoueurDto.getCoutOreAmelioration());
		jou.setNourriturePossession(jou.getNourriturePossession() - batimentJoueurDto.getCoutNourritureAmelioration());

		Joueur joueur = new Joueur(jou.getArmee(), jou.getIcone(), jou.getPseudo(), jou.getEmail(), jou.getMotDePasse(),
				jou.getDescriptif(), jou.getNiveau(), jou.getExperience(), jou.getPierrePossession(),
				jou.getBoisPossession(), jou.getOrPossession(), jou.getNourriturePossession(), jou.getGemmePossession(),
				jou.getPierreMaximum(), jou.getBoisMaximum(), jou.getOrMaximum(), jou.getNourritureMaximum(),
				jou.getPierreBoostProduction(), jou.getBoisBoostProduction(), jou.getOrBoostProduction(),
				jou.getNourritureBoostProduction(), jou.getTempsDeJeu(), jou.getRoles(), jou.getDerniereConnexion(),
				jou.getDonateur(), jou.getPositionX(), jou.getPositionY());
		joueur.setId(jou.getId());

		// SAUVEGARDES
		this.joueurRepo.save(joueur);
		this.batimentJoueurRepo.save(batimentJoueur);

		// RETOUR
		return batimentJoueurDto;
	}

	/**
	 * ACCELERATION CONSTRUCTION D'UN BATIMENT JOUEUR (Contre gemmes)
	 */
	public BatimentJoueurDto accelerationConstructionBatiment(@Valid BatimentJoueurDto batt, Integer id) {
		this.joueurService.getInfoJoueur();

		// RÉCUPÉRATION DU JOUEUR CONNECTÉ.
		Joueur jou = joueurService.recuperationJoueur();

		// INITIALISATION
		Date now = new Date();
		BatimentJoueurDto batimentJoueurDto = this.rechercheBatimentJoueurParId(id);

		// Vérification temps restant à la construction
		Integer secondesRestantes = (int) Math
				.ceil((batimentJoueurDto.getDateFinConstruction() - now.getTime()) / 1000);

		// Cout en gemmes
		Double coutGemmeAcceleration = Math.ceil((double) secondesRestantes / 30);

		if (jou.getGemmePossession() < coutGemmeAcceleration) {
			Long quantiteeGemmeManquante = (long) (coutGemmeAcceleration - jou.getGemmePossession());
			throw new RessourceManquanteException("Il vous manque " + quantiteeGemmeManquante
					+ " gemmes pour lancer l'accélération de la construction.");
		}

		BatimentJoueur batimentJoueur = new BatimentJoueur(batimentJoueurDto.getJoueur(),
				batimentJoueurDto.getBatiment(), batimentJoueurDto.getNiveau(),
				batimentJoueurDto.getOuvrierNecessaireAmelioration(), batimentJoueurDto.getTempsAmelioration(),
				batimentJoueurDto.getCoutPierreAmelioration(), batimentJoueurDto.getCoutBoisAmelioration(),
				batimentJoueurDto.getCoutOreAmelioration(), batimentJoueurDto.getCoutNourritureAmelioration(),
				batimentJoueurDto.getQuantiteeStockagePierre(), batimentJoueurDto.getQuantiteeStockageBois(),
				batimentJoueurDto.getQuantiteeStockageOre(), batimentJoueurDto.getQuantiteeStockageNourriture(),
				batimentJoueurDto.getApportPierreHeure(), batimentJoueurDto.getApportBoisHeure(),
				batimentJoueurDto.getApportOreHeure(), batimentJoueurDto.getApportNourritureHeure(),
				batimentJoueurDto.getDateDebutConstruction(), batimentJoueurDto.getDateFinConstruction());
		batimentJoueur.setId(batimentJoueurDto.getId());
		batimentJoueur.setDateFinConstruction(now.getTime());

		jou.setGemmePossession((long) (jou.getGemmePossession() - coutGemmeAcceleration));

		// MISE A JOUR DONNEES
		Joueur joueur = new Joueur(jou.getArmee(), jou.getIcone(), jou.getPseudo(), jou.getEmail(), jou.getMotDePasse(),
				jou.getDescriptif(), jou.getNiveau(), jou.getExperience(), jou.getPierrePossession(),
				jou.getBoisPossession(), jou.getOrPossession(), jou.getNourriturePossession(), jou.getGemmePossession(),
				jou.getPierreMaximum(), jou.getBoisMaximum(), jou.getOrMaximum(), jou.getNourritureMaximum(),
				jou.getPierreBoostProduction(), jou.getBoisBoostProduction(), jou.getOrBoostProduction(),
				jou.getNourritureBoostProduction(), jou.getTempsDeJeu(), jou.getRoles(), jou.getDerniereConnexion(),
				jou.getDonateur(), jou.getPositionX(), jou.getPositionY());
		joueur.setId(jou.getId());

		// SAUVEGARDE
		this.batimentJoueurRepo.save(batimentJoueur);
		this.joueurRepo.save(jou);

		return batimentJoueurDto;
	}

}
