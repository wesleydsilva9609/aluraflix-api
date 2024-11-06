package br.com.aluraflix.videos_api.model.video;

import br.com.aluraflix.videos_api.model.video.DadosAtualizarVideo;
import br.com.aluraflix.videos_api.model.video.DadosCadastroVideo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Video")
@Table(name = "videos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private String url;
    private boolean ativo;

    public Video(DadosCadastroVideo dados){
        this.id = dados.id();
        this.titulo = dados.titulo();
        this.descricao = dados.descricao();
        this.url = dados.url();
        this.ativo = true;
    }

    public void Atualizar(DadosAtualizarVideo dadosAtualizarVideo) {
        if(dadosAtualizarVideo.Titulo() != null){
            this.titulo = dadosAtualizarVideo.Titulo();
        }if(dadosAtualizarVideo.descricao() != null){
            this.descricao = dadosAtualizarVideo.descricao();
        }if(dadosAtualizarVideo.url() != null){
            this.url = dadosAtualizarVideo.url();
        }
    }

    public void deletar(){
        this.ativo = false;
    }
}
