package dev.services.expedition;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import org.springframework.stereotype.Service;

import dev.controller.dto.expedition.CompositionArmeeExpeditionDto;
import dev.entites.expedition.Expedition;
import dev.entites.expedition.ExpeditionJoueur;
import dev.entites.expedition.ExpeditionUnitee;
import dev.entites.joueur.Armee;
import dev.entites.joueur.Joueur;
import dev.entites.unitee.Unitee;
import dev.exceptions.RecompenseDejaPercuException;
import dev.exceptions.RessourceManquanteException;
import dev.exceptions.UniteeManquanteException;
import dev.repository.JoueurRepo;
import dev.repository.expedition.ExpeditionRepo;
import dev.repository.expedition.ExpeditionUniteeRepo;
import dev.repository.joueur.ArmeeRepo;
import dev.repository.joueur.ExpeditionJoueurRepo;
import dev.repository.unitee.UniteeRepo;
import dev.services.joueur.JoueurService;

@Service
public class ExpeditionJoueurService {
	/*
	 * A FAIRE :
	 * MODIFIER LE FONCTIONNEMENT DE envoiUniteeEnExpedition, POUR RACOURSIR
	 */

	ExpeditionJoueurRepo expeditionJoueurRepo;
	ArmeeRepo armeeRepo;
	JoueurService joueurService;
	JoueurRepo joueurRepo;
	ExpeditionRepo expeditionRepo;
	ExpeditionUniteeRepo expeditionUniteeRepo;
	UniteeRepo uniteeRepo;

	/**
	 * @param expeditionRepo
	 */
	public ExpeditionJoueurService(ExpeditionJoueurRepo expeditionJoueurRepo, ArmeeRepo armeeRepo, JoueurService joueurService, JoueurRepo joueurRepo, ExpeditionRepo expeditionRepo, ExpeditionUniteeRepo expeditionUniteeRepo, UniteeRepo uniteeRepo) {
		super();
		this.expeditionJoueurRepo = expeditionJoueurRepo;
		this.armeeRepo = armeeRepo;
		this.joueurService = joueurService;
		this.joueurRepo = joueurRepo;
		this.expeditionRepo = expeditionRepo;
		this.expeditionUniteeRepo = expeditionUniteeRepo;
		this.uniteeRepo = uniteeRepo;
	}
	

	/*
	0 : EXPEDITION EN COURS
	1 : VICTOIRE, RECOMPENSE EN ATTENTE
	2 : VICTOIRE, RECOMPENSE DEJA RECUPEREE
	3 : DEFAITE
	 */
	
	/**
	 * LISTER TOUTES LES EXPEDITIONS DU JOUEUR, TOUT CONFONDU
	 */
	public List<ExpeditionJoueur> listerExpeditionJoueur() {
		// Récupération du joueur
		Joueur jou = joueurService.recuperationJoueur();
		
		// Récupération de la liste des expéditions du joueur.
		List<ExpeditionJoueur> listeExpeditionJoueur = new ArrayList<>();
		for (ExpeditionJoueur expedition : expeditionJoueurRepo.findByJoueur(jou)) {
			// ACTUALISATION ETAT EXPEDITION
			long maintenant = new Date().getTime();
			// SI L'EXPEDITION EST TERMINEE
			if(expedition.getDateFinExpedition()< maintenant && expedition.getEtatExpedition()==0) {
				// DÉFINIR L'ÉTAT DE RÉUSSITE OU DE DÉFAITE DE L'EXPÉDITION EN FONCTION DU POURCENTAGE DE RÉUSSITE
			    Random rand = new Random();
			    int nombreRandom = rand.nextInt(100);
			    if (nombreRandom <= expedition.getPourcentageReussite())
			    { 
			    	// - Défini l'état de l'expédition comme "Victoire"
			    	expedition.setEtatExpedition(1);
			    }
			    else
			    { 
			    	// - Défini l'état de l'expédition comme "Echec"
			    	expedition.setEtatExpedition(3);
			    }
			    // SAUVEGARDE
			    this.expeditionJoueurRepo.save(expedition);
			}
			// AJOUT A LA LISTE
			listeExpeditionJoueur.add(expedition);
		}
		
		// RETOUR
		return listeExpeditionJoueur;
	}
	
