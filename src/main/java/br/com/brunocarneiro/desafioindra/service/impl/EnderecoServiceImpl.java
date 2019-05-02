package br.com.brunocarneiro.desafioindra.service.impl;

import br.com.brunocarneiro.desafioindra.modelo.Endereco;
import br.com.brunocarneiro.desafioindra.repository.EnderecoRepository;
import br.com.brunocarneiro.desafioindra.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * -------------------
 * Serviço de Endereco
 * -------------------
 * @author bruno.carneiro
 */
@Service
public class EnderecoServiceImpl implements EnderecoService {

    private EnderecoRepository enderecoRepository;

    @Autowired
    public EnderecoServiceImpl(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    /**
     * --------------
     * Salva endereço
     * --------------
     * @param endereco
     * @return endereço salvo
     */
    @Override
    public Endereco salvar(Endereco endereco) {
        if (isEnderecoValido(endereco)) {
            return this.enderecoRepository.save(endereco);
        }
        return null;
    }

    /**
     * --------------
     * Busca endereço
     * --------------
     * @param idEndereco
     * @return
     */
    @Override
    public Endereco buscar(Long idEndereco) {
        return this.enderecoRepository.findById(idEndereco).get();
    }

    /**
     * ---------------
     * Delete endereço
     * ---------------
     * @param idEndereco
     * @return endereço removido
     */
    @Override
    public Endereco deletar(Long idEndereco) {
        Endereco enderecoRemovido = this.enderecoRepository.findById(idEndereco).get();
        if (enderecoRemovido != null) {
            this.enderecoRepository.delete(enderecoRemovido);
        }
        return enderecoRemovido;
    }

    /**
     * ---------------
     * Altera endereço
     * ---------------
     * @param endereco
     * @return endereço alterado
     */
    @Override
    public Endereco alterar(Endereco endereco) {
        if (isEnderecoValido(endereco)) {
            return this.enderecoRepository.saveAndFlush(endereco);
        }
        return null;
    }

    /**
     * ------------------------
     * Lista todos os endereços
     * ------------------------
     * @return
     */
    @Override
    public List<Endereco> listar() {
        return this.enderecoRepository.findAll();
    }

    private boolean isEnderecoValido(Endereco endereco) {
        return endereco.getCep() != null
                && endereco.getCidade() != null
                && endereco.getBairro() != null
                && endereco.getLogradouro() != null;
    }
}
