package com.montonurb.med.api.dto;

import com.montonurb.med.api.enums.Especialidade;
import com.montonurb.med.api.models.Endereco;
import com.montonurb.med.api.models.Medico;

public record MedicoRetornoDto(Long id, String nome, String email, String crm, String telefone, Especialidade especialidade, Endereco endereco) {
    public MedicoRetornoDto(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(), medico.getEspecialidade(), medico.getEndereco());
    }
}
