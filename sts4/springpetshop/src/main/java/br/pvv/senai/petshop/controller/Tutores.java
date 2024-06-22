package br.pvv.senai.petshop.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tutores")
public class Tutores {
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
