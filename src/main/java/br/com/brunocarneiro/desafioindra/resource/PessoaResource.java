package br.com.brunocarneiro.desafioindra.resource;

import br.com.brunocarneiro.desafioindra.modelo.Pessoa;
import br.com.brunocarneiro.desafioindra.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class PessoaResource {

    private PessoaService pessoaService;

    @Autowired
    public PessoaResource(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("/pessoa/{idPessoa}")
    public ResponseEntity<Pessoa> getPessoa(@PathVariable("idPessoa") Long idPessoa) {

        Pessoa response = null;
        HttpStatus httpStatus;

        try {
            response = this.pessoaService.buscar(idPessoa);
            httpStatus = response != null
                    ? HttpStatus.OK
                    : HttpStatus.NO_CONTENT;
        }
        catch (Exception e) {
            httpStatus = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(response, httpStatus);
    }

    @PostMapping("/pessoa")
    public ResponseEntity<Pessoa> postPessoa(@RequestBody Pessoa pessoa) {

        Pessoa response = null;
        HttpStatus httpStatus;

        try {
            response = this.pessoaService.salvar(pessoa);
            httpStatus = response != null
                    ? HttpStatus.OK
                    : HttpStatus.NO_CONTENT;
        }
        catch (Exception e) {
            httpStatus = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(response, httpStatus);

    }

    @DeleteMapping("/pessoa/{idPessoa}")
    public ResponseEntity<Pessoa> deletePessoa(@PathVariable("idPessoa") Long idPessoa) {

        Pessoa response = null;
        HttpStatus httpStatus;

        try {
            response = this.pessoaService.deletar(idPessoa);
            httpStatus = response != null
                    ? HttpStatus.OK
                    : HttpStatus.NO_CONTENT;
        }
        catch (Exception e) {
            httpStatus = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(response, httpStatus);

    }

    @PutMapping("/pessoa")
    public ResponseEntity<Pessoa> putPessoa(@RequestBody Pessoa pessoa) {

        Pessoa response = null;
        HttpStatus httpStatus;

        try {
            response = this.pessoaService.alterar(pessoa);
            httpStatus = response != null
                    ? HttpStatus.OK
                    : HttpStatus.NO_CONTENT;
        }
        catch (Exception e) {
            httpStatus = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(response, httpStatus);

    }

    @GetMapping("/pessoa")
    public ResponseEntity<List<Pessoa>> listPessoas() {

        List<Pessoa> response = null;
        HttpStatus httpStatus;

        try {
            response = this.pessoaService.listar();
            httpStatus = response.size() > 0
                    ? HttpStatus.OK
                    : HttpStatus.NO_CONTENT;
        }
        catch (Exception e) {
            httpStatus = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(response, httpStatus);
    }

}
