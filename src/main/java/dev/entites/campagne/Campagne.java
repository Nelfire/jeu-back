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

import dev.entites.unitee.Unitee;

@Entity
public class Campagne {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/** une campagne peut être réalisée par plusieurs joueurs **/
	@OneToMany(mappedBy = "campagne")
	@JsonIgnore
	private List<CampagneJoueur> campagneJoueur;

	/** type d'unité de la campagne **/
	@ManyToOne
	@JoinColumn(name = "unitee_id")
	private Unitee unitee;

	/** icone de la campagne **/
	private String icone;

	/** libellé de la campagne **/
	private String libelle;

	/** description de la campagne **/
	private String description;

	/** durée de la campagne **/
	private Integer duree;

	/** numéro monde de la campagne **/
	private Integer monde;

	/** niveau de la campagne **/
	private Integer niveau;

	/** quantité d'unités de la campagne **/
	private Integer quantitee;

	/** niveau de difficulte boss **/
	private Boolean isBoss;

	/** montant récompense en pierre de la campagne **/
	private Long recompensePierre;
	
	/** montant récompense en bois de la campagne **/
	private Long recompenseBois;
	
	/** montant récompense en or de la campagne **/
	private Long recompenseOr;
	
	/** montant récompense en nourriture de la campagne **/
	private Long recompenseNourriture;
	
	/** montant récompense en gemme de la campagne **/
	private Integer recompenseGemme;
	
	/** montant récompense en experience de la campagne **/
	private Long recompenseExperience;

	/**
	 * CONSTRUCTEUR VIDE
	 */
	public Campagne() {
	}

	/**
	 * CONSTRUCTEUR AVEC PARAMETRES
	 * 
	 * @param campagneJoueur
	 * @param icone
	 * @param libelle
	 * @param description
	 * @param duree
	 * @param niveau
	 * @param unitee
	 * @param quantitee
	 * @param isBoss
	 * @param recompensePierre
	 * @param recompenseBois
	 * @param recompenseOr
	 * @param recompenseNourriture
	 * @param recompenseGemme
	 */
	public Campagne(String icone, String libelle, String description, Integer duree, Integer monde, Integer niveau,
			Unitee unitee, Integer quantitee, Boolean isBoss, Long recompensePierre, Long recompenseBois,
			Long recompenseOr, Long recompenseNourriture, Integer recompenseGemme, Long recompenseExperience) {
		super();
		this.icone = icone;
		this.libelle = libelle;
		this.description = description;
		this.duree = duree;
		this.monde = monde;
		this.niveau = niveau;
		this.unitee = unitee;
		this.quantitee = quantitee;
		this.isBoss = isBoss;
		this.recompensePierre = recompensePierre;
		this.recompenseBois = recompenseBois;
		this.recompenseOr = recompenseOr;
		this.recompenseNourriture = recompenseNourriture;
		this.recompenseGemme = recompenseGemme;
		this.recompenseExperience = recompenseExperience;
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
	 * @return the monde
	 */
	public Integer getMonde() {
		return monde;
	}

	/**
	 * @param monde the monde to set
	 */
	public void setMonde(Integer monde) {
		this.monde = monde;
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
	 * @return the unitee
	 */
	public Unitee getUnitee() {
		return unitee;
	}

	/**
	 * @param unitee the unitee to set
	 */
	public void setUnitee(Unitee unitee) {
		this.unitee = unitee;
	}

	/**
	 * @return the quantitee
	 */
	public Integer getQuantitee() {
		return quantitee;
	}

	/**
	 * @param quantitee the quantitee to set
	 */
	public void setQuantitee(Integer quantitee) {
		this.quantitee = quantitee;
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

	/**
	 * @return the recompenseExperience
	 */
	public Long getRecompenseExperience() {
		return recompenseExperience;
	}

	/**
	 * @param recompenseExperience the recompenseExperience to set
	 */
	public void setRecompenseExperience(Long recompenseExperience) {
		this.recompenseExperience = recompenseExperience;
	}

	@Override
	public String toString() {
		return "Campagne [id=" + id + ", icone=" + icone + ", libelle=" + libelle + ", description=" + description
				+ ", duree=" + duree + ", monde=" + monde + ", niveau=" + niveau + ", unitee=" + unitee + ", quantitee="
				+ quantitee + ", isBoss=" + isBoss + ", recompensePierre=" + recompensePierre + ", recompenseBois="
				+ recompenseBois + ", recompenseOr=" + recompenseOr + ", recompenseNourriture=" + recompenseNourriture
				+ ", recompenseGemme=" + recompenseGemme + ", recompenseExperience=" + recompenseExperience + "]";
	}

}
