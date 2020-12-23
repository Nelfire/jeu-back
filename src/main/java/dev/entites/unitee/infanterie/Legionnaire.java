package dev.entites.unitee.infanterie;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Legionnaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    /** id unitee : 
     * 4 = Legionnaire
     *  **/
    private final Integer idUnitee = 4;
    
    /** id batiment provenance : 
     * 11 = Caserne millitaire,
     *  **/
    private final Integer idBatimentProvenance = 11;
    
    /** icone de l'unitée **/
    private final String icone = "https://marcdekeister.files.wordpress.com/2018/09/dessin-hocc82tel-de-ville-de-paris.jpg";
    
    /** nom de l'unitée **/
    private final String libelle = "Legionnaire";
    
    /** descriptif de l'unitée **/
    private final String descriptif = "Le descriptif du Legionnaire";
    
    /** niveau de l'unitée **/
    private Integer niveau;
    
    /** coût en pierre de l'unitée **/
    private final Integer coutPierreFormation = 0;
    
    /** coût en bois de l'unitée **/
    private final Integer coutBoisFormation = 10;
    
    /** coût en or de l'unitée **/
    private final Integer coutOrFormation = 25;
    
    /** coût en nourriture de l'unitée **/
    private final Integer coutNourritureFormation = 50;
    
    /** coût humain de l'unitée **/
    private final Integer coutHumain = 1;
    
    /** temps en seconde necessaire à la Formation de l'unitée**/
    private Integer tempsFormation = 65;

    /** points de vie de l'unitée **/
    private Integer vie = 120;

    /** points d'attaque de l'unitée **/
    private Integer attaque = 13;

    /** portée de l'unitée **/
    private Integer portee = 0;

    /** points d'armure de l'unitée **/
    private Integer armure = 2;
    
    /** niveau necessaire du bâtiment pour débloquer la formation **/
    private final Integer niveauBatimentNecessaireFormation = 3;

    
	/**
	 * Constructeur vide
	 */
	public Legionnaire() {
	
	}

	/**
	 * @param niveau
	 */
	public Legionnaire(Integer niveau) {
		super();
		this.niveau = niveau;
	}

	/**
	 * @return Retourne l'id de l'unitée
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param Défini l'id de l'unitée
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return Retourne l'id du type unitée (Legionnaire = 4)
	 */
	public Integer getIdUnitee() {
		return idUnitee;
	}
	
	/**
	 * @return Retourne le niveau de l'unitée
	 */
	public Integer getNiveau() {
		return niveau;
	}

	/**
	 * @return Défini le niveau de l'unitée
	 */
	public void setNiveau(Integer niveau) {
		this.niveau = niveau;
	}

	/**
	 * @return Retourne le temps de formation de l'unitée
	 */
	public Integer getTempsFormation() {
		return tempsFormation;
	}

	/**
	 * @param Défini le temps de formation de l'unitée
	 */
	public void setTempsFormation(Integer tempsFormation) {
		this.tempsFormation = tempsFormation;
	}

	/**
	 * @return Retourne le montant de points de vie de l'unitée
	 */
	public Integer getVie() {
		return vie;
	}

	/**
	 * @return Défini le montant de points de vie de l'unitée
	 */
	public void setVie(Integer vie) {
		this.vie = vie;
	}

	/**
	 * @return Retourne le montant de points d'attaque de l'unitée
	 */
	public Integer getAttaque() {
		return attaque;
	}

	/**
	 * @return Défini le montant de points d'attaque de l'unitée
	 */
	public void setAttaque(Integer attaque) {
		this.attaque = attaque;
	}

	/**
	 * @return Retourne la portée de l'unitée
	 */
	public Integer getPortee() {
		return portee;
	}

	/**
	 * @return Défini la portée de l'unitée
	 */
	public void setPortee(Integer portee) {
		this.portee = portee;
	}

	/**
	 * @return Retourne le montant de points d'armure de l'unitée
	 */
	public Integer getArmure() {
		return armure;
	}

	/**
	 * @return Défini le montant de points d'armure de l'unitée
	 */
	public void setArmure(Integer armure) {
		this.armure = armure;
	}

	/**
	 * @return Retourne l'id de provenance de l'unitée
	 */
	public Integer getIdBatimentProvenance() {
		return idBatimentProvenance;
	}

	/**
	 * @return Retourne l'icone de l'unitée
	 */
	public String getIcone() {
		return icone;
	}

	/**
	 * @return Retourne le libellé de l'unitée
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @return Retourne le descriptif de l'unitée
	 */
	public String getDescriptif() {
		return descriptif;
	}

	/**
	 * @return Retourne le coût en pierre de formation de l'unitée
	 */
	public Integer getCoutPierreFormation() {
		return coutPierreFormation;
	}

	/**
	 * @return Retourne le coût en bois de formation de l'unitée
	 */
	public Integer getCoutBoisFormation() {
		return coutBoisFormation;
	}

	/**
	 * @return Retourne le coût en or de formation de l'unitée
	 */
	public Integer getCoutOrFormation() {
		return coutOrFormation;
	}

	/**
	 * @return Retourne le coût en nourriture de formation de l'unitée
	 */
	public Integer getCoutNourritureFormation() {
		return coutNourritureFormation;
	}

	/**
	 * @return Retourne le coût humain pour la formation de l'unitée
	 */
	public Integer getCoutHumain() {
		return coutHumain;
	}

	/**
	 * @return Retourne le niveau du bâtiment necessaire pour la formation de l'unitée
	 */
	public Integer getNiveauBatimentNecessaireFormation() {
		return niveauBatimentNecessaireFormation;
	}


	
    
}

