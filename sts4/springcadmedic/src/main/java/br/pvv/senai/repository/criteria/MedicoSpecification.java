package br.pvv.senai.repository.criteria;

import java.time.LocalDate;

import org.springframework.data.jpa.domain.Specification;

import br.pvv.senai.common.Especialidade;
import br.pvv.senai.model.Medico;

public class MedicoSpecification {
	public static Specification<Medico> hasNome(String nome) {
		return (root, query, builder) -> {
			return builder.like(root.get("nome"), nome);
		};
	}
	
	public static Specification<Medico> hasEspecialidade(Especialidade esp) {
		return (root,query,builder) -> {
			return builder.equal(root.get("especialidade"), esp);
		};
	}

	public static Specification<Medico> hasDataNascimento(LocalDate date) {
		return (root,query,builder) -> {
			return builder.equal(root.get("dataNascimento"), date);
		};
	}

}
