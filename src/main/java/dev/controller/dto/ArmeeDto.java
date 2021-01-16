package dev.controller.dto;

import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.OneToOne;

import dev.entites.Joueur;
import dev.entites.joueur.Armee;
import dev.entites.unitee.Unitee;

public class ArmeeDto {
    private Integer id;
    private Joueur joueur;
    private Map<Unitee, Integer> unitee;
	/**
	 * @param id
	 * @param joueur
	 * @param unitee
	 */
	public ArmeeDto(Armee armee) {
		super();
		this.id = armee.getId();
		this.joueur = armee.getJoueur();
		this.unitee = armee.getUnitee();
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
	 * @return the unitee
	 */
	public Map<Unitee, Integer> getUnitee() {
		return unitee;
	}
	/**
	 * @param unitee the unitee to set
	 */
	public void setUnitee(Map<Unitee, Integer> unitee) {
		this.unitee = unitee;
	}

	
    
	
}
