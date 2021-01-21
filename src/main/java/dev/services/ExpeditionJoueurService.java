package dev.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.controller.dto.CompositionArmeeExpedition;
import dev.entites.Joueur;
import dev.entites.expedition.Expedition;
import dev.entites.joueur.Armee;
import dev.entites.joueur.ExpeditionJoueur;
import dev.exceptions.RecompenseDejaPercuException;
import dev.exceptions.RessourceManquanteException;
import dev.repository.JoueurRepo;
import dev.repository.expedition.ExpeditionRepo;
import dev.repository.joueur.ArmeeRepo;
import dev.repository.joueur.ExpeditionJoueurRepo;

@Service
public class ExpeditionJoueurService {

	ExpeditionJoueurRepo expeditionJoueurRepo;
	ArmeeRepo armeeRepo;
	JoueurService joueurService;
	JoueurRepo joueurRepo;
	ExpeditionRepo expeditionRepo;

	/**
	 * @param expeditionRepo
	 */
	public ExpeditionJoueurService(ExpeditionJoueurRepo expeditionJoueurRepo, ArmeeRepo armeeRepo, JoueurService joueurService, JoueurRepo joueurRepo, ExpeditionRepo expeditionRepo) {
		super();
		this.expeditionJoueurRepo = expeditionJoueurRepo;
		this.armeeRepo = armeeRepo;
		this.joueurService = joueurService;
		this.joueurRepo = joueurRepo;
		this.expeditionRepo = expeditionRepo;
	}
	
	// Lister les expéditions
	public List<ExpeditionJoueur> listerExpeditionJoueur() {
		// Récupération du joueur
		Joueur jou = joueurService.recuperationJoueur();
		
		// Récupération de la liste des expéditions du joueur.
		List<ExpeditionJoueur> listeExpeditionJoueur = new ArrayList<>();
		for (ExpeditionJoueur expedition : expeditionJoueurRepo.findByJoueur(jou)) {
			listeExpeditionJoueur.add(expedition);
		}
		return listeExpeditionJoueur;
	}
	
	public ExpeditionJoueur rechercherExpeditionJoueurById(Integer id) {
		// Recherche de l'expedition joueur correspondante
		Optional<ExpeditionJoueur> expeJoueur = expeditionJoueurRepo.findById(id);
		// Création d'une instance depuis l'expedition trouvée
		ExpeditionJoueur expeditionJoueur = new ExpeditionJoueur();
		expeditionJoueur.setId(expeJoueur.get().getId());
		expeditionJoueur.setJoueur(expeJoueur.get().getJoueur());
		expeditionJoueur.setExpedition(expeJoueur.get().getExpedition());
		expeditionJoueur.setDateDebutExpedition(expeJoueur.get().getDateDebutExpedition());
		expeditionJoueur.setDateFinExpedition(expeJoueur.get().getDateFinExpedition());
		expeditionJoueur.setArmeeEnvoiJoueur(expeJoueur.get().getArmeeEnvoiJoueur());
		expeditionJoueur.setRecompenseRecuperee(expeJoueur.get().getRecompenseRecuperee());
		return expeditionJoueur;
	}
	
