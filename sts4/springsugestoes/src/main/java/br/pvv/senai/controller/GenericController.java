package br.pvv.senai.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.pvv.senai.models.IEntity;
import br.pvv.senai.services.GenericService;

@Controller
@RestController
public abstract class GenericController<T extends IEntity> {

	private final Log logger = LogFactory.getLog(getClass());

	public abstract GenericService<T> getService();

	@GetMapping("{id}")
	public ResponseEntity<T> get(@PathVariable() int id) {
		logger.info("GET /" + id + " -> Rota acessada");
		return ResponseEntity.ok(getService().find(id));
	}

	@PostMapping()
	public ResponseEntity<T> post(@RequestBody() T model) {
		logger.info("POST / -> Rota acessada");
		logger.info(model);
		return ResponseEntity.ok(getService().save(model));
	}

	@PutMapping("{id}")
	public ResponseEntity<T> put(@PathVariable() int id,@RequestBody() T model) {
		logger.info("PUT /" + id + " -> Rota acessada");
		logger.info(model);
		model.setId(id);
		return ResponseEntity.ok(getService().update(model));
	}

	@DeleteMapping("{id}")
	public ResponseEntity delete(@PathVariable() int id) {
		logger.info("DELETE /" + id + " -> Rota acessada");
		var model = getService().find(id);
		getService().delete(model);
		return ResponseEntity.noContent().build();
	}

}
