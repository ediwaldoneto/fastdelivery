package br.com.ediwaldoneto.fastdelivery.infrastructure.exception;

public class DuplicateEmailException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateEmailException() {
		super();
	}

	public DuplicateEmailException(String message) {
		super(message);
	}

}
