package org.quarkus.bff.exceptionHandler;

public class UserIdNotFoundException extends Exception {

	private static final long serialVersionUID = 5362300776069049000L;

	public UserIdNotFoundException() {
		super();
	}

	public UserIdNotFoundException(String message) {
		super(message);
	}
	
	

}
