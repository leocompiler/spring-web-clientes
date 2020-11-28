package test.surittec.leocompiler.client.MeusClientes.endpoint;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import test.surittec.leocompiler.client.MeusClientes.exception.ResourceNotFoundException;
import test.surittec.leocompiler.client.MeusClientes.model.Clientes;
import test.surittec.leocompiler.client.MeusClientes.repository.ClientesRepository;
import test.surittec.leocompiler.client.MeusClientes.repository.EnderecoRepository;
 


@RestController
public class ClienteController {
	private final ClientesRepository  clientesRepository;
	private final EnderecoRepository enderecoRepository;
	
	@Autowired
	public ClienteController( ClientesRepository  clientesRepository, EnderecoRepository enderecoRepository) {
		this.clientesRepository = clientesRepository;
		this.enderecoRepository = enderecoRepository;
	}
	
	@GetMapping("/clientes")
	public List<Clientes> getAllClientes( ){
		return clientesRepository.findAll();
	}
	
	@PostMapping("/clientes")
	public ResponseEntity<Clientes> createClientes( @Valid @RequestBody Clientes cliente) {
//		return clientesRepository.save( cliente ) ;
 
		Clientes resposta = clientesRepository.save(cliente);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(resposta.getId()).toUri();

        return ResponseEntity.created(location).body(resposta);
        
	}
	
	@GetMapping("/clientes/{id}")
	public Clientes getNoteById(@PathVariable(value = "id") Long noteId) {
	    return clientesRepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
	}
	

}
