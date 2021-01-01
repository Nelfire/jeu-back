package dev.repository.joueur;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.entites.joueur.BatimentJoueur;


public interface BatimentJoueurRepo extends JpaRepository<BatimentJoueur, Integer> {

	List<BatimentJoueur> findByJoueurId(Integer id);
}
