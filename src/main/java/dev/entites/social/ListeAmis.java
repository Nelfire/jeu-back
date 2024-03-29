package dev.entites.social;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ListeAmis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	@ElementCollection(targetClass = Integer.class)
	private List<Integer> listeDAmis;

	/** propriétaire de la liste d'amis **/
	private Integer proprietaireListe;

	/**
	 * CONSTRUCTEUR VIDE
	 */
	public ListeAmis() {
	}

	/**
	 * CONSTRUCTEUR AVEC PARAMETRES
	 * 
	 * @param proprietaireListe
	 * @param listeAmis
	 */
	public ListeAmis(Integer proprietaireListe, List<Integer> listeAmis) {
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
	public Integer getProprietaireListe() {
		return proprietaireListe;
	}

	/**
	 * @param proprietaireListe the proprietaireListe to set
	 */
	public void setProprietaireListe(Integer proprietaireListe) {
		this.proprietaireListe = proprietaireListe;
	}

	/**
	 * @return the listeDAmis
	 */
	public List<Integer> getListeDAmis() {
		return listeDAmis;
	}

	/**
	 * @param listeDAmis the listeDAmis to set
	 */
	public void setListeDAmis(List<Integer> listeDAmis) {
		this.listeDAmis = listeDAmis;
	}

	@Override
	public String toString() {
		return "ListeAmis [id=" + id + ", proprietaireListe=" + proprietaireListe + ", listeDAmis=" + listeDAmis + "]";
	}

}
