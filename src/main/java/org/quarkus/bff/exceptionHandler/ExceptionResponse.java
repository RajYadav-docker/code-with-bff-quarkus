package org.quarkus.bff.exceptionHandler;

import java.io.Serializable;

public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = -7710469340359312473L;
	
	private int status;
	private String message;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
