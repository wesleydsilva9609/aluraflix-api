package br.com.aluraflix.videos_api.controller;

import br.com.aluraflix.videos_api.model.categoria.DadosCadastroCategoria;
import br.com.aluraflix.videos_api.model.categoria.DadosCategoriaAtualizada;
import br.com.aluraflix.videos_api.model.categoria.DadosListagemCategoria;
import br.com.aluraflix.videos_api.model.video.DadosListagemVideo;
import br.com.aluraflix.videos_api.service.CategoriaService;
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

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService service;

    @PostMapping
    @Transactional
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity cadastrarCategoria(@Valid @RequestBody DadosCadastroCategoria dados, UriComponentsBuilder uriComponentsBuilder){
        return service.cadastrarCategoria(dados,uriComponentsBuilder);
    }

    @GetMapping
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<Page<DadosListagemCategoria>> listagemCategoria(@PageableDefault(size = 5,sort = "id")Pageable pageable){
        return service.listarCategoriaAtiva(pageable);
    }

    @GetMapping("/{id}")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity buscarCategoriaPorId(@PathVariable Long id){
        return service.buscarCategoriaPorId(id);
    }

    @PutMapping()
    @Transactional
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity atualizarCategoria(@RequestBody DadosCategoriaAtualizada dados){
        return service.atualizarCategoria(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity deletarPorId(@PathVariable Long id){
        return service.deletarPorId(id);
    }

    @GetMapping("/{id}/videos")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity <List<DadosListagemVideo>> buscarVideosPorCategoria(@PathVariable Long id){
        return service.buscarVideosPorCategoria(id);
    }






}
