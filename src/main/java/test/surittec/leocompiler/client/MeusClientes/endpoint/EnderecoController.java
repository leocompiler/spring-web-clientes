package test.surittec.leocompiler.client.MeusClientes.endpoint;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import test.surittec.leocompiler.client.MeusClientes.exception.ResourceNotFoundException;
import test.surittec.leocompiler.client.MeusClientes.model.Clientes;
import test.surittec.leocompiler.client.MeusClientes.model.Endereco;
import test.surittec.leocompiler.client.MeusClientes.repository.ClientesRepository;
import test.surittec.leocompiler.client.MeusClientes.repository.EnderecoRepository;
 


@RestController
public class EnderecoController {
	private final ClientesRepository  clientesRepository;
	private final EnderecoRepository enderecoRepository;
	
	@Autowired
	public EnderecoController( ClientesRepository  clientesRepository, EnderecoRepository enderecoRepository) {
		this.clientesRepository = clientesRepository;
		this.enderecoRepository = enderecoRepository;
	}
	
	@GetMapping("/enderecos")
	public List<Endereco> getAllClientes( ){
		return enderecoRepository.findAll();
	}
	
	@PostMapping("/enderecos")
	public ResponseEntity<Endereco> createClientes( @Valid @RequestBody Endereco endereco) {
 		
		Endereco resposta = enderecoRepository.save(endereco);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(resposta.getId()).toUri();

        return ResponseEntity.created(location).body(resposta);
        
	}
	
	@GetMapping("/enderecos/{id}")
	public Endereco getEnderecoById(@PathVariable(value = "id") Long enderecoId) {
	    return enderecoRepository.findById(enderecoId).orElseThrow(() -> new ResourceNotFoundException("Note", "id", enderecoId));
	}
	

}
