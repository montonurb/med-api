package com.montonurb.med.api.service;

import com.montonurb.med.api.dto.DadosAutenticacao;
import com.montonurb.med.api.models.Usuario;
import com.montonurb.med.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public void cadastrar(DadosAutenticacao usuario) {
        Usuario user = new Usuario();
        user.setLogin(usuario.login());
        user.setSenha(encriptografarSenha(usuario.senha()));

        repository.save(user);
    }

    private String encriptografarSenha(String senha) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        return encoder.encode(senha);
    }
}
