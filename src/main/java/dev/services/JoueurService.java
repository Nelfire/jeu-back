package dev.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import dev.controller.dto.InformationRessourcesJoueur;
import dev.controller.dto.JoueurDto;
import dev.controller.dto.JoueurInfoDto;
import dev.controller.dto.ModificationJoueurDto;
import dev.entites.Joueur;
import dev.entites.joueur.BatimentJoueur;
import dev.exceptions.JoueurAuthentifieNonRecupereException;
import dev.repository.JoueurRepo;
import dev.repository.joueur.BatimentJoueurRepo;

@Service
public class JoueurService {

	// Déclarations
	private JoueurRepo joueurRepo;
	private BatimentJoueurRepo batimentJoueurRepo;

	/**
	 * Constructeur
	 *
	 * @param absenceRepository
	 */
	public JoueurService(JoueurRepo joueurRepo, BatimentJoueurRepo batimentJoueurRepo) {
		this.joueurRepo = joueurRepo;
		this.batimentJoueurRepo = batimentJoueurRepo;
	}

	/**
	 * RECUPERATION DES INFORMATIONS DU JOUEUR CONNECTE
	 */
	public Joueur recuperationJoueur() {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		Joueur jou = joueurRepo.findByEmail(email).orElseThrow(
				() -> new JoueurAuthentifieNonRecupereException("Le joueur authentifié n'a pas pu être récupéré"));
		return jou;
	}

	/**
	 * LISTER TOUS LES JOUEURS
	 */
	public List<JoueurDto> getAllJoueurs() {
		List<JoueurDto> listeJoueurs = new ArrayList<>();

		for (Joueur joueur : joueurRepo.findAll()) {

			JoueurDto joueurDto = new JoueurDto();
			joueurDto.setIcone(joueur.getIcone());
			joueurDto.setPseudo(joueur.getPseudo());
			joueurDto.setEmail(joueur.getEmail());
			joueurDto.setMotDePasse(joueur.getMotDePasse());
			joueurDto.setDescriptif(joueur.getDescriptif());
			joueurDto.setNiveau(joueur.getNiveau());
			joueurDto.setExperience(joueur.getExperience());
			joueurDto.setPierrePossession(joueur.getPierrePossession());
			joueurDto.setBoisPossession(joueur.getBoisPossession());
			joueurDto.setOrPossession(joueur.getOrPossession());
			joueurDto.setNourriturePossession(joueur.getNourriturePossession());
			joueurDto.setGemmePossession(joueur.getGemmePossession());
			joueurDto.setPierreMaximum(joueur.getPierreMaximum());
			joueurDto.setBoisMaximum(joueur.getBoisMaximum());
			joueurDto.setOrMaximum(joueur.getOrMaximum());
			joueurDto.setNourritureMaximum(joueur.getNourritureMaximum());
			joueurDto.setPierreBoostProduction(joueur.getPierreBoostProduction());
			joueurDto.setBoisBoostProduction(joueur.getBoisBoostProduction());
			joueurDto.setOrBoostProduction(joueur.getOrBoostProduction());
			joueurDto.setNourritureBoostProduction(joueur.getNourritureBoostProduction());
			joueurDto.setTempsDeJeu(joueur.getTempsDeJeu());

			listeJoueurs.add(joueurDto);

		}
		return listeJoueurs;
	}

	/**
	 * LISTER INFORMATIONS (Moins d'infos)
	 */
	public List<JoueurInfoDto> getAllInfoJoueurs() {
		List<JoueurInfoDto> listeJoueurs = new ArrayList<>();

		for (Joueur joueur : joueurRepo.findAll((Sort.by(Sort.Direction.DESC, "niveau")))) {

			JoueurInfoDto joueurDto = new JoueurInfoDto();
			joueurDto.setId(joueur.getId());
			joueurDto.setIcone(joueur.getIcone());
			joueurDto.setPseudo(joueur.getPseudo());
			joueurDto.setNiveau(joueur.getNiveau());
			joueurDto.setTempsDeJeu(joueur.getTempsDeJeu());
			listeJoueurs.add(joueurDto);

		}
		return listeJoueurs;
	}
	
