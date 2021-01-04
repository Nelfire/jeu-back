package dev;

import java.util.ArrayList;
import java.util.Arrays;
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

		BatimentJoueur batimentJoueur1 = new BatimentJoueur(joueur1, hdv, 2, null);
		BatimentJoueur batimentJoueur2 = new BatimentJoueur(joueur1, port, 4, null);
		BatimentJoueur batimentJoueur3 = new BatimentJoueur(joueur1, carriere, 1, 99);
		this.batimentJoueurRepo.save(batimentJoueur1);
		this.batimentJoueurRepo.save(batimentJoueur2);
		this.batimentJoueurRepo.save(batimentJoueur3);
		System.out.println(batimentJoueur1.toString());
		
        // ----- BASE -----
//		Base baseJoueur1 = new Base(joueur1,listeBatiments);
//        this.baseRepo.save(baseJoueur1);
//		System.out.println(baseJoueur1.toString());
        
        // ----- UNITEE -----
        Unitee villageois1 = new Unitee(1,1);
        Unitee archer1 = new Unitee(5,1);
        this.uniteeRepo.save(villageois1);
        this.uniteeRepo.save(archer1);
        
        // ----- ARMEE -----
		List<Unitee> listeUniteesJoueur1 = new ArrayList<>();
		listeUniteesJoueur1.add(villageois1);
		listeUniteesJoueur1.add(archer1);
		Armee armeeJoueur1 = new Armee(joueur1, listeUniteesJoueur1);
		this.armeeRepo.save(armeeJoueur1);
//		System.out.println(armeeJoueur1.toString());
				
		// ----- GUILDE -----
        Guilde guilde1 = new Guilde("Les loulous de l'espace","xxx","Coucou les loulous");
        guilde1.setChefGuilde(joueur1);
        this.guildeRepo.save(guilde1);
//        System.out.println(guilde1.getChefGuilde());
//        System.out.println(joueur1.getGuilde());
//        System.out.println(joueur1.getChefGuilde());
        
         
    }

}
