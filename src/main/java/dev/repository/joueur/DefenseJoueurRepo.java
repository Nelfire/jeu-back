package dev.repository.joueur;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import dev.entites.batiment.DefenseJoueur;
import dev.entites.joueur.Joueur;

/**
 * Repository Défense Joueur
 */
public interface DefenseJoueurRepo extends JpaRepository<DefenseJoueur, Integer> {

	List<DefenseJoueur> findByJoueur(Joueur joueur);

}
