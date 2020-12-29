package dev.entites.unitee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Unitee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
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
    
    /** niveau de l'unitée **/
    private Integer niveau;
    
    /** coût en pierre de l'unitée **/
    private Integer coutPierreFormation = 99;
    
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
    
    
	/**
	 * @param idTypeUnitee
	 * @param niveau
	 */
	public Unitee(Integer idTypeUnitee, Integer niveau) {
		super();
		this.idTypeUnitee = idTypeUnitee;
		this.niveau = niveau;
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
		switch (this.idTypeUnitee) {
		case 1:
			// Villageois
			idBatimentProvenance = 1;
			break;
		case 2:
			// Fantassin hache
			idBatimentProvenance = 11;
			break;
		case 3:
			// Fantassin epée
			idBatimentProvenance = 11;
			break;
		case 4:
			// Légionnaire
			idBatimentProvenance = 11;
			break;
		case 5:
			// Archer
			idBatimentProvenance = 11;
			break;
		case 6:
			// Archer composite
			idBatimentProvenance = 11;
			break;
		case 7:
			// Archer élite
			idBatimentProvenance = 11;
			break;
		case 8:
			// Cavalier
			idBatimentProvenance = 12;
			break;
		case 9:
			// Cavalier expert
			idBatimentProvenance = 12;
			break;
		case 10:
			// Paladin
			idBatimentProvenance = 12;
			break;
		case 11:
			// Navire de pêche
			idBatimentProvenance = 13;
			break;
		case 12:
			// Navire éclaireur
			idBatimentProvenance = 13;
			break;
		case 13:
			// Navire de guerre
			idBatimentProvenance = 13;
			break;
		case 14:
			// Catapulte
			idBatimentProvenance = 14;
			break;
		case 15:
			// Baliste
			idBatimentProvenance = 14;
			break;
		case 16:
			// Eléphan de guerre
			idBatimentProvenance = 14;
			break;
		case 17:
			// Mûle de commerce
			idBatimentProvenance = 17;
			break;
		case 18:
			// Prêtre
			idBatimentProvenance = 16;
			break;
        default:
        	idBatimentProvenance = 0;
            break;
		}
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
		switch (this.idTypeUnitee) {
		case 1:
			// Villageois
			icone = "xxxxxxxxxxxxxxxxxxxxxxxxxxx";
			break;
		case 2:
			// Fantassin hache
			icone = "xxxxxxxxxxxxxxxxxxxxxxxxxxx";
			break;
		case 3:
			// Fantassin epée
			icone = "xxxxxxxxxxxxxxxxxxxxxxxxxxx";
			break;
		case 4:
			// Légionnaire
			icone = "xxxxxxxxxxxxxxxxxxxxxxxxxxx";
			break;
		case 5:
			// Archer
			icone = "xxxxxxxxxxxxxxxxxxxxxxxxxxx";
			break;
		case 6:
			// Archer composite
			icone = "xxxxxxxxxxxxxxxxxxxxxxxxxxx";
			break;
		case 7:
			// Archer élite
			icone = "xxxxxxxxxxxxxxxxxxxxxxxxxxx";
			break;
		case 8:
			// Cavalier
			icone = "xxxxxxxxxxxxxxxxxxxxxxxxxxx";
			break;
		case 9:
			// Cavalier expert
			icone = "xxxxxxxxxxxxxxxxxxxxxxxxxxx";
			break;
		case 10:
			// Paladin
			icone = "xxxxxxxxxxxxxxxxxxxxxxxxxxx";
			break;
		case 11:
			// Navire de pêche
			icone = "xxxxxxxxxxxxxxxxxxxxxxxxxxx";
			break;
		case 12:
			// Navire éclaireur
			icone = "xxxxxxxxxxxxxxxxxxxxxxxxxxx";
			break;
		case 13:
			// Navire de guerre
			icone = "xxxxxxxxxxxxxxxxxxxxxxxxxxx";
			break;
		case 14:
			// Catapulte
			icone = "xxxxxxxxxxxxxxxxxxxxxxxxxxx";
			break;
		case 15:
			// Baliste
			icone = "xxxxxxxxxxxxxxxxxxxxxxxxxxx";
			break;
		case 16:
			// Eléphan de guerre
			icone = "xxxxxxxxxxxxxxxxxxxxxxxxxxx";
			break;
		case 17:
			// Mûle de commerce
			icone = "xxxxxxxxxxxxxxxxxxxxxxxxxxx";
			break;
		case 18:
			// Prêtre
			icone = "xxxxxxxxxxxxxxxxxxxxxxxxxxx";
			break;
        default:
        	icone = "xxxxxxxxxxxxxxxxxxxxxxxxxxx";
            break;
		}
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
		switch (this.idTypeUnitee) {
		case 1:
			// Villageois
			libelle = "Villageois";
			break;
		case 2:
			// Fantassin Hache
			libelle = "Fantassin hache";
			break;
		case 3:
			// Fantassin epée
			libelle = "Fantassin epée";
			break;
		case 4:
			// Légionnaire
			libelle = "Légionnaire";
			break;
		case 5:
			// Archer
			libelle = "Archer";
			break;
		case 6:
			// Archer composite
			libelle = "Archer composite";
			break;
		case 7:
			// Archer élite
			libelle = "Archer élite";
			break;
		case 8:
			// Cavalier
			libelle = "Cavalier";
			break;
		case 9:
			// Cavalier expert
			libelle = "Cavalier expert";
			break;
		case 10:
			// Paladin
			libelle = "Paladin";
			break;
		case 11:
			// Navire de pêche
			libelle = "Navire de pêche";
			break;
		case 12:
			// Navire éclaireur
			libelle = "Navire éclaireur";
			break;
		case 13:
			// Navire de guerre
			libelle = "Navire de guerre";
			break;
		case 14:
			// Catapulte
			libelle = "Catapulte";
			break;
		case 15:
			// Baliste
			libelle = "Baliste";
			break;
		case 16:
			// Eléphan de Guerre
			libelle = "Eléphan de guerre";
			break;
		case 17:
			// Mûle de Commerce
			libelle = "Mûle de commerce";
			break;
		case 18:
			// Prêtre
			libelle = "Prêtre";
			break;
        default:
        	libelle = "Unitée inconnue";
            break;
		}
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
		switch (this.idTypeUnitee) {
		case 1:
			// Villageois
			descriptif = "Descriptif du Villageois";
			break;
		case 2:
			// Fantassin Hache
			descriptif = "Descriptif du Fantassin hache";
			break;
		case 3:
			// Fantassin epée
			descriptif = "Descriptif du Fantassin epée";
			break;
		case 4:
			// Légionnaire
			descriptif = "Descriptif du Légionnaire";
			break;
		case 5:
			// Archer
			descriptif = "Descriptif de l'Archer";
			break;
		case 6:
			// Archer composite
			descriptif = "Descriptif de l'Archer composite";
			break;
		case 7:
			// Archer élite
			descriptif = "Descriptif de l'Archer élite";
			break;
		case 8:
			// Cavalier
			descriptif = "Descriptif du Cavalier";
			break;
		case 9:
			// Cavalier expert
			descriptif = "Descriptif du Cavalier expert";
			break;
		case 10:
			// Paladin
			descriptif = "Descriptif du Paladin";
			break;
		case 11:
			// Navire de pêche
			descriptif = "Descriptif du Navire de pêche";
			break;
		case 12:
			// Navire éclaireur
			descriptif = "Descriptif du Navire éclaireur";
			break;
		case 13:
			// Navire de guerre
			descriptif = "Descriptif du Navire de guerre";
			break;
		case 14:
			// Catapulte
			descriptif = "Descriptif de la Catapulte";
			break;
		case 15:
			// Baliste
			descriptif = "Descriptif de la Baliste";
			break;
		case 16:
			// Eléphan de Guerre
			descriptif = "Descriptif de l'Eléphan de guerre";
			break;
		case 17:
			// Mûle de Commerce
			descriptif = "Descriptif de la Mûle de commerce";
			break;
		case 18:
			// Prêtre
			descriptif = "Descriptif du Prêtre";
			break;
        default:
        	descriptif = "Descriptif inconnue";
            break;
		}
		return descriptif;
	}


	/**
	 * @param descriptif the descriptif to set
	 */
	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
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
	 * @return the coutPierreFormation
	 */
	public Integer getCoutPierreFormation() {
		switch (this.idTypeUnitee) {
		case 1:
			// Villageois
			coutPierreFormation = 99;
			break;
		case 2:
			// Fantassin hache
			coutPierreFormation = 99;
			break;
		case 3:
			// Fantassin epée
			coutPierreFormation = 99;
			break;
		case 4:
			// Légionnaire
			coutPierreFormation = 99;
			break;
		case 5:
			// Archer
			coutPierreFormation = 99;
			break;
		case 6:
			// Archer composite
			coutPierreFormation = 99;
			break;
		case 7:
			// Archer élite
			coutPierreFormation = 99;
			break;
		case 8:
			// Cavalier
			coutPierreFormation = 99;
			break;
		case 9:
			// Cavalier expert
			coutPierreFormation = 99;
			break;
		case 10:
			// Paladin
			coutPierreFormation = 99;
			break;
		case 11:
			// Navire de pêche
			coutPierreFormation = 99;
			break;
		case 12:
			// Navire éclaireur
			coutPierreFormation = 99;
			break;
		case 13:
			// Navire de guerre
			coutPierreFormation = 99;
			break;
		case 14:
			// Catapulte
			coutPierreFormation = 99;
			break;
		case 15:
			// Baliste
			coutPierreFormation = 99;
			break;
		case 16:
			// Eléphan de guerre
			coutPierreFormation = 99;
			break;
		case 17:
			// Mûle de commerce
			coutPierreFormation = 99;
			break;
		case 18:
			// Prêtre
			coutPierreFormation = 99;
			break;
        default:
			coutPierreFormation = 99;
            break;
		}
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
		switch (this.idTypeUnitee) {
		case 1:
			// Villageois
			coutBoisFormation = 99;
			break;
		case 2:
			// Fantassin hache
			coutBoisFormation = 99;
			break;
		case 3:
			// Fantassin epée
			coutBoisFormation = 99;
			break;
		case 4:
			// Légionnaire
			coutBoisFormation = 99;
			break;
		case 5:
			// Archer
			coutBoisFormation = 99;
			break;
		case 6:
			// Archer composite
			coutBoisFormation = 99;
			break;
		case 7:
			// Archer élite
			coutBoisFormation = 99;
			break;
		case 8:
			// Cavalier
			coutBoisFormation = 99;
			break;
		case 9:
			// Cavalier expert
			coutBoisFormation = 99;
			break;
		case 10:
			// Paladin
			coutBoisFormation = 99;
			break;
		case 11:
			// Navire de pêche
			coutBoisFormation = 99;
			break;
		case 12:
			// Navire éclaireur
			coutBoisFormation = 99;
			break;
		case 13:
			// Navire de guerre
			coutBoisFormation = 99;
			break;
		case 14:
			// Catapulte
			coutBoisFormation = 99;
			break;
		case 15:
			// Baliste
			coutBoisFormation = 99;
			break;
		case 16:
			// Eléphan de guerre
			coutBoisFormation = 99;
			break;
		case 17:
			// Mûle de commerce
			coutBoisFormation = 99;
			break;
		case 18:
			// Prêtre
			coutBoisFormation = 99;
			break;
        default:
        	coutBoisFormation = 99;
            break;
		}
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
		switch (this.idTypeUnitee) {
		case 1:
			// Villageois
			coutOrFormation = 99;
			break;
		case 2:
			// Fantassin hache
			coutOrFormation = 99;
			break;
		case 3:
			// Fantassin epée
			coutOrFormation = 99;
			break;
		case 4:
			// Légionnaire
			coutOrFormation = 99;
			break;
		case 5:
			// Archer
			coutOrFormation = 99;
			break;
		case 6:
			// Archer composite
			coutOrFormation = 99;
			break;
		case 7:
			// Archer élite
			coutOrFormation = 99;
			break;
		case 8:
			// Cavalier
			coutOrFormation = 99;
			break;
		case 9:
			// Cavalier expert
			coutOrFormation = 99;
			break;
		case 10:
			// Paladin
			coutOrFormation = 99;
			break;
		case 11:
			// Navire de pêche
			coutOrFormation = 99;
			break;
		case 12:
			// Navire éclaireur
			coutOrFormation = 99;
			break;
		case 13:
			// Navire de guerre
			coutOrFormation = 99;
			break;
		case 14:
			// Catapulte
			coutOrFormation = 99;
			break;
		case 15:
			// Baliste
			coutOrFormation = 99;
			break;
		case 16:
			// Eléphan de guerre
			coutOrFormation = 99;
			break;
		case 17:
			// Mûle de commerce
			coutOrFormation = 99;
			break;
		case 18:
			// Prêtre
			coutOrFormation = 99;
			break;
        default:
        	coutOrFormation = 99;
            break;
		}
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
		switch (this.idTypeUnitee) {
		case 1:
			// Villageois
			coutNourritureFormation = 99;
			break;
		case 2:
			// Fantassin hache
			coutNourritureFormation = 99;
			break;
		case 3:
			// Fantassin epée
			coutNourritureFormation = 99;
			break;
		case 4:
			// Légionnaire
			coutNourritureFormation = 99;
			break;
		case 5:
			// Archer
			coutNourritureFormation = 99;
			break;
		case 6:
			// Archer composite
			coutNourritureFormation = 99;
			break;
		case 7:
			// Archer élite
			coutNourritureFormation = 99;
			break;
		case 8:
			// Cavalier
			coutNourritureFormation = 99;
			break;
		case 9:
			// Cavalier expert
			coutNourritureFormation = 99;
			break;
		case 10:
			// Paladin
			coutNourritureFormation = 99;
			break;
		case 11:
			// Navire de pêche
			coutNourritureFormation = 99;
			break;
		case 12:
			// Navire éclaireur
			coutNourritureFormation = 99;
			break;
		case 13:
			// Navire de guerre
			coutNourritureFormation = 99;
			break;
		case 14:
			// Catapulte
			coutNourritureFormation = 99;
			break;
		case 15:
			// Baliste
			coutNourritureFormation = 99;
			break;
		case 16:
			// Eléphan de guerre
			coutNourritureFormation = 99;
			break;
		case 17:
			// Mûle de commerce
			coutNourritureFormation = 99;
			break;
		case 18:
			// Prêtre
			coutNourritureFormation = 99;
			break;
        default:
        	coutNourritureFormation = 99;
            break;
		}
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
		switch (this.idTypeUnitee) {
		case 1:
			// Villageois
			coutHumain = 99;
			break;
		case 2:
			// Fantassin hache
			coutHumain = 99;
			break;
		case 3:
			// Fantassin epée
			coutHumain = 99;
			break;
		case 4:
			// Légionnaire
			coutHumain = 99;
			break;
		case 5:
			// Archer
			coutHumain = 99;
			break;
		case 6:
			// Archer composite
			coutHumain = 99;
			break;
		case 7:
			// Archer élite
			coutHumain = 99;
			break;
		case 8:
			// Cavalier
			coutHumain = 99;
			break;
		case 9:
			// Cavalier expert
			coutHumain = 99;
			break;
		case 10:
			// Paladin
			coutHumain = 99;
			break;
		case 11:
			// Navire de pêche
			coutHumain = 99;
			break;
		case 12:
			// Navire éclaireur
			coutHumain = 99;
			break;
		case 13:
			// Navire de guerre
			coutHumain = 99;
			break;
		case 14:
			// Catapulte
			coutHumain = 99;
			break;
		case 15:
			// Baliste
			coutHumain = 99;
			break;
		case 16:
			// Eléphan de guerre
			coutHumain = 99;
			break;
		case 17:
			// Mûle de commerce
			coutHumain = 99;
			break;
		case 18:
			// Prêtre
			coutHumain = 99;
			break;
        default:
        	coutHumain = 99;
            break;
		}
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
		switch (this.idTypeUnitee) {
		case 1:
			// Villageois
			tempsFormation = 99;
			break;
		case 2:
			// Fantassin hache
			tempsFormation = 99;
			break;
		case 3:
			// Fantassin epée
			tempsFormation = 99;
			break;
		case 4:
			// Légionnaire
			tempsFormation = 99;
			break;
		case 5:
			// Archer
			tempsFormation = 99;
			break;
		case 6:
			// Archer composite
			tempsFormation = 99;
			break;
		case 7:
			// Archer élite
			tempsFormation = 99;
			break;
		case 8:
			// Cavalier
			tempsFormation = 99;
			break;
		case 9:
			// Cavalier expert
			tempsFormation = 99;
			break;
		case 10:
			// Paladin
			tempsFormation = 99;
			break;
		case 11:
			// Navire de pêche
			tempsFormation = 99;
			break;
		case 12:
			// Navire éclaireur
			tempsFormation = 99;
			break;
		case 13:
			// Navire de guerre
			tempsFormation = 99;
			break;
		case 14:
			// Catapulte
			tempsFormation = 99;
			break;
		case 15:
			// Baliste
			tempsFormation = 99;
			break;
		case 16:
			// Eléphan de guerre
			tempsFormation = 99;
			break;
		case 17:
			// Mûle de commerce
			tempsFormation = 99;
			break;
		case 18:
			// Prêtre
			tempsFormation = 99;
			break;
        default:
        	tempsFormation = 99;
            break;
		}
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
		switch (this.idTypeUnitee) {
		case 1:
			// Villageois
			vie = 99;
			break;
		case 2:
			// Fantassin hache
			vie = 99;
			break;
		case 3:
			// Fantassin epée
			vie = 99;
			break;
		case 4:
			// Légionnaire
			vie = 99;
			break;
		case 5:
			// Archer
			vie = 99;
			break;
		case 6:
			// Archer composite
			vie = 99;
			break;
		case 7:
			// Archer élite
			vie = 99;
			break;
		case 8:
			// Cavalier
			vie = 99;
			break;
		case 9:
			// Cavalier expert
			vie = 99;
			break;
		case 10:
			// Paladin
			vie = 99;
			break;
		case 11:
			// Navire de pêche
			vie = 99;
			break;
		case 12:
			// Navire éclaireur
			vie = 99;
			break;
		case 13:
			// Navire de guerre
			vie = 99;
			break;
		case 14:
			// Catapulte
			vie = 99;
			break;
		case 15:
			// Baliste
			vie = 99;
			break;
		case 16:
			// Eléphan de guerre
			vie = 99;
			break;
		case 17:
			// Mûle de commerce
			vie = 99;
			break;
		case 18:
			// Prêtre
			vie = 99;
			break;
        default:
        	vie = 99;
            break;
		}
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
		switch (this.idTypeUnitee) {
		case 1:
			// Villageois
			attaque = 99;
			break;
		case 2:
			// Fantassin hache
			attaque = 99;
			break;
		case 3:
			// Fantassin epée
			attaque = 99;
			break;
		case 4:
			// Légionnaire
			attaque = 99;
			break;
		case 5:
			// Archer
			attaque = 99;
			break;
		case 6:
			// Archer composite
			attaque = 99;
			break;
		case 7:
			// Archer élite
			attaque = 99;
			break;
		case 8:
			// Cavalier
			attaque = 99;
			break;
		case 9:
			// Cavalier expert
			attaque = 99;
			break;
		case 10:
			// Paladin
			attaque = 99;
			break;
		case 11:
			// Navire de pêche
			attaque = 99;
			break;
		case 12:
			// Navire éclaireur
			attaque = 99;
			break;
		case 13:
			// Navire de guerre
			attaque = 99;
			break;
		case 14:
			// Catapulte
			attaque = 99;
			break;
		case 15:
			// Baliste
			attaque = 99;
			break;
		case 16:
			// Eléphan de guerre
			attaque = 99;
			break;
		case 17:
			// Mûle de commerce
			attaque = 99;
			break;
		case 18:
			// Prêtre
			attaque = 99;
			break;
        default:
        	attaque = 99;
            break;
		}
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
		switch (this.idTypeUnitee) {
		case 1:
			// Villageois
			portee = 99;
			break;
		case 2:
			// Fantassin hache
			portee = 99;
			break;
		case 3:
			// Fantassin epée
			portee = 99;
			break;
		case 4:
			// Légionnaire
			portee = 99;
			break;
		case 5:
			// Archer
			portee = 99;
			break;
		case 6:
			// Archer composite
			portee = 99;
			break;
		case 7:
			// Archer élite
			portee = 99;
			break;
		case 8:
			// Cavalier
			portee = 99;
			break;
		case 9:
			// Cavalier expert
			portee = 99;
			break;
		case 10:
			// Paladin
			portee = 99;
			break;
		case 11:
			// Navire de pêche
			portee = 99;
			break;
		case 12:
			// Navire éclaireur
			portee = 99;
			break;
		case 13:
			// Navire de guerre
			portee = 99;
			break;
		case 14:
			// Catapulte
			portee = 99;
			break;
		case 15:
			// Baliste
			portee = 99;
			break;
		case 16:
			// Eléphan de guerre
			portee = 99;
			break;
		case 17:
			// Mûle de commerce
			portee = 99;
			break;
		case 18:
			// Prêtre
			portee = 99;
			break;
        default:
        	portee = 99;
            break;
		}
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
		switch (this.idTypeUnitee) {
		case 1:
			// Villageois
			armure = 99;
			break;
		case 2:
			// Fantassin hache
			armure = 99;
			break;
		case 3:
			// Fantassin epée
			armure = 99;
			break;
		case 4:
			// Légionnaire
			armure = 99;
			break;
		case 5:
			// Archer
			armure = 99;
			break;
		case 6:
			// Archer composite
			armure = 99;
		case 7:
			// Archer élite
			armure = 99;
			break;
		case 8:
			// Cavalier
			armure = 99;
			break;
		case 9:
			// Cavalier expert
			armure = 99;
			break;
		case 10:
			// Paladin
			armure = 99;
			break;
		case 11:
			// Navire de pêche
			armure = 99;
			break;
		case 12:
			// Navire éclaireur
			armure = 99;
			break;
		case 13:
			// Navire de guerre
			armure = 99;
			break;
		case 14:
			// Catapulte
			armure = 99;
			break;
		case 15:
			// Baliste
			armure = 99;
			break;
		case 16:
			// Eléphan de guerre
			armure = 99;
			break;
		case 17:
			// Mûle de commerce
			armure = 99;
			break;
		case 18:
			// Prêtre
			armure = 99;
			break;
        default:
        	armure = 99;
            break;
		}
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
		switch (this.idTypeUnitee) {
		case 1:
			// Villageois
			niveauBatimentNecessaireFormation = 99;
			break;
		case 2:
			// Fantassin hache
			niveauBatimentNecessaireFormation = 99;
			break;
		case 3:
			// Fantassin epée
			niveauBatimentNecessaireFormation = 99;
			break;
		case 4:
			// Légionnaire
			niveauBatimentNecessaireFormation = 99;
			break;
		case 5:
			// Archer
			niveauBatimentNecessaireFormation = 99;
			break;
		case 6:
			// Archer composite
			niveauBatimentNecessaireFormation = 99;
		case 7:
			// Archer élite
			niveauBatimentNecessaireFormation = 99;
			break;
		case 8:
			// Cavalier
			niveauBatimentNecessaireFormation = 99;
			break;
		case 9:
			// Cavalier expert
			niveauBatimentNecessaireFormation = 99;
			break;
		case 10:
			// Paladin
			niveauBatimentNecessaireFormation = 99;
			break;
		case 11:
			// Navire de pêche
			niveauBatimentNecessaireFormation = 99;
			break;
		case 12:
			// Navire éclaireur
			niveauBatimentNecessaireFormation = 99;
			break;
		case 13:
			// Navire de guerre
			niveauBatimentNecessaireFormation = 99;
			break;
		case 14:
			// Catapulte
			niveauBatimentNecessaireFormation = 99;
			break;
		case 15:
			// Baliste
			niveauBatimentNecessaireFormation = 99;
			break;
		case 16:
			// Eléphan de guerre
			niveauBatimentNecessaireFormation = 99;
			break;
		case 17:
			// Mûle de commerce
			niveauBatimentNecessaireFormation = 99;
			break;
		case 18:
			// Prêtre
			niveauBatimentNecessaireFormation = 99;
			break;
        default:
        	niveauBatimentNecessaireFormation = 99;
            break;
		}
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
		switch (this.idTypeUnitee) {
		case 17:
			// Mûle de commerce
			apportRessourceOrHeure = 99;
			break;
        default:
        	apportRessourceOrHeure = 0;
            break;
		}
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
		switch (this.idTypeUnitee) {
		case 11:
			// Navire de pêche
			apportRessourceNourritureHeure = 99;
			break;
        default:
        	apportRessourceNourritureHeure = 0;
            break;
		}
		return apportRessourceNourritureHeure;
	}


	/**
	 * @param apportRessourceNourritureHeure the apportRessourceNourritureHeure to set
	 */
	public void setApportRessourceNourritureHeure(Integer apportRessourceNourritureHeure) {
		this.apportRessourceNourritureHeure = apportRessourceNourritureHeure;
	}

    

	
    
}

