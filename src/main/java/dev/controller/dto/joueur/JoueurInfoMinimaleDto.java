package dev.controller.dto.joueur;

/**
 * REMONTEE D'UN MINIMUM D'INFORMATIONS CONCERNANT LE JOUEUR
 */
public class JoueurInfoMinimaleDto {

	/** id du joueur **/
	private Integer id;

	/** icone du joueur **/
	private String icone;

	/** pseudo du joueur **/
	private String pseudo;

	/** descriptif fiche perso du joueur **/
	private String descriptif;

	/** niveau du joueur **/
	private Integer niveau;

	/** experience du joueur **/
	private Long experience;

	/** temps de connexion (en secondes) du joueur **/
	private Integer tempsDeJeu;

	/** le joueur est un donateur (O/N) **/
	private Boolean donateur;

	/** position abscisse du joueur **/
	private Integer positionX;

	/** position ordonnée du joueur **/
	private Integer positionY;

	/**
	 * CONSTRUCTEUR VIDE
	 */
	public JoueurInfoMinimaleDto() {
		
	}
	/**
	 * @param id
	 * @param icone
	 * @param pseudo
	 * @param descriptif
	 * @param niveau
	 * @param experience
	 * @param tempsDeJeu
	 * @param donateur
	 * @param positionX
	 * @param positionY
	 */
	public JoueurInfoMinimaleDto(Integer id, String icone, String pseudo, String descriptif, Integer niveau,
			Long experience, Integer tempsDeJeu, Boolean donateur, Integer positionX, Integer positionY) {
		super();
		this.id = id;
		this.icone = icone;
		this.pseudo = pseudo;
		this.descriptif = descriptif;
		this.niveau = niveau;
		this.experience = experience;
		this.tempsDeJeu = tempsDeJeu;
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
