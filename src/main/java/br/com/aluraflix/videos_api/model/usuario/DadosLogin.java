package br.com.aluraflix.videos_api.model.usuario;

import jakarta.validation.constraints.NotBlank;

public record DadosLogin(@NotBlank String login,@NotBlank String senha) {
}
