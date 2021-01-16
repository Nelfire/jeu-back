package dev.repository.joueur;


import org.springframework.data.jpa.repository.JpaRepository;

import dev.controller.dto.ArmeeDto;
import dev.entites.Joueur;
import dev.entites.joueur.Armee;

public interface ArmeeRepo extends JpaRepository<Armee, Integer> {
	ArmeeDto findByJoueur(Joueur joueur);
}
