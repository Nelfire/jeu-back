package dev.services.unitee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.stereotype.Service;

import dev.controller.dto.unitee.UniteeDto;
import dev.entites.unitee.Unitee;
import dev.repository.unitee.UniteeRepo;
import dev.services.joueur.JoueurService;

@Service
public class UniteeService {

	UniteeRepo uniteeRepo;
	JoueurService joueurService;
	/**
	 * @param uniteeControler
	 * @param uniteeRepo
	 */
	public UniteeService(UniteeRepo uniteeRepo, JoueurService joueurService) {
		super();
		this.uniteeRepo = uniteeRepo;
		this.joueurService = joueurService;
	}
	
	/**
	 * CREATION D'UN NOUVEAU TYPE D'UNITEE (Menu administrateur)
	 */
	public Unitee administrationCreerUnitee(Unitee unitee) {
		Unitee unite = new Unitee(unitee.getIdTypeUnitee(),unitee.getIdBatimentProvenance(),unitee.getIcone(),unitee.getLibelle() ,unitee.getDescriptif(), unitee.getCoutPierreFormation(), unitee.getCoutBoisFormation(), unitee.getCoutOrFormation(), unitee.getCoutNourritureFormation(), unitee.getCoutHumain(), unitee.getTempsFormation(), unitee.getVie(), unitee.getAttaque(), unitee.getPortee(), unitee.getArmure(), unitee.getVitesse(), unitee.getNiveauBatimentNecessaireFormation(), unitee.getApportRessourcePierreHeure(), unitee.getApportRessourceBoisHeure(), unitee.getApportRessourceOrHeure(), unitee.getApportRessourceNourritureHeure(), unitee.getApportExperience());
		uniteeRepo.save(unite);
		return unite;
	}
	
	/**
	 * LISTER TOUTES LES UNITEES EXISTANTES
	 */
	public List<UniteeDto> listerDifferentesUnitees() {
		List<UniteeDto> listeUnitees = new ArrayList<>();
		for (Unitee unitee : uniteeRepo.findAllByOrderByAttaqueAsc()) {
			UniteeDto uniteeDto = new UniteeDto();
			uniteeDto.setId(unitee.getId());
			uniteeDto.setIdTypeUnitee(unitee.getIdTypeUnitee());
			uniteeDto.setIdBatimentProvenance(unitee.getIdBatimentProvenance());
			uniteeDto.setIcone(unitee.getIcone());
			uniteeDto.setLibelle(unitee.getLibelle());
			uniteeDto.setDescriptif(unitee.getDescriptif());
			uniteeDto.setCoutPierreFormation(unitee.getCoutPierreFormation());
			uniteeDto.setCoutBoisFormation(unitee.getCoutBoisFormation());
			uniteeDto.setCoutOrFormation(unitee.getCoutOrFormation());
			uniteeDto.setCoutNourritureFormation(unitee.getCoutNourritureFormation());
			uniteeDto.setCoutHumain(unitee.getCoutHumain());
			uniteeDto.setTempsFormation(unitee.getTempsFormation());
			uniteeDto.setVie(unitee.getVie());
			uniteeDto.setAttaque(unitee.getAttaque());
			uniteeDto.setPortee(unitee.getPortee());
			uniteeDto.setArmure(unitee.getArmure());
			uniteeDto.setVitesse(unitee.getVitesse());
			uniteeDto.setNiveauBatimentNecessaireFormation(unitee.getNiveauBatimentNecessaireFormation());
			uniteeDto.setApportRessourcePierreHeure(unitee.getApportRessourcePierreHeure());
			uniteeDto.setApportRessourceBoisHeure(unitee.getApportRessourceBoisHeure());
			uniteeDto.setApportRessourceOrHeure(unitee.getApportRessourceOrHeure());
			uniteeDto.setApportRessourceNourritureHeure(unitee.getApportRessourceNourritureHeure());
			uniteeDto.setApportExperience(unitee.getApportExperience());
			listeUnitees.add(uniteeDto);
		}
		return listeUnitees;
	}
	
