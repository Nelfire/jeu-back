package dev.services.batiment;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import dev.controller.dto.batiment.BatimentDto;
import dev.controller.dto.unitee.UniteeDto;
import dev.entites.batiment.Batiment;
import dev.entites.unitee.Unitee;
import dev.repository.batiment.BatimentRepo;

@Service
public class BatimentService {
	
	private BatimentRepo batimentRepo;

	/**
	 * @param batimentRepo
	 */
	public BatimentService(BatimentRepo batimentRepo) {
		this.batimentRepo = batimentRepo;
	}
	
	/**
	 * LISTER TOUS LES BATIMENTS EXISTANTS
	 */
	public List<BatimentDto> listerBatiments() {
		List<BatimentDto> listeBatiments = new ArrayList<>();

		for (Batiment batiment : batimentRepo.findAll()) {
			BatimentDto batimentDto = new BatimentDto();
			batimentDto.setId(batiment.getId());
			batimentDto.setIdTypeBatiment(batiment.getIdTypeBatiment());
			batimentDto.setIdCategorieBatiment(batiment.getIdCategorieBatiment());
			batimentDto.setIcone(batiment.getIcone());
			batimentDto.setLibelle(batiment.getLibelle());
			batimentDto.setDescriptif(batiment.getDescriptif());
			batimentDto.setOuvrierNecessaireConstruction(batiment.getOuvrierNecessaireConstruction());
			batimentDto.setTempsDeConstruction(batiment.getTempsDeConstruction());
			batimentDto.setCoutPierreConstruction(batiment.getCoutPierreConstruction());
			batimentDto.setCoutBoisConstruction(batiment.getCoutBoisConstruction());
			batimentDto.setCoutOrConstruction(batiment.getCoutOrConstruction());
			batimentDto.setCoutNourritureConstruction(batiment.getCoutNourritureConstruction());
			batimentDto.setNiveauHotelDeVilleNecessaireConstruction(batiment.getNiveauHotelDeVilleNecessaireConstruction());
			batimentDto.setQuantiteeStockagePierre(batiment.getQuantiteeStockagePierre());
			batimentDto.setQuantiteeStockageBois(batiment.getQuantiteeStockageBois());
			batimentDto.setQuantiteeStockageOre(batiment.getQuantiteeStockageOre());
			batimentDto.setQuantiteeStockageNourriture(batiment.getQuantiteeStockageNourriture());
			batimentDto.setApportPierreHeure(batiment.getApportPierreHeure());
			batimentDto.setApportBoisHeure(batiment.getApportBoisHeure());
			batimentDto.setApportOreHeure(batiment.getApportOreHeure());
			batimentDto.setApportNourritureHeure(batiment.getApportNourritureHeure());

			listeBatiments.add(batimentDto);
		}
		return listeBatiments;
	}
	
	/**
	 * LISTER QUE LES BATIMENTS DE TYPE DIVERS = 1
	 */
	public List<BatimentDto> listerBatimentsDivers() {
		List<BatimentDto> listeBatimentsDivers = new ArrayList<>();

		for (Batiment batiment : batimentRepo.findByIdCategorieBatiment(0)) {
			BatimentDto batimentDto = new BatimentDto();
			batimentDto.setIdTypeBatiment(batiment.getIdTypeBatiment());
			batimentDto.setIcone(batiment.getIcone());
			batimentDto.setLibelle(batiment.getLibelle());
			batimentDto.setDescriptif(batiment.getDescriptif());
			batimentDto.setOuvrierNecessaireConstruction(batiment.getOuvrierNecessaireConstruction());
			batimentDto.setTempsDeConstruction(batiment.getTempsDeConstruction());
			batimentDto.setCoutPierreConstruction(batiment.getCoutPierreConstruction());
			batimentDto.setCoutBoisConstruction(batiment.getCoutBoisConstruction());
			batimentDto.setCoutOrConstruction(batiment.getCoutOrConstruction());
			batimentDto.setCoutNourritureConstruction(batiment.getCoutNourritureConstruction());
			batimentDto.setNiveauHotelDeVilleNecessaireConstruction(batiment.getNiveauHotelDeVilleNecessaireConstruction());
			batimentDto.setQuantiteeStockagePierre(batiment.getQuantiteeStockagePierre());
			batimentDto.setQuantiteeStockageBois(batiment.getQuantiteeStockageBois());
			batimentDto.setQuantiteeStockageOre(batiment.getQuantiteeStockageOre());
			batimentDto.setQuantiteeStockageNourriture(batiment.getQuantiteeStockageNourriture());
			batimentDto.setApportPierreHeure(batiment.getApportPierreHeure());
			batimentDto.setApportBoisHeure(batiment.getApportBoisHeure());
			batimentDto.setApportOreHeure(batiment.getApportOreHeure());
			batimentDto.setApportNourritureHeure(batiment.getApportNourritureHeure());

			listeBatimentsDivers.add(batimentDto);
		}
		return listeBatimentsDivers;
	}

