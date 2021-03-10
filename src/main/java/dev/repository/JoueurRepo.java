package dev.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import dev.entites.joueur.Joueur;

/**
 * Repository Joueur
 */
public interface JoueurRepo extends JpaRepository<Joueur, Integer> {

	Boolean existsByPseudo(String pseudo);

	Optional<Joueur> findByEmail(String email);

	Boolean existsByEmail(String email);

}
