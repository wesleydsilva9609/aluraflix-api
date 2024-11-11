package br.com.aluraflix.videos_api.service;

import br.com.aluraflix.videos_api.model.categoria.Categoria;
import br.com.aluraflix.videos_api.model.categoria.CategoriaRepository;
import br.com.aluraflix.videos_api.model.categoria.DadosDetalhamentoCategoria;
import br.com.aluraflix.videos_api.model.video.DadosCadastroVideo;
import br.com.aluraflix.videos_api.model.video.DadosDetalhamentoVideo;
import br.com.aluraflix.videos_api.model.video.Video;
import br.com.aluraflix.videos_api.model.video.VideoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.util.UriComponentsBuilder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class VideosServiceTest {
    @InjectMocks
    private VideosService service;
    @Mock
    private Categoria categoria;
    @Mock
    private CategoriaRepository categoriaRepository;
    @Mock
    private VideoRepository videoRepository;
    @Mock
    private DadosCadastroVideo dadosCadastroVideo;
    @Mock
    private Video video;
    @Mock
    private DadosDetalhamentoVideo dadosDetalhamentoVideo;
    @Mock
    private DadosDetalhamentoCategoria dadosDetalhamentoCategoria;

    @Test
    void deveriasalvarvideo(){
        BDDMockito.given(categoriaRepository.getReferenceById(categoria.getId())).willReturn(categoria);
        service.cadastrarVideo(dadosCadastroVideo, UriComponentsBuilder.fromUriString("/videos"));
        then(videoRepository).should().save(new Video(dadosCadastroVideo.id(),categoria,dadosCadastroVideo.titulo(),dadosCadastroVideo.descricao(),dadosCadastroVideo.url()));
    }

    @Test
    void deletarVideo(){
        BDDMockito.given(videoRepository.getReferenceById(dadosDetalhamentoVideo.id())).willReturn(video);
        assertDoesNotThrow(() -> service.deletarPorId(video.getId()));
    }





}