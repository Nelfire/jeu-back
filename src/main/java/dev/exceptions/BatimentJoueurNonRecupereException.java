package dev.exceptions;


public class BatimentJoueurNonRecupereException extends RuntimeException{

	/** Constructeur
	 * @param message
	 */
	public BatimentJoueurNonRecupereException(String message) {
		super(message);
	}
}
