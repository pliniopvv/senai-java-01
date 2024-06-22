package br.pvv.senai.petshop.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pvv.senai.petshop.model.Pet;
import br.pvv.senai.petshop.service.PetService;

@RestController
@RequestMapping("/pets")
public class Pets {

	PetService service;

	Pets(PetService service) {
		this.service = service;
	}

	@PostMapping
	public Pet doCreate(@RequestBody Pet pet) {
		return this.service.save(pet);
	}

	@GetMapping
	public String doRead() {
		Pet[] list = service.list();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.length; i++)
			sb.append(i + " - " + list[i].toString() + "\n");

		return sb.toString();
	}

	@PutMapping("/{id}")
	public Pet doUpdate(@PathVariable int id, @RequestBody Pet pet) {
		service.update(id, pet);
		return pet;
	}

	@DeleteMapping("/{id}")
	public boolean doDelete(@PathVariable int id) {
		service.remove(id);
		return true;
	}

}
