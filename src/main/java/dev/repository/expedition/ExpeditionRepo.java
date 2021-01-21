package dev.repository.expedition;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.entites.expedition.Expedition;

public interface ExpeditionRepo extends JpaRepository<Expedition, Integer> {
	Optional<Expedition> findById(Integer id);
}
