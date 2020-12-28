package dev.repository.batiment.stockage;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entites.batiment.stockage.Banque;


public interface BanqueRepo extends JpaRepository<Banque, Integer> {

}
