package dev.entites.campagne;

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
public class CampagneJoueur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "joueur_id")
	private Joueur joueur;
	
	@ManyToOne
	@JoinColumn(name = "campagne_id")
	private Campagne campagne;
	
    private Long dateDebutCampagne;
    private Long dateFinCampagne;
	
	@OneToMany(mappedBy = "campagneJoueur")
	@JsonIgnore
    private List<Armee> armeeEnvoiJoueur;
	
	private Boolean recompenseRecuperee;
	
	private Integer pourcentageReussite;
	
	// 0 = En attente
	// 1 = Réussie
	// 2 = Echec
	private Integer etatExpedition;
	
	private Integer nombreTentatives;

	
	public CampagneJoueur() {
		
	}
	/**
	 * @param joueur
	 * @param campagne
	 * @param dateDebutCampagne
	 * @param dateFinCampagne
	 * @param armeeEnvoiJoueur
	 * @param recompenseRecuperee
	 * @param pourcentageReussite
	 * @param etatExpedition
	 */
	public CampagneJoueur(Joueur joueur, Campagne campagne, Long dateDebutCampagne, Long dateFinCampagne,
			List<Armee> armeeEnvoiJoueur, Boolean recompenseRecuperee, Integer pourcentageReussite,
			Integer etatExpedition, Integer nombreTentatives) {
		super();
		this.joueur = joueur;
		this.campagne = campagne;
		this.dateDebutCampagne = dateDebutCampagne;
		this.dateFinCampagne = dateFinCampagne;
		this.armeeEnvoiJoueur = armeeEnvoiJoueur;
		this.recompenseRecuperee = recompenseRecuperee;
		this.pourcentageReussite = pourcentageReussite;
		this.etatExpedition = etatExpedition;
		this.nombreTentatives = nombreTentatives;
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
	 * @return the campagne
	 */
	public Campagne getCampagne() {
		return campagne;
	}
	/**
	 * @param campagne the campagne to set
	 */
	public void setCampagne(Campagne campagne) {
		this.campagne = campagne;
	}
	/**
	 * @return the dateDebutCampagne
	 */
	public Long getDateDebutExpedition() {
		return dateDebutCampagne;
	}
	/**
	 * @param dateDebutCampagne the dateDebutCampagne to set
	 */
	public void setDateDebutExpedition(Long dateDebutCampagne) {
		this.dateDebutCampagne = dateDebutCampagne;
	}
	/**
	 * @return the dateFinCampagne
	 */
	public Long getDateFinExpedition() {
		return dateFinCampagne;
	}
	/**
	 * @param dateFinCampagne the dateFinCampagne to set
	 */
	public void setDateFinExpedition(Long dateFinCampagne) {
		this.dateFinCampagne = dateFinCampagne;
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
	/**
	 * @return the nombreTentatives
	 */
	public Integer getNombreTentatives() {
		return nombreTentatives;
	}
	/**
	 * @param nombreTentatives the nombreTentatives to set
	 */
	public void setNombreTentatives(Integer nombreTentatives) {
		this.nombreTentatives = nombreTentatives;
	}
	
	
	
	
}
