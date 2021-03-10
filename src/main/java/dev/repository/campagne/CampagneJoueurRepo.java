package dev.repository.campagne;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import dev.entites.campagne.CampagneJoueur;
import dev.entites.joueur.Joueur;

/**
 * Repository Campagne Joueur
 */
public interface CampagneJoueurRepo extends JpaRepository<CampagneJoueur, Integer> {
	List<CampagneJoueur> findByJoueur(Joueur joueur);
}
