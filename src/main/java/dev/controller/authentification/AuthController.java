package dev.controller.authentification;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.controller.dto.joueur.CreationCompteJoueurDto;
import dev.entites.joueur.Joueur;
import dev.entites.joueur.Role;
import dev.entites.joueur.RoleJoueur;
import dev.exceptions.MessageResponseException;
import dev.repository.JoueurRepo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("auth")
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class AuthController {
	//https://bezkoder.com/spring-boot-jwt-authentication/
	
	@Autowired
	JoueurRepo joueurRepo;
	
	@Autowired
	PasswordEncoder encoder;
	
	@PostMapping
	public ResponseEntity<?> registerUser(@Valid @RequestBody CreationCompteJoueurDto signUpRequest) {
		for (Joueur joueur : joueurRepo.findAll())  {
			if(joueur.getPseudo().equals(signUpRequest.getPseudo())) {
				return ResponseEntity
						.badRequest()
						.body(new MessageResponseException("Pseudo déjà utilisé"));
			}
			if (joueur.getEmail().equals(signUpRequest.getEmail())) {
				return ResponseEntity
						.badRequest()
						.body(new MessageResponseException("Email déjà utilisé"));
			}
		}

		// Taille password > 5 ??
		if(signUpRequest.getPassword().length() <5) {
			throw new MessageResponseException("Le mot de passe doit faire une taille de 5 caractères au minimum pour votre sécurité.");

		}

		// Match email ?
		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
		Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(signUpRequest.getEmail());
	    if(matcher.matches() == false) {
			throw new MessageResponseException("Le format de l'adresse email n'est pas valide.");
	    }
		

		// Create new user's account
        Joueur joueur1 = new Joueur();
        joueur1.setIcone("https://cdn.discordapp.com/attachments/794876433842831361/815288917468512256/icone.png");
        joueur1.setPseudo(signUpRequest.getPseudo());
        joueur1.setEmail(signUpRequest.getEmail());
        joueur1.setMotDePasse(encoder.encode(signUpRequest.getPassword()));
        joueur1.setDescriptif("");
        joueur1.setNiveau(1);
        joueur1.setExperience(0L);
        joueur1.setPierrePossession(1000L);
        joueur1.setBoisPossession(1000L);
        joueur1.setOrPossession(1000L);
        joueur1.setNourriturePossession(1000L);
        joueur1.setGemmePossession(50L);
        joueur1.setPierreMaximum(20000L);
        joueur1.setBoisMaximum(20000L);
        joueur1.setOrMaximum(20000L);
        joueur1.setNourritureMaximum(20000L);
        joueur1.setPierreBoostProduction(0);
        joueur1.setBoisBoostProduction(0);
        joueur1.setOrBoostProduction(0);
        joueur1.setNourritureBoostProduction(0);
        joueur1.setTempsDeJeu(0);
        joueur1.setGemmePossession(100L);
        joueur1.setRoles(Arrays.asList(new RoleJoueur(joueur1, Role.ROLE_JOUEUR)));
        joueur1.setDonateur(false);

        Boolean positionDejaPrise = true;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        // Récupération de toutes les positions déjà occupées
        for (Joueur joueur : joueurRepo.findAll()) {
        	map.put(joueur.getPositionX(), joueur.getPositionY());
		}
        
        // Définir une position pour le joueur
        Integer positionJoueurX = getChiffreRandom(1,30);
        Integer positionJoueurY = getChiffreRandom(1,30);

        // Vérification position disponible
        while(positionDejaPrise==true) {

        	positionDejaPrise = false;
	        //Boucle while+iterator
	        Iterator iterator = map.entrySet().iterator();
	        
	        // La position est déjà prise, définition d'une nouvelle
	        while (iterator.hasNext() && positionDejaPrise!=true) {
	          Map.Entry mapentry = (Map.Entry) iterator.next();
	          if(mapentry.getKey() == positionJoueurX && mapentry.getValue() == positionJoueurY) {
	             // Définir une nouvelle position
	        	 positionDejaPrise = true;
	             positionJoueurX = getChiffreRandom(1,30);
	             positionJoueurY = getChiffreRandom(1,30);
	          } 		        
	        }
        }

        joueur1.setPositionX(positionJoueurX);
        joueur1.setPositionX(positionJoueurY);
        
        joueurRepo.save(joueur1);

		return ResponseEntity.ok(new MessageResponseException("Compte créé avec succès !"));
	}
	
	public static int getChiffreRandom(int minimum, int maximum) {
	    if (minimum < maximum)
	        return minimum + new Random().nextInt(Math.abs(maximum - minimum));
	    return minimum - new Random().nextInt(Math.abs(maximum - minimum));
	}

}
