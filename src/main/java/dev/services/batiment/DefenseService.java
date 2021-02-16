package dev.services.batiment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import dev.controller.dto.batiment.BatimentDto;
import dev.controller.dto.batiment.DefenseDto;
import dev.entites.batiment.Batiment;
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
	
	
//	/**
//	 * DETAIL D'UNE DEFENSE (Via ID)
//	 */
//	public DefenseDto detailsDefense(Integer idDefense) {
//		Optional<Defense> defense = defenseRepo.findById(idDefense);
//		DefenseDto def = new DefenseDto(defense.get());
//		return def;
//	}
	/**
	 * DETAIL D'UNE DEFENSE (Via ID)
	 */
	public DefenseDto detailsDefense(Integer idDefense) {
		Optional<Defense> defense = defenseRepo.findById(idDefense);
		DefenseDto def = new DefenseDto(defense.get().getIdTypeDefense(),defense.get().getTypeDefense(),defense.get().getIcone(),defense.get().getLibelle(),defense.get().getDescription(),defense.get().getCoutPierreConstruction(),defense.get().getCoutBoisConstruction(),defense.get().getCoutOrConstruction(),defense.get().getCoutNourritureConstruction(),defense.get().getVie(),defense.get().getAttaque(),defense.get().getBouclier(),defense.get().getTempsConstruction(),defense.get().getNiveauBatimentNecessaireConstruction(),defense.get().getIdBatimentProvenance());
		return def;
	}

	/**
	 * MODIFICATION D'UNE DEFENSE (Menu administrateur, Via ID)
	 */
	public DefenseDto administrationModificationDefense(@Valid DefenseDto defenseDto, Integer id) {
		DefenseDto defense = this.detailsDefense(id);

		defense.setId(defenseDto.getId());
		defense.setIdTypeDefense(defenseDto.getIdTypeDefense());
		defense.setTypeDefense(defenseDto.getTypeDefense());
		defense.setIcone(defenseDto.getIcone());
		defense.setLibelle(defenseDto.getLibelle());
		defense.setDescription(defenseDto.getDescription());
		defense.setCoutPierreConstruction(defenseDto.getCoutPierreConstruction());
		defense.setCoutBoisConstruction(defenseDto.getCoutBoisConstruction());
		defense.setCoutOrConstruction(defenseDto.getCoutOrConstruction());
		defense.setCoutNourritureConstruction(defenseDto.getCoutNourritureConstruction());
		defense.setVie(defenseDto.getVie());
		defense.setAttaque(defenseDto.getAttaque());
		defense.setBouclier(defenseDto.getBouclier());
		defense.setTempsConstruction(defenseDto.getTempsConstruction());
		defense.setNiveauBatimentNecessaireConstruction(defenseDto.getNiveauBatimentNecessaireConstruction());
		defense.setIdBatimentProvenance(defenseDto.getIdBatimentProvenance());


		Defense def = new Defense(
				defense.getIdTypeDefense(),
				defense.getTypeDefense(),
				defense.getIcone(),
				defense.getLibelle(),
				defense.getDescription(),
				defense.getCoutPierreConstruction(),
				defense.getCoutBoisConstruction(),
				defense.getCoutOrConstruction(),
				defense.getCoutNourritureConstruction(),
				defense.getVie(),
				defense.getAttaque(),
				defense.getBouclier(),
				defense.getTempsConstruction(),
				defense.getNiveauBatimentNecessaireConstruction(),
				defense.getIdBatimentProvenance());
		def.setId(defense.getId());
		this.defenseRepo.save(def);
		return defense;
	}
}
