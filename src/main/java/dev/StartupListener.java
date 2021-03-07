package dev;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import dev.entites.batiment.Batiment;
import dev.entites.batiment.BatimentJoueur;
import dev.entites.batiment.Defense;
import dev.entites.campagne.Campagne;
import dev.entites.campagne.CampagneArmee;
import dev.entites.expedition.Expedition;
import dev.entites.joueur.Armee;
import dev.entites.joueur.Joueur;
import dev.entites.joueur.Role;
import dev.entites.joueur.RoleJoueur;
import dev.entites.unitee.Unitee;
import dev.repository.JoueurRepo;
import dev.repository.batiment.BatimentRepo;
import dev.repository.batiment.DefenseRepo;
import dev.repository.campagne.CampagneArmeeRepo;
import dev.repository.campagne.CampagneRepo;
import dev.repository.expedition.ExpeditionRepo;
import dev.repository.joueur.ArmeeRepo;
import dev.repository.joueur.BatimentJoueurRepo;
import dev.repository.joueur.ExpeditionJoueurRepo;
import dev.repository.social.GuildeRepo;
import dev.repository.social.ListeAmisRepo;
import dev.repository.unitee.UniteeRepo;


/**
 * Code de démarrage de l'application.
 * Insertion de jeux de données.
 */
@Component
public class StartupListener {
	
    private PasswordEncoder passwordEncoder;
    // ---- Unitee ----
    private UniteeRepo uniteeRepo;
    // ---- Batiment ----
    private BatimentRepo batimentRepo;
    // ---- Defense ----
    private DefenseRepo defenseRepo;
    // - divers -
    // ---- Joueur ----
    private BatimentJoueurRepo batimentJoueurRepo;
    private JoueurRepo joueurRepo;
    private ArmeeRepo armeeRepo;
    // ---- Social ----
    private ExpeditionRepo expeditionRepo;
    private CampagneRepo campagneRepo;
    private CampagneArmeeRepo campagneArmeeRepo;
    
    public StartupListener(@Value("${app.version}") String appVersion, 
    		PasswordEncoder passwordEncoder,
    		UniteeRepo uniteeRepo,
    		BatimentRepo batimentRepo,

    		BatimentJoueurRepo batimentJoueurRepo,

    		JoueurRepo joueurRepo,
    		ArmeeRepo armeeRepo,
    		GuildeRepo guildeRepo,
    		ListeAmisRepo listeAmisRepo,
    		ExpeditionRepo expeditionRepo,
    		ExpeditionJoueurRepo expeditionJoueurRepo,
    		DefenseRepo defenseRepo,
    		CampagneRepo campagneRepo,
    		CampagneArmeeRepo campagneArmeeRepo
    		) {
        this.passwordEncoder = passwordEncoder;        
        // --- UNITEE ---
        this.uniteeRepo = uniteeRepo;
        // --- BATIMENT ---
        this.batimentRepo = batimentRepo;
//        // ---- Joueur ----
        this.batimentJoueurRepo = batimentJoueurRepo;
        this.joueurRepo = joueurRepo;
        this.armeeRepo = armeeRepo;
//        // ---- Social ----
        this.expeditionRepo = expeditionRepo;
        this.defenseRepo = defenseRepo;
        this.campagneRepo = campagneRepo;
        this.campagneArmeeRepo = campagneArmeeRepo;
    }

