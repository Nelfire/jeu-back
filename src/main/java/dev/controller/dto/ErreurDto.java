/**
 * 
 */
package dev.controller.dto;

public class ErreurDto {

	// Déclarations
	private String message;

	/**
	 * Constructeur vide
	 */
	public ErreurDto() {
	}

	/**
	 * Getter
	 *
	 * @return message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Setter
	 *
	 * @param message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
