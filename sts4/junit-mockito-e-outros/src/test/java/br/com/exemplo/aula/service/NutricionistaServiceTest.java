package br.com.exemplo.aula.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.exemplo.aula.controllers.dto.NutricionistaRequestDTO;
import br.com.exemplo.aula.entities.Nutricionista;
import br.com.exemplo.aula.repositories.NutricionistaRepository;
import br.com.exemplo.aula.services.NutricionistaService;

@ExtendWith(MockitoExtension.class)
public class NutricionistaServiceTest {

	@Mock
	NutricionistaRepository repository;

	@InjectMocks
	NutricionistaService service;

	Nutricionista nutricionista;

	@BeforeEach
	public void setup() {
		nutricionista = new Nutricionista(1L, "Um nome de nutricionista", "12323", 5, "CRN12311", "Faxineira",
				Set.of("Certificado 1", "Certificado 2"));
	}

	@Test
	@DisplayName("Teste listar nutricionistas!")
	void listarNutricionistas() {

		var lista = new ArrayList<Nutricionista>();
		lista.add(nutricionista);
		when(repository.findAll()).thenReturn(lista);

		var resultado = service.listarNutricionistas();

		assertNotNull(resultado);
		assertEquals(resultado.get(0).getId(), lista.get(0).getId());

		verify(repository).findAll();
	}

	@Test
	@DisplayName("Teste buscar nutricionista!")
	void buscarNutricionista() {
		
		when(repository.findById(anyLong())).thenReturn(Optional.ofNullable(nutricionista));
		
		var resultado = service.buscarNutricionista(1L);
		
		assertNotNull(resultado);
		assertEquals(nutricionista.getId(), resultado.getId());
		
		verify(repository).findById(anyLong());
	}

	@Test
	@DisplayName("Teste salvar nutricionista!")
	void salvarNutricionista() {
		NutricionistaRequestDTO entity = new NutricionistaRequestDTO("Um nome de nutricionista", "123123", 5, 12L,
				"CRN12311", "Faxineira");

		when(repository.save(any())).thenReturn(nutricionista);

		var resultado = service.salvarNutricionista(entity);

		assertNotNull(resultado);
		assertEquals(resultado.getId(), nutricionista.getId());
	}

	@Test
	@DisplayName("Teste remover nutricionista!")
	void removerNutricionista() {
		doNothing().when(repository).deleteById(anyLong());

		assertDoesNotThrow(() -> service.removerNutricionista(1L));

		verify(repository).deleteById(anyLong());
	}

	@Test
	@DisplayName("Teste autalizar nutricionista!")
	void atualizarNutricionista() {
		NutricionistaRequestDTO entity = new NutricionistaRequestDTO("Um nome de nutricionista", "123123", 5, 12L,
				"CRN12311", "Faxineira");
		when(repository.findById(anyLong())).thenReturn(Optional.ofNullable(nutricionista));
		when(repository.save(any(Nutricionista.class))).thenReturn(nutricionista);

		var resultado = service.atualizarNutricionista(1L, entity);

		assertNotNull(resultado);

		verify(repository).findById(anyLong());
		verify(repository).save(any(Nutricionista.class));
	}

}
