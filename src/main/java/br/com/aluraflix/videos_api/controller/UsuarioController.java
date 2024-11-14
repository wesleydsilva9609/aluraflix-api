package br.com.aluraflix.videos_api.controller;

import br.com.aluraflix.videos_api.model.usuario.*;
import br.com.aluraflix.videos_api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @Transactional
    public ResponseEntity efetuarLogin(@RequestBody DadosLogin dadosLogin){
        return usuarioService.efetuarLogin(dadosLogin);
    }


}
