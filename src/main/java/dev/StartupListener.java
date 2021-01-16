package dev;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import dev.entites.Joueur;
import dev.entites.Role;
import dev.entites.RoleJoueur;
import dev.entites.batiment.Batiment;
import dev.entites.joueur.Armee;
import dev.entites.joueur.BatimentJoueur;
import dev.entites.social.Guilde;
import dev.entites.unitee.Unitee;
import dev.repository.JoueurRepo;
import dev.repository.batiment.BatimentRepo;
import dev.repository.joueur.ArmeeRepo;
import dev.repository.joueur.BatimentJoueurRepo;
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
    // - divers -
    // ---- Joueur ----
    private BatimentJoueurRepo batimentJoueurRepo;
    private JoueurRepo joueurRepo;
    private ArmeeRepo armeeRepo;
    // ---- Social ----
    private GuildeRepo guildeRepo;
    public StartupListener(@Value("${app.version}") String appVersion, 
    		PasswordEncoder passwordEncoder,
    		UniteeRepo uniteeRepo,
    		BatimentRepo batimentRepo,

    		BatimentJoueurRepo batimentJoueurRepo,

    		JoueurRepo joueurRepo,
    		ArmeeRepo armeeRepo,
    		GuildeRepo guildeRepo,
    		ListeAmisRepo listeAmisRepo) {
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
        this.guildeRepo = guildeRepo;
    }

    @EventListener(ContextRefreshedEvent.class)
    public void onStart() {
   
    	 
    /* ********************************************************************************* */

        
    	// ----- JOUEUR -----
        Joueur joueur1 = new Joueur();
        joueur1.setIcone("https://yscorporate.com/wp-content/uploads/2019/01/Photo-profil-professionnelle-par-photographe-entreprise10.jpg");
        joueur1.setPseudo("Nelfire");
        joueur1.setEmail("girvincent@gmail.com");
        joueur1.setMotDePasse(passwordEncoder.encode("password"));
        joueur1.setDescriptif("Salut ! Je suis le premier joueur");
        joueur1.setNiveau(1);
        joueur1.setExperience(0);
        joueur1.setPierrePossession(1000);
        joueur1.setBoisPossession(1000);
        joueur1.setOrPossession(1000);
        joueur1.setNourriturePossession(1000);
        joueur1.setGemmePossession(50);
        joueur1.setPierreMaximum(20000);
        joueur1.setBoisMaximum(20000);
        joueur1.setOrMaximum(20000);
        joueur1.setNourritureMaximum(20000);
        joueur1.setTempsDeJeu(0);
        joueur1.setGemmePossession(50);
        joueur1.setRoles(Arrays.asList(new RoleJoueur(joueur1, Role.ROLE_ADMINISTRATEUR), new RoleJoueur(joueur1, Role.ROLE_JOUEUR)));
        this.joueurRepo.save(joueur1);
        

        
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
        Batiment hdv = new Batiment(1);
        Batiment chaumiere = new Batiment(2);
        Batiment carriere = new Batiment(3);
        Batiment campDeBucheron = new Batiment(4);
        Batiment campDeMineur = new Batiment(5);
        Batiment ferme = new Batiment(6);
        Batiment entrepot = new Batiment(7);
        Batiment scierie = new Batiment(8);
        Batiment banque = new Batiment(9);
        Batiment grenier = new Batiment(10);
        Batiment caserneMillitaire = new Batiment(11);
        Batiment ecurie = new Batiment(12);
        Batiment port = new Batiment(13);
        Batiment atelierDeSiere = new Batiment(14);
        Batiment forge = new Batiment(15);
        Batiment universite = new Batiment(16);
        Batiment marche = new Batiment(17);
        Batiment tableExpedition = new Batiment(18);
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
        this.batimentRepo.save(atelierDeSiere);
        this.batimentRepo.save(forge);
        this.batimentRepo.save(universite);
        this.batimentRepo.save(marche);
        this.batimentRepo.save(tableExpedition);
        
		List<Batiment> listeBatiments = new ArrayList<>();
		listeBatiments.add(hdv);
		listeBatiments.add(ferme);
		System.out.println(hdv.toString());

		long debut = new Date().getTime();
		long fin = new Date().getTime();
		
		BatimentJoueur batimentJoueur1 = new BatimentJoueur(joueur1, hdv, 2, null, debut, fin);
		BatimentJoueur batimentJoueur2 = new BatimentJoueur(joueur1, port, 4,  null, debut, fin);
		BatimentJoueur batimentJoueur3 = new BatimentJoueur(joueur1, carriere, 7,  null, debut, fin);
		this.batimentJoueurRepo.save(batimentJoueur1);
		this.batimentJoueurRepo.save(batimentJoueur2);
		this.batimentJoueurRepo.save(batimentJoueur3);
		System.out.println(batimentJoueur1.toString());
		
        // ----- BASE -----
//		Base baseJoueur1 = new Base(joueur1,listeBatiments);
//        this.baseRepo.save(baseJoueur1);
//		System.out.println(baseJoueur1.toString());
        
		// Type =
		// 1 = Divers
		// 2 = Infanterie
		// 3 - Cavalerie
		// 4 - Siège
		// 5 - Navale
        // ----- UNITEE -----
		Unitee villageois = new Unitee(1,1,"https://media.discordapp.net/attachments/794876433842831361/799986427348647964/Villageois.png","Villageois","Descriptif du villageois",99,99,99,99,1,10,99,99,99,99,1,0,0,0,0);
		Unitee archer = new Unitee(2,11,"https://media.discordapp.net/attachments/794876433842831361/799986264299405342/Archer.png","Archer","Descriptif de l'archer",99,99,99,99,1,10,99,99,99,99,1,0,0,0,0);
		Unitee archerComposite = new Unitee(2,11,"https://media.discordapp.net/attachments/794876433842831361/799986256377151518/Archer_Composite.png","Archer composite","Descriptif de l'archer composite",99,99,99,99,1,10,99,99,99,99,1,0,0,0,0);
		Unitee fantassinEpee = new Unitee(2,11,"https://media.discordapp.net/attachments/794876433842831361/799986321065771018/Fantassin_epee.png","Fantassin épée","Descriptif du fantassin épée",99,99,99,99,1,10,99,99,99,99,1,0,0,0,0);
		Unitee guerrierElite = new Unitee(2,14,"https://media.discordapp.net/attachments/794876433842831361/799986316292784159/Guerrier_elite.png","Guerrier élite","Descriptif du guerrier élite",99,99,99,99,1,10,99,99,99,99,1,0,0,0,0);
		Unitee hommeDArme = new Unitee(2,11,"https://media.discordapp.net/attachments/794876433842831361/799986373188255764/Homme_darme.png","Homme d'arme","Descriptif de l'homme d'arme",99,99,99,99,1,10,99,99,99,99,1,0,0,0,0);
		Unitee lanceurDeHache = new Unitee(2,11,"https://media.discordapp.net/attachments/794876433842831361/799986377042165770/Lanceur_de_hache.png","Lanceur de hache","Descriptif du lanceur de hache",99,99,99,99,1,10,99,99,99,99,1,0,0,0,0);
		Unitee phalange = new Unitee(2,1,"https://media.discordapp.net/attachments/794876433842831361/799986392570658816/Phalange.png","Phalange","Descriptif du phalange",99,99,99,99,1,10,99,99,99,99,1,0,0,0,0);
		Unitee milicien = new Unitee(2,11,"https://media.discordapp.net/attachments/794876433842831361/799986387787972648/Milicien.png","Milicien","Descriptif du milicien",99,99,99,99,1,10,99,99,99,99,1,0,0,0,0);
		Unitee piquier = new Unitee(2,1,"https://media.discordapp.net/attachments/794876433842831361/799986398294704168/Piquier.png","Piquier","Descriptif du piquier",99,99,99,99,1,10,99,99,99,99,1,0,0,0,0);
		Unitee pretre = new Unitee(2,1,"https://media.discordapp.net/attachments/794876433842831361/799986403055370280/Pretre.png","Prêtre","Descriptif du prêtre",99,99,99,99,1,10,99,99,99,99,1,0,0,0,0);
		Unitee samourail = new Unitee(2,14,"https://media.discordapp.net/attachments/794876433842831361/799986417350606908/Samourail.png","Samourail","Descriptif du samouraile",99,99,99,99,1,10,99,99,99,99,1,0,0,0,0);
		Unitee templier = new Unitee(2,14,"https://media.discordapp.net/attachments/794876433842831361/799986422894428220/Templier.png","Templier","Descriptif du templier",99,99,99,99,1,10,99,99,99,99,1,0,0,0,0);
		Unitee cavalier = new Unitee(3,12,"https://media.discordapp.net/attachments/794876433842831361/799986300571615272/Cavalier.png","Cavalier","Descriptif du cavalier",99,99,99,99,1,10,99,99,99,99,1,0,0,0,0);
		Unitee cavalierArcher = new Unitee(3,12,"https://media.discordapp.net/attachments/794876433842831361/799986294889381888/Cavalier_Archer.png","Cavalier archer","Descriptif du cavalier archer",99,99,99,99,1,10,99,99,99,99,1,0,0,0,0);
		Unitee champion = new Unitee(3,12,"https://media.discordapp.net/attachments/794876433842831361/799986305832058900/Champion.png","Champion","Descriptif du champion",99,99,99,99,1,10,99,99,99,99,1,0,0,0,0);
		Unitee catapulte = new Unitee(4,14,"https://media.discordapp.net/attachments/794876433842831361/799986288237084692/Catapulte.png","Catapultre","Descriptif de la catapulte",99,99,99,99,1,10,99,99,99,99,1,0,0,0,0);
		Unitee elephantDeCombat = new Unitee(4,14,"https://media.discordapp.net/attachments/794876433842831361/799994500356505660/Elephant_de_combat.png","Eléphant de combat","Descriptif de l'éléphant de combat",99,99,99,99,1,10,99,99,99,99,1,0,0,0,0);
		Unitee bateauDePeche = new Unitee(5,13,"https://media.discordapp.net/attachments/794876433842831361/799986281508896799/Bateau_de_peche.png","Bateau de pêche","Descriptif du bateau de pêche",99,99,99,99,1,10,99,99,99,99,1,0,0,0,0);
		Unitee bateauIncendiaire = new Unitee(5,13,"https://media.discordapp.net/attachments/794876433842831361/799986349704740884/Bateau_incendiaire.png","Bateau incendiaire","Descriptif du bateau incendiaire",99,99,99,99,1,10,99,99,99,99,1,0,0,0,0);
		Unitee bateauDeDestruction = new Unitee(5,13,"https://media.discordapp.net/attachments/794876433842831361/799986366645272636/Bateau_de_destruction.png","Bateau de destruction","Descriptif du bateau de destruction",99,99,99,99,1,10,99,99,99,99,1,0,0,0,0);
		Unitee galionACanon = new Unitee(5,13,"https://cdn.discordapp.com/attachments/794876433842831361/799986355332448267/Galion_a_canon.png","Galion à canon","Descriptif du galion à canon",99,99,99,99,1,10,99,99,99,99,1,0,0,0,0);
		Unitee galion = new Unitee(5,13,"https://cdn.discordapp.com/attachments/794876433842831361/799990362932117524/Galion.png","Galion","Descriptif du galion",99,99,99,99,1,10,99,99,99,99,1,0,0,0,0);
        this.uniteeRepo.save(villageois);
        this.uniteeRepo.save(archer);
        this.uniteeRepo.save(archerComposite);
        this.uniteeRepo.save(fantassinEpee);
        this.uniteeRepo.save(guerrierElite);
        this.uniteeRepo.save(hommeDArme);
        this.uniteeRepo.save(lanceurDeHache);
        this.uniteeRepo.save(phalange);
        this.uniteeRepo.save(milicien);
        this.uniteeRepo.save(piquier);
        this.uniteeRepo.save(pretre);
        this.uniteeRepo.save(samourail);
        this.uniteeRepo.save(templier);
        this.uniteeRepo.save(cavalier);
        this.uniteeRepo.save(cavalierArcher);
        this.uniteeRepo.save(champion);
        this.uniteeRepo.save(catapulte);
        this.uniteeRepo.save(elephantDeCombat);
        this.uniteeRepo.save(bateauDePeche);
        this.uniteeRepo.save(bateauIncendiaire);
        this.uniteeRepo.save(bateauDeDestruction);
        this.uniteeRepo.save(galionACanon);
        this.uniteeRepo.save(galion);

        // ----- ARMEE -----
//		List<Unitee> listeUniteesJoueur1 = new ArrayList<>();
//		listeUniteesJoueur1.add(villageois1);
//		listeUniteesJoueur1.add(archer1);
//		Armee armeeJoueur1 = new Armee(joueur1, listeUniteesJoueur1);
//		this.armeeRepo.save(armeeJoueur1);
//		System.out.println(armeeJoueur1.toString());
				
		Date date = new Date();
		System.out.println(date);
		date.setSeconds(date.getSeconds()+600);
		System.out.println(date);
		// ----- GUILDE -----
        Guilde guilde1 = new Guilde("Les loulous de l'espace","xxx","Coucou les loulous");
        guilde1.setChefGuilde(joueur1);
        this.guildeRepo.save(guilde1);
//        System.out.println(guilde1.getChefGuilde());
//        System.out.println(joueur1.getGuilde());
//        System.out.println(joueur1.getChefGuilde());
        
         
    }

}
