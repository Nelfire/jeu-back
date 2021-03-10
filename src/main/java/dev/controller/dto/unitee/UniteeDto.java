package dev.controller.dto.unitee;

import dev.entites.unitee.Unitee;

public class UniteeDto {
	private Integer id;

	/**
	 * id unitee : 1 - Villageois 2 - Fantassin Hache 3 - Fantassin Epée 4 -
	 * Légionnaire 5 - Archer 6 - Archer composite 7 - Archer élite 8 - Cavalier 9 -
	 * Cavalier Expert 10 - Paladin 11 - Navire de pêche 12 - Navire éclaireur 13 -
	 * Navire de guerre 14 - Catapulte 15 - Baliste 16 - Eléphan de Guerre 17 - Mûle
	 * de commerce 18 - Prêtre
	 **/
	private Integer idTypeUnitee;

	/**
	 * id batiment provenance : 12 = Ecurie,
	 **/
	private Integer idBatimentProvenance;

	/** icone de l'unité **/
	private String icone;

	/** nom de l'unité **/
	private String libelle;

	/** descriptif de l'unité **/
	private String descriptif;

	/** coût en pierre de l'unité **/
	private Integer coutPierreFormation;

	/** coût en bois de l'unité **/
	private Integer coutBoisFormation;

	/** coût en or de l'unité **/
	private Integer coutOrFormation;

	/** coût en nourriture de l'unité **/
	private Integer coutNourritureFormation;

	/** coût humain de l'unité **/
	private Integer coutHumain;

	/** temps en seconde necessaire à la Formation de l'unité **/
	private Integer tempsFormation;

	/** points de vie de l'unité **/
	private Integer vie;

	/** points d'attaque de l'unité **/
	private Integer attaque;

	/** portée de l'unité **/
	private Integer portee;

	/** points d'armure de l'unité **/
	private Integer armure;

	/** points de vitesse de l'unité **/
	private Integer vitesse;

	/** niveau necessaire du bâtiment pour débloquer la formation **/
	private Integer niveauBatimentNecessaireFormation;

	/** apport de pierre par heure de l'unité **/
	private Integer apportRessourcePierreHeure;
	/** apport de bois par heure de l'unité **/
	private Integer apportRessourceBoisHeure;
	/** apport de or par heure de l'unité **/
	private Integer apportRessourceOrHeure;
	/** apport de nourriture par heure de l'unité **/
	private Integer apportRessourceNourritureHeure;
	/** gain d'expérience formation de l'unité **/
	private Integer apportExperience;

	/**
	 * CONSTRUCTEUR VIDE
	 */
	public UniteeDto() {
	}

