package com.montonurb.med.api.controller;

import com.montonurb.med.api.dto.DadosAutenticacao;
import com.montonurb.med.api.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public ResponseEntity cadastrarUsuario(@RequestBody @Valid DadosAutenticacao dados) {
        service.cadastrar(dados);

        return ResponseEntity.ok().build();
    }
}
