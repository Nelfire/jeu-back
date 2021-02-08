package dev.entites.joueur;

import javax.persistence.CascadeType;
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
	
	//@ManyToOne(cascade = CascadeType.PERSIST)
	@ManyToOne
	@JoinColumn(name = "defense_id")
    private Defense defense;
	
	private Integer quantite;
	
    private Long dateDebutConstruction;
    private Long dateFinConstruction;
    
    public DefenseJoueur() {
    	super();
    }
	/**
	 * @param joueur
	 * @param defense
	 * @param dateDebutConstruction
	 * @param dateFinConstruction
	 */
	public DefenseJoueur(Joueur joueur, Defense defense, Integer quantite, Long dateDebutConstruction, Long dateFinConstruction) {
		super();
		this.joueur = joueur;
		this.defense = defense;
		this.quantite = quantite;
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
	 * @return the quantite
	 */
	public Integer getQuantite() {
		return quantite;
	}
	/**
	 * @param quantite the quantite to set
	 */
	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
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
	@Override
	public String toString() {
		return "DefenseJoueur [id=" + id + ", joueur=" + joueur + ", defense=" + defense + ", quantite=" + quantite
				+ ", dateDebutConstruction=" + dateDebutConstruction + ", dateFinConstruction=" + dateFinConstruction
				+ "]";
	}
	
	
    
    


}
