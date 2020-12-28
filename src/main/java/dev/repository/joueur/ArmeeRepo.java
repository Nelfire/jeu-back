package dev.repository.joueur;


import org.springframework.data.jpa.repository.JpaRepository;

import dev.entites.joueur.Armee;

public interface ArmeeRepo extends JpaRepository<Armee, Integer> {

}
