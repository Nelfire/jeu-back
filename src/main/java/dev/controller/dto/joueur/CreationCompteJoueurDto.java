package dev.controller.dto.joueur;

public class CreationCompteJoueurDto {

	private String pseudo;
	private String email;
	private String password;
	/**
	 * @param pseudo
	 * @param email
	 * @param password
	 */
	public CreationCompteJoueurDto(String pseudo, String email, String password) {
		super();
		this.pseudo = pseudo;
		this.email = email;
		this.password = password;
	}
	/**
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}
	/**
	 * @param pseudo the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