	/**
	 * INFORMATION DU JOUEUR VIA ID
	 */
	public JoueurInfoDto informationJoueurById(Integer id) {
		Optional<Joueur> jou = joueurRepo.findById(id);
		JoueurInfoDto joueur = new JoueurInfoDto();
		joueur.setId(jou.get().getId());
		joueur.setIcone(jou.get().getIcone());
		joueur.setPseudo(jou.get().getPseudo());
		joueur.setDescriptif(jou.get().getDescriptif());
		joueur.setNiveau(jou.get().getNiveau());
		joueur.setExperience(jou.get().getExperience());
		joueur.setTempsDeJeu(jou.get().getTempsDeJeu());
		return joueur;
	}

	/**
	 * RECUPERATION INFORMATIONS JOUEUR CONNECTE
	 */
	public JoueurInfoDto getInfoJoueur() {
		// RÉCUPÉRATION DU JOUEUR CONNECTÉ
		Joueur jou = recuperationJoueur();
		
		// INITIALISATION
		// Calcul ressources à donner au joueur pour son absence :
		// - Date de maintenant
		Date now = new Date();
		// Si premiere connexion du joueur, initialisation
		if(jou.getDerniereConnexion()==null) {
			jou.setDerniereConnexion(now);
		}
		// Calcul du temps passé hors connexion, pour attribution des ressources
		// milliseconde < 1000 ? Si oui --> 1000
		Integer millisecondesDifference = (int) (now.getTime()-jou.getDerniereConnexion().getTime()) < 1000 ? 1000 :(int) (now.getTime()-jou.getDerniereConnexion().getTime());

		//System.out.println("Temps depuis derniere attribution de ressources : "+millisecondesDifference);
		//////////////////////////////////
		// -- ATTRIBUTION RESSOURCES -- //
		//////////////////////////////////
		
		// PIERRE : CALCUL APPORT PAR SECONDE POUR LE JOUEUR
		Integer apportPierreSeconde = apportPierreSeconde();
		//System.out.println("apportPierreSeconde : "+apportPierreSeconde);
		// - CAS INACTIVITEE -
		Integer apportPierreFinal = (apportPierreSeconde * millisecondesDifference)/1000;
		//System.out.println("apportPierreFinal : "+apportPierreFinal);
		
		// BOIS : CALCUL APPORT PAR SECONDE POUR LE JOUEUR
		Integer apportBoisSeconde = apportBoisSeconde();
		// - CAS INACTIVITEE -
		Integer apportBoisFinal = (apportBoisSeconde * millisecondesDifference)/1000;
		
		// OR : CALCUL APPORT PAR SECONDE POUR LE JOUEUR
		Integer apportOrSeconde = apportOrSeconde();
		// - CAS INACTIVITEE -
		Integer apportOrFinal = (apportOrSeconde * millisecondesDifference)/1000;
		
		// NOURRITURE : CALCUL APPORT PAR SECONDE POUR LE JOUEUR
		Integer apportNourritureSeconde = apportNourritureSeconde();
		// - CAS INACTIVITEE -
		Integer apportNourritureFinal = (apportNourritureSeconde * millisecondesDifference)/1000;
		
		//////////////////////////////////////
		// -- LIMITE STOCKAGE RESSOURCES -- //
		//////////////////////////////////////

		// PIERRE
		Integer stockageMaximalPierre = quantiteMaximaleStockagePierre();	
		
		// BOIS
		Integer stockageMaximalBois = quantiteMaximaleStockageBois();
		
		// OR
		Integer stockageMaximalOr = quantiteMaximaleStockageOr();
		
		// NOURRITURE
		Integer stockageMaximalNourriture = quantiteMaximaleStockageNourriture();
		
		
		// ACTUALISATION DES DONNEES DU JOUEUR
		// APPORT
		jou.setPierrePossession((jou.getPierrePossession() + apportPierreFinal)>jou.getPierreMaximum() ? jou.getPierreMaximum() : jou.getPierrePossession() + apportPierreFinal);
		jou.setBoisPossession((jou.getBoisPossession() + apportBoisFinal)>jou.getBoisMaximum() ? jou.getBoisMaximum() : jou.getBoisPossession() + apportBoisFinal);
		jou.setOrPossession((jou.getOrPossession() + apportOrFinal)>jou.getOrMaximum() ? jou.getOrMaximum() : jou.getOrPossession() + apportOrFinal);
		jou.setNourriturePossession((jou.getNourriturePossession() + apportNourritureFinal)>jou.getNourritureMaximum() ? jou.getNourritureMaximum() : jou.getNourriturePossession() + apportNourritureFinal);
		// LIMITE
		jou.setPierreMaximum(stockageMaximalPierre);
		jou.setBoisMaximum(stockageMaximalBois);
		jou.setOrMaximum(stockageMaximalOr);
		jou.setNourritureMaximum(stockageMaximalNourriture);
		// TEMPS DE JEU
		jou.setTempsDeJeu(jou.getTempsDeJeu() + (millisecondesDifference/1000));
		Date dateAujourdhui  = new Date(); 
		jou.setDerniereConnexion(dateAujourdhui);

		// MISE A JOUR DU JOUEUR
		Joueur joueur = new Joueur(jou.getArmee(), jou.getIcone(), jou.getPseudo(), jou.getEmail(), jou.getMotDePasse(),
				jou.getDescriptif(), jou.getNiveau(), jou.getExperience(), jou.getPierrePossession(),
				jou.getBoisPossession(), jou.getOrPossession(), jou.getNourriturePossession(), jou.getGemmePossession(),
				jou.getPierreMaximum(), jou.getBoisMaximum(), jou.getOrMaximum(), jou.getNourritureMaximum(),
				jou.getPierreBoostProduction(), jou.getBoisBoostProduction(), jou.getOrBoostProduction(),
				jou.getNourritureBoostProduction(), jou.getTempsDeJeu(), jou.getRoles(), jou.getDerniereConnexion());
		joueur.setId(jou.getId());
		
		// SAUVEGARDE
		//System.out.println("SAUVEGARDE RESSOURCES JOUEUR");
		this.joueurRepo.save(joueur);

		// RETOUR
		JoueurInfoDto co = new JoueurInfoDto(jou.getId(), jou.getIcone(), jou.getPseudo(), jou.getEmail(),
				jou.getDescriptif(), jou.getNiveau(), jou.getExperience(), jou.getPierrePossession(),
				jou.getBoisPossession(), jou.getOrPossession(), jou.getNourriturePossession(), jou.getGemmePossession(),
				jou.getPierreMaximum(), jou.getBoisMaximum(), jou.getOrMaximum(), jou.getNourritureMaximum(),
				jou.getPierreBoostProduction(), jou.getBoisBoostProduction(), jou.getOrBoostProduction(),
				jou.getNourritureBoostProduction(), jou.getTempsDeJeu(), jou.getDerniereConnexion());
		return co;
	}
	
