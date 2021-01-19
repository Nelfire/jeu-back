package dev.repository.expedition;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.entites.expedition.Expedition;

public interface ExpeditionRepo extends JpaRepository<Expedition, Integer> {
	
}
