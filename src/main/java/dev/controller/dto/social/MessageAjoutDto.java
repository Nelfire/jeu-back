package dev.controller.dto.social;

public class MessageAjoutDto {

	private String contenu;

	/**
	 * CONSTRUCTEUR VIDE
	 */
	public MessageAjoutDto() {
	}

	/**
	 * CONSTRUCTEUR AVEC PARAMETRES
	 * 
	 * @param contenu
	 */
	public MessageAjoutDto(String contenu) {
		super();
		this.contenu = contenu;
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

}
