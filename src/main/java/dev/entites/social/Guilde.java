package dev.entites.social;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import dev.entites.Joueur;

@Entity
public class Guilde {

	/** id de la guilde **/
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    /** libellé de la guilde **/
    private String libelle;
    
    /** icone de la guilde **/
    private String icone;
    
    /** message accueil guilde **/
    private String messageAccueil;
    

    
    /** membres de la guilde **/
    /** "Une guilde peut avoir 1 seul chef**/
    @OneToOne(mappedBy = "guilde")
    private Joueur chefGuilde;
    
    /** membres de la guilde **/
    /** "Une guilde peut avoir plusieurs membres **/
    @OneToMany(mappedBy = "guilde", cascade = CascadeType.PERSIST)
    private List<Joueur> listeMembres;
    
    
    /**
	 * @param libelle
	 * @param icone
	 * @param messageAccueil
	 */
	public Guilde(String libelle, String icone, String messageAccueil) {
		super();
		this.libelle = libelle;
		this.icone = icone;
		this.messageAccueil = messageAccueil;
	}

	/** quitter la guilde **/
    public void quitterGuilde() {
    	
    }

    /** inviter dans la guilde **/
    public void inviterGuilde() {
    	
    }
    
    /** dissoudre la guilde **/
    public void dissoudreGuilde() {
    	
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
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return the icone
	 */
	public String getIcone() {
		return icone;
	}

	/**
	 * @param icone the icone to set
	 */
	public void setIcone(String icone) {
		this.icone = icone;
	}

	/**
	 * @return the messageAccueil
	 */
	public String getMessageAccueil() {
		return messageAccueil;
	}

	/**
	 * @param messageAccueil the messageAccueil to set
	 */
	public void setMessageAccueil(String messageAccueil) {
		this.messageAccueil = messageAccueil;
	}

	/**
	 * @return the chefGuilde
	 */
	public Joueur getChefGuilde() {
		return chefGuilde;
	}

	/**
	 * @param chefGuilde the chefGuilde to set
	 */
	public void setChefGuilde(Joueur chefGuilde) {
		this.chefGuilde = chefGuilde;
	}

	/**
	 * @return the listeMembres
	 */
	public List<Joueur> getListeMembres() {
		return listeMembres;
	}

	/**
	 * @param listeMembres the listeMembres to set
	 */
	public void setListeMembres(List<Joueur> listeMembres) {
		this.listeMembres = listeMembres;
	}
    
    
}
