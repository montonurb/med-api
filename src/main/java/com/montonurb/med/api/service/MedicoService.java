package com.montonurb.med.api.service;

import com.montonurb.med.api.dto.DadosAtualizacaoMedico;
import com.montonurb.med.api.dto.DadosCadastroMedico;
import com.montonurb.med.api.dto.DadosListagemMedico;
import com.montonurb.med.api.models.Medico;
import com.montonurb.med.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository repository;

    public void criarMedico(DadosCadastroMedico dados) {
        repository.save(new Medico(dados));
    }

    public Page<DadosListagemMedico> buscarTodosMedicos(Pageable pageable) {
        return repository.findAll(pageable).map(DadosListagemMedico::new);
    }

    public void atualizarMedico(DadosAtualizacaoMedico dados) {
        Medico medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);

    }
}
