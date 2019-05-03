package br.com.brunocarneiro.desafioindra.resource;

import br.com.brunocarneiro.desafioindra.modelo.Endereco;
import br.com.brunocarneiro.desafioindra.service.EnderecoService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
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
    }

    @Test
    public void testGetEnderecoOK() throws Exception {

        // given
        mockMvc = MockMvcBuilders.standaloneSetup(enderecoResource).build();

        // when
        Mockito.when(enderecoService.buscar(Mockito.anyLong())).thenReturn(new Endereco());

        // then
        mockMvc.perform(get("/endereco")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    public void testPostEnderecoOK() {

    }

    public void testPutEnderecoOK() {

    }

    public void testDeleteEnderecoOK() {

    }

    public void testListEnderecosOK() {

    }
}