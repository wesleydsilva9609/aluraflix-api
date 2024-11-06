package br.com.aluraflix.videos_api.model.categoria;

import br.com.aluraflix.videos_api.model.video.DadosAtualizarVideo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Categoria")
@Table(name = "categorias")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String cor;
    private boolean ativo;

    public Categoria(DadosCadastroCategoria dados) {
        this.id = dados.id();
        this.titulo = dados.titulo();
        this.cor = dados.cor();
        this.ativo = true;
    }

    public void atualizar(DadosCategoriaAtualizada dadosCategoriaAtualizada) {
        if(dadosCategoriaAtualizada.titulo() != null){
            this.titulo = dadosCategoriaAtualizada.titulo();
        }if(dadosCategoriaAtualizada.cor() != null){
            this.cor = dadosCategoriaAtualizada.cor();
        }
    }

    public void deletar() {
        this.ativo = false;
    }
}
