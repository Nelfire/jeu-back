package dev.exceptions;


public class JoueurAuthentifieNonRecupereException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4356628397039516037L;

	/** Constructeur
	 * @param message
	 */
	public JoueurAuthentifieNonRecupereException(String message) {
		super(message);
	}
}
