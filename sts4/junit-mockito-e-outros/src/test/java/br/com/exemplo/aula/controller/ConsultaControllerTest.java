package br.com.exemplo.aula.controller;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.exemplo.aula.controllers.dto.ConsultaRequestDTO;
import br.com.exemplo.aula.controllers.dto.ConsultaResponseDTO;
import br.com.exemplo.aula.controllers.dto.ConsultaResponseListDTO;
import br.com.exemplo.aula.entities.Consulta;
import br.com.exemplo.aula.services.ConsultaService;

@SpringBootTest
@AutoConfigureMockMvc
public class ConsultaControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private ConsultaService consultaService;

	Consulta consulta;
	ConsultaResponseListDTO cDto;
	ConsultaResponseDTO responseDto;

	@BeforeEach
	void consulta() {
		consulta = new Consulta(1L, null, null, LocalDate.now(), "observações");
		cDto = new ConsultaResponseListDTO(1L, "AAAAA", "BBBBB", LocalDate.now());
		response = new ConsultaResponseDTO(1L, null, null, LocalDate.now(), "AAAAAA");
	}

	@Test
	public void testSalvarConsulta() throws Exception {
		ConsultaRequestDTO request = new ConsultaRequestDTO();

		mockMvc.perform(post("/consultas").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request))).andExpect(status().isOk())
				.andExpect(jsonPath("$.id").exists());
	}

	@Test
	public void testListarConsultas() throws Exception {
		
		when(consultaService.listarConsultas()).thenReturn(List.of(cDto));
		
		mockMvc.perform(get("/consultas").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$").isArray());
		
		verify(consultaService).listarConsultas();
	}

	@Test
	public void testBuscarConsultaPorID() throws Exception {
		Long id = 1L;

		when(consultaService.buscarConsulta(anyLong())).thenReturn(responseDto);

		mockMvc.perform(get("/consultas/{id}", id).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(id));

		verify(consultaService).buscarConsulta(anyLong());
	}

	@Test
	public void testDeletarConsultaPorId() throws Exception {
		Long id = 1L;

		doNothing().when(consultaService).deletarConsulta(anyLong());

		mockMvc.perform(delete("/consultas/{id}", id).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());

		verify(consultaService).deletarConsulta(anyLong());
	}
}
