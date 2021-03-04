package dev.entites.campagne;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import dev.entites.unitee.Unitee;

@Entity
public class CampagneArmee {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	// Composition de l'armée averse
	@ManyToOne
	@JoinColumn(name = "unitee_id")
	private Unitee unitee;
	
	private Integer quantite;
	
	@ManyToOne
	@JoinColumn(name = "campagne_id")
	private Campagne campagne;

	/**
	 * 
	 */
	public CampagneArmee() {
		super();
	}

	/**
	 * @param unitee
	 * @param quantite
	 * @param campagne
	 */
	public CampagneArmee(Unitee unitee, Integer quantite) {
		super();
		this.unitee = unitee;
		this.quantite = quantite;
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
	 * @return the unitee
	 */
	public Unitee getUnite() {
		return unitee;
	}

	/**
	 * @param unitee the unitee to set
	 */
	public void setUnite(Unitee unitee) {
		this.unitee = unitee;
	}

	/**
	 * @return the quantite
	 */
	public Integer getQuantite() {
		return quantite;
	}

	/**
	 * @param quantite the quantite to set
	 */
	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
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
	
	
	
	
}
