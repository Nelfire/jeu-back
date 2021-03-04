package dev.repository.campagne;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entites.campagne.Campagne;
import dev.entites.campagne.CampagneArmee;
import dev.entites.expedition.Expedition;

public interface CampagneArmeeRepo extends JpaRepository<CampagneArmee, Integer> {

}
