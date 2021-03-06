package dev.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.entites.batiment.Batiment;
import dev.repository.batiment.BatimentRepo;
import dev.services.batiment.BatimentService;

@ExtendWith(MockitoExtension.class)
public class BatimentServiceTest {
	
	@Mock
	BatimentRepo batimentRepo;
	
	@InjectMocks
	BatimentService batimentService;

	@Test
	void informationExperienceBatiment() {
		
		when(batimentRepo.findAll()).thenReturn(new ArrayList<Batiment>());	
		
        Batiment hdv = new Batiment();
        hdv.setIdTypeBatiment(1);
        hdv.setIdCategorieBatiment(1);
        hdv.setIcone("https://media.discordapp.net/attachments/794876433842831361/808334142617026570/HotelDeVille.png");
        hdv.setLibelle("Hotel de ville");
        hdv.setDescriptif("Bâtiment principal de votre campement, l'hôtel de ville vous assure un apport régulier de ressource et vous permet également d'augmenter votre niveau de connaissance afin de créer de nouveaux types de bâtiments.");
        hdv.setOuvrierNecessaireConstruction(1);
        hdv.setTempsDeConstruction(300);
        hdv.setCoutPierreConstruction(1_000L);
        hdv.setCoutBoisConstruction(1_000L);
        hdv.setCoutOrConstruction(1_000L);
        hdv.setCoutNourritureConstruction(1_000L);
        hdv.setNiveauHotelDeVilleNecessaireConstruction(0);
        hdv.setQuantiteeStockagePierre(30_000L);
        hdv.setQuantiteeStockageBois(30_000L);
        hdv.setQuantiteeStockageOre(30_000L);
        hdv.setQuantiteeStockageNourriture(30_000L);
        hdv.setApportPierreHeure(3_600);
        hdv.setApportBoisHeure(3_600);
        hdv.setApportOreHeure(3_600);
        hdv.setApportNourritureHeure(3_600);
        hdv.setApportExperience(500L);
        hdv.setMultiplicateurExperience(3.000);
        hdv.setMultiplicateurTemps(1.888);
        hdv.setMultiplicateurApport(1.500);
        hdv.setMultiplicateurCout(3.200);
        
		
        assertEquals(500, hdv.getApportExperience());
		
	}
	
	
	
}
