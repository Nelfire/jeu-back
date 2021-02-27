package dev.controller.authentification;

import java.util.Arrays;
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
import dev.exceptions.RessourceManquanteException;
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
        joueur1.setRoles(Arrays.asList(new RoleJoueur(joueur1, Role.ROLE_JOUEUR)));
        joueurRepo.save(joueur1);

		return ResponseEntity.ok(new MessageResponseException("Compte créé avec succès !"));
	}

}
