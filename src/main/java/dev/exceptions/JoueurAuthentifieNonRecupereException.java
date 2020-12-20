package dev.exceptions;


public class JoueurAuthentifieNonRecupereException extends RuntimeException{

	/** Constructeur
	 * @param message
	 */
	public JoueurAuthentifieNonRecupereException(String message) {
		super(message);
	}
}
