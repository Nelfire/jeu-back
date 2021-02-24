package dev.repository.batiment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.entites.batiment.Batiment;

public interface BatimentRepo extends JpaRepository<Batiment, Integer> {

	Batiment findByIdTypeBatiment(Integer idTypeBatiment);
	
	List<Batiment> findByIdCategorieBatiment(Integer idCategorieBatiment);
	
	List<Batiment> findAllByOrderByIdTypeBatimentAsc();
}
