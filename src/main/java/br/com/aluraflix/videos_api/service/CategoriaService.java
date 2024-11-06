package br.com.aluraflix.videos_api.service;

import br.com.aluraflix.videos_api.model.categoria.*;
import br.com.aluraflix.videos_api.model.video.DadosDetalhamentoVideo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repository;

    public ResponseEntity cadastrarCategoria(DadosCadastroCategoria dados, UriComponentsBuilder uriComponentsBuilder) {
        var categoria = new Categoria(dados);
        var uri = uriComponentsBuilder.path("/categoria/{id}").buildAndExpand(dados.id()).toUri();
        repository.save(categoria);
        return ResponseEntity.created(uri).body(new DadosDetalhamentoCategoria(categoria));
    }

    public ResponseEntity<Page<DadosListagemCategoria>> listarCategoriaAtiva(Pageable pageable){
        var page = repository.findAllByAtivoTrue(pageable).map(DadosListagemCategoria::new);
        return ResponseEntity.ok(page);
    }

    public ResponseEntity buscarCategoriaPorId(Long id) {
        var categoria = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoCategoria(categoria));
    }

    public ResponseEntity atualizarCategoria(DadosCategoriaAtualizada dadosCategoriaAtualizada) {
        var categoria = repository.getReferenceById(dadosCategoriaAtualizada.id());
        categoria.atualizar(dadosCategoriaAtualizada);
        return ResponseEntity.ok(new DadosDetalhamentoCategoria(categoria));
    }

    public ResponseEntity deletarPorId(Long id) {
        var categoria = repository.getReferenceById(id);
        categoria.deletar();
        return ResponseEntity.noContent().build();
    }
}