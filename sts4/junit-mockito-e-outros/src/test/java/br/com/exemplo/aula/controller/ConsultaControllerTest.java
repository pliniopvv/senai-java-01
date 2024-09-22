package br.com.exemplo.aula.controller;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import br.com.exemplo.aula.controllers.ConsultaController;
import br.com.exemplo.aula.controllers.dto.ConsultaResponseDTO;
import br.com.exemplo.aula.entities.Nutricionista;
import br.com.exemplo.aula.entities.Paciente;
import br.com.exemplo.aula.services.ConsultaService;

@WebMvcTest(ConsultaController.class)
public class ConsultaControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ConsultaService consultaService;

	@Test
	public void testBuscarConsultaPorID() throws Exception {
		Nutricionista nutricionista = new Nutricionista();
		Paciente paciente = new Paciente();

		ConsultaResponseDTO consulta = new ConsultaResponseDTO(1L, nutricionista, paciente,
				LocalDate.of(2024, 9, 22), "Consulta de rotina");
		when(consultaService.buscarConsulta(1L)).thenReturn(consulta);

		mockMvc.perform(get("/consultas/1")).andExpect(status().isOk()).andExpect(jsonPath("$.id").value(1L))
				.andExpect(jsonPath("$.nome").value("Consulta de Exemplo"));
		
		verify(consultaService).buscarConsulta(anyLong());
	}

	@Test
	public void testDeletarConsultaPorId() throws Exception {
		doNothing().when(consultaService).deletarConsulta(1L);

		mockMvc.perform(delete("/consultas/1")).andExpect(status().isNoContent());
		
		verify(consultaService).deletarConsulta(anyLong());
	}
}
