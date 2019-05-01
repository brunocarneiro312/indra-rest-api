package br.com.brunocarneiro.desafioindra.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PESSOA")
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pessoa")
    @SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa", initialValue = 4)
    @Column(name = "ID_PESSOA")
    private Long id;

    @Column(name = "NOME", nullable = false)
    @Size(min = 2, max = 50)
    private String nome;

    @Column(name = "SOBRENOME", nullable = false)
    @Size(min = 2, max = 100)
    private String sobrenome;

    @Column(name = "EMAIL", unique = true, nullable = false)
    @Email
    private String email;

    @ManyToOne
    @JoinTable(name = "PESSOA_ENDERECO",
            joinColumns = @JoinColumn(name = "ID_PESSOA", referencedColumnName = "ID_PESSOA"),
            inverseJoinColumns = @JoinColumn(name = "ID_ENDERECO", referencedColumnName = "ID_ENDERECO"))
    private Endereco endereco;

}
