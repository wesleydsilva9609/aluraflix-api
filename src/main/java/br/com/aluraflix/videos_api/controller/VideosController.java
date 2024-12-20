package br.com.aluraflix.videos_api.controller;

import br.com.aluraflix.videos_api.model.video.DadosAtualizarVideo;
import br.com.aluraflix.videos_api.model.video.DadosCadastroVideo;
import br.com.aluraflix.videos_api.model.video.DadosListagemVideo;
import br.com.aluraflix.videos_api.service.VideosService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/videos")
public class VideosController {
    @Autowired
    private VideosService service;

    @PostMapping
    @Transactional
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity cadastrarVideo(@Valid @RequestBody DadosCadastroVideo dados, UriComponentsBuilder uri){
        return service.cadastrarVideo(dados,uri);
    }

    @GetMapping("/")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<Page<DadosListagemVideo>> listarVideos(@PageableDefault(size = 5,sort = "id")Pageable pageable){
        return service.exibirTodosOsVideosAtivos(pageable);
    }

    @GetMapping("/{id}")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity buscarVideoPorID(@PathVariable Long id){
        return service.buscarVidePorId(id);
    }

    @PutMapping()
    @Transactional
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity atualizarVideoPorId(@Valid @RequestBody DadosAtualizarVideo dados){
        return service.atualizarVideosPorId(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity deletarPorId(@PathVariable Long id){
        return service.deletarPorId(id);
    }

    @GetMapping
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity buscarVideoPorTitulo(@RequestParam(name = "search",required = false) String titulo){
        return service.buscarVideoPorTitulo(titulo);
    }

    @GetMapping("/free")
    public ResponseEntity<Page<DadosListagemVideo>> listarVideosfree(@PageableDefault(size = 2,sort = "id")Pageable pageable){
        return service.exibirTodosOsVideosAtivos(pageable);
    }



}