	/**
	 * LISTER QUE LES UNITEES DE TYPE DIVERS = 1
	 */
	public List<UniteeDto> listerUniteeDivers() {
		List<UniteeDto> listeUniteeDivers = new ArrayList<>();
		for (Unitee unitee : uniteeRepo.findByIdTypeUnitee(1)) {
			UniteeDto uniteeDto = new UniteeDto();
			uniteeDto.setId(unitee.getId());
			uniteeDto.setIdTypeUnitee(unitee.getIdTypeUnitee());
			uniteeDto.setIdBatimentProvenance(unitee.getIdBatimentProvenance());
			uniteeDto.setIcone(unitee.getIcone());
			uniteeDto.setLibelle(unitee.getLibelle());
			uniteeDto.setDescriptif(unitee.getDescriptif());
			uniteeDto.setCoutPierreFormation(unitee.getCoutPierreFormation());
			uniteeDto.setCoutBoisFormation(unitee.getCoutBoisFormation());
			uniteeDto.setCoutOrFormation(unitee.getCoutOrFormation());
			uniteeDto.setCoutNourritureFormation(unitee.getCoutNourritureFormation());
			uniteeDto.setCoutHumain(unitee.getCoutHumain());
			uniteeDto.setTempsFormation(unitee.getTempsFormation());
			uniteeDto.setVie(unitee.getVie());
			uniteeDto.setAttaque(unitee.getAttaque());
			uniteeDto.setPortee(unitee.getPortee());
			uniteeDto.setArmure(unitee.getArmure());
			uniteeDto.setVitesse(unitee.getVitesse());
			uniteeDto.setNiveauBatimentNecessaireFormation(unitee.getNiveauBatimentNecessaireFormation());
			uniteeDto.setApportRessourcePierreHeure(unitee.getApportRessourcePierreHeure());
			uniteeDto.setApportRessourceBoisHeure(unitee.getApportRessourceBoisHeure());
			uniteeDto.setApportRessourceOrHeure(unitee.getApportRessourceOrHeure());
			uniteeDto.setApportRessourceNourritureHeure(unitee.getApportRessourceNourritureHeure());
			uniteeDto.setApportExperience(unitee.getApportExperience());
			listeUniteeDivers.add(uniteeDto);
		}
		return listeUniteeDivers;
	}
	
	/**
	 * LISTER QUE LES UNITEES DE TYPE INFANTERIE = 2
	 */
	public List<UniteeDto> listerUniteeInfanterie() {
		List<UniteeDto> listeUniteeInfanterie = new ArrayList<>();
		for (Unitee unitee : uniteeRepo.findByIdTypeUnitee(2)) {
			UniteeDto uniteeDto = new UniteeDto();
			uniteeDto.setId(unitee.getId());
			uniteeDto.setIdTypeUnitee(unitee.getIdTypeUnitee());
			uniteeDto.setIdBatimentProvenance(unitee.getIdBatimentProvenance());
			uniteeDto.setIcone(unitee.getIcone());
			uniteeDto.setLibelle(unitee.getLibelle());
			uniteeDto.setDescriptif(unitee.getDescriptif());
			uniteeDto.setCoutPierreFormation(unitee.getCoutPierreFormation());
			uniteeDto.setCoutBoisFormation(unitee.getCoutBoisFormation());
			uniteeDto.setCoutOrFormation(unitee.getCoutOrFormation());
			uniteeDto.setCoutNourritureFormation(unitee.getCoutNourritureFormation());
			uniteeDto.setCoutHumain(unitee.getCoutHumain());
			uniteeDto.setTempsFormation(unitee.getTempsFormation());
			uniteeDto.setVie(unitee.getVie());
			uniteeDto.setAttaque(unitee.getAttaque());
			uniteeDto.setPortee(unitee.getPortee());
			uniteeDto.setArmure(unitee.getArmure());
			uniteeDto.setVitesse(unitee.getVitesse());
			uniteeDto.setNiveauBatimentNecessaireFormation(unitee.getNiveauBatimentNecessaireFormation());
			uniteeDto.setApportRessourcePierreHeure(unitee.getApportRessourcePierreHeure());
			uniteeDto.setApportRessourceBoisHeure(unitee.getApportRessourceBoisHeure());
			uniteeDto.setApportRessourceOrHeure(unitee.getApportRessourceOrHeure());
			uniteeDto.setApportRessourceNourritureHeure(unitee.getApportRessourceNourritureHeure());
			uniteeDto.setApportExperience(unitee.getApportExperience());
			listeUniteeInfanterie.add(uniteeDto);
		}
		return listeUniteeInfanterie;
	}
	
