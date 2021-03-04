package dev.repository.campagne;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.entites.campagne.Campagne;
import dev.entites.expedition.Expedition;

public interface CampagneRepo extends JpaRepository<Campagne, Integer> {
	Optional<Campagne> findById(Integer id);
}
