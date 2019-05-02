package br.com.brunocarneiro.desafioindra.repository;

import br.com.brunocarneiro.desafioindra.modelo.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