	/**
	 * LISTER QUE LES UNITEES DE TYPE CAVALERIE = 3
	 */
	public List<UniteeDto> listerUniteeCavalerie() {
		List<UniteeDto> listeUniteeCavalerie = new ArrayList<>();
		for (Unitee unitee : uniteeRepo.findByIdTypeUnitee(3)) {
			UniteeDto uniteeDto = new UniteeDto();
			uniteeDto.setId(unitee.getId());
			uniteeDto.setIdTypeUnitee(unitee.getIdTypeUnitee());
			uniteeDto.setIdBatimentProvenance(unitee.getIdBatimentProvenance());
			uniteeDto.setIcone(unitee.getIcone());
			uniteeDto.setLibelle(unitee.getLibelle());
			uniteeDto.setDescriptif(unitee.getDescriptif());
			uniteeDto.setCoutPierreFormation(unitee.getCoutPierreFormation());
			uniteeDto.setCoutBoisFormation(unitee.getCoutBoisFormation());
			uniteeDto.setCoutOrFormation(unitee.getCoutOrFormation());
			uniteeDto.setCoutNourritureFormation(unitee.getCoutNourritureFormation());
			uniteeDto.setCoutHumain(unitee.getCoutHumain());
			uniteeDto.setTempsFormation(unitee.getTempsFormation());
			uniteeDto.setVie(unitee.getVie());
			uniteeDto.setAttaque(unitee.getAttaque());
			uniteeDto.setPortee(unitee.getPortee());
			uniteeDto.setArmure(unitee.getArmure());
			uniteeDto.setVitesse(unitee.getVitesse());
			uniteeDto.setNiveauBatimentNecessaireFormation(unitee.getNiveauBatimentNecessaireFormation());
			uniteeDto.setApportRessourcePierreHeure(unitee.getApportRessourcePierreHeure());
			uniteeDto.setApportRessourceBoisHeure(unitee.getApportRessourceBoisHeure());
			uniteeDto.setApportRessourceOrHeure(unitee.getApportRessourceOrHeure());
			uniteeDto.setApportRessourceNourritureHeure(unitee.getApportRessourceNourritureHeure());
			uniteeDto.setApportExperience(unitee.getApportExperience());
			listeUniteeCavalerie.add(uniteeDto);
		}
		return listeUniteeCavalerie;
	}
	
	/**
	 * LISTER QUE LES UNITEES DE TYPE SIEGE = 4
	 */
	public List<UniteeDto> listerUniteeSiege() {
		List<UniteeDto> listeUniteeSiege = new ArrayList<>();
		for (Unitee unitee : uniteeRepo.findByIdTypeUnitee(4)) {
			UniteeDto uniteeDto = new UniteeDto();
			uniteeDto.setId(unitee.getId());
			uniteeDto.setIdTypeUnitee(unitee.getIdTypeUnitee());
			uniteeDto.setIdBatimentProvenance(unitee.getIdBatimentProvenance());
			uniteeDto.setIcone(unitee.getIcone());
			uniteeDto.setLibelle(unitee.getLibelle());
			uniteeDto.setDescriptif(unitee.getDescriptif());
			uniteeDto.setCoutPierreFormation(unitee.getCoutPierreFormation());
			uniteeDto.setCoutBoisFormation(unitee.getCoutBoisFormation());
			uniteeDto.setCoutOrFormation(unitee.getCoutOrFormation());
			uniteeDto.setCoutNourritureFormation(unitee.getCoutNourritureFormation());
			uniteeDto.setCoutHumain(unitee.getCoutHumain());
			uniteeDto.setTempsFormation(unitee.getTempsFormation());
			uniteeDto.setVie(unitee.getVie());
			uniteeDto.setAttaque(unitee.getAttaque());
			uniteeDto.setPortee(unitee.getPortee());
			uniteeDto.setArmure(unitee.getArmure());
			uniteeDto.setVitesse(unitee.getVitesse());
			uniteeDto.setNiveauBatimentNecessaireFormation(unitee.getNiveauBatimentNecessaireFormation());
			uniteeDto.setApportRessourcePierreHeure(unitee.getApportRessourcePierreHeure());
			uniteeDto.setApportRessourceBoisHeure(unitee.getApportRessourceBoisHeure());
			uniteeDto.setApportRessourceOrHeure(unitee.getApportRessourceOrHeure());
			uniteeDto.setApportRessourceNourritureHeure(unitee.getApportRessourceNourritureHeure());
			uniteeDto.setApportExperience(unitee.getApportExperience());
			listeUniteeSiege.add(uniteeDto);
		}
		return listeUniteeSiege;
	}
	
