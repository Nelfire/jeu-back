package dev.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entites.Joueur;

public interface JoueurRepo extends JpaRepository<Joueur, Integer> {

    Optional<Joueur> findByEmail(String email);
}
