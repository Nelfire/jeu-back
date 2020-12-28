package dev.repository.batiment.millitaire;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entites.batiment.millitaire.Ecurie;


public interface EcurieRepo extends JpaRepository<Ecurie, Integer> {

}
