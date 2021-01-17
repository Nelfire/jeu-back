package dev.entites.joueur;

import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import dev.controller.dto.ArmeeJoueurCreationDto;
import dev.entites.Joueur;
import dev.entites.unitee.Unitee;

@Entity
public class Armee {

	// https://www.baeldung.com/jpa-one-to-one
	
	// Déclarations
    /** id de la Armee **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	@ManyToOne
	@JoinColumn(name = "joueur_id")
    private Joueur joueur;
    
//    @Column
//    @ElementCollection(targetClass=Unitee.class)
	@ManyToOne
	@JoinColumn(name = "unitee_id")
    private Unitee unitee;
    
    private Integer quantitee;

    // Constructeur vide
	public Armee() {
		super();
	}

	/**
	 * @param id
	 * @param joueur
	 * @param unitee
	 * @param quantitee
	 */
	public Armee(Integer id, Joueur joueur, Unitee unitee, Integer quantitee) {
		super();
		this.id = id;
		this.joueur = joueur;
		this.unitee = unitee;
		this.quantitee = quantitee;
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

	@Override
	public String toString() {
		return "Armee [id=" + id + ", joueur=" + joueur + ", unitee=" + unitee + ", quantitee=" + quantitee + "]";
	}

	
	
	
}

