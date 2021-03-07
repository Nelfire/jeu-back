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

	// Une campagne peut être réalisée par plusieurs joueurs
    @OneToMany(mappedBy = "campagne")
	private List<CampagneJoueur> campagneJoueur;
    
	private String icone;
	private String libelle;
	private String description;
	private Integer duree;
	private Integer niveau;

	@ManyToOne
	@JoinColumn(name = "unitee_id")
    private Unitee unitee;
    
    private Integer quantitee;

	private Boolean isBoss;
	private Long recompensePierre;
	private Long recompenseBois;
	private Long recompenseOr;
	private Long recompenseNourriture;
	private Integer recompenseGemme;
	
	public Campagne() {
		
	}
	/**
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
	public Campagne(List<CampagneJoueur> campagneJoueur, String icone, String libelle, String description,
			Integer duree, Integer niveau, Unitee unitee, Integer quantitee, Boolean isBoss, Long recompensePierre,
			Long recompenseBois, Long recompenseOr, Long recompenseNourriture, Integer recompenseGemme) {
		super();
		this.campagneJoueur = campagneJoueur;
		this.icone = icone;
		this.libelle = libelle;
		this.description = description;
		this.duree = duree;
		this.niveau = niveau;
		this.unitee = unitee;
		this.quantitee = quantitee;
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
	
	

	
	
}
