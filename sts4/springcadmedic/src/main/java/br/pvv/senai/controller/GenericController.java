package br.pvv.senai.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.pvv.senai.model.IEntity;
import br.pvv.senai.service.GenericService;

@RestController
public abstract class GenericController<T extends IEntity> {

	public abstract GenericService<T> getService();

	@GetMapping
	public List<T> get() {
		return getService().all();
	}

	@GetMapping("/paged/{pageSize}/{pageNumber}")
	public Page<T> paged(@PathVariable int pageNumber, @PathVariable int pageSize) {
		return getService().paged(PageRequest.of(pageNumber, pageSize));
	}

	@GetMapping("{id}")
	public ResponseEntity<T> get(@PathVariable long id) {
		Optional<T> model = getService().load(id);
		if (model.isEmpty())
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(model.get());
	}

	@PostMapping
	public T post(@RequestBody T model) {
		return getService().save(model);
	}

	@PutMapping("{id}")
	public T put(@PathVariable long id, @RequestBody T model) {
		model.setId(id);
		return getService().alter(model);
	}

	@DeleteMapping("{id}")
	public ResponseEntity del(@PathVariable long id) {
		Optional<T> model = getService().load(id);
		if (model.isPresent())
			getService().delete(model.get());
		return ResponseEntity.noContent().build();
	}
}
