package dev.repository.joueur;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import dev.entites.Joueur;
import dev.entites.joueur.Armee;

public interface ArmeeRepo extends JpaRepository<Armee, Integer> {
	
	List<Armee> findByJoueur(Joueur joueur);
}
