package dev.services.batiment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Service;
import dev.controller.dto.batiment.DefenseJoueurCreationDto;
import dev.controller.dto.batiment.DefenseJoueurDto;
import dev.entites.batiment.Defense;
import dev.entites.batiment.DefenseJoueur;
import dev.entites.joueur.Joueur;
import dev.exceptions.MessageResponseException;
import dev.exceptions.RessourceManquanteException;
import dev.repository.JoueurRepo;
import dev.repository.batiment.DefenseRepo;
import dev.repository.joueur.DefenseJoueurRepo;
import dev.services.joueur.JoueurService;

@Service
public class DefenseJoueurService {

	private DefenseJoueurRepo defenseJoueurRepo;
	private JoueurService joueurService;
	private JoueurRepo joueurRepo;
	private DefenseRepo defenseRepo;
	/**
	 * @param defenseJoueurRepo
	 */
	public DefenseJoueurService(DefenseJoueurRepo defenseJoueurRepo, JoueurService joueurService, JoueurRepo joueurRepo, DefenseRepo defenseRepo) {
		super();
		this.defenseJoueurRepo = defenseJoueurRepo;
		this.joueurService = joueurService;
		this.joueurRepo = joueurRepo;
		this.defenseRepo = defenseRepo;
	}
	
	/**
	 * LISTER DIFFERENTES DEFENSES DU JOUEUR
	 */
	public List<DefenseJoueur> listerMesDefenses() {
		List<DefenseJoueur> listeDefensesJoueur = new ArrayList<>();
		
		for (DefenseJoueur defenseJoueur : defenseJoueurRepo.findAll()) {
			listeDefensesJoueur.add(defenseJoueur);
		}
		
		return listeDefensesJoueur;
	}
	
