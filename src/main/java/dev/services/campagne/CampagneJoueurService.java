package dev.services.campagne;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import org.springframework.stereotype.Service;
import dev.controller.dto.campagne.CompositionArmeeCampagneDto;
import dev.entites.campagne.Campagne;
import dev.entites.campagne.CampagneJoueur;
import dev.entites.campagne.CampagneUnitee;
import dev.entites.joueur.Armee;
import dev.entites.joueur.Joueur;
import dev.entites.unitee.Unitee;
import dev.exceptions.MessageResponseException;
import dev.exceptions.RecompenseDejaPercuException;
import dev.exceptions.UniteeManquanteException;
import dev.repository.JoueurRepo;
import dev.repository.campagne.CampagneJoueurRepo;
import dev.repository.campagne.CampagneRepo;
import dev.repository.campagne.CampagneUniteeRepo;
import dev.repository.joueur.ArmeeRepo;
import dev.repository.unitee.UniteeRepo;
import dev.services.joueur.JoueurService;

@Service
public class CampagneJoueurService {

	private CampagneJoueurRepo campagneJoueurRepo;
	private ArmeeRepo armeeRepo;
	private JoueurService joueurService;
	private JoueurRepo joueurRepo;
	private CampagneRepo campagneRepo;
	private CampagneUniteeRepo campagneUniteeRepo;
	private UniteeRepo uniteeRepo;

	/**
	 * @param campagneJoueurRepo
	 * @param armeeRepo
	 * @param joueurService
	 * @param joueurRepo
	 * @param campagneRepo
	 * @param campagneUniteeRepo
	 * @param uniteeRepo
	 */
	public CampagneJoueurService(CampagneJoueurRepo campagneJoueurRepo, ArmeeRepo armeeRepo,
			JoueurService joueurService, JoueurRepo joueurRepo, CampagneRepo campagneRepo,
			CampagneUniteeRepo campagneUniteeRepo, UniteeRepo uniteeRepo) {
		super();
		this.campagneJoueurRepo = campagneJoueurRepo;
		this.armeeRepo = armeeRepo;
		this.joueurService = joueurService;
		this.joueurRepo = joueurRepo;
		this.campagneRepo = campagneRepo;
		this.campagneUniteeRepo = campagneUniteeRepo;
		this.uniteeRepo = uniteeRepo;
	}

	/**
	 * LISTER TOUTES LES CAMPAGNES DU JOUEUR, TOUT CONFONDU
	 */
	public List<CampagneJoueur> listerCampagneJoueur() {
		
		// INITIALISATIONS
		List<CampagneJoueur> listeCampagneJoueur = new ArrayList<>();
		
		// Récupération du joueur
		Joueur jou = joueurService.recuperationJoueur();

		// Récupération de la liste des campagne du joueur.
		for (CampagneJoueur campagne : campagneJoueurRepo.findByJoueur(jou)) {
			// ACTUALISATION ETAT CAMPAGNE
			long maintenant = new Date().getTime();
			// SI L'CAMPAGNE EST TERMINEE
			if (campagne.getDateFinCampagne() < maintenant && campagne.getEtatCampagne() == 0) {
				// DÉFINIR L'ÉTAT DE RÉUSSITE OU DE DÉFAITE DE LA CAMPAGNE EN FONCTION DU
				// POURCENTAGE DE RÉUSSITE
				Random rand = new Random();
				int nombreRandom = rand.nextInt(100);
				if (nombreRandom <= campagne.getPourcentageReussite()) {
					// - Défini l'état de l'campagne comme "Victoire"
					campagne.setEtatCampagne(1);
				} else {
					// - Défini l'état de l'campagne comme "Echec"
					campagne.setEtatCampagne(3);
				}
				// SAUVEGARDE
				this.campagneJoueurRepo.save(campagne);
			}
			
			// AJOUT A LA LISTE
			listeCampagneJoueur.add(campagne);
		}

		// RETOUR
		return listeCampagneJoueur;
	}

