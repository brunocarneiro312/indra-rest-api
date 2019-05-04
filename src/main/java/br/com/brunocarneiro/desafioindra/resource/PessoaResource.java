package br.com.brunocarneiro.desafioindra.resource;

import br.com.brunocarneiro.desafioindra.modelo.Pessoa;
import br.com.brunocarneiro.desafioindra.service.PessoaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(value = "Busca um endereço pelo id", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pessoa encontrado"),
            @ApiResponse(code = 204, message = "Pessoa não encontrado")
    })
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

    @ApiOperation(value = "Salva uma pessoa", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pessoa cadastrada com sucesso"),
            @ApiResponse(code = 400 , message = "Erro durante cadastro de pessoa")
    })
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

    @ApiOperation(value = "Remove uma pessoa pelo id", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pessoa removida com sucesso"),
            @ApiResponse(code = 400 , message = "Erro durante remoção de pessoa")
    })
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

    @ApiOperation(value = "Altera uma pessoa", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pessoa alterada com sucesso"),
            @ApiResponse(code = 400 , message = "Erro durante alteração de endereço")
    })
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

    @ApiOperation(value = "Lista todas as pessoas cadastradas", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Listagem efetuada com sucesso"),
            @ApiResponse(code = 204, message = "Não há pessoas a serem listadas"),
            @ApiResponse(code = 400 , message = "Erro durante listagem de pessoas")
    })
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
