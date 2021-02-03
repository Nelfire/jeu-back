package dev.services;

import org.springframework.stereotype.Service;

import dev.entites.Joueur;
import dev.exceptions.RessourceManquanteException;
import dev.repository.JoueurRepo;

@Service
public class BoutiqueService {
	
	private JoueurService joueurService;
	private JoueurRepo joueurRepo;
	
	/**
	 * @param joueurService
	 */
	public BoutiqueService(JoueurService joueurService, JoueurRepo joueurRepo) {
		super();
		this.joueurService = joueurService;
		this.joueurRepo = joueurRepo;
	}
	
	
	
	// PIERRE
	public void achat10PourcentPierre() {
		System.out.println("Achat 10% pierre service");

		// RECUPERATION DU JOUEUR
		Joueur jou = joueurService.recuperationJoueur();
		
		// QUANTITEE RESSOURCE CORRESPONDANTE (10%)
		Integer quantite10pourcentpierre = (int) (jou.getPierreMaximum()*0.1);
		// CALCUL COUT GEMMES ( montant ressource / 100 )
		Integer coutGemme = quantite10pourcentpierre / 100;
		System.out.println("quantite10pourcentpierre : "+quantite10pourcentpierre);
		System.out.println("coutGemme : "+coutGemme);
			
		// CAS ACHAT DE RESSOURCES SUPÉRIEURE À LA CAPACITÉE DE STOCKAGE
		if(quantite10pourcentpierre+jou.getPierrePossession() > jou.getPierreMaximum()) {
			quantite10pourcentpierre = jou.getPierreMaximum()-jou.getPierrePossession();
			coutGemme = quantite10pourcentpierre / 100;
		}
		
		// CAS GEMMES INSUFISANTES
		if(jou.getGemmePossession()<coutGemme) {
			throw new RessourceManquanteException("Gemmes insuffisantes.");
		}
		
		// SI LIMITE PIERRE ATTEINTE
		if(jou.getPierreMaximum()==jou.getPierrePossession()) {
			throw new RessourceManquanteException("Maximum de pierre atteint.");
		}
		System.out.println(jou.getId());
		System.out.println("Gemmes avant :"+jou.getGemmePossession());
		// RETRAIT DES GEMMES
		jou.setGemmePossession(jou.getGemmePossession() - coutGemme);
		System.out.println("Gemmes apres :"+jou.getGemmePossession());
		// AJOUT DE LA PIERRE

		System.out.println("Pierres avant :"+jou.getPierrePossession());
		jou.setPierrePossession(jou.getPierrePossession() + quantite10pourcentpierre);
		System.out.println("Pierres apres :"+jou.getPierrePossession());
		
		
		Joueur joueur = new Joueur(jou.getArmee(), jou.getIcone(), jou.getPseudo(), jou.getEmail(), jou.getMotDePasse(),
				jou.getDescriptif(), jou.getNiveau(), jou.getExperience(), jou.getPierrePossession(),
				jou.getBoisPossession(), jou.getOrPossession(), jou.getNourriturePossession(), jou.getGemmePossession(),
				jou.getPierreMaximum(), jou.getBoisMaximum(), jou.getOrMaximum(), jou.getNourritureMaximum(),
				jou.getPierreBoostProduction(), jou.getBoisBoostProduction(), jou.getOrBoostProduction(),
				jou.getNourritureBoostProduction(), jou.getTempsDeJeu(), jou.getRoles(), jou.getDerniereConnexion());
		joueur.setId(jou.getId());
		
		// SAUVEGARDE
		joueurRepo.save(joueur);
		System.out.println(joueur.toString());
		
	}
	public void achat50PourcentPierre() {
		// RECUPERATION DU JOUEUR
		Joueur jou = joueurService.recuperationJoueur();
		
		// QUANTITEE RESSOURCE CORRESPONDANTE (50%)
		Integer quantite50pourcentpierre = (int) (jou.getPierreMaximum()*0.5);
		// CALCUL COUT GEMMES ( montant ressource / 100 )
		Integer coutGemme = quantite50pourcentpierre / 100;
		
		// CAS ACHAT DE RESSOURCES SUPÉRIEURE À LA CAPACITÉE DE STOCKAGE
		if(quantite50pourcentpierre+jou.getPierrePossession() > jou.getPierreMaximum()) {
			quantite50pourcentpierre = jou.getPierreMaximum()-jou.getPierrePossession();
			coutGemme = quantite50pourcentpierre / 100;
		}
		
		// CAS GEMMES INSUFISANTES
		if(jou.getGemmePossession()<coutGemme) {
			throw new RessourceManquanteException("Gemmes insuffisantes.");
		}
		
		// SI LIMITE PIERRE ATTEINTE
		if(jou.getPierreMaximum()==jou.getPierrePossession()) {
			throw new RessourceManquanteException("Maximum de pierre atteint.");
		}
		
		// RETRAIT DES GEMMES
		jou.setGemmePossession(jou.getGemmePossession() - coutGemme);
		// AJOUT DE LA PIERRE
		jou.setPierrePossession(jou.getPierrePossession() + quantite50pourcentpierre);
		
		// SAUVEGARDE
		joueurRepo.save(jou);
	}
	public void achat100PourcentPierre() {
		// RECUPERATION DU JOUEUR
		Joueur jou = joueurService.recuperationJoueur();
		
		// QUANTITEE RESSOURCE CORRESPONDANTE (100%)
		Integer quantite100pourcentpierre = (int) (jou.getPierreMaximum());
		// CALCUL COUT GEMMES ( montant ressource / 100 )
		Integer coutGemme = quantite100pourcentpierre / 100;
		
		// CAS ACHAT DE RESSOURCES SUPÉRIEURE À LA CAPACITÉE DE STOCKAGE
		if(quantite100pourcentpierre+jou.getPierrePossession() > jou.getPierreMaximum()) {
			quantite100pourcentpierre = jou.getPierreMaximum()-jou.getPierrePossession();
			coutGemme = quantite100pourcentpierre / 100;
		}
		
		// CAS GEMMES INSUFISANTES
		if(jou.getGemmePossession()<coutGemme) {
			throw new RessourceManquanteException("Gemmes insuffisantes.");
		}
		
		// SI LIMITE PIERRE ATTEINTE
		if(jou.getPierreMaximum()==jou.getPierrePossession()) {
			throw new RessourceManquanteException("Maximum de pierre atteint.");
		}
		
		// RETRAIT DES GEMMES
		jou.setGemmePossession(jou.getGemmePossession() - coutGemme);
		// AJOUT DE LA PIERRE
		jou.setPierrePossession(jou.getPierrePossession() + quantite100pourcentpierre);
		
		// SAUVEGARDE
		joueurRepo.save(jou);
	}
	
	
	// BOIS
	public void achat10PourcentBois() {
		// RECUPERATION DU JOUEUR
		Joueur jou = joueurService.recuperationJoueur();
		
		// QUANTITEE RESSOURCE CORRESPONDANTE (10%)
		Integer quantite10pourcentbois = (int) (jou.getBoisMaximum()*0.1);
		// CALCUL COUT GEMMES ( montant ressource / 100 )
		Integer coutGemme = quantite10pourcentbois / 100;
		
		// CAS ACHAT DE RESSOURCES SUPÉRIEURE À LA CAPACITÉE DE STOCKAGE
		if(quantite10pourcentbois+jou.getBoisPossession() > jou.getBoisMaximum()) {
			quantite10pourcentbois = jou.getBoisMaximum()-jou.getBoisPossession();
			coutGemme = quantite10pourcentbois / 100;
		}
		
		// CAS GEMMES INSUFISANTES
		if(jou.getGemmePossession()<coutGemme) {
			throw new RessourceManquanteException("Gemmes insuffisantes.");
		}
		
		// SI LIMITE BOIS ATTEINTE
		if(jou.getBoisMaximum()==jou.getBoisPossession()) {
			throw new RessourceManquanteException("Maximum de bois atteint.");
		}
		
		// RETRAIT DES GEMMES
		jou.setGemmePossession(jou.getGemmePossession() - coutGemme);
		// AJOUT DE LA BOIS
		jou.setBoisPossession(jou.getBoisPossession() + quantite10pourcentbois);
		
		// SAUVEGARDE
		joueurRepo.save(jou);
	}
	public void achat50PourcentBois() {
		// RECUPERATION DU JOUEUR
		Joueur jou = joueurService.recuperationJoueur();
		
		// QUANTITEE RESSOURCE CORRESPONDANTE (50%)
		Integer quantite50pourcentbois = (int) (jou.getBoisMaximum()*0.5);
		// CALCUL COUT GEMMES ( montant ressource / 100 )
		Integer coutGemme = quantite50pourcentbois / 100;
		
		// CAS ACHAT DE RESSOURCES SUPÉRIEURE À LA CAPACITÉE DE STOCKAGE
		if(quantite50pourcentbois+jou.getBoisPossession() > jou.getBoisMaximum()) {
			quantite50pourcentbois = jou.getBoisMaximum()-jou.getBoisPossession();
			coutGemme = quantite50pourcentbois / 100;
		}
		
		// CAS GEMMES INSUFISANTES
		if(jou.getGemmePossession()<coutGemme) {
			throw new RessourceManquanteException("Gemmes insuffisantes.");
		}
		
		// SI LIMITE BOIS ATTEINTE
		if(jou.getBoisMaximum()==jou.getBoisPossession()) {
			throw new RessourceManquanteException("Maximum de bois atteint.");
		}
		
		// RETRAIT DES GEMMES
		jou.setGemmePossession(jou.getGemmePossession() - coutGemme);
		// AJOUT DE LA BOIS
		jou.setBoisPossession(jou.getBoisPossession() + quantite50pourcentbois);
		
		// SAUVEGARDE
		joueurRepo.save(jou);
	}
	
