package br.com.brunocarneiro.desafioindra.service.impl;

import br.com.brunocarneiro.desafioindra.modelo.Endereco;
import br.com.brunocarneiro.desafioindra.repository.EnderecoRepository;
import br.com.brunocarneiro.desafioindra.service.EnderecoService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.*;

public class EnderecoServiceImplTest {

    @Mock
    private EnderecoRepository enderecoRepository;

    private EnderecoService enderecoService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.enderecoService = new EnderecoServiceImpl(enderecoRepository);
    }

    @Test
    public void salvarEnderecoOK() {

        // given
        Endereco endereco = new Endereco();
        endereco.setCep("70765110");
        endereco.setLogradouro("SQN 312 BL K");
        endereco.setCidade("Brasília");
        endereco.setBairro("Asa Norte");
        endereco.setComplemento("102");

        // when
        Mockito.when(enderecoRepository.save(Mockito.any(Endereco.class))).thenReturn(endereco);
        Endereco enderecoSalvo = enderecoService.salvar(endereco);

        // then
        Assert.assertNotNull(enderecoSalvo);
    }

    @Test
    public void salvarEnderecoComDadosInvalidos() {

        // given
        Endereco endereco = new Endereco();
        endereco.setCep("70765110");
        endereco.setLogradouro("SQN 312 BL K");
        endereco.setBairro("Asa Norte");

        // when
        Mockito.when(enderecoRepository.save(Mockito.any(Endereco.class))).thenReturn(endereco);
        Endereco enderecoSalvo = enderecoService.salvar(endereco);

        // then
        Assert.assertNull(enderecoSalvo);

    }

    @Test
    public void deletarEnderecoOK() {

        // given
        Long enderecoId = 1L;
        Endereco endereco = new Endereco();

        Optional<Endereco> optionalEndereco = Optional.of(endereco);

        // when
        Mockito.when(enderecoRepository.findById(Mockito.anyLong())).thenReturn(optionalEndereco);
        Endereco enderecoRemovido = enderecoService.deletar(enderecoId);

        // then
        Assert.assertNotNull(enderecoRemovido);
    }

    @Test(expected = NoSuchElementException.class)
    public void deletarEnderecoIdNulo() {

        // given
        Long enderecoId = null;
        Endereco endereco = new Endereco();

        // when
        Endereco enderecoRemovido = enderecoService.deletar(enderecoId);

        // then Exception
    }

    @Test
    public void alterarEnderecoOK() {

        // given
        Endereco endereco = new Endereco();
        endereco.setCep("70765110");
        endereco.setLogradouro("SQN 312 BL K");
        endereco.setCidade("Brasília");
        endereco.setBairro("Asa Norte");
        endereco.setComplemento("102");

        // when
        Mockito.when(enderecoRepository.saveAndFlush(Mockito.any(Endereco.class))).thenReturn(endereco);
        Endereco enderecoAlterado = enderecoService.alterar(endereco);

        // then
        Assert.assertNotNull(enderecoAlterado);

    }

    @Test
    public void alterarEnderecoComDadosInvalidos() {

        // given
        Endereco endereco = new Endereco();
        endereco.setCep("70765110");
        endereco.setLogradouro("SQN 312 BL K");
        endereco.setCidade("Brasília");

        // when
        Mockito.when(enderecoRepository.saveAndFlush(Mockito.any(Endereco.class))).thenReturn(endereco);
        Endereco enderecoAlterado = enderecoService.alterar(endereco);

        // then
        Assert.assertNull(enderecoAlterado);
    }

    @Test
    public void buscarEnderecoOK() {

        // given
        Long idEndereco = 1L;
        Endereco endereco = new Endereco();
        Optional<Endereco> optionalEndereco = Optional.of(endereco);

        // when
        Mockito.when(enderecoRepository.findById(Mockito.anyLong())).thenReturn(optionalEndereco);
        Endereco enderecoPesquisado = enderecoService.buscar(idEndereco);

        // then
        Assert.assertNotNull(enderecoPesquisado);

    }

    @Test
    public void listarEnderecosOK() {

        // given
        List<Endereco> enderecos = null;

        // when
        Mockito.when(enderecoRepository.findAll()).thenReturn(new ArrayList<>());
        enderecos = enderecoService.listar();

        // then
        Assert.assertNotNull(enderecos);
    }

}