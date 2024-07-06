package br.pvv.senai.petshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pvv.senai.petshop.dto.CapturedPokemonDTO;
import br.pvv.senai.petshop.dto.SeenPokemonDTO;
import br.pvv.senai.petshop.model.Pokemon;
import br.pvv.senai.petshop.repository.PokemonSummary;
import br.pvv.senai.petshop.service.PokemonService;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

	@Autowired
	private PokemonService service;

	@PostMapping("/seen")
	public Pokemon seenPokemon(@RequestBody SeenPokemonDTO model) {
		return service.seen(model);
	}

	@PostMapping("/captured")
	public Pokemon captured(@RequestBody CapturedPokemonDTO model) {
		return service.captured(model);
	}

	@PutMapping("/{id}")
	public Pokemon update(@PathVariable int id, @RequestBody Pokemon model) {
		model.setId(id);
		return service.update(model);
	}

	@DeleteMapping("/{id}")
	public Pokemon delete(@PathVariable int id) {
		return service.delete(id);
	}

	@GetMapping("/byNumber/{id}")
	public Pokemon get(@PathVariable int id) {
		return service.findByNumero(id);
	}

	@GetMapping
	public List<PokemonSummary> list() {
		return service.list();
	}
}
