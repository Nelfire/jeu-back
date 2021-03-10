package dev.services.campagne;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.stereotype.Service;
import dev.controller.dto.campagne.CampagneDto;
import dev.controller.dto.unitee.UniteeDto;
import dev.entites.campagne.Campagne;
import dev.entites.unitee.Unitee;
import dev.repository.campagne.CampagneRepo;
import dev.services.unitee.UniteeService;

@Service
public class CampagneService {

	private CampagneRepo campagneRepo;
	private UniteeService uniteeService;

	/**
	 * @param campagneRepo
	 * @param uniteeService
	 */
	public CampagneService(CampagneRepo campagneRepo, UniteeService uniteeService) {
		this.campagneRepo = campagneRepo;
		this.uniteeService = uniteeService;
	}

	/**
	 * LISTER TOUTES LES CAMPAGNES EXISTANTES
	 */
	public List<Campagne> listerLesCampagnes() {
		
		// INITIALISATIONS
		List<Campagne> listeCampagnes = new ArrayList<>();

		// BOUCLE SUR TOUTES LES CAMPAGNES QU'IL EXISTE
		for (Campagne campagne : campagneRepo.findAll()) {
			listeCampagnes.add(campagne);
		}

		// RETOUR
		return listeCampagnes;
	}

	/**
	 * LISTER LES CAMPAGNES VIA NUMERO DU MONDE
	 */
	public List<Campagne> listerLesCampagnesMonde(Integer numeroMonde) {
		
		// INITIALISATIONS
		List<Campagne> listeCampagnesMonde = new ArrayList<>();

		// BOUCLE SUR TOUTES LES CAMPAGNES QU'IL EXISTE
		for (Campagne campagne : campagneRepo.findByMonde(numeroMonde)) {
			listeCampagnesMonde.add(campagne);
		}

		// RETOUR
		return listeCampagnesMonde;
	}

	/**
	 * DETAILS D'UNE CAMPAGNE (Via ID)
	 */
	public Campagne detailsCampagne(Integer idCampagne) {

		// RECUPERATION INFORMATIONS CAMPAGNE
		Optional<Campagne> camp = campagneRepo.findById(idCampagne);

		// CREATION CAMPAGNE RETOUR
		Campagne campagne = new Campagne();
		campagne.setId(camp.get().getId());
		campagne.setIcone(camp.get().getIcone());
		campagne.setLibelle(camp.get().getLibelle());
		campagne.setDescription(camp.get().getDescription());
		campagne.setDuree(camp.get().getDuree());
		campagne.setMonde(camp.get().getMonde());
		campagne.setNiveau(camp.get().getNiveau());
		campagne.setUnitee(camp.get().getUnitee());
		campagne.setQuantitee(camp.get().getQuantitee());
		campagne.setIsBoss(camp.get().getIsBoss());
		campagne.setRecompensePierre(camp.get().getRecompensePierre());
		campagne.setRecompenseBois(camp.get().getRecompenseBois());
		campagne.setRecompenseOr(camp.get().getRecompenseOr());
		campagne.setRecompenseNourriture(camp.get().getRecompenseNourriture());
		campagne.setRecompenseGemme(camp.get().getRecompenseGemme());
		campagne.setRecompenseExperience(camp.get().getRecompenseExperience());

		// RETOUR
		return campagne;
	}

	/**
	 * CREATION D'UNE NOUVELLE CAMPAGNE (Menu administrateur)
	 */
	public CampagneDto administrationCreerCampagne(CampagneDto infosCampagne) {

		// RECUPERATION DETAILS UNITE
		UniteeDto uniteeDto = this.uniteeService.detailsUnitee(infosCampagne.getIdUnite());
		Unitee unitee = new Unitee();
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

		// CREATION CAMPAGNE
		Campagne campagne = new Campagne();
		campagne.setIcone(infosCampagne.getIcone());
		campagne.setLibelle(infosCampagne.getIcone());
		campagne.setDescription(infosCampagne.getIcone());
		campagne.setDuree(infosCampagne.getDuree());
		campagne.setMonde(infosCampagne.getMonde());
		campagne.setNiveau(infosCampagne.getNiveau());
		campagne.setUnitee(unitee);
		campagne.setQuantitee(infosCampagne.getQuantitee());
		campagne.setIsBoss(infosCampagne.getIsBoss());
		campagne.setRecompensePierre(infosCampagne.getRecompensePierre());
		campagne.setRecompenseBois(infosCampagne.getRecompenseBois());
		campagne.setRecompenseOr(infosCampagne.getRecompenseOr());
		campagne.setRecompenseNourriture(infosCampagne.getRecompenseNourriture());
		campagne.setRecompenseGemme(infosCampagne.getRecompenseGemme());
		campagne.setRecompenseExperience(infosCampagne.getRecompenseExperience());

		// SAUVEGARDE
		this.campagneRepo.save(campagne);

		// RETOUR
		return infosCampagne;
	}

	/**
	 * MODIFICATION D'UNE CAMPAGNE (Menu administrateur, Via ID)
	 */
	public CampagneDto administrationModificationCampagne(@Valid CampagneDto campagneDto, Integer id) {

		// RECUPERATION UNITEE
		UniteeDto uniteeDto = this.uniteeService.detailsUnitee(campagneDto.getIdUnite());
		Unitee unitee = new Unitee();
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

		// CREATION CAMPAGNE
		Campagne campagne = this.detailsCampagne(id);
		campagne.setId(campagneDto.getId());
		campagne.setIcone(campagneDto.getIcone());
		campagne.setLibelle(campagneDto.getLibelle());
		campagne.setDescription(campagneDto.getDescription());
		campagne.setDuree(campagneDto.getDuree());
		campagne.setMonde(campagneDto.getMonde());
		campagne.setNiveau(campagneDto.getNiveau());
		campagne.setUnitee(unitee);
		campagne.setQuantitee(campagneDto.getQuantitee());
		campagne.setIsBoss(campagneDto.getIsBoss());
		campagne.setRecompensePierre(campagneDto.getRecompensePierre());
		campagne.setRecompenseBois(campagneDto.getRecompenseBois());
		campagne.setRecompenseOr(campagneDto.getRecompenseOr());
		campagne.setRecompenseNourriture(campagneDto.getRecompenseNourriture());
		campagne.setRecompenseGemme(campagneDto.getRecompenseGemme());
		campagne.setRecompenseExperience(campagneDto.getRecompenseExperience());

		// SAUVEGARDE
		this.campagneRepo.save(campagne);

		// RETOUR
		return campagneDto;
	}

}
