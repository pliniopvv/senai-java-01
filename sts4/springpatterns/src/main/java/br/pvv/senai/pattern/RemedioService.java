package br.pvv.senai.pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemedioService {

	@Autowired
	private RemedioRepository remedioRepository;
	@Autowired
	private EstoqueRepository estoqueRepository;

	public void saveRemedio(String nome, Integer dosagemEmMg) {
		// Salvar o remédio quando não encontrarmos
		Remedio remedio = new Remedio();
		remedio.setNome(nome);
		remedio.dosagemMg(dosagemEmMg);

		this.check(nome, dosagemEmMg);

		remedioRepository.save(remedio);
	}

	public void addEstoque(Integer idR, Integer quantidade, String nomeR, Integer remedioDosagemMg) {
		// Se existe remedio eu adiciono o estoque
		if (remedioRepository.existe(idR)) {
			Remedio r = remedioRepository.getRemedioPorId(idR);

			Estoque eAtual = estoqueRepository.getEstoqueAtual(idR);

			if (eAtual == null) {
				// Cria um novo estoque quando não encontrou
				Estoque estoque = new Estoque();
				estoque.setIdRemedio(r.getId());
				estoque.setQuantidade(quantidade);

				if (quantidade < 0) {
					throw new EstoqueNegativeException();
				}

				estoqueRepository.save(estoque);
			} else {
				if (quantidade < 0) {
					throw new EstoqueNegativeException();
				}

				eAtual.setQuantidade(eAtual.getQuantidade() + quantidade);
				estoqueRepository.save(eAtual);
			}

		} else if (remedioRepository.existePorNome(nomeR)) {
			Remedio r = remedioRepository.getRemedioPorNome(nomeR);

			Estoque eAtual = estoqueRepository.getEstoqueAtual(r.getId());

			if (eAtual == null) {
				if (quantidade < 0) {
					throw new EstoqueNegativeException();
				}

				Estoque estoque = new Estoque();
				estoque.setQuantidade(quantidade);
				estoque.setIdRemedio(r.getId());

				estoqueRepository.save(estoque);
			} else {
				if (quantidade < 0) {
					throw new EstoqueNegativeException();
				}

				eAtual.setQuantidade(eAtual.getQuantidade() + quantidade);
				estoqueRepository.save(eAtual);
			}

		} else {
			// Salvar o remédio quando não encontrarmos
			Remedio r = new Remedio();
			r.setNome(nomeR);
			r.dosagemMg(remedioDosagemMg);

			this.check(nomeR, remedioDosagemMg);

			Integer id = remedioRepository.save(r);

			// Adicionar no estoque novo
			Estoque estoque = new Estoque();
			estoque.setIdRemedio(id);
			estoque.setQuantidade(quantidade);

			if (quantidade < 0) {
				throw new EstoqueNegativeException();
			}

			estoqueRepository.save(estoque);
		}

	}
	
	public void check(String nomeR, Integer remedioDosagemMg) {
		if (nomeR == null || nomeR.isEmpty() || nomeR.trim().isEmpty()) {
			throw new NomeNullException();
		} else if (remedioDosagemMg == null || remedioDosagemMg < 0) {
			if (remedioDosagemMg == null) {
				throw new DosagemNullException();
			} else if (remedioDosagemMg < 0) {
				throw new DosagemNegativeException();
			}
		}
	}

	public class EstoqueNegativeException extends Exception {
		public EstoqueNegativeException() {
			this.printStackTrace();
			System.out.println("Quantidade adicionada no estoque não pode ser negativa");
		}
	}

	public class NomeNullException extends Exception {
		public NomeNullException() {
			this.printStackTrace();
			System.out.println("Nome do remédio não pode ser vazio");
		}
	}

	public class DosagemNegativeException extends Exception {
		public DosagemNegativeException() {
			this.printStackTrace();
			System.out.println("Dosagem não pode ser negativa");
		}
	}

	public class DosagemNullException extends Exception {
		public DosagemNullException() {
			this.printStackTrace();
			System.out.println("Remédio precisa possuir dosagem");
		}
	}
}