	/**
	 * CREATION D'UNE DEFENSE JOUEUR (Nouvelles défense)
	 */
	public DefenseJoueurCreationDto construireDefense(DefenseJoueurCreationDto defenseJoueurCreationDto) {
		// RÉCUPÉRATION DU JOUEUR CONNECTÉ
		Joueur jou = this.joueurService.recuperationJoueur();
		
		// INITIALISATIONS
		Boolean flag = false;
		Integer idDefenseJoueur = 0;
		Integer quantite = 0;
		Long quantiteePierreManquante;
		Long quantiteeBoisManquant;
		Long quantiteeOrManquant;
		Long quantiteeNourritureManquante;
		Long tempsDebutConstruction = 0L;
		Long tempsFinConstruction = 0L;
		Long finProduction = 0L;
		
		// INFORMATIONS SUR LA DEFENSE QUE LE JOUEUR VEUT CRÉER
		Defense defense = defenseRepo.findByIdTypeDefense(defenseJoueurCreationDto.getIdDefense());


		// INITIALISATIONS DES COÛTS DE CONSTRUCTION (COÛT DEFENSE RESSOURCE X QUANTITÉ)
		Integer coutPierreOperation = defense.getCoutPierreConstruction() * defenseJoueurCreationDto.getQuantite();
		Integer coutBoisOperation = defense.getCoutBoisConstruction() * defenseJoueurCreationDto.getQuantite();
		Integer coutOrOperation = defense.getCoutOrConstruction() * defenseJoueurCreationDto.getQuantite();
		Integer coutNourritureOperation = defense.getCoutNourritureConstruction() * defenseJoueurCreationDto.getQuantite();

		/* VÉRIFICATIONS : LE JOUEUR À T'IL ASSEZ DE RESSOURCES ?? */
		// - SI RESSOURCES INSUFFISANTES 
		// -- Pierre manquante :
		if(jou.getPierrePossession() < coutPierreOperation) {
			quantiteePierreManquante = coutPierreOperation-jou.getPierrePossession();
			throw new RessourceManquanteException("Il vous manque "+quantiteePierreManquante+" de pierre pour lancer la production.");
		}		
		// -- Bois manquant :
		else if(jou.getBoisPossession() < coutBoisOperation) {
			quantiteeBoisManquant = coutBoisOperation-jou.getBoisPossession();
			throw new RessourceManquanteException("Il vous manque "+quantiteeBoisManquant+" de bois pour lancer la production.");
		}
		// -- Or manquant :
		else if(jou.getOrPossession() < coutOrOperation) {
			quantiteeOrManquant = coutOrOperation-jou.getOrPossession();
			throw new RessourceManquanteException("Il vous manque "+quantiteeOrManquant+" d'or pour lancer la production.");
		}
		// -- Nourriture manquante :
		else if(jou.getNourriturePossession() < coutNourritureOperation) {
			quantiteeNourritureManquante = coutNourritureOperation-jou.getNourriturePossession();
			throw new RessourceManquanteException("Il vous manque "+quantiteeNourritureManquante+" de nourriture pour lancer la production.");
		}
		
		// PARCOURIR LES DEFENSES QUE POSSÈDE DÉJÀ LE JOUEUR
		for (DefenseJoueur defJoueur : defenseJoueurRepo.findByJoueur(jou)) {
			// - S'il possède déjà un type de défense, récupération des données (L'id de la défense, et la quantité de défense)
			if(defJoueur.getDefense().getIdTypeDefense()==defenseJoueurCreationDto.getIdDefense()) {
				flag = true;
				idDefenseJoueur = defJoueur.getId();
				quantite = defJoueur.getQuantite();
				tempsDebutConstruction = defJoueur.getDateDebutConstruction();
				tempsFinConstruction = defJoueur.getDateFinConstruction();
			}
		}

		DefenseJoueur defenseDuJoueur = new DefenseJoueur();
		
		// SI LE JOUEUR POSSÈDE DÉJÀ CE TYPE DE DEFENSE, ALORS ADDITION LES QUANTITÉS (NOUVELLE + ANCIENNE) + ÉCRASE LA DEFENSE DÉJÀ EXISTANTE
		if(flag==true) {
			defenseDuJoueur.setId(idDefenseJoueur);
			defenseDuJoueur.setQuantite(quantite + defenseJoueurCreationDto.getQuantite());
		}
		else // SINON, CRÉATION D'UNE NOUVELLE DEFENSEJOUEUR, POUR CE GENRE DE DEFENSE
		{			
			defenseDuJoueur.setQuantite(defenseJoueurCreationDto.getQuantite());
		}
		
		// Nouvelle production = Nouvelle date de début. 
		if(tempsFinConstruction<new Date().getTime()) {			
			tempsDebutConstruction = new Date().getTime();
			finProduction = new Date().getTime()+((defense.getTempsConstruction()*defenseJoueurCreationDto.getQuantite())*1000);
			defenseDuJoueur.setDateDebutConstruction(tempsDebutConstruction);
		} 
		else // Sinon, date de début inchangée, production toujours en cours. Ajout de temps
		{
			finProduction = tempsFinConstruction+((defense.getTempsConstruction()*defenseJoueurCreationDto.getQuantite())*1000);
			defenseDuJoueur.setDateDebutConstruction(tempsDebutConstruction);
		}
		defenseDuJoueur.setDateFinConstruction(finProduction);

		// MISE A JOUR DU JOUEUR
		// - Retrait de ressources
		jou.setPierrePossession(jou.getPierrePossession()-coutPierreOperation);
		jou.setBoisPossession(jou.getBoisPossession()-coutBoisOperation);
		jou.setOrPossession(jou.getOrPossession()-coutOrOperation);
		jou.setNourriturePossession(jou.getNourriturePossession()-coutNourritureOperation);
		// - Ajout de l'experience gagné pour la construction
		jou.setExperience(jou.getExperience() + defenseJoueurCreationDto.getQuantite()*defense.getApportExperience());
		
		// DETERMINE LE NIVEAU DU JOUEUR EN FONCTION DE SON XP
		Integer niveau = this.joueurService.determinerNiveau(jou.getExperience());
		jou.setNiveau(niveau);
		
		Joueur joueur = new Joueur(jou.getArmee(),jou.getIcone(),jou.getPseudo(),jou.getEmail(),jou.getMotDePasse(),jou.getDescriptif(),jou.getNiveau(),jou.getExperience(),jou.getPierrePossession(),jou.getBoisPossession(),jou.getOrPossession(),jou.getNourriturePossession(),jou.getGemmePossession(),jou.getPierreMaximum(),jou.getBoisMaximum(),jou.getOrMaximum(),jou.getNourritureMaximum(),jou.getPierreBoostProduction(),jou.getBoisBoostProduction(),jou.getOrBoostProduction(),jou.getNourritureBoostProduction(),jou.getTempsDeJeu(),jou.getRoles(), jou.getDerniereConnexion(), jou.getDonateur(), jou.getPositionX(), jou.getPositionY());
		joueur.setId(jou.getId());
		
		// MISE A JOUR DE LA DEFENSE JOUEUR
		defenseDuJoueur.setJoueur(jou);
		defenseDuJoueur.setDefense(defense);
		
		// SAUVEGARDES
		this.joueurRepo.save(joueur);
		this.defenseJoueurRepo.save(defenseDuJoueur); 
		
		// RETOUR
		return new DefenseJoueurCreationDto(defenseDuJoueur.getId(), defenseDuJoueur.getQuantite());
	}
	
