package dev.exceptions;

public class RessourceManquanteException extends RuntimeException {

	private static final long serialVersionUID = 1276918323780406502L;

	/**
	 * Constructeur
	 */
	public RessourceManquanteException(String message) {
		super(message);
	}
}