	/**
	 * LISTER UNIQUEMENT LES EXPEDITIONS JOUEUR TERMINEES EN ECHEC = 3
	 */
	public List<ExpeditionJoueur> listerExpeditionJoueurTermineesEchec() {
		// Récupération du joueur
		Joueur jou = joueurService.recuperationJoueur();
		
		// Récupération de la liste des expéditions du joueur.
		List<ExpeditionJoueur> listeExpeditionJoueur = new ArrayList<>();
		for (ExpeditionJoueur expedition : expeditionJoueurRepo.findByJoueur(jou)) {
			// ACTUALISATION ETAT EXPEDITION
			long maintenant = new Date().getTime();
			// SI L'EXPEDITION EST TERMINEE
			if(expedition.getDateFinExpedition()< maintenant && expedition.getEtatExpedition()==0) {
				// DÉFINIR L'ÉTAT DE RÉUSSITE OU DE DÉFAITE DE L'EXPÉDITION EN FONCTION DU POURCENTAGE DE RÉUSSITE
			    Random rand = new Random();
			    int nombreRandom = rand.nextInt(100);
			    if (nombreRandom <= expedition.getPourcentageReussite())
			    { 
			    	// - Défini l'état de l'expédition comme "Victoire"
			    	expedition.setEtatExpedition(1);
			    }
			    else
			    { 
			    	// - Défini l'état de l'expédition comme "Echec"
			    	expedition.setEtatExpedition(3);
			    }
			    
			    // SAUVEGARDE
			    this.expeditionJoueurRepo.save(expedition);
			}
			
		    // SI L'EXPEDITION EN COURS D'ANALYSE EST UN ECHEC, JE L'INSCRIT DANS LA LISTE
			if(expedition.getEtatExpedition()==3) {
				// AJOUT A LA LISTE
				listeExpeditionJoueur.add(expedition);
			}
		}
		
		// RETOUR
		return listeExpeditionJoueur;	
	}
	
	/**
	 * LISTER UNIQUEMENT LES EXPEDITIONS JOUEUR VICTORIEUSE + RECOMPENSE EN ATTENTE DE RECUPERATION = 1
	 */
	public List<ExpeditionJoueur> listerExpeditionJoueurRecompenseEnAttente() {
		// Récupération du joueur
		Joueur jou = joueurService.recuperationJoueur();
		
		// Récupération de la liste des expéditions du joueur.
		List<ExpeditionJoueur> listeExpeditionJoueur = new ArrayList<>();
		for (ExpeditionJoueur expedition : expeditionJoueurRepo.findByJoueur(jou)) {
			// ACTUALISATION ETAT EXPEDITION
			long maintenant = new Date().getTime();
			// SI L'EXPEDITION EST TERMINEE
			if(expedition.getDateFinExpedition()< maintenant && expedition.getEtatExpedition()==0) {
				// DÉFINIR L'ÉTAT DE RÉUSSITE OU DE DÉFAITE DE L'EXPÉDITION EN FONCTION DU POURCENTAGE DE RÉUSSITE
			    Random rand = new Random();
			    int nombreRandom = rand.nextInt(100);
			    if (nombreRandom <= expedition.getPourcentageReussite())
			    { 
			    	// - Défini l'état de l'expédition comme "Victoire"
			    	expedition.setEtatExpedition(1);
			    }
			    else
			    { 
			    	// - Défini l'état de l'expédition comme "Echec"
			    	expedition.setEtatExpedition(3);
			    }
			    
			    // SAUVEGARDE
			    this.expeditionJoueurRepo.save(expedition);
			}
			
		    // SI L'EXPEDITION EN COURS D'ANALYSE EST UNE VICTOIRE + RECOMPENSE EN ATTENTE , JE L'INSCRIT DANS LA LISTE
			if(expedition.getEtatExpedition()==1) {
				// AJOUT A LA LISTE
				listeExpeditionJoueur.add(expedition);
			}
		}
		
		// RETOUR
		return listeExpeditionJoueur;	
	}
	
	/**
	 * LISTER UNIQUEMENT LES EXPEDITIONS JOUEUR VICTORIEUSE + RECOMPENSE DEJA RECUPEREE = 2
	 */
	public List<ExpeditionJoueur> listerExpeditionJoueurTermineesVictoire() {
		// Récupération du joueur
		Joueur jou = joueurService.recuperationJoueur();
		
		// Récupération de la liste des expéditions du joueur.
		List<ExpeditionJoueur> listeExpeditionJoueur = new ArrayList<>();
		for (ExpeditionJoueur expedition : expeditionJoueurRepo.findByJoueur(jou)) {
			// ACTUALISATION ETAT EXPEDITION
			long maintenant = new Date().getTime();
			// SI L'EXPEDITION EST TERMINEE
			if(expedition.getDateFinExpedition()< maintenant && expedition.getEtatExpedition()==0) {
				// DÉFINIR L'ÉTAT DE RÉUSSITE OU DE DÉFAITE DE L'EXPÉDITION EN FONCTION DU POURCENTAGE DE RÉUSSITE
			    Random rand = new Random();
			    int nombreRandom = rand.nextInt(100);
			    if (nombreRandom <= expedition.getPourcentageReussite())
			    { 
			    	// - Défini l'état de l'expédition comme "Victoire"
			    	expedition.setEtatExpedition(1);
			    }
			    else
			    { 
			    	// - Défini l'état de l'expédition comme "Echec"
			    	expedition.setEtatExpedition(3);
			    }
			    
			    // SAUVEGARDE
			    this.expeditionJoueurRepo.save(expedition);
			}
			
		    // SI L'EXPEDITION EN COURS D'ANALYSE EST UNE VICTOIRE + RECOMPENSE DEJA PERCU , JE L'INSCRIT DANS LA LISTE
			if(expedition.getEtatExpedition()==2) {
				// AJOUT A LA LISTE
				listeExpeditionJoueur.add(expedition);
			}
		}
		
		// RETOUR
		return listeExpeditionJoueur;	
	}
	
