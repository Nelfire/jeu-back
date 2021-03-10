package dev.entites.expedition;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import dev.entites.joueur.Armee;
import dev.entites.joueur.Joueur;

@Entity
public class ExpeditionJoueur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * Un joueur peut avoir plusieurs ExpeditionJoueur, mais une ExpeditionJoueur
	 * n'a qu'un seul joueur à la fois
	 **/
	@ManyToOne
	@JoinColumn(name = "joueur_id")
	private Joueur joueur;

	/**
	 * Une expedition peut concerncé plusieures ExpeditionJoueur, mais une
	 * ExpeditionJoueur n'est concernée par qu'une seul Expédition à la fois
	 **/
	@ManyToOne
	@JoinColumn(name = "expedition_id")
	private Expedition expedition;

	/** plusieurs armées peuvent être envoyées sur une expédition joueur **/
	@OneToMany(mappedBy = "expeditionJoueur")
	@JsonIgnore
	private List<Armee> armeeEnvoiJoueur;

	/** date de début de l'expédition **/
	private Long dateDebutExpedition;

	/** date de fin de l'expédition **/
	private Long dateFinExpedition;

	/** récompense récupérée (O/N) **/
	private Boolean recompenseRecuperee;

	/** pourcentage de réussite de l'expédition **/
	private Integer pourcentageReussite;

	/** 0 = En attente,1 = Réussie, 2 = Terminée, 3 = Echec **/
	private Integer etatExpedition;

	/**
	 * CONSTRUCTEUR VIDE
	 */
	public ExpeditionJoueur() {

	}

	/**
	 * CONSTRUCTEUR AVEC PARAMETRES
	 * 
	 * @param joueur
	 * @param expedition
	 * @param dateDebutExpedition
	 * @param dateFinExpedition
	 * @param armeeEnvoiJoueur
	 * @param recompenseRecuperee
	 * @param pourcentageReussite
	 * @param etatExpedition
	 */
	public ExpeditionJoueur(Joueur joueur, Expedition expedition, Long dateDebutExpedition, Long dateFinExpedition,
			List<Armee> armeeEnvoiJoueur, Boolean recompenseRecuperee, Integer pourcentageReussite,
			Integer etatExpedition) {
		super();
		this.joueur = joueur;
		this.expedition = expedition;
		this.dateDebutExpedition = dateDebutExpedition;
		this.dateFinExpedition = dateFinExpedition;
		this.armeeEnvoiJoueur = armeeEnvoiJoueur;
		this.recompenseRecuperee = recompenseRecuperee;
		this.pourcentageReussite = pourcentageReussite;
		this.etatExpedition = etatExpedition;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the expedition
	 */
	public Expedition getExpedition() {
		return expedition;
	}

	/**
	 * @param expedition the expedition to set
	 */
	public void setExpedition(Expedition expedition) {
		this.expedition = expedition;
	}

	/**
	 * @return the dateDebutExpedition
	 */
	public Long getDateDebutExpedition() {
		return dateDebutExpedition;
	}

	/**
	 * @param dateDebutExpedition the dateDebutExpedition to set
	 */
	public void setDateDebutExpedition(Long dateDebutExpedition) {
		this.dateDebutExpedition = dateDebutExpedition;
	}

	/**
	 * @return the dateFinExpedition
	 */
	public Long getDateFinExpedition() {
		return dateFinExpedition;
	}

	/**
	 * @param dateFinExpedition the dateFinExpedition to set
	 */
	public void setDateFinExpedition(Long dateFinExpedition) {
		this.dateFinExpedition = dateFinExpedition;
	}

	/**
	 * @return the joueur
	 */
	public Joueur getJoueur() {
		return joueur;
	}

	/**
	 * @param joueur the joueur to set
	 */
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	/**
	 * @return the armeeEnvoiJoueur
	 */
	public List<Armee> getArmeeEnvoiJoueur() {
		return armeeEnvoiJoueur;
	}

	/**
	 * @param armeeEnvoiJoueur the armeeEnvoiJoueur to set
	 */
	public void setArmeeEnvoiJoueur(List<Armee> armeeEnvoiJoueur) {
		this.armeeEnvoiJoueur = armeeEnvoiJoueur;
	}

	/**
	 * @return the recompenseRecuperee
	 */
	public Boolean getRecompenseRecuperee() {
		return recompenseRecuperee;
	}

	/**
	 * @param recompenseRecuperee the recompenseRecuperee to set
	 */
	public void setRecompenseRecuperee(Boolean recompenseRecuperee) {
		this.recompenseRecuperee = recompenseRecuperee;
	}

	/**
	 * @return the pourcentageReussite
	 */
	public Integer getPourcentageReussite() {
		return pourcentageReussite;
	}

	/**
	 * @param pourcentageReussite the pourcentageReussite to set
	 */
	public void setPourcentageReussite(Integer pourcentageReussite) {
		this.pourcentageReussite = pourcentageReussite;
	}

	/**
	 * @return the etatExpedition
	 */
	public Integer getEtatExpedition() {
		return etatExpedition;
	}

	/**
	 * @param etatExpedition the etatExpedition to set
	 */
	public void setEtatExpedition(Integer etatExpedition) {
		this.etatExpedition = etatExpedition;
	}

}
