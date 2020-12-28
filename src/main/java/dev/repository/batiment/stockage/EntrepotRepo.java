package dev.repository.batiment.stockage;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entites.batiment.stockage.Entrepot;


public interface EntrepotRepo extends JpaRepository<Entrepot, Integer> {

}
