package dev.entites.batiment;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import dev.entites.joueur.BatimentJoueur;

@Entity
public class Batiment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /** Un batiment peut concerner plusieurs batimentsJoueur **/
    @OneToMany(mappedBy = "batiment")
    @JsonIgnore 
	private List<BatimentJoueur> batimentJoueur;
    
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

	public Batiment() {
	}
	
	/**
	 * @param idTypeBatiment
	 */
	public Batiment(Integer idTypeBatiment) {
		super();
		this.idTypeBatiment = idTypeBatiment;
		switch (this.idTypeBatiment) {
			// Hotel de ville
			case 1:
				this.icone = "https://cdn.discordapp.com/attachments/794876433842831361/794876575979667456/HotelDeVille.png";
				this.libelle = "Hotel de ville";
				this.descriptif = "Descriptif de l'Hotel de ville";
				this.ouvrierNecessaireConstruction = 99;
				this.tempsDeConstruction = 99;
				this.coutPierreConstruction = 99;
				this.coutBoisConstruction = 99;
				this.coutOrConstruction = 99;
				this.coutNourritureConstruction = 99;
				this.niveauHotelDeVilleNecessaireConstruction = 99;
			break;
			//Chaumière (augmenter limite population)
			case 2:
				this.icone = "https://cdn.discordapp.com/attachments/794876433842831361/794876520338161704/Chaumiere.png";
				this.libelle = "Chaumière";
				this.descriptif = "Descriptif de la Chaumière";
				this.ouvrierNecessaireConstruction = 99;
				this.tempsDeConstruction = 99;
				this.coutPierreConstruction = 99;
				this.coutBoisConstruction = 99;
				this.coutOrConstruction = 99;
				this.coutNourritureConstruction = 99;
				this.niveauHotelDeVilleNecessaireConstruction = 99;
			break;
			// Carrière (farm pierre)
			case 3:
				this.icone = "https://cdn.discordapp.com/attachments/794876433842831361/794876505230540860/Carriere.png";
				this.libelle = "Carrière";
				this.descriptif = "Descriptif de la Carrière";
				this.ouvrierNecessaireConstruction = 99;
				this.tempsDeConstruction = 99;
				this.coutPierreConstruction = 99;
				this.coutBoisConstruction = 99;
				this.coutOrConstruction = 99;
				this.coutNourritureConstruction = 99;
				this.niveauHotelDeVilleNecessaireConstruction = 99;
			break;
			// Camp de bucheron (farm bois)		
			case 4:
				this.icone = "https://cdn.discordapp.com/attachments/794876433842831361/794876491850711040/CampDeBucheron.png";
				this.libelle = "Camp de bucheron";
				this.descriptif = "Descriptif du Camp de bucheron";
				this.ouvrierNecessaireConstruction = 99;
				this.tempsDeConstruction = 99;
				this.coutPierreConstruction = 99;
				this.coutBoisConstruction = 99;
				this.coutOrConstruction = 99;
				this.coutNourritureConstruction = 99;
				this.niveauHotelDeVilleNecessaireConstruction = 99;
			break;
			// Camp de mineur (farm or)
			case 5:
				this.icone = "https://cdn.discordapp.com/attachments/794876433842831361/794876498183323678/CampDeMineur.png";
				this.libelle = "Camp de mineur";
				this.descriptif = "Descriptif du Camp de mineur";
				this.ouvrierNecessaireConstruction = 99;
				this.tempsDeConstruction = 99;
				this.coutPierreConstruction = 99;
				this.coutBoisConstruction = 99;
				this.coutOrConstruction = 99;
				this.coutNourritureConstruction = 99;
				this.niveauHotelDeVilleNecessaireConstruction = 99;
			break;
			// Ferme (farm nourriture)
			case 6:
				this.icone = "https://cdn.discordapp.com/attachments/794876433842831361/794876556509839360/Ferme.png";
				this.libelle = "Ferme";
				this.descriptif = "Descriptif de la Ferme";
				this.ouvrierNecessaireConstruction = 99;
				this.tempsDeConstruction = 99;
				this.coutPierreConstruction = 99;
				this.coutBoisConstruction = 99;
				this.coutOrConstruction = 99;
				this.coutNourritureConstruction = 99;
				this.niveauHotelDeVilleNecessaireConstruction = 99;
			break;
			// Stockage Pierre (Entrepot)	
			case 7:
				this.icone = "https://cdn.discordapp.com/attachments/794876433842831361/794876485034311690/Banque.png";
				this.libelle = "Entrepot";
				this.descriptif = "Descriptif de l'Entrepot";
				this.ouvrierNecessaireConstruction = 99;
				this.tempsDeConstruction = 99;
				this.coutPierreConstruction = 99;
				this.coutBoisConstruction = 99;
				this.coutOrConstruction = 99;
				this.coutNourritureConstruction = 99;
				this.niveauHotelDeVilleNecessaireConstruction = 99;
			break;
			// Stockage Bois (Scierie)
			case 8:
				this.icone = "https://cdn.discordapp.com/attachments/794876433842831361/794876485034311690/Banque.png";
				this.libelle = "Scierie";
				this.descriptif = "Descriptif de la Scierie";
				this.ouvrierNecessaireConstruction = 99;
				this.tempsDeConstruction = 99;
				this.coutPierreConstruction = 99;
				this.coutBoisConstruction = 99;
				this.coutOrConstruction = 99;
				this.coutNourritureConstruction = 99;
				this.niveauHotelDeVilleNecessaireConstruction = 99;
			break;
			// Stockage Or (Banque)
			case 9:
				this.icone = "https://cdn.discordapp.com/attachments/794876433842831361/794876485034311690/Banque.png";
				this.libelle = "Banque";
				this.descriptif = "Descriptif de la Banque";
				this.ouvrierNecessaireConstruction = 99;
				this.tempsDeConstruction = 99;
				this.coutPierreConstruction = 99;
				this.coutBoisConstruction = 99;
				this.coutOrConstruction = 99;
				this.coutNourritureConstruction = 99;
				this.niveauHotelDeVilleNecessaireConstruction = 99;
			break;
			// Stockage Nourriture (Grenier)
			case 10:
				this.icone = "https://cdn.discordapp.com/attachments/794876433842831361/794876485034311690/Banque.png";
				this.libelle = "Grenier";
				this.descriptif = "Descriptif du Grenier";
				this.ouvrierNecessaireConstruction = 99;
				this.tempsDeConstruction = 99;
				this.coutPierreConstruction = 99;
				this.coutBoisConstruction = 99;
				this.coutOrConstruction = 99;
				this.coutNourritureConstruction = 99;
				this.niveauHotelDeVilleNecessaireConstruction = 99;
			break;
			// Caserne Militaire	
			case 11:
				this.icone = "https://cdn.discordapp.com/attachments/794876433842831361/794876513039417404/CaserneMillitaire.png";
				this.libelle = "Caserne Militaire";
				this.descriptif = "Descriptif de la Caserne Militaire";
				this.ouvrierNecessaireConstruction = 99;
				this.tempsDeConstruction = 99;
				this.coutPierreConstruction = 99;
				this.coutBoisConstruction = 99;
				this.coutOrConstruction = 99;
				this.coutNourritureConstruction = 99;
				this.niveauHotelDeVilleNecessaireConstruction = 99;
			break;
			// Ecurie
			case 12:
				this.icone = "https://cdn.discordapp.com/attachments/794876433842831361/794876520338161704/Chaumiere.png";
				this.libelle = "Ecurie";
				this.descriptif = "Descriptif de l'Ecurie";
				this.ouvrierNecessaireConstruction = 99;
				this.tempsDeConstruction = 99;
				this.coutPierreConstruction = 99;
				this.coutBoisConstruction = 99;
				this.coutOrConstruction = 99;
				this.coutNourritureConstruction = 99;
				this.niveauHotelDeVilleNecessaireConstruction = 99;
			break;
			// Port
			case 13:
				this.icone = "https://cdn.discordapp.com/attachments/794876433842831361/794876596741865522/Port.png";
				this.libelle = "Port";
				this.descriptif = "Descriptif du Port";
				this.ouvrierNecessaireConstruction = 99;
				this.tempsDeConstruction = 99;
				this.coutPierreConstruction = 99;
				this.coutBoisConstruction = 99;
				this.coutOrConstruction = 99;
				this.coutNourritureConstruction = 99;
				this.niveauHotelDeVilleNecessaireConstruction = 99;
			break;
			// Atelier de siege
			case 14:
				this.icone = "https://cdn.discordapp.com/attachments/794876433842831361/794876478667751444/AtelierDeSiege.png";
				this.libelle = "Atelier de siege";
				this.descriptif = "Descriptif de l'Atelier de siege";
				this.ouvrierNecessaireConstruction = 99;
				this.tempsDeConstruction = 99;
				this.coutPierreConstruction = 99;
				this.coutBoisConstruction = 99;
				this.coutOrConstruction = 99;
				this.coutNourritureConstruction = 99;
				this.niveauHotelDeVilleNecessaireConstruction = 99;
			break;
			// Forge
			case 15:
				this.icone = "https://cdn.discordapp.com/attachments/794876433842831361/794876568375001098/Forge.png";
				this.libelle = "Forge";
				this.descriptif = "Descriptif de la Forge";
				this.ouvrierNecessaireConstruction = 99;
				this.tempsDeConstruction = 99;
				this.coutPierreConstruction = 99;
				this.coutBoisConstruction = 99;
				this.coutOrConstruction = 99;
				this.coutNourritureConstruction = 99;
				this.niveauHotelDeVilleNecessaireConstruction = 99;
			break;
			// Universite
			case 16:
				this.icone = "https://cdn.discordapp.com/attachments/794876433842831361/794876610632220702/Universite.png";
				this.libelle = "Universite";
				this.descriptif = "Descriptif de l'Universite";
				this.ouvrierNecessaireConstruction = 99;
				this.tempsDeConstruction = 99;
				this.coutPierreConstruction = 99;
				this.coutBoisConstruction = 99;
				this.coutOrConstruction = 99;
				this.coutNourritureConstruction = 99;
				this.niveauHotelDeVilleNecessaireConstruction = 99;
			break;
			// Marché
			case 17:
				this.icone = "https://cdn.discordapp.com/attachments/794876433842831361/794876590022590504/Marche.png";
				this.libelle = "Marché";
				this.descriptif = "Descriptif du Marché";
				this.ouvrierNecessaireConstruction = 99;
				this.tempsDeConstruction = 99;
				this.coutPierreConstruction = 99;
				this.coutBoisConstruction = 99;
				this.coutOrConstruction = 99;
				this.coutNourritureConstruction = 99;
				this.niveauHotelDeVilleNecessaireConstruction = 99;
			break;
			// Table d'expéditions
			case 18:
				this.icone = "https://cdn.discordapp.com/attachments/794876433842831361/794876603564818432/TableExpedition.png";
				this.libelle = "Table d'expéditions";
				this.descriptif = "Descriptif de la Table d'expéditions";
				this.ouvrierNecessaireConstruction = 99;
				this.tempsDeConstruction = 99;
				this.coutPierreConstruction = 99;
				this.coutBoisConstruction = 99;
				this.coutOrConstruction = 99;
				this.coutNourritureConstruction = 99;
				this.niveauHotelDeVilleNecessaireConstruction = 99;
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
	 * @return the batimentJoueur
	 */
	public List<BatimentJoueur> getBatimentJoueur() {
		return batimentJoueur;
	}

	/**
	 * @param batimentJoueur the batimentJoueur to set
	 */
	public void setBatimentJoueur(List<BatimentJoueur> batimentJoueur) {
		this.batimentJoueur = batimentJoueur;
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

	@Override
	public String toString() {
		return "Batiment [id=" + id + ", batimentJoueur=" + batimentJoueur + ", idTypeBatiment=" + idTypeBatiment
				+ ", icone=" + icone + ", libelle=" + libelle + ", descriptif=" + descriptif
				+ ", ouvrierNecessaireConstruction=" + ouvrierNecessaireConstruction + ", tempsDeConstruction="
				+ tempsDeConstruction + ", coutPierreConstruction=" + coutPierreConstruction + ", coutBoisConstruction="
				+ coutBoisConstruction + ", coutOrConstruction=" + coutOrConstruction + ", coutNourritureConstruction="
				+ coutNourritureConstruction + ", niveauHotelDeVilleNecessaireConstruction="
				+ niveauHotelDeVilleNecessaireConstruction + "]";
	}

	
    
}