	/**
	 * RECUPERATION DONNES D'UNE DEFENSE (Via ID) : Utilisé dans "putBatimentJoueur"
	 */
	public DefenseJoueurDto rechercheDefenseJoueurParId(Integer id) {
		DefenseJoueur defenseJoueur = defenseJoueurRepo.findById(id).orElseThrow(() -> new MessageResponseException("La défense joueur n'a pas pu être récupérée"));
		DefenseJoueurDto def = new DefenseJoueurDto(id, defenseJoueur.getJoueur(), defenseJoueur.getDefense(),defenseJoueur.getQuantite(),defenseJoueur.getDateDebutConstruction(),defenseJoueur.getDateFinConstruction());
		
		// RETOUR
		return def;
	}
	
	public DefenseJoueurDto accelerationConstructionDefense(@Valid DefenseJoueurDto def, Integer id) {
		
		this.joueurService.getInfoJoueur();
		// RÉCUPÉRATION DU JOUEUR CONNECTÉ.
		Joueur jou = joueurService.recuperationJoueur();
		
		// INITIALISATION
		Date now = new Date();
		DefenseJoueurDto defenseJoueurDto = this.rechercheDefenseJoueurParId(id);
		
		// Vérification temps restant à la construction
		Integer secondesRestantes = (int)Math.ceil((defenseJoueurDto.getDateFinConstruction()-now.getTime())/1000);

		// Cout en gemmes
		Double coutGemmeAcceleration = Math.ceil((double) secondesRestantes/60);
		
		if(jou.getGemmePossession() < coutGemmeAcceleration) {
			Integer quantiteeGemmeManquante = (int) (coutGemmeAcceleration-jou.getGemmePossession());
			throw new RessourceManquanteException("Il vous manque "+quantiteeGemmeManquante+" gemmes pour lancer l'accélération de la construction.");
		}	
		
		DefenseJoueur defenseJoueur = new DefenseJoueur(
				defenseJoueurDto.getJoueur(),
				defenseJoueurDto.getDefense(),
				defenseJoueurDto.getQuantite(),
				defenseJoueurDto.getDateDebutConstruction(),
				defenseJoueurDto.getDateFinConstruction());
		defenseJoueur.setId(defenseJoueurDto.getId());
		defenseJoueur.setDateFinConstruction(now.getTime());
		
		jou.setGemmePossession((long) (jou.getGemmePossession() - coutGemmeAcceleration));
		
		// MISE A JOUR DONNEES
		Joueur joueur = new Joueur(jou.getArmee(),jou.getIcone(),jou.getPseudo(),jou.getEmail(),jou.getMotDePasse(),jou.getDescriptif(),jou.getNiveau(),jou.getExperience(),jou.getPierrePossession(),jou.getBoisPossession(),jou.getOrPossession(),jou.getNourriturePossession(),jou.getGemmePossession(),jou.getPierreMaximum(),jou.getBoisMaximum(),jou.getOrMaximum(),jou.getNourritureMaximum(),jou.getPierreBoostProduction(),jou.getBoisBoostProduction(),jou.getOrBoostProduction(),jou.getNourritureBoostProduction(),jou.getTempsDeJeu(),jou.getRoles(), jou.getDerniereConnexion(), jou.getDonateur(), jou.getPositionX(), jou.getPositionY());
		joueur.setId(jou.getId());
		
		// SAUVEGARDE
		this.defenseJoueurRepo.save(defenseJoueur);
		this.joueurRepo.save(jou);
		
		
		return defenseJoueurDto;
	}
	
	
	
	
	
	
}
