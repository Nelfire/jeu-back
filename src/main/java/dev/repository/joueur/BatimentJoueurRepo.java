package dev.repository.joueur;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import dev.entites.batiment.BatimentJoueur;


public interface BatimentJoueurRepo extends JpaRepository<BatimentJoueur, Integer> {

	List<BatimentJoueur> findByJoueurId(Integer id);
	//BatimentJoueur findByBatimentIdTypeBatiment(Integer id);

	// Bâtiments donnant un apport de ressources
	List<BatimentJoueur> findByApportPierreHeureGreaterThanAndJoueurId(Integer apportPierreHeure,Integer idJoueur);
	List<BatimentJoueur> findByApportBoisHeureGreaterThanAndJoueurId(Integer apportBoisHeure,Integer idJoueur);
	List<BatimentJoueur> findByApportOreHeureGreaterThanAndJoueurId(Integer apportOrHeure,Integer idJoueur);
	List<BatimentJoueur> findByApportNourritureHeureGreaterThanAndJoueurId(Integer apportNourritureHeure,Integer idJoueur);
	
	List<BatimentJoueur> findByQuantiteeStockagePierreGreaterThanAndJoueurId(Integer stockagePierre,Integer idJoueur);
	List<BatimentJoueur> findByQuantiteeStockageBoisGreaterThanAndJoueurId(Integer stockageBois,Integer idJoueur);
	List<BatimentJoueur> findByQuantiteeStockageOreGreaterThanAndJoueurId(Integer stockageOr,Integer idJoueur);
	List<BatimentJoueur> findByQuantiteeStockageNourritureGreaterThanAndJoueurId(Integer stockageNourriture,Integer idJoueur);
	
	List<BatimentJoueur> findByBatimentIdTypeBatiment(Integer id);
	
	
	
}
