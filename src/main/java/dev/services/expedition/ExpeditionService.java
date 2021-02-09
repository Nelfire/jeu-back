package dev.services.expedition;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Random;

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
	
	/**
	 * LISTER TOUTES LES EXPEDITIONS EXISTANTES
	 */
	public List<Expedition> listerExpedition() {
        LocalDate dateAujourdhui  = LocalDate.now();
		List<Expedition> listeExpedition = new ArrayList<>();
		for (Expedition expedition : expeditionRepo.findAll()) {
			if(expedition.getDateParution().isEqual(dateAujourdhui)) {
				listeExpedition.add(expedition);
			}
		}
		return listeExpedition;
	}
	
	/**
	 * DETAILS D'UNE EXPEDITION (Via ID)
	 */
	public Expedition detailExpedition(Integer idExpedition) {
		Optional<Expedition> expe = this.expeditionRepo.findById(idExpedition);
		Expedition expedition = new Expedition();
		expedition.setId(expe.get().getId());
		expedition.setIcone(expe.get().getIcone());
		expedition.setLibelle(expe.get().getLibelle());
		expedition.setDescription(expe.get().getDescription());
		expedition.setDureeExpedition(expe.get().getDureeExpedition());
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
		expedition.setRecompenseExperience(expe.get().getRecompenseExperience());
		expedition.setDateParution(expe.get().getDateParution());
		return expedition;
	}
	
	/**
	 * CREER DE NOUVELLES EXPEDITIONS CHAQUES JOURS
	 */
	
	public void creerNouvellesExpeditions() {
		
		LocalDate dateAujourdhui  = LocalDate.now(); 
		for (int i = 0; i < 10; i++) {
			Expedition nouvelleExpedition = new Expedition();
			System.out.println(i);
			// vie aléatoire (poid : 0.2) (Ex : 20000)
		    Integer vie = getChiffreRandom(1000,80000);
		    
		    // armure aléatoire (poid : 0.4) (Ex : 7000)
		    Integer armure = getChiffreRandom(vie/3,(vie+5000)/3);
		    
		    // degats aléatoire (poid : 0.5) (Ex : 7000)
		    Integer degats = getChiffreRandom(vie/3,(vie+5000)/3);

		    // 1 600 à 130 000
		    Integer sommeVieArmureDegats = vie+armure+degats;
			// coutPierre aléatoire (Ex : 34 000 / 10 = 3400 à 4800)
		    Integer coutPierre = getChiffreRandom((sommeVieArmureDegats)/5,(sommeVieArmureDegats)/2);
			// coutBois aléatoire
		    Integer coutBois = getChiffreRandom((sommeVieArmureDegats)/5,(sommeVieArmureDegats)/2);
			// coutOr aléatoire
		    Integer coutOr = getChiffreRandom((sommeVieArmureDegats)/5,(sommeVieArmureDegats)/2);
			// coutNourriture aléatoire
		    Integer coutNourriture = getChiffreRandom((sommeVieArmureDegats)/5,(sommeVieArmureDegats)/2);

			// recompensePierre aléatoire
		    Integer recompensePierre = getChiffreRandom(coutPierre*2,coutPierre*3);
			// recompenseBois aléatoire
		    Integer recompenseBois = getChiffreRandom(coutBois*2,coutBois*3);
			// recompenseOr aléatoire
		    Integer recompenseOr = getChiffreRandom(coutOr*2,coutOr*3);
			// recompenseNourriture aléatoire
		    Integer recompenseNourriture = getChiffreRandom(coutNourriture*2,coutNourriture*3);
			// recompenseGemme aléatoire
		    Integer recompenseGemme = getChiffreRandom(sommeVieArmureDegats/250,sommeVieArmureDegats/200);
			// recompenseExperience aléatoire
		    Integer recompenseExperience = sommeVieArmureDegats;
			// dureeExpedition aléatoire	    
		    Integer dureeExpedition = sommeVieArmureDegats / 4;
			// icone aléatoire
		    String icone = "https://media.discordapp.net/attachments/794876433842831361/796753858625142804/thumb-1920-1013122.jpg?width=1278&height=497";
			// libelle aléatoire
		    String libelle = "Expedition";
			// description aléatoire
		    String description = "Description expedition";
		    // difficultee aléatoire
		    Integer difficultee = 0;
		    if(sommeVieArmureDegats <= 2000) {
		    	difficultee = 1;
		    } else if (sommeVieArmureDegats >2000 && sommeVieArmureDegats <= 20000 ) {
		    	difficultee = 2;
		    } else if (sommeVieArmureDegats >20000 && sommeVieArmureDegats <= 50000 ) {
		    	difficultee = 3;
		    } else if (sommeVieArmureDegats >50000 && sommeVieArmureDegats <= 100000 ) {
		    	difficultee = 4;
		    } else if (sommeVieArmureDegats >100000) {
		    	difficultee = 5;
		    }
		    
		    nouvelleExpedition.setIcone(icone);
		    nouvelleExpedition.setLibelle(libelle);
		    nouvelleExpedition.setDescription(description);
		    nouvelleExpedition.setDureeExpedition(dureeExpedition);
		    nouvelleExpedition.setDifficultee(difficultee);
		    nouvelleExpedition.setDegats(degats);
		    nouvelleExpedition.setVie(vie);
		    nouvelleExpedition.setArmure(armure);
		    nouvelleExpedition.setCoutPierre(coutPierre);
		    nouvelleExpedition.setCoutBois(coutBois);
		    nouvelleExpedition.setCoutOr(coutOr);
		    nouvelleExpedition.setCoutNourriture(coutNourriture);
		    nouvelleExpedition.setRecompensePierre(recompensePierre);
		    nouvelleExpedition.setRecompenseBois(recompenseBois);
		    nouvelleExpedition.setRecompenseOr(recompenseOr);
		    nouvelleExpedition.setRecompenseNourriture(recompenseNourriture);
		    nouvelleExpedition.setRecompenseGemme(recompenseGemme);
		    nouvelleExpedition.setRecompenseExperience(recompenseExperience);
		    nouvelleExpedition.setDateParution(dateAujourdhui);
		    System.out.println(nouvelleExpedition.toString());
			// SAUVEGARDE
			this.expeditionRepo.save(nouvelleExpedition);
		}

		
		
	}
	
	
	public static int getChiffreRandom(int minimum, int maximum) {
	    if (minimum < maximum)
	        return minimum + new Random().nextInt(Math.abs(maximum - minimum));
	    return minimum - new Random().nextInt(Math.abs(maximum - minimum));
	}
}