	public void achat100PourcentBois() {
		// RECUPERATION DU JOUEUR
		Joueur jou = joueurService.recuperationJoueur();
		
		// QUANTITEE RESSOURCE CORRESPONDANTE (100%)
		Integer quantite100pourcentbois = (int) (jou.getBoisMaximum());
		// CALCUL COUT GEMMES ( montant ressource / 100 )
		Integer coutGemme = quantite100pourcentbois / 100;
		
		// CAS ACHAT DE RESSOURCES SUPÉRIEURE À LA CAPACITÉE DE STOCKAGE
		if(quantite100pourcentbois+jou.getBoisPossession() > jou.getBoisMaximum()) {
			quantite100pourcentbois = jou.getBoisMaximum()-jou.getBoisPossession();
			coutGemme = quantite100pourcentbois / 100;
		}
		
		// CAS GEMMES INSUFISANTES
		if(jou.getGemmePossession()<coutGemme) {
			throw new RessourceManquanteException("Gemmes insuffisantes.");
		}
		
		// SI LIMITE BOIS ATTEINTE
		if(jou.getBoisMaximum()==jou.getBoisPossession()) {
			throw new RessourceManquanteException("Maximum de bois atteint.");
		}
		
		// RETRAIT DES GEMMES
		jou.setGemmePossession(jou.getGemmePossession() - coutGemme);
		// AJOUT DE LA BOIS
		jou.setBoisPossession(jou.getBoisPossession() + quantite100pourcentbois);
		
		// SAUVEGARDE
		joueurRepo.save(jou);
	}
	
