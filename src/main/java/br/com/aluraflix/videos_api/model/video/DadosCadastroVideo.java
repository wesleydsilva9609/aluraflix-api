package br.com.aluraflix.videos_api.model.video;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroVideo(
        Long id,
        @NotBlank
        String titulo,
        @NotBlank
        String descricao,
        @NotBlank
        String url) {
}
