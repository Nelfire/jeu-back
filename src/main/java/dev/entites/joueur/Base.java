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
import dev.entites.batiment.Batiment;

@Entity
public class Base {

	// https://www.baeldung.com/jpa-one-to-one
	// Déclarations
    /** id de la base **/
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @OneToOne(mappedBy = "base")
    private Joueur joueur;
    
    @Column
    @ElementCollection(targetClass=Batiment.class)
    private List<Batiment> batiment;

	/**
	 * @param id
	 * @param joueur
	 * @param idBatiments
	 */
	public Base(Joueur joueur, List<Batiment> batiment) {
		super();
		this.joueur = joueur;
		this.batiment = batiment;
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
	 * @return the idBatiments
	 */
	public List<Batiment> getBatiments() {
		return batiment;
	}

	/**
	 * @param idBatiments the idBatiments to set
	 */
	public void setIdBatiments(List<Batiment> batiment) {
		this.batiment = batiment;
	}

	@Override
	public String toString() {
		return "Informations base du joueur : [id=" + id + ", joueur=" + joueur + ", batiment=" + batiment + "]";
	}

    
    
    
}
