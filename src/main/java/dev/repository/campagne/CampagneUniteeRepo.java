package dev.repository.campagne;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.entites.campagne.CampagneUnitee;

public interface CampagneUniteeRepo extends JpaRepository<CampagneUnitee, Integer> {
}
