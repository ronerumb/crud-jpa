package com.drugstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ClientNotFoundException.class)
	public ResponseEntity<MessageException> clientNotFound(HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;		
		MessageException err = new MessageException(System.currentTimeMillis(), status.value(), "Not Found 404", request.getPathInfo());
		return ResponseEntity.status(status).body(err);
	}

}
