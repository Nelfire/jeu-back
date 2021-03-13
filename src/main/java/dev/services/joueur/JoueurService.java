package dev.services.joueur;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import dev.controller.dto.divers.EchangeRessourceDto;
import dev.controller.dto.divers.GainRessourceDto;
import dev.controller.dto.joueur.InformationRessourcesJoueur;
import dev.controller.dto.joueur.JoueurDto;
import dev.controller.dto.joueur.JoueurInfoDto;
import dev.controller.dto.joueur.JoueurInfoMinimaleDto;
import dev.controller.dto.joueur.ModificationJoueurDto;
import dev.entites.batiment.BatimentJoueur;
import dev.entites.joueur.Joueur;
import dev.exceptions.JoueurAuthentifieNonRecupereException;
import dev.exceptions.MessageResponseException;
import dev.repository.JoueurRepo;
import dev.repository.joueur.BatimentJoueurRepo;

@Service
public class JoueurService {

	// Déclarations
	private JoueurRepo joueurRepo;
	private BatimentJoueurRepo batimentJoueurRepo;

	/**
	 * @param joueurRepo
	 * @param batimentJoueurRepo
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
	 * RECUPERER TOUS LES JOUEURS
	 */
	public List<JoueurDto> getAllJoueurs() {

		// INITIALISATIONS
		List<JoueurDto> listeJoueurs = new ArrayList<>();

		// RECHERCHE DE TOUS LES JOUEURS
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
			joueurDto.setPositionX(joueur.getPositionX());
			joueurDto.setPositionY(joueur.getPositionY());

			// AJOUT AU TABLEAU
			listeJoueurs.add(joueurDto);

		}

