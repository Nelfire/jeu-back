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
    private Integer niveau;
    
    /** coût en pierre du batiment **/
    private Integer coutPierreAmelioration;
    
    /** coût en bois du batiment **/
    private Integer coutBoisAmelioration;
    
    /** coût en or du batiment **/
    private Integer coutOrAmelioration;
    
    /** coût en nourriture du batiment **/
    private Integer coutNourritureAmelioration;
    
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
	 * @param coutPierreAmelioration
	 * @param coutBoisAmelioration
	 * @param coutOrAmelioration
	 * @param coutNourritureAmelioration
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
	public HotelDeVille(Integer niveau,
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
	 * @return Retourne le niveau du bâtiment
	 */
	public Integer getNiveau() {
		return niveau;
	}

	/**
	 * @param Définir le niveau du bâtiment
	 */
	public void setNiveau(Integer niveau) {
		this.niveau = niveau;
	}

	/**
	 * @return Retourne le coût en pierre pour l'amélioration de 1 niveau du bâtiment
	 */
	public Integer getCoutPierreAmelioration() {
		return (this.niveau*this.niveau)*(10_000*this.niveau);
	}

	/**
	 * @param Défini le coût en pierre pour l'amélioration de 1 niveau du bâtiment
	 */
	public void setCoutPierreAmelioration(Integer coutPierreAmelioration) {
		this.coutPierreAmelioration = coutPierreAmelioration;
	}

	/**
	 * @return Retourne le coût en bois pour l'amélioration de 1 niveau du bâtiment
	 */
	public Integer getCoutBoisAmelioration() {
		return (this.niveau*this.niveau)*(10_000*this.niveau);
	}

	/**
	 * @param Défini le coût en bois pour l'amélioration de 1 niveau du bâtiment
	 */
	public void setCoutBoisAmelioration(Integer coutBoisAmelioration) {
		this.coutBoisAmelioration = coutBoisAmelioration;
	}

	/**
	 * @return Retourne le coût en or pour l'amélioration de 1 niveau du bâtiment
	 */
	public Integer getCoutOrAmelioration() {
		return (this.niveau*this.niveau)*(10_000*this.niveau);
	}

	/**
	 * @param Défini le coût en or pour l'amélioration de 1 niveau du bâtiment
	 */
	public void setCoutOrAmelioration(Integer coutOrAmelioration) {
		this.coutOrAmelioration = coutOrAmelioration;
	}

	/**
	 * @return Retourne le coût en nourriture pour l'amélioration de 1 niveau du bâtiment
	 */
	public Integer getCoutNourritureAmelioration() {
		return (this.niveau*this.niveau)*(10_000*this.niveau);
	}

	/**
	 * @param Défini le coût en nourriture pour l'amélioration de 1 niveau du bâtiment
	 */
	public void setCoutNourritureAmelioration(Integer coutNourritureAmelioration) {
		this.coutNourritureAmelioration = coutNourritureAmelioration;
	}

	/**
	 * @return Retourne le nombre de villageois necessaire pour l'amélioration de 1 niveau du bâtiment
	 */
	public Integer getVillageoisNecessaireAmelioration() {
		return (this.niveau*this.niveau)*(20*this.niveau);
	}

	/**
	 * @param Défini le nombre de villageois necessaire pour l'amélioration de 1 niveau du bâtiment
	 */
	public void setVillageoisNecessaireAmelioration(Integer villageoisNecessaireAmelioration) {
		this.villageoisNecessaireAmelioration = villageoisNecessaireAmelioration;
	}

	/**
	 * @return Retourne le temps en secondes necessaire à l'amélioration de 1 niveau du bâtiment
	 */
	public Integer getTempsAmelioration() {
		return (this.niveau*this.niveau)*(360*this.niveau*this.niveau);
	}

	/**
	 * @param Défini le temps en secondes necessaire à l'amélioration de 1 niveau du bâtiment
	 */
	public void setTempsAmelioration(Integer tempsAmelioration) {
		this.tempsAmelioration = tempsAmelioration;
	}

	/**
	 * @return Retourne la quantité de pierre stockable dans la chambre forte pour le niveau actuel
	 */
	public Integer getQuantiteeStockagePierreChambreForte() {
		return (this.niveau*this.niveau)*(1000*this.niveau);
	}

	/**
	 * @return Défini la quantité de pierre stockable dans la chambre forte pour le niveau actuel
	 */
	public void setQuantiteeStockagePierreChambreForte(Integer quantiteeStockagePierreChambreForte) {
		this.quantiteeStockagePierreChambreForte = quantiteeStockagePierreChambreForte;
	}

	/**
	 * @return Retourne la quantité de bois stockable dans la chambre forte pour le niveau actuel
	 */
	public Integer getQuantiteeStockageBoisChambreForte() {
		return (this.niveau*this.niveau)*(1000*this.niveau);
	}

	/**
	 * @return Défini la quantité de pierre stockable dans la chambre forte pour le niveau actuel
	 */
	public void setQuantiteeStockageBoisChambreForte(Integer quantiteeStockageBoisChambreForte) {
		this.quantiteeStockageBoisChambreForte = quantiteeStockageBoisChambreForte;
	}

	/**
	 * @return Retourne la quantité d'or stockable dans la chambre forte pour le niveau actuel
	 */
	public Integer getQuantiteeStockageOrChambreForte() {
		return (this.niveau*this.niveau)*(1000*this.niveau);
	}

	/**
	 * @return Défini la quantité d'or stockable dans la chambre forte pour le niveau actuel
	 */
	public void setQuantiteeStockageOrChambreForte(Integer quantiteeStockageOrChambreForte) {
		this.quantiteeStockageOrChambreForte = quantiteeStockageOrChambreForte;
	}

	/**
	 * @return Retourne la quantité de nourriture stockable dans la chambre forte pour le niveau actuel
	 */
	public Integer getQuantiteeStockageNourritureChambreForte() {
		return (this.niveau*this.niveau)*(1000*this.niveau);
	}

	/**
	 * @return Défini la quantité de nourriture stockable dans la chambre forte pour le niveau actuel
	 */
	public void setQuantiteeStockageNourritureChambreForte(Integer quantiteeStockageNourritureChambreForte) {
		this.quantiteeStockageNourritureChambreForte = quantiteeStockageNourritureChambreForte;
	}

	/**
	 * @return Retourne le nombre de bâtiment de type "Chaumiere" qu'il est possible de construire pour le niveau actuel
	 */
	public Integer getNombreMaximalBatimentChaumiere() {
		return nombreMaximalBatimentChaumiere;
	}

	/**
	 * @return Défini le nombre de bâtiment de type "Chaumiere" qu'il est possible de construire pour le niveau actuel
	 */
	public void setNombreMaximalBatimentChaumiere(Integer nombreMaximalBatimentChaumiere) {
		this.nombreMaximalBatimentChaumiere = nombreMaximalBatimentChaumiere;
	}

	/**
	 * @return Retourne le nombre de bâtiment de type "Carrière" qu'il est possible de construire pour le niveau actuel
	 */
	public Integer getNombreMaximalBatimentCarriere() {
		return nombreMaximalBatimentCarriere;
	}

	/**
	 * @return Défini le nombre de bâtiment de type "Carrière" qu'il est possible de construire pour le niveau actuel
	 */
	public void setNombreMaximalBatimentCarriere(Integer nombreMaximalBatimentCarriere) {
		this.nombreMaximalBatimentCarriere = nombreMaximalBatimentCarriere;
	}

	/**
	 * @return Retourne le nombre de bâtiment de type "Camp de bûcheron" qu'il est possible de construire pour le niveau actuel
	 */
	public Integer getNombreMaximalBatimentCampDeBucheron() {
		return nombreMaximalBatimentCampDeBucheron;
	}

	/**
	 * @return Défini le nombre de bâtiment de type "Camp de bûcheron" qu'il est possible de construire pour le niveau actuel
	 */
	public void setNombreMaximalBatimentCampDeBucheron(Integer nombreMaximalBatimentCampDeBucheron) {
		this.nombreMaximalBatimentCampDeBucheron = nombreMaximalBatimentCampDeBucheron;
	}

	/**
	 * @return Retourne le nombre de bâtiment de type "Camp de mineur" qu'il est possible de construire pour le niveau actuel
	 */
	public Integer getNombreMaximalBatimentCampDeMineur() {
		return nombreMaximalBatimentCampDeMineur;
	}

	/**
	 * @return Défini le nombre de bâtiment de type "Camp de mineur" qu'il est possible de construire pour le niveau actuel
	 */
	public void setNombreMaximalBatimentCampDeMineur(Integer nombreMaximalBatimentCampDeMineur) {
		this.nombreMaximalBatimentCampDeMineur = nombreMaximalBatimentCampDeMineur;
	}

	/**
	 * @return Retourne le nombre de bâtiment de type "Ferme" qu'il est possible de construire pour le niveau actuel
	 */
	public Integer getNombreMaximalBatimentFerme() {
		return nombreMaximalBatimentFerme;
	}

	/**
	 * @return Défini le nombre de bâtiment de type "Ferme" qu'il est possible de construire pour le niveau actuel
	 */
	public void setNombreMaximalBatimentFerme(Integer nombreMaximalBatimentFerme) {
		this.nombreMaximalBatimentFerme = nombreMaximalBatimentFerme;
	}

	/**
	 * @return Retourne le nombre de bâtiment de type "Entrepot" qu'il est possible de construire pour le niveau actuel
	 */
	public Integer getNombreMaximalBatimentEntrepot() {
		return nombreMaximalBatimentEntrepot;
	}

	/**
	 * @return Défini le nombre de bâtiment de type "Entrepot" qu'il est possible de construire pour le niveau actuel
	 */
	public void setNombreMaximalBatimentEntrepot(Integer nombreMaximalBatimentEntrepot) {
		this.nombreMaximalBatimentEntrepot = nombreMaximalBatimentEntrepot;
	}

	/**
	 * @return Retourne le nombre de bâtiment de type "Scierie" qu'il est possible de construire pour le niveau actuel
	 */
	public Integer getNombreMaximalBatimentScierie() {
		return nombreMaximalBatimentScierie;
	}

	/**
	 * @return Défini le nombre de bâtiment de type "Scierie" qu'il est possible de construire pour le niveau actuel
	 */
	public void setNombreMaximalBatimentScierie(Integer nombreMaximalBatimentScierie) {
		this.nombreMaximalBatimentScierie = nombreMaximalBatimentScierie;
	}

	/**
	 * @return Retourne le nombre de bâtiment de type "Banque" qu'il est possible de construire pour le niveau actuel
	 */
	public Integer getNombreMaximalBatimentBanque() {
		return nombreMaximalBatimentBanque;
	}

	/**
	 * @return Défini le nombre de bâtiment de type "Banque" qu'il est possible de construire pour le niveau actuel
	 */
	public void setNombreMaximalBatimentBanque(Integer nombreMaximalBatimentBanque) {
		this.nombreMaximalBatimentBanque = nombreMaximalBatimentBanque;
	}

	/**
	 * @return Retourne le nombre de bâtiment de type "Grenier" qu'il est possible de construire pour le niveau actuel
	 */
	public Integer getNombreMaximalBatimentGrenier() {
		return nombreMaximalBatimentGrenier;
	}

	/**
	 * @return Défini le nombre de bâtiment de type "Grenier" qu'il est possible de construire pour le niveau actuel
	 */
	public void setNombreMaximalBatimentGrenier(Integer nombreMaximalBatimentGrenier) {
		this.nombreMaximalBatimentGrenier = nombreMaximalBatimentGrenier;
	}

	/**
	 * @return Retourne le nombre de bâtiment de type "Port" qu'il est possible de construire pour le niveau actuel
	 */
	public Integer getNombreMaximalBatimentPort() {
		return nombreMaximalBatimentPort;
	}

	/**
	 * @return Défini le nombre de bâtiment de type "Port" qu'il est possible de construire pour le niveau actuel
	 */
	public void setNombreMaximalBatimentPort(Integer nombreMaximalBatimentPort) {
		this.nombreMaximalBatimentPort = nombreMaximalBatimentPort;
	}

	/**
	 * @return Retourne le nombre de bâtiment de type "Caserne millitaire" qu'il est possible de construire pour le niveau actuel
	 */
	public Integer getNombreMaximalBatimentCaserneMillitaire() {
		return nombreMaximalBatimentCaserneMillitaire;
	}

	/**
	 * @return Défini le nombre de bâtiment de type "Caserne millitaire" qu'il est possible de construire pour le niveau actuel
	 */
	public void setNombreMaximalBatimentCaserneMillitaire(Integer nombreMaximalBatimentCaserneMillitaire) {
		this.nombreMaximalBatimentCaserneMillitaire = nombreMaximalBatimentCaserneMillitaire;
	}

	/**
	 * @return Retourne le nombre de bâtiment de type "Atelier de siège" qu'il est possible de construire pour le niveau actuel
	 */
	public Integer getNombreMaximalBatimentAtelierDeSiege() {
		return nombreMaximalBatimentAtelierDeSiege;
	}

	/**
	 * @return Défini le nombre de bâtiment de type "Atelier de siège" qu'il est possible de construire pour le niveau actuel
	 */
	public void setNombreMaximalBatimentAtelierDeSiege(Integer nombreMaximalBatimentAtelierDeSiege) {
		this.nombreMaximalBatimentAtelierDeSiege = nombreMaximalBatimentAtelierDeSiege;
	}

	/**
	 * @return Retourne le nombre de bâtiment de type "Forge" qu'il est possible de construire pour le niveau actuel
	 */
	public Integer getNombreMaximalBatimentForge() {
		return nombreMaximalBatimentForge;
	}

	/**
	 * @return Défini le nombre de bâtiment de type "Forge" qu'il est possible de construire pour le niveau actuel
	 */
	public void setNombreMaximalBatimentForge(Integer nombreMaximalBatimentForge) {
		this.nombreMaximalBatimentForge = nombreMaximalBatimentForge;
	}

	/**
	 * @return Retourne le nombre de bâtiment de type "Universite" qu'il est possible de construire pour le niveau actuel
	 */
	public Integer getNombreMaximalBatimentUniversite() {
		return nombreMaximalBatimentUniversite;
	}

	/**
	 * @return Défini le nombre de bâtiment de type "Universite" qu'il est possible de construire pour le niveau actuel
	 */
	public void setNombreMaximalBatimentUniversite(Integer nombreMaximalBatimentUniversite) {
		this.nombreMaximalBatimentUniversite = nombreMaximalBatimentUniversite;
	}

	/**
	 * @return Retourne le nombre de bâtiment de type "Table de mission" qu'il est possible de construire pour le niveau actuel
	 */
	public Integer getNombreMaximalTableDeMission() {
		return nombreMaximalTableDeMission;
	}

	/**
	 * @return Défini le nombre de bâtiment de type "Table de mission" qu'il est possible de construire pour le niveau actuel
	 */
	public void setNombreMaximalTableDeMission(Integer nombreMaximalTableDeMission) {
		this.nombreMaximalTableDeMission = nombreMaximalTableDeMission;
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
