package br.pvv.senai.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.pvv.senai.petshop.model.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
	
	public Pokemon findByNumero(int id);

}
