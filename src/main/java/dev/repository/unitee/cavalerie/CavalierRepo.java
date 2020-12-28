package dev.repository.unitee.cavalerie;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entites.unitee.cavalerie.Cavalier;

public interface CavalierRepo extends JpaRepository<Cavalier, Integer> {

}
