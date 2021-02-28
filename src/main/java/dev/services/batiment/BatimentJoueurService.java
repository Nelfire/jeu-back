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
			BatimentJoueurDto batimentJoueurDto = new BatimentJoueurDto(batiment.getId(), batiment.getJoueur(), batiment.getBatiment(),batiment.getNiveau(),batiment.getOuvrierNecessaireAmelioration(),batiment.getTempsAmelioration(),batiment.getCoutPierreAmelioration(),batiment.getCoutBoisAmelioration(),batiment.getCoutOreAmelioration(),batiment.getCoutNourritureAmelioration(),batiment.getQuantiteeStockagePierre(),batiment.getQuantiteeStockageBois(),batiment.getQuantiteeStockageOre(),batiment.getQuantiteeStockageNourriture(),batiment.getApportPierreHeure(),batiment.getApportBoisHeure(),batiment.getApportOreHeure(),batiment.getApportNourritureHeure(),batiment.getDateDebutConstruction(),batiment.getDateFinConstruction());
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
		BatimentJoueurDto bat = new BatimentJoueurDto(id, batimentJoueur.getJoueur(), batimentJoueur.getBatiment(),batimentJoueur.getNiveau(),batimentJoueur.getOuvrierNecessaireAmelioration(),batimentJoueur.getTempsAmelioration(),batimentJoueur.getCoutPierreAmelioration(),batimentJoueur.getCoutBoisAmelioration(),batimentJoueur.getCoutOreAmelioration(),batimentJoueur.getCoutNourritureAmelioration(),batimentJoueur.getQuantiteeStockagePierre(),batimentJoueur.getQuantiteeStockageBois(),batimentJoueur.getQuantiteeStockageOre(),batimentJoueur.getQuantiteeStockageNourriture(),batimentJoueur.getApportPierreHeure(),batimentJoueur.getApportBoisHeure(),batimentJoueur.getApportOreHeure(),batimentJoueur.getApportNourritureHeure(),batimentJoueur.getDateDebutConstruction(),batimentJoueur.getDateFinConstruction());
		
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
		Joueur joueur = new Joueur(jou.getArmee(),jou.getIcone(),jou.getPseudo(),jou.getEmail(),jou.getMotDePasse(),jou.getDescriptif(),jou.getNiveau(),jou.getExperience(),jou.getPierrePossession(),jou.getBoisPossession(),jou.getOrPossession(),jou.getNourriturePossession(),jou.getGemmePossession(),jou.getPierreMaximum(),jou.getBoisMaximum(),jou.getOrMaximum(),jou.getNourritureMaximum(),jou.getPierreBoostProduction(),jou.getBoisBoostProduction(),jou.getOrBoostProduction(),jou.getNourritureBoostProduction(),jou.getTempsDeJeu(),jou.getRoles(), jou.getDerniereConnexion());
		joueur.setId(jou.getId());
