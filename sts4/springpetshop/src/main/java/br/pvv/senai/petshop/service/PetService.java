package br.pvv.senai.petshop.service;

import org.springframework.stereotype.Service;

import br.pvv.senai.petshop.model.Pet;
import br.pvv.senai.petshop.repository.PetRepository;

@Service
public class PetService {

	PetRepository repository;

	PetService(PetRepository repository) {
		this.repository = repository;
	}

	public Pet save(Pet pet) {
		repository.list.add(pet);
		return pet;
	}

	public Pet get(int id) {
		return repository.list.get(id);
	}

	public Pet[] list() {
		return repository.list.toArray(new Pet[repository.list.size()]);
	}

	public boolean remove(int id) {
		repository.list.remove(id);
		return true;
	}

	public Pet update(int id, Pet pet) {
		repository.list.set(id, pet);
		return pet;
	}

}
