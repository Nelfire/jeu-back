package dev;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import dev.entites.batiment.Batiment;
import dev.entites.batiment.BatimentJoueur;
import dev.entites.batiment.Defense;
import dev.entites.expedition.Expedition;
import dev.entites.joueur.Armee;
import dev.entites.joueur.Joueur;
import dev.entites.joueur.Role;
import dev.entites.joueur.RoleJoueur;
import dev.entites.unitee.Unitee;
import dev.repository.JoueurRepo;
import dev.repository.batiment.BatimentRepo;
import dev.repository.batiment.DefenseRepo;
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
    		DefenseRepo defenseRepo) {
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
    }

    @EventListener(ContextRefreshedEvent.class)
    public void onStart() {
   
    	// ----- JOUEUR -----
        Joueur joueur1 = new Joueur();
        joueur1.setIcone("https://www.blog-nouvelles-technologies.fr/wp-content/uploads/2017/12/detective-avatar-icon-01-.jpg");
        joueur1.setPseudo("Nelfire");
        joueur1.setEmail("girvincent@gmail.com");
        joueur1.setMotDePasse(passwordEncoder.encode("password"));
        joueur1.setDescriptif("Salut ! Je suis le premier joueur");
        joueur1.setNiveau(1);
        joueur1.setExperience(0);
        joueur1.setPierrePossession(1000);
        joueur1.setBoisPossession(1000);
        joueur1.setOrPossession(1000);
        joueur1.setNourriturePossession(1001);
        joueur1.setGemmePossession(500);
        joueur1.setPierreMaximum(20000);
        joueur1.setBoisMaximum(20000);
        joueur1.setOrMaximum(20000);
        joueur1.setNourritureMaximum(20000);
        joueur1.setTempsDeJeu(0);
        joueur1.setGemmePossession(500);
        joueur1.setRoles(Arrays.asList(new RoleJoueur(joueur1, Role.ROLE_ADMINISTRATEUR), new RoleJoueur(joueur1, Role.ROLE_JOUEUR)));
        this.joueurRepo.save(joueur1);
        
        Joueur joueur2 = new Joueur();
        joueur2.setIcone("https://www.blog-nouvelles-technologies.fr/wp-content/uploads/2017/12/detective-avatar-icon-01-.jpg");
        joueur2.setPseudo("Riosha");
        joueur2.setEmail("riosha@gmail.com");
        joueur2.setMotDePasse(passwordEncoder.encode("password"));
        joueur2.setDescriptif("Salut ! Je suis le deuxieme joueur");
        joueur2.setNiveau(1);
        joueur2.setExperience(0);
        joueur2.setPierrePossession(1000);
        joueur2.setBoisPossession(1000);
        joueur2.setOrPossession(1000);
        joueur2.setNourriturePossession(1000);
        joueur2.setGemmePossession(500);
        joueur2.setPierreMaximum(20000);
        joueur2.setBoisMaximum(20000);
        joueur2.setOrMaximum(20000);
        joueur2.setNourritureMaximum(20000);
        joueur2.setTempsDeJeu(0);
        joueur2.setGemmePossession(40);
        joueur2.setRoles(Arrays.asList(new RoleJoueur(joueur2, Role.ROLE_ADMINISTRATEUR), new RoleJoueur(joueur2, Role.ROLE_JOUEUR)));
        this.joueurRepo.save(joueur2);
        
        Joueur joueur3 = new Joueur();
        joueur3.setIcone("https://www.blog-nouvelles-technologies.fr/wp-content/uploads/2017/12/detective-avatar-icon-01-.jpg");
        joueur3.setPseudo("Test");
        joueur3.setEmail("test@email.com");
        joueur3.setMotDePasse(passwordEncoder.encode("password"));
        joueur3.setDescriptif("Troisieme joueur");
        joueur3.setNiveau(1);
        joueur3.setExperience(0);
        joueur3.setPierrePossession(1000);
        joueur3.setBoisPossession(1000);
        joueur3.setOrPossession(1000);
        joueur3.setNourriturePossession(1000);
        joueur3.setGemmePossession(500);
        joueur3.setPierreMaximum(20000);
        joueur3.setBoisMaximum(20000);
        joueur3.setOrMaximum(20000);
        joueur3.setNourritureMaximum(20000);
        joueur3.setTempsDeJeu(0);
        joueur3.setGemmePossession(40);
        joueur3.setRoles(Arrays.asList(new RoleJoueur(joueur3, Role.ROLE_JOUEUR)));
        this.joueurRepo.save(joueur3);
        
        // ----- BATIMENT -----
        /* 
     	1 - Hotel de ville	
    	2 - Chaumière (augmenter limite population)
    	3 - Carrière (farm pierre)
    	4 - Camp de bucheron (farm bois)		
    	5 - Camp de mineur (farm or)
    	6 - Ferme (farm nourriture)
    	7 - Stockage Pierre (Entrepot)	
    	8 - Stockage Bois (Scierie)
    	9 - Stockage Or (Banque)
    	10 - Stockage Nourriture (Grenier)
    	11 - Caserne Militaire	
    	12 - Ecurie
    	13 - Port
    	14 - Atelier de siege
    	15 - Forge		
    	16 - Universite
    	17 - Marché
    	18 - Table d'expéditions
         */
        Batiment hdv = new Batiment(1,0,"https://media.discordapp.net/attachments/794876433842831361/808334142617026570/HotelDeVille.png","Hotel de ville","Bâtiment principal de votre campement, l'hôtel de ville vous assure un apport régulier de ressource et vous permet également d'augmenter votre niveau de connaissance afin de créer de nouveaux types de bâtiments."
        		,5,30,500,250,100,200,0,10000,10000,10000,10000,3600,3600,3600,3600,4,10);
        Batiment chaumiere = new Batiment(2,0,"https://cdn.discordapp.com/attachments/794876433842831361/794876520338161704/Chaumiere.png","Chantier","Le chantier permet la création de bâtiments de défense."
        		,5,180,2000,1000,1000,1000,1,0,0,0,0,0,0,0,0,0,5);
        Batiment carriere = new Batiment(3,1,"https://media.discordapp.net/attachments/794876433842831361/808335646653153330/Carriere.png","Carrière","La carrière vous assure un apport régulier de pierre. Plus son niveau est élevé, plus l'apport de pierre sera important."
        		,5,80,150,200,100,100,1,0,0,0,0,6500,0,0,0,2,8);
        Batiment campDeBucheron = new Batiment(4,1,"https://media.discordapp.net/attachments/794876433842831361/808335663467724800/Scierie.png","Camp de bûcheron","Le camp de bûcheron vous assure un apport régulier de bois. Plus son niveau est élevé, plus l'apport de bois sera important."
        		,5,80,200,150,100,100,1,0,0,0,0,0,10000,0,0,2,8);
        Batiment campDeMineur = new Batiment(5,1,"https://cdn.discordapp.com/attachments/794876433842831361/794876498183323678/CampDeMineur.png","Camp de mineur","Le camp de mineur vous assure un apport régulier d'or. Plus son niveau est élevé, plus l'apport d'or sera important."
        		,5,80,200,100,150,100,1,0,0,0,0,0,0,4000,0,2,8);
        Batiment ferme = new Batiment(6,1,"https://cdn.discordapp.com/attachments/794876433842831361/794876556509839360/Ferme.png","Ferme","La ferme vous assure un apport régulier de nourriture. Plus son niveau est élevé, plus l'apport de nourriture sera important."
        		,5,80,100,200,100,150,1,0,0,0,0,0,0,0,15000,2,8);
        Batiment entrepot = new Batiment(7,2,"https://media.discordapp.net/attachments/794876433842831361/808341147192918076/Entrepot.png","Entrepot","L'entrepot sert de point de dépôt pour la pierre."
        		,5,600,5000,2500,2500,1500,1,50000,0,0,0,0,0,0,0,3,6);
        Batiment scierie = new Batiment(8,2,"https://cdn.discordapp.com/attachments/794876433842831361/794876485034311690/Banque.png","Scierie","La scierie sert de point de dépôt pour le bois."
        		,5,600,2500,5000,2500,1500,1,0,50000,0,0,0,0,0,0,3,6);
        Batiment banque = new Batiment(9,2,"https://cdn.discordapp.com/attachments/794876433842831361/794876485034311690/Banque.png","Banque","La banque sert de point de dépôt pour l'or."
        		,5,600,2500,2500,5000,1500,1,0,0,50000,0,0,0,0,0,3,6);
        Batiment grenier = new Batiment(10,2,"https://media.discordapp.net/attachments/794876433842831361/808337913272205362/Grenier.png","Grenier","Le grenier sert de point de dépôt pour la nourriture."
        		,5,600,2500,2500,2500,3000,1,0,0,0,50000,0,0,0,0,3,6);
        Batiment caserneMillitaire = new Batiment(11,3,"https://media.discordapp.net/attachments/794876433842831361/808333625426313246/Camp_militaire.png","Caserne militaire","La caserne militaire permet la création d'unitées d'infanterie légère."
        		,5,300,2500,1500,1000,1500,2,0,0,0,0,0,0,0,0,0,4);
        Batiment ecurie = new Batiment(12,3,"https://media.discordapp.net/attachments/794876433842831361/808333303592779876/ecurie.png","Ecurie","L'écurie permet la création d'unitées de cavalerie."
        		,5,400,3000,2000,1500,2000,3,0,0,0,0,0,0,0,0,0,4);
        Batiment port = new Batiment(13,3,"https://media.discordapp.net/attachments/794876433842831361/808341626640400484/Port.png","Port","Le port permet la création d'unitées navale."
        		,5,600,2500,4000,2000,2500,4,0,0,0,0,0,0,0,0,0,4);
        Batiment atelierDeSiege = new Batiment(14,3,"https://cdn.discordapp.com/attachments/794876433842831361/794876478667751444/AtelierDeSiege.png","Atelier de siège","L'atelier de siège permet la création d'unitées de combat lourde."
        		,5,900,7000,5000,4000,4000,5,0,0,0,0,0,0,0,0,0,4);
        Batiment forge = new Batiment(15,0,"https://media.discordapp.net/attachments/794876433842831361/808337592025743380/Forge2.png","Forge","La forme permet l'amélioration de certaines de vos unitées et de vos défenses."
        		,5,1800,20000,15000,10000,12000,5,0,0,0,0,0,0,0,0,0,4);
        Batiment universite = new Batiment(16,0,"https://media.discordapp.net/attachments/794876433842831361/808335597034537003/Bibliotheque.png","Université","L'université permet la création d'unitées et la recherche."
        		,5,1800,25000,20000,30000,20000,5,0,0,0,0,0,0,0,0,0,4);
        Batiment marche = new Batiment(17,0,"https://media.discordapp.net/attachments/794876433842831361/808342149753077801/Marche.png","Marché","Le marché permet l'échange de ressources."
        		,5,1200,25000,15000,25000,15000,5,0,0,0,0,0,0,0,0,0,4);
        Batiment tableExpedition = new Batiment(18,0,"https://media.discordapp.net/attachments/794876433842831361/808342166874357770/CampExpedition.png","Table d'expéditions","La table d'expédition vous permet d'envoyer vos unités en expédition. Plus le niveau de la structure sera élevé, plus vous serez en mesure de lancer des expéditions en simultané."
        		,5,600,2500,2000,1500,2000,1,0,0,0,0,0,0,0,0,0,4);
        this.batimentRepo.save(hdv);
        this.batimentRepo.save(chaumiere);
        this.batimentRepo.save(carriere);
        this.batimentRepo.save(campDeBucheron);
        this.batimentRepo.save(campDeMineur);
        this.batimentRepo.save(ferme);
        this.batimentRepo.save(entrepot);
        this.batimentRepo.save(scierie);
        this.batimentRepo.save(banque);
        this.batimentRepo.save(grenier);
        this.batimentRepo.save(caserneMillitaire);
        this.batimentRepo.save(ecurie);
        this.batimentRepo.save(port);
        this.batimentRepo.save(atelierDeSiege);
        this.batimentRepo.save(forge);
        this.batimentRepo.save(universite);
        this.batimentRepo.save(marche);
        this.batimentRepo.save(tableExpedition);
        
        // -- DEFENSES --
        Defense tour = new Defense(1,1,"https://cdn.discordapp.com/attachments/794876433842831361/794876513039417404/CaserneMillitaire.png","Tour de guet","Description de la tour"
        		,50,50,50,50,99,99,99,10,1,2);
        Defense murFortifie = new Defense(2,2,"https://media.discordapp.net/attachments/794876433842831361/808330333325099068/MurFortifie.png","Mur fortifié","Description du mur fortifié"
        		,50,50,50,50,1000,0,200,10,3,2);
        

        this.defenseRepo.save(tour);
        this.defenseRepo.save(murFortifie);
        
		long debut = new Date().getTime();
		long fin = new Date().getTime();

		BatimentJoueur batimentJoueur1 = new BatimentJoueur(joueur1,hdv,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,debut,fin);
		BatimentJoueur batimentJoueur2 = new BatimentJoueur(joueur1,tableExpedition,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,debut,fin);
		BatimentJoueur batimentJoueur3 = new BatimentJoueur(joueur1,chaumiere,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,debut,fin);

		this.batimentJoueurRepo.save(batimentJoueur1);
		this.batimentJoueurRepo.save(batimentJoueur2);
		this.batimentJoueurRepo.save(batimentJoueur3);
		
		
        // ----- UNITEE -----
	    //1 villageois 
		//2 archer 
		//3 archerComposite
		//4 fantassinEpee
		//5 hommeDArme 
		//6 lanceurDeHache
		//7 milicien 
		//8 piquier 
		//9 cavalierArcher
		//10 cavalier
		//11 champion 
		//12 bateauDePeche 
		//13 bateauIncendiaire 
		//14 bateauDeDestruction
		//15 galionACanon
		//16 galion
		//17 guerrierElite
		//18 phalange
		//19 samourail
		//20 templier
		//21 catapulte
		//22 elephantDeCombat
		//23 pretre

		// Initialisation poids

		Double poidBonusNiveauBatiment;
		Integer global;
		Integer niveauBatiment;
		// - poid -
		Integer poidPierre = 3;
		Integer poidBois = 2;
		Integer poidOr = 5;
		Integer poidNourriture = 1;
		// - stats -
		Integer poidVie = 100;
		Integer poidAttaque = 200;
		Integer poidPortee = 500;
		Integer poidArmure = 1000;
		Integer poidTemps = 2;
		// - cout -
		Integer coutPierre;
		Integer coutBois;
		Integer coutOr;
		Integer coutNourriture;
		Integer vie;
		Integer attaque;
		Integer portee;
		Integer armure;
		Integer temps;

		// ---------------------------- //
		// ------ HOTEL DE VILLE ------ //
		// ---------------------------- //
		// Villageois
		niveauBatiment = 1;
		poidBonusNiveauBatiment = 1.0+((double) niveauBatiment/10);
		global = 1000;
		coutPierre = global / poidPierre;
		coutBois = global / poidBois;
		coutOr = global / poidOr;
		coutNourriture = global / poidNourriture;
		vie =  (int) ((global / poidVie) * poidBonusNiveauBatiment);
		attaque = (int) ((global / poidAttaque) * poidBonusNiveauBatiment);
		portee = (int) ((global / poidPortee) * poidBonusNiveauBatiment);
		armure = (int) ((global / poidArmure) * poidBonusNiveauBatiment);
		temps = global / poidTemps;
		Unitee villageois = new Unitee(1,1,"https://media.discordapp.net/attachments/794876433842831361/799986427348647964/Villageois.png","Villageois","Descriptif du villageois"
				,coutPierre,coutBois,coutOr,coutNourriture,1,temps,vie,attaque,portee,armure,niveauBatiment,0,0,0,0);
		
		// ------------------------------- //
		// ------ CASERNE MILITAIRE ------ //
		// ------------------------------- //
		// Archer
		niveauBatiment = 1;
		poidBonusNiveauBatiment = 1.0+((double) niveauBatiment/10);
		global = 2000;
		coutPierre = global / poidPierre;
		coutBois = global / poidBois;
		coutOr = global / poidOr;
		coutNourriture = global / poidNourriture;
		vie =  (int) ((global / poidVie) * poidBonusNiveauBatiment);
		attaque = (int) ((global / poidAttaque) * poidBonusNiveauBatiment);
		portee = (int) ((global / poidPortee) * poidBonusNiveauBatiment);
		armure = (int) ((global / poidArmure) * poidBonusNiveauBatiment);
		temps = global / poidTemps;
		Unitee archer = new Unitee(2,11,"https://media.discordapp.net/attachments/794876433842831361/799986264299405342/Archer.png","Archer","Descriptif de l'archer"
				,coutPierre,coutBois,coutOr,coutNourriture,1,temps,vie,attaque,portee,armure,niveauBatiment,0,0,0,0);
		
		// Archer Composite
		niveauBatiment = 1;
		poidBonusNiveauBatiment = 1.0+((double) niveauBatiment/10);
		global = 3000;
		coutPierre = global / poidPierre;
		coutBois = global / poidBois;
		coutOr = global / poidOr;
		coutNourriture = global / poidNourriture;
		vie =  (int) ((global / poidVie) * poidBonusNiveauBatiment);
		attaque = (int) ((global / poidAttaque) * poidBonusNiveauBatiment);
		portee = (int) ((global / poidPortee) * poidBonusNiveauBatiment);
		armure = (int) ((global / poidArmure) * poidBonusNiveauBatiment);
		temps = global / poidTemps;
		Unitee archerComposite = new Unitee(2,11,"https://media.discordapp.net/attachments/794876433842831361/799986256377151518/Archer_Composite.png","Archer composite","Descriptif de l'archer composite"
				,coutPierre,coutBois,coutOr,coutNourriture,1,temps,vie,attaque,portee,armure,niveauBatiment,0,0,0,0);
		
		// Fantassin Epee
		niveauBatiment = 2;
		poidBonusNiveauBatiment = 1.0+((double) niveauBatiment/10);
		global = 3000;
		coutPierre = global / poidPierre;
		coutBois = global / poidBois;
		coutOr = global / poidOr;
		coutNourriture = global / poidNourriture;
		vie =  (int) ((global / poidVie) * poidBonusNiveauBatiment);
		attaque = (int) ((global / poidAttaque) * poidBonusNiveauBatiment);
		portee = (int) ((global / poidPortee) * poidBonusNiveauBatiment);
		armure = (int) ((global / poidArmure) * poidBonusNiveauBatiment);
		temps = global / poidTemps;
		Unitee fantassinEpee = new Unitee(2,11,"https://media.discordapp.net/attachments/794876433842831361/799986321065771018/Fantassin_epee.png","Fantassin épée","Descriptif du fantassin épée"
				,coutPierre,coutBois,coutOr,coutNourriture,1,temps,vie,attaque,portee,armure,niveauBatiment,0,0,0,0);
		
		// Homme d'arme
		niveauBatiment = 2;
		poidBonusNiveauBatiment = 1.0+((double) niveauBatiment/10);
		global = 4000;
		coutPierre = global / poidPierre;
		coutBois = global / poidBois;
		coutOr = global / poidOr;
		coutNourriture = global / poidNourriture;
		vie =  (int) ((global / poidVie) * poidBonusNiveauBatiment);
		attaque = (int) ((global / poidAttaque) * poidBonusNiveauBatiment);
		portee = (int) ((global / poidPortee) * poidBonusNiveauBatiment);
		armure = (int) ((global / poidArmure) * poidBonusNiveauBatiment);
		temps = global / poidTemps;
		Unitee hommeDArme = new Unitee(2,11,"https://media.discordapp.net/attachments/794876433842831361/799986373188255764/Homme_darme.png","Homme d'arme","Descriptif de l'homme d'arme"
				,coutPierre,coutBois,coutOr,coutNourriture,1,temps,vie,attaque,portee,armure,niveauBatiment,0,0,0,0);
		
		// Lanceur de Hâche
		niveauBatiment = 3;
		poidBonusNiveauBatiment = 1.0+((double) niveauBatiment/10);
		global = 4000;
		coutPierre = global / poidPierre;
		coutBois = global / poidBois;
		coutOr = global / poidOr;
		coutNourriture = global / poidNourriture;
		vie =  (int) ((global / poidVie) * poidBonusNiveauBatiment);
		attaque = (int) ((global / poidAttaque) * poidBonusNiveauBatiment);
		portee = (int) ((global / poidPortee) * poidBonusNiveauBatiment);
		armure = (int) ((global / poidArmure) * poidBonusNiveauBatiment);
		temps = global / poidTemps;
		Unitee lanceurDeHache = new Unitee(2,11,"https://media.discordapp.net/attachments/794876433842831361/799986377042165770/Lanceur_de_hache.png","Lanceur de hache","Descriptif du lanceur de hache"
				,coutPierre,coutBois,coutOr,coutNourriture,1,temps,vie,attaque,portee,armure,niveauBatiment,0,0,0,0);
		
		// Milicien
		niveauBatiment = 3;
		poidBonusNiveauBatiment = 1.0+((double) niveauBatiment/10);
		global = 5000;
		coutPierre = global / poidPierre;
		coutBois = global / poidBois;
		coutOr = global / poidOr;
		coutNourriture = global / poidNourriture;
		vie =  (int) ((global / poidVie) * poidBonusNiveauBatiment);
		attaque = (int) ((global / poidAttaque) * poidBonusNiveauBatiment);
		portee = (int) ((global / poidPortee) * poidBonusNiveauBatiment);
		armure = (int) ((global / poidArmure) * poidBonusNiveauBatiment);
		temps = global / poidTemps;
		Unitee milicien = new Unitee(2,11,"https://media.discordapp.net/attachments/794876433842831361/799986387787972648/Milicien.png","Milicien","Descriptif du milicien"
				,coutPierre,coutBois,coutOr,coutNourriture,1,temps,vie,attaque,portee,armure,niveauBatiment,0,0,0,0);
		
		// Piquier
		niveauBatiment = 4;
		poidBonusNiveauBatiment = 1.0+((double) niveauBatiment/10);
		global = 4000;
		coutPierre = global / poidPierre;
		coutBois = global / poidBois;
		coutOr = global / poidOr;
		coutNourriture = global / poidNourriture;
		vie =  (int) ((global / poidVie) * poidBonusNiveauBatiment);
		attaque = (int) ((global / poidAttaque) * poidBonusNiveauBatiment);
		portee = (int) ((global / poidPortee) * poidBonusNiveauBatiment);
		armure = (int) ((global / poidArmure) * poidBonusNiveauBatiment);
		temps = global / poidTemps;
		Unitee piquier = new Unitee(2,11,"https://media.discordapp.net/attachments/794876433842831361/799986398294704168/Piquier.png","Piquier","Descriptif du piquier"
				,coutPierre,coutBois,coutOr,coutNourriture,1,temps,vie,attaque,portee,armure,niveauBatiment,0,0,0,0);
		

		// -------------------- //
		// ------ ECURIE ------ //
		// -------------------- //
		
		// Cavalier
		niveauBatiment = 1;
		poidBonusNiveauBatiment = 1.0+((double) niveauBatiment/10);
		global = 4000;
		coutPierre = global / poidPierre;
		coutBois = global / poidBois;
		coutOr = global / poidOr;
		coutNourriture = global / poidNourriture;
		vie =  (int) ((global / poidVie) * poidBonusNiveauBatiment);
		attaque = (int) ((global / poidAttaque) * poidBonusNiveauBatiment);
		portee = (int) ((global / poidPortee) * poidBonusNiveauBatiment);
		armure = (int) ((global / poidArmure) * poidBonusNiveauBatiment);
		temps = global / poidTemps;
		Unitee cavalier = new Unitee(3,12,"https://media.discordapp.net/attachments/794876433842831361/799986300571615272/Cavalier.png","Cavalier","Descriptif du cavalier"
				,coutPierre,coutBois,coutOr,coutNourriture,1,temps,vie,attaque,portee,armure,niveauBatiment,0,0,0,0);
		
		// Cavalier Archer
		niveauBatiment = 2;
		poidBonusNiveauBatiment = 1.0+((double) niveauBatiment/10);
		global = 6000;
		coutPierre = global / poidPierre;
		coutBois = global / poidBois;
		coutOr = global / poidOr;
		coutNourriture = global / poidNourriture;
		vie =  (int) ((global / poidVie) * poidBonusNiveauBatiment);
		attaque = (int) ((global / poidAttaque) * poidBonusNiveauBatiment);
		portee = (int) ((global / poidPortee) * poidBonusNiveauBatiment);
		armure = (int) ((global / poidArmure) * poidBonusNiveauBatiment);
		temps = global / poidTemps;
		Unitee cavalierArcher = new Unitee(3,12,"https://media.discordapp.net/attachments/794876433842831361/799986294889381888/Cavalier_Archer.png","Cavalier archer","Descriptif du cavalier archer"
				,coutPierre,coutBois,coutOr,coutNourriture,1,temps,vie,attaque,portee,armure,niveauBatiment,0,0,0,0);
		
		// Champion
		niveauBatiment = 3;
		poidBonusNiveauBatiment = 1.0+((double) niveauBatiment/10);
		global = 8000;
		coutPierre = global / poidPierre;
		coutBois = global / poidBois;
		coutOr = global / poidOr;
		coutNourriture = global / poidNourriture;
		vie =  (int) ((global / poidVie) * poidBonusNiveauBatiment);
		attaque = (int) ((global / poidAttaque) * poidBonusNiveauBatiment);
		portee = (int) ((global / poidPortee) * poidBonusNiveauBatiment);
		armure = (int) ((global / poidArmure) * poidBonusNiveauBatiment);
		temps = global / poidTemps;
		Unitee champion = new Unitee(3,12,"https://media.discordapp.net/attachments/794876433842831361/799986305832058900/Champion.png","Champion","Descriptif du champion"
				,coutPierre,coutBois,coutOr,coutNourriture,1,temps,vie,attaque,portee,armure,niveauBatiment,0,0,0,0);
		
		
		// ------------------ //
		// ------ PORT ------ //
		// ------------------ //
		// Bateau de pèche
		niveauBatiment = 1;
		poidBonusNiveauBatiment = 1.0+((double) niveauBatiment/10);
		global = 1000;
		coutPierre = global / poidPierre;
		coutBois = global / poidBois;
		coutOr = global / poidOr;
		coutNourriture = global / poidNourriture;
		vie =  (int) ((global / poidVie) * poidBonusNiveauBatiment);
		attaque = (int) ((global / poidAttaque) * poidBonusNiveauBatiment);
		portee = (int) ((global / poidPortee) * poidBonusNiveauBatiment);
		armure = (int) ((global / poidArmure) * poidBonusNiveauBatiment);
		temps = global / poidTemps;
		Unitee bateauDePeche = new Unitee(5,13,"https://media.discordapp.net/attachments/794876433842831361/799986281508896799/Bateau_de_peche.png","Bateau de pêche","Descriptif du bateau de pêche"
				,coutPierre,coutBois,coutOr,coutNourriture,1,temps,vie,attaque,portee,armure,niveauBatiment,0,0,0,0);
		
		// Bateau incendiaire
		niveauBatiment = 1;
		poidBonusNiveauBatiment = 1.0+((double) niveauBatiment/10);
		global = 5000;
		coutPierre = global / poidPierre;
		coutBois = global / poidBois;
		coutOr = global / poidOr;
		coutNourriture = global / poidNourriture;
		vie =  (int) ((global / poidVie) * poidBonusNiveauBatiment);
		attaque = (int) ((global / poidAttaque) * poidBonusNiveauBatiment);
		portee = (int) ((global / poidPortee) * poidBonusNiveauBatiment);
		armure = (int) ((global / poidArmure) * poidBonusNiveauBatiment);
		temps = global / poidTemps;
		Unitee bateauIncendiaire = new Unitee(5,13,"https://media.discordapp.net/attachments/794876433842831361/799986349704740884/Bateau_incendiaire.png","Bateau incendiaire","Descriptif du bateau incendiaire"
				,coutPierre,coutBois,coutOr,coutNourriture,1,temps,vie,attaque,portee,armure,niveauBatiment,0,0,0,0);
		
		// Bateau de destruction
		niveauBatiment = 2;
		poidBonusNiveauBatiment = 1.0+((double) niveauBatiment/10);
		global = 9000;
		coutPierre = global / poidPierre;
		coutBois = global / poidBois;
		coutOr = global / poidOr;
		coutNourriture = global / poidNourriture;
		vie =  (int) ((global / poidVie) * poidBonusNiveauBatiment);
		attaque = (int) ((global / poidAttaque) * poidBonusNiveauBatiment);
		portee = (int) ((global / poidPortee) * poidBonusNiveauBatiment);
		armure = (int) ((global / poidArmure) * poidBonusNiveauBatiment);
		temps = global / poidTemps;
		Unitee bateauDeDestruction = new Unitee(5,13,"https://media.discordapp.net/attachments/794876433842831361/799986366645272636/Bateau_de_destruction.png","Navire de démolition","Descriptif du navire de démolition"
				,coutPierre,coutBois,coutOr,coutNourriture,1,temps,vie,attaque,portee,armure,niveauBatiment,0,0,0,0);
		
		// Galion
		niveauBatiment = 3;
		poidBonusNiveauBatiment = 1.0+((double) niveauBatiment/10);
		global = 12000;
		coutPierre = global / poidPierre;
		coutBois = global / poidBois;
		coutOr = global / poidOr;
		coutNourriture = global / poidNourriture;
		vie =  (int) ((global / poidVie) * poidBonusNiveauBatiment);
		attaque = (int) ((global / poidAttaque) * poidBonusNiveauBatiment);
		portee = (int) ((global / poidPortee) * poidBonusNiveauBatiment);
		armure = (int) ((global / poidArmure) * poidBonusNiveauBatiment);
		temps = global / poidTemps;
		Unitee galion = new Unitee(5,13,"https://cdn.discordapp.com/attachments/794876433842831361/799990362932117524/Galion.png","Galion","Descriptif du galion"
				,coutPierre,coutBois,coutOr,coutNourriture,1,temps,vie,attaque,portee,armure,niveauBatiment,0,0,0,0);
		
		// Galion à canon
		niveauBatiment = 4;
		poidBonusNiveauBatiment = 1.0+((double) niveauBatiment/10);
		global = 15000;
		coutPierre = global / poidPierre;
		coutBois = global / poidBois;
		coutOr = global / poidOr;
		coutNourriture = global / poidNourriture;
		vie =  (int) ((global / poidVie) * poidBonusNiveauBatiment);
		attaque = (int) ((global / poidAttaque) * poidBonusNiveauBatiment);
		portee = (int) ((global / poidPortee) * poidBonusNiveauBatiment);
		armure = (int) ((global / poidArmure) * poidBonusNiveauBatiment);
		temps = global / poidTemps;
		Unitee galionACanon = new Unitee(5,13,"https://cdn.discordapp.com/attachments/794876433842831361/799986355332448267/Galion_a_canon.png","Galion à canon","Descriptif du galion à canon"
				,coutPierre,coutBois,coutOr,coutNourriture,1,temps,vie,attaque,portee,armure,niveauBatiment,0,0,0,0);

		// ------------------------------ //
		// ------ ATELIER DE SIEGE ------ //
		// ------------------------------ //
		// Guerrier Elite
		niveauBatiment = 1;
		poidBonusNiveauBatiment = 1.0+((double) niveauBatiment/10);
		global = 6000;
		coutPierre = global / poidPierre;
		coutBois = global / poidBois;
		coutOr = global / poidOr;
		coutNourriture = global / poidNourriture;
		vie =  (int) ((global / poidVie) * poidBonusNiveauBatiment);
		attaque = (int) ((global / poidAttaque) * poidBonusNiveauBatiment);
		portee = (int) ((global / poidPortee) * poidBonusNiveauBatiment);
		armure = (int) ((global / poidArmure) * poidBonusNiveauBatiment);
		temps = global / poidTemps;
		Unitee guerrierElite = new Unitee(2,14,"https://media.discordapp.net/attachments/794876433842831361/799986316292784159/Guerrier_elite.png","Guerrier élite","Descriptif du guerrier élite"
				,coutPierre,coutBois,coutOr,coutNourriture,1,temps,vie,attaque,portee,armure,niveauBatiment,0,0,0,0);
		
		// Phalange
		niveauBatiment = 1;
		poidBonusNiveauBatiment = 1.0+((double) niveauBatiment/10);
		global = 7000;
		coutPierre = global / poidPierre;
		coutBois = global / poidBois;
		coutOr = global / poidOr;
		coutNourriture = global / poidNourriture;
		vie =  (int) ((global / poidVie) * poidBonusNiveauBatiment);
		attaque = (int) ((global / poidAttaque) * poidBonusNiveauBatiment);
		portee = (int) ((global / poidPortee) * poidBonusNiveauBatiment);
		armure = (int) ((global / poidArmure) * poidBonusNiveauBatiment);
		temps = global / poidTemps;
		Unitee phalange = new Unitee(2,14,"https://media.discordapp.net/attachments/794876433842831361/799986392570658816/Phalange.png","Phalange","Descriptif du phalange"
				,coutPierre,coutBois,coutOr,coutNourriture,1,temps,vie,attaque,portee,armure,niveauBatiment,0,0,0,0);
		
		// Samourai
		niveauBatiment = 2;
		poidBonusNiveauBatiment = 1.0+((double) niveauBatiment/10);
		global = 9000;
		coutPierre = global / poidPierre;
		coutBois = global / poidBois;
		coutOr = global / poidOr;
		coutNourriture = global / poidNourriture;
		vie =  (int) ((global / poidVie) * poidBonusNiveauBatiment);
		attaque = (int) ((global / poidAttaque) * poidBonusNiveauBatiment);
		portee = (int) ((global / poidPortee) * poidBonusNiveauBatiment);
		armure = (int) ((global / poidArmure) * poidBonusNiveauBatiment);
		temps = global / poidTemps;
		Unitee samourail = new Unitee(2,14,"https://media.discordapp.net/attachments/794876433842831361/799986417350606908/Samourail.png","Samouraï","Descriptif du samouraï"
				,coutPierre,coutBois,coutOr,coutNourriture,1,temps,vie,attaque,portee,armure,niveauBatiment,0,0,0,0);
		
		// Templier
		niveauBatiment = 3;
		poidBonusNiveauBatiment = 1.0+((double) niveauBatiment/10);
		global = 12000;
		coutPierre = global / poidPierre;
		coutBois = global / poidBois;
		coutOr = global / poidOr;
		coutNourriture = global / poidNourriture;
		vie =  (int) ((global / poidVie) * poidBonusNiveauBatiment);
		attaque = (int) ((global / poidAttaque) * poidBonusNiveauBatiment);
		portee = (int) ((global / poidPortee) * poidBonusNiveauBatiment);
		armure = (int) ((global / poidArmure) * poidBonusNiveauBatiment);
		temps = global / poidTemps;
		Unitee templier = new Unitee(2,14,"https://media.discordapp.net/attachments/794876433842831361/799986422894428220/Templier.png","Templier","Descriptif du templier"
				,coutPierre,coutBois,coutOr,coutNourriture,1,temps,vie,attaque,portee,armure,niveauBatiment,0,0,0,0);
		
		// catapulte
		niveauBatiment = 4;
		poidBonusNiveauBatiment = 1.0+((double) niveauBatiment/10);
		global = 18000;
		coutPierre = global / poidPierre;
		coutBois = global / poidBois;
		coutOr = global / poidOr;
		coutNourriture = global / poidNourriture;
		vie =  (int) ((global / poidVie) * poidBonusNiveauBatiment);
		attaque = (int) ((global / poidAttaque) * poidBonusNiveauBatiment);
		portee = (int) ((global / poidPortee) * poidBonusNiveauBatiment);
		armure = (int) ((global / poidArmure) * poidBonusNiveauBatiment);
		temps = global / poidTemps;
		Unitee catapulte = new Unitee(4,14,"https://media.discordapp.net/attachments/794876433842831361/799986288237084692/Catapulte.png","Catapulte","Descriptif de la catapulte"
				,coutPierre,coutBois,coutOr,coutNourriture,1,temps,vie,attaque,portee,armure,niveauBatiment,0,0,0,0);
		
		// elephant de combat
		niveauBatiment = 5;
		poidBonusNiveauBatiment = 1.0+((double) niveauBatiment/10);
		global = 25000;
		coutPierre = global / poidPierre;
		coutBois = global / poidBois;
		coutOr = global / poidOr;
		coutNourriture = global / poidNourriture;
		vie =  (int) ((global / poidVie) * poidBonusNiveauBatiment);
		attaque = (int) ((global / poidAttaque) * poidBonusNiveauBatiment);
		portee = (int) ((global / poidPortee) * poidBonusNiveauBatiment);
		armure = (int) ((global / poidArmure) * poidBonusNiveauBatiment);
		temps = global / poidTemps;
		Unitee elephantDeCombat = new Unitee(4,14,"https://media.discordapp.net/attachments/794876433842831361/799994500356505660/Elephant_de_combat.png","Eléphant de combat","Descriptif de l'éléphant de combat"
				,coutPierre,coutBois,coutOr,coutNourriture,1,temps,vie,attaque,portee,armure,niveauBatiment,0,0,0,0);
		
		// ------------------------ //
		// ------ UNIVERSITE ------ //
		// ------------------------ //
		// Prêtre
		niveauBatiment = 1;
		poidBonusNiveauBatiment = 1.0+((double) niveauBatiment/10);
		global = 30000;
		coutPierre = global / poidPierre;
		coutBois = global / poidBois;
		coutOr = global / poidOr;
		coutNourriture = global / poidNourriture;
		vie =  (int) ((global / poidVie) * poidBonusNiveauBatiment);
		attaque = (int) ((global / poidAttaque) * poidBonusNiveauBatiment);
		portee = (int) ((global / poidPortee) * poidBonusNiveauBatiment);
		armure = (int) ((global / poidArmure) * poidBonusNiveauBatiment);
		temps = global / poidTemps;
		Unitee pretre = new Unitee(2,16,"https://media.discordapp.net/attachments/794876433842831361/799986403055370280/Pretre.png","Prêtre","Descriptif du prêtre"
				,coutPierre,coutBois,coutOr,coutNourriture,1,temps,vie,attaque,portee,armure,niveauBatiment,0,0,0,0);

		this.uniteeRepo.save(villageois);
        this.uniteeRepo.save(archer);
        this.uniteeRepo.save(archerComposite);
        this.uniteeRepo.save(fantassinEpee);
        this.uniteeRepo.save(hommeDArme);
        this.uniteeRepo.save(lanceurDeHache);
        this.uniteeRepo.save(milicien);
        this.uniteeRepo.save(piquier);
        this.uniteeRepo.save(cavalierArcher);
        this.uniteeRepo.save(cavalier);
        this.uniteeRepo.save(champion);
        
        this.uniteeRepo.save(bateauDePeche);
        this.uniteeRepo.save(bateauIncendiaire);
        this.uniteeRepo.save(bateauDeDestruction);
        this.uniteeRepo.save(galionACanon);
        this.uniteeRepo.save(galion);
        
        this.uniteeRepo.save(guerrierElite);
        this.uniteeRepo.save(phalange);
        this.uniteeRepo.save(samourail);
        this.uniteeRepo.save(templier);
        this.uniteeRepo.save(catapulte);
        this.uniteeRepo.save(elephantDeCombat);
        
        this.uniteeRepo.save(pretre);
        
        // ----- EXPEDITIONS -----
        LocalDate dateAujourdhui  = LocalDate.now(); 
        Expedition expedition1 = new Expedition("https://media.discordapp.net/attachments/794876433842831361/796753858625142804/thumb-1920-1013122.jpg?width=1278&height=497","Expedition 1","Descriptif de l'expedition 1",10, 1, 1000, 5000, 1200, 500, 500, 500, 500, 2500, 2500, 2500, 2500, 10, 5000,dateAujourdhui);
        Expedition expedition2 = new Expedition("https://media.discordapp.net/attachments/794876433842831361/796753858625142804/thumb-1920-1013122.jpg?width=1278&height=497","Expedition 2","Descriptif de l'expedition 2",3600, 1, 1000, 5000, 1200, 500, 500, 500, 500, 2500, 2500, 2500, 2500, 10, 5000,dateAujourdhui);
        Expedition expedition3 = new Expedition("https://media.discordapp.net/attachments/794876433842831361/796753858625142804/thumb-1920-1013122.jpg?width=1278&height=497","Expedition 3","Descriptif de l'expedition 3",10, 1, 1000, 5000, 1200, 500, 500, 500, 500, 2500, 2500, 2500, 2500, 10, 5000,dateAujourdhui);
        Expedition expedition4 = new Expedition("https://media.discordapp.net/attachments/794876433842831361/796753858625142804/thumb-1920-1013122.jpg?width=1278&height=497","Expedition 4","Descriptif de l'expedition 4",10, 1, 1000, 5000, 1200, 500, 500, 500, 500, 2500, 2500, 2500, 2500, 10, 5000,dateAujourdhui);
        this.expeditionRepo.save(expedition1);
        this.expeditionRepo.save(expedition2);
        this.expeditionRepo.save(expedition3);
        this.expeditionRepo.save(expedition4);

        // ----- ARMEES -----
        Armee armeeChampion = new Armee(joueur1,champion,20,1612523480L,1612523480L);
        Armee armeeArcher = new Armee(joueur1,archer,300,1612523480L,1612523480L);
        this.armeeRepo.save(armeeChampion);
        this.armeeRepo.save(armeeArcher);
         
    }

}
