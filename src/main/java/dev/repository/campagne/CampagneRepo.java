package dev.repository.campagne;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import dev.entites.campagne.Campagne;

/**
 * Repository Campagne
 */
public interface CampagneRepo extends JpaRepository<Campagne, Integer> {
	Optional<Campagne> findById(Integer id);

	List<Campagne> findByMonde(Integer id);
}
