package dev.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.controller.dto.JoueurDto;
import dev.controller.dto.JoueurInfoDto;
import dev.entites.Joueur;
import dev.exceptions.JoueurAuthentifieNonRecupereException;
import dev.repository.JoueurRepo;

@Service
public class JoueurService {

	// Déclarations
	private JoueurRepo joueurRepo;

	/**
	 * Constructeur
	 *
	 * @param absenceRepository
	 */
	public JoueurService(JoueurRepo joueurRepo) {
		this.joueurRepo = joueurRepo;
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
	
//	public JoueurInfoDto getInfoJoueurEmail(String email) {
//		Joueur coll = joueurRepo.findByEmail(email).orElseThrow(() -> new JoueurAuthentifieNonRecupereException("Erreur."));
//		JoueurInfoDto col = new JoueurInfoDto(email, coll.getNom(), coll.getPrenom());
//		return col;
//	}
}