	public CompositionArmeeExpedition envoiUniteeEnExpedition(CompositionArmeeExpedition compositionArmeeExpedition) {
		
		// Recherche Expedition correspondante
		Optional<Expedition> expe = expeditionRepo.findById(compositionArmeeExpedition.getIdExpedition());
		// Creation d'une expedition type, à partir de cette recherche
		Expedition expedition = new Expedition();
		expedition.setId(expe.get().getId());
		expedition.setIcone(expe.get().getIcone());
		expedition.setLibelle(expe.get().getLibelle());
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
		
		// Initialisations
		Integer coutPierre = expe.get().getCoutPierre();
		Integer coutBois = expe.get().getCoutBois();
		Integer coutOr = expe.get().getCoutOr();
		Integer coutNourriture = expe.get().getCoutNourriture();
		
		// Récupération du joueur
		Joueur jou = joueurService.recuperationJoueur();
		Armee armee = new Armee();
		
		// Préparation liste des armées que le joueur va envoyer
		List<Armee> listeArmees = new ArrayList<>();
		
		// Retrait de ressources
		jou.setPierrePossession(jou.getPierrePossession()-coutPierre);
		jou.setBoisPossession(jou.getBoisPossession()-coutBois);
		jou.setOrPossession(jou.getOrPossession()-coutOr);
		jou.setNourriturePossession(jou.getNourriturePossession()-coutNourriture);
		
		// Mise à jour du joueur
		Joueur joueur = new Joueur(jou.getArmee(),jou.getIcone(),jou.getPseudo(),jou.getEmail(),jou.getMotDePasse(),jou.getDescriptif(),jou.getNiveau(),jou.getExperience(),jou.getPierrePossession(),jou.getBoisPossession(),jou.getOrPossession(),jou.getNourriturePossession(),jou.getGemmePossession(),jou.getPierreMaximum(),jou.getBoisMaximum(),jou.getOrMaximum(),jou.getNourritureMaximum(),jou.getPierreBoostProduction(),jou.getBoisBoostProduction(),jou.getOrBoostProduction(),jou.getNourritureBoostProduction(),jou.getTempsDeJeu(),jou.getRoles());
		joueur.setId(jou.getId());
		joueurRepo.save(joueur);
		
		// ---------- RETRAIT UNITEES ----------
		// Parcourir les armées que possède déjà le joueur, pour y soustraire les unitées qu'il envoi en expédition
		for (Armee arme : armeeRepo.findByJoueur(jou)) {
			if(arme.getUnitee().getId()==1) // Villageois
			{
				armee.setId(arme.getId());
				armee.setJoueur(jou);
				armee.setUnitee(arme.getUnitee());
				armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombreVillageois());
				armeeRepo.save(armee);
				listeArmees.add(armee);
			} 
			else if(arme.getUnitee().getId()==2)  // Archer
			{
				armee.setId(arme.getId());
				armee.setJoueur(jou);
				armee.setUnitee(arme.getUnitee());
				armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombreArcher());
				armeeRepo.save(armee);
				listeArmees.add(armee);
			} 
			else if(arme.getUnitee().getId()==3)  // ArcherComposite
			{
				armee.setId(arme.getId());
				armee.setJoueur(jou);
				armee.setUnitee(arme.getUnitee());
				armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombreArcherComposite());
				armeeRepo.save(armee);
				listeArmees.add(armee);
			} 
			else if(arme.getUnitee().getId()==4)  // FantassinEpee
			{
				armee.setId(arme.getId());
				armee.setJoueur(jou);
				armee.setUnitee(arme.getUnitee());
				armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombreFantassinEpee());
				armeeRepo.save(armee);
				listeArmees.add(armee);
			} 
			else if(arme.getUnitee().getId()==5)  // nombreHommeDArme
			{
				armee.setId(arme.getId());
				armee.setJoueur(jou);
				armee.setUnitee(arme.getUnitee());
				armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombreHommeDArme());
				armeeRepo.save(armee);
				listeArmees.add(armee);
			} 
			else if(arme.getUnitee().getId()==6)  // nombreLanceurDeHache
			{
				armee.setId(arme.getId());
				armee.setJoueur(jou);
				armee.setUnitee(arme.getUnitee());
				armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombreLanceurDeHache());
				armeeRepo.save(armee);
				listeArmees.add(armee);
			} 
			else if(arme.getUnitee().getId()==7)  // nombreMilicien
			{
				armee.setId(arme.getId());
				armee.setJoueur(jou);
				armee.setUnitee(arme.getUnitee());
				armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombreMilicien());
				armeeRepo.save(armee);
				listeArmees.add(armee);
			} 
			else if(arme.getUnitee().getId()==8)  // nombrePiquier
			{
				armee.setId(arme.getId());
				armee.setJoueur(jou);
				armee.setUnitee(arme.getUnitee());
				armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombrePiquier());
				armeeRepo.save(armee);
				listeArmees.add(armee);
			} 
			else if(arme.getUnitee().getId()==9)  // nombreCavalierArcher
			{
				armee.setId(arme.getId());
				armee.setJoueur(jou);
				armee.setUnitee(arme.getUnitee());
				armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombreCavalierArcher());
				armeeRepo.save(armee);
				listeArmees.add(armee);
			} 
			else if(arme.getUnitee().getId()==10)  // nombreCavalier
			{
				armee.setId(arme.getId());
				armee.setJoueur(jou);
				armee.setUnitee(arme.getUnitee());
				armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombreCavalier());
				armeeRepo.save(armee);
				listeArmees.add(armee);
			} 
			else if(arme.getUnitee().getId()==11)  // nombreChampion
			{
				armee.setId(arme.getId());
				armee.setJoueur(jou);
				armee.setUnitee(arme.getUnitee());
				armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombreChampion());
				armeeRepo.save(armee);
				listeArmees.add(armee);
			} 
			else if(arme.getUnitee().getId()==12)  // nombreBateauDePeche
			{
				armee.setId(arme.getId());
				armee.setJoueur(jou);
				armee.setUnitee(arme.getUnitee());
				armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombreBateauDePeche());
				armeeRepo.save(armee);
				listeArmees.add(armee);
			} 
			else if(arme.getUnitee().getId()==13)  // nombreBateauIncendiaire
			{
				armee.setId(arme.getId());
				armee.setJoueur(jou);
				armee.setUnitee(arme.getUnitee());
				armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombreBateauIncendiaire());
				armeeRepo.save(armee);
				listeArmees.add(armee);
			} 
			else if(arme.getUnitee().getId()==14)  // nombreBateauDeDestruction
			{
				armee.setId(arme.getId());
				armee.setJoueur(jou);
				armee.setUnitee(arme.getUnitee());
				armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombreBateauDeDestruction());
				armeeRepo.save(armee);
				listeArmees.add(armee);
			} 
			else if(arme.getUnitee().getId()==15)  // nombreGalionACanon
			{
				armee.setId(arme.getId());
				armee.setJoueur(jou);
				armee.setUnitee(arme.getUnitee());
				armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombreGalionACanon());
				armeeRepo.save(armee);
				listeArmees.add(armee);
			} 
			else if(arme.getUnitee().getId()==16)  // nombreGalion
			{
				armee.setId(arme.getId());
				armee.setJoueur(jou);
				armee.setUnitee(arme.getUnitee());
				armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombreGalion());
				armeeRepo.save(armee);
				listeArmees.add(armee);
			} 
			else if(arme.getUnitee().getId()==17)  // nombreGuerrierElite
			{
				armee.setId(arme.getId());
				armee.setJoueur(jou);
				armee.setUnitee(arme.getUnitee());
				armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombreGuerrierElite());
				armeeRepo.save(armee);
				listeArmees.add(armee);
			} 
			else if(arme.getUnitee().getId()==18)  // nombrePhalange
			{
				armee.setId(arme.getId());
				armee.setJoueur(jou);
				armee.setUnitee(arme.getUnitee());
				armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombrePhalange());
				armeeRepo.save(armee);
				listeArmees.add(armee);
			} 
			else if(arme.getUnitee().getId()==19)  // nombreSamourail
			{
				armee.setId(arme.getId());
				armee.setJoueur(jou);
				armee.setUnitee(arme.getUnitee());
				armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombreSamourail());
				armeeRepo.save(armee);
				listeArmees.add(armee);
			} 
			else if(arme.getUnitee().getId()==20)  // nombreTemplier
			{
				armee.setId(arme.getId());
				armee.setJoueur(jou);
				armee.setUnitee(arme.getUnitee());
				armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombreTemplier());
				armeeRepo.save(armee);
				listeArmees.add(armee);
			} 
			else if(arme.getUnitee().getId()==21)  // nombreCatapulte
			{
				armee.setId(arme.getId());
				armee.setJoueur(jou);
				armee.setUnitee(arme.getUnitee());
				armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombreCatapulte());
				armeeRepo.save(armee);
				listeArmees.add(armee);
			} 
			else if(arme.getUnitee().getId()==22)  // nombreElephantDeCombat
			{
				armee.setId(arme.getId());
				armee.setJoueur(jou);
				armee.setUnitee(arme.getUnitee());
				armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombreElephantDeCombat());
				armeeRepo.save(armee);
				listeArmees.add(armee);
			} 
			else if(arme.getUnitee().getId()==23)  // nombrePretre
			{
				armee.setId(arme.getId());
				armee.setJoueur(jou);
				armee.setUnitee(arme.getUnitee());
				armee.setQuantitee(arme.getQuantitee()-compositionArmeeExpedition.getNombrePretre());
				armeeRepo.save(armee);
				listeArmees.add(armee);
			}

		}
		// Génération des dates début/fin
		long debut = new Date().getTime();
		long fin = new Date().getTime()+(expedition.getDureeExpedition()*1000);
		
		// Création de l'expedition joueur
		ExpeditionJoueur expeditionJoueur = new ExpeditionJoueur();
		expeditionJoueur.setJoueur(jou);
		expeditionJoueur.setExpedition(expedition);
		expeditionJoueur.setDateDebutExpedition(debut);
		expeditionJoueur.setDateFinExpedition(fin);
		expeditionJoueur.setArmeeEnvoiJoueur(listeArmees);
		expeditionJoueur.setRecompenseRecuperee(false);
		
		expeditionJoueurRepo.save(expeditionJoueur);
		return null;
	}
	
	public String recupererRecompense(Integer idExpedition) {
		
		// Récupération informations expeditionJouer
		ExpeditionJoueur expdJoueur = this.rechercherExpeditionJoueurById(idExpedition);
		
		// Vérification récompense disponnible (Si elle à pas déjà été perçu)
		if(expdJoueur.getRecompenseRecuperee() == true) {
			throw new RecompenseDejaPercuException("Vous avez déjà perçu cette récompense.");
		}
		
		// Création d'une expeditionJoueur à partir de notre recherche
		ExpeditionJoueur expeditionJoueur = new ExpeditionJoueur();
		expeditionJoueur.setId(expdJoueur.getId());
		expeditionJoueur.setJoueur(expdJoueur.getJoueur());
		expeditionJoueur.setExpedition(expdJoueur.getExpedition());
		expeditionJoueur.setDateDebutExpedition(expdJoueur.getDateDebutExpedition());
		expeditionJoueur.setDateFinExpedition(expdJoueur.getDateFinExpedition());
		expeditionJoueur.setArmeeEnvoiJoueur(expdJoueur.getArmeeEnvoiJoueur());
		// On change l'état de la récompense
		expeditionJoueur.setRecompenseRecuperee(true);
		
		// Récupération joueur, pour y attribuer les ressources
		Joueur jou = joueurService.recuperationJoueur();
		jou.setPierrePossession(jou.getPierrePossession() + expdJoueur.getExpedition().getRecompensePierre());
		jou.setBoisPossession(jou.getBoisPossession() + expdJoueur.getExpedition().getRecompenseBois());
		jou.setOrPossession(jou.getOrPossession() + expdJoueur.getExpedition().getRecompenseOr());
		jou.setNourriturePossession(jou.getNourriturePossession() + expdJoueur.getExpedition().getRecompenseNourriture());
		jou.setGemmePossession(jou.getGemmePossession() + expdJoueur.getExpedition().getRecompenseGemme());
		
		// Sauvegarges
		expeditionJoueurRepo.save(expeditionJoueur);
		joueurRepo.save(jou);
		return "Ok";
		
		
	
	}
	
}
