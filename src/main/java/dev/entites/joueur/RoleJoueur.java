package dev.entites.joueur;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class RoleJoueur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/** joueur **/
	@ManyToOne
	@JoinColumn(name = "joueur_id")
	private Joueur joueur;

	/** rôle d'un joueur **/
	@Enumerated(EnumType.STRING)
	private Role role;

	/**
	 * Constructeur vide
	 */
	public RoleJoueur() {
	}

	/**
	 * CONSTRUCTEUR AVEC PARAMETRES
	 * 
	 * @param joueur
	 * @param rôle
	 */
	public RoleJoueur(Joueur joueur, Role role) {
		this.joueur = joueur;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Long id) {
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	/**
	 * Getter
	 *
	 * @return rôle
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * Setter
	 *
	 * @param rôle to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}
}
