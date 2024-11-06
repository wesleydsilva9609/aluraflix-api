package br.com.aluraflix.videos_api.model.categoria;

public record DadosListagemCategoria(Long id, String titulo, String cor) {
    public  DadosListagemCategoria(Categoria categoria){
        this(categoria.getId(), categoria.getTitulo(), categoria.getCor());
    }
}
