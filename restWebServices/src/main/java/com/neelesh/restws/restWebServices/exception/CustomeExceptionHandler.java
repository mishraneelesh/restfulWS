package com.neelesh.restws.restWebServices.exception;



import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.neelesh.restws.restWebServices.user.UserNotFoundException;

@RestControllerAdvice
@RestController
public class CustomeExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		ExceptionBean bean = new ExceptionBean(new Date(),ex.getMessage(),request.getDescription(false));
		
		 return new ResponseEntity(bean,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserException(UserNotFoundException ex, WebRequest request) throws Exception {
		ExceptionBean bean = new ExceptionBean(new Date(),ex.getMessage(),request.getDescription(false));
		
		 return new ResponseEntity(bean,HttpStatus.NOT_FOUND);
		
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionBean bean = new ExceptionBean(new Date(),"Input Validation failed",ex.getBindingResult().toString());
		return new ResponseEntity(bean,HttpStatus.BAD_REQUEST);
	}
	
}
