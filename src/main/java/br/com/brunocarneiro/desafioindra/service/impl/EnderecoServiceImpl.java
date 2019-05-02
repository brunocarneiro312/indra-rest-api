package br.com.brunocarneiro.desafioindra.service.impl;

import br.com.brunocarneiro.desafioindra.modelo.Endereco;
import br.com.brunocarneiro.desafioindra.repository.EnderecoRepository;
import br.com.brunocarneiro.desafioindra.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    private EnderecoRepository enderecoRepository;

    @Autowired
    public EnderecoServiceImpl(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public Endereco salvar(Endereco endereco) {
        return null;
    }

    @Override
    public Endereco buscar(Long idEndereco) {
        return null;
    }

    @Override
    public Endereco deletar(Long idEndereco) {
        return null;
    }

    @Override
    public Endereco alterar(Endereco endereco) {
        return null;
    }

    @Override
    public List<Endereco> listar() {
        return null;
    }
}
