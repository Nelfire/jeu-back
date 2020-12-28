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

@Entity
public class Armee {

	// https://www.baeldung.com/jpa-one-to-one
	
	// Déclarations
    /** id de la Armee **/
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @OneToOne(mappedBy = "armee")
    private Joueur joueur;
    
    @Column
    @ElementCollection(targetClass=Integer.class)
    private List<Integer> idUnitees;

	/**
	 * @param id
	 * @param joueur
	 * @param idUnitees
	 */
	public Armee(Joueur joueur, List<Integer> idUnitees) {
		super();
		this.joueur = joueur;
		this.idUnitees = idUnitees;
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
	 * @return the idUnitees
	 */
	public List<Integer> getIdUnitees() {
		return idUnitees;
	}

	/**
	 * @param idUnitees the idUnitees to set
	 */
	public void setIdUnitees(List<Integer> idUnitees) {
		this.idUnitees = idUnitees;
	}

	@Override
	public String toString() {
		return "Armee [id=" + id + ", joueur=" + joueur + ", idUnitees=" + idUnitees + "]";
	}
    
    

}

