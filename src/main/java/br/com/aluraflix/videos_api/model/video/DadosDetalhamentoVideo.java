package br.com.aluraflix.videos_api.model.video;

public record DadosDetalhamentoVideo(Long id,Long categoriaid, String titulo, String descricao, String url) {

    public DadosDetalhamentoVideo(Video video){
        this(video.getId(), video.getCategoriaid().getId(), video.getTitulo(), video.getDescricao(), video.getUrl());
    }
}
