package br.com.brunocarneiro.desafioindra.resource;

import br.com.brunocarneiro.desafioindra.modelo.Endereco;
import br.com.brunocarneiro.desafioindra.service.EnderecoService;
import com.fasterxml.jackson.databind.ObjectMapper;
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

public class EnderecoResourceTest {

    @Mock
    private EnderecoService enderecoService;

    private EnderecoResource enderecoResource;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        enderecoResource = new EnderecoResource(enderecoService);
        mockMvc = MockMvcBuilders.standaloneSetup(enderecoResource).build();
    }

    @Test
    public void testGetEnderecoOK() throws Exception {

        // when
        Mockito.when(enderecoService.buscar(Mockito.anyLong())).thenReturn(new Endereco());

        // then
        mockMvc.perform(get("/endereco")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    public void testPostEndereco200() throws Exception {

        // given
        ObjectMapper mapper = new ObjectMapper();
        String jsonEndereco = mapper.writeValueAsString(new Endereco());

        // when
        Mockito.when(enderecoService.salvar(Mockito.any(Endereco.class))).thenReturn(new Endereco());

        // then
        mockMvc.perform(post("/endereco")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(jsonEndereco))
                .andExpect(status().isOk());
        Mockito.verify(enderecoService, Mockito.times(1)).salvar(Mockito.any(Endereco.class));
    }

    @Test
    public void testPostEndereco204() throws Exception {

        // given
        ObjectMapper mapper = new ObjectMapper();
        String jsonEndereco = mapper.writeValueAsString(new Endereco());

        // when
        Mockito.when(enderecoService.salvar(Mockito.any(Endereco.class))).thenReturn(null);

        // then
        mockMvc.perform(post("/endereco")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(jsonEndereco))
                .andExpect(status().isNoContent());
        Mockito.verify(enderecoService, Mockito.times(1)).salvar(Mockito.any(Endereco.class));

    }

    @Test
    public void testPostEndereco4xx() throws Exception {

        // given
        ObjectMapper mapper = new ObjectMapper();

        // when
        Mockito.when(enderecoService.salvar(Mockito.any(Endereco.class))).thenReturn(null);

        // then
        mockMvc.perform(post("/endereco")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void testPutEndereco200() throws Exception {

        // given
        ObjectMapper mapper = new ObjectMapper();
        String jsonEndereco = mapper.writeValueAsString(new Endereco());

        // when
        Mockito.when(enderecoService.alterar(Mockito.any(Endereco.class))).thenReturn(new Endereco());

        // then
        mockMvc.perform(put("/endereco")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(jsonEndereco))
                .andExpect(status().isOk());
        Mockito.verify(enderecoService, Mockito.times(1)).alterar(Mockito.any(Endereco.class));

    }

    @Test
    public void testPutEndereco204() throws Exception {

        // given
        ObjectMapper mapper = new ObjectMapper();
        String jsonEndereco = mapper.writeValueAsString(new Endereco());

        // when
        Mockito.when(enderecoService.alterar(Mockito.any(Endereco.class))).thenReturn(null);

        // then
        mockMvc.perform(put("/endereco")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(jsonEndereco))
                .andExpect(status().isNoContent());
        Mockito.verify(enderecoService, Mockito.times(1)).alterar(Mockito.any(Endereco.class));

    }

    @Test
    public void testPutEndereco4xx() throws Exception {

        // when
        Mockito.when(enderecoService.alterar(Mockito.any(Endereco.class))).thenReturn(null);

        // then
        mockMvc.perform(put("/endereco")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testDeleteEndereco200() throws Exception {

        // when
        Mockito.when(enderecoService.deletar(Mockito.anyLong())).thenReturn(new Endereco());

        // then
        mockMvc.perform(delete("/endereco/{idEndereco}", 1L)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
        Mockito.verify(enderecoService, Mockito.times(1)).deletar(Mockito.anyLong());
    }

    @Test
    public void testDeleteEndereco204() throws Exception {

        // when
        Mockito.when(enderecoService.deletar(Mockito.anyLong())).thenReturn(null);

        // then
        mockMvc.perform(delete("/endereco/{idEndereco}", 1L)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isNoContent());
        Mockito.verify(enderecoService, Mockito.times(1)).deletar(Mockito.anyLong());
    }

    @Test
    public void testListEnderecos200() throws Exception {

        // when
        Mockito.when(enderecoService.listar()).thenReturn(Arrays.asList(new Endereco()));

        // then
        mockMvc.perform(get("/endereco")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
        Mockito.verify(enderecoService, Mockito.times(1)).listar();
    }
}