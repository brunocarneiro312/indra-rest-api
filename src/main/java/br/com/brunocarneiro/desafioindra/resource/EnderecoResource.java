package br.com.brunocarneiro.desafioindra.resource;

import br.com.brunocarneiro.desafioindra.modelo.Endereco;
import br.com.brunocarneiro.desafioindra.modelo.Pessoa;
import br.com.brunocarneiro.desafioindra.service.EnderecoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "API de endereço")
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class EnderecoResource {

    private EnderecoService enderecoService;

    @Autowired
    public EnderecoResource(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @ApiOperation(value = "Busca um endereço pelo id", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Endereço encontrado"),
            @ApiResponse(code = 204, message = "Endereço não encontrado"),
            @ApiResponse(code = 400 , message = "Erro durante cadastro de endereço")
    })
    @GetMapping(value = "/endereco/{idEndereco}")
    public ResponseEntity<Endereco> getEndereco(@PathVariable("idEndereco") Long idEndereco) {

        Endereco response = null;
        HttpStatus httpStatus;

        try {
            response = this.enderecoService.buscar(idEndereco);
            httpStatus = response != null
                    ? HttpStatus.OK
                    : HttpStatus.NO_CONTENT;
        }
        catch (Exception e) {
            httpStatus = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(response, httpStatus);

    }

    @ApiOperation(value = "Salva um endereço")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Endereço salvo com sucesso"),
            @ApiResponse(code = 400 , message = "Erro durante cadastro de endereço")
    })
    @PostMapping("/endereco")
    public ResponseEntity<Endereco> postEndereco(@RequestBody Endereco endereco) {

        Endereco response = null;
        HttpStatus httpStatus;

        try {
            response = this.enderecoService.salvar(endereco);
            httpStatus = response != null
                    ? HttpStatus.OK
                    : HttpStatus.NO_CONTENT;
        }
        catch(Exception e) {
            httpStatus = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(response, httpStatus);
    }

    @ApiOperation(value = "Altera um enderço")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Endereço alterado com sucesso"),
            @ApiResponse(code = 400 , message = "Erro durante atualização de endereço")
    })
    @PutMapping("/endereco")
    public ResponseEntity<Endereco> putEndereco(@RequestBody Endereco endereco) {

        Endereco response = null;
        HttpStatus httpStatus;

        try {
            response = this.enderecoService.alterar(endereco);
            httpStatus = response != null
                    ? HttpStatus.OK
                    : HttpStatus.NO_CONTENT;
        }
        catch(Exception e) {
            httpStatus = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(response, httpStatus);
    }

    @ApiOperation(value = "Remove um endereço")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Endereço removido com sucesso"),
            @ApiResponse(code = 400 , message = "Erro durante remoção de endereço")
    })
    @DeleteMapping("/endereco/{idEndereco}")
    public ResponseEntity<Endereco> deleteEndereco(@PathVariable("idEndereco") Long idEndereco) {

        Endereco response = null;
        HttpStatus httpStatus;

        try {
            response = this.enderecoService.deletar(idEndereco);
            httpStatus = response != null
                    ? HttpStatus.OK
                    : HttpStatus.NO_CONTENT;
        }
        catch(Exception e) {
            httpStatus = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(response, httpStatus);

    }

    @ApiOperation(value = "Lista todos os endereços cadastrados")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Endereços listados com sucesso"),
            @ApiResponse(code = 204, message = "Não há endereços a serem listados"),
            @ApiResponse(code = 400 , message = "Erro durante listagem de endereço")
    })
    @GetMapping("/endereco")
    public ResponseEntity<List<Endereco>> listEnderecos() {

        List<Endereco> response = null;
        HttpStatus httpStatus;

        try {
            response = this.enderecoService.listar();
            httpStatus = response != null
                    ? HttpStatus.OK
                    : HttpStatus.NO_CONTENT;
        }
        catch(Exception e) {
            httpStatus = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(response, httpStatus);

    }
}
