package br.pvv.senai.model.dto;

import java.time.LocalDate;

import br.pvv.senai.common.Especialidade;
import br.pvv.senai.model.IEntity;
import br.pvv.senai.model.Medico;

public class MedicoDTO extends GenericDTO<Medico> implements IEntity {
	public long id;
	public String nome;
	public String crm;
	public LocalDate dataNascimento;
	public String telefone;
	public Especialidade especialidade;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

}
