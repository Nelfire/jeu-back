package dev.repository.joueur;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import dev.entites.joueur.Armee;
import dev.entites.joueur.Joueur;

public interface ArmeeRepo extends JpaRepository<Armee, Integer> {
	
	List<Armee> findByJoueur(Joueur joueur);
}
