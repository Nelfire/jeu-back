package dev.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import dev.controller.dto.BatimentJoueurDto;
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

	// Récupération du joueur connecté.
	public Joueur recuperationJoueur() {
		// --- RECUPERATION JOUEUR CONNECTE ---
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		Joueur jou = joueurRepo.findByEmail(email).orElseThrow(
				() -> new JoueurAuthentifieNonRecupereException("Le joueur authentifié n'a pas pu être récupéré"));
		// ------------------------------------
		return jou;
	}

	/**
	 * Lister tous les joueurs
	 * 
	 * @return
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

//	public List<JoueurInfoDto> getAllInfoJoueurs() {
//		List<JoueurInfoDto> listeJoueurs = new ArrayList<>();
//
//		for (Joueur joueur : joueurRepo.findAll()) {
//
//			JoueurInfoDto joueurDto = new JoueurInfoDto();
//			joueurDto.setEmail(joueur.getEmail());
//			joueurDto.setNom(joueur.getNom());
//			joueurDto.setPrenom(joueur.getPrenom());
//			listeJoueurs.add(joueurDto);
//
//		}
//		return listeJoueurs;
//	}

	/*
	 * public JoueurInfoDto getInfoJoueurEmail(String email) { Joueur col =
	 * joueurRepo.findByEmail(email).orElseThrow(() -> new
	 * JoueurAuthentifieNonRecupereException("Erreur.")); // Aller récupérer tous
	 * les batiments du joueurs qui donnent du bois.
	 * 
	 * List<BatimentJoueur> batimentsPierre = new ArrayList<>();
	 * 
	 * Integer apportPierre = 0; for (BatimentJoueur batimentPierre :
	 * batimentJoueurRepo.findByApportPierreHeureGreaterThan(1)) { apportPierre =
	 * apportPierre+batimentPierre.getApportPierreHeure(); } JoueurInfoDto co = new
	 * JoueurInfoDto(col.getId(),col.getIcone(),col.getPseudo(),email,col.
	 * getDescriptif(),col.getNiveau(),col.getExperience(),col.getPierrePossession()
	 * ,col.getBoisPossession(),col.getOrPossession(),col.getNourriturePossession(),
	 * col.getGemmePossession(),col.getPierreMaximum(),col.getBoisMaximum(),col.
	 * getOrMaximum(),col.getNourritureMaximum(),col.getPierreBoostProduction(),col.
	 * getBoisBoostProduction(),col.getOrBoostProduction(),col.
	 * getNourritureBoostProduction(),col.getTempsDeJeu()); return co; }
	 */

	public JoueurInfoDto getInfoJoueur() {
		// Récupération du joueur connecté.
		Joueur jou = recuperationJoueur();
		// Aller récupérer tous les batiments du joueurs qui donnent du bois.

		// Liste tous les batiments qui rapportent de la pierre
		List<BatimentJoueur> batimentsPierre = new ArrayList<>();

		// ------------
		// -- PIERRE --
		// ------------
		// CALCUL APPORT PAR HEURE DU JOUEUR
		Integer apportPierreHeure = 0;
		// -- TOUS LES BATIMENTS QUI RAPPORTENT DE LA PIERRE
		for (BatimentJoueur batimentPierre : batimentJoueurRepo.findByApportPierreHeureGreaterThan(1)) {
			apportPierreHeure = apportPierreHeure + batimentPierre.getApportPierreHeure();
		}
		// -- APPORT PIERRE PAR SECONDES
		Integer apportPierreSeconde = apportPierreHeure / 3600;

		// ------------
		// -- BOIS --
		// ------------
		// CALCUL APPORT PAR HEURE DU JOUEUR
		Integer apportBoisHeure = 0;
		// -- TOUS LES BATIMENTS QUI RAPPORTENT DU BOIS
		for (BatimentJoueur batimentBois : batimentJoueurRepo.findByApportBoisHeureGreaterThan(1)) {
			apportBoisHeure = apportBoisHeure + batimentBois.getApportBoisHeure();
		}
		// -- APPORT BOIS PAR SECONDES
		Integer apportBoisSeconde = apportBoisHeure / 3600;

		// ------------
		// -- OR --
		// ------------
		// CALCUL APPORT PAR HEURE DU JOUEUR
		Integer apportOrHeure = 0;
		// -- TOUS LES BATIMENTS QUI RAPPORTENT DE L'OR
		for (BatimentJoueur batimentOr : batimentJoueurRepo.findByApportOreHeureGreaterThan(1)) {
			apportOrHeure = apportOrHeure + batimentOr.getApportOreHeure();
		}
		// -- APPORT OR PAR SECONDES
		Integer apportOrSeconde = apportOrHeure / 3600;

		// ------------
		// -- NOURRITURE --
		// ------------
		// CALCUL APPORT PAR HEURE DU JOUEUR
		Integer apportNourritureHeure = 0;
		// -- TOUS LES BATIMENTS QUI RAPPORTENT DE LA NOURRITURE
		for (BatimentJoueur batimentNourriture : batimentJoueurRepo.findByApportNourritureHeureGreaterThan(1)) {
			apportNourritureHeure = apportNourritureHeure + batimentNourriture.getApportNourritureHeure();
		}
		// -- APPORT NOURRITURE PAR SECONDES
		Integer apportNourritureSeconde = apportNourritureHeure / 3600;

		jou.setPierrePossession((jou.getPierrePossession() + apportPierreSeconde)>jou.getPierreMaximum() ? jou.getPierreMaximum() : jou.getPierrePossession() + apportPierreSeconde);
		jou.setBoisPossession((jou.getBoisPossession() + apportBoisSeconde)>jou.getBoisMaximum() ? jou.getBoisMaximum() : jou.getBoisPossession() + apportBoisSeconde);
		jou.setOrPossession((jou.getOrPossession() + apportOrSeconde)>jou.getOrMaximum() ? jou.getOrMaximum() : jou.getOrPossession() + apportOrSeconde);
		jou.setNourriturePossession((jou.getNourriturePossession() + apportNourritureSeconde)>jou.getNourritureMaximum() ? jou.getNourritureMaximum() : jou.getNourriturePossession() + apportNourritureSeconde);
		jou.setTempsDeJeu(jou.getTempsDeJeu() + 1);

		Joueur joueur = new Joueur(jou.getArmee(), jou.getIcone(), jou.getPseudo(), jou.getEmail(), jou.getMotDePasse(),
				jou.getDescriptif(), jou.getNiveau(), jou.getExperience(), jou.getPierrePossession(),
				jou.getBoisPossession(), jou.getOrPossession(), jou.getNourriturePossession(), jou.getGemmePossession(),
				jou.getPierreMaximum(), jou.getBoisMaximum(), jou.getOrMaximum(), jou.getNourritureMaximum(),
				jou.getPierreBoostProduction(), jou.getBoisBoostProduction(), jou.getOrBoostProduction(),
				jou.getNourritureBoostProduction(), jou.getTempsDeJeu(), jou.getRoles());
		joueur.setId(jou.getId());
		this.joueurRepo.save(joueur);

		JoueurInfoDto co = new JoueurInfoDto(jou.getId(), jou.getIcone(), jou.getPseudo(), jou.getEmail(),
				jou.getDescriptif(), jou.getNiveau(), jou.getExperience(), jou.getPierrePossession(),
				jou.getBoisPossession(), jou.getOrPossession(), jou.getNourriturePossession(), jou.getGemmePossession(),
				jou.getPierreMaximum(), jou.getBoisMaximum(), jou.getOrMaximum(), jou.getNourritureMaximum(),
				jou.getPierreBoostProduction(), jou.getBoisBoostProduction(), jou.getOrBoostProduction(),
				jou.getNourritureBoostProduction(), jou.getTempsDeJeu());
		return co;
	}
}
