package br.com.exemplo.aula.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.exemplo.aula.controllers.dto.NutricionistaRequestDTO;
import br.com.exemplo.aula.entities.Nutricionista;
import br.com.exemplo.aula.services.NutricionistaService;

@SpringBootTest
public class NutricionistaServiceSimplesTest {

	@Autowired
	NutricionistaService service;

	Nutricionista nutricionista;

	@BeforeEach
	public void setup() {
		nutricionista = new Nutricionista(1L, "Um nome de nutricionista", "12323", 5, "CRN12311", "Faxineira",
				Set.of("Certificado 1", "Certificado 2"));
	}

	@Test
	@DisplayName("")
	void testeSimples() {
		NutricionistaRequestDTO entity = new NutricionistaRequestDTO("Um nome de nutricionista", "123123", 5, 12L,
				"CRN12311", "Faxineira");

		service.salvarNutricionista(entity);
		var resultado = service.buscarNutricionista(1L);

		assertNotNull(resultado);
		assertEquals(resultado.getMatricula(), entity.getMatricula());
	}

}
