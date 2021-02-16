package dev.exceptions;


public class MessageResponseException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7258038137879377481L;

	/** Constructeur
	 * @param message
	 */
	public MessageResponseException(String message) {
		super(message);
	}
}
