package com.drugstore.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ClientNotFoundException.class)
	public ResponseEntity<MessageException> clientNotFound(ClientNotFoundException msg){
		HttpStatus status = HttpStatus.NOT_FOUND;		
		MessageException err = new MessageException(System.currentTimeMillis(), status.value(), msg.getMessage());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MessageException> methodArgumentNotValid(MethodArgumentNotValidException e){
		  Map<String, String> errors = new HashMap<>();
		    
	       e.getBindingResult().getFieldErrors().forEach(error -> 
	           errors.put(error.getField(), error.getDefaultMessage()));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageException(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), errors.toString()));
		
	}

}
