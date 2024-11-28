package com.montonurb.med.api.controller;

import com.montonurb.med.api.dto.DadosAtualizacaoMedico;
import com.montonurb.med.api.dto.DadosCadastroMedico;
import com.montonurb.med.api.dto.DadosListagemMedico;
import com.montonurb.med.api.dto.MedicoRetornoDto;
import com.montonurb.med.api.service.MedicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoService service;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico json, UriComponentsBuilder uriBuilder) {
        var medico = service.criarMedico(json);
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new MedicoRetornoDto(medico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>> buscarTodosMedicos(Pageable pageable) {
        var page = service.buscarTodosMedicos(pageable);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) {
        var medico = service.atualizarMedico(dados);

        return ResponseEntity.ok(new MedicoRetornoDto(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
        service.excluirMedico(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity pesquisarPorId(@PathVariable Long id) {
        var medico = service.buscarPorId(id);

        return ResponseEntity.ok(new MedicoRetornoDto(medico));
    }
}
