package dev.entites.social;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import dev.entites.joueur.Joueur;

@Entity
public class ChatGuilde {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	/** Date d'envoi du message **/
    private LocalDate dateMessage;
 
    /** Id de la guilde concernée par le chat**/
    private Integer idGuilde;
    
    /** Contenu du message**/
    private String message;
    
    /** Joueur émetteur du message**/
	@ManyToOne
	@JoinColumn(name = "joueur_id")
	private Joueur joueur;
	
	/**
	 * @param dateMessage
	 * @param idGuilde
	 * @param message
	 * @param joueur
	 */
	public ChatGuilde(LocalDate dateMessage, Integer idGuilde, String message, Joueur joueur) {
		super();
		this.dateMessage = dateMessage;
		this.idGuilde = idGuilde;
		this.message = message;
		this.joueur = joueur;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the dateMessage
	 */
	public LocalDate getDateMessage() {
		return dateMessage;
	}

	/**
	 * @param dateMessage the dateMessage to set
	 */
	public void setDateMessage(LocalDate dateMessage) {
		this.dateMessage = dateMessage;
	}

	/**
	 * @return the idGuilde
	 */
	public Integer getIdGuilde() {
		return idGuilde;
	}

	/**
	 * @param idGuilde the idGuilde to set
	 */
	public void setIdGuilde(Integer idGuilde) {
		this.idGuilde = idGuilde;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the joueur
	 */
	public Joueur getJoueur() {
		return joueur;
	}

	/**
	 * @param joueur the joueur to set
	 */
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}
    
	
}
