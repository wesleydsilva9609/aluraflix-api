package br.com.aluraflix.videos_api.model.video;

import jakarta.validation.constraints.NotBlank;

public record DadosAtualizarVideo(Long id, String Titulo, String descricao, String url){
}
