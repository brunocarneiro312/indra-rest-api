package br.com.brunocarneiro.desafioindra.service;

import br.com.brunocarneiro.desafioindra.modelo.Endereco;

import java.util.List;

public interface EnderecoService {

    Endereco salvar(Endereco endereco);

    Endereco buscar(Long idEndereco);

    Endereco deletar(Long idEndereco);

    Endereco alterar(Endereco endereco);

    List<Endereco> listar();

}
