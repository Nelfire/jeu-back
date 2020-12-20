package dev.entites.batiment.millitaire;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Port {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /** type de batiment : 
     * 13 = Port,
     *  **/
    private final Integer idTypeBatiment = 13;
    
    /** icone du batiment **/
    private final String icone = "https://marcdekeister.files.wordpress.com/2018/09/dessin-hocc82tel-de-ville-de-paris.jpg";
    
    /** nom du batiment **/
    private final String libelle = "Port";
    
    /** descriptif du batiment **/
    private final String descriptif = "Le descriptif du Port";
    
    /** niveau du batiment **/
    private Integer niveau;
    
    /** coût en pierre du batiment **/
    private final Integer coutPierreConstruction = 5000;
    
    /** coût en bois du batiment **/
    private final Integer coutBoisConstruction = 5000;
    
    /** coût en or du batiment **/
    private final Integer coutOrConstruction = 5000;
    
    /** coût en nourriture du batiment **/
    private final Integer coutNourritureConstruction = 5000;
    
    /** coût en pierre du batiment **/
    private Integer coutPierreAmelioration;
    
    /** coût en bois du batiment **/
    private Integer coutBoisAmelioration;
    
    /** coût en or du batiment **/
    private Integer coutOrAmelioration;
    
    /** coût en nourriture du batiment **/
    private Integer coutNourritureAmelioration;
    
    /** nombre de villageois necessaires pour la construction du batiment **/
    private final Integer villageoisNecessaireConstruction = 5;
    
    /** nombre de villageois necessaires pour l'amélioration du batiment **/
    private Integer villageoisNecessaireAmelioration;
    
    /** temps en seconde necessaire à la construction du batiment**/
    private Integer tempsConstruction = 600;

    /** temps en seconde necessaire à l'amélioration du batiment**/
    private Integer tempsAmelioration;

    
	/**
	 * Constructeur vide
	 */
	public Port() {
	
	}

	/**
	 * @param niveau
	 */
	public Port(Integer niveau) {
		super();
		this.niveau = niveau;
	}
	/**
	 * @return Retourne l'id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param Définir l'id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param Retourne le niveau du bâtiment
	 */
	public Integer getNiveau() {
		return niveau;
	}
	
	/**
	 * @param Defini le niveau du bâtiment
	 */
	public void setNiveau(Integer niveau) {
		this.niveau = niveau;
	}
	
	/**
	 * @return Retourne le coût en pierre pour la construction du bâtiment
	 */
	public Integer getCoutPierreConstruction() {
		return coutPierreConstruction;
	}

	/**
	 * @return Retourne le coût en bois pour la construction du bâtiment
	 */
	public Integer getCoutBoisConstruction() {
		return coutBoisConstruction;
	}

	/**
	 * @return Retourne le coût en or pour la construction du bâtiment
	 */
	public Integer getCoutOrConstruction() {
		return coutOrConstruction;
	}

	/**
	 * @return Retourne le coût en nourriture pour la construction du bâtiment
	 */
	public Integer getCoutNourritureConstruction() {
		return coutNourritureConstruction;
	}

	/**
	 * @return Retourne le coût en pierre pour l'amélioration du bâtiment
	 */
	public Integer getCoutPierreAmelioration() {
		return (this.niveau*this.niveau)*(2000*this.niveau);
	}

	/**
	 * @return Défini le coût en pierre pour l'amélioration du bâtiment
	 */
	public void setCoutPierreAmelioration(Integer coutPierreAmelioration) {
		this.coutPierreAmelioration = coutPierreAmelioration;
	}

	/**
	 * @return Retourne le coût en bois pour l'amélioration du bâtiment
	 */
	public Integer getCoutBoisAmelioration() {
		return (this.niveau*this.niveau)*(2000*this.niveau);
	}

	/**
	 * @return Défini le coût en bois pour l'amélioration du bâtiment
	 */
	public void setCoutBoisAmelioration(Integer coutBoisAmelioration) {
		this.coutBoisAmelioration = coutBoisAmelioration;
	}

	/**
	 * @return Retourne le coût en or pour l'amélioration du bâtiment
	 */
	public Integer getCoutOrAmelioration() {
		return (this.niveau*this.niveau)*(2000*this.niveau);
	}

	/**
	 * @return Défini le coût en or pour l'amélioration du bâtiment
	 */
	public void setCoutOrAmelioration(Integer coutOrAmelioration) {
		this.coutOrAmelioration = coutOrAmelioration;
	}

	/**
	 * @return Retourne le coût en nourriture pour l'amélioration du bâtiment
	 */
	public Integer getCoutNourritureAmelioration() {
		return (this.niveau*this.niveau)*(2000*this.niveau);
	}

	/**
	 * @return Défini le coût en nourriture pour l'amélioration du bâtiment
	 */
	public void setCoutNourritureAmelioration(Integer coutNourritureAmelioration) {
		this.coutNourritureAmelioration = coutNourritureAmelioration;
	}
	
	/**
	 * @return Retourne le nombre de villageois necessaire pour la construction du bâtiment
	 */
	public Integer getVillageoisNecessaireConstruction() {
		return villageoisNecessaireConstruction;
	}

	/**
	 * @return Retourne le nombre de villageois necessaire pour l'amélioration du bâtiment
	 */
	public Integer getVillageoisNecessaireAmelioration() {
		return (this.niveau*this.niveau)*(this.villageoisNecessaireConstruction*this.niveau);
	}
	
	/**
	 * @return Défini le nombre de villageois necessaire pour l'amélioration du bâtiment
	 */
	public void setVillageoisNecessaireAmelioration(Integer villageoisNecessaireAmelioration) {
		this.villageoisNecessaireAmelioration = villageoisNecessaireAmelioration;
	}
	
	/**
	 * @return Retourne le temps en secondes necessaire à la construction du bâtiment
	 */
	public Integer getTempsConstruction() {
		return tempsConstruction;
	}

	/**
	 * @return Defini le temps en secondes necessaire à la construction du bâtiment
	 */
	public void setTempsConstruction(Integer tempsConstruction) {
		this.tempsConstruction = tempsConstruction;
	}

	/**
	 * @return Retourne le temps en secondes necessaire à l'amélioration du bâtiment
	 */
	public Integer getTempsAmelioration() {
		return (this.niveau*this.niveau)*(this.tempsConstruction*this.niveau*this.niveau);
	}
	
	/**
	 * @return Défini le temps en secondes necessaire à l'amélioration du bâtiment
	 */
	public void setTempsAmelioration(Integer tempsAmelioration) {
		this.tempsAmelioration = tempsAmelioration;
	}
	/**
	 * @return Retourne l'id du type de bâtiment
	 */
	public Integer getIdTypeBatiment() {
		return idTypeBatiment;
	}

	/**
	 * @return Retourne l'icône du bâtiment
	 */
	public String getIcone() {
		return icone;
	}

	/**
	 * @return Retourne le libellé du bâtiment
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @return Retourne le descriptif du bâtiment
	 */
	public String getDescriptif() {
		return descriptif;
	}


	
    
}

