package br.pvv.senai.petshop.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.pvv.senai.petshop.model.Pet;

@Repository
public class PetRepository {
	public List<Pet> list = new ArrayList<Pet>();
}
