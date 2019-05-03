package br.com.brunocarneiro.desafioindra.resource;

import br.com.brunocarneiro.desafioindra.modelo.Endereco;
import br.com.brunocarneiro.desafioindra.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return null;
    }

    @PutMapping("/endereco")
    public ResponseEntity<Endereco> putEndereco(@RequestBody Endereco endereco) {
        return null;
    }

    @DeleteMapping("/endereco")
    public ResponseEntity<Endereco> deleteEndereco(@PathVariable("idEndereco") Long idEndereco) {
        return null;
    }

    @GetMapping("/endereco")
    public ResponseEntity<List<Endereco>> listEnderecos() {
        return null;
    }
}
