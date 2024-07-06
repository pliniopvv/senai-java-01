package br.pvv.senai.petshop.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PokemonExceptionAdvice {

	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<Void> trataIdInvalido(NumberFormatException exception) {
		return ResponseEntity.notFound().build();
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<String> trataEnumIvalido(HttpMessageNotReadableException exception) {
		return ResponseEntity.badRequest().body(exception.getMessage());
	}
}
