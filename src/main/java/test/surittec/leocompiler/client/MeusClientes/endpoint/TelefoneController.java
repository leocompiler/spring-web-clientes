package test.surittec.leocompiler.client.MeusClientes.endpoint;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import test.surittec.leocompiler.client.MeusClientes.exception.ResourceNotFoundException;
import test.surittec.leocompiler.client.MeusClientes.model.Clientes;
import test.surittec.leocompiler.client.MeusClientes.model.Endereco;
import test.surittec.leocompiler.client.MeusClientes.model.Telefones;
import test.surittec.leocompiler.client.MeusClientes.repository.ClientesRepository;
import test.surittec.leocompiler.client.MeusClientes.repository.EnderecoRepository;
import test.surittec.leocompiler.client.MeusClientes.repository.TelefoneRepository;
 

@RestController
public class TelefoneController {
	private final ClientesRepository  clientesRepository;
	private final TelefoneRepository telefoneRepository;
	
	@Autowired
	public TelefoneController( ClientesRepository  clientesRepository, TelefoneRepository telefoneRepository) {
		this.clientesRepository = clientesRepository;
		this.telefoneRepository = telefoneRepository;
	}
	
	@GetMapping("/telefones")
	public List<Telefones> getAllClientes( ){
		return telefoneRepository.findAll();
	}
	
	@PostMapping("/telefones")
	public ResponseEntity<Telefones> createClientes( @Valid @RequestBody Telefones item) {
 		
		Telefones resposta = telefoneRepository.save(item);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(resposta.getId()).toUri();

        return ResponseEntity.created(location).body(resposta);
        
	}
	
	@GetMapping("/telefones/{id}")
	public Telefones getEnderecoById(@PathVariable(value = "id") Long id) {
	    return telefoneRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Note", "id", id));
	}
	

}
