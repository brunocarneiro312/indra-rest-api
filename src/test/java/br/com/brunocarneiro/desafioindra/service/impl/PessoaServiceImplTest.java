package br.com.brunocarneiro.desafioindra.service.impl;

import br.com.brunocarneiro.desafioindra.modelo.Endereco;
import br.com.brunocarneiro.desafioindra.modelo.Pessoa;
import br.com.brunocarneiro.desafioindra.repository.PessoaRepository;
import br.com.brunocarneiro.desafioindra.service.PessoaService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class PessoaServiceImplTest {

    @Mock
    private PessoaRepository pessoaRepository;

    private PessoaService pessoaService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        pessoaService = new PessoaServiceImpl(pessoaRepository);
    }

    @Test
    public void salvarPessoaOK() {

        // given
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Carlos");
        pessoa.setSobrenome("Santos");
        pessoa.setEmail("carlos.santos@email.com");
        pessoa.setEndereco(new Endereco());

        // when
        Mockito.when(pessoaRepository.save(Mockito.any(Pessoa.class))).thenReturn(pessoa);
        Pessoa pessoaSalva = pessoaService.salvar(pessoa);

        // then
        Assert.assertNotNull(pessoaSalva);
    }

    @Test
    public void salvarPessoaComDadosNulos() {

        // given
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Carlos");
        pessoa.setSobrenome("Santos");
        pessoa.setEndereco(new Endereco());

        // when
        Mockito.when(pessoaRepository.save(Mockito.any(Pessoa.class))).thenReturn(pessoa);
        Pessoa pessoaSalva = pessoaService.salvar(pessoa);

        // then
        Assert.assertNull(pessoaSalva);
    }

    @Test
    public void alterarPessoaOK() {

        // given
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Carlos");
        pessoa.setSobrenome("Santos");
        pessoa.setEmail("carlos.santos@email.com");
        pessoa.setEndereco(new Endereco());

        // when
        Mockito.when(pessoaRepository.saveAndFlush(Mockito.any(Pessoa.class))).thenReturn(pessoa);
        Pessoa pessoaAlterada = pessoaService.alterar(pessoa);

        // then
        Assert.assertNotNull(pessoaAlterada);
    }

    @Test(expected = NullPointerException.class)
    public void alterarPessoaComDadosInvalidos() {

        // given
        Pessoa pessoa = null;

        // when
        Mockito.when(pessoaRepository.saveAndFlush(Mockito.any(Pessoa.class))).thenReturn(pessoa);
        Pessoa pessoaAlterada = pessoaService.alterar(pessoa);

        // then
        Assert.assertNull(pessoaAlterada);
    }

    @Test
    public void deletarPessoaOK() {

        // given
        Long idPessoa = 1L;
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Carlos");
        pessoa.setSobrenome("Santos");
        pessoa.setEmail("carlos.santos@email.com");
        pessoa.setEndereco(new Endereco());

        Optional<Pessoa> optionalPessoa = Optional.of(pessoa);

        // when
        Mockito.when(pessoaRepository.findById(idPessoa)).thenReturn(optionalPessoa);
        Pessoa pessoaRemovida = pessoaService.deletar(idPessoa);

        // then
        Assert.assertNotNull(pessoaRemovida);
    }

    @Test
    public void deletarPessoaComIdNulo() {

        // given
        Long idPessoa = null;
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Carlos");
        pessoa.setSobrenome("Santos");
        pessoa.setEmail("carlos.santos@email.com");
        pessoa.setEndereco(new Endereco());

        Optional<Pessoa> optionalPessoa = Optional.of(pessoa);

        // when
        Mockito.when(pessoaRepository.findById(idPessoa)).thenReturn(optionalPessoa);
        Pessoa pessoaRemovida = pessoaService.deletar(idPessoa);

        // then
        Assert.assertNull(pessoaRemovida);
    }

    @Test
    public void buscarPessoaOK() {

        // given
        Long pessoaId = 1L;

        Optional<Pessoa> optionalPessoa = Optional.of(new Pessoa());

        // when
        Mockito.when(pessoaRepository.findById(Mockito.anyLong())).thenReturn(optionalPessoa);
        Pessoa pessoaPesquisada = pessoaService.buscar(pessoaId);

        // then
        Assert.assertNotNull(pessoaPesquisada);

    }

    @Test
    public void buscarPessoaComIdNulo() {

        // given
        Long pessoaId = null;

        Optional<Pessoa> optionalPessoa = Optional.of(new Pessoa());

        // when
        Mockito.when(pessoaRepository.findById(Mockito.anyLong())).thenReturn(optionalPessoa);
        Pessoa pessoaPesquisada = pessoaService.buscar(pessoaId);

        // then
        Assert.assertNull(pessoaPesquisada);

    }

    @Test
    public void listarPessoasOK() {

        // given
        List<Pessoa> listaPessoas;

        // when
        Mockito.when(pessoaRepository.findAll()).thenReturn(Arrays.asList());
        listaPessoas = pessoaService.listar();

        // then
        Assert.assertNotNull(listaPessoas);

    }

}