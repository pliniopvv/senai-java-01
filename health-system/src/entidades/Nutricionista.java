package entidades;

import java.util.ArrayList;
import java.util.List;

//[M2S03] Ex. 04 - Sistema de Saúde Parte 2 - Nutricionista
public class Nutricionista extends Funcionario {

	private List<String> certificacoes;
	private int numero_de_consultas;
	private int tempo_de_experiencia;
	
	private static List<Nutricionista> list = new ArrayList<>();

	public Nutricionista() {
		super();
		list.add(this);
	}

	public Nutricionista(List<String> certificacoes, int numero_de_consultas, int tempo_de_experiencia) {
		super();
		list.add(this);
		this.certificacoes = certificacoes;
		this.numero_de_consultas = numero_de_consultas;
		this.tempo_de_experiencia = tempo_de_experiencia;
	}

	@Override
	public void setNome(String nome) {
		Funcionario[] list = this.listar();

		try {
			for (Funcionario f : list)
				if (f.getNome().equals(nome))
					throw new Exception("Nome já existente!");
			super.setNome(nome);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static Nutricionista[] getList() {
		Nutricionista[] array = list.toArray(new Nutricionista[list.size()]);
		return array;
	}

	public List<String> getCertificacoes() {
		return certificacoes;
	}

	public void setCertificacoes(List<String> certificacoes) {
		this.certificacoes = certificacoes;
	}

	public int getNumero_de_consultas() {
		return numero_de_consultas;
	}

	public void setNumero_de_consultas(int numero_de_consultas) {
		this.numero_de_consultas = numero_de_consultas;
	}

	public int getTempo_de_experiencia() {
		return tempo_de_experiencia;
	}

	public void setTempo_de_experiencia(int tempo_de_experiencia) {
		this.tempo_de_experiencia = tempo_de_experiencia;
	}

//	[M2S03] Ex. 05 - Sistema de Saúde Parte 2 - Métodos do Nutricionista
	public void aumentarExperiencia() {
		this.tempo_de_experiencia++;
	}

	public void addCertificado(String certificado) {
		this.certificacoes.add(certificado);
	}

}
