package org.cityapp.exceptions;

public class DatabaseException extends Exception {

	private static final long serialVersionUID = 1L;

	public DatabaseException(String message, Exception exception) {
		super(message, exception);
	}

	public DatabaseException(String message) {
		super(message);
	}

	public DatabaseException(Exception exception) {
		super(exception);
	}

}