package br.pvv.senai.saude.dto.response;

import java.util.Date;

import br.pvv.senai.saude.model.Nutricionista;
import br.pvv.senai.saude.model.Paciente;

public class ConsultaResponseDTO {

	private long id;
	private Nutricionista nutricionista;
	private Paciente paciente;
	private Date data;
	private String observacao;

	public Nutricionista getNutricionista() {
		return nutricionista;
	}

	public void setNutricionista(Nutricionista nutricionista) {
		this.nutricionista = nutricionista;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}
}
