package br.pvv.senai.tutorshop.service;

import org.springframework.stereotype.Service;

import br.pvv.senai.petshop.model.Tutor;
import br.pvv.senai.petshop.repository.TutorRepository;

@Service
public class TutorService {

	TutorRepository repository;

	TutorService(TutorRepository repository) {
		this.repository = repository;
	}

	public Tutor save(Tutor tutor) {
		repository.list.add(tutor);
		return tutor;
	}

	public Tutor get(int id) {
		return repository.list.get(id);
	}

	public Tutor[] list() {
		return repository.list.toArray(new Tutor[repository.list.size()]);
	}

	public boolean remove(int id) {
		repository.list.remove(id);
		return true;
	}

	public Tutor update(int id, Tutor tutor) {
		repository.list.set(id, tutor);
		return tutor;
	}
}
