package dev.repository.joueur;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entites.Joueur;
import dev.entites.joueur.BatimentJoueur;


public interface BatimentJoueurRepo extends JpaRepository<BatimentJoueur, Integer> {

	List<BatimentJoueur> findByJoueur(Joueur joueur);
	
}
