package dev.entites.joueur;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import dev.entites.Joueur;
import dev.entites.batiment.Batiment;
import dev.entites.batiment.Defense;

@Entity
public class DefenseJoueur {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "joueur_id")
    private Joueur joueur;
	
	@ManyToOne
	@JoinColumn(name = "defense_id")
    private Defense defense;
	
	private Integer quantitee;
	
    private Long dateDebutConstruction;
    private Long dateFinConstruction;
    
    public DefenseJoueur() {
    	
    }
	/**
	 * @param joueur
	 * @param defense
	 * @param dateDebutConstruction
	 * @param dateFinConstruction
	 */
	public DefenseJoueur(Joueur joueur, Defense defense, Integer quantitee, Long dateDebutConstruction, Long dateFinConstruction) {
		super();
		this.joueur = joueur;
		this.defense = defense;
		this.quantitee = quantitee;
		this.dateDebutConstruction = dateDebutConstruction;
		this.dateFinConstruction = dateFinConstruction;
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
	 * @return the defense
	 */
	public Defense getDefense() {
		return defense;
	}
	/**
	 * @param defense the defense to set
	 */
	public void setDefense(Defense defense) {
		this.defense = defense;
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
	 * @return the dateDebutConstruction
	 */
	public Long getDateDebutConstruction() {
		return dateDebutConstruction;
	}
	/**
	 * @param dateDebutConstruction the dateDebutConstruction to set
	 */
	public void setDateDebutConstruction(Long dateDebutConstruction) {
		this.dateDebutConstruction = dateDebutConstruction;
	}
	/**
	 * @return the dateFinConstruction
	 */
	public Long getDateFinConstruction() {
		return dateFinConstruction;
	}
	/**
	 * @param dateFinConstruction the dateFinConstruction to set
	 */
	public void setDateFinConstruction(Long dateFinConstruction) {
		this.dateFinConstruction = dateFinConstruction;
	}
	
	
    
    


}
