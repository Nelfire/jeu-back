package dev.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
	// Détail d'une expédition (id)
	public Expedition detailExpedition(Integer idExpedition) {
		Optional<Expedition> expe = this.expeditionRepo.findById(idExpedition);
		Expedition expedition = new Expedition();
		expedition.setId(expe.get().getId());
		expedition.setIcone(expe.get().getIcone());
		expedition.setLibelle(expe.get().getLibelle());
		expedition.setDescription(expe.get().getDescription());
		expedition.setDureeExpedition(expe.get().getDureeExpedition());
		expedition.setPourcentageReussite(expe.get().getPourcentageReussite());
		expedition.setDifficultee(expe.get().getDifficultee());
		expedition.setDegats(expe.get().getDegats());
		expedition.setVie(expe.get().getVie());
		expedition.setArmure(expe.get().getArmure());
		expedition.setCoutPierre(expe.get().getCoutPierre());
		expedition.setCoutBois(expe.get().getCoutBois());
		expedition.setCoutOr(expe.get().getCoutOr());
		expedition.setCoutNourriture(expe.get().getCoutNourriture());
		expedition.setRecompensePierre(expe.get().getRecompensePierre());
		expedition.setRecompenseBois(expe.get().getRecompenseBois());
		expedition.setRecompenseOr(expe.get().getRecompenseOr());
		expedition.setRecompenseNourriture(expe.get().getRecompenseNourriture());
		expedition.setRecompenseGemme(expe.get().getRecompenseGemme());
		return expedition;
	}
	
}
