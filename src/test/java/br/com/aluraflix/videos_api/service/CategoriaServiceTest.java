package br.com.aluraflix.videos_api.service;

import br.com.aluraflix.videos_api.model.categoria.*;
import br.com.aluraflix.videos_api.model.video.DadosListagemVideo;
import br.com.aluraflix.videos_api.model.video.Video;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.then;
import static org.mockito.BDDMockito.willReturn;

@ExtendWith(MockitoExtension.class)
class CategoriaServiceTest {
    @InjectMocks
    private CategoriaService service;
    @Mock
    private DadosCadastroCategoria dadosCadastroCategoria;
    @Mock
    private DadosDetalhamentoCategoria dadosDetalhamentoCategoria;
    @Mock
    private Categoria categoria;
    @Mock
    private CategoriaRepository categoriaRepository;
    @Mock
    private DadosCategoriaAtualizada dadosCategoriaAtualizada;
    @Mock
    private List<Video> video;;


    @Test
    void deveriaSalvarCategoria() {
        service.cadastrarCategoria(dadosCadastroCategoria, UriComponentsBuilder.fromUriString("/categoria"));
         then(categoriaRepository).should().save(new Categoria(dadosCadastroCategoria));
    }

    @Test
    void deveriaRetornarCategoriaPorid(){
        BDDMockito.given(categoriaRepository.getReferenceById(dadosDetalhamentoCategoria.id())).willReturn(categoria);
        assertDoesNotThrow(() -> service.buscarCategoriaPorId(categoria.getId()));
    }

    @Test
    void deveriaDeletarCategoria(){
        BDDMockito.given(categoriaRepository.getReferenceById(dadosDetalhamentoCategoria.id())).willReturn(categoria);
        assertDoesNotThrow(() -> service.deletarPorId(categoria.getId()));

    }

    @Test
    void deveriaBuscarVideoCategoria(){
        BDDMockito.given(categoriaRepository.buscarVideoPorCategoriaId(categoria.getId())).willReturn(video);
        assertDoesNotThrow(() -> service.buscarVideosPorCategoria(categoria.getId()));

    }

    @Test
    void deveriaAtualizaCategoria() {
        BDDMockito.given(categoriaRepository.getReferenceById(dadosCategoriaAtualizada.id())).willReturn(categoria);
        assertDoesNotThrow(()-> service.atualizarCategoria(dadosCategoriaAtualizada));
    }


}