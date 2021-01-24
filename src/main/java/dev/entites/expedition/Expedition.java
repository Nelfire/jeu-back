package dev.entites.expedition;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.entites.joueur.ExpeditionJoueur;

@Entity
public class Expedition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
    /** Une expedition peut avoir plusieures expeditionJoueur **/
    @OneToMany(mappedBy = "expedition")
    @JsonIgnore
	private List<ExpeditionJoueur> expeditionJoueur;
    private String icone;
    private String libelle;
    private String description;
    
	private Integer dureeExpedition;
	// Difficultée
	private Integer difficultee;
	// -- Dégats qu'émet l'expédition
	private Integer degats;
	// -- Vie que possède l'expédition
	private Integer vie;
	// -- Armure que possède l'expédition
	private Integer armure;
	// Coût envoi
	private Integer coutPierre;
	private Integer coutBois;
	private Integer coutOr;
	private Integer coutNourriture;
	// Récompense ressources
	private Integer recompensePierre;
	private Integer recompenseBois;
	private Integer recompenseOr;
	private Integer recompenseNourriture;
	private Integer recompenseGemme;
	private Integer recompenseExperience;
	
	public Expedition() {
		
	}


	/**
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
	public Expedition(String icone, String libelle, String description,
			Integer dureeExpedition, Integer difficultee, Integer degats, Integer vie,
			Integer armure, Integer coutPierre, Integer coutBois, Integer coutOr, Integer coutNourriture,
			Integer recompensePierre, Integer recompenseBois, Integer recompenseOr, Integer recompenseNourriture,
			Integer recompenseGemme, Integer recompenseExperience) {
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
	public Integer getDegats() {
		return degats;
	}

	/**
	 * @param degats the degats to set
	 */
	public void setDegats(Integer degats) {
		this.degats = degats;
	}

	/**
	 * @return the vie
	 */
	public Integer getVie() {
		return vie;
	}

	/**
	 * @param vie the vie to set
	 */
	public void setVie(Integer vie) {
		this.vie = vie;
	}

	/**
	 * @return the armure
	 */
	public Integer getArmure() {
		return armure;
	}

	/**
	 * @param armure the armure to set
	 */
	public void setArmure(Integer armure) {
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
	public Integer getRecompensePierre() {
		return recompensePierre;
	}

	/**
	 * @param recompensePierre the recompensePierre to set
	 */
	public void setRecompensePierre(Integer recompensePierre) {
		this.recompensePierre = recompensePierre;
	}

	/**
	 * @return the recompenseBois
	 */
	public Integer getRecompenseBois() {
		return recompenseBois;
	}

	/**
	 * @param recompenseBois the recompenseBois to set
	 */
	public void setRecompenseBois(Integer recompenseBois) {
		this.recompenseBois = recompenseBois;
	}

	/**
	 * @return the recompenseOr
	 */
	public Integer getRecompenseOr() {
		return recompenseOr;
	}

	/**
	 * @param recompenseOr the recompenseOr to set
	 */
	public void setRecompenseOr(Integer recompenseOr) {
		this.recompenseOr = recompenseOr;
	}

	/**
	 * @return the recompenseNourriture
	 */
	public Integer getRecompenseNourriture() {
		return recompenseNourriture;
	}

	/**
	 * @param recompenseNourriture the recompenseNourriture to set
	 */
	public void setRecompenseNourriture(Integer recompenseNourriture) {
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
	 * @return the recompenseExperience
	 */
	public Integer getRecompenseExperience() {
		return recompenseExperience;
	}


	/**
	 * @param recompenseExperience the recompenseExperience to set
	 */
	public void setRecompenseExperience(Integer recompenseExperience) {
		this.recompenseExperience = recompenseExperience;
	}

	
	
	
	
}
