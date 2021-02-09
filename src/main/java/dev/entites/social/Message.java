package dev.entites.social;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import dev.entites.joueur.Joueur;

@Entity
public class Message {
	
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    
	@ManyToOne
	@JoinColumn(name = "joueur_id")
    private Joueur joueur;
    
	private Long datePublication;
    private String contenu;
    
    public Message() {
    	
    }
	/**
	 * @param joueur
	 * @param datePublication
	 * @param contenu
	 */
	public Message(Joueur joueur, Long datePublication, String contenu) {
		super();
		this.joueur = joueur;
		this.datePublication = datePublication;
		this.contenu = contenu;
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
	/**
	 * @return the datePublication
	 */
	public Long getDatePublication() {
		return datePublication;
	}
	/**
	 * @param datePublication the datePublication to set
	 */
	public void setDatePublication(Long datePublication) {
		this.datePublication = datePublication;
	}
	/**
	 * @return the contenu
	 */
	public String getContenu() {
		return contenu;
	}
	/**
	 * @param contenu the contenu to set
	 */
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", joueur=" + joueur + ", datePublication=" + datePublication + ", contenu="
				+ contenu + "]";
	}
    
	
    
}
