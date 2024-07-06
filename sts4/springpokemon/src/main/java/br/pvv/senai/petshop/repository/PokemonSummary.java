package br.pvv.senai.petshop.repository;

public class PokemonSummary {
	private int numero;
	private String nome;
	private boolean captured;

	public PokemonSummary() {

	}

	public PokemonSummary(int numero, String nome, boolean captured) {
		super();
		this.numero = numero;
		this.nome = nome;
		this.captured = captured;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isCaptured() {
		return captured;
	}

	public void setCaptured(boolean captured) {
		this.captured = captured;
	}

}
