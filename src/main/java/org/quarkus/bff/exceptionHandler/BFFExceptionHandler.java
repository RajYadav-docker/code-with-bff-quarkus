package org.quarkus.bff.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class BFFExceptionHandler {
	
	@ExceptionHandler(UserIdNotFoundException.class)
	@ResponseStatus(value=HttpStatus.UNAUTHORIZED)
	public ExceptionResponse handleUserIdNotFound(UserIdNotFoundException userIdNotFoundException) {
		
		ExceptionResponse exceptionResponse=new ExceptionResponse();
		exceptionResponse.setStatus(400);
		exceptionResponse.setMessage(userIdNotFoundException.getMessage());
		return exceptionResponse;
		
	}
	
	@ExceptionHandler(MoviesDetailsNotFoundException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public ExceptionResponse handleMovieDetailsNotFound(MoviesDetailsNotFoundException moviesDetailsNotFoundException) {
		
		ExceptionResponse exceptionResponse=new ExceptionResponse();
		exceptionResponse.setStatus(400);
		exceptionResponse.setMessage(moviesDetailsNotFoundException.getMessage());
		return exceptionResponse;
		
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	public ExceptionResponse handleException(Exception exception) {
		
		ExceptionResponse exceptionResponse=new ExceptionResponse();
		exceptionResponse.setStatus(500);
		exceptionResponse.setMessage(exception.getMessage());
		return exceptionResponse;
		
	}
	
	
}
