package br.com.aluraflix.videos_api.service;

import br.com.aluraflix.videos_api.model.usuario.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private TokenService service;
    @Autowired
    private AuthenticationManager manager;


    public ResponseEntity efetuarLogin(DadosLogin dadosLogin) {
        var token = new UsernamePasswordAuthenticationToken(dadosLogin.login(),dadosLogin.senha());
        var authentication = manager.authenticate(token);
        var tokenJWT = service.gerarToken((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok(new DadosJwt(tokenJWT));
    }
}
