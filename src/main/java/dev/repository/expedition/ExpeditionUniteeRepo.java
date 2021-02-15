package dev.repository.expedition;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.entites.expedition.ExpeditionUnitee;

public interface ExpeditionUniteeRepo extends JpaRepository<ExpeditionUnitee, Integer> {
	
	
}
