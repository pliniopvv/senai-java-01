package br.pvv.senai.pattern;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

	@Autowired
	private UnimedService unimedService;
	@Autowired
	private BradescoService bradescoService;
	@Autowired
	private SusService susService;
	@Autowired
	private BacenService bacenService;

	private Map<FormaPagamento, PagamentoProcessador> map = new HashMap<>();
	private Map<FormaPagamento, PaymentService> mapService = new HashMap<>();

	public PagamentoService() {
		this.map.put(FormaPagamento.CONVENIO_UNIMED, new PagamentoConvUnimed());
		this.map.put(FormaPagamento.CONVENIO_BRADESCO, new PagamentoConvBradesco());
		this.map.put(FormaPagamento.SUS, new PagamentoSus());
		this.map.put(FormaPagamento.PIX, new PagamentoPix());

		this.mapService.put(FormaPagamento.CONVENIO_UNIMED, unimedService);
		this.mapService.put(FormaPagamento.CONVENIO_BRADESCO, bradescoService);
		this.mapService.put(FormaPagamento.SUS, susService);
		this.mapService.put(FormaPagamento.PIX, bacenService);
	}

	public void processaPagamento(PessoaPaciente paciente, FormaPagamento formaPagamento,
			InformacoesPagamento informacoesPagamento, Float valor) {
		this.map.get(formaPagamento).Processar(paciente, informacoesPagamento, this.mapService.get(formaPagamento));
	}

	public interface PagamentoProcessador {
		public void Processar(PessoaPaciente paciente, InformacoesPagamento informacoesPagamento,
				PaymentService service);
	}

	public interface PaymentService {
		public void Pagar(PessoaPaciente paciente, InformacoesPagamento informacoesPagamento);
	}

	public enum FormaPagamento {
		CONVENIO_UNIMED, CONVENIO_BRADESCO, SUS, PIX
	}

	public class PagamentoConvUnimed implements PagamentoProcessador {

		@Override
		public void Processar(PessoaPaciente paciente, InformacoesPagamento informacoesPagamento,
				PaymentService service) {
			if (paciente.getNumeroConvenio() == null || paciente.getCpf() == null) {
				throw new RegraDeNegocionException(
						"Informações obrigatórias nao preenchidas. Preencha Numero de Convenio e CPF.");
			}
			service.Pagar(paciente, informacoesPagamento);

		}
	}

	public class PagamentoConvBradesco implements PagamentoProcessador {

		@Override
		public void Processar(PessoaPaciente paciente, InformacoesPagamento informacoesPagamento,
				PaymentService service) {
			if (paciente.getCpf() == null) {
				throw new RegraDeNegocionException("Informaão obrigatórias nao preenchidas. Preencha o CPF.");
			}
			service.Pagar(paciente, informacoesPagamento);
		}
	}

	public class PagamentoSus implements PagamentoProcessador {

		@Override
		public void Processar(PessoaPaciente paciente, InformacoesPagamento informacoesPagamento,
				PaymentService service) {
			if (paciente.getCpf() == null || paciente.getNumeroPis() == null) {
				throw new RegraDeNegocionException(
						"Informações obrigatórias nao preenchidas. Preencha Numero do PIS e CPF.");
			}
			service.Pagar(paciente, informacoesPagamento);
		}
	}

	public class PagamentoPix implements PagamentoProcessador {

		@Override
		public void Processar(PessoaPaciente paciente, InformacoesPagamento informacoesPagamento,
				PaymentService service) {
			service.Pagar(paciente, informacoesPagamento);
		}
	}
}