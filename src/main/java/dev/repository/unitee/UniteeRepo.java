package dev.repository.unitee;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import dev.entites.unitee.Unitee;

public interface UniteeRepo extends JpaRepository<Unitee, Integer> {
	
	Optional<Unitee> findById(Integer id);

}
