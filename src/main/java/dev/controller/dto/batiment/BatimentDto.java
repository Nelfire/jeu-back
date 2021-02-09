package dev.controller.dto.batiment;

public class BatimentDto {

    private Integer id;

    /* 
 	1 /- Hotel de ville	
	2 /- Chaumière (augmenter limite population)
	3 /- Carrière (farm pierre)
	4 /- Camp de bucheron (farm bois)		
	5 /- Camp de mineur (farm or)
	6 /- Ferme (farm nourriture)
	7 /- Stockage Pierre (Entrepot)	
	8 /- Stockage Bois (Scierie)
	9 /- Stockage Or (Banque)
	10 /- Stockage Nourriture (Grenier)
	11 /- Caserne Militaire	
	12 /- Ecurie
	13 /- Port
	14 /- Atelier de siege
	15 /- Forge		
	16 /- Universite
	17 /- Marché
	18 - Table d'expéditions
     */
    private Integer idTypeBatiment;
    /*
     * 0 = Divers
     * 1 = Ressource
     * 2 = Stockage
     * 3 = Millitaire
     */
    private Integer idCategorieBatiment;
    
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
    
    /** quantitée de pierre stockable dans la chambre forte du batiment**/
    private Integer quantiteeStockagePierre;
    /** quantitée de bois stockable dans la chambre forte du batiment**/
    private Integer quantiteeStockageBois;
    /** quantitée d'or stockable dans la chambre forte du batiment**/
    private Integer quantiteeStockageOre;
    /** quantitée de nourriture stockable dans la chambre forte du batiment**/
    private Integer quantiteeStockageNourriture;
    /** montant de l'apport de ressource (pierre) par heure (pour 100% exploitants) **/
    private Integer apportPierreHeure;
    /** montant de l'apport de ressource (bois) par heure (pour 100% exploitants) **/
    private Integer apportBoisHeure;
    /** montant de l'apport de ressource (or) par heure (pour 100% exploitants) **/
    private Integer apportOreHeure;
    /** montant de l'apport de ressource (nourriture) par heure (pour 100% exploitants) **/
    private Integer apportNourritureHeure;
    
	public BatimentDto() {
	}

	/**
	 * @param idTypeBatiment
	 * @param icone
	 * @param libelle
	 * @param descriptif
	 * @param ouvrierNecessaireConstruction
	 * @param tempsDeConstruction
	 * @param coutPierreConstruction
	 * @param coutBoisConstruction
	 * @param coutOrConstruction
	 * @param coutNourritureConstruction
	 * @param niveauHotelDeVilleNecessaireConstruction
	 * @param quantiteeStockagePierre
	 * @param quantiteeStockageBois
	 * @param quantiteeStockageOre
	 * @param quantiteeStockageNourriture
	 * @param apportPierreHeure
	 * @param apportBoisHeure
	 * @param apportOreHeure
	 * @param apportNourritureHeure
	 */
	public BatimentDto(Integer idTypeBatiment, Integer idCategorieBatiment, String icone, String libelle, String descriptif,
			Integer ouvrierNecessaireConstruction, Integer tempsDeConstruction, Integer coutPierreConstruction,
			Integer coutBoisConstruction, Integer coutOrConstruction, Integer coutNourritureConstruction,
			Integer niveauHotelDeVilleNecessaireConstruction, Integer quantiteeStockagePierre,
			Integer quantiteeStockageBois, Integer quantiteeStockageOre, Integer quantiteeStockageNourriture,
			Integer apportPierreHeure, Integer apportBoisHeure, Integer apportOreHeure, Integer apportNourritureHeure) {
		super();
		this.idTypeBatiment = idTypeBatiment;
		this.idCategorieBatiment = idCategorieBatiment;
		this.icone = icone;
		this.libelle = libelle;
		this.descriptif = descriptif;
		this.ouvrierNecessaireConstruction = ouvrierNecessaireConstruction;
		this.tempsDeConstruction = tempsDeConstruction;
		this.coutPierreConstruction = coutPierreConstruction;
		this.coutBoisConstruction = coutBoisConstruction;
		this.coutOrConstruction = coutOrConstruction;
		this.coutNourritureConstruction = coutNourritureConstruction;
		this.niveauHotelDeVilleNecessaireConstruction = niveauHotelDeVilleNecessaireConstruction;
		this.quantiteeStockagePierre = quantiteeStockagePierre;
		this.quantiteeStockageBois = quantiteeStockageBois;
		this.quantiteeStockageOre = quantiteeStockageOre;
		this.quantiteeStockageNourriture = quantiteeStockageNourriture;
		this.apportPierreHeure = apportPierreHeure;
		this.apportBoisHeure = apportBoisHeure;
		this.apportOreHeure = apportOreHeure;
		this.apportNourritureHeure = apportNourritureHeure;
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
	 * @return the idCategorieBatiment
	 */
	public Integer getIdCategorieBatiment() {
		return idCategorieBatiment;
	}

	/**
	 * @param idCategorieBatiment the idCategorieBatiment to set
	 */
	public void setIdCategorieBatiment(Integer idCategorieBatiment) {
		this.idCategorieBatiment = idCategorieBatiment;
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
	 * @return the quantiteeStockageOre
	 */
	public Integer getQuantiteeStockageOre() {
		return quantiteeStockageOre;
	}

	/**
	 * @param quantiteeStockageOre the quantiteeStockageOre to set
	 */
	public void setQuantiteeStockageOre(Integer quantiteeStockageOre) {
		this.quantiteeStockageOre = quantiteeStockageOre;
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
	 * @return the apportPierreHeure
	 */
	public Integer getApportPierreHeure() {
		return apportPierreHeure;
	}

	/**
	 * @param apportPierreHeure the apportPierreHeure to set
	 */
	public void setApportPierreHeure(Integer apportPierreHeure) {
		this.apportPierreHeure = apportPierreHeure;
	}

	/**
	 * @return the apportBoisHeure
	 */
	public Integer getApportBoisHeure() {
		return apportBoisHeure;
	}

	/**
	 * @param apportBoisHeure the apportBoisHeure to set
	 */
	public void setApportBoisHeure(Integer apportBoisHeure) {
		this.apportBoisHeure = apportBoisHeure;
	}

	/**
	 * @return the apportOreHeure
	 */
	public Integer getApportOreHeure() {
		return apportOreHeure;
	}

	/**
	 * @param apportOreHeure the apportOreHeure to set
	 */
	public void setApportOreHeure(Integer apportOreHeure) {
		this.apportOreHeure = apportOreHeure;
	}

	/**
	 * @return the apportNourritureHeure
	 */
	public Integer getApportNourritureHeure() {
		return apportNourritureHeure;
	}

	/**
	 * @param apportNourritureHeure the apportNourritureHeure to set
	 */
	public void setApportNourritureHeure(Integer apportNourritureHeure) {
		this.apportNourritureHeure = apportNourritureHeure;
	}

	
    
}
