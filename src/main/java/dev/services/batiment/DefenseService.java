package dev.services.batiment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.stereotype.Service;
import dev.controller.dto.batiment.DefenseDto;
import dev.entites.batiment.Defense;
import dev.repository.batiment.DefenseRepo;

@Service
public class DefenseService {

	private DefenseRepo defenseRepo;

	/**
	 * @param defenseRepo
	 */
	public DefenseService(DefenseRepo defenseRepo) {
		this.defenseRepo = defenseRepo;
	}

	/**
	 * LISTE LES DIFFERENTS TYPES DE DEFENSE
	 */
	public List<Defense> listerDefense() {

		// INITIALISATIONS
		List<Defense> listeDefenses = new ArrayList<>();

		// PARCOURS DE TOUTES LES DEFENSES
		for (Defense defense : defenseRepo.findAll()) {
			listeDefenses.add(defense);
		}

		// RETOUR
		return listeDefenses;
	}

	/**
	 * LISTER QUE LES DEFENSES DE TYPE OFFENSIVE = 1
	 */
	public List<Defense> listerDefensesOffensive() {

		// INITIALISATIONS
		List<Defense> listeDefensesOffensive = new ArrayList<>();

		// PARCOURS DE TOUTES LES DEFENSES (Type 1)
		for (Defense defense : defenseRepo.findByTypeDefense(1)) {
			listeDefensesOffensive.add(defense);
		}

		// RETOUR
		return listeDefensesOffensive;
	}

	/**
	 * LISTER QUE LES DEFENSES DE TYPE DEFENSIVE = 2
	 */
	public List<Defense> listerDefensesDefensive() {

		// INITIALISATIONS
		List<Defense> listeDefensesDefensive = new ArrayList<>();

		// PARCOURS DE TOUTES LES DEFENSES (Type 2)
		for (Defense defense : defenseRepo.findByTypeDefense(2)) {
			listeDefensesDefensive.add(defense);
		}

		// RETOUR
		return listeDefensesDefensive;
	}

	/**
	 * DETAIL D'UNE DEFENSE (Via ID)
	 */
	public DefenseDto detailsDefense(Integer idDefense) {

		// RECHERCHE D'UNE DEFENSE PAR ID
		Optional<Defense> defense = defenseRepo.findById(idDefense);
		DefenseDto def = new DefenseDto(defense.get().getIdTypeDefense(), defense.get().getTypeDefense(),
				defense.get().getIcone(), defense.get().getLibelle(), defense.get().getDescription(),
				defense.get().getCoutPierreConstruction(), defense.get().getCoutBoisConstruction(),
				defense.get().getCoutOrConstruction(), defense.get().getCoutNourritureConstruction(),
				defense.get().getVie(), defense.get().getAttaque(), defense.get().getPortee(),
				defense.get().getArmure(), defense.get().getTempsConstruction(),
				defense.get().getNiveauBatimentNecessaireConstruction(), defense.get().getIdBatimentProvenance(),
				defense.get().getApportExperience());

		// RETOUR
		return def;
	}

	/**
	 * MODIFICATION D'UNE DEFENSE (Menu administrateur, Via ID)
	 */
	public DefenseDto administrationModificationDefense(@Valid DefenseDto defenseDto, Integer id) {
		
		// RECHERCHE D'UNE DEFENSE PAR ID
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
		defense.setPortee(defenseDto.getPortee());
		defense.setArmure(defenseDto.getArmure());
		defense.setTempsConstruction(defenseDto.getTempsConstruction());
		defense.setNiveauBatimentNecessaireConstruction(defenseDto.getNiveauBatimentNecessaireConstruction());
		defense.setIdBatimentProvenance(defenseDto.getIdBatimentProvenance());
		defense.setApportExperience(defenseDto.getApportExperience());

		Defense def = new Defense(defense.getIdTypeDefense(), defense.getTypeDefense(), defense.getIcone(),
				defense.getLibelle(), defense.getDescription(), defense.getCoutPierreConstruction(),
				defense.getCoutBoisConstruction(), defense.getCoutOrConstruction(),
				defense.getCoutNourritureConstruction(), defense.getVie(), defense.getAttaque(), defense.getPortee(),
				defense.getArmure(), defense.getTempsConstruction(), defense.getNiveauBatimentNecessaireConstruction(),
				defense.getIdBatimentProvenance(), defense.getApportExperience());
		def.setId(defense.getId());
		
		// SAUVEGARDE
		this.defenseRepo.save(def);
		
		// RETOUR
		return defense;
	}
}
