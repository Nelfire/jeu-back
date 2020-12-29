package dev.entites.joueur;

import java.util.List;

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
    private List<Unitee> unitee;

	/**
	 * @param joueur
	 * @param unitee
	 */
	public Armee(Joueur joueur, List<Unitee> unitee) {
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
	public List<Unitee> getUnitee() {
		return unitee;
	}

	/**
	 * @param unitee the unitee to set
	 */
	public void setUnitee(List<Unitee> unitee) {
		this.unitee = unitee;
	}

	@Override
	public String toString() {
		return "Informations armée du joueur : [id=" + id + ", joueur=" + joueur + ", unitee=" + unitee + "]";
	}

    
    

}

