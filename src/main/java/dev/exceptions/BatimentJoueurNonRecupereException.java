package dev.exceptions;


public class BatimentJoueurNonRecupereException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7258038137879377481L;

	/** Constructeur
	 * @param message
	 */
	public BatimentJoueurNonRecupereException(String message) {
		super(message);
	}
}
