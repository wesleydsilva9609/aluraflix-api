package br.com.aluraflix.videos_api.controller;

import br.com.aluraflix.videos_api.service.CategoriaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@SpringBootTest
@AutoConfigureMockMvc
class CategoriaControllerTest {
    @MockBean
    private CategoriaService service;
    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("deveria Retornar erro 400 se informção estiver incorreta")
    @WithMockUser
    void cadastrarCategoriacaso1() throws Exception {

        var response = mvc.perform(post("/categoria").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertEquals(400,response.getStatus());
    }

    @Test
    @DisplayName("deveria cadastrar categoria")
    @WithMockUser
    void cadastrarCategoria() throws Exception {

        var json = """
                {
                	"titulo": "MUSICA",
                	"cor": "#4b42f5"
                }
                """;

        var response = mvc.perform(post("/categoria").contentType(MediaType.APPLICATION_JSON).content(json)).andReturn().getResponse();

        assertEquals(200,response.getStatus());
    }

    @Test
    @WithMockUser
    void deveriaBuscarCategoriaPorId() throws Exception {

        var id = 1;

        var response = mvc.perform(get("/categoria/{id}",id).contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertEquals(200,response.getStatus());
    }

    @Test
    @WithMockUser
    void deveriaListarCategoria() throws Exception {
        MockHttpServletResponse response = mvc.perform(get("/categoria").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertEquals(200,response.getStatus());
    }

    @Test
    @WithMockUser
    void deveriaDeletarCategoriaPorId() throws Exception {

        var id = 1;

        var response = mvc.perform(delete("/categoria/{id}",id).contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertEquals(200,response.getStatus());
    }

    @Test
    @WithMockUser
    void deveriaAtualizarCategoria() throws Exception {

        var json = """
                {
                	"titulo": "MUSICA"
                	
                }
                """;

        var response = mvc.perform(put("/categoria").contentType(MediaType.APPLICATION_JSON).content(json)).andReturn().getResponse();

        assertEquals(200,response.getStatus());
    }

    @Test
    @WithMockUser
    void deveriaBuscarVideoPorCategoria() throws Exception {
        var id = 1;

        MockHttpServletResponse response = mvc.perform(get("/categoria/{id}/videos",id).contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertEquals(200,response.getStatus());
    }


}