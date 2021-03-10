package dev.services.social;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import dev.controller.dto.social.CreationGuildeDto;
import dev.entites.joueur.Joueur;
import dev.entites.social.Guilde;
import dev.exceptions.NomGuildeDejaPrisException;
import dev.exceptions.RessourceManquanteException;
import dev.repository.JoueurRepo;
import dev.repository.social.GuildeRepo;
import dev.services.joueur.JoueurService;

@Service
public class GuildeService {

	GuildeRepo guildeRepo;
	JoueurRepo joueurRepo;
	JoueurService joueurService;

	/**
	 * @param guildeRepo
	 * @param joueurService
	 * @param joueurRepo
	 */
	private GuildeService(GuildeRepo guildeRepo, JoueurService joueurService, JoueurRepo joueurRepo) {
		this.guildeRepo = guildeRepo;
		this.joueurService = joueurService;
		this.joueurRepo = joueurRepo;
	}

	/**
	 * CREER UNE NOUVELLE GUILDE
	 */
	public Guilde creationGuilde(CreationGuildeDto creationGuildeDto) {
		
		// INITIALISATIONS
		List<Joueur> listeDesMembres = new ArrayList<>();
		
		// RECUPERATION DU JOUEUR CONNECTE
		Joueur jou = joueurService.recuperationJoueur();

		// AJOUT AU TABLEAU LE CREATEUR DE LA GUILDE
		listeDesMembres.add(jou);

		// CREATION DE LA GUILDE
		Guilde guildeCree = new Guilde();

		// RETRAIT DES RESSOURCES (de création de guilde) AU JOUEUR
		// TEST : LE JOUEUR À T'IL ASSEZ DE RESSOURCES POUR CREER LA GUILDE ???
		if (jou.getOrPossession() < guildeCree.getCoutOrCreation()) {
			throw new RessourceManquanteException("Or insuffisant pour créer la guilde.");
		}

		// RETRAIT DES RESSOURCES AU JOUEUR
		jou.setOrPossession(jou.getOrPossession() - guildeCree.getCoutOrCreation());

		// VERIFICATION NOM DE GUILDE PAS DEJA EXISTANT
		for (Guilde verificationNomDejaPris : guildeRepo.findAll()) {
			if (verificationNomDejaPris.getLibelle().equals(creationGuildeDto.getLibelle())) {
				throw new NomGuildeDejaPrisException("Nom de guilde déjà pris");
			}
		}

		Joueur joueur = new Joueur(jou.getArmee(), jou.getIcone(), jou.getPseudo(), jou.getEmail(), jou.getMotDePasse(),
				jou.getDescriptif(), jou.getNiveau(), jou.getExperience(), jou.getPierrePossession(),
				jou.getBoisPossession(), jou.getOrPossession(), jou.getNourriturePossession(), jou.getGemmePossession(),
				jou.getPierreMaximum(), jou.getBoisMaximum(), jou.getOrMaximum(), jou.getNourritureMaximum(),
				jou.getPierreBoostProduction(), jou.getBoisBoostProduction(), jou.getOrBoostProduction(),
				jou.getNourritureBoostProduction(), jou.getTempsDeJeu(), jou.getRoles(), jou.getDerniereConnexion(),
				jou.getDonateur(), jou.getPositionX(), jou.getPositionY());

		// DONNEES SETTÉES
		guildeCree.setLibelle(creationGuildeDto.getLibelle());
		guildeCree.setIcone(creationGuildeDto.getIcone());
		guildeCree.setMessageAccueil("");

		guildeCree.setListeMembres(listeDesMembres);
		guildeCree.setNiveau(1);
		guildeCree.setExperience(0);
		guildeCree.setNombreMembresMaximal(20);

		// MISE A JOUR DU JOUEUR
		joueur.setId(jou.getId());

		// SAUVEGARDE
		this.joueurRepo.save(joueur);
		this.guildeRepo.save(guildeCree);
		
		// RETOUR
		return guildeCree;

	}

	/**
	 * LISTE TOUTES LES GUILDES
	 */
	public List<Guilde> listerLesGuildes() {
		
		// INITIALISATIONS
		List<Guilde> lesGuildes = new ArrayList<>();
		
		// PARCOURS TOUTES LES GUILDES
		for (Guilde guilde : this.guildeRepo.findAll()) {
			lesGuildes.add(guilde);
		}
		
		// RETOUR
		return lesGuildes;
	}
}
