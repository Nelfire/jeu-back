package dev.services.expedition;

import java.time.LocalDate;
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
		
		// CAS HEROKU EN VEILLE AU MOMENT DU @Scheduled, forcer la création des expéditions du jour
		if(listeExpedition.size() == 0) {
			this.creerNouvellesExpeditions();
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
		Integer vieDifficulteMin = 0;
		Integer vieDifficulteMax = 0;
		Integer difficultee = 0;
		Integer dureeExpedition = 0;
		for (int i = 0; i < 18; i++) {
			Expedition nouvelleExpedition = new Expedition();
			
			if(i>=0 && i<3) {
				vieDifficulteMin = 50;
				vieDifficulteMax = 1000;
		    	difficultee = 1;
		    	dureeExpedition = 600;
			} else if (i>=3 && i<6) {
				vieDifficulteMin = 5000;
				vieDifficulteMax = 50_000;
		    	difficultee = 2;
		    	dureeExpedition = 2000;
			} else if (i>=6 && i<9) {
				vieDifficulteMin = 50_000;
				vieDifficulteMax = 1_000_000;
		    	difficultee = 3;
		    	dureeExpedition = 6000;
			} else if (i>=9 && i<12) {
				vieDifficulteMin = 1_000_000;
				vieDifficulteMax = 100_000_000;
		    	difficultee = 4;
		    	dureeExpedition = 10_000;
			} else if (i>=12 && i<15) {
				vieDifficulteMin = 100_000_000;
				vieDifficulteMax = 500_000_000;
		    	difficultee = 5;
		    	dureeExpedition = 14_000;
			} else if (i>=15 && i<18) {
				vieDifficulteMin = 500_000_000;
				vieDifficulteMax = 1_500_000_000;
		    	difficultee = 6;
		    	dureeExpedition = 18_000;
			}

			// vie aléatoire (poid : 0.2) (Ex : 20000)
		    Long vie = getChiffeRandomLong(vieDifficulteMin,vieDifficulteMax);
		    
		    // armure aléatoire (poid : 0.4) (Ex : 7000)
		    Long armure = vie/20;
		    
		    // degats aléatoire (poid : 0.5) (Ex : 7000)
		    Long degats = vie/30;

		    // 1 600 à 130 000
		    //Long sommeVieArmureDegats = vie+armure+degats;
			// coutPierre aléatoire (Ex : 34 000 / 10 = 3400 à 4800)
//		    Integer coutPierre = getChiffreRandom((sommeVieArmureDegats)/6,(sommeVieArmureDegats)/3);
//			// coutBois aléatoire
//		    Integer coutBois = getChiffreRandom((sommeVieArmureDegats)/7,(sommeVieArmureDegats)/4);
//			// coutOr aléatoire
//		    Integer coutOr = getChiffreRandom((sommeVieArmureDegats)/8,(sommeVieArmureDegats)/5);
//			// coutNourriture aléatoire
//		    Integer coutNourriture = getChiffreRandom((sommeVieArmureDegats)/5,(sommeVieArmureDegats)/2);

			// recompensePierre aléatoire
		    Long recompenseRessoureTotalePoid = 900*vie;
		    
		    Long recompensePierre =  (recompenseRessoureTotalePoid/12);
			// recompenseBois aléatoire
		    Long recompenseBois =  (recompenseRessoureTotalePoid/8);
			// recompenseOr aléatoire
		    Long recompenseOr =  (recompenseRessoureTotalePoid/20);
			// recompenseNourriture aléatoire
		    Long recompenseNourriture =  (recompenseRessoureTotalePoid/4);
			// recompenseGemme aléatoire
		    Long recompenseGemme =  (recompenseRessoureTotalePoid/40_000);
			// recompenseExperience aléatoire
		    Long recompenseExperience =  (recompenseRessoureTotalePoid/100);
			// dureeExpedition aléatoire	    
//		    Integer dureeExpedition = sommeVieArmureDegats / 6;
			// icone aléatoire
		    String icone = "https://media.discordapp.net/attachments/794876433842831361/796753858625142804/thumb-1920-1013122.jpg?width=1278&height=497";
			// libelle aléatoire
		    String libelle = "Expedition";
			// description aléatoire
		    String description = "Description expedition";
		    // difficultee aléatoire
//		    Integer difficultee = 0;
//		    if(sommeVieArmureDegats <= 1000) {
//		    	difficultee = 1;
//		    } else if (sommeVieArmureDegats >2000 && sommeVieArmureDegats <= 20_000 ) {
//		    	difficultee = 2;
//		    } else if (sommeVieArmureDegats >20_000 && sommeVieArmureDegats <= 100_000 ) {
//		    	difficultee = 3;
//		    } else if (sommeVieArmureDegats >100_000 && sommeVieArmureDegats <= 1_000_000 ) {
//		    	difficultee = 4;
//		    } else if (sommeVieArmureDegats >100000) {
//		    	difficultee = 5;
//		    }
		    
		    nouvelleExpedition.setIcone(icone);
		    nouvelleExpedition.setLibelle(libelle);
		    nouvelleExpedition.setDescription(description);
		    nouvelleExpedition.setDureeExpedition(dureeExpedition);
		    nouvelleExpedition.setDifficultee(difficultee);
		    nouvelleExpedition.setDegats(degats);
		    nouvelleExpedition.setVie(vie);
		    nouvelleExpedition.setArmure(armure);
		    nouvelleExpedition.setCoutPierre(0);
		    nouvelleExpedition.setCoutBois(0);
		    nouvelleExpedition.setCoutOr(0);
		    nouvelleExpedition.setCoutNourriture(0);
		    nouvelleExpedition.setRecompensePierre(recompensePierre);
		    nouvelleExpedition.setRecompenseBois(recompenseBois);
		    nouvelleExpedition.setRecompenseOr(recompenseOr);
		    nouvelleExpedition.setRecompenseNourriture(recompenseNourriture);
		    nouvelleExpedition.setRecompenseGemme(recompenseGemme);
		    nouvelleExpedition.setRecompenseExperience(recompenseExperience);
		    nouvelleExpedition.setDateParution(dateAujourdhui);

			// SAUVEGARDE
			this.expeditionRepo.save(nouvelleExpedition);
		}

		
	}

	
//	public static int getChiffreRandom(int minimum, int maximum) {
//	    if (minimum < maximum)
//	        return minimum + new Random().nextInt(Math.abs(maximum - minimum));
//	    return minimum - new Random().nextInt(Math.abs(maximum - minimum));
//	}
	
	public static long getChiffeRandomLong(long minimum, long maximum) {
	    return minimum + (long) (Math.random() * (maximum - minimum));
	}

}
