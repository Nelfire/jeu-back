package dev.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.controller.dto.ArmeeDto;
import dev.controller.dto.ArmeeJoueurCreationDto;
import dev.controller.dto.UniteeDto;
import dev.entites.Joueur;
import dev.entites.joueur.Armee;
import dev.entites.unitee.Unitee;
import dev.repository.joueur.ArmeeRepo;
import dev.repository.unitee.UniteeRepo;

@Service
public class ArmeeService {

	JoueurService joueurService;
	UniteeService uniteeService;
	ArmeeRepo armeeRepo;
	UniteeRepo uniteeRepo;
	
	/**
	 * @param joueurService
	 * @param armeeRepo
	 */
	public ArmeeService(JoueurService joueurService, ArmeeRepo armeeRepo, UniteeService uniteeService) {
		super();
		this.joueurService = joueurService;
		this.armeeRepo = armeeRepo;
		this.uniteeService = uniteeService;
	}

	public ArmeeJoueurCreationDto produireUnitee(ArmeeJoueurCreationDto armeeJoueurCreationDto) {
		
		Boolean flag = false;
		Integer idArmee = 0;
		Integer quantitee = 0;
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

		// Parcourir les armées que possède déjà le joueur
		for (Armee arme : armeeRepo.findByJoueur(jou)) {
			// S'il possède déjà un type d'unitée, on aditionne de nouvelles unitées
			if(arme.getUnitee().getId()==armeeJoueurCreationDto.getIdUnitee()) {
				flag = true;
				idArmee = arme.getId();
				quantitee = arme.getQuantitee();
			}
		}
		
		Armee armee = new Armee();
		if(flag==true) {
			armee.setId(idArmee);
			armee.setQuantitee(quantitee + armeeJoueurCreationDto.getQuantitee());
		}
		else {
			armee.setQuantitee(armeeJoueurCreationDto.getQuantitee());
		}
		// Récupération de l'armée du joueur
		armee.setJoueur(jou);
		armee.setUnitee(uni);
		armeeRepo.save(armee);

		return new ArmeeJoueurCreationDto(armee.getUnitee().getId(), armee.getQuantitee());
	}
	
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