	/**
	 * LISTER UNIQUEMENT LES EXPEDITIONS JOUEUR EN COURS = 0
	 */
	public List<ExpeditionJoueur> listerExpeditionJoueurEnCours() {
		// Récupération du joueur
		Joueur jou = joueurService.recuperationJoueur();
		
		// Récupération de la liste des expéditions du joueur.
		List<ExpeditionJoueur> listeExpeditionJoueur = new ArrayList<>();
		for (ExpeditionJoueur expedition : expeditionJoueurRepo.findByJoueur(jou)) {
			// ACTUALISATION ETAT EXPEDITION
			long maintenant = new Date().getTime();
			// SI L'EXPEDITION EST TERMINEE
			if(expedition.getDateFinExpedition()< maintenant && expedition.getEtatExpedition()==0) {
				// DÉFINIR L'ÉTAT DE RÉUSSITE OU DE DÉFAITE DE L'EXPÉDITION EN FONCTION DU POURCENTAGE DE RÉUSSITE
			    Random rand = new Random();
			    int nombreRandom = rand.nextInt(100);
			    if (nombreRandom <= expedition.getPourcentageReussite())
			    { 
			    	// - Défini l'état de l'expédition comme "Victoire"
			    	expedition.setEtatExpedition(1);
			    }
			    else
			    { 
			    	// - Défini l'état de l'expédition comme "Echec"
			    	expedition.setEtatExpedition(3);
			    }
			    
			    // SAUVEGARDE
			    this.expeditionJoueurRepo.save(expedition);
			}
			
		    // SI L'EXPEDITION EN COURS D'ANALYSE EST EN COURS , JE L'INSCRIT DANS LA LISTE
			if(expedition.getEtatExpedition()==0) {
				// AJOUT A LA LISTE
				listeExpeditionJoueur.add(expedition);
			}
		}
		
		// RETOUR
		return listeExpeditionJoueur;	
	}
	
	
	
	/**
	 * RECHERCHE EXPEDITION JOUEUR PAR ID
	 */
	public ExpeditionJoueur rechercherExpeditionJoueurById(Integer id) {
		// Recherche de l'expedition joueur correspondante
		Optional<ExpeditionJoueur> expeJoueur = expeditionJoueurRepo.findById(id);
		// Création d'une instance depuis l'expedition trouvée
		ExpeditionJoueur expeditionJoueur = new ExpeditionJoueur();
		expeditionJoueur.setId(expeJoueur.get().getId());
		expeditionJoueur.setJoueur(expeJoueur.get().getJoueur());
		expeditionJoueur.setExpedition(expeJoueur.get().getExpedition());
		expeditionJoueur.setDateDebutExpedition(expeJoueur.get().getDateDebutExpedition());
		expeditionJoueur.setDateFinExpedition(expeJoueur.get().getDateFinExpedition());
		expeditionJoueur.setArmeeEnvoiJoueur(expeJoueur.get().getArmeeEnvoiJoueur());
		expeditionJoueur.setRecompenseRecuperee(expeJoueur.get().getRecompenseRecuperee());
		expeditionJoueur.setPourcentageReussite(expeJoueur.get().getPourcentageReussite());
		expeditionJoueur.setEtatExpedition(expeJoueur.get().getEtatExpedition());
		return expeditionJoueur;
	}
	
