package br.pvv.senai.petshop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pvv.senai.petshop.model.Tutor;

@RestController
@RequestMapping("/tutores")
public class Tutores {

	List<Tutor> list = new ArrayList<Tutor>();

	@PostMapping
	public Tutor doCreate(@RequestBody Tutor tutor) {
		list.add(tutor);
		return tutor;
	}

	@GetMapping
	public String doRead() {

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++)
			sb.append(i + " - " + list.get(i).toString() + "\n");

		return sb.toString();
	}

	@PutMapping("/{id}")
	public Tutor doUpdate(@PathVariable int id, @RequestBody Tutor tutor) {
		list.set(id, tutor);
		return tutor;
	}

	@DeleteMapping("/{id}")
	public boolean doDelete(@PathVariable int id) {
		list.remove(id);
		return true;
	}
}