		// RETOUR
		return listeJoueurs;
	}

	/**
	 * RECUPERATION DES INFORMATIONS DES JOUEURS
	 */
	public List<JoueurInfoMinimaleDto> getAllInfoJoueurs() {

		// INITIALISATIONS
		List<JoueurInfoMinimaleDto> listeJoueurs = new ArrayList<>();

		// RECHERCHE DE TOUS LES JOUEURS, CLASSE PAR NIVEAU
		for (Joueur joueur : joueurRepo.findAll((Sort.by(Sort.Direction.DESC, "niveau")))) {

			JoueurInfoMinimaleDto joueurDto = new JoueurInfoMinimaleDto();
			joueurDto.setId(joueur.getId());
			joueurDto.setIcone(joueur.getIcone());
			joueurDto.setPseudo(joueur.getPseudo());
			joueurDto.setDescriptif(joueur.getDescriptif());
			joueurDto.setNiveau(joueur.getNiveau());
			joueurDto.setExperience(joueur.getExperience());
			joueurDto.setTempsDeJeu(joueur.getTempsDeJeu());
			joueurDto.setDonateur(joueur.getDonateur());
			joueurDto.setPositionX(joueur.getPositionX());
			joueurDto.setPositionY(joueur.getPositionY());

			// AJOUT AU TABLEAU
			listeJoueurs.add(joueurDto);

		}

		// RETOUR
		return listeJoueurs;
	}

	/**
	 * RECUPERATION INFORMATIONS JOUEUR CONNECTE
	 */
	public JoueurInfoMinimaleDto informationJoueurById(Integer id) {

		// RECHERCHE D'UN JOUEUR PAR ID
		Optional<Joueur> jou = joueurRepo.findById(id);

		JoueurInfoMinimaleDto joueur = new JoueurInfoMinimaleDto();
		joueur.setId(jou.get().getId());
		joueur.setIcone(jou.get().getIcone());
		joueur.setPseudo(jou.get().getPseudo());
		joueur.setDescriptif(jou.get().getDescriptif());
		joueur.setNiveau(jou.get().getNiveau());
		joueur.setExperience(jou.get().getExperience());
		joueur.setTempsDeJeu(jou.get().getTempsDeJeu());
		joueur.setDonateur(jou.get().getDonateur());
		joueur.setPositionX(jou.get().getPositionX());
		joueur.setPositionY(jou.get().getPositionY());

		// RETOUR
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
		if (jou.getDerniereConnexion() == null) {
			jou.setDerniereConnexion(now);
		}
		// Calcul du temps passé hors connexion, pour attribution des ressources
		Integer millisecondesDifference = (int) (now.getTime() - jou.getDerniereConnexion().getTime());

		// Premiere initialisation
		millisecondesDifference = millisecondesDifference == 0 ? 1000 : millisecondesDifference;

		//////////////////////////////////
		// -- ATTRIBUTION RESSOURCES -- //
		//////////////////////////////////

		// PIERRE : CALCUL APPORT PAR SECONDE POUR LE JOUEUR
		Integer apportPierreSeconde = apportPierreSeconde();
		// - CAS INACTIVITEE -
		Integer apportPierreFinal = (apportPierreSeconde * millisecondesDifference / 1000);
		// BOIS : CALCUL APPORT PAR SECONDE POUR LE JOUEUR
		Integer apportBoisSeconde = apportBoisSeconde();
		// - CAS INACTIVITEE -
		Integer apportBoisFinal = (apportBoisSeconde * millisecondesDifference / 1000);

		// OR : CALCUL APPORT PAR SECONDE POUR LE JOUEUR
		Integer apportOrSeconde = apportOrSeconde();
		// - CAS INACTIVITEE -
		Integer apportOrFinal = (apportOrSeconde * millisecondesDifference / 1000);

		// NOURRITURE : CALCUL APPORT PAR SECONDE POUR LE JOUEUR
		Integer apportNourritureSeconde = apportNourritureSeconde();
		// - CAS INACTIVITEE -
		Integer apportNourritureFinal = (apportNourritureSeconde * millisecondesDifference / 1000);
		//////////////////////////////////////
		// -- LIMITE STOCKAGE RESSOURCES -- //
		//////////////////////////////////////

		// PIERRE
		Long stockageMaximalPierre = quantiteMaximaleStockagePierre();

		// BOIS
		Long stockageMaximalBois = quantiteMaximaleStockageBois();

		// OR
		Long stockageMaximalOr = quantiteMaximaleStockageOr();

		// NOURRITURE
		Long stockageMaximalNourriture = quantiteMaximaleStockageNourriture();

		// ACTUALISATION DES DONNEES DU JOUEUR
		// APPORT
		jou.setPierreMaximum(stockageMaximalPierre);
		jou.setBoisMaximum(stockageMaximalBois);
		jou.setOrMaximum(stockageMaximalOr);
		jou.setNourritureMaximum(stockageMaximalNourriture);
		// LIMITE
		jou.setPierrePossession(
				(jou.getPierrePossession() + apportPierreFinal) > jou.getPierreMaximum() ? jou.getPierreMaximum()
						: jou.getPierrePossession() + apportPierreFinal);
		if (jou.getPierrePossession() < 0) {
			jou.setPierrePossession(jou.getPierreMaximum());
		}
		jou.setBoisPossession((jou.getBoisPossession() + apportBoisFinal) > jou.getBoisMaximum() ? jou.getBoisMaximum()
				: jou.getBoisPossession() + apportBoisFinal);
		if (jou.getBoisPossession() < 0) {
			jou.setBoisPossession(jou.getBoisMaximum());
		}
		jou.setOrPossession((jou.getOrPossession() + apportOrFinal) > jou.getOrMaximum() ? jou.getOrMaximum()
				: jou.getOrPossession() + apportOrFinal);
		if (jou.getOrPossession() < 0) {
			jou.setOrPossession(jou.getOrMaximum());
		}
		jou.setNourriturePossession((jou.getNourriturePossession() + apportNourritureFinal) > jou.getNourritureMaximum()
				? jou.getNourritureMaximum()
				: jou.getNourriturePossession() + apportNourritureFinal);
		if (jou.getNourriturePossession() < 0) {
			jou.setNourriturePossession(jou.getNourritureMaximum());
		}

		// TEMPS DE JEU
		// Grosse inactivitée ? Pas prise en compte (+10 de minutes)
		Integer tempsActif = (millisecondesDifference / 1000) > 600 ? 0 : (millisecondesDifference / 1000);
		jou.setTempsDeJeu(jou.getTempsDeJeu() + tempsActif);
		Date dateAujourdhui = new Date();
		jou.setDerniereConnexion(dateAujourdhui);

		// MISE A JOUR DU JOUEUR
		Joueur joueur = new Joueur(jou.getArmee(), jou.getIcone(), jou.getPseudo(), jou.getEmail(), jou.getMotDePasse(),
				jou.getDescriptif(), jou.getNiveau(), jou.getExperience(), jou.getPierrePossession(),
				jou.getBoisPossession(), jou.getOrPossession(), jou.getNourriturePossession(), jou.getGemmePossession(),
				jou.getPierreMaximum(), jou.getBoisMaximum(), jou.getOrMaximum(), jou.getNourritureMaximum(),
				jou.getPierreBoostProduction(), jou.getBoisBoostProduction(), jou.getOrBoostProduction(),
				jou.getNourritureBoostProduction(), jou.getTempsDeJeu(), jou.getRoles(), jou.getDerniereConnexion(),
				jou.getDonateur(), jou.getPositionX(), jou.getPositionY());
		joueur.setId(jou.getId());

		// SAUVEGARDE
		this.joueurRepo.save(joueur);

		JoueurInfoDto co = new JoueurInfoDto(jou.getId(), jou.getIcone(), jou.getPseudo(), jou.getEmail(),
				jou.getDescriptif(), jou.getNiveau(), jou.getExperience(), jou.getPierrePossession(),
				jou.getBoisPossession(), jou.getOrPossession(), jou.getNourriturePossession(), jou.getGemmePossession(),
				jou.getPierreMaximum(), jou.getBoisMaximum(), jou.getOrMaximum(), jou.getNourritureMaximum(),
				jou.getPierreBoostProduction(), jou.getBoisBoostProduction(), jou.getOrBoostProduction(),
				jou.getNourritureBoostProduction(), jou.getTempsDeJeu(), jou.getDerniereConnexion(), jou.getDonateur(),
				jou.getPositionX(), jou.getPositionY());

		// RETOUR
		return co;

	}

	/**
	 * RECAPITULATIF DES INFORMATIONS RESSOURCE DU JOUEUR
	 */
	public InformationRessourcesJoueur informationRessourcesJoueur() {
		getInfoJoueur();

		// RÉCUPÉRATION DU JOUEUR CONNECTÉ
		Joueur jou = recuperationJoueur();
		InformationRessourcesJoueur informationRessourcesJoueur = new InformationRessourcesJoueur();
		// Ses apports
		Integer apportPierreSeconde = apportPierreSeconde();
		Integer apportBoisSeconde = apportBoisSeconde();
		Integer apportOrSeconde = apportOrSeconde();
		Integer apportNourritureSeconde = apportNourritureSeconde();
		// Ses limites
		Long quantiteMaximaleStockagePierre = quantiteMaximaleStockagePierre();
		Long quantiteMaximaleStockageBois = quantiteMaximaleStockageBois();
		Long quantiteMaximaleStockageOr = quantiteMaximaleStockageOr();
		Long quantiteMaximaleStockageNourriture = quantiteMaximaleStockageNourriture();
		// Ses ressources actuelle
		Long pierrePossession = jou.getPierrePossession();
		Long boisPossession = jou.getBoisPossession();
		Long orPossession = jou.getOrPossession();
		Long nourriturePossession = jou.getNourriturePossession();
		Long gemmePossession = jou.getGemmePossession();

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
	////// STOCKAGE//////
	////////////////////

	/**
	 * STOCKAGE : QUANTITE MAXIMALE DE STOCKAGE DE PIERRE POUR LE JOUEUR
	 */
	private Long quantiteMaximaleStockagePierre() {

		// Récupération du joueur connecté
		Joueur jou = recuperationJoueur();

		// -- PIERRE -
		Long stockageMaximalPierre = 20_000L;

		// -- TOUS LES BATIMENTS QUI AUGMENTENT LA LIMITE DE STOCKAGE DE PIERRE
		for (BatimentJoueur batimentStockagePierre : batimentJoueurRepo
				.findByQuantiteeStockagePierreGreaterThanAndJoueurId(1L, jou.getId())) {
			long maintenant = new Date().getTime();
			long fin = batimentStockagePierre.getDateFinConstruction();
			// Si le batiment est en cours d'amélioration, augmentation pas prise en compte
			if (maintenant > fin) {
				stockageMaximalPierre = stockageMaximalPierre + batimentStockagePierre.getQuantiteeStockagePierre();
			} else // Sinon, prise en compte
			{
				// Vérification que la bâtiment est déjà construit
				if (batimentStockagePierre.getNiveau() > 1) {
					stockageMaximalPierre = (long) (stockageMaximalPierre
							+ (batimentStockagePierre.getQuantiteeStockagePierre() / batimentStockagePierre.getBatiment().getMultiplicateurApport()));

				}
			}
		}

		// RETOUR
		return stockageMaximalPierre;
	}

	/**
	 * STOCKAGE : QUANTITE MAXIMALE DE STOCKAGE DE BOIS POUR LE JOUEUR
	 */
	private Long quantiteMaximaleStockageBois() {

		// Récupération du joueur connecté
		Joueur jou = recuperationJoueur();

		// -- BOIS --
		Long stockageMaximalBois = 20_000L;

		// -- TOUS LES BATIMENTS QUI AUGMENTENT LA LIMITE DE STOCKAGE DE BOIS
		for (BatimentJoueur batimentStockageBois : batimentJoueurRepo
				.findByQuantiteeStockageBoisGreaterThanAndJoueurId(1L, jou.getId())) {
			long maintenant = new Date().getTime();
			long fin = batimentStockageBois.getDateFinConstruction();
			// Si le batiment est en cours d'amélioration, augmentation pas prise en compte
			if (maintenant > fin) {
				stockageMaximalBois = stockageMaximalBois + batimentStockageBois.getQuantiteeStockageBois();
			} else // Sinon, prise en compte
			{
				// Vérification que la bâtiment est déjà construit
				if (batimentStockageBois.getNiveau() > 1) {
					stockageMaximalBois = (long) (stockageMaximalBois + (batimentStockageBois.getQuantiteeStockageBois() / batimentStockageBois.getBatiment().getMultiplicateurApport()));

				}
			}
		}

		// RETOUR
		return stockageMaximalBois;
	}

	/**
	 * STOCKAGE : QUANTITE MAXIMALE DE STOCKAGE D'OR POUR LE JOUEUR
	 */
	private Long quantiteMaximaleStockageOr() {

		// Récupération du joueur connecté
		Joueur jou = recuperationJoueur();

		// -- OR --
		Long stockageMaximalOr = 20_000L;

		// -- TOUS LES BATIMENTS QUI AUGMENTENT LA LIMITE DE STOCKAGE DE OR
		for (BatimentJoueur batimentStockageOr : batimentJoueurRepo.findByQuantiteeStockageOreGreaterThanAndJoueurId(1L,
				jou.getId())) {
			long maintenant = new Date().getTime();
			long fin = batimentStockageOr.getDateFinConstruction();
			// Si le batiment est en cours d'amélioration, augmentation pas prise en compte
			if (maintenant > fin) {
				stockageMaximalOr = stockageMaximalOr + batimentStockageOr.getQuantiteeStockageOre();
			} else // Sinon, prise en compte
			{
				// Vérification que la bâtiment est déjà construit
				if (batimentStockageOr.getNiveau() > 1) {
					stockageMaximalOr = (long) (stockageMaximalOr + (batimentStockageOr.getQuantiteeStockageOre() / batimentStockageOr.getBatiment().getMultiplicateurApport()));

				}
			}
		}

		// RETOUR
		return stockageMaximalOr;
	}

	/**
	 * STOCKAGE : QUANTITE MAXIMALE DE STOCKAGE DE NOURRITURE POUR LE JOUEUR
	 */
	private Long quantiteMaximaleStockageNourriture() {

		// Récupération du joueur connecté
		Joueur jou = recuperationJoueur();

		// -- NOURRITURE --
		Long stockageMaximalNourriture = 20_000L;

		// -- TOUS LES BATIMENTS QUI AUGMENTENT LA LIMITE DE STOCKAGE DE NOURRITURE
		for (BatimentJoueur batimentStockageNourriture : batimentJoueurRepo
				.findByQuantiteeStockageNourritureGreaterThanAndJoueurId(1L, jou.getId())) {
			long maintenant = new Date().getTime();
			long fin = batimentStockageNourriture.getDateFinConstruction();
			// Si le batiment est en cours d'amélioration, augmentation pas prise en compte
			if (maintenant > fin) {
				stockageMaximalNourriture = stockageMaximalNourriture
						+ batimentStockageNourriture.getQuantiteeStockageNourriture();
			} else // Bâtiment(s) en cours de construction
			{
				// Vérification que la bâtiment est déjà construit
				if (batimentStockageNourriture.getNiveau() > 1) {
					stockageMaximalNourriture = (long) (stockageMaximalNourriture
							+ (batimentStockageNourriture.getQuantiteeStockageNourriture() / batimentStockageNourriture.getBatiment().getMultiplicateurApport()));

				}
			}
		}

		// RETOUR
		return stockageMaximalNourriture;
	}

	//////////////////
	////// APPORT//////
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
		for (BatimentJoueur batimentPierre : batimentJoueurRepo.findByApportPierreHeureGreaterThanAndJoueurId(1,
				jou.getId())) {
			// Si le batiment est en cours d'amélioration, apport de ressources pas pris en
			// compte
			long maintenant = new Date().getTime();
			long fin = batimentPierre.getDateFinConstruction();
			if (maintenant > fin) {
				apportPierreHeure = apportPierreHeure + batimentPierre.getApportPierreHeure();
			}
		}
		// -- APPORT PIERRE PAR SECONDES

		Integer apportPierreSeconde = Math.round(apportPierreHeure / 3600);

		// RETOUR
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
		for (BatimentJoueur batimentBois : batimentJoueurRepo.findByApportBoisHeureGreaterThanAndJoueurId(1,
				jou.getId())) {
			// Si le batiment est en cours d'amélioration, apport de ressources pas pris en
			// compte
			long maintenant = new Date().getTime();
			long fin = batimentBois.getDateFinConstruction();
			if (maintenant > fin) {
				apportBoisHeure = apportBoisHeure + batimentBois.getApportBoisHeure();
			}
		}
		// -- APPORT BOIS PAR SECONDES
		Integer apportBoisSeconde = Math.round(apportBoisHeure / 3600);

		// RETOUR
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
		for (BatimentJoueur batimentOr : batimentJoueurRepo.findByApportOreHeureGreaterThanAndJoueurId(1,
				jou.getId())) {
			// Si le batiment est en cours d'amélioration, apport de ressources pas pris en
			// compte
			long maintenant = new Date().getTime();
			long fin = batimentOr.getDateFinConstruction();
			if (maintenant > fin) {
				apportOrHeure = apportOrHeure + batimentOr.getApportOreHeure();
			}
		}
		// -- APPORT OR PAR SECONDES
		Integer apportOrSeconde = Math.round(apportOrHeure / 3600);

		// RETOUR
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
		for (BatimentJoueur batimentNourriture : batimentJoueurRepo.findByApportNourritureHeureGreaterThanAndJoueurId(1,
				jou.getId())) {
			// Si le batiment est en cours d'amélioration, apport de ressources pas pris en
			// compte
			long maintenant = new Date().getTime();
			long fin = batimentNourriture.getDateFinConstruction();
			if (maintenant > fin) {
				apportNourritureHeure = apportNourritureHeure + batimentNourriture.getApportNourritureHeure();
			}
		}
		// -- APPORT NOURRITURE PAR SECONDES
		Integer apportNourritureSeconde = Math.round(apportNourritureHeure / 3600);

		// RETOUR
		return apportNourritureSeconde;
	}

	/**
	 * MODIFICATION INFORMATIONS DU JOUEUR
	 */
	public Joueur modifierInformationsJoueur(ModificationJoueurDto modificationJoueurDto) {

		// RECUPERATION DU JOUEUR CONNECTE
		Joueur jou = recuperationJoueur();

		jou.setIcone(modificationJoueurDto.getIcone());
		jou.setDescriptif(modificationJoueurDto.getDescriptif());
		Joueur joueur = new Joueur(jou.getArmee(), jou.getIcone(), jou.getPseudo(), jou.getEmail(), jou.getMotDePasse(),
				jou.getDescriptif(), jou.getNiveau(), jou.getExperience(), jou.getPierrePossession(),
				jou.getBoisPossession(), jou.getOrPossession(), jou.getNourriturePossession(), jou.getGemmePossession(),
				jou.getPierreMaximum(), jou.getBoisMaximum(), jou.getOrMaximum(), jou.getNourritureMaximum(),
				jou.getPierreBoostProduction(), jou.getBoisBoostProduction(), jou.getOrBoostProduction(),
				jou.getNourritureBoostProduction(), jou.getTempsDeJeu(), jou.getRoles(), jou.getDerniereConnexion(),
				jou.getDonateur(), jou.getPositionX(), jou.getPositionY());
		joueur.setId(jou.getId());

		// SAUVEGARDE
		joueurRepo.save(jou);

		// RETOUR
		return jou;
	}

	/**
	 * Attribution de ressources
	 */
	public GainRessourceDto attributionRessources(@Valid GainRessourceDto gainRessourceDto) {
		getInfoJoueur();
		// RECUPERATION DU JOUEUR
		Joueur jou = this.recuperationJoueur();
		jou.getPierrePossession();
		Joueur joueur = new Joueur(jou.getArmee(), jou.getIcone(), jou.getPseudo(), jou.getEmail(), jou.getMotDePasse(),
				jou.getDescriptif(), jou.getNiveau(), jou.getExperience(),
				jou.getPierrePossession() + gainRessourceDto.getGainPierre(),
				jou.getBoisPossession() + gainRessourceDto.getGainBois(),
				jou.getOrPossession() + gainRessourceDto.getGainOr(),
				jou.getNourriturePossession() + gainRessourceDto.getGainNourriture(), jou.getGemmePossession(),
				jou.getPierreMaximum(), jou.getBoisMaximum(), jou.getOrMaximum(), jou.getNourritureMaximum(),
				jou.getPierreBoostProduction(), jou.getBoisBoostProduction(), jou.getOrBoostProduction(),
				jou.getNourritureBoostProduction(), jou.getTempsDeJeu(), jou.getRoles(), jou.getDerniereConnexion(),
				jou.getDonateur(), jou.getPositionX(), jou.getPositionY());
		joueur.setId(jou.getId());
		joueur.getPierrePossession();

		// SAUVEGARDE
		joueurRepo.save(joueur);

		// RETOUR
		return new GainRessourceDto(gainRessourceDto.getGainPierre(), gainRessourceDto.getGainBois(),
				gainRessourceDto.getGainOr(), gainRessourceDto.getGainNourriture());
	}

	/**
	 * MODIFICATION D'UN BÂTIMENT (Menu administrateur, Via ID)
	 */
	public JoueurDto administrationModificationJoueur(@Valid JoueurDto joueurDto, Integer id) {
		Joueur jou = joueurRepo.findById(id).orElseThrow(
				() -> new JoueurAuthentifieNonRecupereException("Le joueur authentifié n'a pas pu être récupéré"));

		Joueur joueur = new Joueur(jou.getArmee(), joueurDto.getIcone(), joueurDto.getPseudo(), joueurDto.getEmail(),
				jou.getMotDePasse(), joueurDto.getDescriptif(), joueurDto.getNiveau(), joueurDto.getExperience(),
				joueurDto.getPierrePossession(), joueurDto.getBoisPossession(), joueurDto.getOrPossession(),
				joueurDto.getNourriturePossession(), joueurDto.getGemmePossession(), jou.getPierreMaximum(),
				jou.getBoisMaximum(), jou.getOrMaximum(), jou.getNourritureMaximum(),
				joueurDto.getPierreBoostProduction(), joueurDto.getBoisBoostProduction(),
				joueurDto.getOrBoostProduction(), joueurDto.getNourritureBoostProduction(), jou.getTempsDeJeu(),
				jou.getRoles(), jou.getDerniereConnexion(), joueurDto.getDonateur(), joueurDto.getPositionX(),
				joueurDto.getPositionY());
		joueur.setId(jou.getId());

		// SAUVEGARDE
		this.joueurRepo.save(joueur);

		// RETOUR
		return joueurDto;
	}

	/**
	 * ECHANGE DE RESSOURCES (Via marché)
	 */
	public EchangeRessourceDto echangeRessource(@Valid EchangeRessourceDto echangeRessourceDto) {

		getInfoJoueur();
		// RECUPERATION DU JOUEUR
		Joueur jou = this.recuperationJoueur();

		Integer pierreJoueurARetirer = echangeRessourceDto.getMontantPierre() == null ? 0
				: echangeRessourceDto.getMontantPierre();
		Integer boisJoueurARetirer = echangeRessourceDto.getMontantBois() == null ? 0
				: echangeRessourceDto.getMontantBois();
		Integer orJoueurARetirer = echangeRessourceDto.getMontantOr() == null ? 0 : echangeRessourceDto.getMontantOr();
		Integer nourritureJoueurARetirer = echangeRessourceDto.getMontantNourriture() == null ? 0
				: echangeRessourceDto.getMontantNourriture();

		Integer pierreJoueurACrediter = 0;
		Integer boisJoueurACrediter = 0;
		Integer orJoueurACrediter = 0;
		Integer nourritureJoueurACrediter = 0;

		if (pierreJoueurARetirer > 0) { // Pierre
			if (pierreJoueurARetirer > jou.getPierrePossession()) {
				throw new MessageResponseException("Vous manquez de pierre");
			}
			// Echange contre pierre
			if (echangeRessourceDto.getEtatPierre() == true) {
				throw new MessageResponseException(
						"Il n'est pas possible d'échanger de la pierre contre de la pierre... pas très utile");
			} else if (echangeRessourceDto.getEtatBois() == true) { // Echange contre Bois
				boisJoueurACrediter = (int) Math.round((double) pierreJoueurARetirer * 1.5);
				if ((jou.getBoisPossession() + boisJoueurACrediter) > jou.getBoisMaximum()) {
					throw new MessageResponseException("Limite de stockage de bois dépassée");
				}
			} else if (echangeRessourceDto.getEtatOr() == true) { // Echange contre Or
				orJoueurACrediter = (int) Math.round((double) pierreJoueurARetirer * 0.66);
				if ((jou.getOrPossession() + orJoueurACrediter) > jou.getOrMaximum()) {
					throw new MessageResponseException("Limite de stockage d'or dépassée");
				}
			} else if (echangeRessourceDto.getEtatNourriture() == true) { // Echange contre Nourriture
				nourritureJoueurACrediter = (int) Math.round((double) pierreJoueurARetirer * 3);
				if ((jou.getNourriturePossession() + nourritureJoueurACrediter) > jou.getNourritureMaximum()) {
					throw new MessageResponseException("Limite de stockage de nourriture dépassée");
				}
			}
		} else if (boisJoueurARetirer > 0) { // Bois
			if (boisJoueurARetirer > jou.getBoisPossession()) {
				throw new MessageResponseException("Vous manquez de bois");
			}
			// Echange contre pierre
			if (echangeRessourceDto.getEtatPierre() == true) {
				pierreJoueurACrediter = (int) Math.round((double) boisJoueurARetirer * 0.66);
				if ((jou.getPierrePossession() + pierreJoueurACrediter) > jou.getPierreMaximum()) {
					throw new MessageResponseException("Limite de stockage de pierre dépassée");
				}
			} else if (echangeRessourceDto.getEtatBois() == true) { // Echange contre Bois
				throw new MessageResponseException(
						"Il n'est pas possible d'échanger du bois contre du bois... pas très utile");
			} else if (echangeRessourceDto.getEtatOr() == true) { // Echange contre Or
				orJoueurACrediter = (int) Math.round((double) boisJoueurARetirer * 0.4);
				if ((jou.getOrPossession() + orJoueurACrediter) > jou.getOrMaximum()) {
					throw new MessageResponseException("Limite de stockage d'or dépassée");
				}
			} else if (echangeRessourceDto.getEtatNourriture() == true) { // Echange contre Nourriture
				nourritureJoueurACrediter = (int) Math.round((double) boisJoueurARetirer * 2);
				if ((jou.getNourriturePossession() + nourritureJoueurACrediter) > jou.getNourritureMaximum()) {
					throw new MessageResponseException("Limite de stockage de nourriture dépassée");
				}
			}
		} else if (orJoueurARetirer > 0) { // Or
			if (orJoueurARetirer > jou.getOrPossession()) {
				throw new MessageResponseException("Vous manquez d'or");
			}
			// Echange contre pierre
			if (echangeRessourceDto.getEtatPierre() == true) {
				pierreJoueurACrediter = (int) Math.round((double) orJoueurARetirer * 1.66);
				if ((jou.getPierrePossession() + pierreJoueurACrediter) > jou.getPierreMaximum()) {
					throw new MessageResponseException("Limite de stockage de pierre dépassée");
				}
			} else if (echangeRessourceDto.getEtatBois() == true) { // Echange contre Bois
				boisJoueurACrediter = (int) Math.round((double) orJoueurARetirer * 2.5);
				if ((jou.getBoisPossession() + boisJoueurACrediter) > jou.getBoisMaximum()) {
					throw new MessageResponseException("Limite de stockage de bois dépassée");
				}
			} else if (echangeRessourceDto.getEtatOr() == true) { // Echange contre Or
				throw new MessageResponseException(
						"Il n'est pas possible d'échanger de l'or contre de l'or... pas très utile");
			} else if (echangeRessourceDto.getEtatNourriture() == true) { // Echange contre Nourriture
				nourritureJoueurACrediter = (int) Math.round((double) orJoueurARetirer * 5);
				if ((jou.getNourriturePossession() + nourritureJoueurACrediter) > jou.getNourritureMaximum()) {
					throw new MessageResponseException("Limite de stockage de nourriture dépassée");
				}
			}
		} else if (nourritureJoueurARetirer > 0) { // Nourriture
			if (nourritureJoueurARetirer > jou.getNourriturePossession()) {
				throw new MessageResponseException("Vous manquez de nourriture");
			}
			// Echange contre pierre
			if (echangeRessourceDto.getEtatPierre() == true) {
				pierreJoueurACrediter = (int) Math.round((double) nourritureJoueurARetirer * 0.33);
				if ((jou.getPierrePossession() + pierreJoueurACrediter) > jou.getPierreMaximum()) {
					throw new MessageResponseException("Limite de stockage de pierre dépassée");
				}
			} else if (echangeRessourceDto.getEtatBois() == true) { // Echange contre Bois
				boisJoueurACrediter = (int) Math.round((double) nourritureJoueurARetirer * 0.5);
				if ((jou.getBoisPossession() + boisJoueurACrediter) > jou.getBoisMaximum()) {
					throw new MessageResponseException("Limite de stockage de bois dépassée");
				}
			} else if (echangeRessourceDto.getEtatOr() == true) { // Echange contre Or
				orJoueurACrediter = (int) Math.round((double) nourritureJoueurARetirer * 0.2);
				if ((jou.getOrPossession() + orJoueurACrediter) > jou.getOrMaximum()) {
					throw new MessageResponseException("Limite de stockage d'or dépassée");
				}
			} else if (echangeRessourceDto.getEtatNourriture() == true) { // Echange contre Nourriture
				throw new MessageResponseException(
						"Il n'est pas possible d'échanger de la nourriture contre de la nourriture... pas très utile");
			}
		} else { // Erreur aucun cas > 0
			throw new MessageResponseException("Erreur dans la saisie.");
		}

		Joueur joueur = new Joueur(jou.getArmee(), jou.getIcone(), jou.getPseudo(), jou.getEmail(), jou.getMotDePasse(),
				jou.getDescriptif(), jou.getNiveau(), jou.getExperience(),
				jou.getPierrePossession() - pierreJoueurARetirer + pierreJoueurACrediter,
				jou.getBoisPossession() - boisJoueurARetirer + boisJoueurACrediter,
				jou.getOrPossession() - orJoueurARetirer + orJoueurACrediter,
				jou.getNourriturePossession() - nourritureJoueurARetirer + nourritureJoueurACrediter,
				jou.getGemmePossession(), jou.getPierreMaximum(), jou.getBoisMaximum(), jou.getOrMaximum(),
				jou.getNourritureMaximum(), jou.getPierreBoostProduction(), jou.getBoisBoostProduction(),
				jou.getOrBoostProduction(), jou.getNourritureBoostProduction(), jou.getTempsDeJeu(), jou.getRoles(),
				jou.getDerniereConnexion(), jou.getDonateur(), jou.getPositionX(), jou.getPositionY());
		joueur.setId(jou.getId());

		// SAUVEGARDE
		joueurRepo.save(joueur);

		// RETOUR
		return echangeRessourceDto;
	}

	/**
	 * DETERMINE LE NIVEAU EN FONCTION DE L'EXPERIENCE
	 */
	public Integer determinerNiveau(Long experience) {
		// PREMIER PALIER A 5000XP (niveau1) puis 10000XP( niveau 2) ... x2 x2 x2
		Integer niveau = 1;
		Long seuil = 5000L;
		while (experience > 0) {
			experience = experience - seuil;
			if (experience >= 0) {
				niveau++;
			}
			seuil = seuil * 2;
		}

		// RETOUR
		return niveau;
	}

}