	/**
	 * RECHERCHE CAMPAGNE JOUEUR PAR ID
	 */
	public CampagneJoueur rechercherCampagneJoueurById(Integer id) {
		
		// RECHERCHE INFORMATIONS CAMPAGNE PAR ID
		Optional<CampagneJoueur> campJoueur = campagneJoueurRepo.findById(id);
		
		// Création d'une instance depuis l'campagne trouvée
		CampagneJoueur campagneJoueur = new CampagneJoueur();
		campagneJoueur.setId(campJoueur.get().getId());
		campagneJoueur.setJoueur(campJoueur.get().getJoueur());
		campagneJoueur.setCampagne(campJoueur.get().getCampagne());
		campagneJoueur.setDateDebutCampagne(campJoueur.get().getDateDebutCampagne());
		campagneJoueur.setDateFinCampagne(campJoueur.get().getDateFinCampagne());
		campagneJoueur.setArmeeEnvoiJoueur(campJoueur.get().getArmeeEnvoiJoueur());
		campagneJoueur.setRecompenseRecuperee(campJoueur.get().getRecompenseRecuperee());
		campagneJoueur.setPourcentageReussite(campJoueur.get().getPourcentageReussite());
		campagneJoueur.setEtatCampagne(campJoueur.get().getEtatCampagne());
		
		// RETOUR
		return campagneJoueur;
	}

