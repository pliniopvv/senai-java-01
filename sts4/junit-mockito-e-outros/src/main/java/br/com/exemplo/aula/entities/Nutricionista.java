package br.com.exemplo.aula.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "nutricionista")
public class Nutricionista {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_nutricionista")
	private Long id;

	@Column(nullable = false)
	private String nome;

	private String matricula;
	private int tempoExperiencia;

	@Column(nullable = false)
	private String crn;

	private String especialidade;

	@ElementCollection
	private Set<String> certificacoes = new HashSet<>();

	public Nutricionista() {
		super();
	}

	public Nutricionista(Long id, String nome, String matricula, int tempoExperiencia, String crn, String especialidade,
			Set<String> certificacoes) {
		super();
		this.id = id;
		this.nome = nome;
		this.matricula = matricula;
		this.tempoExperiencia = tempoExperiencia;
		this.crn = crn;
		this.especialidade = especialidade;
		this.certificacoes = certificacoes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getTempoExperiencia() {
		return tempoExperiencia;
	}

	public void setTempoExperiencia(int tempoExperiencia) {
		this.tempoExperiencia = tempoExperiencia;
	}

	public String getCrn() {
		return crn;
	}

	public void setCrn(String crn) {
		this.crn = crn;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public Set<String> getCertificacoes() {
		return certificacoes;
	}

	public void setCertificacoes(Set<String> certificacoes) {
		this.certificacoes = certificacoes;
	}
}
