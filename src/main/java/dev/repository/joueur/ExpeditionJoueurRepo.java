package dev.repository.joueur;


import org.springframework.data.jpa.repository.JpaRepository;

import dev.entites.joueur.ExpeditionJoueur;


public interface ExpeditionJoueurRepo extends JpaRepository<ExpeditionJoueur, Integer> {
	
}
