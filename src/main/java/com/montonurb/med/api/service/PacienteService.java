package com.montonurb.med.api.service;

import com.montonurb.med.api.dto.DadosCadastroPaciente;
import com.montonurb.med.api.dto.DadosListagemMedico;
import com.montonurb.med.api.models.Paciente;
import com.montonurb.med.api.repository.PacienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository repository;

    public void criarPaciente(@Valid DadosCadastroPaciente dados) {
        repository.save(new Paciente(dados));
    }
}
