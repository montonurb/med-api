package com.montonurb.med.api.dto;

import com.montonurb.med.api.enums.Especialidade;
import com.montonurb.med.api.models.Medico;

public record DadosListagemMedico(Long id, String nome, String email, String crm, Especialidade especialidade) {
    public DadosListagemMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