	// OR
	public void achat10PourcentOr() {
		// RECUPERATION DU JOUEUR
		Joueur jou = joueurService.recuperationJoueur();
		
		// QUANTITEE RESSOURCE CORRESPONDANTE (10%)
		Integer quantite10pourcentor = (int) (jou.getOrMaximum()*0.1);
		// CALCUL COUT GEMMES ( montant ressource / 100 )
		Integer coutGemme = quantite10pourcentor / 100;
		
		// CAS ACHAT DE RESSOURCES SUPÉRIEURE À LA CAPACITÉE DE STOCKAGE
		if(quantite10pourcentor+jou.getOrPossession() > jou.getOrMaximum()) {
			quantite10pourcentor = jou.getOrMaximum()-jou.getOrPossession();
			coutGemme = quantite10pourcentor / 100;
		}
		
		// CAS GEMMES INSUFISANTES
		if(jou.getGemmePossession()<coutGemme) {
			throw new RessourceManquanteException("Gemmes insuffisantes.");
		}
		
		// SI LIMITE OR ATTEINTE
		if(jou.getOrMaximum()==jou.getOrPossession()) {
			throw new RessourceManquanteException("Maximum de or atteint.");
		}
		
		// RETRAIT DES GEMMES
		jou.setGemmePossession(jou.getGemmePossession() - coutGemme);
		// AJOUT DE LA OR
		jou.setOrPossession(jou.getOrPossession() + quantite10pourcentor);
		
		// SAUVEGARDE
		joueurRepo.save(jou);
	}
	
