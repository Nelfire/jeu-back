package dev.entites.batiment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Batiment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /* 
 	1 - Hotel de ville	
	2 - Chaumière (augmenter limite population)
	3 - Carrière (farm pierre)
	4 - Camp de bucheron (farm bois)		
	5 - Camp de mineur (farm or)
	6 - Ferme (farm nourriture)
	7 - Stockage Pierre (Entrepot)	
	8 - Stockage Bois (Scierie)
	9 - Stockage Or (Banque)
	10 - Stockage Nourriture (Grenier)
	11 - Caserne Militaire	
	12 - Ecurie
	13 - Port
	14 - Atelier de siege
	15 - Forge		
	16 - Universite
	17 - Marché
	18 - Table d'expéditions
     */
    private Integer idTypeBatiment;
    
    /** icone du batiment **/
    private String icone;
    
    /** nom du batiment **/
    private String libelle;
    
    /** descriptif du batiment **/
    private String descriptif;
    
    /** niveau du batiment **/
    private Integer niveau;

    /** nombre ouvriers necessaire pour construction du batiment **/
    private Integer ouvrierNecessaireConstruction;
    
    /** nombre ouvriers necessaire pour l'amélioration du batiment **/
    private Integer ouvrierNecessaireAmelioration;
    
    /** temps de construction du batiment **/
    private Integer tempsDeConstruction;
    
    /** temps d'amelioration du batiment **/
    private Integer tempsAmelioration;
    
    /** coût en pierre construction du batiment **/
    private Integer coutPierreConstruction;
    
    /** coût en pierre amelioration du batiment **/
    private Integer coutPierreAmelioration;
    
    /** coût en bois construction du batiment **/
    private Integer coutBoisConstruction;
    
    /** coût en bois amelioration du batiment **/
    private Integer coutBoisAmelioration;

    /** coût en or construction du batiment **/
    private Integer coutOrConstruction;
    
    /** coût en or amelioration du batiment **/
    private Integer coutOrAmelioration;

    /** coût en nourriture construction du batiment **/
    private Integer coutNourritureConstruction;
    
    /** coût en nourriture amelioration du batiment **/
    private Integer coutNourritureAmelioration;
    
    /** quantitée de pierre stockable dans la chambre forte du batiment**/
    private Integer quantiteeStockagePierre;
    
    /** quantitée de bois stockable dans la chambre forte du batiment**/
    private Integer quantiteeStockageBois;
    
    /** quantitée d'or stockable dans la chambre forte du batiment**/
    private Integer quantiteeStockageOr;
    
    /** quantitée de nourriture stockable dans la chambre forte du batiment**/
    private Integer quantiteeStockageNourriture;
    
    /** nombre d'exploitants autorisé pour le bâtiment **/
    private Integer nombreExploitantsAutorise;
    
    /** montant de l'apport de ressource par heure (pour 100% exploitants) **/
    private Integer apportRessourceHeure;
    
    /** niveau necessaire de l'hotel de ville pour la construction du bâtiment **/
    private Integer niveauHotelDeVilleNecessaireConstruction;

	/**
	 * @param idTypeBatiment
	 * @param niveau
	 */
	public Batiment(Integer idTypeBatiment, Integer niveau) {
		super();
		this.idTypeBatiment = idTypeBatiment;
		this.niveau = niveau;
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
	 * @return the idTypeBatiment
	 */
	public Integer getIdTypeBatiment() {
		return idTypeBatiment;
	}

	/**
	 * @param idTypeBatiment the idTypeBatiment to set
	 */
	public void setIdTypeBatiment(Integer idTypeBatiment) {
		this.idTypeBatiment = idTypeBatiment;
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
		switch (this.idTypeBatiment) {
		case 1:
			libelle = "Hotel de Ville";
			break;
		case 2:
			libelle = "Chaumière";
			break;
		case 3:
			libelle = "Carrière";
			break;
		case 4:
			libelle = "Camp de bucheron";
			break;
		case 5:
			libelle = "Camp de mineur";
			break;
		case 6:
			libelle = "Ferme";
			break;
		case 7:
			libelle = "Entrepot";
			break;
		case 8:
			libelle = "Scierie";
			break;
		case 9:
			libelle = "Banque";
			break;
		case 10:
			libelle = "Grenier";
			break;
		case 11:
			libelle = "Caserne Militaire";
			break;
		case 12:
			libelle = "Ecurie";
			break;
		case 13:
			libelle = "Port";
			break;
		case 14:
			libelle = "Atelier de Siège";
			break;
		case 15:
			libelle = "Forge";
			break;
		case 16:
			libelle = "Université";
			break;
		case 17:
			libelle = "Marché";
			break;
		case 18:
			libelle = "Table d'Expéditions";
			break;
        default:
        	libelle = "Problème dans la matrice";
            break;
		}
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
		switch (this.idTypeBatiment) {
		case 1:
			descriptif = "Descriptif de l'Hotel de Ville";
			break;
		case 2:
			descriptif = "Descriptif de la Chaumière";
			break;
		case 3:
			descriptif = "Descriptif de la Carrière";
			break;
		case 4:
			descriptif = "Descriptif du Camp de bucheron";
			break;
		case 5:
			descriptif = "Descriptif du Camp de mineur";
			break;
		case 6:
			descriptif = "Descriptif de la Ferme";
			break;
		case 7:
			descriptif = "Descriptif de l'Entrepot";
			break;
		case 8:
			descriptif = "Descriptif de la Scierie";
			break;
		case 9:
			descriptif = "Descriptif de la Banque";
			break;
		case 10:
			descriptif = "Descriptif du Grenier";
			break;
		case 11:
			descriptif = "Descriptif de la Caserne Militaire";
			break;
		case 12:
			descriptif = "Descriptif de l'Ecurie";
			break;
		case 13:
			descriptif = "Descriptif du Port";
			break;
		case 14:
			descriptif = "Descriptif de l'Atelier de Siège";
			break;
		case 15:
			descriptif = "Descriptif de la Forge";
			break;
		case 16:
			descriptif = "Descriptif de l'Université";
			break;
		case 17:
			descriptif = "Descriptif du Marché";
			break;
		case 18:
			descriptif = "Descriptif de la Table d'Expéditions";
			break;
        default:
        	descriptif = "Problème dans la matrice";
            break;
		}
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
	 * @return the ouvrierNecessaireConstruction
	 */
	public Integer getOuvrierNecessaireConstruction() {
		switch (this.idTypeBatiment) {
		case 1:
			// Hotel de ville	
			ouvrierNecessaireConstruction = 0;
			break;
		case 2:
			// Chaumière
			ouvrierNecessaireConstruction = 99;
			break;
		case 3:
			// Carrière
			ouvrierNecessaireConstruction = 99;
			break;
		case 4:
			// Camp de bucheron
			ouvrierNecessaireConstruction = 99;
			break;
		case 5:
			// Camp de mineur
			ouvrierNecessaireConstruction = 99;
			break;
		case 6:
			// Ferme
			ouvrierNecessaireConstruction = 99;
			break;
		case 7:
			// Entrepot (Stockage Pierre)
			ouvrierNecessaireConstruction = 99;
			break;
		case 8:
			// Scierie (Stockage Bois)
			ouvrierNecessaireConstruction = 99;
			break;
		case 9:
			// Banque (Stockage Or)
			ouvrierNecessaireConstruction = 99;
			break;
		case 10:
			// Grenier (Stockage Nourriture)
			ouvrierNecessaireConstruction = 99;
			break;
		case 11:
			// Caserne Militaire
			ouvrierNecessaireConstruction = 99;
			break;
		case 12:
			// Ecurie
			ouvrierNecessaireConstruction = 99;
			break;
		case 13:
			// Port
			ouvrierNecessaireConstruction = 99;
			break;
		case 14:
			// Atelier de siege
			ouvrierNecessaireConstruction = 99;
			break;
		case 15:
			// Forge
			ouvrierNecessaireConstruction = 99;
			break;
		case 16:
			// Universite
			ouvrierNecessaireConstruction = 99;
			break;
		case 17:
			// Marché
			ouvrierNecessaireConstruction = 99;
			break;
		case 18:
			// Table d'expéditions
			ouvrierNecessaireConstruction = 99;
			break;
        default:
			ouvrierNecessaireConstruction = 99;
            break;
		}
		return ouvrierNecessaireConstruction;
	}

	/**
	 * @param ouvrierNecessaireConstruction the ouvrierNecessaireConstruction to set
	 */
	public void setOuvrierNecessaireConstruction(Integer ouvrierNecessaireConstruction) {
		this.ouvrierNecessaireConstruction = ouvrierNecessaireConstruction;
	}

	/**
	 * @return the ouvrierNecessaireAmelioration
	 */
	public Integer getOuvrierNecessaireAmelioration() {
		switch (this.idTypeBatiment) {
		case 1:
			// Hotel de ville	
			ouvrierNecessaireAmelioration = 99*this.niveau;
			break;
		case 2:
			// Chaumière
			ouvrierNecessaireAmelioration = 99*this.niveau;
			break;
		case 3:
			// Carrière
			ouvrierNecessaireAmelioration = 99*this.niveau;
			break;
		case 4:
			// Camp de bucheron
			ouvrierNecessaireAmelioration = 99*this.niveau;
			break;
		case 5:
			// Camp de mineur
			ouvrierNecessaireAmelioration = 99*this.niveau;
			break;
		case 6:
			// Ferme
			ouvrierNecessaireAmelioration = 99*this.niveau;
			break;
		case 7:
			// Entrepot (Stockage Pierre)
			ouvrierNecessaireAmelioration = 99*this.niveau;
			break;
		case 8:
			// Scierie (Stockage Bois)
			ouvrierNecessaireAmelioration = 99*this.niveau;
			break;
		case 9:
			// Banque (Stockage Or)
			ouvrierNecessaireAmelioration = 99*this.niveau;
			break;
		case 10:
			// Grenier (Stockage Nourriture)
			ouvrierNecessaireAmelioration = 99*this.niveau;
			break;
		case 11:
			// Caserne Militaire
			ouvrierNecessaireAmelioration = 99*this.niveau;
			break;
		case 12:
			// Ecurie
			ouvrierNecessaireAmelioration = 99*this.niveau;
			break;
		case 13:
			// Port
			ouvrierNecessaireAmelioration = 99*this.niveau;
			break;
		case 14:
			// Atelier de siege
			ouvrierNecessaireAmelioration = 99*this.niveau;
			break;
		case 15:
			// Forge
			ouvrierNecessaireAmelioration = 99*this.niveau;
			break;
		case 16:
			// Universite
			ouvrierNecessaireAmelioration = 99*this.niveau;
			break;
		case 17:
			// Marché
			ouvrierNecessaireAmelioration = 99*this.niveau;
			break;
		case 18:
			// Table d'expéditions
			ouvrierNecessaireAmelioration = 99*this.niveau;
			break;
        default:
        	ouvrierNecessaireAmelioration = 99*this.niveau;
            break;
		}
		return ouvrierNecessaireAmelioration;
	}

	/**
	 * @param ouvrierNecessaireAmelioration the ouvrierNecessaireAmelioration to set
	 */
	public void setOuvrierNecessaireAmelioration(Integer ouvrierNecessaireAmelioration) {
		this.ouvrierNecessaireAmelioration = ouvrierNecessaireAmelioration;
	}

	/**
	 * @return the tempsDeConstruction
	 */
	public Integer getTempsDeConstruction() {
		switch (this.idTypeBatiment) {
		case 1:
			// Hotel de ville	
			tempsDeConstruction = 99;
			break;
		case 2:
			// Chaumière
			tempsDeConstruction = 99;
			break;
		case 3:
			// Carrière
			tempsDeConstruction = 99;
			break;
		case 4:
			// Camp de bucheron
			tempsDeConstruction = 99;
			break;
		case 5:
			// Camp de mineur
			tempsDeConstruction = 99;
			break;
		case 6:
			// Ferme
			tempsDeConstruction = 99;
			break;
		case 7:
			// Entrepot (Stockage Pierre)
			tempsDeConstruction = 99;
			break;
		case 8:
			// Scierie (Stockage Bois)
			tempsDeConstruction = 99;
			break;
		case 9:
			// Banque (Stockage Or)
			tempsDeConstruction = 99;
			break;
		case 10:
			// Grenier (Stockage Nourriture)
			tempsDeConstruction = 99;
			break;
		case 11:
			// Caserne Militaire
			tempsDeConstruction = 99;
			break;
		case 12:
			// Ecurie
			tempsDeConstruction = 99;
			break;
		case 13:
			// Port
			tempsDeConstruction = 99;
			break;
		case 14:
			// Atelier de siege
			tempsDeConstruction = 99;
			break;
		case 15:
			// Forge
			tempsDeConstruction = 99;
			break;
		case 16:
			// Universite
			tempsDeConstruction = 99;
			break;
		case 17:
			// Marché
			tempsDeConstruction = 99;
			break;
		case 18:
			// Table d'expéditions
			tempsDeConstruction = 99;
			break;
        default:
        	tempsDeConstruction = 99;
            break;
		}
		return tempsDeConstruction;
	}

	/**
	 * @param tempsDeConstruction the tempsDeConstruction to set
	 */
	public void setTempsDeConstruction(Integer tempsDeConstruction) {
		this.tempsDeConstruction = tempsDeConstruction;
	}

	/**
	 * @return the tempsAmelioration
	 */
	public Integer getTempsAmelioration() {
		return tempsAmelioration;
	}

	/**
	 * @param tempsAmelioration the tempsAmelioration to set
	 */
	public void setTempsAmelioration(Integer tempsAmelioration) {
		this.tempsAmelioration = tempsAmelioration;
	}

	/**
	 * @return the coutPierreConstruction
	 */
	public Integer getCoutPierreConstruction() {
		return coutPierreConstruction;
	}

	/**
	 * @param coutPierreConstruction the coutPierreConstruction to set
	 */
	public void setCoutPierreConstruction(Integer coutPierreConstruction) {
		this.coutPierreConstruction = coutPierreConstruction;
	}

	/**
	 * @return the coutPierreAmelioration
	 */
	public Integer getCoutPierreAmelioration() {
		return coutPierreAmelioration;
	}

	/**
	 * @param coutPierreAmelioration the coutPierreAmelioration to set
	 */
	public void setCoutPierreAmelioration(Integer coutPierreAmelioration) {
		this.coutPierreAmelioration = coutPierreAmelioration;
	}

	/**
	 * @return the coutBoisConstruction
	 */
	public Integer getCoutBoisConstruction() {
		return coutBoisConstruction;
	}

	/**
	 * @param coutBoisConstruction the coutBoisConstruction to set
	 */
	public void setCoutBoisConstruction(Integer coutBoisConstruction) {
		this.coutBoisConstruction = coutBoisConstruction;
	}

	/**
	 * @return the coutBoisAmelioration
	 */
	public Integer getCoutBoisAmelioration() {
		return coutBoisAmelioration;
	}

	/**
	 * @param coutBoisAmelioration the coutBoisAmelioration to set
	 */
	public void setCoutBoisAmelioration(Integer coutBoisAmelioration) {
		this.coutBoisAmelioration = coutBoisAmelioration;
	}

	/**
	 * @return the coutOrConstruction
	 */
	public Integer getCoutOrConstruction() {
		return coutOrConstruction;
	}

	/**
	 * @param coutOrConstruction the coutOrConstruction to set
	 */
	public void setCoutOrConstruction(Integer coutOrConstruction) {
		this.coutOrConstruction = coutOrConstruction;
	}

	/**
	 * @return the coutOrAmelioration
	 */
	public Integer getCoutOrAmelioration() {
		return coutOrAmelioration;
	}

	/**
	 * @param coutOrAmelioration the coutOrAmelioration to set
	 */
	public void setCoutOrAmelioration(Integer coutOrAmelioration) {
		this.coutOrAmelioration = coutOrAmelioration;
	}

	/**
	 * @return the coutNourritureConstruction
	 */
	public Integer getCoutNourritureConstruction() {
		return coutNourritureConstruction;
	}

	/**
	 * @param coutNourritureConstruction the coutNourritureConstruction to set
	 */
	public void setCoutNourritureConstruction(Integer coutNourritureConstruction) {
		this.coutNourritureConstruction = coutNourritureConstruction;
	}

	/**
	 * @return the coutNourritureAmelioration
	 */
	public Integer getCoutNourritureAmelioration() {
		return coutNourritureAmelioration;
	}

	/**
	 * @param coutNourritureAmelioration the coutNourritureAmelioration to set
	 */
	public void setCoutNourritureAmelioration(Integer coutNourritureAmelioration) {
		this.coutNourritureAmelioration = coutNourritureAmelioration;
	}

	/**
	 * @return the quantiteeStockagePierre
	 */
	public Integer getQuantiteeStockagePierre() {
		return quantiteeStockagePierre;
	}

	/**
	 * @param quantiteeStockagePierre the quantiteeStockagePierre to set
	 */
	public void setQuantiteeStockagePierre(Integer quantiteeStockagePierre) {
		this.quantiteeStockagePierre = quantiteeStockagePierre;
	}

	/**
	 * @return the quantiteeStockageBois
	 */
	public Integer getQuantiteeStockageBois() {
		return quantiteeStockageBois;
	}

	/**
	 * @param quantiteeStockageBois the quantiteeStockageBois to set
	 */
	public void setQuantiteeStockageBois(Integer quantiteeStockageBois) {
		this.quantiteeStockageBois = quantiteeStockageBois;
	}

	/**
	 * @return the quantiteeStockageOr
	 */
	public Integer getQuantiteeStockageOr() {
		return quantiteeStockageOr;
	}

	/**
	 * @param quantiteeStockageOr the quantiteeStockageOr to set
	 */
	public void setQuantiteeStockageOr(Integer quantiteeStockageOr) {
		this.quantiteeStockageOr = quantiteeStockageOr;
	}

	/**
	 * @return the quantiteeStockageNourriture
	 */
	public Integer getQuantiteeStockageNourriture() {
		return quantiteeStockageNourriture;
	}

	/**
	 * @param quantiteeStockageNourriture the quantiteeStockageNourriture to set
	 */
	public void setQuantiteeStockageNourriture(Integer quantiteeStockageNourriture) {
		this.quantiteeStockageNourriture = quantiteeStockageNourriture;
	}

	/**
	 * @return the nombreExploitantsAutorise
	 */
	public Integer getNombreExploitantsAutorise() {
		return nombreExploitantsAutorise;
	}

	/**
	 * @param nombreExploitantsAutorise the nombreExploitantsAutorise to set
	 */
	public void setNombreExploitantsAutorise(Integer nombreExploitantsAutorise) {
		this.nombreExploitantsAutorise = nombreExploitantsAutorise;
	}

	/**
	 * @return the apportRessourceHeure
	 */
	public Integer getApportRessourceHeure() {
		return apportRessourceHeure;
	}

	/**
	 * @param apportRessourceHeure the apportRessourceHeure to set
	 */
	public void setApportRessourceHeure(Integer apportRessourceHeure) {
		this.apportRessourceHeure = apportRessourceHeure;
	}

	/**
	 * @return the niveauHotelDeVilleNecessaireConstruction
	 */
	public Integer getNiveauHotelDeVilleNecessaireConstruction() {
		return niveauHotelDeVilleNecessaireConstruction;
	}

	/**
	 * @param niveauHotelDeVilleNecessaireConstruction the niveauHotelDeVilleNecessaireConstruction to set
	 */
	public void setNiveauHotelDeVilleNecessaireConstruction(Integer niveauHotelDeVilleNecessaireConstruction) {
		this.niveauHotelDeVilleNecessaireConstruction = niveauHotelDeVilleNecessaireConstruction;
	}
    
    
    
}
