package br.com.brunocarneiro.desafioindra.resource;

import br.com.brunocarneiro.desafioindra.modelo.Pessoa;
import br.com.brunocarneiro.desafioindra.service.PessoaService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PessoaResourceTest {

    private PessoaResource pessoaResource;

    @Mock
    private PessoaService pessoaService;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        pessoaResource = new PessoaResource(pessoaService);
    }

    @Test
    public void testGetPessoa200() throws Exception {

        // given
        mockMvc = MockMvcBuilders.standaloneSetup(pessoaResource).build();

        // when
        Mockito.when(pessoaService.listar()).thenReturn(Arrays.asList(new Pessoa()));

        // then
        mockMvc.perform(get("/pessoa")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
        Mockito.verify(pessoaService, Mockito.times(1)).listar();
    }

    @Test
    public void testGetPessoa204() throws Exception {

        // given
        mockMvc = MockMvcBuilders.standaloneSetup(pessoaResource).build();

        // when
        Mockito.when(pessoaService.listar()).thenReturn(Arrays.asList());

        // then
        mockMvc.perform(get("/pessoa")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isNoContent());
        Mockito.verify(pessoaService, Mockito.times(1)).listar();
    }

    @Test
    public void testGetPessoa4xx() throws Exception {

        // given
        mockMvc = MockMvcBuilders.standaloneSetup(pessoaResource).build();

        // when
        Mockito.when(pessoaService.listar()).thenReturn(null);

        // then
        mockMvc.perform(get("/pessoa")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().is4xxClientError());
        Mockito.verify(pessoaService, Mockito.times(1)).listar();
    }

    @Test
    public void testPutPessoa200() throws Exception {

        // given
        mockMvc = MockMvcBuilders.standaloneSetup(pessoaResource).build();

        // when
        Mockito.when(pessoaService.alterar(Mockito.any(Pessoa.class))).thenReturn(new Pessoa());

        // then
        mockMvc.perform(put("/pessoa")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
        Mockito.verify(pessoaService, Mockito.times(1)).alterar(Mockito.any(Pessoa.class));
    }

    @Test
    public void testPutPessoa4xx() throws Exception {

        // given
        mockMvc = MockMvcBuilders.standaloneSetup(pessoaResource).build();

        // when
        Mockito.when(pessoaService.alterar(Mockito.any(Pessoa.class))).thenReturn(null);

        // then
        mockMvc.perform(put("/pessoa")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().is4xxClientError());
        Mockito.verify(pessoaService, Mockito.times(1)).alterar(Mockito.any(Pessoa.class));
    }

    @Test
    public void testDeletePessoa200() throws Exception {

        // given
        mockMvc = MockMvcBuilders.standaloneSetup(pessoaResource).build();

        // when
        Mockito.when(pessoaService.deletar(Mockito.anyLong())).thenReturn(new Pessoa());

        // then
        mockMvc.perform(delete("/pessoa")
                .param("idPessoa", "1")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
        Mockito.verify(pessoaService, Mockito.times(1)).deletar(Mockito.anyLong());
    }

    @Test
    public void testDeletePessoa4xx() throws Exception {

        // given
        mockMvc = MockMvcBuilders.standaloneSetup(pessoaResource).build();

        // when
        Mockito.when(pessoaService.deletar(Mockito.anyLong())).thenReturn(new Pessoa());

        // then
        mockMvc.perform(delete("/pessoa")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().is4xxClientError());
        Mockito.verify(pessoaService, Mockito.times(1)).deletar(Mockito.anyLong());
    }

}