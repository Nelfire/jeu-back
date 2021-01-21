package dev.repository.joueur;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entites.Joueur;
import dev.entites.joueur.ExpeditionJoueur;


public interface ExpeditionJoueurRepo extends JpaRepository<ExpeditionJoueur, Integer> {
	
	List<ExpeditionJoueur> findByJoueur(Joueur joueur);
}