	/**
	 * LISTER QUE LES BATIMENTS DE TYPE RECOLTE = 1
	 */
	public List<BatimentDto> listerBatimentsRecolte() {
		List<BatimentDto> listeBatimentsRecolte = new ArrayList<>();

		for (Batiment batiment : batimentRepo.findByIdCategorieBatiment(1)) {
			BatimentDto batimentDto = new BatimentDto();
			batimentDto.setIdTypeBatiment(batiment.getIdTypeBatiment());
			batimentDto.setIcone(batiment.getIcone());
			batimentDto.setLibelle(batiment.getLibelle());
			batimentDto.setDescriptif(batiment.getDescriptif());
			batimentDto.setOuvrierNecessaireConstruction(batiment.getOuvrierNecessaireConstruction());
			batimentDto.setTempsDeConstruction(batiment.getTempsDeConstruction());
			batimentDto.setCoutPierreConstruction(batiment.getCoutPierreConstruction());
			batimentDto.setCoutBoisConstruction(batiment.getCoutBoisConstruction());
			batimentDto.setCoutOrConstruction(batiment.getCoutOrConstruction());
			batimentDto.setCoutNourritureConstruction(batiment.getCoutNourritureConstruction());
			batimentDto.setNiveauHotelDeVilleNecessaireConstruction(batiment.getNiveauHotelDeVilleNecessaireConstruction());
			batimentDto.setQuantiteeStockagePierre(batiment.getQuantiteeStockagePierre());
			batimentDto.setQuantiteeStockageBois(batiment.getQuantiteeStockageBois());
			batimentDto.setQuantiteeStockageOre(batiment.getQuantiteeStockageOre());
			batimentDto.setQuantiteeStockageNourriture(batiment.getQuantiteeStockageNourriture());
			batimentDto.setApportPierreHeure(batiment.getApportPierreHeure());
			batimentDto.setApportBoisHeure(batiment.getApportBoisHeure());
			batimentDto.setApportOreHeure(batiment.getApportOreHeure());
			batimentDto.setApportNourritureHeure(batiment.getApportNourritureHeure());

			listeBatimentsRecolte.add(batimentDto);
		}
		return listeBatimentsRecolte;
	}

