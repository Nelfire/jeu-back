package dev.controller.dto.social;

public class MessageAjoutDto {

	// Déclarations
	private String contenu;

	/**
	 * @param contenu
	 */
	public MessageAjoutDto() {
	}
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
