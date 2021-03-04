package dev.entites.batiment;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Defense {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer idTypeDefense;
	
	/*
	 * 1 = Offensif
	 * 2 = Defensif
	 */
	private Integer typeDefense;
	
	private String icone;
	
    @OneToMany(mappedBy = "defense")
    @JsonIgnore 
	private List<DefenseJoueur> defenseJoueur;
    
	private String libelle;
	private String description;
	private Integer coutPierreConstruction;
	private Integer coutBoisConstruction;
	private Integer coutOrConstruction;
	private Integer coutNourritureConstruction;
	private Integer vie;
	private Integer attaque;
	private Integer portee;
	private Integer armure;
	private Integer tempsConstruction;
	
    /** niveau necessaire du bâtiment pour débloquer la formation **/
    private Integer niveauBatimentNecessaireConstruction;
	private Integer idBatimentProvenance;
	
	private Long apportExperience;
	
	public Defense() {
		super();
	}

	/**
	 * @param idTypeDefense
	 * @param icone
	 * @param defenseJoueur
	 * @param libelle
	 * @param description
	 * @param coutPierreConstruction
	 * @param coutBoisConstruction
	 * @param coutOrConstruction
	 * @param coutNourritureConstruction
	 * @param vie
	 * @param attaque
	 * @param armure
	 * @param tempsConstruction
	 * @param niveauBatimentNecessaireConstruction
	 * @param idBatimentProvenance
	 */
	public Defense(Integer idTypeDefense, Integer typeDefense, String icone, String libelle,
			String description, Integer coutPierreConstruction, Integer coutBoisConstruction,
			Integer coutOrConstruction, Integer coutNourritureConstruction, Integer vie, Integer attaque, Integer portee,
			Integer armure, Integer tempsConstruction, Integer niveauBatimentNecessaireConstruction,
			Integer idBatimentProvenance, Long apportExperience) {
		super();
		this.idTypeDefense = idTypeDefense;
		this.typeDefense = typeDefense;
		this.icone = icone;
		this.libelle = libelle;
		this.description = description;
		this.coutPierreConstruction = coutPierreConstruction;
		this.coutBoisConstruction = coutBoisConstruction;
		this.coutOrConstruction = coutOrConstruction;
		this.coutNourritureConstruction = coutNourritureConstruction;
		this.vie = vie;
		this.attaque = attaque;
		this.portee = portee;
		this.armure = armure;
		this.tempsConstruction = tempsConstruction;
		this.niveauBatimentNecessaireConstruction = niveauBatimentNecessaireConstruction;
		this.idBatimentProvenance = idBatimentProvenance;
		this.apportExperience = apportExperience;
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
	 * @return the idTypeDefense
	 */
	public Integer getIdTypeDefense() {
		return idTypeDefense;
	}

	/**
	 * @param idTypeDefense the idTypeDefense to set
	 */
	public void setIdTypeDefense(Integer idTypeDefense) {
		this.idTypeDefense = idTypeDefense;
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
	 * @return the defenseJoueur
	 */
	public List<DefenseJoueur> getDefenseJoueur() {
		return defenseJoueur;
	}

	/**
	 * @param defenseJoueur the defenseJoueur to set
	 */
	public void setDefenseJoueur(List<DefenseJoueur> defenseJoueur) {
		this.defenseJoueur = defenseJoueur;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * @return the tempsConstruction
	 */
	public Integer getTempsConstruction() {
		return tempsConstruction;
	}

	/**
	 * @param tempsConstruction the tempsConstruction to set
	 */
	public void setTempsConstruction(Integer tempsConstruction) {
		this.tempsConstruction = tempsConstruction;
	}

	/**
	 * @return the niveauBatimentNecessaireConstruction
	 */
	public Integer getNiveauBatimentNecessaireConstruction() {
		return niveauBatimentNecessaireConstruction;
	}

	/**
	 * @param niveauBatimentNecessaireConstruction the niveauBatimentNecessaireConstruction to set
	 */
	public void setNiveauBatimentNecessaireConstruction(Integer niveauBatimentNecessaireConstruction) {
		this.niveauBatimentNecessaireConstruction = niveauBatimentNecessaireConstruction;
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
	 * @return the typeDefense
	 */
	public Integer getTypeDefense() {
		return typeDefense;
	}

	/**
	 * @param typeDefense the typeDefense to set
	 */
	public void setTypeDefense(Integer typeDefense) {
		this.typeDefense = typeDefense;
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

	@Override
	public String toString() {
		return "Defense [libelle=" + libelle + "]";
	}


	



	
}
