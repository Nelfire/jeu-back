package dev.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.entites.expedition.Expedition;
import dev.repository.expedition.ExpeditionRepo;

@Service
public class ExpeditionService {

	ExpeditionRepo expeditionRepo;

	/**
	 * @param expeditionRepo
	 */
	public ExpeditionService(ExpeditionRepo expeditionRepo) {
		super();
		this.expeditionRepo = expeditionRepo;
	}
	
	// Lister les expéditions
	public List<Expedition> listerExpedition() {
		List<Expedition> listeExpedition = new ArrayList<>();
		for (Expedition expedition : expeditionRepo.findAll()) {
			listeExpedition.add(expedition);
		}
		return listeExpedition;
	}
	
}
