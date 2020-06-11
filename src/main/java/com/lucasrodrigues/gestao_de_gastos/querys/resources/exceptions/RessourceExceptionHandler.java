package com.lucasrodrigues.gestao_de_gastos.querys.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lucasrodrigues.gestao_de_gastos.querys.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class RessourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class) //interceptar a requisição que gerou a excessao
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.ok().body(err);
	}
	
	
}
