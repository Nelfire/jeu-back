package dev.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import dev.controller.dto.ArmeeDto;
import dev.controller.dto.UniteeDto;
import dev.entites.Joueur;
import dev.entites.joueur.Armee;
import dev.entites.unitee.Unitee;
import dev.repository.joueur.ArmeeRepo;

@Service
public class ArmeeService {

	JoueurService joueurService;
	UniteeService uniteeService;
	ArmeeRepo armeeRepo;
	
	/**
	 * @param joueurService
	 * @param armeeRepo
	 */
	public ArmeeService(JoueurService joueurService, ArmeeRepo armeeRepo, UniteeService uniteeService) {
		super();
		this.joueurService = joueurService;
		this.armeeRepo = armeeRepo;
		this.uniteeService = uniteeService;
	}

	public Integer produireUnitee(Integer quantitee, Integer idUnitee) {
		// Récupération des infos joueur (Pour soustraire les ressources).
		Joueur jou = this.joueurService.recuperationJoueur();
		
		// Informations sur l'unitée que le joueur veut créer
		UniteeDto unit = this.uniteeService.detailsUnitee(idUnitee);

		// Récupération de l'armée du joueur
		ArmeeDto armee = armeeRepo.findByJoueur(jou);
		
		// Récupération des unitées du joueur
		Map<UniteeDto, Integer> unitees = armee.getUnitee();
		unitees.put(unit, 1);
		armee.setUnitee(null);
		return null;
	}
}
