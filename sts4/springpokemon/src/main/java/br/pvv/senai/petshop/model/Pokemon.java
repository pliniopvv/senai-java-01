package br.pvv.senai.petshop.model;

import br.pvv.senai.petshop.common.Categoria;
import br.pvv.senai.petshop.common.Habitat;
import br.pvv.senai.petshop.common.Type;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pokemon implements IEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private int numero;
	@Column
	private String nome;
	@Column
	private String descricao;
	@Column
	private String imagem;
	@Column
	private Type tipo;
	@Column
	private Categoria categoria;
	@Column
	private Habitat areaQueHabita;
	@Column
	private double altura;
	@Column
	private double peso;
	@Column
	private boolean captured;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public boolean isCaptured() {
		return captured;
	}

	public void setCaptured(boolean captured) {
		this.captured = captured;
	}
}