	/**
	 * LISTER QUE LES BATIMENTS DE TYPE STOCKAGE = 2
	 */
	public List<BatimentDto> listerBatimentsStockage() {
		List<BatimentDto> listeBatimentsStockage = new ArrayList<>();

		for (Batiment batiment : batimentRepo.findByIdCategorieBatiment(2)) {
			BatimentDto batimentDto = new BatimentDto();
			batimentDto.setIdTypeBatiment(batiment.getIdTypeBatiment());
			batimentDto.setIcone(batiment.getIcone());
			batimentDto.setLibelle(batiment.getLibelle());
			batimentDto.setDescriptif(batiment.getDescriptif());
			batimentDto.setOuvrierNecessaireConstruction(batiment.getOuvrierNecessaireConstruction());
			batimentDto.setTempsDeConstruction(batiment.getTempsDeConstruction());
			batimentDto.setCoutPierreConstruction(batiment.getCoutPierreConstruction());
			batimentDto.setCoutBoisConstruction(batiment.getCoutBoisConstruction());
			batimentDto.setCoutOrConstruction(batiment.getCoutOrConstruction());
			batimentDto.setCoutNourritureConstruction(batiment.getCoutNourritureConstruction());
			batimentDto.setNiveauHotelDeVilleNecessaireConstruction(batiment.getNiveauHotelDeVilleNecessaireConstruction());
			batimentDto.setQuantiteeStockagePierre(batiment.getQuantiteeStockagePierre());
			batimentDto.setQuantiteeStockageBois(batiment.getQuantiteeStockageBois());
			batimentDto.setQuantiteeStockageOre(batiment.getQuantiteeStockageOre());
			batimentDto.setQuantiteeStockageNourriture(batiment.getQuantiteeStockageNourriture());
			batimentDto.setApportPierreHeure(batiment.getApportPierreHeure());
			batimentDto.setApportBoisHeure(batiment.getApportBoisHeure());
			batimentDto.setApportOreHeure(batiment.getApportOreHeure());
			batimentDto.setApportNourritureHeure(batiment.getApportNourritureHeure());

			listeBatimentsStockage.add(batimentDto);
		}
		return listeBatimentsStockage;
	}

	/**
	 * LISTER QUE LES BATIMENTS DE TYPE MILLITAIRE = 3
	 */
	public List<BatimentDto> listerBatimentsMillitaire() {
		List<BatimentDto> listeBatimentsMillitaire = new ArrayList<>();

		for (Batiment batiment : batimentRepo.findByIdCategorieBatiment(3)) {
			BatimentDto batimentDto = new BatimentDto();
			batimentDto.setIdTypeBatiment(batiment.getIdTypeBatiment());
			batimentDto.setIcone(batiment.getIcone());
			batimentDto.setLibelle(batiment.getLibelle());
			batimentDto.setDescriptif(batiment.getDescriptif());
			batimentDto.setOuvrierNecessaireConstruction(batiment.getOuvrierNecessaireConstruction());
			batimentDto.setTempsDeConstruction(batiment.getTempsDeConstruction());
			batimentDto.setCoutPierreConstruction(batiment.getCoutPierreConstruction());
			batimentDto.setCoutBoisConstruction(batiment.getCoutBoisConstruction());
			batimentDto.setCoutOrConstruction(batiment.getCoutOrConstruction());
			batimentDto.setCoutNourritureConstruction(batiment.getCoutNourritureConstruction());
			batimentDto.setNiveauHotelDeVilleNecessaireConstruction(batiment.getNiveauHotelDeVilleNecessaireConstruction());
			batimentDto.setQuantiteeStockagePierre(batiment.getQuantiteeStockagePierre());
			batimentDto.setQuantiteeStockageBois(batiment.getQuantiteeStockageBois());
			batimentDto.setQuantiteeStockageOre(batiment.getQuantiteeStockageOre());
			batimentDto.setQuantiteeStockageNourriture(batiment.getQuantiteeStockageNourriture());
			batimentDto.setApportPierreHeure(batiment.getApportPierreHeure());
			batimentDto.setApportBoisHeure(batiment.getApportBoisHeure());
			batimentDto.setApportOreHeure(batiment.getApportOreHeure());
			batimentDto.setApportNourritureHeure(batiment.getApportNourritureHeure());

			listeBatimentsMillitaire.add(batimentDto);
		}
		return listeBatimentsMillitaire;
	}
	
