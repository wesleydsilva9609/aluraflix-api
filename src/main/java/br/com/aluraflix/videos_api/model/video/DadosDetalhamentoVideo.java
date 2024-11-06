package br.com.aluraflix.videos_api.model.video;

public record DadosDetalhamentoVideo(Long id, String titulo, String descricao, String url) {

    public DadosDetalhamentoVideo(Video video){
        this(video.getId(), video.getTitulo(), video.getDescricao(), video.getUrl());
    }
}