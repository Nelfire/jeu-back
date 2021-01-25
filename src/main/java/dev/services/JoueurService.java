package dev.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import dev.controller.dto.JoueurDto;
import dev.controller.dto.JoueurInfoDto;
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
			joueurDto.setIcone(joueur.getIcone());
			joueurDto.setPseudo(joueur.getPseudo());
			joueurDto.setNiveau(joueur.getNiveau());
			joueurDto.setTempsDeJeu(joueur.getTempsDeJeu());
			listeJoueurs.add(joueurDto);

		}
		return listeJoueurs;
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
		Integer millisecondesDifference = (int) (now.getTime()-jou.getDerniereConnexion().getTime());

		// ------------
		// -- PIERRE --
		// ------------
		// CALCUL APPORT PAR HEURE DU JOUEUR
		Integer apportPierreHeure = 1;
		// -- TOUS LES BATIMENTS QUI RAPPORTENT DE LA PIERRE
		for (BatimentJoueur batimentPierre : batimentJoueurRepo.findByApportPierreHeureGreaterThan(1)) {
			// Si le batiment est en cours d'amélioration, apport de ressources pas pris en compte
			long maintenant = new Date().getTime();
			long fin = batimentPierre.getDateFinConstruction();
			if(maintenant>fin) {
				apportPierreHeure = apportPierreHeure + batimentPierre.getApportPierreHeure();
			}
		}
		// -- APPORT PIERRE PAR SECONDES
		Integer apportPierreSeconde = apportPierreHeure / 3600;
		// -- CALCUL APPORT PIERRE REEL (Attribution ressources inactivitée)
		Integer apportPierreFinal = (apportPierreSeconde * millisecondesDifference)/1000;
		
		// ------------
		// -- BOIS --
		// ------------
		// CALCUL APPORT PAR HEURE DU JOUEUR
		Integer apportBoisHeure = 1;
		// -- TOUS LES BATIMENTS QUI RAPPORTENT DU BOIS
		for (BatimentJoueur batimentBois : batimentJoueurRepo.findByApportBoisHeureGreaterThan(1)) {
			// Si le batiment est en cours d'amélioration, apport de ressources pas pris en compte
			long maintenant = new Date().getTime();
			long fin = batimentBois.getDateFinConstruction();
			if(maintenant>fin) {
				apportBoisHeure = apportBoisHeure + batimentBois.getApportBoisHeure();
			}
		}
		// -- APPORT BOIS PAR SECONDES
		Integer apportBoisSeconde = apportBoisHeure / 3600;
		// -- CALCUL APPORT BOIS REEL (Attribution ressources inactivitée)
		Integer apportBoisFinal = (apportBoisSeconde * millisecondesDifference)/1000;
		// ------------
		// -- OR --
		// ------------
		// CALCUL APPORT PAR HEURE DU JOUEUR
		Integer apportOrHeure = 1;
		// -- TOUS LES BATIMENTS QUI RAPPORTENT DE L'OR
		for (BatimentJoueur batimentOr : batimentJoueurRepo.findByApportOreHeureGreaterThan(1)) {
			// Si le batiment est en cours d'amélioration, apport de ressources pas pris en compte
			long maintenant = new Date().getTime();
			long fin = batimentOr.getDateFinConstruction();
			if(maintenant>fin) {
				apportOrHeure = apportOrHeure + batimentOr.getApportOreHeure();
			}
		}
		// -- APPORT OR PAR SECONDES
		Integer apportOrSeconde = apportOrHeure / 3600;
		// -- CALCUL APPORT OR REEL (Attribution ressources inactivitée)
		Integer apportOrFinal = (apportOrSeconde * millisecondesDifference)/1000;
		
		// ------------
		// -- NOURRITURE --
		// ------------
		// CALCUL APPORT PAR HEURE DU JOUEUR
		Integer apportNourritureHeure = 1;
		// -- TOUS LES BATIMENTS QUI RAPPORTENT DE LA NOURRITURE
		for (BatimentJoueur batimentNourriture : batimentJoueurRepo.findByApportNourritureHeureGreaterThan(1)) {
			// Si le batiment est en cours d'amélioration, apport de ressources pas pris en compte
			long maintenant = new Date().getTime();
			long fin = batimentNourriture.getDateFinConstruction();
			if(maintenant>fin) {
				apportNourritureHeure = apportNourritureHeure + batimentNourriture.getApportNourritureHeure();
			}
		}
		// -- APPORT NOURRITURE PAR SECONDES
		Integer apportNourritureSeconde = apportNourritureHeure / 3600;
		// -- CALCUL APPORT NOURRITURE REEL (Attribution ressources inactivitée)
		Integer apportNourritureFinal = (apportNourritureSeconde * millisecondesDifference)/1000;

		// ACTUALISATION DES RESSOURCES DU JOUEUR (Appelé chaques secondes)
		jou.setPierrePossession((jou.getPierrePossession() + apportPierreFinal)>jou.getPierreMaximum() ? jou.getPierreMaximum() : jou.getPierrePossession() + apportPierreFinal);
		jou.setBoisPossession((jou.getBoisPossession() + apportBoisFinal)>jou.getBoisMaximum() ? jou.getBoisMaximum() : jou.getBoisPossession() + apportBoisFinal);
		jou.setOrPossession((jou.getOrPossession() + apportOrFinal)>jou.getOrMaximum() ? jou.getOrMaximum() : jou.getOrPossession() + apportOrFinal);
		jou.setNourriturePossession((jou.getNourriturePossession() + apportNourritureFinal)>jou.getNourritureMaximum() ? jou.getNourritureMaximum() : jou.getNourriturePossession() + apportNourritureFinal);
		jou.setTempsDeJeu(jou.getTempsDeJeu() + 1);
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
}
