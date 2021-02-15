package dev.entites.expedition;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import dev.entites.unitee.Unitee;

@Entity
public class ExpeditionUnitee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer idExpedition;
	
	private Integer idUnitee;
	
	private Integer quantite;
	
	public ExpeditionUnitee() {
		
	}

	/**
	 * @param idExpedition
	 * @param idUnitee
	 * @param quantite
	 */
	public ExpeditionUnitee(Integer idExpedition, Integer idUnitee, Integer quantite) {
		super();
		this.idExpedition = idExpedition;
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
	 * @return the idExpedition
	 */
	public Integer getIdExpedition() {
		return idExpedition;
	}

	/**
	 * @param idExpedition the idExpedition to set
	 */
	public void setIdExpedition(Integer idExpedition) {
		this.idExpedition = idExpedition;
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
