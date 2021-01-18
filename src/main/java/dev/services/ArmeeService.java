package dev.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.controller.dto.ArmeeDto;
import dev.controller.dto.ArmeeJoueurCreationDto;
import dev.controller.dto.UniteeDto;
import dev.entites.Joueur;
import dev.entites.joueur.Armee;
import dev.entites.unitee.Unitee;
import dev.exceptions.RessourceManquanteException;
import dev.repository.JoueurRepo;
import dev.repository.joueur.ArmeeRepo;
import dev.repository.unitee.UniteeRepo;

@Service
public class ArmeeService {

	JoueurService joueurService;
	UniteeService uniteeService;
	ArmeeRepo armeeRepo;
	UniteeRepo uniteeRepo;
	JoueurRepo joueurRepo;
	
	/**
	 * @param joueurService
	 * @param armeeRepo
	 */
	public ArmeeService(JoueurService joueurService, ArmeeRepo armeeRepo, UniteeService uniteeService, JoueurRepo joueurRepo) {
		super();
		this.joueurService = joueurService;
		this.armeeRepo = armeeRepo;
		this.uniteeService = uniteeService;
		this.joueurRepo = joueurRepo;
	}

	/**
	 * CREATION ARMEE DU JOUEUR (Nouvelles unitées)
	 * */
	public ArmeeJoueurCreationDto produireUnitee(ArmeeJoueurCreationDto armeeJoueurCreationDto) {
		System.out.println("Ligne 44");
		// Initialisations
		Boolean flag = false;
		Integer idArmee = 0;
		Integer quantitee = 0;
		Integer quantiteePierreManquante;
		Integer quantiteeBoisManquant;
		Integer quantiteeOrManquant;
		Integer quantiteeNourritureManquante;
		
		// Récupération des infos joueur (Pour soustraire les ressources).
		Joueur jou = this.joueurService.recuperationJoueur();
		
		// Informations sur l'unitée que le joueur veut créer
		UniteeDto un = this.uniteeService.detailsUnitee(armeeJoueurCreationDto.getIdUnitee());
		Unitee uni = new Unitee();
		uni.setId(un.getId());
		uni.setIdTypeUnitee(un.getIdTypeUnitee());
		uni.setIdBatimentProvenance(un.getIdBatimentProvenance());
		uni.setIcone(un.getIcone());
		uni.setLibelle(un.getLibelle());
		uni.setDescriptif(un.getDescriptif());
		uni.setCoutPierreFormation(un.getCoutPierreFormation());
		uni.setCoutBoisFormation(un.getCoutBoisFormation());
		uni.setCoutOrFormation(un.getCoutOrFormation());
		uni.setCoutNourritureFormation(un.getCoutNourritureFormation());
		uni.setCoutHumain(un.getCoutHumain());
		uni.setTempsFormation(un.getTempsFormation());
		uni.setVie(un.getVie());
		uni.setAttaque(un.getAttaque());
		uni.setPortee(un.getPortee());
		uni.setArmure(un.getArmure());
		uni.setNiveauBatimentNecessaireFormation(un.getNiveauBatimentNecessaireFormation());
		uni.setApportRessourcePierreHeure(un.getApportRessourcePierreHeure());
		uni.setApportRessourceBoisHeure(un.getApportRessourceBoisHeure());
		uni.setApportRessourceOrHeure(un.getApportRessourceOrHeure());
		uni.setApportRessourceNourritureHeure(un.getApportRessourceNourritureHeure());

		// Initialisations des coûts de formations (Coût unitée ressource x quantitée)
		Integer coutPierreOperation = uni.getCoutPierreFormation() * armeeJoueurCreationDto.getQuantitee();
		Integer coutBoisOperation = uni.getCoutBoisFormation() * armeeJoueurCreationDto.getQuantitee();
		Integer coutOrOperation = uni.getCoutOrFormation() * armeeJoueurCreationDto.getQuantitee();
		Integer coutNourritureOperation = uni.getCoutNourritureFormation() * armeeJoueurCreationDto.getQuantitee();
		System.out.println(coutOrOperation);

		/* Vérifications : La joueur à t'il assez de ressources ?? */
		// - SI RESSOURCES INSUFFISANTES 
		// -- Pierre manquante :
		if(jou.getPierrePossession() < coutPierreOperation) {
			quantiteePierreManquante = coutPierreOperation-jou.getPierrePossession();
			throw new RessourceManquanteException("Il vous manque "+quantiteePierreManquante+" de pierre pour lancer la production.");
		}		
		// -- Bois manquant :
		else if(jou.getBoisPossession() < coutBoisOperation) {
			quantiteeBoisManquant = coutBoisOperation-jou.getBoisPossession();
			throw new RessourceManquanteException("Il vous manque "+quantiteeBoisManquant+" de bois pour lancer la production.");
		}
		// -- Or manquant :
		else if(jou.getOrPossession() < coutOrOperation) {
			quantiteeOrManquant = coutOrOperation-jou.getOrPossession();
			throw new RessourceManquanteException("Il vous manque "+quantiteeOrManquant+" d'or pour lancer la production.");
		}
		// -- Nourriture manquante :
		else if(jou.getNourriturePossession() < coutNourritureOperation) {
			quantiteeNourritureManquante = coutNourritureOperation-jou.getNourriturePossession();
			throw new RessourceManquanteException("Il vous manque "+quantiteeNourritureManquante+" de nourriture pour lancer la production.");
		}
		
		
		// Parcourir les armées que possède déjà le joueur
		for (Armee arme : armeeRepo.findByJoueur(jou)) {
			// S'il possède déjà un type d'unitée, récupération de données (L'id de l'armée, et la quantitée d'unitées)
			if(arme.getUnitee().getId()==armeeJoueurCreationDto.getIdUnitee()) {
				flag = true;
				idArmee = arme.getId();
				quantitee = arme.getQuantitee();
			}
		}
		
		Armee armee = new Armee();
		// Si le joueur possède déjà ce type d'unitée, alors on aditionne les quantitées (nouvelle + ancienne) + J'écrase l'armée déjà existante
		if(flag==true) {
			armee.setId(idArmee);
			armee.setQuantitee(quantitee + armeeJoueurCreationDto.getQuantitee());
			System.out.println("Possede deja unitee");
		}
		else // Sinon, je créer une nouvelle armée, pour ce genre d'unitée
		{
			armee.setQuantitee(armeeJoueurCreationDto.getQuantitee());
			System.out.println("Possede pas unitee");
		}
		
		// Je met à jour le joueur, pour y enlever les ressources
		jou.setPierrePossession(jou.getPierrePossession()-coutPierreOperation);
		jou.setBoisPossession(jou.getBoisPossession()-coutBoisOperation);
		jou.setOrPossession(jou.getOrPossession()-coutOrOperation);
		jou.setNourriturePossession(jou.getNourriturePossession()-coutNourritureOperation);
		Joueur joueur = new Joueur(jou.getArmee(),jou.getIcone(),jou.getPseudo(),jou.getEmail(),jou.getMotDePasse(),jou.getDescriptif(),jou.getNiveau(),jou.getExperience(),jou.getPierrePossession(),jou.getBoisPossession(),jou.getOrPossession(),jou.getNourriturePossession(),jou.getGemmePossession(),jou.getPierreMaximum(),jou.getBoisMaximum(),jou.getOrMaximum(),jou.getNourritureMaximum(),jou.getPierreBoostProduction(),jou.getBoisBoostProduction(),jou.getOrBoostProduction(),jou.getNourritureBoostProduction(),jou.getTempsDeJeu(),jou.getRoles());
		joueur.setId(jou.getId());
		this.joueurRepo.save(joueur);

		// J'enregistre l'armée
		armee.setJoueur(jou);
		armee.setUnitee(uni);
		armeeRepo.save(armee);
		
		return new ArmeeJoueurCreationDto(armee.getUnitee().getId(), armee.getQuantitee());
	}
	
	/**
	 * LISTER LES ARMEES DU JOUEURS
	 * */
	public List<ArmeeDto> listerArmeesDuJoueur() {
		// Récupération des infos joueur (Pour soustraire les ressources).
		Joueur jou = this.joueurService.recuperationJoueur();
		
		List<ArmeeDto> listeArmeesDuJoueur = new ArrayList<>();
		for (Armee armee : armeeRepo.findByJoueur(jou)) {
			ArmeeDto armeeDto = new ArmeeDto();
			armeeDto.setId(armee.getId());
			armeeDto.setJoueur(armee.getJoueur());
			armeeDto.setUnitee(armee.getUnitee());
			armeeDto.setQuantitee(armee.getQuantitee());
			
			listeArmeesDuJoueur.add(armeeDto);
		}
		return listeArmeesDuJoueur;
	}
}
