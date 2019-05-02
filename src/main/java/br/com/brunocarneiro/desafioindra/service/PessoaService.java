package br.com.brunocarneiro.desafioindra.service;

import br.com.brunocarneiro.desafioindra.modelo.Pessoa;

import java.util.List;

public interface PessoaService {

    Pessoa salvar(Pessoa endereco);

    Pessoa buscar(Long idPessoa);

    Pessoa deletar(Long idPessoa);

    Pessoa alterar(Pessoa pessoa);

    List<Pessoa> listar();

}
