package br.com.aluraflix.videos_api.model.usuario;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {


    public String gerarToken(Usuario usuario){
        try {
            var algorithm = Algorithm.HMAC256("secret");
            return JWT.create()
                    .withIssuer("Aluraflix_Api")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(DateInspiracao())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("nao foi possivel Gerar o Token",exception);
        }

    }

    public String getSubject(String tokenJWT){
        try {
            var algorithm = Algorithm.HMAC256("secret");
            return JWT.require(algorithm)
                    .withIssuer("Aluraflix_Api")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException exception){
            throw new RuntimeException("Token Invalido");
        }

    }

    private Instant DateInspiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }


}
