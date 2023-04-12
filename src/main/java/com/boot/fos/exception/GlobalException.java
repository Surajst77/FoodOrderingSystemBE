package com.boot.fos.exception;

import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalException extends RuntimeException{
	
	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<APIResponse> resourceNotFoundException(ResourceNotFound ex)
	{
		String message = ex.getMessage();
		APIResponse response = new APIResponse();
		response.setMessage(message);
		response.setStatus(false);
		
		return new ResponseEntity<APIResponse>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Set<String>> constraintViolations(ConstraintViolationException ex)
	{
		Set<String> errorList = ex.getConstraintViolations().stream().map(error->error.getMessage()).collect(Collectors.toSet());
		return new ResponseEntity<Set<String>>(errorList, HttpStatus.BAD_REQUEST);
	}
}
