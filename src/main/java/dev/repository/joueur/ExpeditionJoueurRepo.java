package dev.repository.joueur;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import dev.entites.expedition.ExpeditionJoueur;
import dev.entites.joueur.Joueur;

/**
 * Repository Expédition Joueur
 */
public interface ExpeditionJoueurRepo extends JpaRepository<ExpeditionJoueur, Integer> {

	List<ExpeditionJoueur> findByJoueur(Joueur joueur);
}