	/**
	 * ENVOI D'UNITES EN CAMPAGNE (Création)
	 */
	public CompositionArmeeCampagneDto envoiUniteeEnCampagne(CompositionArmeeCampagneDto compositionArmeeCampagne) {

		// INITIALISATION
		Integer plusHautNiveauAtteint = 0;
		
		// RÉCUPÉRATION DU JOUEUR
		Joueur jou = joueurService.recuperationJoueur();
		
		// RECHERCHE CAMPAGNE PAR ID
		Optional<Campagne> camp = campagneRepo.findById(compositionArmeeCampagne.getIdCampagne());
		
		// CREATION D'UNE CAMPAGNE TYPE, À PARTIR DE CETTE RECHERCHE
		Campagne campagne = new Campagne();
		campagne.setId(camp.get().getId());
		campagne.setIcone(camp.get().getIcone());
		campagne.setLibelle(camp.get().getLibelle());
		campagne.setDuree(camp.get().getDuree());
		campagne.setNiveau(camp.get().getNiveau());
		campagne.setUnitee(camp.get().getUnitee());
		campagne.setQuantitee(camp.get().getQuantitee());
		campagne.setIsBoss(camp.get().getIsBoss());
		campagne.setRecompensePierre(camp.get().getRecompensePierre());
		campagne.setRecompenseBois(camp.get().getRecompenseBois());
		campagne.setRecompenseOr(camp.get().getRecompenseOr());
		campagne.setRecompenseNourriture(camp.get().getRecompenseNourriture());
		campagne.setRecompenseGemme(camp.get().getRecompenseGemme());
		campagne.setRecompenseExperience(camp.get().getRecompenseExperience());

		// Vérification niveau campagne lancée pas supérieure au niveau maximum de
		// campagne débloqué par le joueur

		List<CampagneJoueur> listeCampagnesJoueurDejaRealisees = this.campagneJoueurRepo.findByJoueur(jou);
		for (CampagneJoueur campagneJoueur : listeCampagnesJoueurDejaRealisees) {
			// Si campagne succes, continue la vérification
			if (campagneJoueur.getEtatCampagne() == 2) {
				// Récupération plus haut niveau atteint
				if (campagneJoueur.getCampagne().getNiveau() > plusHautNiveauAtteint) {
					plusHautNiveauAtteint = campagneJoueur.getCampagne().getNiveau();
				}
			}
		}

		// SI ACCES CAMPAGNE NON AUTORISE : EXCEPTION
		if (campagne.getNiveau() > plusHautNiveauAtteint + 1) {
			throw new MessageResponseException("Veuillez compléter les campagnes de niveau inférieur avant.");
		}

		// INITIALISATION
		// - Dégats que le jouer va emettre lors de l'attaque, pour calculer le %
		// réussite
		Integer degatsEmis = 0;

		Armee armee = new Armee();
		// - Temps campagne
		long debut = new Date().getTime();
		long fin = new Date().getTime() + (campagne.getDuree() * 1000);

		// - Liste des armées que le joueur va envoyer
		List<Armee> listeArmees = new ArrayList<>();

		// RETRAIT UNITEES
		// - Parcourir les armées que possède déjà le joueur, pour y soustraire les
		// unitées qu'il envoi en campagne
		for (Armee arme : armeeRepo.findByJoueur(jou)) {
			if (arme.getUnitee().getId() == 1) // Villageois
			{
				if (arme.getQuantitee() - compositionArmeeCampagne.getNombreVillageois() < 0) {
					throw new UniteeManquanteException("Vous manquez de villageois.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis
							+ (arme.getUnitee().getAttaque() * compositionArmeeCampagne.getNombreVillageois());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee() - compositionArmeeCampagne.getNombreVillageois());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);

					CampagneUnitee campagneUnitee = new CampagneUnitee(campagne.getId(), arme.getUnitee().getId(),
							compositionArmeeCampagne.getNombreVillageois());
					campagneUniteeRepo.save(campagneUnitee);
				}
			} else if (arme.getUnitee().getId() == 2) // Archer
			{
				if (arme.getQuantitee() - compositionArmeeCampagne.getNombreArcher() < 0) {
					throw new UniteeManquanteException("Vous manquez d'archers.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis
							+ (arme.getUnitee().getAttaque() * compositionArmeeCampagne.getNombreArcher());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee() - compositionArmeeCampagne.getNombreArcher());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);

					CampagneUnitee campagneUnitee = new CampagneUnitee(campagne.getId(), arme.getUnitee().getId(),
							compositionArmeeCampagne.getNombreArcher());
					campagneUniteeRepo.save(campagneUnitee);
				}
			} else if (arme.getUnitee().getId() == 3) // ArcherComposite
			{
				if (arme.getQuantitee() - compositionArmeeCampagne.getNombreArcherComposite() < 0) {
					throw new UniteeManquanteException("Vous manquez d'archers composite.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis
							+ (arme.getUnitee().getAttaque() * compositionArmeeCampagne.getNombreArcherComposite());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee() - compositionArmeeCampagne.getNombreArcherComposite());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);

					CampagneUnitee campagneUnitee = new CampagneUnitee(campagne.getId(), arme.getUnitee().getId(),
							compositionArmeeCampagne.getNombreArcherComposite());
					campagneUniteeRepo.save(campagneUnitee);
				}
			} else if (arme.getUnitee().getId() == 4) // FantassinEpee
			{
				if (arme.getQuantitee() - compositionArmeeCampagne.getNombreFantassinEpee() < 0) {
					throw new UniteeManquanteException("Vous manquez de fantassins épée.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis
							+ (arme.getUnitee().getAttaque() * compositionArmeeCampagne.getNombreFantassinEpee());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee() - compositionArmeeCampagne.getNombreFantassinEpee());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);

					CampagneUnitee campagneUnitee = new CampagneUnitee(campagne.getId(), arme.getUnitee().getId(),
							compositionArmeeCampagne.getNombreFantassinEpee());
					campagneUniteeRepo.save(campagneUnitee);
				}
			} else if (arme.getUnitee().getId() == 5) // nombrePiquier
			{
				if (arme.getQuantitee() - compositionArmeeCampagne.getNombrePiquier() < 0) {
					throw new UniteeManquanteException("Vous manquez de piquiers.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis
							+ (arme.getUnitee().getAttaque() * compositionArmeeCampagne.getNombrePiquier());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee() - compositionArmeeCampagne.getNombrePiquier());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);

					CampagneUnitee campagneUnitee = new CampagneUnitee(campagne.getId(), arme.getUnitee().getId(),
							compositionArmeeCampagne.getNombrePiquier());
					campagneUniteeRepo.save(campagneUnitee);
				}
			} else if (arme.getUnitee().getId() == 6) // nombreLanceurDeHache
			{
				if (arme.getQuantitee() - compositionArmeeCampagne.getNombreLanceurDeHache() < 0) {
					throw new UniteeManquanteException("Vous manquez de lanceurs de hache.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis
							+ (arme.getUnitee().getAttaque() * compositionArmeeCampagne.getNombreLanceurDeHache());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee() - compositionArmeeCampagne.getNombreLanceurDeHache());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);

					CampagneUnitee campagneUnitee = new CampagneUnitee(campagne.getId(), arme.getUnitee().getId(),
							compositionArmeeCampagne.getNombreLanceurDeHache());
					campagneUniteeRepo.save(campagneUnitee);
				}
			} else if (arme.getUnitee().getId() == 7) // nombreMilicien
			{
				if (arme.getQuantitee() - compositionArmeeCampagne.getNombreMilicien() < 0) {
					throw new UniteeManquanteException("Vous manquez de miliciens.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis
							+ (arme.getUnitee().getAttaque() * compositionArmeeCampagne.getNombreMilicien());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee() - compositionArmeeCampagne.getNombreMilicien());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);

					CampagneUnitee campagneUnitee = new CampagneUnitee(campagne.getId(), arme.getUnitee().getId(),
							compositionArmeeCampagne.getNombreMilicien());
					campagneUniteeRepo.save(campagneUnitee);
				}
			} else if (arme.getUnitee().getId() == 8) // nombreHommeDArme
			{
				if (arme.getQuantitee() - compositionArmeeCampagne.getNombreHommeDArme() < 0) {
					throw new UniteeManquanteException("Vous manquez d'hommes d'arme.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis
							+ (arme.getUnitee().getAttaque() * compositionArmeeCampagne.getNombreHommeDArme());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee() - compositionArmeeCampagne.getNombreHommeDArme());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);

					CampagneUnitee campagneUnitee = new CampagneUnitee(campagne.getId(), arme.getUnitee().getId(),
							compositionArmeeCampagne.getNombreHommeDArme());
					campagneUniteeRepo.save(campagneUnitee);
				}
			} else if (arme.getUnitee().getId() == 9) // nombreCavalierArcher
			{
				if (arme.getQuantitee() - compositionArmeeCampagne.getNombreCavalierArcher() < 0) {
					throw new UniteeManquanteException("Vous manquez de cavaliers archer.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis
							+ (arme.getUnitee().getAttaque() * compositionArmeeCampagne.getNombreCavalierArcher());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee() - compositionArmeeCampagne.getNombreCavalierArcher());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);

					CampagneUnitee campagneUnitee = new CampagneUnitee(campagne.getId(), arme.getUnitee().getId(),
							compositionArmeeCampagne.getNombreCavalierArcher());
					campagneUniteeRepo.save(campagneUnitee);
				}
			} else if (arme.getUnitee().getId() == 10) // nombreCavalier
			{
				if (arme.getQuantitee() - compositionArmeeCampagne.getNombreCavalier() < 0) {
					throw new UniteeManquanteException("Vous manquez de cavaliers.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis
							+ (arme.getUnitee().getAttaque() * compositionArmeeCampagne.getNombreCavalier());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee() - compositionArmeeCampagne.getNombreCavalier());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);

					CampagneUnitee campagneUnitee = new CampagneUnitee(campagne.getId(), arme.getUnitee().getId(),
							compositionArmeeCampagne.getNombreCavalier());
					campagneUniteeRepo.save(campagneUnitee);
				}
			} else if (arme.getUnitee().getId() == 11) // nombreChampion
			{
				if (arme.getQuantitee() - compositionArmeeCampagne.getNombreChampion() < 0) {
					throw new UniteeManquanteException("Vous manquez de champions.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis
							+ (arme.getUnitee().getAttaque() * compositionArmeeCampagne.getNombreChampion());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee() - compositionArmeeCampagne.getNombreChampion());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);

					CampagneUnitee campagneUnitee = new CampagneUnitee(campagne.getId(), arme.getUnitee().getId(),
							compositionArmeeCampagne.getNombreChampion());
					campagneUniteeRepo.save(campagneUnitee);
				}
			} else if (arme.getUnitee().getId() == 12) // nombreBateauDePeche
			{
				if (arme.getQuantitee() - compositionArmeeCampagne.getNombreBateauDePeche() < 0) {
					throw new UniteeManquanteException("Vous manquez de bâteaux de pêche.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis
							+ (arme.getUnitee().getAttaque() * compositionArmeeCampagne.getNombreBateauDePeche());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee() - compositionArmeeCampagne.getNombreBateauDePeche());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);

					CampagneUnitee campagneUnitee = new CampagneUnitee(campagne.getId(), arme.getUnitee().getId(),
							compositionArmeeCampagne.getNombreBateauDePeche());
					campagneUniteeRepo.save(campagneUnitee);
				}
			} else if (arme.getUnitee().getId() == 13) // nombreBateauIncendiaire
			{
				if (arme.getQuantitee() - compositionArmeeCampagne.getNombreBateauIncendiaire() < 0) {
					throw new UniteeManquanteException("Vous manquez de bâteaux incendiaire.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis
							+ (arme.getUnitee().getAttaque() * compositionArmeeCampagne.getNombreBateauIncendiaire());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee() - compositionArmeeCampagne.getNombreBateauIncendiaire());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);

					CampagneUnitee campagneUnitee = new CampagneUnitee(campagne.getId(), arme.getUnitee().getId(),
							compositionArmeeCampagne.getNombreBateauIncendiaire());
					campagneUniteeRepo.save(campagneUnitee);
				}
			} else if (arme.getUnitee().getId() == 14) // nombreBateauDeDestruction
			{
				if (arme.getQuantitee() - compositionArmeeCampagne.getNombreBateauDeDestruction() < 0) {
					throw new UniteeManquanteException("Vous manquez de bâteaux de destruction.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis
							+ (arme.getUnitee().getAttaque() * compositionArmeeCampagne.getNombreBateauDeDestruction());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee() - compositionArmeeCampagne.getNombreBateauDeDestruction());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);

					CampagneUnitee campagneUnitee = new CampagneUnitee(campagne.getId(), arme.getUnitee().getId(),
							compositionArmeeCampagne.getNombreBateauDeDestruction());
					campagneUniteeRepo.save(campagneUnitee);
				}
			} else if (arme.getUnitee().getId() == 15) // nombreGalionACanon
			{
				if (arme.getQuantitee() - compositionArmeeCampagne.getNombreGalionACanon() < 0) {
					throw new UniteeManquanteException("Vous manquez de galions à canon.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis
							+ (arme.getUnitee().getAttaque() * compositionArmeeCampagne.getNombreGalionACanon());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee() - compositionArmeeCampagne.getNombreGalionACanon());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);

					CampagneUnitee campagneUnitee = new CampagneUnitee(campagne.getId(), arme.getUnitee().getId(),
							compositionArmeeCampagne.getNombreGalionACanon());
					campagneUniteeRepo.save(campagneUnitee);
				}
			} else if (arme.getUnitee().getId() == 16) // nombreGalion
			{
				if (arme.getQuantitee() - compositionArmeeCampagne.getNombreGalion() < 0) {
					throw new UniteeManquanteException("Vous manquez de galions.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis
							+ (arme.getUnitee().getAttaque() * compositionArmeeCampagne.getNombreGalion());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee() - compositionArmeeCampagne.getNombreGalion());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);

					CampagneUnitee campagneUnitee = new CampagneUnitee(campagne.getId(), arme.getUnitee().getId(),
							compositionArmeeCampagne.getNombreGalion());
					campagneUniteeRepo.save(campagneUnitee);
				}
			} else if (arme.getUnitee().getId() == 17) // nombreGuerrierElite
			{
				if (arme.getQuantitee() - compositionArmeeCampagne.getNombreGuerrierElite() < 0) {
					throw new UniteeManquanteException("Vous manquez de guerriers élite.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis
							+ (arme.getUnitee().getAttaque() * compositionArmeeCampagne.getNombreGuerrierElite());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee() - compositionArmeeCampagne.getNombreGuerrierElite());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);

					CampagneUnitee campagneUnitee = new CampagneUnitee(campagne.getId(), arme.getUnitee().getId(),
							compositionArmeeCampagne.getNombreGuerrierElite());
					campagneUniteeRepo.save(campagneUnitee);
				}
			} else if (arme.getUnitee().getId() == 18) // nombrePhalange
			{
				if (arme.getQuantitee() - compositionArmeeCampagne.getNombrePhalange() < 0) {
					throw new UniteeManquanteException("Vous manquez de phalanges.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis
							+ (arme.getUnitee().getAttaque() * compositionArmeeCampagne.getNombrePhalange());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee() - compositionArmeeCampagne.getNombrePhalange());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);

					CampagneUnitee campagneUnitee = new CampagneUnitee(campagne.getId(), arme.getUnitee().getId(),
							compositionArmeeCampagne.getNombrePhalange());
					campagneUniteeRepo.save(campagneUnitee);
				}
			} else if (arme.getUnitee().getId() == 19) // nombreSamourail
			{
				if (arme.getQuantitee() - compositionArmeeCampagne.getNombreSamourail() < 0) {
					throw new UniteeManquanteException("Vous manquez de samourails.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis
							+ (arme.getUnitee().getAttaque() * compositionArmeeCampagne.getNombreSamourail());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee() - compositionArmeeCampagne.getNombreSamourail());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);

					CampagneUnitee campagneUnitee = new CampagneUnitee(campagne.getId(), arme.getUnitee().getId(),
							compositionArmeeCampagne.getNombreSamourail());
					campagneUniteeRepo.save(campagneUnitee);
				}
			} else if (arme.getUnitee().getId() == 20) // nombreTemplier
			{
				if (arme.getQuantitee() - compositionArmeeCampagne.getNombreTemplier() < 0) {
					throw new UniteeManquanteException("Vous manquez de templiers.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis
							+ (arme.getUnitee().getAttaque() * compositionArmeeCampagne.getNombreTemplier());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee() - compositionArmeeCampagne.getNombreTemplier());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);

					CampagneUnitee campagneUnitee = new CampagneUnitee(campagne.getId(), arme.getUnitee().getId(),
							compositionArmeeCampagne.getNombreTemplier());
					campagneUniteeRepo.save(campagneUnitee);
				}
			} else if (arme.getUnitee().getId() == 21) // nombreCatapulte
			{
				if (arme.getQuantitee() - compositionArmeeCampagne.getNombreCatapulte() < 0) {
					throw new UniteeManquanteException("Vous manquez de catapultes.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis
							+ (arme.getUnitee().getAttaque() * compositionArmeeCampagne.getNombreCatapulte());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee() - compositionArmeeCampagne.getNombreCatapulte());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);

					CampagneUnitee campagneUnitee = new CampagneUnitee(campagne.getId(), arme.getUnitee().getId(),
							compositionArmeeCampagne.getNombreCatapulte());
					campagneUniteeRepo.save(campagneUnitee);
				}
			} else if (arme.getUnitee().getId() == 22) // nombreElephantDeCombat
			{
				if (arme.getQuantitee() - compositionArmeeCampagne.getNombreElephantDeCombat() < 0) {
					throw new UniteeManquanteException("Vous manquez d'éléphants de combat.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis
							+ (arme.getUnitee().getAttaque() * compositionArmeeCampagne.getNombreElephantDeCombat());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee() - compositionArmeeCampagne.getNombreElephantDeCombat());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);

					CampagneUnitee campagneUnitee = new CampagneUnitee(campagne.getId(), arme.getUnitee().getId(),
							compositionArmeeCampagne.getNombreElephantDeCombat());
					campagneUniteeRepo.save(campagneUnitee);
				}
			} else if (arme.getUnitee().getId() == 23) // nombrePretre
			{
				if (arme.getQuantitee() - compositionArmeeCampagne.getNombrePretre() < 0) {
					throw new UniteeManquanteException("Vous manquez de prêtres.");

				} else {
					// - Calcul des dégats émis
					degatsEmis = degatsEmis
							+ (arme.getUnitee().getAttaque() * compositionArmeeCampagne.getNombrePretre());
					armee.setId(arme.getId());
					armee.setJoueur(jou);
					armee.setUnitee(arme.getUnitee());
					armee.setQuantitee(arme.getQuantitee() - compositionArmeeCampagne.getNombrePretre());
					armee.setDateDebutProduction(arme.getDateDebutProduction());
					armee.setDateFinProduction(arme.getDateFinProduction());
					armeeRepo.save(armee);
					listeArmees.add(armee);

					CampagneUnitee campagneUnitee = new CampagneUnitee(campagne.getId(), arme.getUnitee().getId(),
							compositionArmeeCampagne.getNombrePretre());
					campagneUniteeRepo.save(campagneUnitee);
				}
			}

		}

		// SI AUCUN DÉGATS N'EST ÉMIS, C'EST QU'AUCUNE UNITÉE N'A ÉTÉ SÉLECTIONNÉE :
		// EXCEPTION
		if (degatsEmis == 0) {
			throw new UniteeManquanteException("Vous n'avez sélectionné aucune unité");
		}

		/*
		 * 0 = EN ATTENTE + VICTORIEUSE 1 = EN ATTENTE + DEFAITE 2 = RECOMPENSE EN
		 * ATTENTE 3 = DEFAITE
		 */
		// CALCUL DU POURCENTAGE DE RÉUSSITE DE LA CAMPAGNE
		int vieRestanteCampagne = campagne.getUnitee().getVie() * campagne.getQuantitee() - degatsEmis;
		int pourcentageReussite = 100
				- (((vieRestanteCampagne * 100) / (campagne.getUnitee().getVie() * campagne.getQuantitee())));
		if (vieRestanteCampagne < 0) {
			pourcentageReussite = 100;
		}

		// CRÉATION DE LA CAMPAGNE JOUEUR
		CampagneJoueur campagneJoueur = new CampagneJoueur();
		campagneJoueur.setJoueur(jou);
		campagneJoueur.setCampagne(campagne);
		campagneJoueur.setDateDebutCampagne(debut);
		campagneJoueur.setDateFinCampagne(fin);
		campagneJoueur.setArmeeEnvoiJoueur(listeArmees);
		campagneJoueur.setRecompenseRecuperee(false);
		campagneJoueur.setPourcentageReussite(pourcentageReussite);
		campagneJoueur.setEtatCampagne(0);
		campagneJoueur.setNombreTentatives(1);

		// Le joueur à t'il déjà tenté cette campagne??
		List<CampagneJoueur> listeCampagneDejaRealiseesParLeJoueur = this.listerCampagneJoueur();
		for (CampagneJoueur campagneJoueurDejaRealisees : listeCampagneDejaRealiseesParLeJoueur) {
			// Oui, déjà réalisée
			if (campagneJoueurDejaRealisees.getCampagne().getId() == camp.get().getId()) {
				campagneJoueur.setId(campagneJoueurDejaRealisees.getId());
				campagneJoueur.setNombreTentatives(campagneJoueurDejaRealisees.getNombreTentatives() + 1);
			}
		}

		// SAUVEGARDE FINALE DE LA CAMPAGNE JOUEUR
		campagneJoueurRepo.save(campagneJoueur);
		return null;
	}

	/**
	 * RECUPERATION DE LA RECOMPENSE
	 */
	public CampagneJoueur recupererRecompense(Integer idCampagne) {

		// RÉCUPÉRATION INFORMATIONS CAMPAGNEJOUER
		CampagneJoueur campJoueur = this.rechercherCampagneJoueurById(idCampagne);

		// VÉRIFICATION RÉCOMPENSE DISPONNIBLE (SI ELLE À PAS DÉJÀ ÉTÉ PERÇU)
		if (campJoueur.getRecompenseRecuperee() == true) {
			throw new RecompenseDejaPercuException("Vous avez déjà perçu cette récompense.");
		}

		// CRÉATION D'UNE CAMPAGNEJOUEUR À PARTIR DE NOTRE RECHERCHE
		CampagneJoueur campagneJoueur = new CampagneJoueur();
		campagneJoueur.setId(campJoueur.getId());
		campagneJoueur.setJoueur(campJoueur.getJoueur());
		campagneJoueur.setCampagne(campJoueur.getCampagne());
		campagneJoueur.setDateDebutCampagne(campJoueur.getDateDebutCampagne());
		campagneJoueur.setDateFinCampagne(campJoueur.getDateFinCampagne());
		campagneJoueur.setArmeeEnvoiJoueur(campJoueur.getArmeeEnvoiJoueur());
		// ON CHANGE L'ÉTAT DE LA RÉCOMPENSE
		campagneJoueur.setRecompenseRecuperee(true);
		campagneJoueur.setPourcentageReussite(campJoueur.getPourcentageReussite());
		campagneJoueur.setEtatCampagne(campJoueur.getEtatCampagne());
		campagneJoueur.setNombreTentatives(campJoueur.getNombreTentatives());

		// DANS LE CAS OU LA CAMPAGNE EST UN SUCCES, ATTIBUTION DES RESSOURCES AU JOUEUR
		// (PIERRE, BOIS, OR, NOURRITURE, GEMME)
		if (campJoueur.getEtatCampagne() == 1) {
			Joueur jou = joueurService.recuperationJoueur();
			jou.setPierrePossession(jou.getPierrePossession() + campJoueur.getCampagne().getRecompensePierre());
			jou.setBoisPossession(jou.getBoisPossession() + campJoueur.getCampagne().getRecompenseBois());
			jou.setOrPossession(jou.getOrPossession() + campJoueur.getCampagne().getRecompenseOr());
			jou.setNourriturePossession(
					jou.getNourriturePossession() + campJoueur.getCampagne().getRecompenseNourriture());
			jou.setGemmePossession(jou.getGemmePossession() + campJoueur.getCampagne().getRecompenseGemme());
			jou.setExperience(jou.getExperience() + campJoueur.getCampagne().getRecompenseExperience());

			Integer niveau = this.joueurService.determinerNiveau(jou.getExperience());
			jou.setNiveau(niveau);

			// - Changement de l'état, pour définir l'campagne comme "réussite"
			campagneJoueur.setEtatCampagne(2);

			// Détection des unités envoyées en campagne.
			for (CampagneUnitee campagneUnitee : campagneUniteeRepo.findAll()) {
				// SI CAMPAGNE UNITEE
				if (campagneUnitee.getIdCampagne() == campagneJoueur.getCampagne().getId()) {
					// RECHERCHE UNITEE CORRESPONDANTE
					for (Unitee unitee : uniteeRepo.findAll()) {
						if (unitee.getId() == campagneUnitee.getIdUnitee()) {
							// RECHERCHE ARMEE DU JOUEUR CORRESPONDANTE
							for (Armee arme : armeeRepo.findByJoueur(jou)) {
								if (arme.getUnitee().getId() == campagneUnitee.getIdUnitee()) {
									// RE-ATTRIBUTION DES QUANTITES

									Armee armee = new Armee();
									// - Calcul des dégats émis
									armee.setId(arme.getId());
									armee.setJoueur(jou);
									armee.setUnitee(arme.getUnitee());
									armee.setQuantitee(arme.getQuantitee() + campagneUnitee.getQuantite());
									armee.setDateDebutProduction(arme.getDateDebutProduction());
									armee.setDateFinProduction(arme.getDateFinProduction());
									armeeRepo.save(armee);
								}
							}
						}
					}
				}
			}

			// - Sauvegardes des informations joueur
			joueurRepo.save(jou);
		}

		// SAUVEGARDE DE LA CAMPAGNE JOUEUR
		campagneJoueurRepo.save(campagneJoueur);

		return campagneJoueur;
	}

}
