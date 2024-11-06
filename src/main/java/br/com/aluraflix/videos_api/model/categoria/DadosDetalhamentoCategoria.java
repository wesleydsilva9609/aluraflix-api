package br.com.aluraflix.videos_api.model.categoria;

import br.com.aluraflix.videos_api.model.video.Video;

public record DadosDetalhamentoCategoria(Long id, String titulo, String cor) {

    public DadosDetalhamentoCategoria(Categoria categoria){
        this(categoria.getId(), categoria.getTitulo(), categoria.getCor());
    }
}
