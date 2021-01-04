package dev.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.controller.dto.BatimentDto;
import dev.controller.dto.BatimentJoueurCreationDto;
import dev.controller.dto.BatimentJoueurDto;
import dev.entites.Joueur;
import dev.entites.batiment.Batiment;
import dev.entites.joueur.BatimentJoueur;
import dev.exceptions.JoueurAuthentifieNonRecupereException;
import dev.repository.JoueurRepo;
import dev.repository.batiment.BatimentRepo;
import dev.repository.joueur.BatimentJoueurRepo;

@Service
public class BatimentJoueurService {

	private BatimentJoueurRepo batimentJoueurRepo;
	private BatimentRepo batimentRepo;
	private JoueurRepo joueurRepo;

	/**
	 * @param batimentJoueurRepo
	 */
	public BatimentJoueurService(BatimentJoueurRepo batimentJoueurRepo, BatimentRepo batimentRepo, JoueurRepo joueurRepo) {
		this.batimentJoueurRepo = batimentJoueurRepo;
		this.batimentRepo = batimentRepo;
		this.joueurRepo = joueurRepo;
	}
	
	public List<BatimentJoueurDto> listerMesBatiments(Integer idJoueur) {
		
		List<BatimentJoueurDto> listeMesBatiments = new ArrayList<>();
		for (BatimentJoueur batiment : batimentJoueurRepo.findByJoueurId(idJoueur)) {
			BatimentJoueurDto batimentJoueurDto = new BatimentJoueurDto(batiment.getJoueur(), batiment.getBatiment(),batiment.getNiveau(),batiment.getNombreExploitantsActif());
			listeMesBatiments.add(batimentJoueurDto);	
		}
		return listeMesBatiments;
	}

	// Créer un batiment joueur
	public BatimentJoueurCreationDto creationBatimentJoueur(BatimentJoueurCreationDto batimentJoueurCreationDto) {
		// Récupération email du joueur connecté
		String email = SecurityContextHolder.getContext().getAuthentication().getName();

		// Récupération du joueur connecté, via l'email
		Joueur jou = joueurRepo.findByEmail(email).orElseThrow(() -> new JoueurAuthentifieNonRecupereException("Le collègue authentifié n'a pas été récupéré"));
		
		// Recherche du batiment correspondant à la création
		Batiment batiment = batimentRepo.findByIdTypeBatiment(batimentJoueurCreationDto.getIdBatiment());
		
		// Création de la ligne batimentJoueur
		// Retrait ressource

		// -------- /!\ TESTES A FAIRE : -------- 
		// - SI RESSOURCES SUFFISANTES 
		// - SI OUVRIERS SUFFISANTS 
		// - SI LVL HDV SUFFISANTS 
		jou.setPierrePossession(jou.getPierrePossession()-batiment.getCoutPierreConstruction());
		jou.setBoisPossession(jou.getBoisPossession()-batiment.getCoutBoisConstruction());
		jou.setOrPossession(jou.getOrPossession()-batiment.getCoutOrConstruction());
		jou.setNourriturePossession(jou.getNourriturePossession()-batiment.getCoutNourritureConstruction());
		
		Joueur joueur = new Joueur(jou.getArmee(),jou.getIcone(),jou.getPseudo(),jou.getEmail(),jou.getMotDePasse(),jou.getDescriptif(),jou.getNiveau(),jou.getExperience(),jou.getPierrePossession(),jou.getBoisPossession(),jou.getOrPossession(),jou.getNourriturePossession(),jou.getGemmePossession(),jou.getPierreMaximum(),jou.getBoisMaximum(),jou.getOrMaximum(),jou.getNourritureMaximum(),jou.getPierreBoostProduction(),jou.getBoisBoostProduction(),jou.getOrBoostProduction(),jou.getNourritureBoostProduction(),jou.getTempsDeJeu(),jou.getRoles());
		joueur.setId(jou.getId());
		BatimentJoueur batimentJoueur = new BatimentJoueur(jou,batiment,1,0);
		
		// Sauvegarde 
		this.batimentJoueurRepo.save(batimentJoueur);
		this.joueurRepo.save(joueur);
		
		// Return
		return new BatimentJoueurCreationDto(batimentJoueur.getBatiment().getIdTypeBatiment());
	}
	
	
}
