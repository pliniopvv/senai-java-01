package br.pvv.senai.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvicer {

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<Void> trataIdInvalido(NullPointerException exception) {
		return ResponseEntity.notFound().build();
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<Void> trataIdInvalido(NumberFormatException exception) {
		return ResponseEntity.notFound().build();
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<String> trataEnumIvalido(HttpMessageNotReadableException exception) {
		return ResponseEntity.badRequest().body(exception.getMessage());
	}
	
}
