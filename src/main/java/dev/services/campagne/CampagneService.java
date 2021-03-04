package dev.services.campagne;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.controller.dto.campagne.CampagneDto;
import dev.entites.campagne.Campagne;
import dev.repository.campagne.CampagneRepo;

@Service
public class CampagneService {

	private CampagneRepo campagneRepo;

	public CampagneService (CampagneRepo campagneRepo) {
		this.campagneRepo = campagneRepo;
	}

	/**
	 * LISTER TOUTES LES CAMPAGNES EXISTANTES
	 */
	public List<Campagne> listerLesCampagnes() {
		List<Campagne> listeCampagnes = new ArrayList<>();

		// BOUCLE SUR TOUTES LES CAMPAGNES QU'IL EXISTE
		for (Campagne campagne : campagneRepo.findAll()) {
			listeCampagnes.add(campagne);
			System.out.println(campagne.toString());
		}

		// RETOUR
		return listeCampagnes;
	}

}
