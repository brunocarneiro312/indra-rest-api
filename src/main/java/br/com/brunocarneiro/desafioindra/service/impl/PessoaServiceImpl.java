package br.com.brunocarneiro.desafioindra.service.impl;

import br.com.brunocarneiro.desafioindra.modelo.Pessoa;
import br.com.brunocarneiro.desafioindra.repository.PessoaRepository;
import br.com.brunocarneiro.desafioindra.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaServiceImpl implements PessoaService {

    private PessoaRepository pessoaRepository;

    @Autowired
    public PessoaServiceImpl(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public Pessoa salvar(Pessoa pessoa) {
        if (pessoaValida(pessoa)) {
            return this.pessoaRepository.save(pessoa);
        }
        return null;
    }

    @Override
    public Pessoa buscar(Long idPessoa) {
        if (idPessoa != null) {
            return this.pessoaRepository.findById(idPessoa).get();
        }
        return null;
    }

    @Override
    public Pessoa deletar(Long idPessoa) {

        if (idPessoa != null) {

            Pessoa pessoaASerRemovida = this.pessoaRepository.findById(idPessoa).get();

            if (pessoaASerRemovida != null) {
                pessoaRepository.delete(pessoaASerRemovida);
                return pessoaASerRemovida;
            }
        }

        return null;
    }

    @Override
    public Pessoa alterar(Pessoa pessoa) {

        if (pessoaValida(pessoa)) {
            return pessoaRepository.saveAndFlush(pessoa);
        }

        return null;
    }

    @Override
    public List<Pessoa> listar() {
        return pessoaRepository.findAll();
    }

    private boolean pessoaValida(Pessoa pessoa) {
        return pessoa.getNome() != null
                && pessoa.getSobrenome() != null
                && pessoa.getEmail() != null
                && pessoa.getEndereco() != null;
    }
}
