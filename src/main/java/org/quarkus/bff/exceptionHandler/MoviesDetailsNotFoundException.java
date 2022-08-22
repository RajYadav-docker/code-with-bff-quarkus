package org.quarkus.bff.exceptionHandler;

public class MoviesDetailsNotFoundException extends Exception {

	private static final long serialVersionUID = 8786974768423451512L;

	public MoviesDetailsNotFoundException() {
		super();
	}

	public MoviesDetailsNotFoundException(String message) {
		super(message);
	}
	
	

}
