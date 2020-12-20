package dev.controller.dto;

import java.util.ArrayList;
import java.util.List;
import dev.entites.Role;

public class JoueurInfoDto {

	// Déclarations
	private String email;
	private String nom;
	private String prenom;
	private List<Role> roles = new ArrayList<>();

	/**
	 * Constructeur
	 * 
	 * @param email
	 * @param nom
	 * @param prenom
	 * @param roles
	 */
	public JoueurInfoDto(String email, String nom, String prenom) {
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
	}

	/**
	 * Constructeur vide
	 */
	public JoueurInfoDto() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
}