	/**
	 * RECAPITULATIF DES INFORMATIONS RESSOURCE DU JOUEUR
	 */
	public InformationRessourcesJoueur informationRessourcesJoueur() {
		getInfoJoueur();
		Joueur jou = recuperationJoueur();
		InformationRessourcesJoueur informationRessourcesJoueur = new InformationRessourcesJoueur();
		// Ses apports
		Integer apportPierreSeconde = apportPierreSeconde();
		Integer apportBoisSeconde = apportBoisSeconde();
		Integer apportOrSeconde = apportOrSeconde();
		Integer apportNourritureSeconde = apportNourritureSeconde();
		// Ses limites
		Integer quantiteMaximaleStockagePierre = quantiteMaximaleStockagePierre();
		Integer quantiteMaximaleStockageBois = quantiteMaximaleStockageBois();
		Integer quantiteMaximaleStockageOr = quantiteMaximaleStockageOr();
		Integer quantiteMaximaleStockageNourriture = quantiteMaximaleStockageNourriture();
		// Ses ressources actuelle
		Integer pierrePossession = jou.getPierrePossession();
		Integer boisPossession = jou.getBoisPossession();
		Integer orPossession = jou.getOrPossession();
		Integer nourriturePossession = jou.getNourriturePossession();
		Integer gemmePossession = jou.getGemmePossession();
		
		//////////////////
		// SET : Apports
		informationRessourcesJoueur.setApportPierreSeconde(apportPierreSeconde);
		informationRessourcesJoueur.setApportBoisSeconde(apportBoisSeconde);
		informationRessourcesJoueur.setApportOrSeconde(apportOrSeconde);
		informationRessourcesJoueur.setApportNourritureSeconde(apportNourritureSeconde);
		// SET : Limites
		informationRessourcesJoueur.setQuantiteMaximaleStockagePierre(quantiteMaximaleStockagePierre);
		informationRessourcesJoueur.setQuantiteMaximaleStockageBois(quantiteMaximaleStockageBois);
		informationRessourcesJoueur.setQuantiteMaximaleStockageOr(quantiteMaximaleStockageOr);
		informationRessourcesJoueur.setQuantiteMaximaleStockageNourriture(quantiteMaximaleStockageNourriture);
		// SET : ressources actuelles
		informationRessourcesJoueur.setPierrePossession(pierrePossession);
		informationRessourcesJoueur.setBoisPossession(boisPossession);
		informationRessourcesJoueur.setOrPossession(orPossession);
		informationRessourcesJoueur.setNourriturePossession(nourriturePossession);
		informationRessourcesJoueur.setGemmePossession(gemmePossession);
		
		// RETOUR
		return informationRessourcesJoueur;
	}
	


