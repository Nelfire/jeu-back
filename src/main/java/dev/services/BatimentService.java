package dev.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.controller.dto.BatimentDto;
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
			batimentDto.setOuvrierNecessaireConstruction(batiment.getOuvrierNecessaireConstruction());
			batimentDto.setTempsDeConstruction(batiment.getTempsDeConstruction());
			batimentDto.setCoutPierreConstruction(batiment.getIdTypeBatiment());
			batimentDto.setCoutBoisConstruction(batiment.getIdTypeBatiment());
			batimentDto.setCoutOrConstruction(batiment.getIdTypeBatiment());
			batimentDto.setCoutNourritureConstruction(batiment.getIdTypeBatiment());

			listeBatiments.add(batimentDto);

		}
		return listeBatiments;
	}

}
