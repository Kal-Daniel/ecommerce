package com.devdomain.ecommerce.controller.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devdomain.ecommerce.services.exceptions.DatabaseException;
import com.devdomain.ecommerce.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class CustomExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request) {
	  StandardError err = new StandardError();
	  err.setTimestamp(Instant.now());
	  err.setStatus(HttpStatus.NOT_FOUND.value());
	  err.setError("Resource not found.");
	  err.setMessage(e.getMessage());
	  err.setPath(request.getRequestURI());
	  return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
  }
  
  @ExceptionHandler(DatabaseException.class)
  public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request) {
	  StandardError err = new StandardError();
	  err.setTimestamp(Instant.now());
	  err.setStatus(HttpStatus.BAD_REQUEST.value());
	  err.setError("Database error");
	  err.setMessage(e.getMessage());
	  err.setPath(request.getRequestURI());
	  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
  }

}