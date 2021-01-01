package dev.controller.dto;

import dev.entites.Joueur;
import dev.entites.batiment.Batiment;
import dev.entites.joueur.BatimentJoueur;

public class BatimentJoueurDto {

    private Integer id;
   
    private Joueur joueur;
    
    private Batiment batiment;
    
    /** niveau du batiment **/
    private Integer niveau;

    /** nombre ouvriers necessaire pour l'amélioration du batiment **/
    private Integer ouvrierNecessaireAmelioration;

    /** temps d'amelioration du batiment **/
    private Integer tempsAmelioration;

    /** coût en pierre amelioration du batiment **/
    private Integer coutPierreAmelioration;

    /** coût en bois amelioration du batiment **/
    private Integer coutBoisAmelioration;
    
    /** coût en or amelioration du batiment **/
    private Integer coutOrAmelioration;

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

    /** nombre d'exploitants actuel actifs sur le bâtiment **/
    private Integer nombreExploitantsActif;
    
    /** montant de l'apport de ressource par heure (pour 100% exploitants) **/
    private Integer apportRessourceHeure;

    public BatimentJoueurDto() {
    	
    }
	/**
	 * @param joueur
	 * @param batiment
	 * @param niveau
	 * @param ouvrierNecessaireAmelioration
	 * @param tempsAmelioration
	 * @param coutPierreAmelioration
	 * @param coutBoisAmelioration
	 * @param coutOrAmelioration
	 * @param coutNourritureAmelioration
	 * @param quantiteeStockagePierre
	 * @param quantiteeStockageBois
	 * @param quantiteeStockageOr
	 * @param quantiteeStockageNourriture
	 * @param nombreExploitantsAutorise
	 * @param nombreExploitantsActif
	 * @param apportRessourceHeure
	 */
	public BatimentJoueurDto(Joueur joueur, Batiment batiment, Integer niveau, Integer nombreExploitantsActif ) {
		this.joueur = joueur;
		this.batiment = batiment;
		this.niveau = niveau;
	
		switch (batiment.getIdTypeBatiment()) {
		// Hotel de ville
		case 1:
			// Hotel de ville	
			this.ouvrierNecessaireAmelioration = 99*this.niveau;
			this.tempsAmelioration = 99*this.niveau;
			this.coutPierreAmelioration = 99*this.niveau;
			this.coutBoisAmelioration = 99*this.niveau;
			this.coutOrAmelioration = 99*this.niveau;
			this.coutNourritureAmelioration = 99*this.niveau;
			this.quantiteeStockagePierre = 99*this.niveau;
			this.quantiteeStockageBois = 99*this.niveau;
			this.quantiteeStockageOr = 99*this.niveau;
			this.quantiteeStockageNourriture = 99*this.niveau;
			this.nombreExploitantsAutorise = 0;
			this.nombreExploitantsActif = 0;
			// ??????????????????????
			this.apportRessourceHeure = 0;
			break;
		case 2:
			// Chaumière
			this.ouvrierNecessaireAmelioration = 99*this.niveau;
			this.tempsAmelioration = 99*this.niveau;
			this.coutPierreAmelioration = 99*this.niveau;
			this.coutBoisAmelioration = 99*this.niveau;
			this.coutOrAmelioration = 99*this.niveau;
			this.coutNourritureAmelioration = 99*this.niveau;
			this.quantiteeStockagePierre = 0;
			this.quantiteeStockageBois = 0;
			this.quantiteeStockageOr = 0;
			this.quantiteeStockageNourriture = 0;
			this.nombreExploitantsAutorise = 99*this.niveau;
			this.nombreExploitantsActif = nombreExploitantsActif;
			// ??????????????????????
			this.apportRessourceHeure = ((99*this.niveau)*(nombreExploitantsActif))/this.nombreExploitantsAutorise;
			break;
		case 3:
			// Carrière
			this.ouvrierNecessaireAmelioration = 99*this.niveau;
			this.tempsAmelioration = 99*this.niveau;
			this.coutPierreAmelioration = 99*this.niveau;
			this.coutBoisAmelioration = 99*this.niveau;
			this.coutOrAmelioration = 99*this.niveau;
			this.coutNourritureAmelioration = 99*this.niveau;
			this.quantiteeStockagePierre = 0;
			this.quantiteeStockageBois = 0;
			this.quantiteeStockageOr = 0;
			this.quantiteeStockageNourriture = 0;
			this.nombreExploitantsAutorise = 99*this.niveau;
			this.nombreExploitantsActif = nombreExploitantsActif;
			// ??????????????????????
			this.apportRessourceHeure = ((99*this.niveau)*(nombreExploitantsActif))/this.nombreExploitantsAutorise;
			break;
		case 4:
			// Camp de bucheron
			this.ouvrierNecessaireAmelioration = 99*this.niveau;
			this.tempsAmelioration = 99*this.niveau;
			this.coutPierreAmelioration = 99*this.niveau;
			this.coutBoisAmelioration = 99*this.niveau;
			this.coutOrAmelioration = 99*this.niveau;
			this.coutNourritureAmelioration = 99*this.niveau;
			this.quantiteeStockagePierre = 0;
			this.quantiteeStockageBois = 0;
			this.quantiteeStockageOr = 0;
			this.quantiteeStockageNourriture = 0;
			this.nombreExploitantsAutorise = 99*this.niveau;
			this.nombreExploitantsActif = nombreExploitantsActif;
			// ??????????????????????
			this.apportRessourceHeure = ((99*this.niveau)*(nombreExploitantsActif))/this.nombreExploitantsAutorise;
			break;
		case 5:
			// Camp de mineur
			this.ouvrierNecessaireAmelioration = 99*this.niveau;
			this.tempsAmelioration = 99*this.niveau;
			this.coutPierreAmelioration = 99*this.niveau;
			this.coutBoisAmelioration = 99*this.niveau;
			this.coutOrAmelioration = 99*this.niveau;
			this.coutNourritureAmelioration = 99*this.niveau;
			this.quantiteeStockagePierre = 0;
			this.quantiteeStockageBois = 0;
			this.quantiteeStockageOr = 0;
			this.quantiteeStockageNourriture = 0;
			this.nombreExploitantsAutorise = 99*this.niveau;
			this.nombreExploitantsActif = nombreExploitantsActif;
			// ??????????????????????
			this.apportRessourceHeure = ((99*this.niveau)*(nombreExploitantsActif))/this.nombreExploitantsAutorise;
			break;
		case 6:
			// Ferme
			this.ouvrierNecessaireAmelioration = 0;
			this.tempsAmelioration = 0;
			this.coutPierreAmelioration = 0;
			this.coutBoisAmelioration = 0;
			this.coutOrAmelioration = 0;
			this.coutNourritureAmelioration = 0;
			this.quantiteeStockagePierre = 0;
			this.quantiteeStockageBois = 0;
			this.quantiteeStockageOr = 0;
			this.quantiteeStockageNourriture = 0;
			this.nombreExploitantsAutorise = 0;
			this.nombreExploitantsActif = 0;
			this.apportRessourceHeure = 0;
			break;
		case 7:
			// Entrepot (Stockage Pierre)
			this.ouvrierNecessaireAmelioration = 99*this.niveau;
			this.tempsAmelioration = 99*this.niveau;
			this.coutPierreAmelioration = 99*this.niveau;
			this.coutBoisAmelioration = 99*this.niveau;
			this.coutOrAmelioration = 99*this.niveau;
			this.coutNourritureAmelioration = 99*this.niveau;
			this.quantiteeStockagePierre = 99*this.niveau;
			this.quantiteeStockageBois = 0;
			this.quantiteeStockageOr = 0;
			this.quantiteeStockageNourriture = 0;
			this.nombreExploitantsAutorise = 0;
			this.nombreExploitantsActif = 0;
			this.apportRessourceHeure = 0;
			break;
		case 8:
			// Scierie (Stockage Bois)
			this.ouvrierNecessaireAmelioration = 99*this.niveau;
			this.tempsAmelioration = 99*this.niveau;
			this.coutPierreAmelioration = 99*this.niveau;
			this.coutBoisAmelioration = 99*this.niveau;
			this.coutOrAmelioration = 99*this.niveau;
			this.coutNourritureAmelioration = 99*this.niveau;
			this.quantiteeStockagePierre = 0;
			this.quantiteeStockageBois = 99*this.niveau;
			this.quantiteeStockageOr = 0;
			this.quantiteeStockageNourriture = 0;
			this.nombreExploitantsAutorise = 0;
			this.nombreExploitantsActif = 0;
			this.apportRessourceHeure = 0;
			break;
		case 9:
			// Banque (Stockage Or)
			this.ouvrierNecessaireAmelioration = 99*this.niveau;
			this.tempsAmelioration = 99*this.niveau;
			this.coutPierreAmelioration = 99*this.niveau;
			this.coutBoisAmelioration = 99*this.niveau;
			this.coutOrAmelioration = 99*this.niveau;
			this.coutNourritureAmelioration = 99*this.niveau;
			this.quantiteeStockagePierre = 0;
			this.quantiteeStockageBois = 0;
			this.quantiteeStockageOr = 99*this.niveau;
			this.quantiteeStockageNourriture = 0;
			this.nombreExploitantsAutorise = 0;
			this.nombreExploitantsActif = 0;
			this.apportRessourceHeure = 0;
			break;
		case 10:
			// Grenier (Stockage Nourriture)
			this.ouvrierNecessaireAmelioration = 99*this.niveau;
			this.tempsAmelioration = 99*this.niveau;
			this.coutPierreAmelioration = 99*this.niveau;
			this.coutBoisAmelioration = 99*this.niveau;
			this.coutOrAmelioration = 99*this.niveau;
			this.coutNourritureAmelioration = 99*this.niveau;
			this.quantiteeStockagePierre = 0;
			this.quantiteeStockageBois = 0;
			this.quantiteeStockageOr = 0;
			this.quantiteeStockageNourriture = 99*this.niveau;
			this.nombreExploitantsAutorise = 0;
			this.nombreExploitantsActif = 0;
			this.apportRessourceHeure = 0;
			break;
		case 11:
			// Caserne Militaire
			this.ouvrierNecessaireAmelioration = 99*this.niveau;
			this.tempsAmelioration = 99*this.niveau;
			this.coutPierreAmelioration = 99*this.niveau;
			this.coutBoisAmelioration = 99*this.niveau;
			this.coutOrAmelioration = 99*this.niveau;
			this.coutNourritureAmelioration = 99*this.niveau;
			this.quantiteeStockagePierre = 0;
			this.quantiteeStockageBois = 0;
			this.quantiteeStockageOr = 0;
			this.quantiteeStockageNourriture = 0;
			this.nombreExploitantsAutorise = 0;
			this.nombreExploitantsActif = 0;
			this.apportRessourceHeure = 0;
			break;
		case 12:
			// Ecurie
			this.ouvrierNecessaireAmelioration = 99*this.niveau;
			this.tempsAmelioration = 99*this.niveau;
			this.coutPierreAmelioration = 99*this.niveau;
			this.coutBoisAmelioration = 99*this.niveau;
			this.coutOrAmelioration = 99*this.niveau;
			this.coutNourritureAmelioration = 99*this.niveau;
			this.quantiteeStockagePierre = 0;
			this.quantiteeStockageBois = 0;
			this.quantiteeStockageOr = 0;
			this.quantiteeStockageNourriture = 0;
			this.nombreExploitantsAutorise = 0;
			this.nombreExploitantsActif = 0;
			this.apportRessourceHeure = 0;
			break;
		case 13:
			// Port
			this.ouvrierNecessaireAmelioration = 99*this.niveau;
			this.tempsAmelioration = 99*this.niveau;
			this.coutPierreAmelioration = 99*this.niveau;
			this.coutBoisAmelioration = 99*this.niveau;
			this.coutOrAmelioration = 99*this.niveau;
			this.coutNourritureAmelioration = 99*this.niveau;
			this.quantiteeStockagePierre = 0;
			this.quantiteeStockageBois = 0;
			this.quantiteeStockageOr = 0;
			this.quantiteeStockageNourriture = 0;
			this.nombreExploitantsAutorise = 0;
			this.nombreExploitantsActif = 0;
			this.apportRessourceHeure = 0;
			break;
		case 14:
			// Atelier de siege
			this.ouvrierNecessaireAmelioration = 99*this.niveau;
			this.tempsAmelioration = 99*this.niveau;
			this.coutPierreAmelioration = 99*this.niveau;
			this.coutBoisAmelioration = 99*this.niveau;
			this.coutOrAmelioration = 99*this.niveau;
			this.coutNourritureAmelioration = 99*this.niveau;
			this.quantiteeStockagePierre = 0;
			this.quantiteeStockageBois = 0;
			this.quantiteeStockageOr = 0;
			this.quantiteeStockageNourriture = 0;
			this.nombreExploitantsAutorise = 0;
			this.nombreExploitantsActif = 0;
			this.apportRessourceHeure = 0;
			break;
		case 15:
			// Forge
			this.ouvrierNecessaireAmelioration = 99*this.niveau;
			this.tempsAmelioration = 99*this.niveau;
			this.coutPierreAmelioration = 99*this.niveau;
			this.coutBoisAmelioration = 99*this.niveau;
			this.coutOrAmelioration = 99*this.niveau;
			this.coutNourritureAmelioration = 99*this.niveau;
			this.quantiteeStockagePierre = 0;
			this.quantiteeStockageBois = 0;
			this.quantiteeStockageOr = 0;
			this.quantiteeStockageNourriture = 0;
			this.nombreExploitantsAutorise = 0;
			this.nombreExploitantsActif = 0;
			this.apportRessourceHeure = 0;
			break;
		case 16:
			// Universite
			this.ouvrierNecessaireAmelioration = 99*this.niveau;
			this.tempsAmelioration = 99*this.niveau;
			this.coutPierreAmelioration = 99*this.niveau;
			this.coutBoisAmelioration = 99*this.niveau;
			this.coutOrAmelioration = 99*this.niveau;
			this.coutNourritureAmelioration = 99*this.niveau;
			this.quantiteeStockagePierre = 0;
			this.quantiteeStockageBois = 0;
			this.quantiteeStockageOr = 0;
			this.quantiteeStockageNourriture = 0;
			this.nombreExploitantsAutorise = 0;
			this.nombreExploitantsActif = 0;
			this.apportRessourceHeure = 0;
			break;
		case 17:
			// Marché
			this.ouvrierNecessaireAmelioration = 99*this.niveau;
			this.tempsAmelioration = 99*this.niveau;
			this.coutPierreAmelioration = 99*this.niveau;
			this.coutBoisAmelioration = 99*this.niveau;
			this.coutOrAmelioration = 99*this.niveau;
			this.coutNourritureAmelioration = 99*this.niveau;
			this.quantiteeStockagePierre = 0;
			this.quantiteeStockageBois = 0;
			this.quantiteeStockageOr = 0;
			this.quantiteeStockageNourriture = 0;
			this.nombreExploitantsAutorise = 0;
			this.nombreExploitantsActif = 0;
			this.apportRessourceHeure = 0;
			break;
		case 18:
			// Table d'expéditions
			this.ouvrierNecessaireAmelioration = 99*this.niveau;
			this.tempsAmelioration = 99*this.niveau;
			this.coutPierreAmelioration = 99*this.niveau;
			this.coutBoisAmelioration = 99*this.niveau;
			this.coutOrAmelioration = 99*this.niveau;
			this.coutNourritureAmelioration = 99*this.niveau;
			this.quantiteeStockagePierre = 0;
			this.quantiteeStockageBois = 0;
			this.quantiteeStockageOr = 0;
			this.quantiteeStockageNourriture = 0;
			this.nombreExploitantsAutorise = 0;
			this.nombreExploitantsActif = 0;
			this.apportRessourceHeure = 0;
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
	 * @return the idJoueur
	 */
	public Joueur getJoueur() {
		return joueur;
	}
	/**
	 * @param idJoueur the idJoueur to set
	 */
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}
	/**
	 * @return the idBatiment
	 */
	public Batiment getBatiment() {
		return batiment;
	}
	/**
	 * @param idBatiment the idBatiment to set
	 */
	public void setBatiment(Batiment batiment) {
		this.batiment = batiment;
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
	 * @return the ouvrierNecessaireAmelioration
	 */
	public Integer getOuvrierNecessaireAmelioration() {
		return ouvrierNecessaireAmelioration;
	}
	/**
	 * @param ouvrierNecessaireAmelioration the ouvrierNecessaireAmelioration to set
	 */
	public void setOuvrierNecessaireAmelioration(Integer ouvrierNecessaireAmelioration) {
		this.ouvrierNecessaireAmelioration = ouvrierNecessaireAmelioration;
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
	 * @return the nombreExploitantsActif
	 */
	public Integer getNombreExploitantsActif() {
		return nombreExploitantsActif;
	}
	/**
	 * @param nombreExploitantsActif the nombreExploitantsActif to set
	 */
	public void setNombreExploitantsActif(Integer nombreExploitantsActif) {
		this.nombreExploitantsActif = nombreExploitantsActif;
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

	
    
    
}
