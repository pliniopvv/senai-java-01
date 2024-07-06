package br.pvv.senai.petshop.dto;

import br.pvv.senai.petshop.common.Habitat;

public class SeenPokemonDTO {
	private int numero;
	private String nome;
	private String imagem;
	private Habitat areaQueHabita;

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

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Habitat getAreaQueHabita() {
		return areaQueHabita;
	}

	public void setAreaQueHabita(Habitat areaQueHabita) {
		this.areaQueHabita = areaQueHabita;
	}

}
