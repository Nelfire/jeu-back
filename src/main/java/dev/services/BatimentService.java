package dev.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.controller.dto.BatimentDto;
import dev.controller.dto.JoueurDto;
import dev.entites.Joueur;
import dev.entites.batiment.Batiment;
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
	
	public List<BatimentDto> listerBatiments() {
		List<BatimentDto> listeBatiments = new ArrayList<>();

		for (Batiment batiment : batimentRepo.findAll()) {

			BatimentDto batimentDto = new BatimentDto();
			batimentDto.setIdTypeBatiment(batiment.getIdTypeBatiment());
			batimentDto.setIcone(batiment.getIcone());
			batimentDto.setLibelle(batiment.getLibelle());
			batimentDto.setDescriptif(batiment.getDescriptif());
			batimentDto.setNiveau(batiment.getNiveau());
			batimentDto.setOuvrierNecessaireConstruction(batiment.getOuvrierNecessaireConstruction());
			batimentDto.setOuvrierNecessaireAmelioration(batiment.getOuvrierNecessaireAmelioration());
			batimentDto.setTempsDeConstruction(batiment.getTempsDeConstruction());
			batimentDto.setTempsAmelioration(batiment.getIdTypeBatiment());
			batimentDto.setCoutPierreConstruction(batiment.getIdTypeBatiment());
			batimentDto.setCoutPierreAmelioration(batiment.getIdTypeBatiment());
			batimentDto.setCoutBoisConstruction(batiment.getIdTypeBatiment());
			batimentDto.setCoutBoisAmelioration(batiment.getIdTypeBatiment());
			batimentDto.setCoutOrConstruction(batiment.getIdTypeBatiment());
			batimentDto.setCoutOrAmelioration(batiment.getIdTypeBatiment());
			batimentDto.setCoutNourritureConstruction(batiment.getIdTypeBatiment());
			batimentDto.setCoutNourritureAmelioration(batiment.getIdTypeBatiment());
			batimentDto.setQuantiteeStockagePierre(batiment.getIdTypeBatiment());
			batimentDto.setQuantiteeStockageBois(batiment.getIdTypeBatiment());
			batimentDto.setQuantiteeStockageOr(batiment.getIdTypeBatiment());
			batimentDto.setQuantiteeStockageNourriture(batiment.getIdTypeBatiment());
			batimentDto.setNombreExploitantsAutorise(batiment.getIdTypeBatiment());
			batimentDto.setNombreExploitantsActif(batiment.getIdTypeBatiment());
			batimentDto.setApportRessourceHeure(batiment.getIdTypeBatiment());
			batimentDto.setNiveauHotelDeVilleNecessaireConstruction(batiment.getIdTypeBatiment());

			listeBatiments.add(batimentDto);

		}
		return listeBatiments;
	}

}
