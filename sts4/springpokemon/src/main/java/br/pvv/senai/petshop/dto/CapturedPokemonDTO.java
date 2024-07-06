package br.pvv.senai.petshop.dto;

import br.pvv.senai.petshop.common.Categoria;
import br.pvv.senai.petshop.common.Habitat;
import br.pvv.senai.petshop.common.Type;

public class CapturedPokemonDTO {
	private int numero;
	private String nome;
	private String descricao;
	private String imagem;
	private Type tipo;
	private Categoria categoria;
	private Habitat areaQueHabita;
	private int altura;
	private int peso;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Type getTipo() {
		return tipo;
	}

	public void setTipo(Type tipo) {
		this.tipo = tipo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Habitat getAreaQueHabita() {
		return areaQueHabita;
	}

	public void setAreaQueHabita(Habitat areaQueHabita) {
		this.areaQueHabita = areaQueHabita;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

}