	/**
	 * DETAIL D'UN BATIMENT (Via ID)
	 */
	public BatimentDto detailsBatiment(Integer idTypeBatiment) {
		Batiment batiment =  batimentRepo.findByIdTypeBatiment(idTypeBatiment);
		BatimentDto bat = new BatimentDto(batiment.getIdTypeBatiment(),batiment.getIdCategorieBatiment(),batiment.getIcone(),batiment.getLibelle(),batiment.getDescriptif(),batiment.getOuvrierNecessaireConstruction(),batiment.getTempsDeConstruction(),batiment.getCoutPierreConstruction(),batiment.getCoutBoisConstruction(),batiment.getCoutOrConstruction(),batiment.getCoutNourritureConstruction(),batiment.getNiveauHotelDeVilleNecessaireConstruction(),batiment.getQuantiteeStockagePierre(),batiment.getQuantiteeStockageBois(),batiment.getQuantiteeStockageOre(),batiment.getQuantiteeStockageNourriture(),batiment.getApportPierreHeure(),batiment.getApportBoisHeure(),batiment.getApportOreHeure(),batiment.getApportNourritureHeure());
		return bat;
	}
	
	/**
	 * MODIFICATION D'UN BÂTIMENT (Menu administrateur, Via ID)
	 */
	public BatimentDto administrationModificationBatiment(@Valid BatimentDto batimentDto, Integer id) {
		BatimentDto batiment = this.detailsBatiment(id);

		batiment.setId(batimentDto.getId());
		batiment.setIdTypeBatiment(batimentDto.getIdTypeBatiment());
		batiment.setIdCategorieBatiment(batimentDto.getIdCategorieBatiment());
		batiment.setIcone(batimentDto.getIcone());
		batiment.setLibelle(batimentDto.getLibelle());
		batiment.setDescriptif(batimentDto.getDescriptif());
		batiment.setOuvrierNecessaireConstruction(batimentDto.getOuvrierNecessaireConstruction());
		batiment.setTempsDeConstruction(batimentDto.getTempsDeConstruction());
		batiment.setCoutPierreConstruction(batimentDto.getCoutPierreConstruction());
		batiment.setCoutBoisConstruction(batimentDto.getCoutBoisConstruction());
		batiment.setCoutOrConstruction(batimentDto.getCoutOrConstruction());
		batiment.setCoutNourritureConstruction(batimentDto.getCoutNourritureConstruction());
		batiment.setNiveauHotelDeVilleNecessaireConstruction(batimentDto.getNiveauHotelDeVilleNecessaireConstruction());
		batiment.setQuantiteeStockagePierre(batimentDto.getQuantiteeStockagePierre());
		batiment.setQuantiteeStockageBois(batimentDto.getQuantiteeStockageBois());
		batiment.setQuantiteeStockageOre(batimentDto.getQuantiteeStockageOre());
		batiment.setQuantiteeStockageNourriture(batimentDto.getQuantiteeStockageNourriture());
		batiment.setApportPierreHeure(batimentDto.getApportPierreHeure());
		batiment.setApportBoisHeure(batimentDto.getApportBoisHeure());
		batiment.setApportOreHeure(batimentDto.getApportOreHeure());
		batiment.setApportNourritureHeure(batimentDto.getApportNourritureHeure());


		Batiment bat = new Batiment(batiment.getIdTypeBatiment(),
				batiment.getIdCategorieBatiment(),
				batiment.getIcone(),
				batiment.getLibelle(),
				batiment.getDescriptif(),
				batiment.getOuvrierNecessaireConstruction(),
				batiment.getTempsDeConstruction(),
				batiment.getCoutPierreConstruction(),
				batiment.getCoutBoisConstruction(),
				batiment.getCoutOrConstruction(),
				batiment.getCoutNourritureConstruction(),
				batiment.getNiveauHotelDeVilleNecessaireConstruction(),
				batiment.getQuantiteeStockagePierre(),
				batiment.getQuantiteeStockageBois(),
				batiment.getQuantiteeStockageOre(),
				batiment.getQuantiteeStockageNourriture(),
				batiment.getApportPierreHeure(),
				batiment.getApportBoisHeure(),
				batiment.getApportOreHeure(),
				batiment.getApportNourritureHeure());
		bat.setId(batiment.getId());
		this.batimentRepo.save(bat);
		return batiment;
	}

}
