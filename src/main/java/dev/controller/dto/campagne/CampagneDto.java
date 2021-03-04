package dev.controller.dto.campagne;

import java.util.List;

import javax.persistence.OneToMany;

import dev.entites.campagne.CampagneArmee;
import dev.entites.campagne.CampagneJoueur;

public class CampagneDto {

	private Integer id;
	private List<CampagneJoueur> campagneJoueur;
	private String icone;
	private String libelle;
	private String description;
	private Integer duree;
	private Integer niveau;
	private List<CampagneArmee> campagneArmee;
	private Boolean isBoss;
	private Long recompensePierre;
	private Long recompenseBois;
	private Long recompenseOr;
	private Long recompenseNourriture;
	private Integer recompenseGemme;
	
	
	public CampagneDto() {
		
	}
	/**
	 * @param id
	 * @param campagneJoueur
	 * @param icone
	 * @param libelle
	 * @param description
	 * @param duree
	 * @param niveau
	 * @param campagneArmee
	 * @param isBoss
	 * @param recompensePierre
	 * @param recompenseBois
	 * @param recompenseOr
	 * @param recompenseNourriture
	 * @param recompenseGemme
	 */
	public CampagneDto(Integer id, List<CampagneJoueur> campagneJoueur, String icone, String libelle,
			String description, Integer duree, Integer niveau, List<CampagneArmee> campagneArmee, Boolean isBoss,
			Long recompensePierre, Long recompenseBois, Long recompenseOr, Long recompenseNourriture,
			Integer recompenseGemme) {
		super();
		this.id = id;
		this.campagneJoueur = campagneJoueur;
		this.icone = icone;
		this.libelle = libelle;
		this.description = description;
		this.duree = duree;
		this.niveau = niveau;
		this.campagneArmee = campagneArmee;
		this.isBoss = isBoss;
		this.recompensePierre = recompensePierre;
		this.recompenseBois = recompenseBois;
		this.recompenseOr = recompenseOr;
		this.recompenseNourriture = recompenseNourriture;
		this.recompenseGemme = recompenseGemme;
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
	 * @return the campagneJoueur
	 */
	public List<CampagneJoueur> getCampagneJoueur() {
		return campagneJoueur;
	}
	/**
	 * @param campagneJoueur the campagneJoueur to set
	 */
	public void setCampagneJoueur(List<CampagneJoueur> campagneJoueur) {
		this.campagneJoueur = campagneJoueur;
	}
	/**
	 * @return the icone
	 */
	public String getIcone() {
		return icone;
	}
	/**
	 * @param icone the icone to set
	 */
	public void setIcone(String icone) {
		this.icone = icone;
	}
	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}
	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the duree
	 */
	public Integer getDuree() {
		return duree;
	}
	/**
	 * @param duree the duree to set
	 */
	public void setDuree(Integer duree) {
		this.duree = duree;
	}
	/**
	 * @return the niveau
	 */
	public Integer getNiveau() {
		return niveau;
	}
	/**
	 * @param niveau the niveau to set
	 */
	public void setNiveau(Integer niveau) {
		this.niveau = niveau;
	}
	/**
	 * @return the campagneArmee
	 */
	public List<CampagneArmee> getCampagneArmee() {
		return campagneArmee;
	}
	/**
	 * @param campagneArmee the campagneArmee to set
	 */
	public void setCampagneArmee(List<CampagneArmee> campagneArmee) {
		this.campagneArmee = campagneArmee;
	}
	/**
	 * @return the isBoss
	 */
	public Boolean getIsBoss() {
		return isBoss;
	}
	/**
	 * @param isBoss the isBoss to set
	 */
	public void setIsBoss(Boolean isBoss) {
		this.isBoss = isBoss;
	}
	/**
	 * @return the recompensePierre
	 */
	public Long getRecompensePierre() {
		return recompensePierre;
	}
	/**
	 * @param recompensePierre the recompensePierre to set
	 */
	public void setRecompensePierre(Long recompensePierre) {
		this.recompensePierre = recompensePierre;
	}
	/**
	 * @return the recompenseBois
	 */
	public Long getRecompenseBois() {
		return recompenseBois;
	}
	/**
	 * @param recompenseBois the recompenseBois to set
	 */
	public void setRecompenseBois(Long recompenseBois) {
		this.recompenseBois = recompenseBois;
	}
	/**
	 * @return the recompenseOr
	 */
	public Long getRecompenseOr() {
		return recompenseOr;
	}
	/**
	 * @param recompenseOr the recompenseOr to set
	 */
	public void setRecompenseOr(Long recompenseOr) {
		this.recompenseOr = recompenseOr;
	}
	/**
	 * @return the recompenseNourriture
	 */
	public Long getRecompenseNourriture() {
		return recompenseNourriture;
	}
	/**
	 * @param recompenseNourriture the recompenseNourriture to set
	 */
	public void setRecompenseNourriture(Long recompenseNourriture) {
		this.recompenseNourriture = recompenseNourriture;
	}
	/**
	 * @return the recompenseGemme
	 */
	public Integer getRecompenseGemme() {
		return recompenseGemme;
	}
	/**
	 * @param recompenseGemme the recompenseGemme to set
	 */
	public void setRecompenseGemme(Integer recompenseGemme) {
		this.recompenseGemme = recompenseGemme;
	}
	
	
}
