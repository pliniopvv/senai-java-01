package entidades;

//[M2S03] Ex. 02 - Sistema de Sa�de Parte 2 - Endere�o
public class Endereco {
	
	private String logradouro;
	private String Estado;
	private String Cidade;
	private int Numero;
	private int cep;
	
	public Endereco() {
		
	}
	
	public Endereco(String logradouro, String estado, String cidade, int numero, int cep) {
		super();
		this.logradouro = logradouro;
		Estado = estado;
		Cidade = cidade;
		Numero = numero;
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public String getCidade() {
		return Cidade;
	}

	public void setCidade(String cidade) {
		Cidade = cidade;
	}

	public int getNumero() {
		return Numero;
	}

	public void setNumero(int numero) {
		Numero = numero;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

}
