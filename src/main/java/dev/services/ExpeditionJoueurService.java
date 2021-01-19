package dev.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.entites.expedition.Expedition;
import dev.entites.joueur.ExpeditionJoueur;
import dev.repository.expedition.ExpeditionRepo;
import dev.repository.joueur.ExpeditionJoueurRepo;

@Service
public class ExpeditionJoueurService {

	ExpeditionJoueurRepo expeditionJoueurRepo;

	/**
	 * @param expeditionRepo
	 */
	public ExpeditionJoueurService(ExpeditionJoueurRepo expeditionJoueurRepo) {
		super();
		this.expeditionJoueurRepo = expeditionJoueurRepo;
	}
	
	// Lister les expéditions
	public List<ExpeditionJoueur> listerExpeditionJoueur() {
		List<ExpeditionJoueur> listeExpeditionJoueur = new ArrayList<>();
		for (ExpeditionJoueur expedition : expeditionJoueurRepo.findAll()) {
			listeExpeditionJoueur.add(expedition);
		}
		return listeExpeditionJoueur;
	}
	
}
