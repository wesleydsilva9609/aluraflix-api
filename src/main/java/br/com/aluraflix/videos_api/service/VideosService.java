package br.com.aluraflix.videos_api.service;

import br.com.aluraflix.videos_api.model.video.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class VideosService {
    @Autowired
    private VideoRepository repository;


    public ResponseEntity cadastrarVideo(DadosCadastroVideo dados, UriComponentsBuilder uri) {
        var video = new Video(dados);
        var uribuilder = uri.path("/videos{id}").buildAndExpand(dados.id()).toUri();
        repository.save(video);
        return ResponseEntity.created(uribuilder).body(new DadosDetalhamentoVideo(video));
    }

    public ResponseEntity<Page<DadosListagemVideo>> exibirTodosOsVideosAtivos(Pageable pageable){
        var page = repository.findAllByAtivoTrue(pageable).map(DadosListagemVideo::new);
        return ResponseEntity.ok(page);
    }

    public ResponseEntity buscarVidePorId(Long id) {
        var video = repository.findById(id);
        return ResponseEntity.ok(video);
    }

    public ResponseEntity atualizarVideosPorId(DadosAtualizarVideo dadosAtualizarVideo){
        var video = repository.getReferenceById(dadosAtualizarVideo.id());
        video.Atualizar(dadosAtualizarVideo);
        return ResponseEntity.ok(new DadosDetalhamentoVideo(video));
    }

    public ResponseEntity deletarPorId(Long id) {
        var video = repository.getReferenceById(id);
        video.deletar();
        return ResponseEntity.noContent().build();
    }
}
