package com.montonurb.med.api.controller;

import com.montonurb.med.api.dto.DadosCadastroPaciente;
import com.montonurb.med.api.service.PacienteService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService service;

    @PostMapping("/cadastrar")
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados) {
        service.criarPaciente(dados);
    }
}
