package dev.controller.dto.joueur;

import java.util.Date;

import dev.entites.joueur.Armee;
import dev.entites.social.Guilde;

public class JoueurInfoDto {

	/** id du joueur **/
	private Integer id;

	private Armee armee;

	/** Tous les joueurs peuvent appartenir à une guilde **/
	private Guilde guilde;

	/** icone du joueur **/
	private String icone;

	/** pseudo du joueur **/
	private String pseudo;

	/** email du joueur **/
	private String email;

	/** descriptif fiche perso du joueur **/
	private String descriptif;

	/** niveau du joueur **/
	private Integer niveau;

	/** experience du joueur **/
	private Long experience;

	/** ressources de pierre que possède le joueur **/
	private Long pierrePossession;

	/** ressources de bois que possède le joueur **/
	private Long boisPossession;

	/** ressources d'or que possède le joueur **/
	private Long orPossession;

	/** ressources de nourriture que possède le joueur **/
	private Long nourriturePossession;

	/** ressources de gemme que possède le joueur **/
	private Long gemmePossession;

	/** montant maximum de pierre que peut posséder le joueur **/
	private Long pierreMaximum;

	/** montant maximum de bois que peut posséder le joueur **/
	private Long boisMaximum;

	/** montant maximum d'or que peut posséder le joueur **/
	private Long orMaximum;

	/** montant maximum de nourriture que peut posséder le joueur **/
	private Long nourritureMaximum;

	/** montant du boost de production de pierre pour le joueur **/
	private Integer pierreBoostProduction;

	/** montant du boost de production de bois pour le joueur **/
	private Integer boisBoostProduction;

	/** montant du boost de production d'or pour le joueur **/
	private Integer orBoostProduction;

	/** montant du boost de production de nourriture pour le joueur **/
	private Integer nourritureBoostProduction;

	/** temps de connexion (en secondes) du joueur **/
	private Integer tempsDeJeu;

	/** date de la derniere connexion du joueur **/
	private Date derniereConnexion;

	/** le joueur est un donateur (O/N) **/
	private Boolean donateur;

	/** position abscisse du joueur **/
	private Integer positionX;

	/** position ordonnée du joueur **/
	private Integer positionY;

	/**
	 * CONSTRUCTEUR VIDE
	 */
	public JoueurInfoDto() {

	}

	/**
	 * CONSTRUCTEUR AVEC PARAMETRES
	 * 
	 * @param id
	 * @param base
	 * @param armee
	 * @param guilde
	 * @param chefGuilde
	 * @param messagesGuilde
	 * @param listeAmis
	 * @param icone
	 * @param pseudo
	 * @param email
	 * @param motDePasse
	 * @param descriptif
	 * @param niveau
	 * @param experience
	 * @param pierrePossession
	 * @param boisPossession
	 * @param orPossession
	 * @param nourriturePossession
	 * @param gemmePossession
	 * @param pierreMaximum
	 * @param boisMaximum
	 * @param orMaximum
	 * @param nourritureMaximum
	 * @param pierreBoostProduction
	 * @param boisBoostProduction
	 * @param orBoostProduction
	 * @param nourritureBoostProduction
	 * @param tempsDeJeu
	 */
	public JoueurInfoDto(Integer id, String icone, String pseudo, String email, String descriptif, Integer niveau,
			Long experience, Long pierrePossession, Long boisPossession, Long orPossession, Long nourriturePossession,
			Long gemmePossession, Long pierreMaximum, Long boisMaximum, Long orMaximum, Long nourritureMaximum,
			Integer pierreBoostProduction, Integer boisBoostProduction, Integer orBoostProduction,
			Integer nourritureBoostProduction, Integer tempsDeJeu, Date derniereConnexion, Boolean donateur,
			Integer positionX, Integer positionY) {
		super();
		this.id = id;
		this.icone = icone;
		this.pseudo = pseudo;
		this.email = email;
		this.descriptif = descriptif;
		this.niveau = niveau;
		this.experience = experience;
		this.pierrePossession = pierrePossession;
		this.boisPossession = boisPossession;
		this.orPossession = orPossession;
		this.nourriturePossession = nourriturePossession;
		this.gemmePossession = gemmePossession;
		this.pierreMaximum = pierreMaximum;
		this.boisMaximum = boisMaximum;
		this.orMaximum = orMaximum;
		this.nourritureMaximum = nourritureMaximum;
		this.pierreBoostProduction = pierreBoostProduction;
		this.boisBoostProduction = boisBoostProduction;
		this.orBoostProduction = orBoostProduction;
		this.nourritureBoostProduction = nourritureBoostProduction;
		this.tempsDeJeu = tempsDeJeu;
		this.derniereConnexion = derniereConnexion;
		this.donateur = donateur;
		this.positionX = positionX;
		this.positionY = positionY;
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
	 * @return the armee
	 */
	public Armee getArmee() {
		return armee;
	}

	/**
	 * @param armee the armee to set
	 */
	public void setArmee(Armee armee) {
		this.armee = armee;
	}

	/**
	 * @return the guilde
	 */
	public Guilde getGuilde() {
		return guilde;
	}

	/**
	 * @param guilde the guilde to set
	 */
	public void setGuilde(Guilde guilde) {
		this.guilde = guilde;
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
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}

	/**
	 * @param pseudo the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the descriptif
	 */
	public String getDescriptif() {
		return descriptif;
	}

	/**
	 * @param descriptif the descriptif to set
	 */
	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}

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
	public Long getExperience() {
		return experience;
	}

