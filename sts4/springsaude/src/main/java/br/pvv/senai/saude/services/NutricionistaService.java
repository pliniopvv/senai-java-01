package br.pvv.senai.saude.services;

import java.util.Optional;

import br.pvv.senai.saude.model.Nutricionista;

public class NutricionistaService extends GenericService<Nutricionista> {

	public Nutricionista upXP(long id) {
		Optional<Nutricionista> n = repository.findById(id);
		if (n.isPresent()) {
			Nutricionista nutri = n.get();
			int xp = nutri.getXp();
			xp++;
			nutri.setXp(xp);
			return repository.save(nutri);
		}
		return null;
	}

	public Nutricionista addCert(long id, String certification) {
		Optional<Nutricionista> n = repository.findById(id);
		if (n.isPresent()) {
			Nutricionista nutri = n.get();
			String esp = nutri.getEspecialidade();
			esp += certification;
			nutri.setEspecialidade(esp);
			return repository.save(nutri);
		}
		return null;
	}

}
