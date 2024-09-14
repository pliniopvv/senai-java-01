package br.pvv.senai.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.pvv.senai.common.Especialidade;
import br.pvv.senai.model.Medico;
import br.pvv.senai.model.dto.MedicoItemDTO;
import br.pvv.senai.repository.MedicoDAO;
import br.pvv.senai.service.GenericService;
import br.pvv.senai.service.MedicoService;

@RestController
@RequestMapping("/medico")
public class MedicoController extends GenericController<Medico> {

	@Autowired
	private MedicoService service;
	
	@Autowired
	private MedicoDAO medicDao;

	@Override
	public GenericService<Medico> getService() {
		return service;
	}

	@GetMapping("/paged/{pageSize}/{pageNumber}/filter")
	public List<MedicoItemDTO> paged(@PathVariable int pageNumber, @PathVariable int pageSize,
			@RequestParam Map<String, String> filter) {
		Pageable page = PageRequest.of(pageNumber, pageSize);

		Medico medico = new Medico();

		if (filter.containsKey("nome")) {
			medico.setNome(filter.get("nome"));
		}
		if (filter.containsKey("especialidade")) {
			int iEsp = Integer.valueOf(filter.get("especialidade"));
			Especialidade esp = Especialidade.values()[iEsp];
			medico.setEspecialidade(esp);
		}
		if (filter.containsKey("dataNascimento")) {
			LocalDate date = LocalDate.parse(filter.get("dataNascimento"));
			medico.setDataNascimento(date);
		}

		ExampleMatcher matcher = ExampleMatcher.matchingAny()
				.withMatcher("nome", match -> match.contains().ignoreCase())
				.withMatcher("dataNascimento", match -> match.exact())
				.withMatcher("especialidade", match -> match.exact());
		Example<Medico> example = Example.of(medico, matcher);

		return getService().paged(example, page)
				.map(x -> new MedicoItemDTO(x.getNome(), x.getEspecialidade(), x.getDataNascimento())).toList();
	}
	
	@GetMapping("test")
	public void test() {
		medicDao.Test();
	}

}
