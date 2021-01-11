package dev.controller.dto;

public class BatimentDto {

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

    /** nombre ouvriers necessaire pour construction du batiment **/
    private Integer ouvrierNecessaireConstruction;
    
    /** temps de construction du batiment **/
    private Integer tempsDeConstruction;
    
    /** coût en pierre construction du batiment **/
    private Integer coutPierreConstruction;
    
    /** coût en bois construction du batiment **/
    private Integer coutBoisConstruction;

    /** coût en or construction du batiment **/
    private Integer coutOrConstruction;

    /** coût en nourriture construction du batiment **/
    private Integer coutNourritureConstruction;
    
    
    /** niveau necessaire de l'hotel de ville pour la construction du bâtiment **/
    private Integer niveauHotelDeVilleNecessaireConstruction;

	public BatimentDto() {
	}
	
	/**
	 * @param idTypeBatiment
	 */
	public BatimentDto(Integer idTypeBatiment) {
		super();
		this.idTypeBatiment = idTypeBatiment;
		switch (this.idTypeBatiment) {
			// Hotel de ville
		case 1:
			this.icone = "https://cdn.discordapp.com/attachments/794876433842831361/794876575979667456/HotelDeVille.png";
			this.libelle = "Hotel de ville";
			this.descriptif = "Descriptif de l'Hotel de ville";
			this.ouvrierNecessaireConstruction = 5;
			this.tempsDeConstruction = 99;
			this.coutPierreConstruction = 20;
			this.coutBoisConstruction = 20;
			this.coutOrConstruction = 20;
			this.coutNourritureConstruction = 20;
			this.niveauHotelDeVilleNecessaireConstruction = 0;
		break;
		//Chaumière (augmenter limite population)
		case 2:
			this.icone = "https://cdn.discordapp.com/attachments/794876433842831361/794876520338161704/Chaumiere.png";
			this.libelle = "Chaumière";
			this.descriptif = "Descriptif de la Chaumière";
			this.ouvrierNecessaireConstruction = 5;
			this.tempsDeConstruction = 300;
			this.coutPierreConstruction = 2500;
			this.coutBoisConstruction = 2000;
			this.coutOrConstruction = 500;
			this.coutNourritureConstruction = 1000;
			this.niveauHotelDeVilleNecessaireConstruction = 1;
		break;
		// Carrière (farm pierre)
		case 3:
			this.icone = "https://cdn.discordapp.com/attachments/794876433842831361/794876505230540860/Carriere.png";
			this.libelle = "Carrière";
			this.descriptif = "Descriptif de la Carrière";
			this.ouvrierNecessaireConstruction = 5;
			this.tempsDeConstruction = 300;
			this.coutPierreConstruction = 1;
			this.coutBoisConstruction = 1;
			this.coutOrConstruction = 1;
			this.coutNourritureConstruction = 1;
			this.niveauHotelDeVilleNecessaireConstruction = 1;
		break;
		// Camp de bucheron (farm bois)		
		case 4:
			this.icone = "https://cdn.discordapp.com/attachments/794876433842831361/794876491850711040/CampDeBucheron.png";
			this.libelle = "Camp de bucheron";
			this.descriptif = "Descriptif du Camp de bucheron";
			this.ouvrierNecessaireConstruction = 5;
			this.tempsDeConstruction = 300;
			this.coutPierreConstruction = 2500;
			this.coutBoisConstruction = 2000;
			this.coutOrConstruction = 500;
			this.coutNourritureConstruction = 1000;
			this.niveauHotelDeVilleNecessaireConstruction = 1;
		break;
		// Camp de mineur (farm or)
		case 5:
			this.icone = "https://cdn.discordapp.com/attachments/794876433842831361/794876498183323678/CampDeMineur.png";
			this.libelle = "Camp de mineur";
			this.descriptif = "Descriptif du Camp de mineur";
			this.ouvrierNecessaireConstruction = 5;
			this.tempsDeConstruction = 300;
			this.coutPierreConstruction = 2500;
			this.coutBoisConstruction = 2000;
			this.coutOrConstruction = 500;
			this.coutNourritureConstruction = 1000;
			this.niveauHotelDeVilleNecessaireConstruction = 1;
		break;
		// Ferme (farm nourriture)
		case 6:
			this.icone = "https://cdn.discordapp.com/attachments/794876433842831361/794876556509839360/Ferme.png";
			this.libelle = "Ferme";
			this.descriptif = "Descriptif de la Ferme";
			this.ouvrierNecessaireConstruction = 5; 
			this.tempsDeConstruction = 300;
			this.coutPierreConstruction = 2500;
			this.coutBoisConstruction = 2000;
			this.coutOrConstruction = 500;
			this.coutNourritureConstruction = 1000;
			this.niveauHotelDeVilleNecessaireConstruction = 1;
		break;
		// Stockage Pierre (Entrepot)	
		case 7:
			this.icone = "https://cdn.discordapp.com/attachments/794876433842831361/794876485034311690/Banque.png";
			this.libelle = "Entrepot";
			this.descriptif = "Descriptif de l'Entrepot";
			this.ouvrierNecessaireConstruction = 5;
			this.tempsDeConstruction = 300;
			this.coutPierreConstruction = 2500;
			this.coutBoisConstruction = 2000;
			this.coutOrConstruction = 500;
			this.coutNourritureConstruction = 1000;
			this.niveauHotelDeVilleNecessaireConstruction = 2;
		break;
		// Stockage Bois (Scierie)
		case 8:
			this.icone = "https://cdn.discordapp.com/attachments/794876433842831361/794876485034311690/Banque.png";
			this.libelle = "Scierie";
			this.descriptif = "Descriptif de la Scierie";
			this.ouvrierNecessaireConstruction = 5;
			this.tempsDeConstruction = 300;
			this.coutPierreConstruction = 2500;
			this.coutBoisConstruction = 2000;
			this.coutOrConstruction = 500;
			this.coutNourritureConstruction = 1000;
			this.niveauHotelDeVilleNecessaireConstruction = 2;
		break;
		// Stockage Or (Banque)
		case 9:
			this.icone = "https://cdn.discordapp.com/attachments/794876433842831361/794876485034311690/Banque.png";
			this.libelle = "Banque";
			this.descriptif = "Descriptif de la Banque";
			this.ouvrierNecessaireConstruction = 5;
			this.tempsDeConstruction = 300;
			this.coutPierreConstruction = 2500;
			this.coutBoisConstruction = 2000;
			this.coutOrConstruction = 500;
			this.coutNourritureConstruction = 1000;
			this.niveauHotelDeVilleNecessaireConstruction = 2;
		break;
		// Stockage Nourriture (Grenier)
		case 10:
			this.icone = "https://cdn.discordapp.com/attachments/794876433842831361/794876485034311690/Banque.png";
			this.libelle = "Grenier";
			this.descriptif = "Descriptif du Grenier";
			this.ouvrierNecessaireConstruction = 5;
			this.tempsDeConstruction = 300;
			this.coutPierreConstruction = 2500;
			this.coutBoisConstruction = 2000;
			this.coutOrConstruction = 500;
			this.coutNourritureConstruction = 1000;
			this.niveauHotelDeVilleNecessaireConstruction = 2;
		break;
		// Caserne Militaire	
		case 11:
			this.icone = "https://cdn.discordapp.com/attachments/794876433842831361/794876513039417404/CaserneMillitaire.png";
			this.libelle = "Caserne Militaire";
			this.descriptif = "Descriptif de la Caserne Militaire";
			this.ouvrierNecessaireConstruction = 5;
			this.tempsDeConstruction = 300;
			this.coutPierreConstruction = 2500;
			this.coutBoisConstruction = 2000;
			this.coutOrConstruction = 500;
			this.coutNourritureConstruction = 1000;
			this.niveauHotelDeVilleNecessaireConstruction = 2;
		break;
		// Ecurie
		case 12:
			this.icone = "https://cdn.discordapp.com/attachments/794876433842831361/794876520338161704/Chaumiere.png";
			this.libelle = "Ecurie";
			this.descriptif = "Descriptif de l'Ecurie";
			this.ouvrierNecessaireConstruction = 5;
			this.tempsDeConstruction = 300;
			this.coutPierreConstruction = 2500;
			this.coutBoisConstruction = 2000;
			this.coutOrConstruction = 500;
			this.coutNourritureConstruction = 1000;
			this.niveauHotelDeVilleNecessaireConstruction = 3;
		break;
		// Port
		case 13:
			this.icone = "https://cdn.discordapp.com/attachments/794876433842831361/794876596741865522/Port.png";
			this.libelle = "Port";
			this.descriptif = "Descriptif du Port";
			this.ouvrierNecessaireConstruction = 5;
			this.tempsDeConstruction = 300;
			this.coutPierreConstruction = 2500;
			this.coutBoisConstruction = 2000;
			this.coutOrConstruction = 500;
			this.coutNourritureConstruction = 1000;
			this.niveauHotelDeVilleNecessaireConstruction = 4;
		break;
		// Atelier de siege
		case 14:
			this.icone = "https://cdn.discordapp.com/attachments/794876433842831361/794876478667751444/AtelierDeSiege.png";
			this.libelle = "Atelier de siege";
			this.descriptif = "Descriptif de l'Atelier de siege";
			this.ouvrierNecessaireConstruction = 5;
			this.tempsDeConstruction = 300;
			this.coutPierreConstruction = 2500;
			this.coutBoisConstruction = 2000;
			this.coutOrConstruction = 500;
			this.coutNourritureConstruction = 1000;
			this.niveauHotelDeVilleNecessaireConstruction = 5;
		break;
		// Forge
		case 15:
			this.icone = "https://cdn.discordapp.com/attachments/794876433842831361/794876568375001098/Forge.png";
			this.libelle = "Forge";
			this.descriptif = "Descriptif de la Forge";
			this.ouvrierNecessaireConstruction = 5;
			this.tempsDeConstruction = 300;
			this.coutPierreConstruction = 2500;
			this.coutBoisConstruction = 2000;
			this.coutOrConstruction = 500;
			this.coutNourritureConstruction = 1000;
			this.niveauHotelDeVilleNecessaireConstruction = 5;
		break;
		// Universite
		case 16:
			this.icone = "https://cdn.discordapp.com/attachments/794876433842831361/794876610632220702/Universite.png";
			this.libelle = "Universite";
			this.descriptif = "Descriptif de l'Universite";
			this.ouvrierNecessaireConstruction = 5;
			this.tempsDeConstruction = 300;
			this.coutPierreConstruction = 2500;
			this.coutBoisConstruction = 2000;
			this.coutOrConstruction = 500;
			this.coutNourritureConstruction = 1000;
			this.niveauHotelDeVilleNecessaireConstruction = 5;
		break;
		// Marché
		case 17:
			this.icone = "https://cdn.discordapp.com/attachments/794876433842831361/794876590022590504/Marche.png";
			this.libelle = "Marché";
			this.descriptif = "Descriptif du Marché";
			this.ouvrierNecessaireConstruction = 5;
			this.tempsDeConstruction = 300;
			this.coutPierreConstruction = 2500;
			this.coutBoisConstruction = 2000;
			this.coutOrConstruction = 500;
			this.coutNourritureConstruction = 1000;
			this.niveauHotelDeVilleNecessaireConstruction = 5;
		break;
		// Table d'expéditions
		case 18:
			this.icone = "https://cdn.discordapp.com/attachments/794876433842831361/794876603564818432/TableExpedition.png";
			this.libelle = "Table d'expéditions";
			this.descriptif = "Descriptif de la Table d'expéditions";
			this.ouvrierNecessaireConstruction = 5;
			this.tempsDeConstruction = 300;
			this.coutPierreConstruction = 2500;
			this.coutBoisConstruction = 2000;
			this.coutOrConstruction = 500;
			this.coutNourritureConstruction = 1000;
			this.niveauHotelDeVilleNecessaireConstruction = 6;
		break;
			
		}
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
	 * @return the ouvrierNecessaireConstruction
	 */
	public Integer getOuvrierNecessaireConstruction() {
		return ouvrierNecessaireConstruction;
	}

	/**
	 * @param ouvrierNecessaireConstruction the ouvrierNecessaireConstruction to set
	 */
	public void setOuvrierNecessaireConstruction(Integer ouvrierNecessaireConstruction) {
		this.ouvrierNecessaireConstruction = ouvrierNecessaireConstruction;
	}

	/**
	 * @return the tempsDeConstruction
	 */
	public Integer getTempsDeConstruction() {
		return tempsDeConstruction;
	}

	/**
	 * @param tempsDeConstruction the tempsDeConstruction to set
	 */
	public void setTempsDeConstruction(Integer tempsDeConstruction) {
		this.tempsDeConstruction = tempsDeConstruction;
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
