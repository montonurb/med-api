package com.montonurb.med.api.controller;

import com.montonurb.med.api.dto.DadosAtualizacaoMedico;
import com.montonurb.med.api.dto.DadosCadastroMedico;
import com.montonurb.med.api.dto.DadosListagemMedico;
import com.montonurb.med.api.service.MedicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoService service;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico json) {
        service.criarMedico(json);
    }

    @GetMapping
    public Page<DadosListagemMedico> buscarTodosMedicos(Pageable pageable) {
        return service.buscarTodosMedicos(pageable);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) {
        service.atualizarMedico(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id) {
        service.excluirMedico(id);
    }
}
