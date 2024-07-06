package br.pvv.senai.petshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pvv.senai.petshop.dto.CapturedPokemonDTO;
import br.pvv.senai.petshop.dto.SeenPokemonDTO;
import br.pvv.senai.petshop.model.Pokemon;
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
}
