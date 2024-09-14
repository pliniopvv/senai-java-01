package br.pvv.senai.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity()
@Table(name = "tb_Comments")
public class Comments implements ICollection {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@Column()
	@Schema(description = "Texto do comentário", example = "Um texto sobre a sugestão/comentário/reclamação", type = "String")
	private String texto;
	@Column()
	@JsonFormat(pattern = "dd-MM-yyyy")
	@Schema(description = "Data de envio do comentário na sugestão (campo automático)", example = "15-08-2022", type = "date")
	private LocalDate dateEnvio;

	@ManyToOne()
	private Content content;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
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

	@Override
	public int getIdParent() {
		return content.getId();
	}

	@Override
	public void setIdParent(int id) {
		content.setId(id);
	}

}
