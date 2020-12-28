package dev;

import java.time.LocalDate;
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
import dev.entites.batiment.divers.HotelDeVille;
import dev.entites.joueur.Armee;
import dev.entites.joueur.Base;
import dev.entites.unitee.infanterie.Archer;
import dev.entites.unitee.infanterie.FantassinEpee;
import dev.repository.JoueurRepo;
import dev.repository.batiment.divers.ChaumiereRepo;
import dev.repository.batiment.divers.HotelDeVilleRepo;
import dev.repository.batiment.divers.MarcheRepo;
import dev.repository.batiment.divers.TableExpeditionRepo;
import dev.repository.batiment.millitaire.AtelierDeSiegeRepo;
import dev.repository.batiment.millitaire.CaserneMillitaireRepo;
import dev.repository.batiment.millitaire.EcurieRepo;
import dev.repository.batiment.millitaire.PortRepo;
import dev.repository.batiment.recherche.ForgeRepo;
import dev.repository.batiment.recherche.UniversiteRepo;
import dev.repository.batiment.ressource.CampDeBucheronRepo;
import dev.repository.batiment.ressource.CampDeMineurRepo;
import dev.repository.batiment.ressource.CarriereRepo;
import dev.repository.batiment.ressource.FermeRepo;
import dev.repository.batiment.stockage.BanqueRepo;
import dev.repository.batiment.stockage.EntrepotRepo;
import dev.repository.batiment.stockage.GrenierRepo;
import dev.repository.batiment.stockage.ScierieRepo;
import dev.repository.joueur.ArmeeRepo;
import dev.repository.joueur.BaseRepo;
import dev.repository.social.GuildeRepo;
import dev.repository.social.ListeAmisRepo;
import dev.repository.unitee.cavalerie.CavalierExpertRepo;
import dev.repository.unitee.cavalerie.CavalierRepo;
import dev.repository.unitee.cavalerie.PaladinRepo;
import dev.repository.unitee.divers.MuleDeCommerceRepo;
import dev.repository.unitee.divers.PretreRepo;
import dev.repository.unitee.divers.VillageoisRepo;
import dev.repository.unitee.infanterie.ArcherCompositeRepo;
import dev.repository.unitee.infanterie.ArcherEliteRepo;
import dev.repository.unitee.infanterie.ArcherRepo;
import dev.repository.unitee.infanterie.FantassinEpeeRepo;
import dev.repository.unitee.infanterie.FantassinHacheRepo;
import dev.repository.unitee.infanterie.LegionnaireRepo;
import dev.repository.unitee.navale.NavireDeGuerreRepo;
import dev.repository.unitee.navale.NavireDePecheRepo;
import dev.repository.unitee.navale.NavireEclaireurRepo;
import dev.repository.unitee.siege.BalisteRepo;
import dev.repository.unitee.siege.CatapulteRepo;
import dev.repository.unitee.siege.ElephanDeGuerreRepo;


/**
 * Code de démarrage de l'application.
 * Insertion de jeux de données.
 */
@Component
public class StartupListener {
	
	private String appVersion;
    private PasswordEncoder passwordEncoder;
    // ---- Batiment ----
    // - divers -
    private ChaumiereRepo chaumiereRepo;
    private HotelDeVilleRepo hotelDeVilleRepo;
    private MarcheRepo marcheRepo;
    private TableExpeditionRepo tableExpeditionRepo;
    // - millitaire -
    private AtelierDeSiegeRepo atelierDeSiegeRepo;
    private CaserneMillitaireRepo caserneMillitaireRepo;
    private EcurieRepo ecurieRepo;
    private PortRepo portRepo;
    // - recherche -
    private ForgeRepo forgeRepo;
    private UniversiteRepo universiteRepo;
    // - ressource -
    private CampDeBucheronRepo campDeBucheronRepo;
    private CampDeMineurRepo campDeMineurRepo;
    private CarriereRepo carriereRepo;
    private FermeRepo fermeRepo;
    // - stockage -
    private BanqueRepo banqueRepo;
    private EntrepotRepo entrepotRepo;
    private GrenierRepo grenierRepo;
    private ScierieRepo scierieRepo;
    // ---- Joueur ----
    private JoueurRepo joueurRepo;
    private BaseRepo baseRepo;
    private ArmeeRepo armeeRepo;
    // ---- Social ----
    private GuildeRepo guildeRepo;
    private ListeAmisRepo listeAmisRepo;
    // ---- Unitee ----
    // - Cavalerie -
    private CavalierExpertRepo cavalierExpertRepo;
    private CavalierRepo cavalierRepo;
    private PaladinRepo paladinRepo;
    // - Divers -
    private MuleDeCommerceRepo muleDeCommerceRepo;
    private PretreRepo pretreRepo;
    private VillageoisRepo villageoisRepo;
    // - Infanterie -
    private ArcherCompositeRepo archerCompositeRepo;
    private ArcherEliteRepo archerEliteRepo;
    private ArcherRepo archerRepo;
    private FantassinEpeeRepo fantassinEpeeRepo;
    private FantassinHacheRepo fantassinHacheRepo;
    private LegionnaireRepo legionnaireRepo;
    // - Navale -
    private NavireDeGuerreRepo navireDeGuerreRepo;
    private NavireDePecheRepo navireDePecheRepo;
    private NavireEclaireurRepo navireEclaireurRepo;
    // - Siege -
    private BalisteRepo balisteRepo;
    private CatapulteRepo catapulteRepo;
    private ElephanDeGuerreRepo elephanDeGuerreRepo;
 
