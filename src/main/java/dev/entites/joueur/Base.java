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
    @ElementCollection(targetClass=Integer.class)
    private List<Integer> idBatiments;

	/**
	 * @param id
	 * @param joueur
	 * @param idBatiments
	 */
	public Base(Joueur joueur, List<Integer> idBatiments) {
		super();
		this.joueur = joueur;
		this.idBatiments = idBatiments;
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
	public List<Integer> getIdBatiments() {
		return idBatiments;
	}

	/**
	 * @param idBatiments the idBatiments to set
	 */
	public void setIdBatiments(List<Integer> idBatiments) {
		this.idBatiments = idBatiments;
	}


    
	
	
    

    
    
}
