package br.com.aluraflix.videos_api.model.video;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroVideo(
        Long id,
        Long categoriaid,
        @NotBlank
        String titulo,
        @NotBlank
        String descricao,
        @NotBlank
        String url) {

        public DadosCadastroVideo(Video video) {
                this(video.getId(),video.getCategoriaid().getId(), video.getTitulo(), video.getDescricao(), video.getUrl());
        }


}
