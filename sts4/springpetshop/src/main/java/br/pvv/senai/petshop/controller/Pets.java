package br.pvv.senai.petshop.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

@RestController
@RequestMapping("/pets")
public class Pets {

	@PostMapping
	public String doCreate() {
		return "Create";
	}

	@GetMapping
	public String doRead() {
		return "Read";
	}

	@PutMapping
	public String doUpdate() {
		return "Update";
	}

	@DeleteMapping
	public String doDelete() {
		return "Delete";
	}

}
