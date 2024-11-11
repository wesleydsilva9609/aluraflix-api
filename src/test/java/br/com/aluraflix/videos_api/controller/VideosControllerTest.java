package br.com.aluraflix.videos_api.controller;

import br.com.aluraflix.videos_api.model.categoria.Categoria;
import br.com.aluraflix.videos_api.model.categoria.CategoriaRepository;
import br.com.aluraflix.videos_api.model.video.Video;
import br.com.aluraflix.videos_api.model.video.VideoRepository;
import br.com.aluraflix.videos_api.service.VideosService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
class VideosControllerTest {
    @MockBean
    private VideosService service;
    @Autowired
    private MockMvc mvc;
    @Mock
    private Video video;


    @Test
    @DisplayName("deveria Retornar erro 400 se informção estiver incorreta")
    void cadastrarVideoacaso1() throws Exception {

        var response = mvc.perform(post("/videos").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertEquals(400,response.getStatus());
    }

    @Test
    @DisplayName("deveria cadastrar o video")
    void cadastrarVideo() throws Exception {
        var json = """
                {	
                	"categoriaid": 2,
                	"titulo": "Nirvana",
                	"descricao": "rape me",
                	"url": "https://www.youtube.com/watch?v=VXAwcZ13M80"	
                }
                """;

        var response = mvc.perform(post("/videos").content(json).contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertEquals(200,response.getStatus());
    }

    @Test
    void BuscarVideoPorId() throws Exception {
        var id = 1;
        var response = mvc.perform(get("/videos/{id}",id).contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();
        assertEquals(200,response.getStatus());
    }

    @Test
    void listarVideos() throws Exception {

        var response = mvc.perform(get("/videos/").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();
        assertEquals(200,response.getStatus());
    }

    @Test
    void DeletarVideoPorId() throws Exception {
        var id = 1;
        var response = mvc.perform(delete("/videos/{id}",id).contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();
        assertEquals(200,response.getStatus());
    }

    @Test
    void atualizarVideo() throws Exception {
        var json = """
                {	
                	"categoriaid": 2,
                	"titulo": "Nirvana",
                	"descricao": "rape me",
                	"url": "https://www.youtube.com/watch?v=VXAwcZ13M80"	
                }
                """;

        var response = mvc.perform(put("/videos").content(json).contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertEquals(200,response.getStatus());
    }

    @Test
    void buscarVideoPorNome() throws Exception {
        var titulo = "nirvana";
        var response = mvc.perform(get("/videos/?search=",titulo).contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();
        assertEquals(200,response.getStatus());
    }



}