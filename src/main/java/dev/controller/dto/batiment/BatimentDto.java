package dev.controller.dto.batiment;

public class BatimentDto {

	private Integer id;

	private Integer idTypeBatiment;

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
	private Long coutPierreConstruction;

	/** coût en bois construction du batiment **/
	private Long coutBoisConstruction;

	/** coût en or construction du batiment **/
	private Long coutOrConstruction;

	/** coût en nourriture construction du batiment **/
	private Long coutNourritureConstruction;

	/** niveau necessaire de l'hotel de ville pour la construction du bâtiment **/
	private Integer niveauHotelDeVilleNecessaireConstruction;

	/** quantitée de pierre stockable dans la chambre forte du batiment **/
	private Long quantiteeStockagePierre;

	/** quantitée de bois stockable dans la chambre forte du batiment **/
	private Long quantiteeStockageBois;

	/** quantitée d'or stockable dans la chambre forte du batiment **/
	private Long quantiteeStockageOre;

	/** quantitée de nourriture stockable dans la chambre forte du batiment **/
	private Long quantiteeStockageNourriture;

	/** montant de l'apport de ressource (pierre) par heure **/
	private Integer apportPierreHeure;

	/** montant de l'apport de ressource (bois) par heure **/
	private Integer apportBoisHeure;

	/** montant de l'apport de ressource (or) par heure **/
	private Integer apportOreHeure;

	/** montant de l'apport de ressource (nourriture) par heure **/
	private Integer apportNourritureHeure;

	/** montant gain experience construction **/
	private Long apportExperience;

	/** montant du multiplicateur d'experience **/
	private Double multiplicateurExperience;

	/** montant du multiplicateur de temps **/
	private Double multiplicateurTemps;

	/** montant du multiplicateur d'apport de ressource **/
	private Double multiplicateurApport;

	/** montant du multiplicateur de coût **/
	private Double multiplicateurCout;

	/**
	 * CONSTRUCTEUR VIDE
	 */
	public BatimentDto() {
	}

