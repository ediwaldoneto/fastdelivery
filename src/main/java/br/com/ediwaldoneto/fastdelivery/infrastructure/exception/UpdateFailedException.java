package br.com.ediwaldoneto.fastdelivery.infrastructure.exception;

public class UpdateFailedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 619109794846571589L;

	public UpdateFailedException(String message) {
		super(message);
	}

}
