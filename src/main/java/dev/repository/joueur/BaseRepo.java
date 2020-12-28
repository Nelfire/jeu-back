package dev.repository.joueur;


import org.springframework.data.jpa.repository.JpaRepository;

import dev.entites.joueur.Base;

public interface BaseRepo extends JpaRepository<Base, Integer> {

}