	/**
	 * CONSTRUCTEUR AVEC PARAMETRES
	 * 
	 * @param idTypeBatiment
	 * @param idCategorieBatiment
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
	 * @param apportExperience
	 * @param multiplicateurExperience
	 * @param multiplicateurTemps
	 * @param multiplicateurApport
	 * @param multiplicateurCout
	 */
	public BatimentDto(Integer idTypeBatiment, Integer idCategorieBatiment, String icone, String libelle,
			String descriptif, Integer ouvrierNecessaireConstruction, Integer tempsDeConstruction,
			Long coutPierreConstruction, Long coutBoisConstruction, Long coutOrConstruction,
			Long coutNourritureConstruction, Integer niveauHotelDeVilleNecessaireConstruction,
			Long quantiteeStockagePierre, Long quantiteeStockageBois, Long quantiteeStockageOre,
			Long quantiteeStockageNourriture, Integer apportPierreHeure, Integer apportBoisHeure,
			Integer apportOreHeure, Integer apportNourritureHeure, Long apportExperience,
			Double multiplicateurExperience, Double multiplicateurTemps, Double multiplicateurApport,
			Double multiplicateurCout) {
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
		this.apportExperience = apportExperience;
		this.multiplicateurExperience = multiplicateurExperience;
		this.multiplicateurTemps = multiplicateurTemps;
		this.multiplicateurApport = multiplicateurApport;
		this.multiplicateurCout = multiplicateurCout;
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
	public Long getCoutPierreConstruction() {
		return coutPierreConstruction;
	}

	/**
	 * @param coutPierreConstruction the coutPierreConstruction to set
	 */
	public void setCoutPierreConstruction(Long coutPierreConstruction) {
		this.coutPierreConstruction = coutPierreConstruction;
	}

	/**
	 * @return the coutBoisConstruction
	 */
	public Long getCoutBoisConstruction() {
		return coutBoisConstruction;
	}

	/**
	 * @param coutBoisConstruction the coutBoisConstruction to set
	 */
	public void setCoutBoisConstruction(Long coutBoisConstruction) {
		this.coutBoisConstruction = coutBoisConstruction;
	}

	/**
	 * @return the coutOrConstruction
	 */
	public Long getCoutOrConstruction() {
		return coutOrConstruction;
	}

	/**
	 * @param coutOrConstruction the coutOrConstruction to set
	 */
	public void setCoutOrConstruction(Long coutOrConstruction) {
		this.coutOrConstruction = coutOrConstruction;
	}

	/**
	 * @return the coutNourritureConstruction
	 */
	public Long getCoutNourritureConstruction() {
		return coutNourritureConstruction;
	}

	/**
	 * @param coutNourritureConstruction the coutNourritureConstruction to set
	 */
	public void setCoutNourritureConstruction(Long coutNourritureConstruction) {
		this.coutNourritureConstruction = coutNourritureConstruction;
	}

	/**
	 * @return the niveauHotelDeVilleNecessaireConstruction
	 */
	public Integer getNiveauHotelDeVilleNecessaireConstruction() {
		return niveauHotelDeVilleNecessaireConstruction;
	}

	/**
	 * @param niveauHotelDeVilleNecessaireConstruction the
	 *                                                 niveauHotelDeVilleNecessaireConstruction
	 *                                                 to set
	 */
	public void setNiveauHotelDeVilleNecessaireConstruction(Integer niveauHotelDeVilleNecessaireConstruction) {
		this.niveauHotelDeVilleNecessaireConstruction = niveauHotelDeVilleNecessaireConstruction;
	}

	/**
	 * @return the quantiteeStockagePierre
	 */
	public Long getQuantiteeStockagePierre() {
		return quantiteeStockagePierre;
	}

	/**
	 * @param quantiteeStockagePierre the quantiteeStockagePierre to set
	 */
	public void setQuantiteeStockagePierre(Long quantiteeStockagePierre) {
		this.quantiteeStockagePierre = quantiteeStockagePierre;
	}

	/**
	 * @return the quantiteeStockageBois
	 */
	public Long getQuantiteeStockageBois() {
		return quantiteeStockageBois;
	}

	/**
	 * @param quantiteeStockageBois the quantiteeStockageBois to set
	 */
	public void setQuantiteeStockageBois(Long quantiteeStockageBois) {
		this.quantiteeStockageBois = quantiteeStockageBois;
	}

	/**
	 * @return the quantiteeStockageOre
	 */
	public Long getQuantiteeStockageOre() {
		return quantiteeStockageOre;
	}

	/**
	 * @param quantiteeStockageOre the quantiteeStockageOre to set
	 */
	public void setQuantiteeStockageOre(Long quantiteeStockageOre) {
		this.quantiteeStockageOre = quantiteeStockageOre;
	}

	/**
	 * @return the quantiteeStockageNourriture
	 */
	public Long getQuantiteeStockageNourriture() {
		return quantiteeStockageNourriture;
	}

	/**
	 * @param quantiteeStockageNourriture the quantiteeStockageNourriture to set
	 */
	public void setQuantiteeStockageNourriture(Long quantiteeStockageNourriture) {
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

	/**
	 * @return the multiplicateurApport
	 */
	public Double getMultiplicateurApport() {
		return multiplicateurApport;
	}

	/**
	 * @param multiplicateurApport the multiplicateurApport to set
	 */
	public void setMultiplicateurApport(Double multiplicateurApport) {
		this.multiplicateurApport = multiplicateurApport;
	}

	/**
	 * @return the multiplicateurCout
	 */
	public Double getMultiplicateurCout() {
		return multiplicateurCout;
	}

	/**
	 * @param multiplicateurCout the multiplicateurCout to set
	 */
	public void setMultiplicateurCout(Double multiplicateurCout) {
		this.multiplicateurCout = multiplicateurCout;
	}

	/**
	 * @return the multiplicateurTemps
	 */
	public Double getMultiplicateurTemps() {
		return multiplicateurTemps;
	}

	/**
	 * @param multiplicateurTemps the multiplicateurTemps to set
	 */
	public void setMultiplicateurTemps(Double multiplicateurTemps) {
		this.multiplicateurTemps = multiplicateurTemps;
	}

	/**
	 * @return the apportExperience
	 */
	public Long getApportExperience() {
		return apportExperience;
	}

	/**
	 * @param apportExperience the apportExperience to set
	 */
	public void setApportExperience(Long apportExperience) {
		this.apportExperience = apportExperience;
	}

	/**
	 * @return the multiplicateurExperience
	 */
	public Double getMultiplicateurExperience() {
		return multiplicateurExperience;
	}

	/**
	 * @param multiplicateurExperience the multiplicateurExperience to set
	 */
	public void setMultiplicateurExperience(Double multiplicateurExperience) {
		this.multiplicateurExperience = multiplicateurExperience;
	}

}
