package br.com.exemplo.aula.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.exemplo.aula.controllers.dto.ConsultaRequestDTO;
import br.com.exemplo.aula.controllers.dto.ConsultaResponseDTO;
import br.com.exemplo.aula.controllers.dto.ConsultaResponseListDTO;
import br.com.exemplo.aula.services.ConsultaService;

@RestController
@RequestMapping(value = "/consultas")
public class ConsultaController {

    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @PostMapping()
    public ConsultaResponseDTO salvarConsulta(@RequestBody ConsultaRequestDTO request) {
        return consultaService.salvarConsulta(request);
    }

    @GetMapping()
    public List<ConsultaResponseListDTO> listarConsultas() {
        var consultas = consultaService.listarConsultas();
        if (consultas.isEmpty()){
            return null;
        } else {
            return consultas;
        }

    }
    
    @GetMapping("/consultas/{id}")
    public ResponseEntity<ConsultaResponseDTO> buscarConsultaPorID(@PathVariable Long id) {
        ConsultaResponseDTO consulta = consultaService.buscarConsulta(id);
        return ResponseEntity.ok(consulta);
    }

    @DeleteMapping("/consultas/{id}")
    public ResponseEntity<Void> deletarConsultaPorId(@PathVariable Long id) {
        consultaService.deletarConsulta(id);
        return ResponseEntity.noContent().build();
    }
    
}