	////////////////////
	//////STOCKAGE//////
	////////////////////
	
	/**
	 * STOCKAGE : QUANTITE MAXIMALE DE STOCKAGE DE PIERRE POUR LE JOUEUR
	 */
	private Integer quantiteMaximaleStockagePierre() {
		// Récupération du joueur connecté
		Joueur jou = recuperationJoueur();
		// -- PIERRE -
		Integer stockageMaximalPierre = 10000;
		// -- TOUS LES BATIMENTS QUI AUGMENTENT LA LIMITE DE STOCKAGE DE PIERRE
		for (BatimentJoueur batimentStockagePierre : batimentJoueurRepo.findByQuantiteeStockagePierreGreaterThanAndJoueurId(1,jou.getId())) {
			long maintenant = new Date().getTime();
			long fin = batimentStockagePierre.getDateFinConstruction();
			// Si le batiment est en cours d'amélioration, augmentation pas prise en compte
			if(maintenant>fin) {
				stockageMaximalPierre = stockageMaximalPierre + batimentStockagePierre.getQuantiteeStockagePierre();
			} 
			else // Sinon, prise en compte
			{
				// Vérification que la bâtiment est déjà construit
				if(batimentStockagePierre.getNiveau()>1) {
					stockageMaximalPierre = stockageMaximalPierre + batimentStockagePierre.getQuantiteeStockagePierre()/2;

				}
			}
		}
		return stockageMaximalPierre;
	}
	
	/**
	 * STOCKAGE : QUANTITE MAXIMALE DE STOCKAGE DE BOIS POUR LE JOUEUR
	 */
	private Integer quantiteMaximaleStockageBois() {
		// Récupération du joueur connecté
		Joueur jou = recuperationJoueur();
		// -- BOIS --
		Integer stockageMaximalBois = 10000;
		// -- TOUS LES BATIMENTS QUI AUGMENTENT LA LIMITE DE STOCKAGE DE BOIS
		for (BatimentJoueur batimentStockageBois : batimentJoueurRepo.findByQuantiteeStockageBoisGreaterThanAndJoueurId(1,jou.getId())) {
			long maintenant = new Date().getTime();
			long fin = batimentStockageBois.getDateFinConstruction();
			// Si le batiment est en cours d'amélioration, augmentation pas prise en compte
			if(maintenant>fin) {
				stockageMaximalBois = stockageMaximalBois + batimentStockageBois.getQuantiteeStockageBois();
			} 
			else // Sinon, prise en compte
			{
				// Vérification que la bâtiment est déjà construit
				if(batimentStockageBois.getNiveau()>1) {
					stockageMaximalBois = stockageMaximalBois + batimentStockageBois.getQuantiteeStockageBois()/2;

				}
			}
		}
		return stockageMaximalBois;
	}
	