	/**
	 * @param experience the experience to set
	 */
	public void setExperience(Long experience) {
		this.experience = experience;
	}

	/**
	 * @return the pierrePossession
	 */
	public Long getPierrePossession() {
		return pierrePossession;
	}

	/**
	 * @param pierrePossession the pierrePossession to set
	 */
	public void setPierrePossession(Long pierrePossession) {
		this.pierrePossession = pierrePossession;
	}

	/**
	 * @return the boisPossession
	 */
	public Long getBoisPossession() {
		return boisPossession;
	}

	/**
	 * @param boisPossession the boisPossession to set
	 */
	public void setBoisPossession(Long boisPossession) {
		this.boisPossession = boisPossession;
	}

	/**
	 * @return the orPossession
	 */
	public Long getOrPossession() {
		return orPossession;
	}

	/**
	 * @param orPossession the orPossession to set
	 */
	public void setOrPossession(Long orPossession) {
		this.orPossession = orPossession;
	}

	/**
	 * @return the nourriturePossession
	 */
	public Long getNourriturePossession() {
		return nourriturePossession;
	}

	/**
	 * @param nourriturePossession the nourriturePossession to set
	 */
	public void setNourriturePossession(Long nourriturePossession) {
		this.nourriturePossession = nourriturePossession;
	}

	/**
	 * @return the gemmePossession
	 */
	public Long getGemmePossession() {
		return gemmePossession;
	}

	/**
	 * @param gemmePossession the gemmePossession to set
	 */
	public void setGemmePossession(Long gemmePossession) {
		this.gemmePossession = gemmePossession;
	}

	/**
	 * @return the pierreMaximum
	 */
	public Long getPierreMaximum() {
		return pierreMaximum;
	}

	/**
	 * @param pierreMaximum the pierreMaximum to set
	 */
	public void setPierreMaximum(Long pierreMaximum) {
		this.pierreMaximum = pierreMaximum;
	}

	/**
	 * @return the boisMaximum
	 */
	public Long getBoisMaximum() {
		return boisMaximum;
	}

	/**
	 * @param boisMaximum the boisMaximum to set
	 */
	public void setBoisMaximum(Long boisMaximum) {
		this.boisMaximum = boisMaximum;
	}

	/**
	 * @return the orMaximum
	 */
	public Long getOrMaximum() {
		return orMaximum;
	}

	/**
	 * @param orMaximum the orMaximum to set
	 */
	public void setOrMaximum(Long orMaximum) {
		this.orMaximum = orMaximum;
	}

	/**
	 * @return the nourritureMaximum
	 */
	public Long getNourritureMaximum() {
		return nourritureMaximum;
	}

	/**
	 * @param nourritureMaximum the nourritureMaximum to set
	 */
	public void setNourritureMaximum(Long nourritureMaximum) {
		this.nourritureMaximum = nourritureMaximum;
	}

