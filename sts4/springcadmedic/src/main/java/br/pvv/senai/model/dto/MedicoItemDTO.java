package br.pvv.senai.model.dto;

import java.time.LocalDate;

import br.pvv.senai.common.Especialidade;

public class MedicoItemDTO {
	private String nome;
	private Especialidade especialidade;
	private LocalDate dataNascimento;

	public MedicoItemDTO(String nome, Especialidade especialidade, LocalDate dataNascimento) {
		super();
		this.nome = nome;
		this.especialidade = especialidade;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