    @EventListener(ContextRefreshedEvent.class)
    public void onStart() {
   
        ////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////
        /////////////////////////JOUEUR/////////////////////////
        ////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////
//    	
//        Joueur joueur1 = new Joueur();
//        joueur1.setIcone("https://media.discordapp.net/attachments/794876433842831361/814268374242557972/ghost_PNG44.png?width=468&height=468");
//        joueur1.setPseudo("Nelfire");
//        joueur1.setEmail("girvincent@gmail.com");
//        joueur1.setMotDePasse(passwordEncoder.encode("password"));
//        joueur1.setDescriptif("Je broierai bien un café moi dis donc...");
//        joueur1.setNiveau(1);
//        joueur1.setExperience(0L);
//        joueur1.setPierrePossession(10_000L);
//        joueur1.setBoisPossession(10_000L);
//        joueur1.setOrPossession(10_000L);
//        joueur1.setNourriturePossession(10_000L);
//        joueur1.setPierreMaximum(20_000L);
//        joueur1.setBoisMaximum(20_000L);
//        joueur1.setOrMaximum(20_000L);
//        joueur1.setNourritureMaximum(20_000L);
//        joueur1.setPierreBoostProduction(0);
//        joueur1.setBoisBoostProduction(0);
//        joueur1.setOrBoostProduction(0);
//        joueur1.setNourritureBoostProduction(0);
//        joueur1.setTempsDeJeu(61455);
//        joueur1.setGemmePossession(99999L);
//        joueur1.setRoles(Arrays.asList(new RoleJoueur(joueur1, Role.ROLE_ADMINISTRATEUR), new RoleJoueur(joueur1, Role.ROLE_JOUEUR)));
//        joueur1.setDonateur(true);
//        joueur1.setPositionX(15);
//        joueur1.setPositionY(15);
//        this.joueurRepo.save(joueur1);
//        
//        Joueur joueur2 = new Joueur();
//        joueur2.setIcone("https://media.discordapp.net/attachments/794876433842831361/814892650678452264/admin.png?width=629&height=700");
//        joueur2.setPseudo("Admin 1");
//        joueur2.setEmail("admin1@gmail.com");
//        joueur2.setMotDePasse(passwordEncoder.encode("admin1password"));
//        joueur2.setDescriptif("Compte administrateur.");
//        joueur2.setNiveau(1);
//        joueur2.setExperience(0L);
//        joueur2.setPierrePossession(1000L);
//        joueur2.setBoisPossession(1000L);
//        joueur2.setOrPossession(1000L);
//        joueur2.setNourriturePossession(1000L);
//        joueur2.setPierreMaximum(20000L);
//        joueur2.setBoisMaximum(20000L);
//        joueur2.setOrMaximum(20000L);
//        joueur2.setNourritureMaximum(20000L);
//        joueur2.setPierreBoostProduction(0);
//        joueur2.setBoisBoostProduction(0);
//        joueur2.setOrBoostProduction(0);
//        joueur2.setNourritureBoostProduction(0);
//        joueur2.setTempsDeJeu(34140);
//        joueur2.setGemmePossession(40L);
//        joueur2.setRoles(Arrays.asList(new RoleJoueur(joueur2, Role.ROLE_ADMINISTRATEUR), new RoleJoueur(joueur2, Role.ROLE_JOUEUR)));
//        joueur2.setDonateur(false);
//        joueur2.setPositionX(8);
//        joueur2.setPositionY(24);
//        this.joueurRepo.save(joueur2);
//
//        Joueur joueur3 = new Joueur();
//        joueur3.setIcone("https://media.discordapp.net/attachments/794876433842831361/814892650678452264/admin.png?width=629&height=700");
//        joueur3.setPseudo("Admin 2");
//        joueur3.setEmail("admin2@email.com");
//        joueur3.setMotDePasse(passwordEncoder.encode("admin2password"));
//        joueur3.setDescriptif("Compte administrateur.");
//        joueur3.setNiveau(1);
//        joueur3.setExperience(0L);
//        joueur3.setPierrePossession(1000L);
//        joueur3.setBoisPossession(1000L);
//        joueur3.setOrPossession(1000L);
//        joueur3.setNourriturePossession(1000L);
//        joueur3.setPierreMaximum(20000L);
//        joueur3.setBoisMaximum(20000L);
//        joueur3.setOrMaximum(20000L);
//        joueur3.setNourritureMaximum(20000L);
//        joueur3.setPierreBoostProduction(0);
//        joueur3.setBoisBoostProduction(0);
//        joueur3.setOrBoostProduction(0);
//        joueur3.setNourritureBoostProduction(0);
//        joueur3.setTempsDeJeu(25200);
//        joueur3.setGemmePossession(40L);
//        joueur3.setRoles(Arrays.asList(new RoleJoueur(joueur3, Role.ROLE_JOUEUR)));
//        joueur3.setDonateur(false);
//        joueur3.setPositionX(21);
//        joueur3.setPositionY(17);
//        this.joueurRepo.save(joueur3);
//        
//        ////////////////////////////////////////////////////////
//        ////////////////////////////////////////////////////////
//        ////////////////////////BATIMENT////////////////////////
//        ////////////////////////////////////////////////////////
//        ////////////////////////////////////////////////////////
//        /* 
//     	1 - Hotel de ville	
//    	2 - Chaumière (augmenter limite population)
//    	3 - Carrière (farm pierre)
//    	4 - Camp de bucheron (farm bois)		
//    	5 - Camp de mineur (farm or)
//    	6 - Ferme (farm nourriture)
//    	7 - Stockage Pierre (Entrepot)	
//    	8 - Stockage Bois (Scierie)
//    	9 - Stockage Or (Banque)
//    	10 - Stockage Nourriture (Grenier)
//    	11 - Caserne Militaire	
//    	12 - Ecurie
//    	13 - Port
//    	14 - Atelier de siege
//    	15 - Forge		
//    	16 - Universite
//    	17 - Marché
//    	18 - Table d'expéditions
//         */
//        Batiment hdv = new Batiment();
//        hdv.setIdTypeBatiment(1);
//        hdv.setIdCategorieBatiment(1);
//        hdv.setIcone("https://media.discordapp.net/attachments/794876433842831361/808334142617026570/HotelDeVille.png");
//        hdv.setLibelle("Hotel de ville");
//        hdv.setDescriptif("Bâtiment principal de votre campement, l'hôtel de ville vous assure un apport régulier de ressource et vous permet également d'augmenter votre niveau de connaissance afin de créer de nouveaux types de bâtiments.");
//        hdv.setOuvrierNecessaireConstruction(1);
//        hdv.setTempsDeConstruction(300);
//        hdv.setCoutPierreConstruction(1_000L);
//        hdv.setCoutBoisConstruction(1_000L);
//        hdv.setCoutOrConstruction(1_000L);
//        hdv.setCoutNourritureConstruction(1_000L);
//        hdv.setNiveauHotelDeVilleNecessaireConstruction(0);
//        hdv.setQuantiteeStockagePierre(30_000L);
//        hdv.setQuantiteeStockageBois(30_000L);
//        hdv.setQuantiteeStockageOre(30_000L);
//        hdv.setQuantiteeStockageNourriture(30_000L);
//        hdv.setApportPierreHeure(3_600);
//        hdv.setApportBoisHeure(3_600);
//        hdv.setApportOreHeure(3_600);
//        hdv.setApportNourritureHeure(3_600);
//        hdv.setApportExperience(500L);
//        hdv.setMultiplicateurExperience(3.000);
//        hdv.setMultiplicateurTemps(1.888);
//        hdv.setMultiplicateurApport(1.500);
//        hdv.setMultiplicateurCout(3.200);
//        
//        Batiment carriere = new Batiment();
//        carriere.setIdTypeBatiment(3);
//        carriere.setIdCategorieBatiment(1);
//        carriere.setIcone("https://media.discordapp.net/attachments/794876433842831361/808335646653153330/Carriere.png");
//        carriere.setLibelle("Carrière");
//        carriere.setDescriptif("La carrière vous assure un apport régulier de pierre. Plus son niveau est élevé, plus l'apport de pierre sera important.");
//        carriere.setOuvrierNecessaireConstruction(1);
//        carriere.setTempsDeConstruction(180);
//        carriere.setCoutPierreConstruction(0L);
//        carriere.setCoutBoisConstruction(1_000L);
//        carriere.setCoutOrConstruction(450L);
//        carriere.setCoutNourritureConstruction(2_000L);
//        carriere.setNiveauHotelDeVilleNecessaireConstruction(1);
//        carriere.setQuantiteeStockagePierre(0L);
//        carriere.setQuantiteeStockageBois(0L);
//        carriere.setQuantiteeStockageOre(0L);
//        carriere.setQuantiteeStockageNourriture(0L);
//        carriere.setApportPierreHeure(6_000);
//        carriere.setApportBoisHeure(0);
//        carriere.setApportOreHeure(0);
//        carriere.setApportNourritureHeure(0);
//        carriere.setApportExperience(500L);
//        carriere.setMultiplicateurExperience(3.000);
//        carriere.setMultiplicateurTemps(1.987);
//        carriere.setMultiplicateurApport(1.650);
//        carriere.setMultiplicateurCout(3.382);
//        
//        Batiment campDeBucheron = new Batiment();
//        campDeBucheron.setIdTypeBatiment(4);
//        campDeBucheron.setIdCategorieBatiment(1);
//        campDeBucheron.setIcone("https://media.discordapp.net/attachments/794876433842831361/808335663467724800/Scierie.png");
//        campDeBucheron.setLibelle("Camp de bûcheron");
//        campDeBucheron.setDescriptif("Le camp de bûcheron vous assure un apport régulier de bois. Plus son niveau est élevé, plus l'apport de bois sera important.");
//        campDeBucheron.setOuvrierNecessaireConstruction(1);
//        campDeBucheron.setTempsDeConstruction(180);
//        campDeBucheron.setCoutPierreConstruction(750L);
//        campDeBucheron.setCoutBoisConstruction(0L);
//        campDeBucheron.setCoutOrConstruction(450L);
//        campDeBucheron.setCoutNourritureConstruction(2_000L);
//        campDeBucheron.setNiveauHotelDeVilleNecessaireConstruction(1);
//        campDeBucheron.setQuantiteeStockagePierre(0L);
//        campDeBucheron.setQuantiteeStockageBois(0L);
//        campDeBucheron.setQuantiteeStockageOre(0L);
//        campDeBucheron.setQuantiteeStockageNourriture(0L);
//        campDeBucheron.setApportPierreHeure(0);
//        campDeBucheron.setApportBoisHeure(9_000);
//        campDeBucheron.setApportOreHeure(0);
//        campDeBucheron.setApportNourritureHeure(0);
//        campDeBucheron.setApportExperience(500L);
//        campDeBucheron.setMultiplicateurExperience(3.000);
//        campDeBucheron.setMultiplicateurTemps(1.987);
//        campDeBucheron.setMultiplicateurApport(1.654);
//        campDeBucheron.setMultiplicateurCout(3.368);
//        
//        Batiment campDeMineur = new Batiment();
//        campDeMineur.setIdTypeBatiment(5);
//        campDeMineur.setIdCategorieBatiment(1);
//        campDeMineur.setIcone("https://cdn.discordapp.com/attachments/794876433842831361/794876498183323678/CampDeMineur.png");
//        campDeMineur.setLibelle("Camp de mineur");
//        campDeMineur.setDescriptif("Le camp de mineur vous assure un apport régulier d'or. Plus son niveau est élevé, plus l'apport d'or sera important.");
//        campDeMineur.setOuvrierNecessaireConstruction(1);
//        campDeMineur.setTempsDeConstruction(180);
//        campDeMineur.setCoutPierreConstruction(7_50L);
//        campDeMineur.setCoutBoisConstruction(1_000L);
//        campDeMineur.setCoutOrConstruction(0L);
//        campDeMineur.setCoutNourritureConstruction(2_000L);
//        campDeMineur.setNiveauHotelDeVilleNecessaireConstruction(1);
//        campDeMineur.setQuantiteeStockagePierre(0L);
//        campDeMineur.setQuantiteeStockageBois(0L);
//        campDeMineur.setQuantiteeStockageOre(0L);
//        campDeMineur.setQuantiteeStockageNourriture(0L);
//        campDeMineur.setApportPierreHeure(0);
//        campDeMineur.setApportBoisHeure(0);
//        campDeMineur.setApportOreHeure(3_600);
//        campDeMineur.setApportNourritureHeure(0);
//        campDeMineur.setApportExperience(500L);
//        campDeMineur.setMultiplicateurExperience(3.000);
//        campDeMineur.setMultiplicateurTemps(1.987);
//        campDeMineur.setMultiplicateurApport(1.703);
//        campDeMineur.setMultiplicateurCout(3.382);
//        
//        Batiment ferme = new Batiment();
//        ferme.setIdTypeBatiment(6);
//        ferme.setIdCategorieBatiment(1);
//        ferme.setIcone("https://cdn.discordapp.com/attachments/794876433842831361/794876556509839360/Ferme.png");
//        ferme.setLibelle("Ferme");
//        ferme.setDescriptif("La ferme vous assure un apport régulier de nourriture. Plus son niveau est élevé, plus l'apport de nourriture sera important.");
//        ferme.setOuvrierNecessaireConstruction(1);
//        ferme.setTempsDeConstruction(180);
//        ferme.setCoutPierreConstruction(750L);
//        ferme.setCoutBoisConstruction(1_000L);
//        ferme.setCoutOrConstruction(450L);
//        ferme.setCoutNourritureConstruction(0L);
//        ferme.setNiveauHotelDeVilleNecessaireConstruction(1);
//        ferme.setQuantiteeStockagePierre(0L);
//        ferme.setQuantiteeStockageBois(0L);
//        ferme.setQuantiteeStockageOre(0L);
//        ferme.setQuantiteeStockageNourriture(0L);
//        ferme.setApportPierreHeure(0);
//        ferme.setApportBoisHeure(0);
//        ferme.setApportOreHeure(0);
//        ferme.setApportNourritureHeure(18_000);
//        ferme.setApportExperience(500L);
//        ferme.setMultiplicateurExperience(3.000);
//        ferme.setMultiplicateurTemps(1.987);
//        ferme.setMultiplicateurApport(1.683);
//        ferme.setMultiplicateurCout(3.369);
//
//        Batiment entrepot = new Batiment();
//        entrepot.setIdTypeBatiment(7);
//        entrepot.setIdCategorieBatiment(2);
//        entrepot.setIcone("https://media.discordapp.net/attachments/794876433842831361/808341147192918076/Entrepot.png");
//        entrepot.setLibelle("Entrepot");
//        entrepot.setDescriptif("L'entrepot sert de point de dépôt pour la pierre.");
//        entrepot.setOuvrierNecessaireConstruction(1);
//        entrepot.setTempsDeConstruction(600);
//        entrepot.setCoutPierreConstruction(0L);
//        entrepot.setCoutBoisConstruction(2_000L);
//        entrepot.setCoutOrConstruction(900L);
//        entrepot.setCoutNourritureConstruction(4_000L);
//        entrepot.setNiveauHotelDeVilleNecessaireConstruction(1);
//        entrepot.setQuantiteeStockagePierre(13_000L);
//        entrepot.setQuantiteeStockageBois(0L);
//        entrepot.setQuantiteeStockageOre(0L);
//        entrepot.setQuantiteeStockageNourriture(0L);
//        entrepot.setApportPierreHeure(0);
//        entrepot.setApportBoisHeure(0);
//        entrepot.setApportOreHeure(0);
//        entrepot.setApportNourritureHeure(0);
//        entrepot.setApportExperience(500L);
//        entrepot.setMultiplicateurExperience(3.000);
//        entrepot.setMultiplicateurTemps(1.762);
//        entrepot.setMultiplicateurApport(2.850);
//        entrepot.setMultiplicateurCout(3.155);
//        
//        Batiment scierie = new Batiment();
//        scierie.setIdTypeBatiment(8);
//        scierie.setIdCategorieBatiment(2);
//        scierie.setIcone("https://cdn.discordapp.com/attachments/794876433842831361/794876485034311690/Banque.png");
//        scierie.setLibelle("Scierie");
//        scierie.setDescriptif("La scierie sert de point de dépôt pour le bois.");
//        scierie.setOuvrierNecessaireConstruction(1);
//        scierie.setTempsDeConstruction(600);
//        scierie.setCoutPierreConstruction(1_300L);
//        scierie.setCoutBoisConstruction(0L);
//        scierie.setCoutOrConstruction(900L);
//        scierie.setCoutNourritureConstruction(4_000L);
//        scierie.setNiveauHotelDeVilleNecessaireConstruction(1);
//        scierie.setQuantiteeStockagePierre(0L);
//        scierie.setQuantiteeStockageBois(20_000L);
//        scierie.setQuantiteeStockageOre(0L);
//        scierie.setQuantiteeStockageNourriture(0L);
//        scierie.setApportPierreHeure(0);
//        scierie.setApportBoisHeure(0);
//        scierie.setApportOreHeure(0);
//        scierie.setApportNourritureHeure(0);
//        scierie.setApportExperience(500L);
//        scierie.setMultiplicateurExperience(3.000);
//        scierie.setMultiplicateurTemps(1.762);
//        scierie.setMultiplicateurApport(2.850);
//        scierie.setMultiplicateurCout(3.158);
//        
//        Batiment banque = new Batiment();
//        banque.setIdTypeBatiment(9);
//        banque.setIdCategorieBatiment(2);
//        banque.setIcone("https://cdn.discordapp.com/attachments/794876433842831361/794876485034311690/Banque.png");
//        banque.setLibelle("Banque");
//        banque.setDescriptif("La banque sert de point de dépôt pour l'or.");
//        banque.setOuvrierNecessaireConstruction(1);
//        banque.setTempsDeConstruction(600);
//        banque.setCoutPierreConstruction(1_300L);
//        banque.setCoutBoisConstruction(2_000L);
//        banque.setCoutOrConstruction(0L);
//        banque.setCoutNourritureConstruction(4_000L);
//        banque.setNiveauHotelDeVilleNecessaireConstruction(1);
//        banque.setQuantiteeStockagePierre(0L);
//        banque.setQuantiteeStockageBois(0L);
//        banque.setQuantiteeStockageOre(9_000L);
//        banque.setQuantiteeStockageNourriture(0L);
//        banque.setApportPierreHeure(0);
//        banque.setApportBoisHeure(0);
//        banque.setApportOreHeure(0);
//        banque.setApportNourritureHeure(0);
//        banque.setApportExperience(500L);
//        banque.setMultiplicateurExperience(3.000);
//        banque.setMultiplicateurTemps(1.762);
//        banque.setMultiplicateurApport(2.900);
//        banque.setMultiplicateurCout(3.171);
//        
//        Batiment grenier = new Batiment();
//        grenier.setIdTypeBatiment(10);
//        grenier.setIdCategorieBatiment(2);
//        grenier.setIcone("https://media.discordapp.net/attachments/794876433842831361/808337913272205362/Grenier.png");
//        grenier.setLibelle("Grenier");
//        grenier.setDescriptif("Le grenier sert de point de dépôt pour la nourriture.");
//        grenier.setOuvrierNecessaireConstruction(1);
//        grenier.setTempsDeConstruction(600);
//        grenier.setCoutPierreConstruction(1_300L);
//        grenier.setCoutBoisConstruction(2_000L);
//        grenier.setCoutOrConstruction(900L);
//        grenier.setCoutNourritureConstruction(0L);
//        grenier.setNiveauHotelDeVilleNecessaireConstruction(1);
//        grenier.setQuantiteeStockagePierre(0L);
//        grenier.setQuantiteeStockageBois(0L);
//        grenier.setQuantiteeStockageOre(0L);
//        grenier.setQuantiteeStockageNourriture(40_000L);
//        grenier.setApportPierreHeure(0);
//        grenier.setApportBoisHeure(0);
//        grenier.setApportOreHeure(0);
//        grenier.setApportNourritureHeure(0);
//        grenier.setApportExperience(500L);
//        grenier.setMultiplicateurExperience(3.000);
//        grenier.setMultiplicateurTemps(1.762);
//        grenier.setMultiplicateurApport(2.900);
//        grenier.setMultiplicateurCout(3.158);
//        
//        Batiment chantier = new Batiment();
//        chantier.setIdTypeBatiment(2);
//        chantier.setIdCategorieBatiment(0);
//        chantier.setIcone("https://cdn.discordapp.com/attachments/794876433842831361/794876520338161704/Chaumiere.png");
//        chantier.setLibelle("Chantier");
//        chantier.setDescriptif("Le chantier permet la création de bâtiments de défense.");
//        chantier.setOuvrierNecessaireConstruction(1);
//        chantier.setTempsDeConstruction(2_100);
//        chantier.setCoutPierreConstruction(3_000L);
//        chantier.setCoutBoisConstruction(2_000L);
//        chantier.setCoutOrConstruction(1_000L);
//        chantier.setCoutNourritureConstruction(0L);
//        chantier.setNiveauHotelDeVilleNecessaireConstruction(4);
//        chantier.setQuantiteeStockagePierre(0L);
//        chantier.setQuantiteeStockageBois(0L);
//        chantier.setQuantiteeStockageOre(0L);
//        chantier.setQuantiteeStockageNourriture(0L);
//        chantier.setApportPierreHeure(0);
//        chantier.setApportBoisHeure(0);
//        chantier.setApportOreHeure(0);
//        chantier.setApportNourritureHeure(0);
//        chantier.setApportExperience(500L);
//        chantier.setMultiplicateurExperience(3.000);
//        chantier.setMultiplicateurTemps(1.555);
//        chantier.setMultiplicateurApport(2.000);
//        chantier.setMultiplicateurCout(3.043);
//        
//        Batiment caserneMillitaire = new Batiment();
//        caserneMillitaire.setIdTypeBatiment(11);
//        caserneMillitaire.setIdCategorieBatiment(3);
//        caserneMillitaire.setIcone("https://media.discordapp.net/attachments/794876433842831361/808333625426313246/Camp_militaire.png");
//        caserneMillitaire.setLibelle("Caserne militaire");
//        caserneMillitaire.setDescriptif("La caserne militaire permet la création d'unités d'infanterie légère.");
//        caserneMillitaire.setOuvrierNecessaireConstruction(1);
//        caserneMillitaire.setTempsDeConstruction(900);
//        caserneMillitaire.setCoutPierreConstruction(3_000L);
//        caserneMillitaire.setCoutBoisConstruction(2_000L);
//        caserneMillitaire.setCoutOrConstruction(1_000L);
//        caserneMillitaire.setCoutNourritureConstruction(3_500L);
//        caserneMillitaire.setNiveauHotelDeVilleNecessaireConstruction(2);
//        caserneMillitaire.setQuantiteeStockagePierre(0L);
//        caserneMillitaire.setQuantiteeStockageBois(0L);
//        caserneMillitaire.setQuantiteeStockageOre(0L);
//        caserneMillitaire.setQuantiteeStockageNourriture(0L);
//        caserneMillitaire.setApportPierreHeure(0);
//        caserneMillitaire.setApportBoisHeure(0);
//        caserneMillitaire.setApportOreHeure(0);
//        caserneMillitaire.setApportNourritureHeure(0);
//        caserneMillitaire.setApportExperience(500L);
//        caserneMillitaire.setMultiplicateurExperience(3.000);
//        caserneMillitaire.setMultiplicateurTemps(1.692);
//        caserneMillitaire.setMultiplicateurApport(0.000);
//        caserneMillitaire.setMultiplicateurCout(2.990);
//        
//        Batiment ecurie = new Batiment();
//        ecurie.setIdTypeBatiment(12);
//        ecurie.setIdCategorieBatiment(3);
//        ecurie.setIcone("https://media.discordapp.net/attachments/794876433842831361/808333303592779876/ecurie.png");
//        ecurie.setLibelle("Ecurie");
//        ecurie.setDescriptif("L'écurie permet la création d'unités de cavalerie.");
//        ecurie.setOuvrierNecessaireConstruction(1);
//        ecurie.setTempsDeConstruction(900);
//        ecurie.setCoutPierreConstruction(1_500L);
//        ecurie.setCoutBoisConstruction(3_000L);
//        ecurie.setCoutOrConstruction(1_000L);
//        ecurie.setCoutNourritureConstruction(4_500L);
//        ecurie.setNiveauHotelDeVilleNecessaireConstruction(2);
//        ecurie.setQuantiteeStockagePierre(0L);
//        ecurie.setQuantiteeStockageBois(0L);
//        ecurie.setQuantiteeStockageOre(0L);
//        ecurie.setQuantiteeStockageNourriture(0L);
//        ecurie.setApportPierreHeure(0);
//        ecurie.setApportBoisHeure(0);
//        ecurie.setApportOreHeure(0);
//        ecurie.setApportNourritureHeure(0);
//        ecurie.setApportExperience(500L);
//        ecurie.setMultiplicateurExperience(3.000);
//        ecurie.setMultiplicateurTemps(1.692);
//        ecurie.setMultiplicateurApport(0.000);
//        ecurie.setMultiplicateurCout(3.010);
//        
//        Batiment port = new Batiment();
//        port.setIdTypeBatiment(13);
//        port.setIdCategorieBatiment(3);
//        port.setIcone("https://media.discordapp.net/attachments/794876433842831361/808341626640400484/Port.png");
//        port.setLibelle("Port");
//        port.setDescriptif("Le port permet la création d'unitées navale.");
//        port.setOuvrierNecessaireConstruction(1);
//        port.setTempsDeConstruction(900);
//        port.setCoutPierreConstruction(1_500L);
//        port.setCoutBoisConstruction(4_000L);
//        port.setCoutOrConstruction(1_000L);
//        port.setCoutNourritureConstruction(2_000L);
//        port.setNiveauHotelDeVilleNecessaireConstruction(3);
//        port.setQuantiteeStockagePierre(0L);
//        port.setQuantiteeStockageBois(0L);
//        port.setQuantiteeStockageOre(0L);
//        port.setQuantiteeStockageNourriture(0L);
//        port.setApportPierreHeure(0);
//        port.setApportBoisHeure(0);
//        port.setApportOreHeure(0);
//        port.setApportNourritureHeure(0);
//        port.setApportExperience(500L);
//        port.setMultiplicateurExperience(3.000);
//        port.setMultiplicateurTemps(1.692);
//        port.setMultiplicateurApport(0.000);
//        port.setMultiplicateurCout(3.018);
//        
//        Batiment atelierDeSiege = new Batiment();
//        atelierDeSiege.setIdTypeBatiment(14);
//        atelierDeSiege.setIdCategorieBatiment(3);
//        atelierDeSiege.setIcone("https://cdn.discordapp.com/attachments/794876433842831361/794876478667751444/AtelierDeSiege.png");
//        atelierDeSiege.setLibelle("Atelier de siège");
//        atelierDeSiege.setDescriptif("L'atelier de siège permet la création d'unitées de combat lourde.");
//        atelierDeSiege.setOuvrierNecessaireConstruction(1);
//        atelierDeSiege.setTempsDeConstruction(1_200);
//        atelierDeSiege.setCoutPierreConstruction(4_000L);
//        atelierDeSiege.setCoutBoisConstruction(4_000L);
//        atelierDeSiege.setCoutOrConstruction(2_000L);
//        atelierDeSiege.setCoutNourritureConstruction(1_000L);
//        atelierDeSiege.setNiveauHotelDeVilleNecessaireConstruction(4);
//        atelierDeSiege.setQuantiteeStockagePierre(0L);
//        atelierDeSiege.setQuantiteeStockageBois(0L);
//        atelierDeSiege.setQuantiteeStockageOre(0L);
//        atelierDeSiege.setQuantiteeStockageNourriture(0L);
//        atelierDeSiege.setApportPierreHeure(0);
//        atelierDeSiege.setApportBoisHeure(0);
//        atelierDeSiege.setApportOreHeure(0);
//        atelierDeSiege.setApportNourritureHeure(0);
//        atelierDeSiege.setApportExperience(500L);
//        atelierDeSiege.setMultiplicateurExperience(3.000);
//        atelierDeSiege.setMultiplicateurTemps(1.650);
//        atelierDeSiege.setMultiplicateurApport(0.000);
//        atelierDeSiege.setMultiplicateurCout(2.881);
//        
//        Batiment forge = new Batiment();
//        forge.setIdTypeBatiment(15);
//        forge.setIdCategorieBatiment(0);
//        forge.setIcone("https://media.discordapp.net/attachments/794876433842831361/808337592025743380/Forge2.png");
//        forge.setLibelle("Forge");
//        forge.setDescriptif("La forge permet l'amélioration d'unités de combat et de défenses.");
//        forge.setOuvrierNecessaireConstruction(1);
//        forge.setTempsDeConstruction(3_600);
//        forge.setCoutPierreConstruction(30_000L);
//        forge.setCoutBoisConstruction(40_000L);
//        forge.setCoutOrConstruction(20_000L);
//        forge.setCoutNourritureConstruction(40_000L);
//        forge.setNiveauHotelDeVilleNecessaireConstruction(7);
//        forge.setQuantiteeStockagePierre(0L);
//        forge.setQuantiteeStockageBois(0L);
//        forge.setQuantiteeStockageOre(0L);
//        forge.setQuantiteeStockageNourriture(0L);
//        forge.setApportPierreHeure(0);
//        forge.setApportBoisHeure(0);
//        forge.setApportOreHeure(0);
//        forge.setApportNourritureHeure(0);
//        forge.setApportExperience(500L);
//        forge.setMultiplicateurExperience(3.000);
//        forge.setMultiplicateurTemps(1.500);
//        forge.setMultiplicateurApport(0.000);
//        forge.setMultiplicateurCout(2.289);
//                
//        Batiment universite = new Batiment();
//        universite.setIdTypeBatiment(16);
//        universite.setIdCategorieBatiment(3);
//        universite.setIcone("https://media.discordapp.net/attachments/794876433842831361/808335597034537003/Bibliotheque.png");
//        universite.setLibelle("Université");
//        universite.setDescriptif("L'université permet la création d'unités de combat et le développement de technologies.");
//        universite.setOuvrierNecessaireConstruction(1);
//        universite.setTempsDeConstruction(1_800);
//        universite.setCoutPierreConstruction(4_000L);
//        universite.setCoutBoisConstruction(2_500L);
//        universite.setCoutOrConstruction(4_000L);
//        universite.setCoutNourritureConstruction(2_000L);
//        universite.setNiveauHotelDeVilleNecessaireConstruction(7);
//        universite.setQuantiteeStockagePierre(0L);
//        universite.setQuantiteeStockageBois(0L);
//        universite.setQuantiteeStockageOre(0L);
//        universite.setQuantiteeStockageNourriture(0L);
//        universite.setApportPierreHeure(0);
//        universite.setApportBoisHeure(0);
//        universite.setApportOreHeure(0);
//        universite.setApportNourritureHeure(0);
//        universite.setApportExperience(500L);
//        universite.setMultiplicateurExperience(3.000);
//        universite.setMultiplicateurTemps(1.579);
//        universite.setMultiplicateurApport(0.000);
//        universite.setMultiplicateurCout(2.816);
//                
//        Batiment marche = new Batiment();
//        marche.setIdTypeBatiment(17);
//        marche.setIdCategorieBatiment(0);
//        marche.setIcone("https://media.discordapp.net/attachments/794876433842831361/808342149753077801/Marche.png");
//        marche.setLibelle("Marché");
//        marche.setDescriptif("Le marché permet l'échange de ressources. Plus son niveau sera élevé, meilleur seront les taux de change proposés par les marchands.");
//        marche.setOuvrierNecessaireConstruction(1);
//        marche.setTempsDeConstruction(1_800);
//        marche.setCoutPierreConstruction(250_000L);
//        marche.setCoutBoisConstruction(250_000L);
//        marche.setCoutOrConstruction(250_000L);
//        marche.setCoutNourritureConstruction(250_000L);
//        marche.setNiveauHotelDeVilleNecessaireConstruction(3);
//        marche.setQuantiteeStockagePierre(0L);
//        marche.setQuantiteeStockageBois(0L);
//        marche.setQuantiteeStockageOre(0L);
//        marche.setQuantiteeStockageNourriture(0L);
//        marche.setApportPierreHeure(0);
//        marche.setApportBoisHeure(0);
//        marche.setApportOreHeure(0);
//        marche.setApportNourritureHeure(0);
//        marche.setApportExperience(25_000L);
//        marche.setMultiplicateurExperience(6.000);
//        marche.setMultiplicateurTemps(4.000);
//        marche.setMultiplicateurApport(0.000);
//        marche.setMultiplicateurCout(8.000);
//                
//        Batiment tableExpedition = new Batiment();
//		tableExpedition.setIdTypeBatiment(18);
//        tableExpedition.setIdCategorieBatiment(0);
//        tableExpedition.setIcone("https://media.discordapp.net/attachments/794876433842831361/808342166874357770/CampExpedition.png");
//        tableExpedition.setLibelle("Table d'expédition");
//        tableExpedition.setDescriptif("La table d'expédition vous permet d'envoyer vos unités en expédition. Plus son niveau sera élevé, plus vous serez en mesure de lancer des expéditions en simultané.");
//        tableExpedition.setOuvrierNecessaireConstruction(1);
//        tableExpedition.setTempsDeConstruction(1_500);
//        tableExpedition.setCoutPierreConstruction(40_000L);
//        tableExpedition.setCoutBoisConstruction(20_000L);
//        tableExpedition.setCoutOrConstruction(20_000L);
//        tableExpedition.setCoutNourritureConstruction(30_000L);
//        tableExpedition.setNiveauHotelDeVilleNecessaireConstruction(2);
//        tableExpedition.setQuantiteeStockagePierre(0L);
//        tableExpedition.setQuantiteeStockageBois(0L);
//        tableExpedition.setQuantiteeStockageOre(0L);
//        tableExpedition.setQuantiteeStockageNourriture(0L);
//        tableExpedition.setApportPierreHeure(0);
//        tableExpedition.setApportBoisHeure(0);
//        tableExpedition.setApportOreHeure(0);
//        tableExpedition.setApportNourritureHeure(0);
//        tableExpedition.setApportExperience(500L);
//        tableExpedition.setMultiplicateurExperience(3.000);
//        tableExpedition.setMultiplicateurTemps(1.600);
//        tableExpedition.setMultiplicateurApport(0.000);
//        tableExpedition.setMultiplicateurCout(2.528);
//                
//        this.batimentRepo.save(hdv);
//        this.batimentRepo.save(carriere);
//        this.batimentRepo.save(campDeBucheron);
//        this.batimentRepo.save(campDeMineur);
//        this.batimentRepo.save(ferme);
//        this.batimentRepo.save(entrepot);
//        this.batimentRepo.save(scierie);
//        this.batimentRepo.save(banque);
//        this.batimentRepo.save(grenier);
//        this.batimentRepo.save(chantier);
//        this.batimentRepo.save(caserneMillitaire);
//        this.batimentRepo.save(ecurie);
//        this.batimentRepo.save(port);
//        this.batimentRepo.save(atelierDeSiege);
//        this.batimentRepo.save(forge);
//        this.batimentRepo.save(universite);
//        this.batimentRepo.save(marche);
//        this.batimentRepo.save(tableExpedition);
//        
//        ////////////////////////////////////////////////////////
//        ////////////////////////////////////////////////////////
//        ////////////////////////DEFENSES////////////////////////
//        ////////////////////////////////////////////////////////
//        ////////////////////////////////////////////////////////
//		// Initialisation poids
//
//        // -- DEFENSES --
//        // - Offensif -
//		// - tour -
//		
//        Defense tour = new Defense();
//        tour.setIdTypeDefense(1);
//        tour.setTypeDefense(1);
//        tour.setIcone("https://cdn.discordapp.com/attachments/794876433842831361/794876513039417404/CaserneMillitaire.png");
//        tour.setLibelle("Tour de guet");
//        tour.setDescription("Description de la tour");
//        tour.setCoutPierreConstruction(200);
//        tour.setCoutBoisConstruction(500);
//        tour.setCoutOrConstruction(100);
//        tour.setCoutNourritureConstruction(0);
//        tour.setVie(58);
//        tour.setAttaque(2);
//        tour.setPortee(10);
//        tour.setArmure(3);
//        tour.setTempsConstruction(20);
//        tour.setNiveauBatimentNecessaireConstruction(1);
//        tour.setIdBatimentProvenance(2);
//        tour.setApportExperience(42L);
//        
//        Defense posteAvance = new Defense();
//        posteAvance.setIdTypeDefense(2);
//        posteAvance.setTypeDefense(1);
//        posteAvance.setIcone("https://media.discordapp.net/attachments/794876433842831361/815905021275144192/PosteAvance.png");
//        posteAvance.setLibelle("Poste avancé");
//        posteAvance.setDescription("Description du poste avancé");
//        posteAvance.setCoutPierreConstruction(25_000);
//        posteAvance.setCoutBoisConstruction(20_000);
//        posteAvance.setCoutOrConstruction(8_000);
//        posteAvance.setCoutNourritureConstruction(0);
//        posteAvance.setVie(5_812);
//        posteAvance.setAttaque(194);
//        posteAvance.setPortee(10);
//        posteAvance.setArmure(290);
//        posteAvance.setTempsConstruction(110);
//        posteAvance.setNiveauBatimentNecessaireConstruction(5);
//        posteAvance.setIdBatimentProvenance(2);
//        posteAvance.setApportExperience(110L);
//        
//        Defense tourDeBombarde = new Defense();
//        tourDeBombarde.setIdTypeDefense(3);
//        tourDeBombarde.setTypeDefense(1);
//        tourDeBombarde.setIcone("https://media.discordapp.net/attachments/794876433842831361/815905007244279861/TourDeBombarde.png");
//        tourDeBombarde.setLibelle("Tour de bombarde");
//        tourDeBombarde.setDescription("Description de la tour de bombarde");
//        tourDeBombarde.setCoutPierreConstruction(1_200_000);
//        tourDeBombarde.setCoutBoisConstruction(300_000);
//        tourDeBombarde.setCoutOrConstruction(100_000);
//        tourDeBombarde.setCoutNourritureConstruction(0);
//        tourDeBombarde.setVie(211_500);
//        tourDeBombarde.setAttaque(7_050);
//        tourDeBombarde.setPortee(10);
//        tourDeBombarde.setArmure(10_575);
//        tourDeBombarde.setTempsConstruction(175);
//        tourDeBombarde.setNiveauBatimentNecessaireConstruction(8);
//        tourDeBombarde.setIdBatimentProvenance(2);
//        tourDeBombarde.setApportExperience(94_000L);
//        
//        Defense donjon = new Defense();
//        donjon.setIdTypeDefense(4);
//        donjon.setTypeDefense(1);
//        donjon.setIcone("https://media.discordapp.net/attachments/794876433842831361/815905044787494922/Donjon.png");
//        donjon.setLibelle("Donjon");
//        donjon.setDescription("Description du donjon");
//        donjon.setCoutPierreConstruction(25_000_000);
//        donjon.setCoutBoisConstruction(11_000_000);
//        donjon.setCoutOrConstruction(5_000_000);
//        donjon.setCoutNourritureConstruction(0);
//        donjon.setVie(6_405_000);
//        donjon.setAttaque(213_500);
//        donjon.setPortee(10);
//        donjon.setArmure(320_250);
//        donjon.setTempsConstruction(240);
//        donjon.setNiveauBatimentNecessaireConstruction(11);
//        donjon.setIdBatimentProvenance(2);
//        donjon.setApportExperience(2_440_000L);
//
//        // - Défensif -
//        Defense murFortifie = new Defense();
//        murFortifie.setIdTypeDefense(5);
//        murFortifie.setTypeDefense(2);
//        murFortifie.setIcone("https://media.discordapp.net/attachments/794876433842831361/808330333325099068/MurFortifie.png");
//        murFortifie.setLibelle("Mur fortifié");
//        murFortifie.setDescription("Description du mur fortifié");
//        murFortifie.setCoutPierreConstruction(600);
//        murFortifie.setCoutBoisConstruction(0);
//        murFortifie.setCoutOrConstruction(0);
//        murFortifie.setCoutNourritureConstruction(0);
//        murFortifie.setVie(66);
//        murFortifie.setAttaque(0);
//        murFortifie.setPortee(0);
//        murFortifie.setArmure(4);
//        murFortifie.setTempsConstruction(20);
//        murFortifie.setNiveauBatimentNecessaireConstruction(1);
//        murFortifie.setIdBatimentProvenance(2);
//        murFortifie.setApportExperience(36L);
//        
//        Defense defense2 = new Defense();
//        defense2.setIdTypeDefense(6);
//        defense2.setTypeDefense(2);
//        defense2.setIcone("https://media.discordapp.net/attachments/794876433842831361/808330333325099068/MurFortifie.png");
//        defense2.setLibelle("Défense 2");
//        defense2.setDescription("Description de la défense 2");
//        defense2.setCoutPierreConstruction(25_000);
//        defense2.setCoutBoisConstruction(25_000);
//        defense2.setCoutOrConstruction(5_000);
//        defense2.setCoutNourritureConstruction(0);
//        defense2.setVie(7_500);
//        defense2.setAttaque(0);
//        defense2.setPortee(0);
//        defense2.setArmure(375);
//        defense2.setTempsConstruction(110);
//        defense2.setNiveauBatimentNecessaireConstruction(5);
//        defense2.setIdBatimentProvenance(2);
//        defense2.setApportExperience(3_000L);
//        
//        Defense defense3 = new Defense();
//        defense3.setIdTypeDefense(7);
//        defense3.setTypeDefense(2);
//        defense3.setIcone("https://media.discordapp.net/attachments/794876433842831361/808330333325099068/MurFortifie.png");
//        defense3.setLibelle("Défense 3");
//        defense3.setDescription("Description de la défense 3");
//        defense3.setCoutPierreConstruction(600_000);
//        defense3.setCoutBoisConstruction(1_000_000);
//        defense3.setCoutOrConstruction(100_000);
//        defense3.setCoutNourritureConstruction(0);
//        defense3.setVie(258_000);
//        defense3.setAttaque(0);
//        defense3.setPortee(0);
//        defense3.setArmure(12_900);
//        defense3.setTempsConstruction(175);
//        defense3.setNiveauBatimentNecessaireConstruction(8);
//        defense3.setIdBatimentProvenance(2);
//        defense3.setApportExperience(86_000L);
//        
//        Defense chevalDeFrise = new Defense();
//        chevalDeFrise.setIdTypeDefense(8);
//        chevalDeFrise.setTypeDefense(2);
//        chevalDeFrise.setIcone("https://media.discordapp.net/attachments/794876433842831361/816337739778621501/chevalDeFrise.png?width=842&height=701");
//        chevalDeFrise.setLibelle("Cheval de frise");
//        chevalDeFrise.setDescription("Description du cheval de frise");
//        chevalDeFrise.setCoutPierreConstruction(20_000_000);
//        chevalDeFrise.setCoutBoisConstruction(10_000_000);
//        chevalDeFrise.setCoutOrConstruction(9_000_000);
//        chevalDeFrise.setCoutNourritureConstruction(0);
//        chevalDeFrise.setVie(8_750_000);
//        chevalDeFrise.setAttaque(0);
//        chevalDeFrise.setPortee(0);
//        chevalDeFrise.setArmure(437_500);
//        chevalDeFrise.setTempsConstruction(240);
//        chevalDeFrise.setNiveauBatimentNecessaireConstruction(11);
//        chevalDeFrise.setIdBatimentProvenance(2);
//        chevalDeFrise.setApportExperience(2_500_000L);
//        
//        this.defenseRepo.save(tour);
//        this.defenseRepo.save(posteAvance);
//        this.defenseRepo.save(tourDeBombarde);
//        this.defenseRepo.save(donjon);
//        this.defenseRepo.save(murFortifie);
//        this.defenseRepo.save(defense2);
//        this.defenseRepo.save(defense3);
//        this.defenseRepo.save(chevalDeFrise);
//        
//        ////////////////////////////////////////////////////////
//        ////////////////////////////////////////////////////////
//        ////////////////////BATIMENT JOUEUR/////////////////////
//        ////////////////////////////////////////////////////////
//        ////////////////////////////////////////////////////////
////		long debut = new Date().getTime();
////		long fin = new Date().getTime();
////
////		BatimentJoueur batimentJoueur1 = new BatimentJoueur(joueur1,hdv,1,0,1,1l,1l,1l,1l,1l,1l,1l,1l,1,1,1,1,debut,fin);
////		BatimentJoueur batimentJoueur2 = new BatimentJoueur(joueur1,tableExpedition,1,0,1,1l,1l,1l,1l,1l,1l,1l,1l,1,1,1,1,debut,fin);
////		BatimentJoueur batimentJoueur3 = new BatimentJoueur(joueur1,chantier,1,0,1,1l,1l,1l,1l,1l,1l,1l,1l,1,1,1,1,debut,fin);
////		BatimentJoueur batimentJoueur4 = new BatimentJoueur(joueur1,marche,1,0,1,1l,1l,1l,1l,1l,1l,1l,1l,1,1,1,1,debut,fin);
////		this.batimentJoueurRepo.save(batimentJoueur1);
////		this.batimentJoueurRepo.save(batimentJoueur2);
////		this.batimentJoueurRepo.save(batimentJoueur3);
////		this.batimentJoueurRepo.save(batimentJoueur4);
//		
//		
//        ////////////////////////////////////////////////////////
//        ////////////////////////////////////////////////////////
//        /////////////////////////UNITE//////////////////////////
//        ////////////////////////////////////////////////////////
//        ////////////////////////////////////////////////////////
//	    //1 villageois 
//		//2 archer 
//		//3 archerComposite
//		//4 fantassinEpee
//		//5 hommeDArme 
//		//6 lanceurDeHache
//		//7 milicien 
//		//8 piquier 
//		//9 cavalierArcher
//		//10 cavalier
//		//11 champion 
//		//12 bateauDePeche 
//		//13 bateauIncendiaire 
//		//14 bateauDeDestruction
//		//15 galionACanon
//		//16 galion
//		//17 guerrierElite
//		//18 phalange
//		//19 samourai
//		//20 templier
//		//21 catapulte
//		//22 elephantDeCombat
//		//23 pretre
//
//		// ---------------------------- //
//		// ------ HOTEL DE VILLE ------ //
//		// ---------------------------- //
//		// Villageois
//		Unitee villageois = new Unitee();
//		villageois.setIdTypeUnitee(1);
//		villageois.setIdBatimentProvenance(1);
//		villageois.setIcone("https://media.discordapp.net/attachments/794876433842831361/799986427348647964/Villageois.png");
//		villageois.setLibelle("Villageois");
//		villageois.setDescriptif("Descriptif du villageois");
//		villageois.setCoutPierreFormation(0);
//		villageois.setCoutBoisFormation(0);
//		villageois.setCoutOrFormation(0);
//		villageois.setCoutNourritureFormation(2_150);
//		villageois.setCoutHumain(1);
//		villageois.setTempsFormation(20);
//		villageois.setVie(30);
//		villageois.setAttaque(1);
//		villageois.setPortee(1);
//		villageois.setArmure(1);
//		villageois.setVitesse(12);
//		villageois.setNiveauBatimentNecessaireFormation(1);
//		villageois.setApportRessourcePierreHeure(0);
//		villageois.setApportRessourceBoisHeure(0);
//		villageois.setApportRessourceOrHeure(0);
//		villageois.setApportRessourceNourritureHeure(0);
//		villageois.setApportExperience(43);
//		
//		// ------------------------------- //
//		// ------ CASERNE MILITAIRE ------ //
//		// ------------------------------- //
//		// Archer
//		Unitee archer = new Unitee();
//		archer.setIdTypeUnitee(2);
//		archer.setIdBatimentProvenance(11);
//		archer.setIcone("https://media.discordapp.net/attachments/794876433842831361/799986264299405342/Archer.png");
//		archer.setLibelle("Archer");
//		archer.setDescriptif("Descriptif de l'archer");
//		archer.setCoutPierreFormation(0);
//		archer.setCoutBoisFormation(800);
//		archer.setCoutOrFormation(100);
//		archer.setCoutNourritureFormation(1_500);
//		archer.setCoutHumain(1);
//		archer.setTempsFormation(25);
//		archer.setVie(50);
//		archer.setAttaque(2);
//		archer.setPortee(5);
//		archer.setArmure(2);
//		archer.setVitesse(10);
//		archer.setNiveauBatimentNecessaireFormation(1);
//		archer.setApportRessourcePierreHeure(0);
//		archer.setApportRessourceBoisHeure(0);
//		archer.setApportRessourceOrHeure(0);
//		archer.setApportRessourceNourritureHeure(0);
//		archer.setApportExperience(72);
//		
//		// Archer Composite
//		Unitee archerComposite = new Unitee();
//		archerComposite.setIdTypeUnitee(2);
//		archerComposite.setIdBatimentProvenance(11);
//		archerComposite.setIcone("https://media.discordapp.net/attachments/794876433842831361/799986256377151518/Archer_Composite.png");
//		archerComposite.setLibelle("Archer composite");
//		archerComposite.setDescriptif("Descriptif de l'archer composite");
//		archerComposite.setCoutPierreFormation(0);
//		archerComposite.setCoutBoisFormation(4_500);
//		archerComposite.setCoutOrFormation(700);
//		archerComposite.setCoutNourritureFormation(6_500);
//		archerComposite.setCoutHumain(1);
//		archerComposite.setTempsFormation(65);
//		archerComposite.setVie(310);
//		archerComposite.setAttaque(10);
//		archerComposite.setPortee(7);
//		archerComposite.setArmure(15);
//		archerComposite.setVitesse(10);
//		archerComposite.setNiveauBatimentNecessaireFormation(3);
//		archerComposite.setApportRessourcePierreHeure(0);
//		archerComposite.setApportRessourceBoisHeure(0);
//		archerComposite.setApportRessourceOrHeure(0);
//		archerComposite.setApportRessourceNourritureHeure(0);
//		archerComposite.setApportExperience(380);
//		
//		// Fantassin Epee
//		Unitee fantassinEpee = new Unitee();
//		fantassinEpee.setIdTypeUnitee(2);
//		fantassinEpee.setIdBatimentProvenance(11);
//		fantassinEpee.setIcone("https://media.discordapp.net/attachments/794876433842831361/799986321065771018/Fantassin_epee.png");
//		fantassinEpee.setLibelle("Fantassin épée");
//		fantassinEpee.setDescriptif("Descriptif du fantassin épée");
//		fantassinEpee.setCoutPierreFormation(0);
//		fantassinEpee.setCoutBoisFormation(46_000);
//		fantassinEpee.setCoutOrFormation(60_000);
//		fantassinEpee.setCoutNourritureFormation(121_000);
//		fantassinEpee.setCoutHumain(1);
//		fantassinEpee.setTempsFormation(130);
//		fantassinEpee.setVie(10_260);
//		fantassinEpee.setAttaque(342);
//		fantassinEpee.setPortee(3);
//		fantassinEpee.setArmure(510);
//		fantassinEpee.setVitesse(10);
//		fantassinEpee.setNiveauBatimentNecessaireFormation(6);
//		fantassinEpee.setApportRessourcePierreHeure(0);
//		fantassinEpee.setApportRessourceBoisHeure(0);
//		fantassinEpee.setApportRessourceOrHeure(0);
//		fantassinEpee.setApportRessourceNourritureHeure(0);
//		fantassinEpee.setApportExperience(10_260);
//		
//		// Piquier
//		Unitee piquier = new Unitee();
//		piquier.setIdTypeUnitee(2);
//		piquier.setIdBatimentProvenance(11);
//		piquier.setIcone("https://media.discordapp.net/attachments/794876433842831361/799986398294704168/Piquier.png");
//		piquier.setLibelle("Piquier");
//		piquier.setDescriptif("Descriptif du piquier");
//		piquier.setCoutPierreFormation(0);
//		piquier.setCoutBoisFormation(300_000);
//		piquier.setCoutOrFormation(140_000);
//		piquier.setCoutNourritureFormation(230_000);
//		piquier.setCoutHumain(1);
//		piquier.setTempsFormation(150);
//		piquier.setVie(32_512);
//		piquier.setAttaque(1_080);
//		piquier.setPortee(4);
//		piquier.setArmure(1625);
//		piquier.setVitesse(10);
//		piquier.setNiveauBatimentNecessaireFormation(7);
//		piquier.setApportRessourcePierreHeure(0);
//		piquier.setApportRessourceBoisHeure(0);
//		piquier.setApportRessourceOrHeure(0);
//		piquier.setApportRessourceNourritureHeure(0);
//		piquier.setApportExperience(30_600);		
//		
//		// Lanceur de Hâche
//		Unitee lanceurDeHache = new Unitee();
//		lanceurDeHache.setIdTypeUnitee(2);
//		lanceurDeHache.setIdBatimentProvenance(11);
//		lanceurDeHache.setIcone("https://media.discordapp.net/attachments/794876433842831361/799986377042165770/Lanceur_de_hache.png");
//		lanceurDeHache.setLibelle("Lanceur de hache");
//		lanceurDeHache.setDescriptif("Descriptif du lanceur de hache");
//		lanceurDeHache.setCoutPierreFormation(550_000);
//		lanceurDeHache.setCoutBoisFormation(350_000);
//		lanceurDeHache.setCoutOrFormation(250_000);
//		lanceurDeHache.setCoutNourritureFormation(1_000_000);
//		lanceurDeHache.setCoutHumain(1);
//		lanceurDeHache.setTempsFormation(175);
//		lanceurDeHache.setVie(103_500);
//		lanceurDeHache.setAttaque(3_450);
//		lanceurDeHache.setPortee(9);
//		lanceurDeHache.setArmure(5_175);
//		lanceurDeHache.setVitesse(10);
//		lanceurDeHache.setNiveauBatimentNecessaireFormation(8);
//		lanceurDeHache.setApportRessourcePierreHeure(0);
//		lanceurDeHache.setApportRessourceBoisHeure(0);
//		lanceurDeHache.setApportRessourceOrHeure(0);
//		lanceurDeHache.setApportRessourceNourritureHeure(0);
//		lanceurDeHache.setApportExperience(92_000);
//		
//		// Milicien
//		Unitee milicien = new Unitee();
//		milicien.setIdTypeUnitee(2);
//		milicien.setIdBatimentProvenance(11);
//		milicien.setIcone("https://media.discordapp.net/attachments/794876433842831361/799986387787972648/Milicien.png");
//		milicien.setLibelle("Milicien");
//		milicien.setDescriptif("Descriptif du milicien");
//		milicien.setCoutPierreFormation(0);
//		milicien.setCoutBoisFormation(3_300_000);
//		milicien.setCoutOrFormation(400_000);
//		milicien.setCoutNourritureFormation(5_100_000);
//		milicien.setCoutHumain(1);
//		milicien.setTempsFormation(200);
//		milicien.setVie(325375);
//		milicien.setAttaque(10845);
//		milicien.setPortee(5);
//		milicien.setArmure(16260);
//		milicien.setVitesse(10);
//		milicien.setNiveauBatimentNecessaireFormation(9);
//		milicien.setApportRessourcePierreHeure(0);
//		milicien.setApportRessourceBoisHeure(0);
//		milicien.setApportRessourceOrHeure(0);
//		milicien.setApportRessourceNourritureHeure(0);
//		milicien.setApportExperience(274_000);
//				
//		// Homme d'arme
//		Unitee hommeDArme = new Unitee();
//		hommeDArme.setIdTypeUnitee(2);
//		hommeDArme.setIdBatimentProvenance(11);
//		hommeDArme.setIcone("https://media.discordapp.net/attachments/794876433842831361/799986373188255764/Homme_darme.png");
//		hommeDArme.setLibelle("Homme d'arme");
//		hommeDArme.setDescriptif("Descriptif de l'homme d'arme");
//		hommeDArme.setCoutPierreFormation(0);
//		hommeDArme.setCoutBoisFormation(25_000_000);
//		hommeDArme.setCoutOrFormation(1_500_000);
//		hommeDArme.setCoutNourritureFormation(65_000_000);
//		hommeDArme.setCoutHumain(1);
//		hommeDArme.setTempsFormation(240);
//		hommeDArme.setVie(3_215_625);
//		hommeDArme.setAttaque(107_200);
//		hommeDArme.setPortee(3);
//		hommeDArme.setArmure(160_780);
//		hommeDArme.setVitesse(10);
//		hommeDArme.setNiveauBatimentNecessaireFormation(11);
//		hommeDArme.setApportRessourcePierreHeure(0);
//		hommeDArme.setApportRessourceBoisHeure(0);
//		hommeDArme.setApportRessourceOrHeure(0);
//		hommeDArme.setApportRessourceNourritureHeure(0);
//		hommeDArme.setApportExperience(2_450_000);		
//
//		// -------------------- //
//		// ------ ECURIE ------ //
//		// -------------------- //
//		
//		// Cavalier
//		Unitee cavalier = new Unitee();
//		cavalier.setIdTypeUnitee(3);
//		cavalier.setIdBatimentProvenance(12);
//		cavalier.setIcone("https://media.discordapp.net/attachments/794876433842831361/799986300571615272/Cavalier.png");
//		cavalier.setLibelle("Cavalier");
//		cavalier.setDescriptif("Descriptif du cavalier");
//		cavalier.setCoutPierreFormation(0);
//		cavalier.setCoutBoisFormation(500);
//		cavalier.setCoutOrFormation(400);
//		cavalier.setCoutNourritureFormation(3_000);
//		cavalier.setCoutHumain(1);
//		cavalier.setTempsFormation(44);
//		cavalier.setVie(90);
//		cavalier.setAttaque(3);
//		cavalier.setPortee(1);
//		cavalier.setArmure(4);
//		cavalier.setVitesse(30);
//		cavalier.setNiveauBatimentNecessaireFormation(2);
//		cavalier.setApportRessourcePierreHeure(0);
//		cavalier.setApportRessourceBoisHeure(0);
//		cavalier.setApportRessourceOrHeure(0);
//		cavalier.setApportRessourceNourritureHeure(0);
//		cavalier.setApportExperience(120);	
//		
//		// Cavalier Archer
//		Unitee cavalierArcher = new Unitee();
//		cavalierArcher.setIdTypeUnitee(3);
//		cavalierArcher.setIdBatimentProvenance(12);
//		cavalierArcher.setIcone("https://media.discordapp.net/attachments/794876433842831361/799986294889381888/Cavalier_Archer.png");
//		cavalierArcher.setLibelle("Cavalier archer");
//		cavalierArcher.setDescriptif("Descriptif du cavalier archer");
//		cavalierArcher.setCoutPierreFormation(0);
//		cavalierArcher.setCoutBoisFormation(380_000);
//		cavalierArcher.setCoutOrFormation(40_000);
//		cavalierArcher.setCoutNourritureFormation(510_000);
//		cavalierArcher.setCoutHumain(1);
//		cavalierArcher.setTempsFormation(150);
//		cavalierArcher.setVie(31_240);
//		cavalierArcher.setAttaque(1_040);
//		cavalierArcher.setPortee(11);
//		cavalierArcher.setArmure(1_560);
//		cavalierArcher.setVitesse(30);
//		cavalierArcher.setNiveauBatimentNecessaireFormation(7);
//		cavalierArcher.setApportRessourcePierreHeure(0);
//		cavalierArcher.setApportRessourceBoisHeure(0);
//		cavalierArcher.setApportRessourceOrHeure(0);
//		cavalierArcher.setApportRessourceNourritureHeure(0);
//		cavalierArcher.setApportExperience(29_400);
//		
//		// Champion
//		Unitee champion = new Unitee();
//		champion.setIdTypeUnitee(3);
//		champion.setIdBatimentProvenance(12);
//		champion.setIcone("https://media.discordapp.net/attachments/794876433842831361/799986305832058900/Champion.png");
//		champion.setLibelle("Champion");
//		champion.setDescriptif("Descriptif du champion");
//		champion.setCoutPierreFormation(18_000_000);
//		champion.setCoutBoisFormation(1_550_000);
//		champion.setCoutOrFormation(1_300_000);
//		champion.setCoutNourritureFormation(60_000_000);
//		champion.setCoutHumain(1);
//		champion.setTempsFormation(240);
//		champion.setVie(3_244_500);
//		champion.setAttaque(108_150);
//		champion.setPortee(3);
//		champion.setArmure(162_225);
//		champion.setVitesse(30);
//		champion.setNiveauBatimentNecessaireFormation(11);
//		champion.setApportRessourcePierreHeure(0);
//		champion.setApportRessourceBoisHeure(0);
//		champion.setApportRessourceOrHeure(0);
//		champion.setApportRessourceNourritureHeure(0);
//		champion.setApportExperience(2_472_000);		
//		
//		// ------------------ //
//		// ------ PORT ------ //
//		// ------------------ //
//		// Bateau de pêche
//		Unitee bateauDePeche = new Unitee();
//		bateauDePeche.setIdTypeUnitee(5);
//		bateauDePeche.setIdBatimentProvenance(13);
//		bateauDePeche.setIcone("https://media.discordapp.net/attachments/794876433842831361/799986281508896799/Bateau_de_peche.png");
//		bateauDePeche.setLibelle("Bateau de pêche");
//		bateauDePeche.setDescriptif("Descriptif du bateau de pêche");
//		bateauDePeche.setCoutPierreFormation(0);
//		bateauDePeche.setCoutBoisFormation(1_000);
//		bateauDePeche.setCoutOrFormation(0);
//		bateauDePeche.setCoutNourritureFormation(100);
//		bateauDePeche.setCoutHumain(1);
//		bateauDePeche.setTempsFormation(20);
//		bateauDePeche.setVie(29);
//		bateauDePeche.setAttaque(1);
//		bateauDePeche.setPortee(1);
//		bateauDePeche.setArmure(1);
//		bateauDePeche.setVitesse(20);
//		bateauDePeche.setNiveauBatimentNecessaireFormation(1);
//		bateauDePeche.setApportRessourcePierreHeure(0);
//		bateauDePeche.setApportRessourceBoisHeure(0);
//		bateauDePeche.setApportRessourceOrHeure(0);
//		bateauDePeche.setApportRessourceNourritureHeure(0);
//		bateauDePeche.setApportExperience(42);
//				
//		// Bateau incendiaire
//		Unitee bateauIncendiaire = new Unitee();
//		bateauIncendiaire.setIdTypeUnitee(5);
//		bateauIncendiaire.setIdBatimentProvenance(13);
//		bateauIncendiaire.setIcone("https://media.discordapp.net/attachments/794876433842831361/799986349704740884/Bateau_incendiaire.png");
//		bateauIncendiaire.setLibelle("Bateau incendiaire");
//		bateauIncendiaire.setDescriptif("Descriptif du bateau incendiaire");
//		bateauIncendiaire.setCoutPierreFormation(0);
//		bateauIncendiaire.setCoutBoisFormation(7_100);
//		bateauIncendiaire.setCoutOrFormation(500);
//		bateauIncendiaire.setCoutNourritureFormation(1_000);
//		bateauIncendiaire.setCoutHumain(1);
//		bateauIncendiaire.setTempsFormation(65);
//		bateauIncendiaire.setVie(287);
//		bateauIncendiaire.setAttaque(10);
//		bateauIncendiaire.setPortee(7);
//		bateauIncendiaire.setArmure(14);
//		bateauIncendiaire.setVitesse(20);
//		bateauIncendiaire.setNiveauBatimentNecessaireFormation(3);
//		bateauIncendiaire.setApportRessourcePierreHeure(0);
//		bateauIncendiaire.setApportRessourceBoisHeure(0);
//		bateauIncendiaire.setApportRessourceOrHeure(0);
//		bateauIncendiaire.setApportRessourceNourritureHeure(0);
//		bateauIncendiaire.setApportExperience(354);		
//				
//		// Galion
//		Unitee galion = new Unitee();
//		galion.setIdTypeUnitee(5);
//		galion.setIdBatimentProvenance(13);
//		galion.setIcone("https://cdn.discordapp.com/attachments/794876433842831361/799990362932117524/Galion.png");
//		galion.setLibelle("Galion");
//		galion.setDescriptif("Descriptif du galion");
//		galion.setCoutPierreFormation(0);
//		galion.setCoutBoisFormation(55_000);
//		galion.setCoutOrFormation(8_000);
//		galion.setCoutNourritureFormation(15_000);
//		galion.setCoutHumain(1);
//		galion.setTempsFormation(110);
//		galion.setVie(3_100);
//		galion.setAttaque(103);
//		galion.setPortee(8);
//		galion.setArmure(155);
//		galion.setVitesse(20);
//		galion.setNiveauBatimentNecessaireFormation(5);
//		galion.setApportRessourcePierreHeure(0);
//		galion.setApportRessourceBoisHeure(0);
//		galion.setApportRessourceOrHeure(0);
//		galion.setApportRessourceNourritureHeure(0);
//		galion.setApportExperience(3_300);		
//				
//		// Galion à canon
//		Unitee galionACanon = new Unitee();
//		galionACanon.setIdTypeUnitee(5);
//		galionACanon.setIdBatimentProvenance(13);
//		galionACanon.setIcone("https://cdn.discordapp.com/attachments/794876433842831361/799986355332448267/Galion_a_canon.png");
//		galionACanon.setLibelle("Galion à canon");
//		galionACanon.setDescriptif("Descriptif du galion à canon");
//		galionACanon.setCoutPierreFormation(600_000);
//		galionACanon.setCoutBoisFormation(800_000);
//		galionACanon.setCoutOrFormation(100_000);
//		galionACanon.setCoutNourritureFormation(500_000);
//		galionACanon.setCoutHumain(1);
//		galionACanon.setTempsFormation(175);
//		galionACanon.setVie(99_000);
//		galionACanon.setAttaque(3_300);
//		galionACanon.setPortee(9);
//		galionACanon.setArmure(4_950);
//		galionACanon.setVitesse(20);
//		galionACanon.setNiveauBatimentNecessaireFormation(8);
//		galionACanon.setApportRessourcePierreHeure(0);
//		galionACanon.setApportRessourceBoisHeure(0);
//		galionACanon.setApportRessourceOrHeure(0);
//		galionACanon.setApportRessourceNourritureHeure(0);
//		galionACanon.setApportExperience(88_000);
//				
//		// Bateau de destruction
//		Unitee bateauDeDestruction = new Unitee();
//		bateauDeDestruction.setIdTypeUnitee(5);
//		bateauDeDestruction.setIdBatimentProvenance(13);
//		bateauDeDestruction.setIcone("https://media.discordapp.net/attachments/794876433842831361/799986366645272636/Bateau_de_destruction.png");
//		bateauDeDestruction.setLibelle("Navire de démolition");
//		bateauDeDestruction.setDescriptif("Descriptif du navire de démolition");
//		bateauDeDestruction.setCoutPierreFormation(3_700_000);
//		bateauDeDestruction.setCoutBoisFormation(3_700_000);
//		bateauDeDestruction.setCoutOrFormation(3_700_000);
//		bateauDeDestruction.setCoutNourritureFormation(3_700_000);
//		bateauDeDestruction.setCoutHumain(1);
//		bateauDeDestruction.setTempsFormation(220);
//		bateauDeDestruction.setVie(1_017_500);
//		bateauDeDestruction.setAttaque(33_915);
//		bateauDeDestruction.setPortee(1);
//		bateauDeDestruction.setArmure(50_875);
//		bateauDeDestruction.setVitesse(20);
//		bateauDeDestruction.setNiveauBatimentNecessaireFormation(10);
//		bateauDeDestruction.setApportRessourcePierreHeure(0);
//		bateauDeDestruction.setApportRessourceBoisHeure(0);
//		bateauDeDestruction.setApportRessourceOrHeure(0);
//		bateauDeDestruction.setApportRessourceNourritureHeure(0);
//		bateauDeDestruction.setApportExperience(814_000);	
//		
//		// ------------------------------ //
//		// ------ ATELIER DE SIEGE ------ //
//		// ------------------------------ //
//		// Guerrier Elite
//		Unitee guerrierElite = new Unitee();
//		guerrierElite.setIdTypeUnitee(2);
//		guerrierElite.setIdBatimentProvenance(14);
//		guerrierElite.setIcone("https://media.discordapp.net/attachments/794876433842831361/799986316292784159/Guerrier_elite.png");
//		guerrierElite.setLibelle("Guerrier élite");
//		guerrierElite.setDescriptif("Descriptif du guerrier élite");
//		guerrierElite.setCoutPierreFormation(0);
//		guerrierElite.setCoutBoisFormation(0);
//		guerrierElite.setCoutOrFormation(4800);
//		guerrierElite.setCoutNourritureFormation(1000);
//		guerrierElite.setCoutHumain(1);
//		guerrierElite.setTempsFormation(65);
//		guerrierElite.setVie(406);
//		guerrierElite.setAttaque(14);
//		guerrierElite.setPortee(2);
//		guerrierElite.setArmure(20);
//		guerrierElite.setVitesse(10);
//		guerrierElite.setNiveauBatimentNecessaireFormation(3);
//		guerrierElite.setApportRessourcePierreHeure(0);
//		guerrierElite.setApportRessourceBoisHeure(0);
//		guerrierElite.setApportRessourceOrHeure(0);
//		guerrierElite.setApportRessourceNourritureHeure(0);
//		guerrierElite.setApportExperience(500);
//		
//		// Phalange
//		Unitee phalange = new Unitee();
//		phalange.setIdTypeUnitee(2);
//		phalange.setIdBatimentProvenance(14);
//		phalange.setIcone("https://media.discordapp.net/attachments/794876433842831361/799986392570658816/Phalange.png");
//		phalange.setLibelle("Phalange");
//		phalange.setDescriptif("Descriptif du phalange");
//		phalange.setCoutPierreFormation(1_500);
//		phalange.setCoutBoisFormation(2_000);
//		phalange.setCoutOrFormation(12_000);
//		phalange.setCoutNourritureFormation(5_500);
//		phalange.setCoutHumain(1);
//		phalange.setTempsFormation(1_480);
//		phalange.setVie(1_295);
//		phalange.setAttaque(43);
//		phalange.setPortee(2);
//		phalange.setArmure(65);
//		phalange.setVitesse(10);
//		phalange.setNiveauBatimentNecessaireFormation(4);
//		phalange.setApportRessourcePierreHeure(0);
//		phalange.setApportRessourceBoisHeure(0);
//		phalange.setApportRessourceOrHeure(0);
//		phalange.setApportRessourceNourritureHeure(0);
//		phalange.setApportExperience(1_480);
//		
//		// Samourai
//		Unitee samourai = new Unitee();
//		samourai.setIdTypeUnitee(2);
//		samourai.setIdBatimentProvenance(14);
//		samourai.setIcone("https://media.discordapp.net/attachments/794876433842831361/799986417350606908/Samourail.png");
//		samourai.setLibelle("Samouraï");
//		samourai.setDescriptif("Descriptif du samouraï");
//		samourai.setCoutPierreFormation(0);
//		samourai.setCoutBoisFormation(0);
//		samourai.setCoutOrFormation(1_020_000);
//		samourai.setCoutNourritureFormation(0);
//		samourai.setCoutHumain(1);
//		samourai.setTempsFormation(175);
//		samourai.setVie(114_750);
//		samourai.setAttaque(3_825);
//		samourai.setPortee(2);
//		samourai.setArmure(5_737);
//		samourai.setVitesse(15);
//		samourai.setNiveauBatimentNecessaireFormation(8);
//		samourai.setApportRessourcePierreHeure(0);
//		samourai.setApportRessourceBoisHeure(0);
//		samourai.setApportRessourceOrHeure(0);
//		samourai.setApportRessourceNourritureHeure(0);
//		samourai.setApportExperience(102_000);
//		
//		// Templier
//		Unitee templier = new Unitee();
//		templier.setIdTypeUnitee(2);
//		templier.setIdBatimentProvenance(14);
//		templier.setIcone("https://media.discordapp.net/attachments/794876433842831361/799986422894428220/Templier.png");
//		templier.setLibelle("Templier");
//		templier.setDescriptif("Descriptif du templier");
//		templier.setCoutPierreFormation(0);
//		templier.setCoutBoisFormation(0);
//		templier.setCoutOrFormation(2_500_000);
//		templier.setCoutNourritureFormation(1_500_000);
//		templier.setCoutHumain(1);
//		templier.setTempsFormation(200);
//		templier.setVie(332_500);
//		templier.setAttaque(11_083);
//		templier.setPortee(2);
//		templier.setArmure(16_625);
//		templier.setVitesse(15);
//		templier.setNiveauBatimentNecessaireFormation(9);
//		templier.setApportRessourcePierreHeure(0);
//		templier.setApportRessourceBoisHeure(0);
//		templier.setApportRessourceOrHeure(0);
//		templier.setApportRessourceNourritureHeure(0);
//		templier.setApportExperience(280_000);	
//		
//		// catapulte
//		Unitee catapulte = new Unitee();
//		catapulte.setIdTypeUnitee(4);
//		catapulte.setIdBatimentProvenance(14);
//		catapulte.setIcone("https://media.discordapp.net/attachments/794876433842831361/799986288237084692/Catapulte.png");
//		catapulte.setLibelle("Catapulte");
//		catapulte.setDescriptif("Descriptif de la catapulte");
//		catapulte.setCoutPierreFormation(8_300_000);
//		catapulte.setCoutBoisFormation(6_300_000);
//		catapulte.setCoutOrFormation(800_000);
//		catapulte.setCoutNourritureFormation(500_000);
//		catapulte.setCoutHumain(1);
//		catapulte.setTempsFormation(220);
//		catapulte.setVie(1_050_000);
//		catapulte.setAttaque(35_000);
//		catapulte.setPortee(13);
//		catapulte.setArmure(52_500);
//		catapulte.setVitesse(3);
//		catapulte.setNiveauBatimentNecessaireFormation(10);
//		catapulte.setApportRessourcePierreHeure(0);
//		catapulte.setApportRessourceBoisHeure(0);
//		catapulte.setApportRessourceOrHeure(0);
//		catapulte.setApportRessourceNourritureHeure(0);
//		catapulte.setApportExperience(840_000);
//		
//		// elephant de combat
//		Unitee elephantDeCombat = new Unitee();
//		elephantDeCombat.setIdTypeUnitee(4);
//		elephantDeCombat.setIdBatimentProvenance(14);
//		elephantDeCombat.setIcone("https://media.discordapp.net/attachments/794876433842831361/799994500356505660/Elephant_de_combat.png");
//		elephantDeCombat.setLibelle("Eléphant de combat");
//		elephantDeCombat.setDescriptif("Descriptif de l'éléphant de combat");
//		elephantDeCombat.setCoutPierreFormation(2_000_000);
//		elephantDeCombat.setCoutBoisFormation(3_000_000);
//		elephantDeCombat.setCoutOrFormation(20_000_000);
//		elephantDeCombat.setCoutNourritureFormation(20_000_000);
//		elephantDeCombat.setCoutHumain(1);
//		elephantDeCombat.setTempsFormation(240);
//		elephantDeCombat.setVie(3_465_000);
//		elephantDeCombat.setAttaque(115_500);
//		elephantDeCombat.setPortee(2);
//		elephantDeCombat.setArmure(173_250);
//		elephantDeCombat.setVitesse(1);
//		elephantDeCombat.setNiveauBatimentNecessaireFormation(11);
//		elephantDeCombat.setApportRessourcePierreHeure(0);
//		elephantDeCombat.setApportRessourceBoisHeure(0);
//		elephantDeCombat.setApportRessourceOrHeure(0);
//		elephantDeCombat.setApportRessourceNourritureHeure(0);
//		elephantDeCombat.setApportExperience(2_640_000);		
//				
//		// ------------------------ //
//		// ------ UNIVERSITE ------ //
//		// ------------------------ //
//		// Prêtre
//		Unitee pretre = new Unitee();
//		pretre.setIdTypeUnitee(2);
//		pretre.setIdBatimentProvenance(16);
//		pretre.setIcone("https://media.discordapp.net/attachments/794876433842831361/799986403055370280/Pretre.png");
//		pretre.setLibelle("Prêtre");
//		pretre.setDescriptif("Descriptif du prêtre");
//		pretre.setCoutPierreFormation(60_000_000);
//		pretre.setCoutBoisFormation(60_000_000);
//		pretre.setCoutOrFormation(60_000_000);
//		pretre.setCoutNourritureFormation(60_000_000);
//		pretre.setCoutHumain(1);
//		pretre.setTempsFormation(600);
//		pretre.setVie(18_150_000);
//		pretre.setAttaque(605_000);
//		pretre.setPortee(15);
//		pretre.setArmure(907_500);
//		pretre.setVitesse(50);
//		pretre.setNiveauBatimentNecessaireFormation(12);
//		pretre.setApportRessourcePierreHeure(0);
//		pretre.setApportRessourceBoisHeure(0);
//		pretre.setApportRessourceOrHeure(0);
//		pretre.setApportRessourceNourritureHeure(0);
//		pretre.setApportExperience(13_200_000);
//		
//		this.uniteeRepo.save(villageois);
//        this.uniteeRepo.save(archer);
//        this.uniteeRepo.save(archerComposite);
//        this.uniteeRepo.save(fantassinEpee);
//        this.uniteeRepo.save(piquier);
//        this.uniteeRepo.save(lanceurDeHache);
//        this.uniteeRepo.save(milicien);
//        this.uniteeRepo.save(hommeDArme);
//        this.uniteeRepo.save(cavalierArcher);
//        this.uniteeRepo.save(cavalier);
//        this.uniteeRepo.save(champion);
//        
//        this.uniteeRepo.save(bateauDePeche);
//        this.uniteeRepo.save(bateauIncendiaire);
//        this.uniteeRepo.save(bateauDeDestruction);
//        this.uniteeRepo.save(galionACanon);
//        this.uniteeRepo.save(galion);
//        
//        this.uniteeRepo.save(guerrierElite);
//        this.uniteeRepo.save(phalange);
//        this.uniteeRepo.save(samourai);
//        this.uniteeRepo.save(templier);
//        this.uniteeRepo.save(catapulte);
//        this.uniteeRepo.save(elephantDeCombat);
//        
//        this.uniteeRepo.save(pretre);
//        
//        ////////////////////////////////////////////////////////
//        ////////////////////////////////////////////////////////
//        ///////////////////////EXPEDITION///////////////////////
//        ////////////////////////////////////////////////////////
//        ////////////////////////////////////////////////////////
//        LocalDate dateAujourdhui  = LocalDate.now(); 
//        Expedition expedition1 = new Expedition("https://media.discordapp.net/attachments/794876433842831361/796753858625142804/thumb-1920-1013122.jpg?width=1278&height=497","Expedition 1","Descriptif de l'expedition 1",10, 1, 1000, 2000, 1200, 500, 500, 500, 500, 2500, 2500, 2500, 2500, 10, 2000,dateAujourdhui);
//        Expedition expedition2 = new Expedition("https://media.discordapp.net/attachments/794876433842831361/796753858625142804/thumb-1920-1013122.jpg?width=1278&height=497","Expedition 2","Descriptif de l'expedition 2",3600, 1, 1000, 5000, 1200, 500, 500, 500, 500, 2500, 2500, 2500, 2500, 10, 5000,dateAujourdhui);
//        Expedition expedition3 = new Expedition("https://media.discordapp.net/attachments/794876433842831361/796753858625142804/thumb-1920-1013122.jpg?width=1278&height=497","Expedition 3","Descriptif de l'expedition 3",10, 1, 1000, 5000, 1200, 500, 500, 500, 500, 2500, 2500, 2500, 2500, 10, 5000,dateAujourdhui);
//        Expedition expedition4 = new Expedition("https://media.discordapp.net/attachments/794876433842831361/796753858625142804/thumb-1920-1013122.jpg?width=1278&height=497","Expedition 4","Descriptif de l'expedition 4",10, 1, 1000, 5000, 1200, 500, 500, 500, 500, 2500, 2500, 2500, 2500, 10, 5000,dateAujourdhui);
//        this.expeditionRepo.save(expedition1);
//        this.expeditionRepo.save(expedition2);
//        this.expeditionRepo.save(expedition3);
//        this.expeditionRepo.save(expedition4);
//
//        ////////////////////////////////////////////////////////
//        ////////////////////////////////////////////////////////
//        /////////////////////////ARMEE//////////////////////////
//        ////////////////////////////////////////////////////////
//        ////////////////////////////////////////////////////////
//        Armee armeeChampion = new Armee(joueur1,champion,20,161252348L,1612523480L);
//        Armee armeeArcher = new Armee(joueur1,archer,300,161252348L,1612523480L);
//        this.armeeRepo.save(armeeChampion);
//        this.armeeRepo.save(armeeArcher);
        
    	
    	Unitee villageois = new Unitee();
		villageois.setIdTypeUnitee(1);
		villageois.setIdBatimentProvenance(1);
		villageois.setIcone("https://media.discordapp.net/attachments/794876433842831361/799986427348647964/Villageois.png");
		villageois.setLibelle("Villageois");
		villageois.setDescriptif("Descriptif du villageois");
		villageois.setCoutPierreFormation(0);
		villageois.setCoutBoisFormation(0);
		villageois.setCoutOrFormation(0);
		villageois.setCoutNourritureFormation(2_150);
		villageois.setCoutHumain(1);
		villageois.setTempsFormation(20);
		villageois.setVie(30);
		villageois.setAttaque(1);
		villageois.setPortee(1);
		villageois.setArmure(1);
		villageois.setVitesse(12);
		villageois.setNiveauBatimentNecessaireFormation(1);
		villageois.setApportRessourcePierreHeure(0);
		villageois.setApportRessourceBoisHeure(0);
		villageois.setApportRessourceOrHeure(0);
		villageois.setApportRessourceNourritureHeure(0);
		villageois.setApportExperience(43);
        
        Campagne campagneUne = new Campagne();
        campagneUne.setIcone("https://media.discordapp.net/attachments/794876433842831361/796753858625142804/thumb-1920-1013122.jpg?width=1278&height=497");
        campagneUne.setLibelle("Libelle 1");
        campagneUne.setDescription("Description une");
        campagneUne.setDuree(10);
        campagneUne.setNiveau(1);
        campagneUne.setUnitee(villageois);
        campagneUne.setQuantitee(7);
        campagneUne.setIsBoss(true);
        campagneUne.setRecompensePierre(600L);
        campagneUne.setRecompenseBois(600L);
        campagneUne.setRecompenseOr(600L);
        campagneUne.setRecompenseNourriture(600L);
        campagneUne.setRecompenseGemme(50);
        
        campagneRepo.save(campagneUne);
        
        System.out.println(campagneUne.toString());
    }

}
