package dev.repository.joueur;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.entites.joueur.Armee;
import dev.entites.joueur.Joueur;

public interface ArmeeRepo extends JpaRepository<Armee, Integer> {

	List<Armee> findByJoueur(Joueur joueur);
	
	@Query("SELECT a FROM Armee a WHERE a.joueur = ?1 ORDER BY a.unitee.attaque ASC")
	List<Armee> findByJoueurByOrderByAttaqueAsc(Joueur joueur);
}
