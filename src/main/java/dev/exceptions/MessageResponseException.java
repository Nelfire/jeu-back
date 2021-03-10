package dev.exceptions;

public class MessageResponseException extends RuntimeException {

	private static final long serialVersionUID = -7258038137879377481L;

	/**
	 * Constructeur
	 */
	public MessageResponseException(String message) {
		super(message);
	}
}
