package br.pvv.senai.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.pvv.senai.model.IEntity;
import br.pvv.senai.service.GenericService;

public abstract class GenericController<T extends IEntity> {

	public abstract GenericService<T> getService();

	@GetMapping("{id}")
	public ResponseEntity<T> get(long id) {
		Optional<T> model = getService().load(id);
		if (model.isEmpty()) return ResponseEntity.notFound().build();
		else return ResponseEntity.ok(model.get());
	}

	@PostMapping
	public T post(@RequestBody T model) {
		return getService().save(model);
	}

	@PutMapping("{id}")
	public T put(long id, @RequestBody T model) {
		model.setId(id);
		return getService().alter(model)id;
	}

	@DeleteMapping("{id}")
	public ResponseEntity del(long id) {
		Optional<T> model = getService().load(id);
		if (model.isPresent()) getService().delete(model);
		return ResponseEntity.noContent().build();
	}
}