	/**
	 * @return the pierreBoostProduction
	 */
	public Integer getPierreBoostProduction() {
		return pierreBoostProduction;
	}

	/**
	 * @param pierreBoostProduction thee pierreBoostProduction to set
	 */
	public void setPierreBoostProduction(Integer pierreBoostProduction) {
		this.pierreBoostProduction = pierreBoostProduction;
	}

	/**
	 * @return the boisBoostProduction
	 */
	public Integer getBoisBoostProduction() {
		return boisBoostProduction;
	}

	/**
	 * @param boisBoostProduction the boisBoostProduction to set
	 */
	public void setBoisBoostProduction(Integer boisBoostProduction) {
		this.boisBoostProduction = boisBoostProduction;
	}

	/**
	 * @return the orBoostProduction
	 */
	public Integer getOrBoostProduction() {
		return orBoostProduction;
	}

	/**
	 * @param orBoostProduction the orBoostProduction to set
	 */
	public void setOrBoostProduction(Integer orBoostProduction) {
		this.orBoostProduction = orBoostProduction;
	}

	/**
	 * @return the nourritureBoostProduction
	 */
	public Integer getNourritureBoostProduction() {
		return nourritureBoostProduction;
	}

	/**
	 * @param nourritureBoostProduction the nourritureBoostProduction to set
	 */
	public void setNourritureBoostProduction(Integer nourritureBoostProduction) {
		this.nourritureBoostProduction = nourritureBoostProduction;
	}

	/**
	 * @return the tempsDeJeu
	 */
	public Integer getTempsDeJeu() {
		return tempsDeJeu;
	}

	/**
	 * @param tempsDeJeu the tempsDeJeu to set
	 */
	public void setTempsDeJeu(Integer tempsDeJeu) {
		this.tempsDeJeu = tempsDeJeu;
	}

	/**
	 * @return the derniereConnexion
	 */
	public Date getDerniereConnexion() {
		return derniereConnexion;
	}

	/**
	 * @param derniereConnexion the derniereConnexion to set
	 */
	public void setDerniereConnexion(Date derniereConnexion) {
		this.derniereConnexion = derniereConnexion;
	}

	/**
	 * @return the donateur
	 */
	public Boolean getDonateur() {
		return donateur;
	}

	/**
	 * @param donateur the donateur to set
	 */
	public void setDonateur(Boolean donateur) {
		this.donateur = donateur;
	}

	/**
	 * @return the positionX
	 */
	public Integer getPositionX() {
		return positionX;
	}

	/**
	 * @param positionX the positionX to set
	 */
	public void setPositionX(Integer positionX) {
		this.positionX = positionX;
	}

	/**
	 * @return the positionY
	 */
	public Integer getPositionY() {
		return positionY;
	}

	/**
	 * @param positionY the positionY to set
	 */
	public void setPositionY(Integer positionY) {
		this.positionY = positionY;
	}

	@Override
	public String toString() {
		return "JoueurInfoDto [id=" + id + ", armee=" + armee + ", guilde=" + guilde + ", icone=" + icone + ", pseudo="
				+ pseudo + ", email=" + email + ", descriptif=" + descriptif + ", niveau=" + niveau + ", experience="
				+ experience + ", pierrePossession=" + pierrePossession + ", boisPossession=" + boisPossession
				+ ", orPossession=" + orPossession + ", nourriturePossession=" + nourriturePossession
				+ ", gemmePossession=" + gemmePossession + ", pierreMaximum=" + pierreMaximum + ", boisMaximum="
				+ boisMaximum + ", orMaximum=" + orMaximum + ", nourritureMaximum=" + nourritureMaximum
				+ ", pierreBoostProduction=" + pierreBoostProduction + ", boisBoostProduction=" + boisBoostProduction
				+ ", orBoostProduction=" + orBoostProduction + ", nourritureBoostProduction="
				+ nourritureBoostProduction + ", tempsDeJeu=" + tempsDeJeu + ", derniereConnexion=" + derniereConnexion
				+ ", donateur=" + donateur + ", positionX=" + positionX + ", positionY=" + positionY + "]";
	}

}
