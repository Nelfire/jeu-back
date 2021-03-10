package dev.controller.dto.joueur;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import dev.entites.joueur.Joueur;
import dev.entites.joueur.Role;

public class JoueurDto {

	// Déclarations
	/** id du joueur **/
	private Integer id;

	/** icone du joueur **/
	private String icone;

	/** pseudo du joueur **/
	private String pseudo;

	/** email du joueur **/
	private String email;

	/** mot de passe du joueur **/
	private String motDePasse;

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

	/** roles du joueur **/
	private List<Role> roles = new ArrayList<>();

	/** position abscisse du joueur **/
	private Integer positionX;

	/** position ordonnée du joueur **/
	private Integer positionY;

	/**
	 * CONSTRUCTEUR VIDE
	 */
	public JoueurDto() {

	}

	/**
	 * CONSTRUCTEUR AVEC PARAMETRES
	 */
	public JoueurDto(Joueur jou) {
		super();
		this.id = jou.getId();
		this.icone = jou.getIcone();
		this.pseudo = jou.getPseudo();
		this.email = jou.getEmail();
		this.motDePasse = jou.getMotDePasse();
		this.descriptif = jou.getDescriptif();
		this.niveau = jou.getNiveau();
		this.experience = jou.getExperience();
		this.pierrePossession = jou.getPierrePossession();
		this.boisPossession = jou.getBoisPossession();
		this.orPossession = jou.getOrPossession();
		this.nourriturePossession = jou.getNourriturePossession();
		this.gemmePossession = jou.getGemmePossession();
		this.pierreMaximum = jou.getPierreMaximum();
		this.boisMaximum = jou.getBoisMaximum();
		this.orMaximum = jou.getOrMaximum();
		this.nourritureMaximum = jou.getNourritureMaximum();
		this.pierreBoostProduction = jou.getPierreBoostProduction();
		this.boisBoostProduction = jou.getBoisBoostProduction();
		this.orBoostProduction = jou.getOrBoostProduction();
		this.nourritureBoostProduction = jou.getNourritureBoostProduction();
		this.tempsDeJeu = jou.getTempsDeJeu();
		this.roles = jou.getRoles().stream().map(roleJoueur -> roleJoueur.getRole()).collect(Collectors.toList());
		this.derniereConnexion = jou.getDerniereConnexion();
		this.donateur = jou.getDonateur();
		this.positionX = jou.getPositionX();
		this.positionY = jou.getPositionY();
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
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}

	/**
	 * @param motDePasse the motDePasse to set
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
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
	 * @param pierreBoostProduction the pierreBoostProduction to set
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
	 * @return the roles
	 */
	public List<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<Role> roles) {
		this.roles = roles;
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

}
