package dev.services.batiment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import dev.controller.dto.batiment.DefenseDto;
import dev.entites.batiment.Defense;
import dev.repository.batiment.DefenseRepo;

@Service
public class DefenseService {
	
	private DefenseRepo defenseRepo;
	
	public DefenseService(DefenseRepo defenseRepo) {
		this.defenseRepo = defenseRepo;
	}
	
	
	/**
	 * LISTE LES DIFFERENTS TYPES DE DEFENSE
	 */
	public List<Defense> listerDefense() {
		List<Defense> listeDefenses = new ArrayList<>();
		
		for (Defense defense : defenseRepo.findAll()) {
			listeDefenses.add(defense);
		}
		
		return listeDefenses;
	}
	
	
	/**
	 * DETAIL D'UNE DEFENSE (Via ID)
	 */
	public DefenseDto detailsDefense(Integer idDefense) {
		Optional<Defense> defense = defenseRepo.findById(idDefense);
		DefenseDto def = new DefenseDto(defense.get());
		return def;
	}

}
