package dev.entites.campagne;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import dev.entites.unitee.Unitee;

@Entity
public class CampagneUnitee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer idCampagne;
	
	private Integer idUnitee;
	
	private Integer quantite;
	
	public CampagneUnitee() {
		
	}

	/**
	 * @param idCampagne
	 * @param idUnitee
	 * @param quantite
	 */
	public CampagneUnitee(Integer idCampagne, Integer idUnitee, Integer quantite) {
		super();
		this.idCampagne = idCampagne;
		this.idUnitee = idUnitee;
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
	 * @return the idCampagne
	 */
	public Integer getIdCampagne() {
		return idCampagne;
	}

	/**
	 * @param idCampagne the idCampagne to set
	 */
	public void setIdCampagne(Integer idCampagne) {
		this.idCampagne = idCampagne;
	}

	/**
	 * @return the idUnitee
	 */
	public Integer getIdUnitee() {
		return idUnitee;
	}

	/**
	 * @param idUnitee the idUnitee to set
	 */
	public void setIdUnitee(Integer idUnitee) {
		this.idUnitee = idUnitee;
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

	

}