	/**
	 * STOCKAGE : QUANTITE MAXIMALE DE STOCKAGE D'OR POUR LE JOUEUR
	 */
	private Integer quantiteMaximaleStockageOr() {
		// Récupération du joueur connecté
		Joueur jou = recuperationJoueur();
		// -- OR --
		Integer stockageMaximalOr = 10000;
		// -- TOUS LES BATIMENTS QUI AUGMENTENT LA LIMITE DE STOCKAGE DE OR
		for (BatimentJoueur batimentStockageOr : batimentJoueurRepo.findByQuantiteeStockageOreGreaterThanAndJoueurId(1,jou.getId())) {
			long maintenant = new Date().getTime();
			long fin = batimentStockageOr.getDateFinConstruction();
			// Si le batiment est en cours d'amélioration, augmentation pas prise en compte
			if(maintenant>fin) {
				stockageMaximalOr = stockageMaximalOr + batimentStockageOr.getQuantiteeStockageOre();
			} 
			else // Sinon, prise en compte
			{
				// Vérification que la bâtiment est déjà construit
				if(batimentStockageOr.getNiveau()>1) {
					stockageMaximalOr = stockageMaximalOr + batimentStockageOr.getQuantiteeStockageOre()/2;

				}
			}
		}
		return stockageMaximalOr;
	}

	/**
	 * STOCKAGE : QUANTITE MAXIMALE DE STOCKAGE DE NOURRITURE POUR LE JOUEUR
	 */
	private Integer quantiteMaximaleStockageNourriture() {
		// Récupération du joueur connecté
		Joueur jou = recuperationJoueur();
		// -- NOURRITURE --
		Integer stockageMaximalNourriture = 10000;
		// -- TOUS LES BATIMENTS QUI AUGMENTENT LA LIMITE DE STOCKAGE DE NOURRITURE
		for (BatimentJoueur batimentStockageNourriture : batimentJoueurRepo.findByQuantiteeStockageNourritureGreaterThanAndJoueurId(1,jou.getId())) {
			long maintenant = new Date().getTime();
			long fin = batimentStockageNourriture.getDateFinConstruction();
			// Si le batiment est en cours d'amélioration, augmentation pas prise en compte
			if(maintenant>fin) {
				stockageMaximalNourriture = stockageMaximalNourriture + batimentStockageNourriture.getQuantiteeStockageNourriture();
			} 
			else // Sinon, prise en compte
			{
				// Vérification que la bâtiment est déjà construit
				if(batimentStockageNourriture.getNiveau()>1) {
					stockageMaximalNourriture = stockageMaximalNourriture + batimentStockageNourriture.getQuantiteeStockageNourriture()/2;

				}
			}
		}
		return stockageMaximalNourriture;
	}


	//////////////////
	//////APPORT//////
	//////////////////
	
	/**
	 * APPORT : RETOURNE LA QUANTITE DE PIERRE QUE LE JOUEUR GAGNE PAR SECONDE
	 */
	private Integer apportPierreSeconde() {	
		// Récupération du joueur connecté
		Joueur jou = recuperationJoueur();
		// -- PIERRE --
		// CALCUL APPORT PAR HEURE DU JOUEUR
		Integer apportPierreHeure = 1;
		// -- TOUS LES BATIMENTS QUI RAPPORTENT DE LA PIERRE
		for (BatimentJoueur batimentPierre : batimentJoueurRepo.findByApportPierreHeureGreaterThanAndJoueurId(1,jou.getId())) {
			// Si le batiment est en cours d'amélioration, apport de ressources pas pris en compte
			long maintenant = new Date().getTime();
			long fin = batimentPierre.getDateFinConstruction();
			if(maintenant>fin) {
				apportPierreHeure = apportPierreHeure + batimentPierre.getApportPierreHeure();
			}
		}
		// -- APPORT PIERRE PAR SECONDES
		
		Integer apportPierreSeconde = Math.round(apportPierreHeure / 3600);
		return apportPierreSeconde;
	}

	/**
	 * APPORT : RETOURNE LA QUANTITE DE BOIS QUE LE JOUEUR GAGNE PAR SECONDE
	 */
	private Integer apportBoisSeconde() {
		// Récupération du joueur connecté
		Joueur jou = recuperationJoueur();
		// -- BOIS --
		// CALCUL APPORT PAR HEURE DU JOUEUR
		Integer apportBoisHeure = 1;
		// -- TOUS LES BATIMENTS QUI RAPPORTENT DU BOIS
		for (BatimentJoueur batimentBois : batimentJoueurRepo.findByApportBoisHeureGreaterThanAndJoueurId(1,jou.getId())) {
			// Si le batiment est en cours d'amélioration, apport de ressources pas pris en compte
			long maintenant = new Date().getTime();
			long fin = batimentBois.getDateFinConstruction();
			if(maintenant>fin) {
				apportBoisHeure = apportBoisHeure + batimentBois.getApportBoisHeure();
			}
		}
		// -- APPORT BOIS PAR SECONDES
		Integer apportBoisSeconde =  Math.round(apportBoisHeure / 3600);
		return apportBoisSeconde;
	}