    public StartupListener(@Value("${app.version}") String appVersion, 
    		PasswordEncoder passwordEncoder,
    		ChaumiereRepo chaumiereRepo,
    		HotelDeVilleRepo hotelDeVilleRepo,
    		MarcheRepo marcheRepo,
    		TableExpeditionRepo tableExpeditionRepo,
    		AtelierDeSiegeRepo atelierDeSiegeRepo,
    		CaserneMillitaireRepo caserneMillitaireRepo,
    		EcurieRepo ecurieRepo,
    		PortRepo portRepo,
    		ForgeRepo forgeRepo,
    		UniversiteRepo universiteRepo,
    		CampDeBucheronRepo campDeBucheronRepo,
    		CampDeMineurRepo campDeMineurRepo,
    		CarriereRepo carriereRepo,
    		FermeRepo fermeRepo,
    		BanqueRepo banqueRepo,
    		EntrepotRepo entrepotRepo,
    		GrenierRepo grenierRepo,
    		ScierieRepo scierieRepo,
    		JoueurRepo joueurRepo,
    		BaseRepo baseRepo,
    		ArmeeRepo armeeRepo,
    		GuildeRepo guildeRepo,
    		ListeAmisRepo listeAmisRepo,
    		CavalierExpertRepo cavalierExpertRepo,
    		CavalierRepo cavalierRepo,
    		PaladinRepo paladinRepo,
    		MuleDeCommerceRepo muleDeCommerceRepo,
    		PretreRepo pretreRepo,
    		VillageoisRepo villageoisRepo,
    		ArcherCompositeRepo archerCompositeRepo,
    		ArcherEliteRepo archerEliteRepo,
    		ArcherRepo archerRepo,
    		FantassinEpeeRepo fantassinEpeeRepo,
    		FantassinHacheRepo fantassinHacheRepo,
    		LegionnaireRepo legionnaireRepo,
    		NavireDeGuerreRepo navireDeGuerreRepo,
    		NavireDePecheRepo navireDePecheRepo,
    		NavireEclaireurRepo navireEclaireurRepo,
    		BalisteRepo balisteRepo,
    		CatapulteRepo catapulteRepo,
    		ElephanDeGuerreRepo elephanDeGuerreRepo) {
        this.appVersion = appVersion;
        this.passwordEncoder = passwordEncoder;
        // - divers -
        this.chaumiereRepo = chaumiereRepo;
        this.hotelDeVilleRepo = hotelDeVilleRepo;
        this.marcheRepo = marcheRepo;
        this.tableExpeditionRepo = tableExpeditionRepo;
        // - millitaire -
        this.atelierDeSiegeRepo = atelierDeSiegeRepo;
        this.caserneMillitaireRepo = caserneMillitaireRepo;
        this.ecurieRepo = ecurieRepo;
        this.portRepo = portRepo;
        // - recherche -
        this.forgeRepo = forgeRepo;
        this.universiteRepo = universiteRepo;
        // - ressource -
        this.campDeBucheronRepo = campDeBucheronRepo;
        this.campDeMineurRepo = campDeMineurRepo;
        this.carriereRepo = carriereRepo;
        this.fermeRepo = fermeRepo;
        // - stockage -
        this.banqueRepo = banqueRepo;
        this.entrepotRepo = entrepotRepo;
        this.grenierRepo = grenierRepo;
        this.scierieRepo = scierieRepo;
        // ---- Joueur ----
        this.joueurRepo = joueurRepo;
        this.baseRepo = baseRepo;
        this.armeeRepo = armeeRepo;
        // ---- Social ----
        this.guildeRepo = guildeRepo;
        this.listeAmisRepo = listeAmisRepo;
        // ---- Unitee ----
        // - Cavalerie -
        this.cavalierExpertRepo = cavalierExpertRepo;
        this.cavalierRepo = cavalierRepo;
        this.paladinRepo = paladinRepo;
        // - Divers -
        this.muleDeCommerceRepo = muleDeCommerceRepo;
        this.pretreRepo = pretreRepo;
        this.villageoisRepo = villageoisRepo;
        // - Infanterie -
        this.archerCompositeRepo = archerCompositeRepo;
        this.archerEliteRepo = archerEliteRepo;
        this.archerRepo = archerRepo;
        this.fantassinEpeeRepo = fantassinEpeeRepo;
        this.fantassinHacheRepo = fantassinHacheRepo;
        this.legionnaireRepo = legionnaireRepo;
        // - Navale -
        this.navireDeGuerreRepo = navireDeGuerreRepo;
        this.navireDePecheRepo = navireDePecheRepo;
        this.navireEclaireurRepo = navireEclaireurRepo;
        // - Siege -
        this.balisteRepo = balisteRepo;
        this.catapulteRepo = catapulteRepo;
        this.elephanDeGuerreRepo = elephanDeGuerreRepo;
        
        
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
        
        // ----- UNITEE -----
        Archer archer1 = new Archer(1);
        Archer archer2 = new Archer(3);
        this.archerRepo.save(archer1);
        this.archerRepo.save(archer2);
        List<Integer> listeUnitee = new ArrayList<>();
        listeUnitee.add(archer1.getId());
        listeUnitee.add(archer2.getId());
        
        // ----- BATIMENT -----
        HotelDeVille hotelDeVille1 = new HotelDeVille();
        List<Integer> listeBatiments = new ArrayList<>();
        listeBatiments.add(hotelDeVille1.getId());
        
        // ----- BASE -----
        Base baseJoueur1 = new Base(joueur1,listeBatiments);
        
        // ----- ARMEE -----

        Armee armeeJoueur1 = new Armee(joueur1,listeUnitee);

        System.out.println("Armee du joueur 1 : " + armeeJoueur1);
        
        
         
    }

}
