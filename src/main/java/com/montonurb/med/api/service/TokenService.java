package com.montonurb.med.api.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.montonurb.med.api.models.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("api.secrety.token.secret")
    private String secret;

    public String gerarToken(Usuario usuario) {
        try {
            Algorithm algotitmo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("Montonurb APIs")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(dataExpiracao())
                    .sign(algotitmo);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar Token: " + exception);
        }
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusDays(1).toInstant(ZoneOffset.of("-03:00"));
    }
}
