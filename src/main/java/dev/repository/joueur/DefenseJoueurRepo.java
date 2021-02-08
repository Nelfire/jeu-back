package dev.repository.joueur;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entites.Joueur;
import dev.entites.joueur.DefenseJoueur;

public interface DefenseJoueurRepo extends JpaRepository<DefenseJoueur, Integer> {

	List<DefenseJoueur> findByJoueur(Joueur joueur);

}

