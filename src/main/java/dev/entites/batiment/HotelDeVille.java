package dev.entites.batiment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HotelDeVille {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /** type de batiment : 
     * 1 = hotel de ville,
     *  **/
    private final Integer idTypeBatiment = 1;
    
    /** icone du batiment **/
    private final String icone = "https://marcdekeister.files.wordpress.com/2018/09/dessin-hocc82tel-de-ville-de-paris.jpg";
    
    /** nom du batiment **/
    private final String libelle = "Hotel de Ville";
    
    /** descriptif du batiment **/
    private final String descriptif = "Le descriptif de l'hotel de ville";
    
    /** niveau du batiment **/
    private String niveau;
    
    /** coût en pierre du batiment **/
    private Integer coutPierre;
    
    /** coût en bois du batiment **/
    private Integer coutBois;
    
    /** coût en or du batiment **/
    private Integer coutOr;
    
    /** coût en nourriture du batiment **/
    private Integer coutNourriture;
    
    /** nombre de villageois necessaires pour l'amélioration du batiment **/
    private Integer villageoisNecessaireAmelioration;
    
    /** temps en seconde necessaire à l'amélioration du batiment**/
    private Integer tempsAmelioration;
    
    /** quantitée de pierre stockable dans la chambre forte du batiment**/
    private Integer quantiteeStockagePierreChambreForte;
    
    /** quantitée de bois stockable dans la chambre forte du batiment**/
    private Integer quantiteeStockageBoisChambreForte;
    
    /** quantitée d'or stockable dans la chambre forte du batiment**/
    private Integer quantiteeStockageOrChambreForte;
    
    /** quantitée de nourriture stockable dans la chambre forte du batiment**/
    private Integer quantiteeStockageNourritureChambreForte;
    
    /** nombre maximal de chaumière possible à construire **/
    private Integer nombreMaximalBatimentChaumiere;
    
    /** nombre maximal de carrière possible à construire **/
    private Integer nombreMaximalBatimentCarriere;
    
    /** nombre maximal de camp de bucheron possible à construire **/
    private Integer nombreMaximalBatimentCampDeBucheron;
    
    /** nombre maximal de camp de mineur possible à construire **/
    private Integer nombreMaximalBatimentCampDeMineur;
    
    /** nombre maximal de ferme possible à construire **/
    private Integer nombreMaximalBatimentFerme;
    
    /** nombre maximal d'entrepot possible à construire **/
    private Integer nombreMaximalBatimentEntrepot;
    
    /** nombre maximal de scierie possible à construire **/
    private Integer nombreMaximalBatimentScierie;
    
    /** nombre maximal de banque possible à construire **/
    private Integer nombreMaximalBatimentBanque;
    
    /** nombre maximal de grenier possible à construire **/
    private Integer nombreMaximalBatimentGrenier;
    
    /** nombre maximal de port possible à construire **/
    private Integer nombreMaximalBatimentPort;
    
    /** nombre maximal de caserne millitaire possible à construire **/
    private Integer nombreMaximalBatimentCaserneMillitaire;
    
    /** nombre maximal d'atelier de siège possible à construire **/
    private Integer nombreMaximalBatimentAtelierDeSiege;
    
    /** nombre maximal de forge possible à construire **/
    private Integer nombreMaximalBatimentForge;
    
    /** nombre maximal d'université possible à construire **/
    private Integer nombreMaximalBatimentUniversite;
    
    /** nombre maximal de table de mission possible à construire **/
    private Integer nombreMaximalTableDeMission;
    
    public HotelDeVille() {
    	
    }

	/**
	 * @param niveau
	 * @param coutPierre
	 * @param coutBois
	 * @param coutOr
	 * @param coutNourriture
	 * @param villageoisNecessaireAmelioration
	 * @param tempsAmelioration
	 * @param quantiteeStockagePierreChambreForte
	 * @param quantiteeStockageBoisChambreForte
	 * @param quantiteeStockageOrChambreForte
	 * @param quantiteeStockageNourritureChambreForte
	 * @param nombreMaximalBatimentChaumiere
	 * @param nombreMaximalBatimentCarriere
	 * @param nombreMaximalBatimentCampDeBucheron
	 * @param nombreMaximalBatimentCampDeMineur
	 * @param nombreMaximalBatimentFerme
	 * @param nombreMaximalBatimentEntrepot
	 * @param nombreMaximalBatimentScierie
	 * @param nombreMaximalBatimentBanque
	 * @param nombreMaximalBatimentGrenier
	 * @param nombreMaximalBatimentPort
	 * @param nombreMaximalBatimentCaserneMillitaire
	 * @param nombreMaximalBatimentAtelierDeSiege
	 * @param nombreMaximalBatimentForge
	 * @param nombreMaximalBatimentUniversite
	 * @param nombreMaximalTableDeMission
	 */
	public HotelDeVille(String niveau, Integer coutPierre, Integer coutBois, Integer coutOr,
			Integer coutNourriture, Integer villageoisNecessaireAmelioration, Integer tempsAmelioration,
			Integer quantiteeStockagePierreChambreForte, Integer quantiteeStockageBoisChambreForte,
			Integer quantiteeStockageOrChambreForte, Integer quantiteeStockageNourritureChambreForte,
			Integer nombreMaximalBatimentChaumiere, Integer nombreMaximalBatimentCarriere,
			Integer nombreMaximalBatimentCampDeBucheron, Integer nombreMaximalBatimentCampDeMineur,
			Integer nombreMaximalBatimentFerme, Integer nombreMaximalBatimentEntrepot,
			Integer nombreMaximalBatimentScierie, Integer nombreMaximalBatimentBanque,
			Integer nombreMaximalBatimentGrenier, Integer nombreMaximalBatimentPort,
			Integer nombreMaximalBatimentCaserneMillitaire, Integer nombreMaximalBatimentAtelierDeSiege,
			Integer nombreMaximalBatimentForge, Integer nombreMaximalBatimentUniversite,
			Integer nombreMaximalTableDeMission) {
		super();
		this.niveau = niveau;
		this.coutPierre = coutPierre;
		this.coutBois = coutBois;
		this.coutOr = coutOr;
		this.coutNourriture = coutNourriture;
		this.villageoisNecessaireAmelioration = villageoisNecessaireAmelioration;
		this.tempsAmelioration = tempsAmelioration;
		this.quantiteeStockagePierreChambreForte = quantiteeStockagePierreChambreForte;
		this.quantiteeStockageBoisChambreForte = quantiteeStockageBoisChambreForte;
		this.quantiteeStockageOrChambreForte = quantiteeStockageOrChambreForte;
		this.quantiteeStockageNourritureChambreForte = quantiteeStockageNourritureChambreForte;
		this.nombreMaximalBatimentChaumiere = nombreMaximalBatimentChaumiere;
		this.nombreMaximalBatimentCarriere = nombreMaximalBatimentCarriere;
		this.nombreMaximalBatimentCampDeBucheron = nombreMaximalBatimentCampDeBucheron;
		this.nombreMaximalBatimentCampDeMineur = nombreMaximalBatimentCampDeMineur;
		this.nombreMaximalBatimentFerme = nombreMaximalBatimentFerme;
		this.nombreMaximalBatimentEntrepot = nombreMaximalBatimentEntrepot;
		this.nombreMaximalBatimentScierie = nombreMaximalBatimentScierie;
		this.nombreMaximalBatimentBanque = nombreMaximalBatimentBanque;
		this.nombreMaximalBatimentGrenier = nombreMaximalBatimentGrenier;
		this.nombreMaximalBatimentPort = nombreMaximalBatimentPort;
		this.nombreMaximalBatimentCaserneMillitaire = nombreMaximalBatimentCaserneMillitaire;
		this.nombreMaximalBatimentAtelierDeSiege = nombreMaximalBatimentAtelierDeSiege;
		this.nombreMaximalBatimentForge = nombreMaximalBatimentForge;
		this.nombreMaximalBatimentUniversite = nombreMaximalBatimentUniversite;
		this.nombreMaximalTableDeMission = nombreMaximalTableDeMission;
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
	 * @return the niveau
	 */
	public String getNiveau() {
		return niveau;
	}

	/**
	 * @param niveau the niveau to set
	 */
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	/**
	 * @return the coutPierre
	 */
	public Integer getCoutPierre() {
		return coutPierre;
	}

	/**
	 * @param coutPierre the coutPierre to set
	 */
	public void setCoutPierre(Integer coutPierre) {
		this.coutPierre = coutPierre;
	}

	/**
	 * @return the coutBois
	 */
	public Integer getCoutBois() {
		return coutBois;
	}

	/**
	 * @param coutBois the coutBois to set
	 */
	public void setCoutBois(Integer coutBois) {
		this.coutBois = coutBois;
	}

	/**
	 * @return the coutOr
	 */
	public Integer getCoutOr() {
		return coutOr;
	}

	/**
	 * @param coutOr the coutOr to set
	 */
	public void setCoutOr(Integer coutOr) {
		this.coutOr = coutOr;
	}

	/**
	 * @return the coutNourriture
	 */
	public Integer getCoutNourriture() {
		return coutNourriture;
	}

	/**
	 * @param coutNourriture the coutNourriture to set
	 */
	public void setCoutNourriture(Integer coutNourriture) {
		this.coutNourriture = coutNourriture;
	}

	/**
	 * @return the villageoisNecessaireAmelioration
	 */
	public Integer getVillageoisNecessaireAmelioration() {
		return villageoisNecessaireAmelioration;
	}

	/**
	 * @param villageoisNecessaireAmelioration the villageoisNecessaireAmelioration to set
	 */
	public void setVillageoisNecessaireAmelioration(Integer villageoisNecessaireAmelioration) {
		this.villageoisNecessaireAmelioration = villageoisNecessaireAmelioration;
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
	 * @return the quantiteeStockagePierreChambreForte
	 */
	public Integer getQuantiteeStockagePierreChambreForte() {
		return quantiteeStockagePierreChambreForte;
	}

	/**
	 * @param quantiteeStockagePierreChambreForte the quantiteeStockagePierreChambreForte to set
	 */
	public void setQuantiteeStockagePierreChambreForte(Integer quantiteeStockagePierreChambreForte) {
		this.quantiteeStockagePierreChambreForte = quantiteeStockagePierreChambreForte;
	}

	/**
	 * @return the quantiteeStockageBoisChambreForte
	 */
	public Integer getQuantiteeStockageBoisChambreForte() {
		return quantiteeStockageBoisChambreForte;
	}

	/**
	 * @param quantiteeStockageBoisChambreForte the quantiteeStockageBoisChambreForte to set
	 */
	public void setQuantiteeStockageBoisChambreForte(Integer quantiteeStockageBoisChambreForte) {
		this.quantiteeStockageBoisChambreForte = quantiteeStockageBoisChambreForte;
	}

	/**
	 * @return the quantiteeStockageOrChambreForte
	 */
	public Integer getQuantiteeStockageOrChambreForte() {
		return quantiteeStockageOrChambreForte;
	}

	/**
	 * @param quantiteeStockageOrChambreForte the quantiteeStockageOrChambreForte to set
	 */
	public void setQuantiteeStockageOrChambreForte(Integer quantiteeStockageOrChambreForte) {
		this.quantiteeStockageOrChambreForte = quantiteeStockageOrChambreForte;
	}

	/**
	 * @return the quantiteeStockageNourritureChambreForte
	 */
	public Integer getQuantiteeStockageNourritureChambreForte() {
		return quantiteeStockageNourritureChambreForte;
	}

	/**
	 * @param quantiteeStockageNourritureChambreForte the quantiteeStockageNourritureChambreForte to set
	 */
	public void setQuantiteeStockageNourritureChambreForte(Integer quantiteeStockageNourritureChambreForte) {
		this.quantiteeStockageNourritureChambreForte = quantiteeStockageNourritureChambreForte;
	}

	/**
	 * @return the nombreMaximalBatimentChaumiere
	 */
	public Integer getNombreMaximalBatimentChaumiere() {
		return nombreMaximalBatimentChaumiere;
	}

	/**
	 * @param nombreMaximalBatimentChaumiere the nombreMaximalBatimentChaumiere to set
	 */
	public void setNombreMaximalBatimentChaumiere(Integer nombreMaximalBatimentChaumiere) {
		this.nombreMaximalBatimentChaumiere = nombreMaximalBatimentChaumiere;
	}

	/**
	 * @return the nombreMaximalBatimentCarriere
	 */
	public Integer getNombreMaximalBatimentCarriere() {
		return nombreMaximalBatimentCarriere;
	}

	/**
	 * @param nombreMaximalBatimentCarriere the nombreMaximalBatimentCarriere to set
	 */
	public void setNombreMaximalBatimentCarriere(Integer nombreMaximalBatimentCarriere) {
		this.nombreMaximalBatimentCarriere = nombreMaximalBatimentCarriere;
	}

	/**
	 * @return the nombreMaximalBatimentCampDeBucheron
	 */
	public Integer getNombreMaximalBatimentCampDeBucheron() {
		return nombreMaximalBatimentCampDeBucheron;
	}

	/**
	 * @param nombreMaximalBatimentCampDeBucheron the nombreMaximalBatimentCampDeBucheron to set
	 */
	public void setNombreMaximalBatimentCampDeBucheron(Integer nombreMaximalBatimentCampDeBucheron) {
		this.nombreMaximalBatimentCampDeBucheron = nombreMaximalBatimentCampDeBucheron;
	}

	/**
	 * @return the nombreMaximalBatimentCampDeMineur
	 */
	public Integer getNombreMaximalBatimentCampDeMineur() {
		return nombreMaximalBatimentCampDeMineur;
	}

	/**
	 * @param nombreMaximalBatimentCampDeMineur the nombreMaximalBatimentCampDeMineur to set
	 */
	public void setNombreMaximalBatimentCampDeMineur(Integer nombreMaximalBatimentCampDeMineur) {
		this.nombreMaximalBatimentCampDeMineur = nombreMaximalBatimentCampDeMineur;
	}

	/**
	 * @return the nombreMaximalBatimentFerme
	 */
	public Integer getNombreMaximalBatimentFerme() {
		return nombreMaximalBatimentFerme;
	}

	/**
	 * @param nombreMaximalBatimentFerme the nombreMaximalBatimentFerme to set
	 */
	public void setNombreMaximalBatimentFerme(Integer nombreMaximalBatimentFerme) {
		this.nombreMaximalBatimentFerme = nombreMaximalBatimentFerme;
	}

	/**
	 * @return the nombreMaximalBatimentEntrepot
	 */
	public Integer getNombreMaximalBatimentEntrepot() {
		return nombreMaximalBatimentEntrepot;
	}

	/**
	 * @param nombreMaximalBatimentEntrepot the nombreMaximalBatimentEntrepot to set
	 */
	public void setNombreMaximalBatimentEntrepot(Integer nombreMaximalBatimentEntrepot) {
		this.nombreMaximalBatimentEntrepot = nombreMaximalBatimentEntrepot;
	}

	/**
	 * @return the nombreMaximalBatimentScierie
	 */
	public Integer getNombreMaximalBatimentScierie() {
		return nombreMaximalBatimentScierie;
	}

	/**
	 * @param nombreMaximalBatimentScierie the nombreMaximalBatimentScierie to set
	 */
	public void setNombreMaximalBatimentScierie(Integer nombreMaximalBatimentScierie) {
		this.nombreMaximalBatimentScierie = nombreMaximalBatimentScierie;
	}

	/**
	 * @return the nombreMaximalBatimentBanque
	 */
	public Integer getNombreMaximalBatimentBanque() {
		return nombreMaximalBatimentBanque;
	}

	/**
	 * @param nombreMaximalBatimentBanque the nombreMaximalBatimentBanque to set
	 */
	public void setNombreMaximalBatimentBanque(Integer nombreMaximalBatimentBanque) {
		this.nombreMaximalBatimentBanque = nombreMaximalBatimentBanque;
	}

	/**
	 * @return the nombreMaximalBatimentGrenier
	 */
	public Integer getNombreMaximalBatimentGrenier() {
		return nombreMaximalBatimentGrenier;
	}

	/**
	 * @param nombreMaximalBatimentGrenier the nombreMaximalBatimentGrenier to set
	 */
	public void setNombreMaximalBatimentGrenier(Integer nombreMaximalBatimentGrenier) {
		this.nombreMaximalBatimentGrenier = nombreMaximalBatimentGrenier;
	}

	/**
	 * @return the nombreMaximalBatimentPort
	 */
	public Integer getNombreMaximalBatimentPort() {
		return nombreMaximalBatimentPort;
	}

	/**
	 * @param nombreMaximalBatimentPort the nombreMaximalBatimentPort to set
	 */
	public void setNombreMaximalBatimentPort(Integer nombreMaximalBatimentPort) {
		this.nombreMaximalBatimentPort = nombreMaximalBatimentPort;
	}

	/**
	 * @return the nombreMaximalBatimentCaserneMillitaire
	 */
	public Integer getNombreMaximalBatimentCaserneMillitaire() {
		return nombreMaximalBatimentCaserneMillitaire;
	}

	/**
	 * @param nombreMaximalBatimentCaserneMillitaire the nombreMaximalBatimentCaserneMillitaire to set
	 */
	public void setNombreMaximalBatimentCaserneMillitaire(Integer nombreMaximalBatimentCaserneMillitaire) {
		this.nombreMaximalBatimentCaserneMillitaire = nombreMaximalBatimentCaserneMillitaire;
	}

	/**
	 * @return the nombreMaximalBatimentAtelierDeSiege
	 */
	public Integer getNombreMaximalBatimentAtelierDeSiege() {
		return nombreMaximalBatimentAtelierDeSiege;
	}

	/**
	 * @param nombreMaximalBatimentAtelierDeSiege the nombreMaximalBatimentAtelierDeSiege to set
	 */
	public void setNombreMaximalBatimentAtelierDeSiege(Integer nombreMaximalBatimentAtelierDeSiege) {
		this.nombreMaximalBatimentAtelierDeSiege = nombreMaximalBatimentAtelierDeSiege;
	}

	/**
	 * @return the nombreMaximalBatimentForge
	 */
	public Integer getNombreMaximalBatimentForge() {
		return nombreMaximalBatimentForge;
	}

	/**
	 * @param nombreMaximalBatimentForge the nombreMaximalBatimentForge to set
	 */
	public void setNombreMaximalBatimentForge(Integer nombreMaximalBatimentForge) {
		this.nombreMaximalBatimentForge = nombreMaximalBatimentForge;
	}

	/**
	 * @return the nombreMaximalBatimentUniversite
	 */
	public Integer getNombreMaximalBatimentUniversite() {
		return nombreMaximalBatimentUniversite;
	}

	/**
	 * @param nombreMaximalBatimentUniversite the nombreMaximalBatimentUniversite to set
	 */
	public void setNombreMaximalBatimentUniversite(Integer nombreMaximalBatimentUniversite) {
		this.nombreMaximalBatimentUniversite = nombreMaximalBatimentUniversite;
	}

	/**
	 * @return the nombreMaximalTableDeMission
	 */
	public Integer getNombreMaximalTableDeMission() {
		return nombreMaximalTableDeMission;
	}

	/**
	 * @param nombreMaximalTableDeMission the nombreMaximalTableDeMission to set
	 */
	public void setNombreMaximalTableDeMission(Integer nombreMaximalTableDeMission) {
		this.nombreMaximalTableDeMission = nombreMaximalTableDeMission;
	}

	/**
	 * @return the idTypeBatiment
	 */
	public Integer getIdTypeBatiment() {
		return idTypeBatiment;
	}

	/**
	 * @return the icone
	 */
	public String getIcone() {
		return icone;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @return the descriptif
	 */
	public String getDescriptif() {
		return descriptif;
	}
    
	
    
}