	/**
	 * APPORT : RETOURNE LA QUANTITE D'OR QUE LE JOUEUR GAGNE PAR SECONDE
	 */
	private Integer apportOrSeconde() {
		// Récupération du joueur connecté
		Joueur jou = recuperationJoueur();
		// -- OR --
		// CALCUL APPORT PAR HEURE DU JOUEUR
		Integer apportOrHeure = 1;
		// -- TOUS LES BATIMENTS QUI RAPPORTENT DE L'OR
		for (BatimentJoueur batimentOr : batimentJoueurRepo.findByApportOreHeureGreaterThanAndJoueurId(1,jou.getId())) {
			// Si le batiment est en cours d'amélioration, apport de ressources pas pris en compte
			long maintenant = new Date().getTime();
			long fin = batimentOr.getDateFinConstruction();
			if(maintenant>fin) {
				apportOrHeure = apportOrHeure + batimentOr.getApportOreHeure();
			}
		}
		// -- APPORT OR PAR SECONDES
		Integer apportOrSeconde =  Math.round(apportOrHeure / 3600);
		return apportOrSeconde;
	}
	
	/**
	 * APPORT : RETOURNE LA QUANTITE DE NOURRITURE QUE LE JOUEUR GAGNE PAR SECONDE
	 */
	private Integer apportNourritureSeconde() {
		// Récupération du joueur connecté
		Joueur jou = recuperationJoueur();
		// -- NOURRITURE --
		// CALCUL APPORT PAR HEURE DU JOUEUR
		Integer apportNourritureHeure = 1;
		// -- TOUS LES BATIMENTS QUI RAPPORTENT DE LA NOURRITURE
		for (BatimentJoueur batimentNourriture : batimentJoueurRepo.findByApportNourritureHeureGreaterThanAndJoueurId(1,jou.getId())) {
			// Si le batiment est en cours d'amélioration, apport de ressources pas pris en compte
			long maintenant = new Date().getTime();
			long fin = batimentNourriture.getDateFinConstruction();
			if(maintenant>fin) {
				apportNourritureHeure = apportNourritureHeure + batimentNourriture.getApportNourritureHeure();
			}
		}
		// -- APPORT NOURRITURE PAR SECONDES
		Integer apportNourritureSeconde =  Math.round(apportNourritureHeure / 3600);
		return apportNourritureSeconde;
	}
	
	/**
	 * MODIFICATION INFORMATIONS DU JOUEUR
	 */
	public Joueur modifierInformationsJoueur(ModificationJoueurDto modificationJoueurDto) {
		Joueur jou = recuperationJoueur();
		jou.setIcone(modificationJoueurDto.getIcone());
		jou.setEmail(modificationJoueurDto.getEmail());
		jou.setDescriptif(modificationJoueurDto.getDescriptif());
		Joueur joueur = new Joueur(jou.getArmee(), jou.getIcone(), jou.getPseudo(), jou.getEmail(), jou.getMotDePasse(),
				jou.getDescriptif(), jou.getNiveau(), jou.getExperience(), jou.getPierrePossession(),
				jou.getBoisPossession(), jou.getOrPossession(), jou.getNourriturePossession(), jou.getGemmePossession(),
				jou.getPierreMaximum(), jou.getBoisMaximum(), jou.getOrMaximum(), jou.getNourritureMaximum(),
				jou.getPierreBoostProduction(), jou.getBoisBoostProduction(), jou.getOrBoostProduction(),
				jou.getNourritureBoostProduction(), jou.getTempsDeJeu(), jou.getRoles(), jou.getDerniereConnexion());
		joueur.setId(jou.getId());
		
		// SAUVEGARDE
		joueurRepo.save(jou);

		// RETOUR
		return jou;
	}
	

}
