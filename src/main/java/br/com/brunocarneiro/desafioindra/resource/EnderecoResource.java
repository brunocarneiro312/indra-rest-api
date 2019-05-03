package br.com.brunocarneiro.desafioindra.resource;

import br.com.brunocarneiro.desafioindra.modelo.Endereco;
import br.com.brunocarneiro.desafioindra.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class EnderecoResource {

    private EnderecoService enderecoService;

    @Autowired
    public EnderecoResource(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping(value = "/endereco/{idEndereco}")
    public ResponseEntity<Endereco> getEndereco(@PathVariable("idEndereco") Long idEndereco) {
        return null;
    }

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
