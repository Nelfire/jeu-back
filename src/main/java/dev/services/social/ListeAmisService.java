package dev.services.social;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Service;
import dev.controller.dto.social.AjoutAmiDto;
import dev.entites.joueur.Joueur;
import dev.entites.social.ListeAmis;
import dev.exceptions.MessageResponseException;
import dev.repository.social.ListeAmisRepo;
import dev.services.joueur.JoueurService;

@Service
public class ListeAmisService {

	private ListeAmisRepo listeAmisRepo;
	private JoueurService joueurService;

	/**
	 * @param listeAmisRepo
	 * @param joueurService
	 */
	public ListeAmisService(ListeAmisRepo listeAmisRepo, JoueurService joueurService) {
		super();
		this.listeAmisRepo = listeAmisRepo;
		this.joueurService = joueurService;
	}

	/**
	 * AJOUTER UN NOUVEL AMI
	 */
	public AjoutAmiDto ajouterAmi(AjoutAmiDto idAmi) {
		
		// RECUPERATION JOUEUR CONNECTE
		Joueur jou = this.joueurService.recuperationJoueur();

		// INITIALISATION
		// - Joueur éméteur
		List<Integer> listeAmisDuJoueur = new ArrayList<>();
		ListeAmis listeAmis = new ListeAmis();
		Integer idListe = null;
		Boolean listeExistante = false;
		// - Joueur recepteur
		List<Integer> listeAmisDuJoueurDeux = new ArrayList<>();
		ListeAmis listeAmisDeux = new ListeAmis();
		Integer idListeDeux = null;
		Boolean listeExistanteDeux = false;

		// - Joueur éméteur
		// PARCOURS LISTE, VERIFICATION DEJA AMI
		for (ListeAmis liste : listeAmisRepo.findAll()) {
			// LISTE AMIS DU JOUEUR CONNECTE TROUVEE
			if (liste.getProprietaireListe() == jou.getId()) {
				listeExistante = true;
				idListe = liste.getId();
				// PARCOURS DES AMIS QUE LE JOUEUR POSSEDE DEJA
				for (Integer integer : liste.getListeDAmis()) {
					// RECUPERATION DES AMIS
					listeAmisDuJoueur.add(integer);
					// AMIS DEJA AJOUTE : EXCEPTION
					if (integer == idAmi.getIdAmi()) {
						throw new MessageResponseException("Vous êtes déjà amis avec cette personne.");
					}
				}
			}
		}

		// AJOUT DU NOUVEL AMI CHEZ L'EMETEUR
		listeAmisDuJoueur.add(idAmi.getIdAmi());

		// - Joueur recepteur
		// PARCOURS LISTE
		for (ListeAmis liste : listeAmisRepo.findAll()) {
			// LISTE AMIS DU JOUEUR CONNECTE TROUVEE
			if (liste.getProprietaireListe() == idAmi.getIdAmi()) {
				listeExistanteDeux = true;
				idListeDeux = liste.getId();

				// PARCOURS DES AMIS QUE LE JOUEUR POSSEDE DEJA
				for (Integer integer : liste.getListeDAmis()) {
					// RECUPERATION DES AMIS
					listeAmisDuJoueurDeux.add(integer);
				}
			}
		}

		// AJOUT DU NOUVEL AMI CHEZ LE RECEPTEUR
		listeAmisDuJoueurDeux.add(jou.getId());

		// SAUVEGARDE 1
		// LISTE DEJA EXISTANTE : ECRASE LISTE , SINON : PREMIER AJOUT D'AMI, CREATION
		// D'UNE NOUVELLE LISTE
		if (listeExistante == true) {
			listeAmis.setId(idListe);
		}

		listeAmis.setProprietaireListe(jou.getId());
		listeAmis.setListeDAmis(listeAmisDuJoueur);

		listeAmisRepo.save(listeAmis);

		// SAUVEGARDE 2
		// LISTE DEJA EXISTANTE : ECRASE LISTE , SINON : PREMIER AJOUT D'AMI, CREATION
		// D'UNE NOUVELLE LISTE
		if (listeExistanteDeux == true) {
			listeAmisDeux.setId(idListeDeux);
		}

		listeAmisDeux.setProprietaireListe(idAmi.getIdAmi());
		listeAmisDeux.setListeDAmis(listeAmisDuJoueurDeux);

		listeAmisRepo.save(listeAmisDeux);

		// RETOUR
		return idAmi;
	}

	/**
	 * LISTER LES AMIS DU JOUEUR
	 */
	public ListeAmis lister() {
		// RECUPERATION JOUEUR
		Joueur jou = this.joueurService.recuperationJoueur();

		// INITIALISATION
		ListeAmis listeAmis = new ListeAmis();

		// PARCOURS LISTE DES AMIS
		for (ListeAmis liste : listeAmisRepo.findAll()) {

			// LISTE AMIS DU JOUEUR CONNECTE TROUVEE
			if (liste.getProprietaireListe() == jou.getId()) {

				listeAmis.setId(liste.getId());
				listeAmis.setProprietaireListe(liste.getProprietaireListe());
				listeAmis.setListeDAmis(liste.getListeDAmis());
			}
		}

		// RETOUR
		return listeAmis;
	}

	/**
	 * MODIFICATION LISTE AMI (Retrait d'un ami)
	 */
	public AjoutAmiDto retirerAmi(@Valid AjoutAmiDto idAmi, Integer id) {

		// RECUPERATION JOUEUR
		Joueur jou = this.joueurService.recuperationJoueur();

		// INITIALISATION
		List<Integer> listeAmisDuJoueur = new ArrayList<>();
		List<Integer> listeAmisDuJoueurDeux = new ArrayList<>();
		ListeAmis listeAmis = new ListeAmis();
		Integer idListe = null;

		// JOUEUR 1
		// PARCOURS LISTE, VERIFICATION DEJA AMI
		for (ListeAmis liste : listeAmisRepo.findAll()) {

			// LISTE AMIS DU JOUEUR CONNECTE TROUVEE
			if (liste.getProprietaireListe() == jou.getId()) {
				idListe = liste.getId();

				// PARCOURS DES AMIS QUE LE JOUEUR POSSEDE DEJA
				for (Integer integer : liste.getListeDAmis()) {

					// RECUPERATION DES AMIS
					if (integer != id) {
						listeAmisDuJoueur.add(integer);
					}
				}
			}
		}

		// SAUVEGARDE JOUEUR 1
		listeAmis.setId(idListe);
		listeAmis.setProprietaireListe(jou.getId());
		listeAmis.setListeDAmis(listeAmisDuJoueur);
		listeAmisRepo.save(listeAmis);

		// JOUEUR 2
		// PARCOURS LISTE, VERIFICATION DEJA AMI
		for (ListeAmis liste : listeAmisRepo.findAll()) {
			// LISTE AMIS DU JOUEUR RECEPTEUR
			if (liste.getProprietaireListe() == id) {
				idListe = liste.getId();
				// PARCOURS DES AMIS QUE LE JOUEUR POSSEDE DEJA
				for (Integer integer : liste.getListeDAmis()) {
					// RECUPERATION DES AMIS
					if (integer != jou.getId()) {
						listeAmisDuJoueurDeux.add(integer);
					}
				}
			}
		}

		// SAUVEGARDE JOUEUR 2
		listeAmis.setId(idListe);
		listeAmis.setProprietaireListe(id);
		listeAmis.setListeDAmis(listeAmisDuJoueurDeux);
		listeAmisRepo.save(listeAmis);

		// RETOUR
		return idAmi;
	}

}
