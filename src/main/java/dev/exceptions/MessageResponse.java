package dev.exceptions;


public class MessageResponse extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7258038137879377481L;

	/** Constructeur
	 * @param message
	 */
	public MessageResponse(String message) {
		super(message);
	}
}
