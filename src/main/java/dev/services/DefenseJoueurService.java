package dev.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.entites.joueur.DefenseJoueur;
import dev.repository.joueur.DefenseJoueurRepo;

@Service
public class DefenseJoueurService {

	private DefenseJoueurRepo defenseJoueurRepo;
	
	/**
	 * @param defenseJoueurRepo
	 */
	public DefenseJoueurService(DefenseJoueurRepo defenseJoueurRepo) {
		super();
		this.defenseJoueurRepo = defenseJoueurRepo;
	}
	

	public List<DefenseJoueur> listerMesDefenses() {
		List<DefenseJoueur> listeDefensesJoueur = new ArrayList<>();
		
		for (DefenseJoueur defenseJoueur : defenseJoueurRepo.findAll()) {
			listeDefensesJoueur.add(defenseJoueur);
		}
		
		return listeDefensesJoueur;
	}
}
