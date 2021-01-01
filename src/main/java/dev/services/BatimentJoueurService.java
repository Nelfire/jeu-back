package dev.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.controller.dto.BatimentJoueurDto;
import dev.entites.Joueur;
import dev.entites.batiment.Batiment;
import dev.entites.joueur.BatimentJoueur;
import dev.repository.joueur.BatimentJoueurRepo;

@Service
public class BatimentJoueurService {
	
	private BatimentJoueurRepo batimentJoueurRepo;

	/**
	 * @param batimentJoueurRepo
	 */
	public BatimentJoueurService(BatimentJoueurRepo batimentJoueurRepo) {
		this.batimentJoueurRepo = batimentJoueurRepo;
	}
	
	public List<BatimentJoueurDto> listerMesBatiments(Integer idJoueur) {
		
		List<BatimentJoueurDto> listeMesBatiments = new ArrayList<>();
		for (BatimentJoueur batiment : batimentJoueurRepo.findByJoueurId(idJoueur)) {
			BatimentJoueurDto batimentJoueurDto = new BatimentJoueurDto(batiment.getJoueur(), batiment.getBatiment(),batiment.getNiveau(),batiment.getNombreExploitantsActif());
			listeMesBatiments.add(batimentJoueurDto);	
		}
		return listeMesBatiments;
	}

}
