package dev.entites.joueur;

import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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

    @OneToOne(mappedBy = "armee")
    private Joueur joueur;
    
    @Column
    @ElementCollection(targetClass=Unitee.class)
    private Map<Unitee, Integer> unitee;

    // Constructeur vide
	public Armee() {
		super();
	}
	/**
	 * @param joueur
	 * @param unitee
	 */
	public Armee(Joueur joueur, Map<Unitee,Integer> unitee) {
		super();
		this.joueur = joueur;
		this.unitee = unitee;
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
	public Map<Unitee,Integer> getUnitee() {
		return unitee;
	}

	/**
	 * @param unitee the unitee to set
	 */
	public void setUnitee(Map<Unitee,Integer> unitee) {
		this.unitee = unitee;
	}

	@Override
	public String toString() {
		return "Informations armée du joueur : [id=" + id + ", joueur=" + joueur + ", unitee=" + unitee + "]";
	}

    
    

}

