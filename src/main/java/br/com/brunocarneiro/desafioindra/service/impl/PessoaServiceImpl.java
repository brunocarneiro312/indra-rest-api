package br.com.brunocarneiro.desafioindra.service.impl;

import br.com.brunocarneiro.desafioindra.modelo.Pessoa;
import br.com.brunocarneiro.desafioindra.repository.PessoaRepository;
import br.com.brunocarneiro.desafioindra.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * -----------------
 * Serviço de Pessoa
 * -----------------
 * @author bruno.carneiro
 */
@Service
public class PessoaServiceImpl implements PessoaService {

    private PessoaRepository pessoaRepository;

    @Autowired
    public PessoaServiceImpl(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    /**
     * ------------
     * Salva Pessoa
     * ------------
     * @param pessoa
     * @return pessoa salva
     */
    @Override
    public Pessoa salvar(Pessoa pessoa) {
        if (isPessoaValida(pessoa)) {
            return this.pessoaRepository.save(pessoa);
        }
        return null;
    }

    /**
     * ------------
     * Busca pessoa
     * ------------
     * @param idPessoa
     * @return pessoa
     */
    @Override
    public Pessoa buscar(Long idPessoa) {
        if (idPessoa != null) {
            return this.pessoaRepository.findById(idPessoa).get();
        }
        return null;
    }

    /**
     * -------------
     * deleta pessoa
     * -------------
     * @param idPessoa
     * @return pessoa removida
     */
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

    /**
     * -------------
     * altera pessoa
     * -------------
     * @param pessoa
     * @return pessoa alterada
     */
    @Override
    public Pessoa alterar(Pessoa pessoa) {
        if (isPessoaValida(pessoa)) {
            return pessoaRepository.saveAndFlush(pessoa);
        }
        return null;
    }

    /**
     * ----------------------------------
     * lista todas as pessoas cadastradas
     * ----------------------------------
     * @return lista de pessoas
     */
    @Override
    public List<Pessoa> listar() {
        return pessoaRepository.findAll();
    }

    /**
     * -------------
     * Valida pessoa
     * -------------
     * @param pessoa
     * @return
     */
    private boolean isPessoaValida(Pessoa pessoa) {
        return pessoa.getNome() != null
                && pessoa.getSobrenome() != null
                && pessoa.getEmail() != null
                && pessoa.getEndereco() != null;
    }
}
