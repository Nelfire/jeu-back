package dev.repository.joueur;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import dev.entites.batiment.BatimentJoueur;

/**
 * Repository Bâtiment Joueur
 */
public interface BatimentJoueurRepo extends JpaRepository<BatimentJoueur, Integer> {

	List<BatimentJoueur> findByJoueurId(Integer id);

	List<BatimentJoueur> findByApportPierreHeureGreaterThanAndJoueurId(Integer apportPierreHeure, Integer idJoueur);

	List<BatimentJoueur> findByApportBoisHeureGreaterThanAndJoueurId(Integer apportBoisHeure, Integer idJoueur);

	List<BatimentJoueur> findByApportOreHeureGreaterThanAndJoueurId(Integer apportOrHeure, Integer idJoueur);

	List<BatimentJoueur> findByApportNourritureHeureGreaterThanAndJoueurId(Integer apportNourritureHeure,
			Integer idJoueur);

	List<BatimentJoueur> findByQuantiteeStockagePierreGreaterThanAndJoueurId(Long stockagePierre, Integer idJoueur);

	List<BatimentJoueur> findByQuantiteeStockageBoisGreaterThanAndJoueurId(Long stockageBois, Integer idJoueur);

	List<BatimentJoueur> findByQuantiteeStockageOreGreaterThanAndJoueurId(Long stockageOr, Integer idJoueur);

	List<BatimentJoueur> findByQuantiteeStockageNourritureGreaterThanAndJoueurId(Long stockageNourriture,
			Integer idJoueur);

	List<BatimentJoueur> findByBatimentIdTypeBatiment(Integer id);

}
