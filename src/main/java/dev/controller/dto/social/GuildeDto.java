package dev.controller.dto.social;

import dev.entites.joueur.Joueur;

public class GuildeDto {

	private Integer id;

	/** libellé de la guilde **/
	private String libelle;

	/** icone de la guilde **/
	private String icone;

	/** message accueil guilde **/
	private String messageAccueil;

	/** chef de la guilde **/
	private Joueur chefGuilde;

	/** niveau de la guilde **/
	private Integer niveau;

	/** experience de la guilde **/
	private Integer experience;

	/** nombre maximal de membres de la guilde **/
	private Integer nombreMembresMaximal;

	/** coût de création de la guilde **/
	private final Integer coutOrCreation = 100;

	/**
	 * CONSTRUCTEUR VIDE
	 */
	public GuildeDto() {

	}

	/**
	 * CONSTRUCTEUR AVEC PARAMETRES
	 * 
	 * @param id
	 * @param libelle
	 * @param icone
	 * @param messageAccueil
	 * @param chefGuilde
	 * @param niveau
	 * @param experience
	 * @param nombreMembresMaximal
	 */
	public GuildeDto(Integer id, String libelle, String icone, String messageAccueil, Joueur chefGuilde, Integer niveau,
			Integer experience, Integer nombreMembresMaximal) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.icone = icone;
		this.messageAccueil = messageAccueil;
		this.chefGuilde = chefGuilde;
		this.niveau = niveau;
		this.experience = experience;
		this.nombreMembresMaximal = nombreMembresMaximal;
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

//	/**
//	 * @return the listeMembres
//	 */
//	public List<Joueur> getListeMembres() {
//		return listeMembres;
//	}
//
//	/**
//	 * @param listeMembres the listeMembres to set
//	 */
//	public void setListeMembres(List<Joueur> listeMembres) {
//		this.listeMembres = listeMembres;
//	}

	/**
	 * @return the niveau
	 */
	public Integer getNiveau() {
		return niveau;
	}

	/**
	 * @param niveau the niveau to set
	 */
	public void setNiveau(Integer niveau) {
		this.niveau = niveau;
	}

	/**
	 * @return the experience
	 */
	public Integer getExperience() {
		return experience;
	}

	/**
	 * @param experience the experience to set
	 */
	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	/**
	 * @return the nombreMembresMaximal
	 */
	public Integer getNombreMembresMaximal() {
		return nombreMembresMaximal;
	}

	/**
	 * @param nombreMembresMaximal the nombreMembresMaximal to set
	 */
	public void setNombreMembresMaximal(Integer nombreMembresMaximal) {
		this.nombreMembresMaximal = nombreMembresMaximal;
	}

	/**
	 * @return the coutOrCreation
	 */
	public Integer getCoutOrCreation() {
		return coutOrCreation;
	}

}
