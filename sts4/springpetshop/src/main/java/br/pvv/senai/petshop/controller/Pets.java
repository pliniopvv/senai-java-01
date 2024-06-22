package br.pvv.senai.petshop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.pvv.senai.petshop.model.Pet;

@RestController
@RequestMapping("/pets")
public class Pets {

	private static List<Pet> list = new ArrayList<Pet>();

	@PostMapping
	public Pet doCreate(@RequestBody Pet pet) {
		list.add(pet);
		return pet;
	}

	@GetMapping
	public String doRead() {

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++)
			sb.append(i + " - " + list.get(i).toString() + "\n");

		return sb.toString();
	}

	@PutMapping("/{id}")
	public Pet doUpdate(@PathVariable int id, @RequestBody Pet pet) {
		list.set(id, pet);
		return pet;
	}

	@DeleteMapping("/{id}")
	public boolean doDelete(@PathVariable int id) {
		list.remove(id);
		return true;
	}

}