	/**
	 * CONSTRUCTEUR AVEC PARAMETRES
	 * 
	 * @param unitee
	 */
	public UniteeDto(Unitee unitee) {
		super();
		this.id = unitee.getId();
		this.idTypeUnitee = unitee.getIdTypeUnitee();
		this.idBatimentProvenance = unitee.getIdBatimentProvenance();
		this.icone = unitee.getIcone();
		this.libelle = unitee.getLibelle();
		this.descriptif = unitee.getDescriptif();
		this.coutPierreFormation = unitee.getCoutPierreFormation();
		this.coutBoisFormation = unitee.getCoutBoisFormation();
		this.coutOrFormation = unitee.getCoutOrFormation();
		this.coutNourritureFormation = unitee.getCoutNourritureFormation();
		this.coutHumain = unitee.getCoutHumain();
		this.tempsFormation = unitee.getTempsFormation();
		this.vie = unitee.getVie();
		this.attaque = unitee.getAttaque();
		this.portee = unitee.getPortee();
		this.armure = unitee.getArmure();
		this.vitesse = unitee.getVitesse();
		this.niveauBatimentNecessaireFormation = unitee.getNiveauBatimentNecessaireFormation();
		this.apportRessourcePierreHeure = unitee.getApportRessourcePierreHeure();
		this.apportRessourceBoisHeure = unitee.getApportRessourceBoisHeure();
		this.apportRessourceOrHeure = unitee.getApportRessourceOrHeure();
		this.apportRessourceNourritureHeure = unitee.getApportRessourceNourritureHeure();
		this.apportExperience = unitee.getApportExperience();
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
	 * @return the idTypeUnitee
	 */
	public Integer getIdTypeUnitee() {
		return idTypeUnitee;
	}

	/**
	 * @param idTypeUnitee the idTypeUnitee to set
	 */
	public void setIdTypeUnitee(Integer idTypeUnitee) {
		this.idTypeUnitee = idTypeUnitee;
	}

	/**
	 * @return the idBatimentProvenance
	 */
	public Integer getIdBatimentProvenance() {
		return idBatimentProvenance;
	}

	/**
	 * @param idBatimentProvenance the idBatimentProvenance to set
	 */
	public void setIdBatimentProvenance(Integer idBatimentProvenance) {
		this.idBatimentProvenance = idBatimentProvenance;
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
	 * @return the coutPierreFormation
	 */
	public Integer getCoutPierreFormation() {
		return coutPierreFormation;
	}

	/**
	 * @param coutPierreFormation the coutPierreFormation to set
	 */
	public void setCoutPierreFormation(Integer coutPierreFormation) {
		this.coutPierreFormation = coutPierreFormation;
	}

	/**
	 * @return the coutBoisFormation
	 */
	public Integer getCoutBoisFormation() {
		return coutBoisFormation;
	}

	/**
	 * @param coutBoisFormation the coutBoisFormation to set
	 */
	public void setCoutBoisFormation(Integer coutBoisFormation) {
		this.coutBoisFormation = coutBoisFormation;
	}

	/**
	 * @return the coutOrFormation
	 */
	public Integer getCoutOrFormation() {
		return coutOrFormation;
	}

	/**
	 * @param coutOrFormation the coutOrFormation to set
	 */
	public void setCoutOrFormation(Integer coutOrFormation) {
		this.coutOrFormation = coutOrFormation;
	}

	/**
	 * @return the coutNourritureFormation
	 */
	public Integer getCoutNourritureFormation() {
		return coutNourritureFormation;
	}

	/**
	 * @param coutNourritureFormation the coutNourritureFormation to set
	 */
	public void setCoutNourritureFormation(Integer coutNourritureFormation) {
		this.coutNourritureFormation = coutNourritureFormation;
	}

	/**
	 * @return the coutHumain
	 */
	public Integer getCoutHumain() {
		return coutHumain;
	}

	/**
	 * @param coutHumain the coutHumain to set
	 */
	public void setCoutHumain(Integer coutHumain) {
		this.coutHumain = coutHumain;
	}

	/**
	 * @return the tempsFormation
	 */
	public Integer getTempsFormation() {
		return tempsFormation;
	}

	/**
	 * @param tempsFormation the tempsFormation to set
	 */
	public void setTempsFormation(Integer tempsFormation) {
		this.tempsFormation = tempsFormation;
	}

	/**
	 * @return the vie
	 */
	public Integer getVie() {
		return vie;
	}

	/**
	 * @param vie the vie to set
	 */
	public void setVie(Integer vie) {
		this.vie = vie;
	}

	/**
	 * @return the attaque
	 */
	public Integer getAttaque() {
		return attaque;
	}

	/**
	 * @param attaque the attaque to set
	 */
	public void setAttaque(Integer attaque) {
		this.attaque = attaque;
	}

	/**
	 * @return the portee
	 */
	public Integer getPortee() {
		return portee;
	}

	/**
	 * @param portee the portee to set
	 */
	public void setPortee(Integer portee) {
		this.portee = portee;
	}

	/**
	 * @return the armure
	 */
	public Integer getArmure() {
		return armure;
	}

	/**
	 * @param armure the armure to set
	 */
	public void setArmure(Integer armure) {
		this.armure = armure;
	}

	/**
	 * @return the vitesse
	 */
	public Integer getVitesse() {
		return vitesse;
	}

	/**
	 * @param vitesse the vitesse to set
	 */
	public void setVitesse(Integer vitesse) {
		this.vitesse = vitesse;
	}

	/**
	 * @return the niveauBatimentNecessaireFormation
	 */
	public Integer getNiveauBatimentNecessaireFormation() {
		return niveauBatimentNecessaireFormation;
	}

	/**
	 * @param niveauBatimentNecessaireFormation the
	 *                                          niveauBatimentNecessaireFormation to
	 *                                          set
	 */
	public void setNiveauBatimentNecessaireFormation(Integer niveauBatimentNecessaireFormation) {
		this.niveauBatimentNecessaireFormation = niveauBatimentNecessaireFormation;
	}

	/**
	 * @return the apportRessourcePierreHeure
	 */
	public Integer getApportRessourcePierreHeure() {
		return apportRessourcePierreHeure;
	}

	/**
	 * @param apportRessourcePierreHeure the apportRessourcePierreHeure to set
	 */
	public void setApportRessourcePierreHeure(Integer apportRessourcePierreHeure) {
		this.apportRessourcePierreHeure = apportRessourcePierreHeure;
	}

	/**
	 * @return the apportRessourceBoisHeure
	 */
	public Integer getApportRessourceBoisHeure() {
		return apportRessourceBoisHeure;
	}

	/**
	 * @param apportRessourceBoisHeure the apportRessourceBoisHeure to set
	 */
	public void setApportRessourceBoisHeure(Integer apportRessourceBoisHeure) {
		this.apportRessourceBoisHeure = apportRessourceBoisHeure;
	}

	/**
	 * @return the apportRessourceOrHeure
	 */
	public Integer getApportRessourceOrHeure() {
		return apportRessourceOrHeure;
	}

	/**
	 * @param apportRessourceOrHeure the apportRessourceOrHeure to set
	 */
	public void setApportRessourceOrHeure(Integer apportRessourceOrHeure) {
		this.apportRessourceOrHeure = apportRessourceOrHeure;
	}

	/**
	 * @return the apportRessourceNourritureHeure
	 */
	public Integer getApportRessourceNourritureHeure() {
		return apportRessourceNourritureHeure;
	}

	/**
	 * @param apportRessourceNourritureHeure the apportRessourceNourritureHeure to
	 *                                       set
	 */
	public void setApportRessourceNourritureHeure(Integer apportRessourceNourritureHeure) {
		this.apportRessourceNourritureHeure = apportRessourceNourritureHeure;
	}

	/**
	 * @return the apportExperience
	 */
	public Integer getApportExperience() {
		return apportExperience;
	}

	/**
	 * @param apportExperience the apportExperience to set
	 */
	public void setApportExperience(Integer apportExperience) {
		this.apportExperience = apportExperience;
	}

	@Override
	public String toString() {
		return "UniteeDto [id=" + id + ", idTypeUnitee=" + idTypeUnitee + ", idBatimentProvenance="
				+ idBatimentProvenance + ", icone=" + icone + ", libelle=" + libelle + ", descriptif=" + descriptif
				+ ", coutPierreFormation=" + coutPierreFormation + ", coutBoisFormation=" + coutBoisFormation
				+ ", coutOrFormation=" + coutOrFormation + ", coutNourritureFormation=" + coutNourritureFormation
				+ ", coutHumain=" + coutHumain + ", tempsFormation=" + tempsFormation + ", vie=" + vie + ", attaque="
				+ attaque + ", portee=" + portee + ", armure=" + armure + ", niveauBatimentNecessaireFormation="
				+ niveauBatimentNecessaireFormation + ", apportRessourcePierreHeure=" + apportRessourcePierreHeure
				+ ", apportRessourceBoisHeure=" + apportRessourceBoisHeure + ", apportRessourceOrHeure="
				+ apportRessourceOrHeure + ", apportRessourceNourritureHeure=" + apportRessourceNourritureHeure + "]";
	}

}
