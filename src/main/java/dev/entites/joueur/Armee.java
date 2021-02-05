package dev.entites.joueur;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
    /** Une armées ne concerne qu'une expeditionjoueur **/
	@ManyToOne
	@JoinColumn(name = "expeditionJoueur_id")
    private ExpeditionJoueur expeditionJoueur;
    
	@ManyToOne
	@JoinColumn(name = "unitee_id")
    private Unitee unitee;
    
    private Integer quantitee;
    
    private Long dateDebutProduction;
    private Long dateFinProduction;

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
	public Armee(Joueur joueur, Unitee unitee, Integer quantitee, Long dateDebutProduction, Long dateFinProduction) {
		super();
		this.joueur = joueur;
		this.unitee = unitee;
		this.quantitee = quantitee;
		this.dateDebutProduction = dateDebutProduction;
		this.dateFinProduction = dateFinProduction;
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
	
	

	/**
	 * @return the dateDebutProduction
	 */
	public Long getDateDebutProduction() {
		return dateDebutProduction;
	}

	/**
	 * @param dateDebutProduction the dateDebutProduction to set
	 */
	public void setDateDebutProduction(Long dateDebutProduction) {
		this.dateDebutProduction = dateDebutProduction;
	}

	/**
	 * @return the dateFinProduction
	 */
	public Long getDateFinProduction() {
		return dateFinProduction;
	}

	/**
	 * @param dateFinProduction the dateFinProduction to set
	 */
	public void setDateFinProduction(Long dateFinProduction) {
		this.dateFinProduction = dateFinProduction;
	}

	@Override
	public String toString() {
		return "Armee [id=" + id + ", joueur=" + joueur + ", expeditionJoueur=" + expeditionJoueur + ", unitee="
				+ unitee + ", quantitee=" + quantitee + ", dateDebutProduction=" + dateDebutProduction
				+ ", dateFinProduction=" + dateFinProduction + "]";
	}

	
	
	
	
}

