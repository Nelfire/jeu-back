package dev.repository.batiment;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entites.batiment.Batiment;


public interface BatimentRepo extends JpaRepository<Batiment, Integer> {

}
