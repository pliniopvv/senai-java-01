package br.com.exemplo.aula.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "consulta")
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	// @JoinColumn(name = "id_nutricionista") OPCIONAL ISSO AQUI.
	private Nutricionista nutricionista;

	@ManyToOne
	@JoinColumn(name = "id_paciente")
	private Paciente paciente;

	private LocalDate data;
	private String observacoes;

	public Consulta() {
		super();
	}

	public Consulta(Long id, Nutricionista nutricionista, Paciente paciente, LocalDate data, String observacoes) {
		super();
		this.id = id;
		this.nutricionista = nutricionista;
		this.paciente = paciente;
		this.data = data;
		this.observacoes = observacoes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
}