	/**
	 * LISTER QUE LES UNITEES DE TYPE NAVALE = 5
	 */
	public List<UniteeDto> listerUniteeNavale() {
		List<UniteeDto> listeUniteeNavale = new ArrayList<>();
		for (Unitee unitee : uniteeRepo.findByIdTypeUnitee(5)) {
			UniteeDto uniteeDto = new UniteeDto();
			uniteeDto.setId(unitee.getId());
			uniteeDto.setIdTypeUnitee(unitee.getIdTypeUnitee());
			uniteeDto.setIdBatimentProvenance(unitee.getIdBatimentProvenance());
			uniteeDto.setIcone(unitee.getIcone());
			uniteeDto.setLibelle(unitee.getLibelle());
			uniteeDto.setDescriptif(unitee.getDescriptif());
			uniteeDto.setCoutPierreFormation(unitee.getCoutPierreFormation());
			uniteeDto.setCoutBoisFormation(unitee.getCoutBoisFormation());
			uniteeDto.setCoutOrFormation(unitee.getCoutOrFormation());
			uniteeDto.setCoutNourritureFormation(unitee.getCoutNourritureFormation());
			uniteeDto.setCoutHumain(unitee.getCoutHumain());
			uniteeDto.setTempsFormation(unitee.getTempsFormation());
			uniteeDto.setVie(unitee.getVie());
			uniteeDto.setAttaque(unitee.getAttaque());
			uniteeDto.setPortee(unitee.getPortee());
			uniteeDto.setArmure(unitee.getArmure());
			uniteeDto.setVitesse(unitee.getVitesse());
			uniteeDto.setNiveauBatimentNecessaireFormation(unitee.getNiveauBatimentNecessaireFormation());
			uniteeDto.setApportRessourcePierreHeure(unitee.getApportRessourcePierreHeure());
			uniteeDto.setApportRessourceBoisHeure(unitee.getApportRessourceBoisHeure());
			uniteeDto.setApportRessourceOrHeure(unitee.getApportRessourceOrHeure());
			uniteeDto.setApportRessourceNourritureHeure(unitee.getApportRessourceNourritureHeure());
			uniteeDto.setApportExperience(unitee.getApportExperience());
			listeUniteeNavale.add(uniteeDto);
		}
		return listeUniteeNavale;
	}
	
	/**
	 * DETAIL D'UN UNITEE (Via ID)
	 */
	public UniteeDto detailsUnitee(Integer idUnitee) {
		Optional<Unitee> unitee = uniteeRepo.findById(idUnitee);
		UniteeDto uni = new UniteeDto(unitee.get());
		return uni;
	}
	
	/**
	 * MODIFICATION D'UN TYPE D'UNITEE (Menu administrateur, Via ID)
	 */
	public UniteeDto administrationModificationUnitee(@Valid UniteeDto uniteeDto, Integer id) {
		UniteeDto unitee = this.detailsUnitee(id);

		unitee.setId(uniteeDto.getId());
		unitee.setIdTypeUnitee(uniteeDto.getIdTypeUnitee());
		unitee.setIdBatimentProvenance(uniteeDto.getIdBatimentProvenance());
		unitee.setIcone(uniteeDto.getIcone());
		unitee.setLibelle(uniteeDto.getLibelle());
		unitee.setDescriptif(uniteeDto.getDescriptif());
		unitee.setCoutPierreFormation(uniteeDto.getCoutPierreFormation());
		unitee.setCoutBoisFormation(uniteeDto.getCoutBoisFormation());
		unitee.setCoutOrFormation(uniteeDto.getCoutOrFormation());
		unitee.setCoutNourritureFormation(uniteeDto.getCoutNourritureFormation());
		unitee.setCoutHumain(uniteeDto.getCoutHumain());
		unitee.setTempsFormation(uniteeDto.getTempsFormation());
		unitee.setVie(uniteeDto.getVie());
		unitee.setAttaque(uniteeDto.getAttaque());
		unitee.setPortee(uniteeDto.getPortee());
		unitee.setArmure(uniteeDto.getArmure());
		unitee.setVitesse(uniteeDto.getVitesse());
		unitee.setNiveauBatimentNecessaireFormation(uniteeDto.getNiveauBatimentNecessaireFormation());
		unitee.setApportRessourcePierreHeure(uniteeDto.getApportRessourcePierreHeure());
		unitee.setApportRessourceBoisHeure(uniteeDto.getApportRessourceBoisHeure());
		unitee.setApportRessourceOrHeure(uniteeDto.getApportRessourceOrHeure());
		unitee.setApportRessourceNourritureHeure(uniteeDto.getApportRessourceNourritureHeure());
		unitee.setApportExperience(uniteeDto.getApportExperience());
		
		Unitee uni = new Unitee(unitee.getIdTypeUnitee(),
				unitee.getIdBatimentProvenance(),
				unitee.getIcone(),
				unitee.getLibelle(),
				unitee.getDescriptif(),
				unitee.getCoutPierreFormation(),
				unitee.getCoutBoisFormation(),
				unitee.getCoutOrFormation(),
				unitee.getCoutNourritureFormation(),
				unitee.getCoutHumain(),
				unitee.getTempsFormation(),
				unitee.getVie(),
				unitee.getAttaque(),
				unitee.getPortee(),
				unitee.getArmure(),
				unitee.getVitesse(),
				unitee.getNiveauBatimentNecessaireFormation(),
				unitee.getApportRessourcePierreHeure(),
				unitee.getApportRessourceBoisHeure(),
				unitee.getApportRessourceOrHeure(),
				unitee.getApportRessourceNourritureHeure(),
				unitee.getApportExperience());
		uni.setId(unitee.getId());
		this.uniteeRepo.save(uni);
		return unitee;
	}
	
	
}
