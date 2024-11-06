package br.com.aluraflix.videos_api.controller;

import br.com.aluraflix.videos_api.model.categoria.DadosCadastroCategoria;
import br.com.aluraflix.videos_api.model.categoria.DadosCategoriaAtualizada;
import br.com.aluraflix.videos_api.model.categoria.DadosListagemCategoria;
import br.com.aluraflix.videos_api.service.CategoriaService;
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
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService service;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarCategoria(@Valid @RequestBody DadosCadastroCategoria dados, UriComponentsBuilder uriComponentsBuilder){
        return service.cadastrarCategoria(dados,uriComponentsBuilder);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemCategoria>> listagemCategoria(@PageableDefault(size = 5,sort = "id")Pageable pageable){
        return service.listarCategoriaAtiva(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarCategoriaPorId(@PathVariable Long id){
        return service.buscarCategoriaPorId(id);
    }

    @PutMapping()
    @Transactional
    public ResponseEntity atualizarCategoria(@RequestBody DadosCategoriaAtualizada dados){
        return service.atualizarCategoria(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarPorId(@PathVariable Long id){
        return service.deletarPorId(id);
    }

}