	public void achat50PourcentOr() {
		// RECUPERATION DU JOUEUR
		Joueur jou = joueurService.recuperationJoueur();
		
		// QUANTITEE RESSOURCE CORRESPONDANTE (50%)
		Integer quantite50pourcentor = (int) (jou.getOrMaximum()*0.5);
		// CALCUL COUT GEMMES ( montant ressource / 100 )
		Integer coutGemme = quantite50pourcentor / 100;
		
		// CAS ACHAT DE RESSOURCES SUPÉRIEURE À LA CAPACITÉE DE STOCKAGE
		if(quantite50pourcentor+jou.getOrPossession() > jou.getOrMaximum()) {
			quantite50pourcentor = jou.getOrMaximum()-jou.getOrPossession();
			coutGemme = quantite50pourcentor / 100;
		}
		
		// CAS GEMMES INSUFISANTES
		if(jou.getGemmePossession()<coutGemme) {
			throw new RessourceManquanteException("Gemmes insuffisantes.");
		}
		
		// SI LIMITE OR ATTEINTE
		if(jou.getOrMaximum()==jou.getOrPossession()) {
			throw new RessourceManquanteException("Maximum de or atteint.");
		}
		
		// RETRAIT DES GEMMES
		jou.setGemmePossession(jou.getGemmePossession() - coutGemme);
		// AJOUT DE LA OR
		jou.setOrPossession(jou.getOrPossession() + quantite50pourcentor);
		
		// SAUVEGARDE
		joueurRepo.save(jou);
	}
	
	public void achat100PourcentOr() {
		// RECUPERATION DU JOUEUR
		Joueur jou = joueurService.recuperationJoueur();
		
		// QUANTITEE RESSOURCE CORRESPONDANTE (100%)
		Integer quantite100pourcentor = (int) (jou.getOrMaximum());
		// CALCUL COUT GEMMES ( montant ressource / 100 )
		Integer coutGemme = quantite100pourcentor / 100;
		
		// CAS ACHAT DE RESSOURCES SUPÉRIEURE À LA CAPACITÉE DE STOCKAGE
		if(quantite100pourcentor+jou.getOrPossession() > jou.getOrMaximum()) {
			quantite100pourcentor = jou.getOrMaximum()-jou.getOrPossession();
			coutGemme = quantite100pourcentor / 100;
		}
		
		// CAS GEMMES INSUFISANTES
		if(jou.getGemmePossession()<coutGemme) {
			throw new RessourceManquanteException("Gemmes insuffisantes.");
		}
		
		// SI LIMITE OR ATTEINTE
		if(jou.getOrMaximum()==jou.getOrPossession()) {
			throw new RessourceManquanteException("Maximum de or atteint.");
		}
		
		// RETRAIT DES GEMMES
		jou.setGemmePossession(jou.getGemmePossession() - coutGemme);
		// AJOUT DE LA OR
		jou.setOrPossession(jou.getOrPossession() + quantite100pourcentor);
		
		// SAUVEGARDE
		joueurRepo.save(jou);
	}
	
