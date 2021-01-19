package dev.entites.unitee;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import dev.entites.joueur.Armee;
import dev.entites.joueur.BatimentJoueur;

@Entity
public class Unitee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    /** Une unitee peut concerner plusieures armées **/
    @OneToMany(mappedBy = "unitee")
    @JsonIgnore 
	private List<Armee> armee;
    
    /** id unitee : 
	1 - Villageois
	2 - Fantassin Hache		
	3 - Fantassin Epée		
	4 - Légionnaire		
	5 - Archer		
	6 - Archer composite		
	7 - Archer élite
	8 - Cavalier		
	9 - Cavalier Expert		
	10 - Paladin
	11 - Navire de pêche		
	12 - Navire éclaireur		
	13 - Navire de guerre
	14 - Catapulte		
	15 - Baliste		
	16 - Eléphan de Guerre
	17 - Mûle de commerce		
	18 - Prêtre
     *  **/
    private Integer idTypeUnitee;
    
    /** id batiment provenance : 
     * 12 = Ecurie,
     *  **/
    private Integer idBatimentProvenance;
    
    /** icone de l'unitée **/
    private String icone;
    
    /** nom de l'unitée **/
    private String libelle;
    
    /** descriptif de l'unitée **/
    private String descriptif;
    
    /** coût en pierre de l'unitée **/
    private Integer coutPierreFormation;
    
    /** coût en bois de l'unitée **/
    private Integer coutBoisFormation;
    
    /** coût en or de l'unitée **/
    private Integer coutOrFormation;
    
    /** coût en nourriture de l'unitée **/
    private Integer coutNourritureFormation;
    
    /** coût humain de l'unitée **/
    private Integer coutHumain;
    
    /** temps en seconde necessaire à la Formation de l'unitée**/
    private Integer tempsFormation;

    /** points de vie de l'unitée **/
    private Integer vie;

    /** points d'attaque de l'unitée **/
    private Integer attaque;

    /** portée de l'unitée **/
    private Integer portee;

    /** points d'armure de l'unitée **/
    private Integer armure;

    /** niveau necessaire du bâtiment pour débloquer la formation **/
    private Integer niveauBatimentNecessaireFormation;
    
    /** apport de ressource par heure de l'unitée **/
    private Integer apportRessourcePierreHeure;
    private Integer apportRessourceBoisHeure;
    private Integer apportRessourceOrHeure;
    private Integer apportRessourceNourritureHeure;
    
    
	public Unitee() {
		super();

	}
	/**
	 * @param idTypeUnitee
	 * @param idBatimentProvenance
	 * @param icone
	 * @param libelle
	 * @param descriptif
	 * @param niveau
	 * @param coutPierreFormation
	 * @param coutBoisFormation
	 * @param coutOrFormation
	 * @param coutNourritureFormation
	 * @param coutHumain
	 * @param tempsFormation
	 * @param vie
	 * @param attaque
	 * @param portee
	 * @param armure
	 * @param niveauBatimentNecessaireFormation
	 * @param apportRessourcePierreHeure
	 * @param apportRessourceBoisHeure
	 * @param apportRessourceOrHeure
	 * @param apportRessourceNourritureHeure
	 */
	public Unitee(Integer idTypeUnitee, Integer idBatimentProvenance, String icone, String libelle, String descriptif,
			Integer coutPierreFormation, Integer coutBoisFormation, Integer coutOrFormation,
			Integer coutNourritureFormation, Integer coutHumain, Integer tempsFormation, Integer vie, Integer attaque,
			Integer portee, Integer armure, Integer niveauBatimentNecessaireFormation,
			Integer apportRessourcePierreHeure, Integer apportRessourceBoisHeure, Integer apportRessourceOrHeure,
			Integer apportRessourceNourritureHeure) {
		super();
		this.idTypeUnitee = idTypeUnitee;
		this.idBatimentProvenance = idBatimentProvenance;
		this.icone = icone;
		this.libelle = libelle;
		this.descriptif = descriptif;
		this.coutPierreFormation = coutPierreFormation;
		this.coutBoisFormation = coutBoisFormation;
		this.coutOrFormation = coutOrFormation;
		this.coutNourritureFormation = coutNourritureFormation;
		this.coutHumain = coutHumain;
		this.tempsFormation = tempsFormation;
		this.vie = vie;
		this.attaque = attaque;
		this.portee = portee;
		this.armure = armure;
		this.niveauBatimentNecessaireFormation = niveauBatimentNecessaireFormation;
		this.apportRessourcePierreHeure = apportRessourcePierreHeure;
		this.apportRessourceBoisHeure = apportRessourceBoisHeure;
		this.apportRessourceOrHeure = apportRessourceOrHeure;
		this.apportRessourceNourritureHeure = apportRessourceNourritureHeure;
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
	 * @return the idTypeUnitee
	 */
	public Integer getIdTypeUnitee() {
		return idTypeUnitee;
	}
	/**
	 * @param idTypeUnitee the idTypeUnitee to set
	 */
	public void setIdTypeUnitee(Integer idTypeUnitee) {
		this.idTypeUnitee = idTypeUnitee;
	}
	/**
	 * @return the idBatimentProvenance
	 */
	public Integer getIdBatimentProvenance() {
		return idBatimentProvenance;
	}
	/**
	 * @param idBatimentProvenance the idBatimentProvenance to set
	 */
	public void setIdBatimentProvenance(Integer idBatimentProvenance) {
		this.idBatimentProvenance = idBatimentProvenance;
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
	 * @return the coutPierreFormation
	 */
	public Integer getCoutPierreFormation() {
		return coutPierreFormation;
	}
	/**
	 * @param coutPierreFormation the coutPierreFormation to set
	 */
	public void setCoutPierreFormation(Integer coutPierreFormation) {
		this.coutPierreFormation = coutPierreFormation;
	}
	/**
	 * @return the coutBoisFormation
	 */
	public Integer getCoutBoisFormation() {
		return coutBoisFormation;
	}
	/**
	 * @param coutBoisFormation the coutBoisFormation to set
	 */
	public void setCoutBoisFormation(Integer coutBoisFormation) {
		this.coutBoisFormation = coutBoisFormation;
	}
	/**
	 * @return the coutOrFormation
	 */
	public Integer getCoutOrFormation() {
		return coutOrFormation;
	}
	/**
	 * @param coutOrFormation the coutOrFormation to set
	 */
	public void setCoutOrFormation(Integer coutOrFormation) {
		this.coutOrFormation = coutOrFormation;
	}
	/**
	 * @return the coutNourritureFormation
	 */
	public Integer getCoutNourritureFormation() {
		return coutNourritureFormation;
	}
	/**
	 * @param coutNourritureFormation the coutNourritureFormation to set
	 */
	public void setCoutNourritureFormation(Integer coutNourritureFormation) {
		this.coutNourritureFormation = coutNourritureFormation;
	}
	/**
	 * @return the coutHumain
	 */
	public Integer getCoutHumain() {
		return coutHumain;
	}
	/**
	 * @param coutHumain the coutHumain to set
	 */
	public void setCoutHumain(Integer coutHumain) {
		this.coutHumain = coutHumain;
	}
	/**
	 * @return the tempsFormation
	 */
	public Integer getTempsFormation() {
		return tempsFormation;
	}
	/**
	 * @param tempsFormation the tempsFormation to set
	 */
	public void setTempsFormation(Integer tempsFormation) {
		this.tempsFormation = tempsFormation;
	}
	/**
	 * @return the vie
	 */
	public Integer getVie() {
		return vie;
	}
	/**
	 * @param vie the vie to set
	 */
	public void setVie(Integer vie) {
		this.vie = vie;
	}
	/**
	 * @return the attaque
	 */
	public Integer getAttaque() {
		return attaque;
	}
	/**
	 * @param attaque the attaque to set
	 */
	public void setAttaque(Integer attaque) {
		this.attaque = attaque;
	}
	/**
	 * @return the portee
	 */
	public Integer getPortee() {
		return portee;
	}
	/**
	 * @param portee the portee to set
	 */
	public void setPortee(Integer portee) {
		this.portee = portee;
	}
	/**
	 * @return the armure
	 */
	public Integer getArmure() {
		return armure;
	}
	/**
	 * @param armure the armure to set
	 */
	public void setArmure(Integer armure) {
		this.armure = armure;
	}
	/**
	 * @return the niveauBatimentNecessaireFormation
	 */
	public Integer getNiveauBatimentNecessaireFormation() {
		return niveauBatimentNecessaireFormation;
	}
	/**
	 * @param niveauBatimentNecessaireFormation the niveauBatimentNecessaireFormation to set
	 */
	public void setNiveauBatimentNecessaireFormation(Integer niveauBatimentNecessaireFormation) {
		this.niveauBatimentNecessaireFormation = niveauBatimentNecessaireFormation;
	}
	/**
	 * @return the apportRessourcePierreHeure
	 */
	public Integer getApportRessourcePierreHeure() {
		return apportRessourcePierreHeure;
	}
	/**
	 * @param apportRessourcePierreHeure the apportRessourcePierreHeure to set
	 */
	public void setApportRessourcePierreHeure(Integer apportRessourcePierreHeure) {
		this.apportRessourcePierreHeure = apportRessourcePierreHeure;
	}
	/**
	 * @return the apportRessourceBoisHeure
	 */
	public Integer getApportRessourceBoisHeure() {
		return apportRessourceBoisHeure;
	}
	/**
	 * @param apportRessourceBoisHeure the apportRessourceBoisHeure to set
	 */
	public void setApportRessourceBoisHeure(Integer apportRessourceBoisHeure) {
		this.apportRessourceBoisHeure = apportRessourceBoisHeure;
	}
	/**
	 * @return the apportRessourceOrHeure
	 */
	public Integer getApportRessourceOrHeure() {
		return apportRessourceOrHeure;
	}
	/**
	 * @param apportRessourceOrHeure the apportRessourceOrHeure to set
	 */
	public void setApportRessourceOrHeure(Integer apportRessourceOrHeure) {
		this.apportRessourceOrHeure = apportRessourceOrHeure;
	}
	/**
	 * @return the apportRessourceNourritureHeure
	 */
	public Integer getApportRessourceNourritureHeure() {
		return apportRessourceNourritureHeure;
	}
	/**
	 * @param apportRessourceNourritureHeure the apportRessourceNourritureHeure to set
	 */
	public void setApportRessourceNourritureHeure(Integer apportRessourceNourritureHeure) {
		this.apportRessourceNourritureHeure = apportRessourceNourritureHeure;
	}
	/**
	 * @return the armee
	 */
	public List<Armee> getArmee() {
		return armee;
	}
	/**
	 * @param armee the armee to set
	 */
	public void setArmee(List<Armee> armee) {
		this.armee = armee;
	}
    
    
    
}

