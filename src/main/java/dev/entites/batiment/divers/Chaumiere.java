package dev.entites.batiment.divers;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Chaumiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /** type de batiment : 
     * 2 = Chaumiere,
     *  **/
    private final Integer idTypeBatiment = 2;
    
    /** icone du batiment **/
    private final String icone = "https://marcdekeister.files.wordpress.com/2018/09/dessin-hocc82tel-de-ville-de-paris.jpg";
    
    /** nom du batiment **/
    private final String libelle = "Chaumière";
    
    /** descriptif du batiment **/
    private final String descriptif = "Le descriptif de la chaumière";
    
    /** niveau du batiment **/
    private final Integer niveau = 1;
    
    /** coût en pierre du batiment **/
    private final Integer coutPierreConstruction = 5000;
    
    /** coût en bois du batiment **/
    private final Integer coutBoisConstruction = 5000;
    
    /** coût en or du batiment **/
    private final Integer coutOrConstruction = 5000;
    
    /** coût en nourriture du batiment **/
    private final Integer coutNourritureConstruction = 5000;
    
    /** nombre de villageois necessaires pour la construction du batiment **/
    private final Integer villageoisNecessaireConstruction = 5;
    
    /** temps en seconde necessaire à la construction du batiment**/
    private Integer tempsConstruction = 600;
    
    /** augmentation population totale **/
    private final Integer augmentationPopulationTotal = 20;

    
	public Chaumiere() {
	
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
	 * @return Retourne le nombre de villageois necessaire pour la construction du bâtiment
	 */
	public Integer getVillageoisNecessaireConstruction() {
		return villageoisNecessaireConstruction;
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

	/**
	 * @return Retourne le montant de l'augmentation de population du bâtiment
	 */
	public Integer getAugmentationPopulationTotal() {
		return augmentationPopulationTotal;
	}

	
    
}

