package com.montonurb.med.api.dto;

import org.springframework.validation.FieldError;

public record DadosErroValidacao(String campo, String menssagem) {
    public DadosErroValidacao(FieldError field) {
        this(field.getField(), field.getDefaultMessage());
    }
}
