package dev.controller.dto.joueur;

import dev.entites.joueur.Joueur;
import dev.entites.unitee.Unitee;

public class ArmeeDto {
	private Integer id;

	/** joueur propriétaire **/
	private Joueur joueur;

	/** unité de l'armée **/
	private Unitee unitee;

	/** nombre d'unité de l'armée **/
	private Integer quantitee;

	/** date de début de production de l'armée **/
	private Long dateDebutProduction;

	/** date de fin de production de l'armée **/
	private Long dateFinProduction;

	/**
	 * CONSTRUCTEUR VIDE
	 */
	public ArmeeDto() {

	}

	/**
	 * CONSTRUCTEUR AVEC PARAMETRES
	 * 
	 * @param id
	 * @param joueur
	 * @param unitee
	 * @param quantitee
	 * @param dateDebutProduction
	 * @param dateFinProduction
	 */
	public ArmeeDto(Integer id, Joueur joueur, Unitee unitee, Integer quantitee, Long dateDebutProduction,
			Long dateFinProduction) {
		super();
		this.id = id;
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

}
