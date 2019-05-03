package br.com.brunocarneiro.desafioindra.resource;

import br.com.brunocarneiro.desafioindra.service.EnderecoService;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;

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

    public void testGetEnderecoOK() {

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