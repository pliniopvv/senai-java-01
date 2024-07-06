package br.pvv.senai.petshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pvv.senai.petshop.dto.CapturedPokemonDTO;
import br.pvv.senai.petshop.dto.SeenPokemonDTO;
import br.pvv.senai.petshop.model.Pokemon;
import br.pvv.senai.petshop.repository.PokemonRepository;

@Service
public class PokemonService {

	@Autowired
	private PokemonRepository repository;

	public Pokemon seen(SeenPokemonDTO model) {

		Pokemon p = new Pokemon();
		p.setNumero(model.getNumero());
		p.setNome(model.getNome());
//		p.setDescricao(model.getDescricao());
		p.setImagem(model.getImagem());
//		p.setTipo(model.getTipo());
//		p.setCategoria(model.getCategoria());
//		p.setAreaQueAbita(model.getAreaQueAbita());
//		p.setAltura(model.getAltura());
//		p.setPeso(model.getPeso());
		p.setCaptured(false);

		return repository.save(p);
	}

	public Pokemon captured(CapturedPokemonDTO model) {

		Pokemon p = new Pokemon();
		p.setNumero(model.getNumero());
		p.setNome(model.getNome());
		p.setDescricao(model.getDescricao());
		p.setImagem(model.getImagem());
		p.setTipo(model.getTipo());
		p.setCategoria(model.getCategoria());
		p.setAreaQueHabita(model.getAreaQueHabita());
		p.setAltura(model.getAltura());
		p.setPeso(model.getPeso());
		p.setCaptured(true);

		return repository.save(p);
	}

	public Pokemon update(Pokemon model) {
		return repository.save(model);
	}
}
