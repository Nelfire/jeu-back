package dev.controller.dto.batiment;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import dev.entites.batiment.Batiment;
import dev.entites.joueur.Joueur;

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
	private Integer coutOreAmelioration;
	
	/** coût en nourriture amelioration du batiment **/
	private Integer coutNourritureAmelioration;
	
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
	
	private Long dateDebutConstruction;
	private Long dateFinConstruction;

    public BatimentJoueurDto() {
    	
    }

	/**
	 * @param id
	 * @param joueur
	 * @param batiment
	 * @param niveau
	 * @param ouvrierNecessaireAmelioration
	 * @param tempsAmelioration
	 * @param coutPierreAmelioration
	 * @param coutBoisAmelioration
	 * @param coutOreAmelioration
	 * @param coutNourritureAmelioration
	 * @param quantiteeStockagePierre
	 * @param quantiteeStockageBois
	 * @param quantiteeStockageOre
	 * @param quantiteeStockageNourriture
	 * @param apportPierreHeure
	 * @param apportBoisHeure
	 * @param apportOreHeure
	 * @param apportNourritureHeure
	 * @param dateDebutConstruction
	 * @param dateFinConstruction
	 */
	public BatimentJoueurDto(Integer id, Joueur joueur, Batiment batiment, Integer niveau,
			Integer ouvrierNecessaireAmelioration, Integer tempsAmelioration, Integer coutPierreAmelioration,
			Integer coutBoisAmelioration, Integer coutOreAmelioration, Integer coutNourritureAmelioration,
			Integer quantiteeStockagePierre, Integer quantiteeStockageBois, Integer quantiteeStockageOre,
			Integer quantiteeStockageNourriture, Integer apportPierreHeure, Integer apportBoisHeure,
			Integer apportOreHeure, Integer apportNourritureHeure, Long dateDebutConstruction,
			Long dateFinConstruction) {
		super();
		this.id = id;
		this.joueur = joueur;
		this.batiment = batiment;
		this.niveau = niveau;
		this.ouvrierNecessaireAmelioration = ouvrierNecessaireAmelioration;
		this.tempsAmelioration = tempsAmelioration;
		this.coutPierreAmelioration = coutPierreAmelioration;
		this.coutBoisAmelioration = coutBoisAmelioration;
		this.coutOreAmelioration = coutOreAmelioration;
		this.coutNourritureAmelioration = coutNourritureAmelioration;
		this.quantiteeStockagePierre = quantiteeStockagePierre;
		this.quantiteeStockageBois = quantiteeStockageBois;
		this.quantiteeStockageOre = quantiteeStockageOre;
		this.quantiteeStockageNourriture = quantiteeStockageNourriture;
		this.apportPierreHeure = apportPierreHeure;
		this.apportBoisHeure = apportBoisHeure;
		this.apportOreHeure = apportOreHeure;
		this.apportNourritureHeure = apportNourritureHeure;
		this.dateDebutConstruction = dateDebutConstruction;
		this.dateFinConstruction = dateFinConstruction;
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
	 * @return the joueur
	 */
	public Joueur getJoueur() {
		return joueur;
	}

	/**
	 * @param joueur the joueur to set
	 */
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	/**
	 * @return the batiment
	 */
	public Batiment getBatiment() {
		return batiment;
	}

	/**
	 * @param batiment the batiment to set
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
	 * @return the coutOreAmelioration
	 */
	public Integer getCoutOreAmelioration() {
		return coutOreAmelioration;
	}

	/**
	 * @param coutOreAmelioration the coutOreAmelioration to set
	 */
	public void setCoutOreAmelioration(Integer coutOreAmelioration) {
		this.coutOreAmelioration = coutOreAmelioration;
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

	/**
	 * @return the dateDebutConstruction
	 */
	public Long getDateDebutConstruction() {
		return dateDebutConstruction;
	}

	/**
	 * @param dateDebutConstruction the dateDebutConstruction to set
	 */
	public void setDateDebutConstruction(Long dateDebutConstruction) {
		this.dateDebutConstruction = dateDebutConstruction;
	}

	/**
	 * @return the dateFinConstruction
	 */
	public Long getDateFinConstruction() {
		return dateFinConstruction;
	}

	/**
	 * @param dateFinConstruction the dateFinConstruction to set
	 */
	public void setDateFinConstruction(Long dateFinConstruction) {
		this.dateFinConstruction = dateFinConstruction;
	}
    
    
	
    
}
