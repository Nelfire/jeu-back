package dev.repository.batiment.stockage;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entites.batiment.stockage.Grenier;


public interface GrenierRepo extends JpaRepository<Grenier, Integer> {

}