	// NOURRITURE
	public void achat10PourcentNourriture() {
		// RECUPERATION DU JOUEUR
		Joueur jou = joueurService.recuperationJoueur();
		
		// QUANTITEE RESSOURCE CORRESPONDANTE (10%)
		Integer quantite10pourcentnourriture = (int) (jou.getNourritureMaximum()*0.1);
		// CALCUL COUT GEMMES ( montant ressource / 100 )
		Integer coutGemme = quantite10pourcentnourriture / 100;
		
		// CAS ACHAT DE RESSOURCES SUPÉRIEURE À LA CAPACITÉE DE STOCKAGE
		if(quantite10pourcentnourriture+jou.getNourriturePossession() > jou.getNourritureMaximum()) {
			quantite10pourcentnourriture = jou.getNourritureMaximum()-jou.getNourriturePossession();
			coutGemme = quantite10pourcentnourriture / 100;
		}
		
		// CAS GEMMES INSUFISANTES
		if(jou.getGemmePossession()<coutGemme) {
			throw new RessourceManquanteException("Gemmes insuffisantes.");
		}
		
		// SI LIMITE NOURRITURE ATTEINTE
		if(jou.getNourritureMaximum()==jou.getNourriturePossession()) {
			throw new RessourceManquanteException("Maximum de nourriture atteint.");
		}
		
		// RETRAIT DES GEMMES
		jou.setGemmePossession(jou.getGemmePossession() - coutGemme);
		// AJOUT DE LA NOURRITURE
		jou.setNourriturePossession(jou.getNourriturePossession() + quantite10pourcentnourriture);
		
		// SAUVEGARDE
		joueurRepo.save(jou);
	}
	
	public void achat50PourcentNourriture() {
		// RECUPERATION DU JOUEUR
		Joueur jou = joueurService.recuperationJoueur();
		
		// QUANTITEE RESSOURCE CORRESPONDANTE (50%)
		Integer quantite50pourcentnourriture = (int) (jou.getNourritureMaximum()*0.5);
		// CALCUL COUT GEMMES ( montant ressource / 100 )
		Integer coutGemme = quantite50pourcentnourriture / 100;
		
		// CAS ACHAT DE RESSOURCES SUPÉRIEURE À LA CAPACITÉE DE STOCKAGE
		if(quantite50pourcentnourriture+jou.getNourriturePossession() > jou.getNourritureMaximum()) {
			quantite50pourcentnourriture = jou.getNourritureMaximum()-jou.getNourriturePossession();
			coutGemme = quantite50pourcentnourriture / 100;
		}
		
		// CAS GEMMES INSUFISANTES
		if(jou.getGemmePossession()<coutGemme) {
			throw new RessourceManquanteException("Gemmes insuffisantes.");
		}
		
		// SI LIMITE NOURRITURE ATTEINTE
		if(jou.getNourritureMaximum()==jou.getNourriturePossession()) {
			throw new RessourceManquanteException("Maximum de nourriture atteint.");
		}
		
		// RETRAIT DES GEMMES
		jou.setGemmePossession(jou.getGemmePossession() - coutGemme);
		// AJOUT DE LA NOURRITURE
		jou.setNourriturePossession(jou.getNourriturePossession() + quantite50pourcentnourriture);
		
		// SAUVEGARDE
		joueurRepo.save(jou);
	}
	
	public void achat100PourcentNourriture() {
		// RECUPERATION DU JOUEUR
		Joueur jou = joueurService.recuperationJoueur();
		
		// QUANTITEE RESSOURCE CORRESPONDANTE (100%)
		Integer quantite100pourcentnourriture = (int) (jou.getNourritureMaximum());
		// CALCUL COUT GEMMES ( montant ressource / 100 )
		Integer coutGemme = quantite100pourcentnourriture / 100;
		
		// CAS ACHAT DE RESSOURCES SUPÉRIEURE À LA CAPACITÉE DE STOCKAGE
		if(quantite100pourcentnourriture+jou.getNourriturePossession() > jou.getNourritureMaximum()) {
			quantite100pourcentnourriture = jou.getNourritureMaximum()-jou.getNourriturePossession();
			coutGemme = quantite100pourcentnourriture / 100;
		}
		
		// CAS GEMMES INSUFISANTES
		if(jou.getGemmePossession()<coutGemme) {
			throw new RessourceManquanteException("Gemmes insuffisantes.");
		}
		
		// SI LIMITE NOURRITURE ATTEINTE
		if(jou.getNourritureMaximum()==jou.getNourriturePossession()) {
			throw new RessourceManquanteException("Maximum de nourriture atteint.");
		}
		
		// RETRAIT DES GEMMES
		jou.setGemmePossession(jou.getGemmePossession() - coutGemme);
		// AJOUT DE LA NOURRITURE
		jou.setNourriturePossession(jou.getNourriturePossession() + quantite100pourcentnourriture);
		
		// SAUVEGARDE
		joueurRepo.save(jou);
	}
	
}
