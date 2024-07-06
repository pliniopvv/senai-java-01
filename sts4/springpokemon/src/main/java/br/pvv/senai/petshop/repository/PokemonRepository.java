package br.pvv.senai.petshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.pvv.senai.petshop.model.Pokemon;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {

	public Pokemon findByNumero(int id);

//	public List<IPokemonListable> getPokemon();
}
