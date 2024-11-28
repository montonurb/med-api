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
import java.util.Optional;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository repository;

    public Medico criarMedico(DadosCadastroMedico dados) {
        Medico medico = new Medico(dados);
        repository.save(medico);

        return medico;
    }

    public Page<DadosListagemMedico> buscarTodosMedicos(Pageable pageable) {
        return repository.buscarMedicosAtivos(pageable).map(DadosListagemMedico::new);
    }

    public Medico atualizarMedico(DadosAtualizacaoMedico dados) {
        Medico medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);

        return medico;
    }

    public void excluirMedico(Long id) {
        Medico medico = repository.getReferenceById(id);
        medico.setAtivo(false);
    }

    public Medico buscarPorId(Long id) {
        Optional<Medico> medico = repository.findById(id);

        return medico.orElse(null);
    }
}
