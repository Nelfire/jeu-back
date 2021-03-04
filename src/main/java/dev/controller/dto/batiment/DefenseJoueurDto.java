package dev.controller.dto.batiment;

import dev.entites.batiment.Defense;
import dev.entites.joueur.Joueur;

public class DefenseJoueurDto {
	private Integer id;
	private Joueur joueur;
    private Defense defense;
	
	private Integer quantite;
	
    private Long dateDebutConstruction;
    private Long dateFinConstruction;
    
    public DefenseJoueurDto() {
    }

	/**
	 * @param id
	 * @param joueur
	 * @param defense
	 * @param quantite
	 * @param dateDebutConstruction
	 * @param dateFinConstruction
	 */
	public DefenseJoueurDto(Integer id, Joueur joueur, Defense defense, Integer quantite, Long dateDebutConstruction,
			Long dateFinConstruction) {
		super();
		this.id = id;
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
	
	
    
}
