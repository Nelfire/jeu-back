package dev.entites.expedition;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Expedition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/** Une expedition peut avoir plusieures expeditionJoueur **/
	@OneToMany(mappedBy = "expedition")
	@JsonIgnore
	private List<ExpeditionJoueur> expeditionJoueur;

	/** icone de l'expédition **/
	private String icone;

	/** libellé de l'expédition **/
	private String libelle;

	/** description de l'expédition **/
	private String description;

	/** durée de l'expédition **/
	private Integer dureeExpedition;

	/** difficultée de l'expédition **/
	private Integer difficultee;

	/** dégats émis par l'expédition **/
	private Long degats;

	/** vie de l'expédition **/
	private Long vie;

	/** vie de l'expédition **/
	private Long armure;

	/** coût pierre de l'expédition **/
	private Integer coutPierre;

	/** coût bois de l'expédition **/
	private Integer coutBois;

	/** coût or de l'expédition **/
	private Integer coutOr;

	/** coût nourriture de l'expédition **/
	private Integer coutNourriture;

	/** récompense pierre de l'expédition **/
	private Long recompensePierre;

	/** récompense bois de l'expédition **/
	private Long recompenseBois;

	/** récompense or de l'expédition **/
	private Long recompenseOr;

	/** récompense nourriture de l'expédition **/
	private Long recompenseNourriture;

	/** récompense gemme de l'expédition **/
	private Long recompenseGemme;

	/** récompense expérience de l'expédition **/
	private Long recompenseExperience;

	/** date de parution de l'expédition **/
	private LocalDate dateParution;

	/**
	 * CONSTRUCTEUR VIDE
	 */
	public Expedition() {

	}

	/**
	 * CONSTRUCTEUR AVEC PARAMETRES
	 * 
	 * @param expeditionJoueur
	 * @param libelle
	 * @param description
	 * @param dureeExpedition
	 * @param pourcentageReussite
	 * @param difficultee
	 * @param degats
	 * @param vie
	 * @param armure
	 * @param coutPierre
	 * @param coutBois
	 * @param coutOr
	 * @param coutNourriture
	 * @param recompensePierre
	 * @param recompenseBois
	 * @param recompenseOr
	 * @param recompenseNourriture
	 * @param recompenseGemme
	 */
	public Expedition(String icone, String libelle, String description, Integer dureeExpedition, Integer difficultee,
			Long degats, Long vie, Long armure, Integer coutPierre, Integer coutBois, Integer coutOr,
			Integer coutNourriture, Long recompensePierre, Long recompenseBois, Long recompenseOr,
			Long recompenseNourriture, Long recompenseGemme, Long recompenseExperience, LocalDate dateParution) {
		super();
		this.icone = icone;
		this.libelle = libelle;
		this.description = description;
		this.dureeExpedition = dureeExpedition;
		this.difficultee = difficultee;
		this.degats = degats;
		this.vie = vie;
		this.armure = armure;
		this.coutPierre = coutPierre;
		this.coutBois = coutBois;
		this.coutOr = coutOr;
		this.coutNourriture = coutNourriture;
		this.recompensePierre = recompensePierre;
		this.recompenseBois = recompenseBois;
		this.recompenseOr = recompenseOr;
		this.recompenseNourriture = recompenseNourriture;
		this.recompenseGemme = recompenseGemme;
		this.recompenseExperience = recompenseExperience;
		this.dateParution = dateParution;
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
	 * @return the expeditionJoueur
	 */
	public List<ExpeditionJoueur> getExpeditionJoueur() {
		return expeditionJoueur;
	}

	/**
	 * @param expeditionJoueur the expeditionJoueur to set
	 */
	public void setExpeditionJoueur(List<ExpeditionJoueur> expeditionJoueur) {
		this.expeditionJoueur = expeditionJoueur;
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
	 * @return the dureeExpedition
	 */
	public Integer getDureeExpedition() {
		return dureeExpedition;
	}

	/**
	 * @param dureeExpedition the dureeExpedition to set
	 */
	public void setDureeExpedition(Integer dureeExpedition) {
		this.dureeExpedition = dureeExpedition;
	}

	/**
	 * @return the difficultee
	 */
	public Integer getDifficultee() {
		return difficultee;
	}

	/**
	 * @param difficultee the difficultee to set
	 */
	public void setDifficultee(Integer difficultee) {
		this.difficultee = difficultee;
	}

	/**
	 * @return the degats
	 */
	public Long getDegats() {
		return degats;
	}

	/**
	 * @param degats the degats to set
	 */
	public void setDegats(Long degats) {
		this.degats = degats;
	}

	/**
	 * @return the vie
	 */
	public Long getVie() {
		return vie;
	}

	/**
	 * @param vie the vie to set
	 */
	public void setVie(Long vie) {
		this.vie = vie;
	}

	/**
	 * @return the armure
	 */
	public Long getArmure() {
		return armure;
	}

	/**
	 * @param armure the armure to set
	 */
	public void setArmure(Long armure) {
		this.armure = armure;
	}

	/**
	 * @return the coutPierre
	 */
	public Integer getCoutPierre() {
		return coutPierre;
	}

	/**
	 * @param coutPierre the coutPierre to set
	 */
	public void setCoutPierre(Integer coutPierre) {
		this.coutPierre = coutPierre;
	}

	/**
	 * @return the coutBois
	 */
	public Integer getCoutBois() {
		return coutBois;
	}

	/**
	 * @param coutBois the coutBois to set
	 */
	public void setCoutBois(Integer coutBois) {
		this.coutBois = coutBois;
	}

	/**
	 * @return the coutOr
	 */
	public Integer getCoutOr() {
		return coutOr;
	}

	/**
	 * @param coutOr the coutOr to set
	 */
	public void setCoutOr(Integer coutOr) {
		this.coutOr = coutOr;
	}

	/**
	 * @return the coutNourriture
	 */
	public Integer getCoutNourriture() {
		return coutNourriture;
	}

	/**
	 * @param coutNourriture the coutNourriture to set
	 */
	public void setCoutNourriture(Integer coutNourriture) {
		this.coutNourriture = coutNourriture;
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
	public Long getRecompenseGemme() {
		return recompenseGemme;
	}

	/**
	 * @param recompenseGemme the recompenseGemme to set
	 */
	public void setRecompenseGemme(Long recompenseGemme) {
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

	/**
	 * @return the dateParution
	 */
	public LocalDate getDateParution() {
		return dateParution;
	}

	/**
	 * @param dateParution the dateParution to set
	 */
	public void setDateParution(LocalDate dateParution) {
		this.dateParution = dateParution;
	}

}
