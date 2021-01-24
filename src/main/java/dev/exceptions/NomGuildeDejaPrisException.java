package dev.exceptions;


public class NomGuildeDejaPrisException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2923983032670806791L;

	/** Constructeur
	 * @param message
	 */
	public NomGuildeDejaPrisException(String message) {
		super(message);
	}
}
