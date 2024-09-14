package br.pvv.senai.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity()
@Table(name = "tb_Comments")
public class Comments implements IEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@Column()
	private int contentId;
	@Column()
	private String texto;
	@Column()
	private LocalDate dateEnvio;
	
	@ManyToOne()
	private Content content;
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getSugestaoId() {
		return contentId;
	}

	public void setSugestaoId(int sugestaoId) {
		this.contentId = sugestaoId;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDate getDateEnvio() {
		return dateEnvio;
	}

	public void setDateEnvio(LocalDate dateEnvio) {
		this.dateEnvio = dateEnvio;
	}

}
