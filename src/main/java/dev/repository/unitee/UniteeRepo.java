package dev.repository.unitee;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entites.batiment.Batiment;
import dev.entites.unitee.Unitee;


public interface UniteeRepo extends JpaRepository<Unitee, Integer> {

}