	/**
	 * ENVOI D'UNITEES EN EXPEDITION (Création)
	 */
	public CompositionArmeeExpeditionDto envoiUniteeEnExpedition(CompositionArmeeExpeditionDto compositionArmeeExpedition) {
		
		// RÉCUPÉRATION DU JOUEUR
		Joueur jou = joueurService.recuperationJoueur();
		// RECHERCHE EXPEDITION CORRESPONDANTE
		Optional<Expedition> expe = expeditionRepo.findById(compositionArmeeExpedition.getIdExpedition());
		// CREATION D'UNE EXPEDITION TYPE, À PARTIR DE CETTE RECHERCHE
		Expedition expedition = new Expedition();
		expedition.setId(expe.get().getId());
		expedition.setIcone(expe.get().getIcone());
		expedition.setLibelle(expe.get().getLibelle());
		expedition.setDureeExpedition(expe.get().getDureeExpedition());
		expedition.setDifficultee(expe.get().getDifficultee());
		expedition.setDegats(expe.get().getDegats());
		expedition.setVie(expe.get().getVie());
		expedition.setArmure(expe.get().getArmure());
		expedition.setCoutPierre(expe.get().getCoutPierre());
		expedition.setCoutBois(expe.get().getCoutBois());
		expedition.setCoutOr(expe.get().getCoutOr());
		expedition.setCoutNourriture(expe.get().getCoutNourriture());
		expedition.setRecompensePierre(expe.get().getRecompensePierre());
		expedition.setRecompenseBois(expe.get().getRecompenseBois());
		expedition.setRecompenseOr(expe.get().getRecompenseOr());
		expedition.setRecompenseNourriture(expe.get().getRecompenseNourriture());
		expedition.setRecompenseGemme(expe.get().getRecompenseGemme());
		
		// INITIALISATION
		// - Dégats que le jouer va emettre lors de l'attaque, pour calculer le % réussite
		Integer degatsEmis = 0;
		// - Coût global de l'expédition
		Integer coutPierre = expe.get().getCoutPierre();
		Integer coutBois = expe.get().getCoutBois();
		Integer coutOr = expe.get().getCoutOr();
		Integer coutNourriture = expe.get().getCoutNourriture();
		Armee armee = new Armee();
		// - Temps expédition
		long debut = new Date().getTime();
		long fin = new Date().getTime()+(expedition.getDureeExpedition()*1000);
		// - Liste des armées que le joueur va envoyer
		List<Armee> listeArmees = new ArrayList<>();

		// TEST : LE JOUEUR À T'IL ASSEZ DE RESSOURCES POUR LANCER L'EXPEDITION ???
		if(jou.getPierrePossession() < expedition.getCoutPierre()) {
			throw new RessourceManquanteException("Pierre insuffisante pour lancer l'expédition.");
		} else if(jou.getBoisPossession() < expedition.getCoutBois()) {
			throw new RessourceManquanteException("Bois insuffisant pour lancer l'expédition.");
		} else if(jou.getOrPossession() < expedition.getCoutOr()) {
			throw new RessourceManquanteException("Or insuffisant pour lancer l'expédition.");
		} else if(jou.getNourriturePossession() < expedition.getCoutNourriture()) {
			throw new RessourceManquanteException("Nourriture insuffisante pour lancer l'expédition.");
		}

		
		
		// RETRAIT UNITEES
		// - Parcourir les armées que possède déjà le joueur, pour y soustraire les unitées qu'il envoi en expédition
		for (Armee arme : armeeRepo.findByJoueur(jou)) {
			if(arme.getUnitee().getId()==1) // Villageois
			{
				if(arme.getQuantitee()-compositionArmeeExpedition.getNombreVillageois()<0) {
					throw new UniteeManquanteException("Vous manquez de villageois.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis + (arme.getUnitee().getAttaque() * compositionArmeeExpedition.getNombreVillageois());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombreVillageois());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);
					
					ExpeditionUnitee expeditionUnitee = new ExpeditionUnitee(expedition.getId(),arme.getUnitee().getId(),compositionArmeeExpedition.getNombreVillageois());
					expeditionUniteeRepo.save(expeditionUnitee);
				}
			} 
			else if(arme.getUnitee().getId()==2)  // Archer
			{
				if(arme.getQuantitee()-compositionArmeeExpedition.getNombreArcher()<0) {
					throw new UniteeManquanteException("Vous manquez d'archers.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis + (arme.getUnitee().getAttaque() * compositionArmeeExpedition.getNombreArcher());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombreArcher());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);
					
					ExpeditionUnitee expeditionUnitee = new ExpeditionUnitee(expedition.getId(),arme.getUnitee().getId(),compositionArmeeExpedition.getNombreArcher());
					expeditionUniteeRepo.save(expeditionUnitee);
				}
			} 
			else if(arme.getUnitee().getId()==3)  // ArcherComposite
			{
				if(arme.getQuantitee()-compositionArmeeExpedition.getNombreArcherComposite()<0) {
					throw new UniteeManquanteException("Vous manquez d'archers composite.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis + (arme.getUnitee().getAttaque() * compositionArmeeExpedition.getNombreArcherComposite());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombreArcherComposite());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);
					
					ExpeditionUnitee expeditionUnitee = new ExpeditionUnitee(expedition.getId(),arme.getUnitee().getId(),compositionArmeeExpedition.getNombreArcherComposite());
					expeditionUniteeRepo.save(expeditionUnitee);
				}
			} 
			else if(arme.getUnitee().getId()==4)  // FantassinEpee
			{
				if(arme.getQuantitee()-compositionArmeeExpedition.getNombreFantassinEpee()<0) {
					throw new UniteeManquanteException("Vous manquez de fantassins épée.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis + (arme.getUnitee().getAttaque() * compositionArmeeExpedition.getNombreFantassinEpee());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombreFantassinEpee());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);
					
					ExpeditionUnitee expeditionUnitee = new ExpeditionUnitee(expedition.getId(),arme.getUnitee().getId(),compositionArmeeExpedition.getNombreFantassinEpee());
					expeditionUniteeRepo.save(expeditionUnitee);
				}
			} 
			else if(arme.getUnitee().getId()==5)  // nombreHommeDArme
			{
				if(arme.getQuantitee()-compositionArmeeExpedition.getNombreHommeDArme()<0) {
					throw new UniteeManquanteException("Vous manquez d'hommes d'arme.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis + (arme.getUnitee().getAttaque() * compositionArmeeExpedition.getNombreHommeDArme());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombreHommeDArme());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);
					
					ExpeditionUnitee expeditionUnitee = new ExpeditionUnitee(expedition.getId(),arme.getUnitee().getId(),compositionArmeeExpedition.getNombreHommeDArme());
					expeditionUniteeRepo.save(expeditionUnitee);
				}
			} 
			else if(arme.getUnitee().getId()==6)  // nombreLanceurDeHache
			{
				if(arme.getQuantitee()-compositionArmeeExpedition.getNombreLanceurDeHache()<0) {
					throw new UniteeManquanteException("Vous manquez de lanceurs de hache.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis + (arme.getUnitee().getAttaque() * compositionArmeeExpedition.getNombreLanceurDeHache());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombreLanceurDeHache());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);
					
					ExpeditionUnitee expeditionUnitee = new ExpeditionUnitee(expedition.getId(),arme.getUnitee().getId(),compositionArmeeExpedition.getNombreLanceurDeHache());
					expeditionUniteeRepo.save(expeditionUnitee);
				}
			} 
			else if(arme.getUnitee().getId()==7)  // nombreMilicien
			{
				if(arme.getQuantitee()-compositionArmeeExpedition.getNombreMilicien()<0) {
					throw new UniteeManquanteException("Vous manquez de miliciens.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis + (arme.getUnitee().getAttaque() * compositionArmeeExpedition.getNombreMilicien());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombreMilicien());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);
					
					ExpeditionUnitee expeditionUnitee = new ExpeditionUnitee(expedition.getId(),arme.getUnitee().getId(),compositionArmeeExpedition.getNombreMilicien());
					expeditionUniteeRepo.save(expeditionUnitee);
				}
			} 
			else if(arme.getUnitee().getId()==8)  // nombrePiquier
			{
				if(arme.getQuantitee()-compositionArmeeExpedition.getNombrePiquier()<0) {
					throw new UniteeManquanteException("Vous manquez de piquiers.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis + (arme.getUnitee().getAttaque() * compositionArmeeExpedition.getNombrePiquier());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombrePiquier());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);
					
					ExpeditionUnitee expeditionUnitee = new ExpeditionUnitee(expedition.getId(),arme.getUnitee().getId(),compositionArmeeExpedition.getNombrePiquier());
					expeditionUniteeRepo.save(expeditionUnitee);
				}
			} 
			else if(arme.getUnitee().getId()==9)  // nombreCavalierArcher
			{
				if(arme.getQuantitee()-compositionArmeeExpedition.getNombreCavalierArcher()<0) {
					throw new UniteeManquanteException("Vous manquez de cavaliers archer.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis + (arme.getUnitee().getAttaque() * compositionArmeeExpedition.getNombreCavalierArcher());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombreCavalierArcher());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);
					
					ExpeditionUnitee expeditionUnitee = new ExpeditionUnitee(expedition.getId(),arme.getUnitee().getId(),compositionArmeeExpedition.getNombreCavalierArcher());
					expeditionUniteeRepo.save(expeditionUnitee);
				}
			} 
			else if(arme.getUnitee().getId()==10)  // nombreCavalier
			{
				if(arme.getQuantitee()-compositionArmeeExpedition.getNombreCavalier()<0) {
					throw new UniteeManquanteException("Vous manquez de cavaliers.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis + (arme.getUnitee().getAttaque() * compositionArmeeExpedition.getNombreCavalier());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombreCavalier());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);
					
					ExpeditionUnitee expeditionUnitee = new ExpeditionUnitee(expedition.getId(),arme.getUnitee().getId(),compositionArmeeExpedition.getNombreCavalier());
					expeditionUniteeRepo.save(expeditionUnitee);
				}
			} 
			else if(arme.getUnitee().getId()==11)  // nombreChampion
			{
				if(arme.getQuantitee()-compositionArmeeExpedition.getNombreChampion()<0) {
					throw new UniteeManquanteException("Vous manquez de champions.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis + (arme.getUnitee().getAttaque() * compositionArmeeExpedition.getNombreChampion());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombreChampion());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);
					
					ExpeditionUnitee expeditionUnitee = new ExpeditionUnitee(expedition.getId(),arme.getUnitee().getId(),compositionArmeeExpedition.getNombreChampion());
					expeditionUniteeRepo.save(expeditionUnitee);
				}
			} 
			else if(arme.getUnitee().getId()==12)  // nombreBateauDePeche
			{
				if(arme.getQuantitee()-compositionArmeeExpedition.getNombreBateauDePeche()<0) {
					throw new UniteeManquanteException("Vous manquez de bâteaux de pêche.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis + (arme.getUnitee().getAttaque() * compositionArmeeExpedition.getNombreBateauDePeche());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombreBateauDePeche());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);
					
					ExpeditionUnitee expeditionUnitee = new ExpeditionUnitee(expedition.getId(),arme.getUnitee().getId(),compositionArmeeExpedition.getNombreBateauDePeche());
					expeditionUniteeRepo.save(expeditionUnitee);
				}
			} 
			else if(arme.getUnitee().getId()==13)  // nombreBateauIncendiaire
			{
				if(arme.getQuantitee()-compositionArmeeExpedition.getNombreBateauIncendiaire()<0) {
					throw new UniteeManquanteException("Vous manquez de bâteaux incendiaire.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis + (arme.getUnitee().getAttaque() * compositionArmeeExpedition.getNombreBateauIncendiaire());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombreBateauIncendiaire());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);
					
					ExpeditionUnitee expeditionUnitee = new ExpeditionUnitee(expedition.getId(),arme.getUnitee().getId(),compositionArmeeExpedition.getNombreBateauIncendiaire());
					expeditionUniteeRepo.save(expeditionUnitee);
				}
			} 
			else if(arme.getUnitee().getId()==14)  // nombreBateauDeDestruction
			{
				if(arme.getQuantitee()-compositionArmeeExpedition.getNombreBateauDeDestruction()<0) {
					throw new UniteeManquanteException("Vous manquez de bâteaux de destruction.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis + (arme.getUnitee().getAttaque() * compositionArmeeExpedition.getNombreBateauDeDestruction());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombreBateauDeDestruction());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);
					
					ExpeditionUnitee expeditionUnitee = new ExpeditionUnitee(expedition.getId(),arme.getUnitee().getId(),compositionArmeeExpedition.getNombreBateauDeDestruction());
					expeditionUniteeRepo.save(expeditionUnitee);
				}
			} 
			else if(arme.getUnitee().getId()==15)  // nombreGalionACanon
			{
				if(arme.getQuantitee()-compositionArmeeExpedition.getNombreGalionACanon()<0) {
					throw new UniteeManquanteException("Vous manquez de galions à canon.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis + (arme.getUnitee().getAttaque() * compositionArmeeExpedition.getNombreGalionACanon());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombreGalionACanon());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);
					
					ExpeditionUnitee expeditionUnitee = new ExpeditionUnitee(expedition.getId(),arme.getUnitee().getId(),compositionArmeeExpedition.getNombreGalionACanon());
					expeditionUniteeRepo.save(expeditionUnitee);
				}
			} 
			else if(arme.getUnitee().getId()==16)  // nombreGalion
			{
				if(arme.getQuantitee()-compositionArmeeExpedition.getNombreGalion()<0) {
					throw new UniteeManquanteException("Vous manquez de galions.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis + (arme.getUnitee().getAttaque() * compositionArmeeExpedition.getNombreGalion());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombreGalion());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);
					
					ExpeditionUnitee expeditionUnitee = new ExpeditionUnitee(expedition.getId(),arme.getUnitee().getId(),compositionArmeeExpedition.getNombreGalion());
					expeditionUniteeRepo.save(expeditionUnitee);
				}
			} 
			else if(arme.getUnitee().getId()==17)  // nombreGuerrierElite
			{
				if(arme.getQuantitee()-compositionArmeeExpedition.getNombreGuerrierElite()<0) {
					throw new UniteeManquanteException("Vous manquez de guerriers élite.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis + (arme.getUnitee().getAttaque() * compositionArmeeExpedition.getNombreGuerrierElite());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombreGuerrierElite());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);
					
					ExpeditionUnitee expeditionUnitee = new ExpeditionUnitee(expedition.getId(),arme.getUnitee().getId(),compositionArmeeExpedition.getNombreGuerrierElite());
					expeditionUniteeRepo.save(expeditionUnitee);
				}
			} 
			else if(arme.getUnitee().getId()==18)  // nombrePhalange
			{
				if(arme.getQuantitee()-compositionArmeeExpedition.getNombrePhalange()<0) {
					throw new UniteeManquanteException("Vous manquez de phalanges.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis + (arme.getUnitee().getAttaque() * compositionArmeeExpedition.getNombrePhalange());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombrePhalange());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);
					
					ExpeditionUnitee expeditionUnitee = new ExpeditionUnitee(expedition.getId(),arme.getUnitee().getId(),compositionArmeeExpedition.getNombrePhalange());
					expeditionUniteeRepo.save(expeditionUnitee);
				}
			} 
			else if(arme.getUnitee().getId()==19)  // nombreSamourail
			{
				if(arme.getQuantitee()-compositionArmeeExpedition.getNombreSamourail()<0) {
					throw new UniteeManquanteException("Vous manquez de samourails.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis + (arme.getUnitee().getAttaque() * compositionArmeeExpedition.getNombreSamourail());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombreSamourail());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);
					
					ExpeditionUnitee expeditionUnitee = new ExpeditionUnitee(expedition.getId(),arme.getUnitee().getId(),compositionArmeeExpedition.getNombreSamourail());
					expeditionUniteeRepo.save(expeditionUnitee);
				}
			} 
			else if(arme.getUnitee().getId()==20)  // nombreTemplier
			{
				if(arme.getQuantitee()-compositionArmeeExpedition.getNombreTemplier()<0) {
					throw new UniteeManquanteException("Vous manquez de templiers.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis + (arme.getUnitee().getAttaque() * compositionArmeeExpedition.getNombreTemplier());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombreTemplier());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);
					
					ExpeditionUnitee expeditionUnitee = new ExpeditionUnitee(expedition.getId(),arme.getUnitee().getId(),compositionArmeeExpedition.getNombreTemplier());
					expeditionUniteeRepo.save(expeditionUnitee);
				}
			} 
			else if(arme.getUnitee().getId()==21)  // nombreCatapulte
			{
				if(arme.getQuantitee()-compositionArmeeExpedition.getNombreCatapulte()<0) {
					throw new UniteeManquanteException("Vous manquez de catapultes.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis + (arme.getUnitee().getAttaque() * compositionArmeeExpedition.getNombreCatapulte());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombreCatapulte());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);
					
					ExpeditionUnitee expeditionUnitee = new ExpeditionUnitee(expedition.getId(),arme.getUnitee().getId(),compositionArmeeExpedition.getNombreCatapulte());
					expeditionUniteeRepo.save(expeditionUnitee);
				}
			} 
			else if(arme.getUnitee().getId()==22)  // nombreElephantDeCombat
			{
				if(arme.getQuantitee()-compositionArmeeExpedition.getNombreElephantDeCombat()<0) {
					throw new UniteeManquanteException("Vous manquez d'éléphants de combat.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis + (arme.getUnitee().getAttaque() * compositionArmeeExpedition.getNombreElephantDeCombat());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombreElephantDeCombat());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);
					
					ExpeditionUnitee expeditionUnitee = new ExpeditionUnitee(expedition.getId(),arme.getUnitee().getId(),compositionArmeeExpedition.getNombreElephantDeCombat());
					expeditionUniteeRepo.save(expeditionUnitee);
				}
			} 
			else if(arme.getUnitee().getId()==23)  // nombrePretre
			{
				if(arme.getQuantitee()-compositionArmeeExpedition.getNombrePretre()<0) {
					throw new UniteeManquanteException("Vous manquez de prêtres.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis + (arme.getUnitee().getAttaque() * compositionArmeeExpedition.getNombrePretre());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombrePretre());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);
					
					ExpeditionUnitee expeditionUnitee = new ExpeditionUnitee(expedition.getId(),arme.getUnitee().getId(),compositionArmeeExpedition.getNombrePretre());
					expeditionUniteeRepo.save(expeditionUnitee);
				}
			}

		}
		
		// SI AUCUN DÉGATS N'EST ÉMIS, C'EST QU'AUCUNE UNITÉE N'A ÉTÉ SÉLECTIONNÉE : EXCEPTION
		if(degatsEmis==0) {
			throw new UniteeManquanteException("Vous n'avez sélectionné aucune unitée");
		}
		
		// LE PROCESSUS DE L'EXPÉDITION CONTINUE : RETRAIT DE RESSOURCES AU JOUEUR
		jou.setPierrePossession(jou.getPierrePossession()-coutPierre);
		jou.setBoisPossession(jou.getBoisPossession()-coutBois);
		jou.setOrPossession(jou.getOrPossession()-coutOr);
		jou.setNourriturePossession(jou.getNourriturePossession()-coutNourriture);
		Joueur joueur = new Joueur(jou.getArmee(),jou.getIcone(),jou.getPseudo(),jou.getEmail(),jou.getMotDePasse(),jou.getDescriptif(),jou.getNiveau(),jou.getExperience(),jou.getPierrePossession(),jou.getBoisPossession(),jou.getOrPossession(),jou.getNourriturePossession(),jou.getGemmePossession(),jou.getPierreMaximum(),jou.getBoisMaximum(),jou.getOrMaximum(),jou.getNourritureMaximum(),jou.getPierreBoostProduction(),jou.getBoisBoostProduction(),jou.getOrBoostProduction(),jou.getNourritureBoostProduction(),jou.getTempsDeJeu(),jou.getRoles(), jou.getDerniereConnexion());
		joueur.setId(jou.getId());
		joueurRepo.save(joueur);
		
		/*
		 * 0 = EN ATTENTE + VICTORIEUSE
		 * 1 = EN ATTENTE + DEFAITE
		 * 2 = RECOMPENSE EN ATTENTE
		 * 3 = DEFAITE
		 */
		// CALCUL DU POURCENTAGE DE RÉUSSITE DE L'EXPÉDITION
	    int vieRestanteExpedition = expedition.getVie() - degatsEmis;
	    int pourcentageReussite = 100 - (((vieRestanteExpedition * 100) / expedition.getVie()));
	    if (vieRestanteExpedition < 0) {
	      pourcentageReussite = 100;
	    }
	    
		// CRÉATION DE L'EXPEDITION JOUEUR
		ExpeditionJoueur expeditionJoueur = new ExpeditionJoueur();
		expeditionJoueur.setJoueur(jou);
		expeditionJoueur.setExpedition(expedition);
		expeditionJoueur.setDateDebutExpedition(debut);
		expeditionJoueur.setDateFinExpedition(fin);
		expeditionJoueur.setArmeeEnvoiJoueur(listeArmees);
		expeditionJoueur.setRecompenseRecuperee(false);
		expeditionJoueur.setPourcentageReussite(pourcentageReussite);
		expeditionJoueur.setEtatExpedition(0);
		
	    // SAUVEGARDE FINALE DE L'EXPÉDITION JOUEUR
		expeditionJoueurRepo.save(expeditionJoueur);
		return null;
	}
	
	public String recupererRecompense(Integer idExpedition) {
		
		// RÉCUPÉRATION INFORMATIONS EXPEDITIONJOUER
		ExpeditionJoueur expdJoueur = this.rechercherExpeditionJoueurById(idExpedition);
		
		// VÉRIFICATION RÉCOMPENSE DISPONNIBLE (SI ELLE À PAS DÉJÀ ÉTÉ PERÇU)
		if(expdJoueur.getRecompenseRecuperee() == true) {
			throw new RecompenseDejaPercuException("Vous avez déjà perçu cette récompense.");
		}
		
		// CRÉATION D'UNE EXPEDITIONJOUEUR À PARTIR DE NOTRE RECHERCHE
		ExpeditionJoueur expeditionJoueur = new ExpeditionJoueur();
		expeditionJoueur.setId(expdJoueur.getId());
		expeditionJoueur.setJoueur(expdJoueur.getJoueur());
		expeditionJoueur.setExpedition(expdJoueur.getExpedition());
		expeditionJoueur.setDateDebutExpedition(expdJoueur.getDateDebutExpedition());
		expeditionJoueur.setDateFinExpedition(expdJoueur.getDateFinExpedition());
		expeditionJoueur.setArmeeEnvoiJoueur(expdJoueur.getArmeeEnvoiJoueur());
		// ON CHANGE L'ÉTAT DE LA RÉCOMPENSE
		expeditionJoueur.setRecompenseRecuperee(true);
		expeditionJoueur.setPourcentageReussite(expdJoueur.getPourcentageReussite());
		expeditionJoueur.setEtatExpedition(expdJoueur.getEtatExpedition());

		
		// DANS LE CAS OU L'EXPÉDITION EST UN SUCCES, ATTIBUTION DES RESSOURCES AU JOUEUR (PIERRE, BOIS, OR, NOURRITURE, GEMME)
	    if (expdJoueur.getEtatExpedition() == 1) 
	    {
			Joueur jou = joueurService.recuperationJoueur();
			jou.setPierrePossession(jou.getPierrePossession() + expdJoueur.getExpedition().getRecompensePierre());
			jou.setBoisPossession(jou.getBoisPossession() + expdJoueur.getExpedition().getRecompenseBois());
			jou.setOrPossession(jou.getOrPossession() + expdJoueur.getExpedition().getRecompenseOr());
			jou.setNourriturePossession(jou.getNourriturePossession() + expdJoueur.getExpedition().getRecompenseNourriture());
			jou.setGemmePossession(jou.getGemmePossession() + expdJoueur.getExpedition().getRecompenseGemme());
			jou.setExperience(jou.getExperience() + expdJoueur.getExpedition().getRecompenseExperience());
			jou.setNiveau(1+Math.round(jou.getExperience() / 5000)); // /!\ Temporaire : 1 Niveau = 5000 Experience
			
			// - Changement de l'état, pour définir l'expédition comme "réussite"
			expeditionJoueur.setEtatExpedition(2);
			
			// Détection des unitées envoyées en expédition.
			for (ExpeditionUnitee expeditionUnitee : expeditionUniteeRepo.findAll()) {
				// SI EXPEDITION UNITEE
				if(expeditionUnitee.getIdExpedition() == expeditionJoueur.getExpedition().getId()) {
					// RECHERCHE UNITEE CORRESPONDANTE
					for (Unitee unitee : uniteeRepo.findAll()) {
						if(unitee.getId() == expeditionUnitee.getIdUnitee()) {
							// RECHERCHE ARMEE DU JOUEUR CORRESPONDANTE
							for (Armee arme : armeeRepo.findByJoueur(jou)) {
								if(arme.getUnitee().getId()==expeditionUnitee.getIdUnitee())
								{
									// RE-ATTRIBUTION DES QUANTITES
									
									Armee armee = new Armee();
									// - Calcul des dégats émis
									armee.setId(arme.getId());
									armee.setJoueur(jou);
									armee.setUnitee(arme.getUnitee());
									armee.setQuantitee(arme.getQuantitee()+expeditionUnitee.getQuantite());
									armee.setDateDebutProduction(arme.getDateDebutProduction());
									armee.setDateFinProduction(arme.getDateFinProduction());
									armeeRepo.save(armee);
								}
							}
						}
					}
				}
			}
			
			// - Sauvegardes des informations joueur
			joueurRepo.save(jou);
	    }

		// SAUVEGARDE DE L'EXPÉDITION JOUEUR
		expeditionJoueurRepo.save(expeditionJoueur);
		
		return "Ok";
	}
}
