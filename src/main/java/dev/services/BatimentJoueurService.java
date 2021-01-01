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
	
	public List<BatimentJoueurDto> listerMesBatiments(Joueur joueur) {
		List<BatimentJoueurDto> listeMesBatiments = new ArrayList<>();

		for (BatimentJoueur batiment : batimentJoueurRepo.findByJoueur(joueur)) {

			BatimentJoueurDto batimentJoueurDto = new BatimentJoueurDto();
			batimentJoueurDto.setJoueur(batiment.getJoueur());
			batimentJoueurDto.setBatiment(batiment.getBatiment());
			batimentJoueurDto.setNiveau(batiment.getNiveau());
			batimentJoueurDto.setOuvrierNecessaireAmelioration(batiment.getOuvrierNecessaireAmelioration());
			batimentJoueurDto.setTempsAmelioration(batiment.getTempsAmelioration());
			batimentJoueurDto.setCoutPierreAmelioration(batiment.getCoutPierreAmelioration());
			batimentJoueurDto.setCoutBoisAmelioration(batiment.getCoutBoisAmelioration());
			batimentJoueurDto.setCoutOrAmelioration(batiment.getCoutOrAmelioration());
			batimentJoueurDto.setCoutNourritureAmelioration(batiment.getCoutNourritureAmelioration());
			batimentJoueurDto.setQuantiteeStockagePierre(batiment.getQuantiteeStockagePierre());
			batimentJoueurDto.setQuantiteeStockageBois(batiment.getQuantiteeStockageBois());
			batimentJoueurDto.setQuantiteeStockageOr(batiment.getQuantiteeStockageOr());
			batimentJoueurDto.setQuantiteeStockageNourriture(batiment.getQuantiteeStockageNourriture());
			batimentJoueurDto.setNombreExploitantsAutorise(batiment.getNombreExploitantsAutorise());
			batimentJoueurDto.setNombreExploitantsActif(batiment.getNombreExploitantsActif());
			batimentJoueurDto.setApportRessourceHeure(batiment.getApportRessourceHeure());

			listeMesBatiments.add(batimentJoueurDto);

		}
		return listeMesBatiments;
	}

}
