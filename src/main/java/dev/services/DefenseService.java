package dev.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

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

}
