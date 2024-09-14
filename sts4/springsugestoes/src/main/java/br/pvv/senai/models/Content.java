package br.pvv.senai.models;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity()
@Table(name = "tb_Content")
public class Content implements IEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@Column()
	@Schema(description = "Titulo da sugestão/comentário/reclamação", example = "Sugestão: Uma sugestão.", type = "String")
	private String titulo;
	@Column()
	@Schema(description = "Descrição da sugestão/comentário/reclamação", example = "Um comentário sobre a sugestão/comentário/reclamação", type = "String")
	private String descricao;
	@Column()
	@JsonFormat(pattern = "dd-MM-yyyy")
	@Schema(description = "Data de Envio do comentário (campo automático)", example = "15-08-2023", type = "date")
	private LocalDate dataEnvio;
	@Column()
	@JsonFormat(pattern = "dd-MM-yyyy")
	@Schema(description = "Data de atualização da sugestão (campo automático)", example = "15-08-2022", type = "date")
	private LocalDate dataAtualizacao;

	@OneToMany()
	private List<Comments> comments;

	public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(LocalDate dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public LocalDate getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDate dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

}
