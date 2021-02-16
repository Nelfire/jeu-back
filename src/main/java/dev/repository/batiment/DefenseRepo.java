package dev.repository.batiment;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entites.batiment.Defense;

public interface DefenseRepo extends JpaRepository<Defense, Integer> {

	Defense findByIdTypeDefense(Integer idTypeDefense);
	List<Defense> findByTypeDefense(Integer idCategorieBatiment);
}

