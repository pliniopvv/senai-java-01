package br.com.exemplo.aula.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.exemplo.aula.controllers.dto.PacienteRequestDTO;
import br.com.exemplo.aula.controllers.dto.PacienteResponseDTO;
import br.com.exemplo.aula.entities.Paciente;
import br.com.exemplo.aula.repositories.PacienteRepository;
import br.com.exemplo.aula.services.PacienteService;

@ExtendWith(MockitoExtension.class)
public class PacienteServiceTest {

	@Mock
	PacienteRepository pacienteRepository;

	@InjectMocks
	PacienteService pacienteService;

	Paciente paciente;

	@BeforeEach
	public void setup() {
		paciente = new Paciente(1L, "asdf", LocalDate.now(), "123.123.123-12", "12341234", "mail@xmail.com.br");
	}

	@Test
	@DisplayName("Testa listar pacientes!")
	void listarPacientes() {

		List<Paciente> pacientes = new ArrayList<>();
		pacientes.add(paciente);

		when(pacienteRepository.findAll()).thenReturn(pacientes);

		var resultado = pacienteService.listarPacientes();

		assertNotNull(resultado);
		assertEquals(pacientes.get(0).getId(), resultado.get(0).getId());

		verify(pacienteRepository).findAll();
	}

	@Test
	@DisplayName("Testa busca paciente!")
	void buscarPaciente() {

		when(pacienteRepository.findById(anyLong())).thenReturn(Optional.ofNullable(paciente));
		
		PacienteResponseDTO resultado = pacienteService.buscarPaciente(1L);
		
		assertNotNull(resultado);
		assertEquals(paciente.getId(), resultado.getId());
		
		verify(pacienteRepository).findById(anyLong());
	}

	@Test
	void salvarPaciente() {
		PacienteRequestDTO pacienteRequestDTO = new PacienteRequestDTO(paciente.getNome(), paciente.getDataNascimento(),
				paciente.getCpf(), paciente.getTelefone(), paciente.getEmail(), 1L);

		when(pacienteRepository.save(any())).thenReturn(paciente);

		var resultado = pacienteService.salvarPaciente(pacienteRequestDTO);

		assertNotNull(resultado);
		assertEquals(pacienteRequestDTO.getNome(), resultado.getNome());

		verify(pacienteRepository).save(any());
	}

	@Test
	@DisplayName("Testa atualizar paciente!")
	void atualizarPaciente() {
		PacienteRequestDTO pacienteRequestDTO = new PacienteRequestDTO(paciente.getNome(), paciente.getDataNascimento(),
				paciente.getCpf(), paciente.getTelefone(), paciente.getEmail(), 1L);

		when(pacienteRepository.findById(anyLong())).thenReturn(Optional.ofNullable(paciente));
		when(pacienteRepository.save(any(Paciente.class))).thenReturn(paciente);

		// When
		var resultado = pacienteService.atualizarPaciente(1L, pacienteRequestDTO);

		// Then
		assertNotNull(resultado);
		assertEquals(pacienteRequestDTO.getNome(), resultado.getNome());

		verify(pacienteRepository, times(1)).findById(anyLong());
		verify(pacienteRepository).save(any());
	}

	@Test
	@DisplayName("Testa remover paciente!")
	void removerPaciente() {
		doNothing().when(pacienteRepository).deleteById(anyLong());

		assertDoesNotThrow(() -> pacienteService.removerPaciente(1L));

		verify(pacienteRepository).deleteById(anyLong());
	}

}
