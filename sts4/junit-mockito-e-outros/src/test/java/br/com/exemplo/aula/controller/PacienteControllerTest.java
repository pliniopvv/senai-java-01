package br.com.exemplo.aula.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import br.com.exemplo.aula.controllers.PacienteController;
import br.com.exemplo.aula.controllers.dto.PacienteRequestDTO;
import br.com.exemplo.aula.controllers.dto.PacienteResponseDTO;
import br.com.exemplo.aula.entities.Paciente;
import br.com.exemplo.aula.services.PacienteService;

@WebMvcTest(controllers = PacienteController.class)
@AutoConfigureMockMvc
@ActiveProfiles("Test")
public class PacienteControllerTest {

	@Autowired
	MockMvc mvc;

	@MockBean
	PacienteService service;

	@MockBean
	static AuthenticationManager authenticationManager;

	Paciente paciente;

	@BeforeAll
	static void configAuth() {
		UserDetails userDetails = User.withUsername("user").password("password").roles("USER").build();

		Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
				userDetails.getAuthorities());
		Mockito.when(authenticationManager.authenticate(Mockito.any())).thenReturn(authentication);
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	@BeforeEach
	public void setup() {
		paciente = new Paciente(1L, "asdf", LocalDate.now(), "123.123.123-12", "12341234", "mail@xmail.com.br");

	}

	@Test
	void listarPacinetes() throws Exception {
		var pacienteDto = new PacienteResponseDTO(1L, "Paciente", LocalDate.now(), "UM CPF", "123123",
				"E-mail@x.com.br");

		when(service.listarPacientes()).thenReturn(List.of(pacienteDto));

		mvc.perform(get("/pacientes")).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].nome").value(pacienteDto.getNome()));

		verify(service).listarPacientes();
	}

	@Test
	void search() throws Exception {
		var pacienteDto = new PacienteResponseDTO(1L, "Paciente", LocalDate.now(), "UM CPF", "123123",
				"E-mail@x.com.br");

		when(service.buscarPaciente(anyLong())).thenReturn(pacienteDto);

		mvc.perform(get("/pacientes/1")).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].nome").value(pacienteDto.getNome()));

		verify(service).buscarPaciente(anyLong());
	}

	@Test
	void remover() throws Exception {
		doNothing().when(service).removerPaciente(anyLong());

		mvc.perform(delete("/pacientes/1")).andExpect(status().isNoContent());

		verify(service).removerPaciente(anyLong());
	}

	@Test
	void atualizarPaciente() throws Exception {
		var pacienteDto = new PacienteResponseDTO(1L, "Paciente", LocalDate.now(), "UM CPF", "123123",
				"E-mail@x.com.br");

		when(service.atualizarPaciente(anyLong(), any(PacienteRequestDTO.class))).thenReturn(pacienteDto);

		mvc.perform(
				put("/pacientes/1").header("Authoriztion", "fake").contentType(MediaType.APPLICATION_JSON).content("""
						{
							"nome": "Pacinete",
							"cpf": "123123",
							"telefone": "1231312",
							"idEndereco": 5,
							"dataNascimento": "15/08/2000"
						}
						""")).andExpect(status().isOk());

		verify(service).atualizarPaciente(anyLong(), any(PacienteRequestDTO.class));
	}

}