//		jou.setPierreMaximum(jou.getPierreMaximum()+batiment.getQuantiteeStockagePierre());
//		jou.setBoisMaximum(jou.getBoisMaximum()+batiment.getQuantiteeStockageBois());
//		jou.setOrMaximum(jou.getOrMaximum()+batiment.getQuantiteeStockageOre());
//		jou.setNourritureMaximum(jou.getNourritureMaximum()+batiment.getQuantiteeStockageNourriture());
		
		
		// INITIALISATION DONNEES
		Integer ouvrierNecessaireAmelioration = 0;
		Integer tempsAmelioration = 0;
		Integer coutPierreAmelioration = 0;
		Integer coutBoisAmelioration = 0;
		Integer coutOreAmelioration = 0;
		Integer coutNourritureAmelioration = 0;
		Integer quantiteeStockagePierre = 0;
		Integer quantiteeStockageBois = 0;
		Integer quantiteeStockageOre = 0;
		Integer quantiteeStockageNourriture = 0;
		Integer apportPierreHeure = 0;
		Integer apportBoisHeure = 0;
		Integer apportOreHeure = 0;
		Integer apportNourritureHeure = 0;
		
	    /* 
	 	1 /- Hotel de ville	
		2 /- Chaumière (augmenter limite population)
		3 /- Carrière (farm pierre)
		4 /- Camp de bucheron (farm bois)		
		5 /- Camp de mineur (farm or)
		6 /- Ferme (farm nourriture)
		7 /- Stockage Pierre (Entrepot)	
		8 /- Stockage Bois (Scierie)
		9 /- Stockage Or (Banque)
		10 /- Stockage Nourriture (Grenier)
		11 /- Caserne Militaire	
		12 /- Ecurie
		13 /- Port
		14 /- Atelier de siege
		15 /- Forge		
		16 /- Universite
		17 /- Marché
		18 - Table d'expéditions
	     */
		
		/////////////////////////////////////
		/////DEFINIR COUT D'AMELIORATION/////
		/////////////////////////////////////
		
		if(batiment.getIdTypeBatiment() == 1) // 1 = Hotel de ville
		{
			ouvrierNecessaireAmelioration = batiment.getOuvrierNecessaireConstruction();
			tempsAmelioration = batiment.getTempsDeConstruction();
			coutPierreAmelioration = batiment.getCoutPierreConstruction();
			coutBoisAmelioration = batiment.getCoutBoisConstruction();
			coutOreAmelioration = batiment.getCoutOrConstruction();
			coutNourritureAmelioration = batiment.getCoutNourritureConstruction();
			quantiteeStockagePierre =batiment.getQuantiteeStockagePierre();
			quantiteeStockageBois = batiment.getQuantiteeStockageBois();
			quantiteeStockageOre = batiment.getQuantiteeStockageOre();
			quantiteeStockageNourriture = batiment.getQuantiteeStockageNourriture();
			apportPierreHeure = batiment.getApportPierreHeure();
			apportBoisHeure = batiment.getApportBoisHeure();
			apportOreHeure = batiment.getApportOreHeure();
			apportNourritureHeure = batiment.getApportNourritureHeure();

		} 
		else if (batiment.getIdTypeBatiment() == 2) // 2 = Chaumière
		{
			ouvrierNecessaireAmelioration = batiment.getOuvrierNecessaireConstruction();
			tempsAmelioration = batiment.getTempsDeConstruction();
			coutPierreAmelioration = batiment.getCoutPierreConstruction();
			coutBoisAmelioration = batiment.getCoutBoisConstruction();
			coutOreAmelioration = batiment.getCoutOrConstruction();
			coutNourritureAmelioration = batiment.getCoutNourritureConstruction();

		} 
		else if (batiment.getIdTypeBatiment() == 3) // 3 = Carrière
		{
			ouvrierNecessaireAmelioration = batiment.getOuvrierNecessaireConstruction();
			tempsAmelioration = batiment.getTempsDeConstruction();
			coutPierreAmelioration = batiment.getCoutPierreConstruction();
			coutBoisAmelioration = batiment.getCoutBoisConstruction();
			coutOreAmelioration = batiment.getCoutOrConstruction();
			coutNourritureAmelioration = batiment.getCoutNourritureConstruction();
			apportPierreHeure = batiment.getApportPierreHeure();
		} 
		else if (batiment.getIdTypeBatiment() == 4) // 4 = Camp de bucheron
		{
			ouvrierNecessaireAmelioration = batiment.getOuvrierNecessaireConstruction();
			tempsAmelioration = batiment.getTempsDeConstruction();
			coutPierreAmelioration = batiment.getCoutPierreConstruction();
			coutBoisAmelioration = batiment.getCoutBoisConstruction();
			coutOreAmelioration = batiment.getCoutOrConstruction();
			coutNourritureAmelioration = batiment.getCoutNourritureConstruction();
			apportBoisHeure = batiment.getApportBoisHeure();

		} 
		else if (batiment.getIdTypeBatiment() == 5) // 5 = Camp de mineur
		{
			ouvrierNecessaireAmelioration = batiment.getOuvrierNecessaireConstruction();
			tempsAmelioration = batiment.getTempsDeConstruction();
			coutPierreAmelioration = batiment.getCoutPierreConstruction();
			coutBoisAmelioration = batiment.getCoutBoisConstruction();
			coutOreAmelioration = batiment.getCoutOrConstruction();
			coutNourritureAmelioration = batiment.getCoutNourritureConstruction();
			apportOreHeure = batiment.getApportOreHeure();
		} 
		else if (batiment.getIdTypeBatiment() == 6) // 6 = Ferme
		{
			ouvrierNecessaireAmelioration = batiment.getOuvrierNecessaireConstruction();
			tempsAmelioration = batiment.getTempsDeConstruction();
			coutPierreAmelioration = batiment.getCoutPierreConstruction();
			coutBoisAmelioration = batiment.getCoutBoisConstruction();
			coutOreAmelioration = batiment.getCoutOrConstruction();
			coutNourritureAmelioration = batiment.getCoutNourritureConstruction();
			apportNourritureHeure = batiment.getApportNourritureHeure();
		} 
		else if (batiment.getIdTypeBatiment() == 7) // 7 = Stockage Pierre
		{
			ouvrierNecessaireAmelioration = batiment.getOuvrierNecessaireConstruction();
			tempsAmelioration = batiment.getTempsDeConstruction();
			coutPierreAmelioration = batiment.getCoutPierreConstruction();
			coutBoisAmelioration = batiment.getCoutBoisConstruction();
			coutOreAmelioration = batiment.getCoutOrConstruction();
			coutNourritureAmelioration = batiment.getCoutNourritureConstruction();
			quantiteeStockagePierre =batiment.getQuantiteeStockagePierre();
		} 
		else if (batiment.getIdTypeBatiment() == 8) // 8 = Stockage Bois
		{
			ouvrierNecessaireAmelioration = batiment.getOuvrierNecessaireConstruction();
			tempsAmelioration = batiment.getTempsDeConstruction();
			coutPierreAmelioration = batiment.getCoutPierreConstruction();
			coutBoisAmelioration = batiment.getCoutBoisConstruction();
			coutOreAmelioration = batiment.getCoutOrConstruction();
			coutNourritureAmelioration = batiment.getCoutNourritureConstruction();
			quantiteeStockageBois = batiment.getQuantiteeStockageBois();
		} 
		else if (batiment.getIdTypeBatiment() == 9) // 9 = Stockage Or
		{
			ouvrierNecessaireAmelioration = batiment.getOuvrierNecessaireConstruction();
			tempsAmelioration = batiment.getTempsDeConstruction();
			coutPierreAmelioration = batiment.getCoutPierreConstruction();
			coutBoisAmelioration = batiment.getCoutBoisConstruction();
			coutOreAmelioration = batiment.getCoutOrConstruction();
			coutNourritureAmelioration = batiment.getCoutNourritureConstruction();
			quantiteeStockageOre = batiment.getQuantiteeStockageOre();
		} 
		else if (batiment.getIdTypeBatiment() == 10) // 10 = Stockage Nourriture
		{
			ouvrierNecessaireAmelioration = batiment.getOuvrierNecessaireConstruction();
			tempsAmelioration = batiment.getTempsDeConstruction();
			coutPierreAmelioration = batiment.getCoutPierreConstruction();
			coutBoisAmelioration = batiment.getCoutBoisConstruction();
			coutOreAmelioration = batiment.getCoutOrConstruction();
			coutNourritureAmelioration = batiment.getCoutNourritureConstruction();
			quantiteeStockageNourriture = batiment.getQuantiteeStockageNourriture();
		} 
		else if (batiment.getIdTypeBatiment() == 11) // 11 = Caserne Militaire
		{
			ouvrierNecessaireAmelioration = batiment.getOuvrierNecessaireConstruction();
			tempsAmelioration = batiment.getTempsDeConstruction();
			coutPierreAmelioration = batiment.getCoutPierreConstruction();
			coutBoisAmelioration = batiment.getCoutBoisConstruction();
			coutOreAmelioration = batiment.getCoutOrConstruction();
			coutNourritureAmelioration = batiment.getCoutNourritureConstruction();
		} 
		else if (batiment.getIdTypeBatiment() == 12) // 12 = Ecurie
		{
			ouvrierNecessaireAmelioration = batiment.getOuvrierNecessaireConstruction();
			tempsAmelioration = batiment.getTempsDeConstruction();
			coutPierreAmelioration = batiment.getCoutPierreConstruction();
			coutBoisAmelioration = batiment.getCoutBoisConstruction();
			coutOreAmelioration = batiment.getCoutOrConstruction();
			coutNourritureAmelioration = batiment.getCoutNourritureConstruction();
		} 
		else if (batiment.getIdTypeBatiment() == 13) // 13 = Port
		{
			ouvrierNecessaireAmelioration = batiment.getOuvrierNecessaireConstruction();
			tempsAmelioration = batiment.getTempsDeConstruction();
			coutPierreAmelioration = batiment.getCoutPierreConstruction();
			coutBoisAmelioration = batiment.getCoutBoisConstruction();
			coutOreAmelioration = batiment.getCoutOrConstruction();
			coutNourritureAmelioration = batiment.getCoutNourritureConstruction();
		} 
		else if (batiment.getIdTypeBatiment() == 14) // 14 = Atelier de siege
		{
			ouvrierNecessaireAmelioration = batiment.getOuvrierNecessaireConstruction();
			tempsAmelioration = batiment.getTempsDeConstruction();
			coutPierreAmelioration = batiment.getCoutPierreConstruction();
			coutBoisAmelioration = batiment.getCoutBoisConstruction();
			coutOreAmelioration = batiment.getCoutOrConstruction();
			coutNourritureAmelioration = batiment.getCoutNourritureConstruction();
		} 
		else if (batiment.getIdTypeBatiment() == 15) // 15 = Forge
		{
			ouvrierNecessaireAmelioration = batiment.getOuvrierNecessaireConstruction();
			tempsAmelioration = batiment.getTempsDeConstruction();
			coutPierreAmelioration = batiment.getCoutPierreConstruction();
			coutBoisAmelioration = batiment.getCoutBoisConstruction();
			coutOreAmelioration = batiment.getCoutOrConstruction();
			coutNourritureAmelioration = batiment.getCoutNourritureConstruction();
		} 
		else if (batiment.getIdTypeBatiment() == 16) // 16 = Universite
		{
			ouvrierNecessaireAmelioration = batiment.getOuvrierNecessaireConstruction();
			tempsAmelioration = batiment.getTempsDeConstruction();
			coutPierreAmelioration = batiment.getCoutPierreConstruction();
			coutBoisAmelioration = batiment.getCoutBoisConstruction();
			coutOreAmelioration = batiment.getCoutOrConstruction();
			coutNourritureAmelioration = batiment.getCoutNourritureConstruction();
		} 
		else if (batiment.getIdTypeBatiment() == 17) // 17 = Marché
		{
			ouvrierNecessaireAmelioration = batiment.getOuvrierNecessaireConstruction();
			tempsAmelioration = batiment.getTempsDeConstruction();
			coutPierreAmelioration = batiment.getCoutPierreConstruction();
			coutBoisAmelioration = batiment.getCoutBoisConstruction();
			coutOreAmelioration = batiment.getCoutOrConstruction();
			coutNourritureAmelioration = batiment.getCoutNourritureConstruction();
		} 
		else if (batiment.getIdTypeBatiment() == 18) // 18 = Table d'expéditions
		{
			ouvrierNecessaireAmelioration = batiment.getOuvrierNecessaireConstruction();
			tempsAmelioration = batiment.getTempsDeConstruction();
			coutPierreAmelioration = batiment.getCoutPierreConstruction();
			coutBoisAmelioration = batiment.getCoutBoisConstruction();
			coutOreAmelioration = batiment.getCoutOrConstruction();
			coutNourritureAmelioration = batiment.getCoutNourritureConstruction();
		}

		// MISE A JOUR DE BATIMENT JOUEUR
		BatimentJoueur batimentJoueur = new BatimentJoueur(
				jou,
				batiment,
				1,
				ouvrierNecessaireAmelioration,
				tempsAmelioration,
				coutPierreAmelioration,
				coutBoisAmelioration,
				coutOreAmelioration,
				coutNourritureAmelioration,
				quantiteeStockagePierre,
				quantiteeStockageBois,
				quantiteeStockageOre,
				quantiteeStockageNourriture,
				apportPierreHeure,
				apportBoisHeure,
				apportOreHeure,
				apportNourritureHeure,
				debut,
				fin);
		
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
		batimentJoueurDto.setNiveau(batimentJoueurDto.getNiveau()+1);
		
		// INITIALISATION DES DONNEES
		// INITIALISATION DONNEES
		Integer ouvrierNecessaireAmelioration = 0;
		Integer tempsAmelioration = 0;
		Integer coutPierreAmelioration = 0;
		Integer coutBoisAmelioration = 0;
		Integer coutOreAmelioration = 0;
		Integer coutNourritureAmelioration = 0;
		Integer quantiteeStockagePierre = 0;
		Integer quantiteeStockageBois = 0;
		Integer quantiteeStockageOre = 0;
		Integer quantiteeStockageNourriture = 0;
		Integer apportPierreHeure = 0;
		Integer apportBoisHeure = 0;
		Integer apportOreHeure = 0;
		Integer apportNourritureHeure = 0;
		
		
		
		/////////////////////////////////////
		/////DEFINIR COUT D'AMELIORATION/////
		/////////////////////////////////////
		
		if(batimentJoueurDto.getBatiment().getIdTypeBatiment() == 1) // 1 = Hotel de ville
		{
			ouvrierNecessaireAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getOuvrierNecessaireAmelioration());
			tempsAmelioration = (batimentJoueurDto.getBatiment().getMultiplicateurCout()/4)*(batimentJoueurDto.getTempsAmelioration());
			coutPierreAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutPierreAmelioration());
			coutBoisAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutBoisAmelioration());
			coutOreAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutOreAmelioration());
			coutNourritureAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutNourritureAmelioration());
			quantiteeStockagePierre = batimentJoueurDto.getBatiment().getMultiplicateurApport()*(batimentJoueurDto.getQuantiteeStockagePierre());
			quantiteeStockageBois = batimentJoueurDto.getBatiment().getMultiplicateurApport()*(batimentJoueurDto.getQuantiteeStockageBois());
			quantiteeStockageOre = batimentJoueurDto.getBatiment().getMultiplicateurApport()*(batimentJoueurDto.getQuantiteeStockageOre());
			quantiteeStockageNourriture = batimentJoueurDto.getBatiment().getMultiplicateurApport()*(batimentJoueurDto.getQuantiteeStockageNourriture());
			apportPierreHeure = batimentJoueurDto.getBatiment().getMultiplicateurApport()*(batimentJoueurDto.getApportPierreHeure());
			apportBoisHeure = batimentJoueurDto.getBatiment().getMultiplicateurApport()*(batimentJoueurDto.getApportBoisHeure());
			apportOreHeure = batimentJoueurDto.getBatiment().getMultiplicateurApport()*(batimentJoueurDto.getApportOreHeure());
			apportNourritureHeure = batimentJoueurDto.getBatiment().getMultiplicateurApport()*(batimentJoueurDto.getApportNourritureHeure());
		} 
		else if (batimentJoueurDto.getBatiment().getIdTypeBatiment() == 2) // 2 = Chaumière
		{
			ouvrierNecessaireAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getOuvrierNecessaireAmelioration());;
			tempsAmelioration = (batimentJoueurDto.getBatiment().getMultiplicateurCout()/4)*(batimentJoueurDto.getTempsAmelioration());
			coutPierreAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutPierreAmelioration());
			coutBoisAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutBoisAmelioration());
			coutOreAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutOreAmelioration());
			coutNourritureAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutNourritureAmelioration());
		
		} 
		else if (batimentJoueurDto.getBatiment().getIdTypeBatiment() == 3) // 3 = Carrière
		{
			ouvrierNecessaireAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getOuvrierNecessaireAmelioration());;
			tempsAmelioration = (batimentJoueurDto.getBatiment().getMultiplicateurCout()/4)*(batimentJoueurDto.getTempsAmelioration());
			coutPierreAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutPierreAmelioration());
			coutBoisAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutBoisAmelioration());
			coutOreAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutOreAmelioration());
			coutNourritureAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutNourritureAmelioration());
			apportPierreHeure = batimentJoueurDto.getBatiment().getMultiplicateurApport()*(batimentJoueurDto.getApportPierreHeure());
		} 
		else if (batimentJoueurDto.getBatiment().getIdTypeBatiment() == 4) // 4 = Camp de bucheron
		{
			ouvrierNecessaireAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getOuvrierNecessaireAmelioration());;
			tempsAmelioration = (batimentJoueurDto.getBatiment().getMultiplicateurCout()/4)*(batimentJoueurDto.getTempsAmelioration());
			coutPierreAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutPierreAmelioration());
			coutBoisAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutBoisAmelioration());
			coutOreAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutOreAmelioration());
			coutNourritureAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutNourritureAmelioration());
			apportBoisHeure = batimentJoueurDto.getBatiment().getMultiplicateurApport()*(batimentJoueurDto.getApportBoisHeure());
		
		} 
		else if (batimentJoueurDto.getBatiment().getIdTypeBatiment() == 5) // 5 = Camp de mineur
		{
			ouvrierNecessaireAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getOuvrierNecessaireAmelioration());;
			tempsAmelioration = (batimentJoueurDto.getBatiment().getMultiplicateurCout()/4)*(batimentJoueurDto.getTempsAmelioration());
			coutPierreAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutPierreAmelioration());
			coutBoisAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutBoisAmelioration());
			coutOreAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutOreAmelioration());
			coutNourritureAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutNourritureAmelioration());
			apportOreHeure = batimentJoueurDto.getBatiment().getMultiplicateurApport()*(batimentJoueurDto.getApportOreHeure());
		} 
		else if (batimentJoueurDto.getBatiment().getIdTypeBatiment() == 6) // 6 = Ferme
		{
			ouvrierNecessaireAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getOuvrierNecessaireAmelioration());;
			tempsAmelioration = (batimentJoueurDto.getBatiment().getMultiplicateurCout()/4)*(batimentJoueurDto.getTempsAmelioration());
			coutPierreAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutPierreAmelioration());
			coutBoisAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutBoisAmelioration());
			coutOreAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutOreAmelioration());
			coutNourritureAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutNourritureAmelioration());
			apportNourritureHeure = batimentJoueurDto.getBatiment().getMultiplicateurApport()*(batimentJoueurDto.getApportNourritureHeure());
		} 
		else if (batimentJoueurDto.getBatiment().getIdTypeBatiment() == 7) // 7 = Stockage Pierre
		{
			ouvrierNecessaireAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getOuvrierNecessaireAmelioration());;
			tempsAmelioration = (batimentJoueurDto.getBatiment().getMultiplicateurCout()/4)*(batimentJoueurDto.getTempsAmelioration());
			coutPierreAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutPierreAmelioration());
			coutBoisAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutBoisAmelioration());
			coutOreAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutOreAmelioration());
			coutNourritureAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutNourritureAmelioration());
			quantiteeStockagePierre = batimentJoueurDto.getBatiment().getMultiplicateurApport()*(batimentJoueurDto.getQuantiteeStockagePierre());
		} 
		else if (batimentJoueurDto.getBatiment().getIdTypeBatiment() == 8) // 8 = Stockage Bois
		{
			ouvrierNecessaireAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getOuvrierNecessaireAmelioration());;
			tempsAmelioration = (batimentJoueurDto.getBatiment().getMultiplicateurCout()/4)*(batimentJoueurDto.getTempsAmelioration());
			coutPierreAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutPierreAmelioration());
			coutBoisAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutBoisAmelioration());
			coutOreAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutOreAmelioration());
			coutNourritureAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutNourritureAmelioration());
			quantiteeStockageBois = batimentJoueurDto.getBatiment().getMultiplicateurApport()*(batimentJoueurDto.getQuantiteeStockageBois());
		} 
		else if (batimentJoueurDto.getBatiment().getIdTypeBatiment() == 9) // 9 = Stockage Or
		{
			ouvrierNecessaireAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getOuvrierNecessaireAmelioration());;
			tempsAmelioration = (batimentJoueurDto.getBatiment().getMultiplicateurCout()/4)*(batimentJoueurDto.getTempsAmelioration());
			coutPierreAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutPierreAmelioration());
			coutBoisAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutBoisAmelioration());
			coutOreAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutOreAmelioration());
			coutNourritureAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutNourritureAmelioration());
			quantiteeStockageOre = batimentJoueurDto.getBatiment().getMultiplicateurApport()*(batimentJoueurDto.getQuantiteeStockageOre());
		} 
		else if (batimentJoueurDto.getBatiment().getIdTypeBatiment() == 10) // 10 = Stockage Nourriture
		{
			ouvrierNecessaireAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getOuvrierNecessaireAmelioration());;
			tempsAmelioration = (batimentJoueurDto.getBatiment().getMultiplicateurCout()/4)*(batimentJoueurDto.getTempsAmelioration());
			coutPierreAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutPierreAmelioration());
			coutBoisAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutBoisAmelioration());
			coutOreAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutOreAmelioration());
			coutNourritureAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutNourritureAmelioration());
			quantiteeStockageNourriture = batimentJoueurDto.getBatiment().getMultiplicateurApport()*(batimentJoueurDto.getQuantiteeStockageNourriture());
		} 
		else if (batimentJoueurDto.getBatiment().getIdTypeBatiment() == 11) // 11 = Caserne Militaire
		{
			ouvrierNecessaireAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getOuvrierNecessaireAmelioration());;
			tempsAmelioration = (batimentJoueurDto.getBatiment().getMultiplicateurCout()/4)*(batimentJoueurDto.getTempsAmelioration());
			coutPierreAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutPierreAmelioration());
			coutBoisAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutBoisAmelioration());
			coutOreAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutOreAmelioration());
			coutNourritureAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutNourritureAmelioration());
		} 
		else if (batimentJoueurDto.getBatiment().getIdTypeBatiment() == 12) // 12 = Ecurie
		{
			ouvrierNecessaireAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getOuvrierNecessaireAmelioration());;
			tempsAmelioration = (batimentJoueurDto.getBatiment().getMultiplicateurCout()/4)*(batimentJoueurDto.getTempsAmelioration());
			coutPierreAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutPierreAmelioration());
			coutBoisAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutBoisAmelioration());
			coutOreAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutOreAmelioration());
			coutNourritureAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutNourritureAmelioration());
		} 
		else if (batimentJoueurDto.getBatiment().getIdTypeBatiment() == 13) // 13 = Port
		{
			ouvrierNecessaireAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getOuvrierNecessaireAmelioration());;
			tempsAmelioration = (batimentJoueurDto.getBatiment().getMultiplicateurCout()/4)*(batimentJoueurDto.getTempsAmelioration());
			coutPierreAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutPierreAmelioration());
			coutBoisAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutBoisAmelioration());
			coutOreAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutOreAmelioration());
			coutNourritureAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutNourritureAmelioration());
		} 
		else if (batimentJoueurDto.getBatiment().getIdTypeBatiment() == 14) // 14 = Atelier de siege
		{
			ouvrierNecessaireAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getOuvrierNecessaireAmelioration());;
			tempsAmelioration = (batimentJoueurDto.getBatiment().getMultiplicateurCout()/4)*(batimentJoueurDto.getTempsAmelioration());
			coutPierreAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutPierreAmelioration());
			coutBoisAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutBoisAmelioration());
			coutOreAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutOreAmelioration());
			coutNourritureAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutNourritureAmelioration());
		} 
		else if (batimentJoueurDto.getBatiment().getIdTypeBatiment() == 15) // 15 = Forge
		{
			ouvrierNecessaireAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getOuvrierNecessaireAmelioration());;
			tempsAmelioration = (batimentJoueurDto.getBatiment().getMultiplicateurCout()/4)*(batimentJoueurDto.getTempsAmelioration());
			coutPierreAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutPierreAmelioration());
			coutBoisAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutBoisAmelioration());
			coutOreAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutOreAmelioration());
			coutNourritureAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutNourritureAmelioration());
		} 
		else if (batimentJoueurDto.getBatiment().getIdTypeBatiment() == 16) // 16 = Universite
		{
			ouvrierNecessaireAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getOuvrierNecessaireAmelioration());;
			tempsAmelioration = (batimentJoueurDto.getBatiment().getMultiplicateurCout()/4)*(batimentJoueurDto.getTempsAmelioration());
			coutPierreAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutPierreAmelioration());
			coutBoisAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutBoisAmelioration());
			coutOreAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutOreAmelioration());
			coutNourritureAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutNourritureAmelioration());
		} 
		else if (batimentJoueurDto.getBatiment().getIdTypeBatiment() == 17) // 17 = Marché
		{
			ouvrierNecessaireAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getOuvrierNecessaireAmelioration());;
			tempsAmelioration = (batimentJoueurDto.getBatiment().getMultiplicateurCout()/4)*(batimentJoueurDto.getTempsAmelioration());
			coutPierreAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutPierreAmelioration());
			coutBoisAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutBoisAmelioration());
			coutOreAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutOreAmelioration());
			coutNourritureAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutNourritureAmelioration());
		} 
		else if (batimentJoueurDto.getBatiment().getIdTypeBatiment() == 18) // 18 = Table d'expéditions
		{
			ouvrierNecessaireAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getOuvrierNecessaireAmelioration());;
			tempsAmelioration = (batimentJoueurDto.getBatiment().getMultiplicateurCout()/4)*(batimentJoueurDto.getTempsAmelioration());
			coutPierreAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutPierreAmelioration());
			coutBoisAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutBoisAmelioration());
			coutOreAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutOreAmelioration());
			coutNourritureAmelioration = batimentJoueurDto.getBatiment().getMultiplicateurCout()*(batimentJoueurDto.getCoutNourritureAmelioration());
		}
		
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
		Integer quantiteePierreManquante;
		Integer quantiteeBoisManquant;
		Integer quantiteeOrManquant;
		Integer quantiteeNourritureManquante;
		
		// - Détermine la date de fin de l'amélioration
		long debut = new Date().getTime();
		long fin = new Date().getTime()+(batimentJoueurDto.getTempsAmelioration()*1000);

		
		
		BatimentJoueur batimentJoueur = new BatimentJoueur(
				batimentJoueurDto.getJoueur(),
				batimentJoueurDto.getBatiment(),
				batimentJoueurDto.getNiveau(),
				batimentJoueurDto.getOuvrierNecessaireAmelioration(),
				batimentJoueurDto.getTempsAmelioration(),
				batimentJoueurDto.getCoutPierreAmelioration(),
				batimentJoueurDto.getCoutBoisAmelioration(),
				batimentJoueurDto.getCoutOreAmelioration(),
				batimentJoueurDto.getCoutNourritureAmelioration(),
				batimentJoueurDto.getQuantiteeStockagePierre(),
				batimentJoueurDto.getQuantiteeStockageBois(),
				batimentJoueurDto.getQuantiteeStockageOre(),
				batimentJoueurDto.getQuantiteeStockageNourriture(),
				batimentJoueurDto.getApportPierreHeure(),
				batimentJoueurDto.getApportBoisHeure(),
				batimentJoueurDto.getApportOreHeure(),
				batimentJoueurDto.getApportNourritureHeure(),
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
//		jou.setPierreMaximum(jou.getPierreMaximum()+batimentJoueurDto.getQuantiteeStockagePierre());
//		jou.setBoisMaximum(jou.getBoisMaximum()+batimentJoueurDto.getQuantiteeStockageBois());
//		jou.setOrMaximum(jou.getOrMaximum()+batimentJoueurDto.getQuantiteeStockageOre());
//		jou.setNourritureMaximum(jou.getNourritureMaximum()+batimentJoueurDto.getQuantiteeStockageNourriture());
		
		Joueur joueur = new Joueur(jou.getArmee(),jou.getIcone(),jou.getPseudo(),jou.getEmail(),jou.getMotDePasse(),jou.getDescriptif(),jou.getNiveau(),jou.getExperience(),jou.getPierrePossession(),jou.getBoisPossession(),jou.getOrPossession(),jou.getNourriturePossession(),jou.getGemmePossession(),jou.getPierreMaximum(),jou.getBoisMaximum(),jou.getOrMaximum(),jou.getNourritureMaximum(),jou.getPierreBoostProduction(),jou.getBoisBoostProduction(),jou.getOrBoostProduction(),jou.getNourritureBoostProduction(),jou.getTempsDeJeu(),jou.getRoles(), jou.getDerniereConnexion());
		joueur.setId(jou.getId());

		// SAUVEGARDES
		this.joueurRepo.save(joueur);
		this.batimentJoueurRepo.save(batimentJoueur);
		
		// RETOUR
		return batimentJoueurDto;
	}
	
//	/**
//	 * RECHERCHE POPULATION MAXIMALE DU JOUEUR
//	 */
//	public Integer RecherchePopulationMaximaleJoueur() {
//		// INITIALISATION
//		Integer populationMaximaleJoueur = 0;
//		
//		Joueur jou = joueurService.recuperationJoueur();
//		List<BatimentJoueur> batimentsJoueur = batimentJoueurRepo.findByJoueurId(jou.getId());
//		for (BatimentJoueur batimentJoueur : batimentsJoueur) {
//			if(batimentJoueur.getBatiment().getIdTypeBatiment()==1 || batimentJoueur.getBatiment().getIdTypeBatiment()==2) {
//				populationMaximaleJoueur = populationMaximaleJoueur + batimentJoueur.getApportPopulation();
//			}
//		}
//		
//		// RETOUR
//		return populationMaximaleJoueur;
//	}
	
	
}
