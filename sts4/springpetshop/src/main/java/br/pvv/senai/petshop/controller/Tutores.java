package br.pvv.senai.petshop.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pvv.senai.petshop.model.Tutor;
import br.pvv.senai.petshop.service.TutorService;

@RestController
@RequestMapping("/tutores")
public class Tutores {

	TutorService service;
	
	Tutores(TutorService service) {
		this.service = service;
	}

	@PostMapping
	public Tutor doCreate(@RequestBody Tutor tutor) {
		return service.save(tutor);
	}

	@GetMapping
	public String doRead() {
		Tutor[] list = service.list();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.length; i++)
			sb.append(i + " - " + list[i].toString() + "\n");

		return sb.toString();
	}

	@PutMapping("/{id}")
	public Tutor doUpdate(@PathVariable int id, @RequestBody Tutor tutor) {
		service.update(id, tutor);
		return tutor;
	}

	@DeleteMapping("/{id}")
	public boolean doDelete(@PathVariable int id) {
		service.remove(id);
		return true;
	}
}
