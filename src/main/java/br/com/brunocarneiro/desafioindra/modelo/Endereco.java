package br.com.brunocarneiro.desafioindra.modelo;

import java.io.Serializable;

public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;

    public Endereco() {

    }

    public Endereco(Long id,
                    String cep,
                    String logradouro,
                    String bairro,
                    String cidade,
                    String complemento,
                    String uf) {

        this.id = id;
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
    }

    private Long id;
    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;
    private String complemento;
    private Pessoa pessoa;

}
