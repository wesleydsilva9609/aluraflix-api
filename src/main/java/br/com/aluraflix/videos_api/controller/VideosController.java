package br.com.aluraflix.videos_api.controller;

import br.com.aluraflix.videos_api.model.video.DadosAtualizarVideo;
import br.com.aluraflix.videos_api.model.video.DadosCadastroVideo;
import br.com.aluraflix.videos_api.model.video.DadosListagemVideo;
import br.com.aluraflix.videos_api.service.VideosService;
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
    public ResponseEntity cadastrarVideo(@Valid @RequestBody DadosCadastroVideo dados, UriComponentsBuilder uri){
        return service.cadastrarVideo(dados,uri);
    }

    @GetMapping("/")
    public ResponseEntity<Page<DadosListagemVideo>> listarVideos(@PageableDefault(size = 5,sort = "id")Pageable pageable){
        return service.exibirTodosOsVideosAtivos(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarVideoPorID(@PathVariable Long id){
        return service.buscarVidePorId(id);
    }

    @PutMapping()
    @Transactional
    public ResponseEntity atualizarVideoPorId(@Valid @RequestBody DadosAtualizarVideo dados){
        return service.atualizarVideosPorId(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarPorId(@PathVariable Long id){
        return service.deletarPorId(id);
    }

}
