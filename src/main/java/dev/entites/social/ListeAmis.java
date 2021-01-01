package dev.entites.social;
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
public class ListeAmis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    /** "Une liste d'amis ne peut appartenir qu'a une seule personne**/
    @OneToOne(mappedBy = "listeAmis")
    private Joueur proprietaireListe;
    
    @Column
    @ElementCollection(targetClass=Joueur.class)
    private List<Joueur> listeDAmis;

	/**
	 * @param proprietaireListe
	 * @param listeAmis
	 */
	public ListeAmis(Joueur proprietaireListe, List<Joueur> listeAmis) {
		super();
		this.proprietaireListe = proprietaireListe;
		this.listeDAmis = listeAmis;
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
	 * @return the proprietaireListe
	 */
	public Joueur getProprietaireListe() {
		return proprietaireListe;
	}

	/**
	 * @param proprietaireListe the proprietaireListe to set
	 */
	public void setProprietaireListe(Joueur proprietaireListe) {
		this.proprietaireListe = proprietaireListe;
	}

	/**
	 * @return the listeAmis
	 */
	public List<Joueur> getListeAmis() {
		return listeDAmis;
	}

	/**
	 * @param listeAmis the listeAmis to set
	 */
	public void setListeAmis(List<Joueur> listeDAmis) {
		this.listeDAmis = listeDAmis;
	}
    
    
    
}
