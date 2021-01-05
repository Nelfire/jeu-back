package dev.repository.joueur;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.controller.dto.BatimentJoueurDto;
import dev.entites.joueur.BatimentJoueur;


public interface BatimentJoueurRepo extends JpaRepository<BatimentJoueur, Integer> {

	List<BatimentJoueur> findByJoueurId(Integer id);
	BatimentJoueur findByBatimentIdTypeBatiment(Integer id);

	List<BatimentJoueur> findByApportPierreHeureGreaterThan(Integer apportPierreHeure);
	List<BatimentJoueur> findByApportBoisHeureGreaterThan(Integer apportBoisHeure);
	List<BatimentJoueur> findByApportOreHeureGreaterThan(Integer apportOrHeure);
	List<BatimentJoueur> findByApportNourritureHeureGreaterThan(Integer apportNourritureHeure);
	
}
