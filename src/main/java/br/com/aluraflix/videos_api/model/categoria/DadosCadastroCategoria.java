package br.com.aluraflix.videos_api.model.categoria;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroCategoria( Long id, @NotBlank String titulo, @NotBlank String cor) {
}
