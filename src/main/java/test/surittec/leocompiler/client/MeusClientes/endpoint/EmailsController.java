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
import test.surittec.leocompiler.client.MeusClientes.model.Emails;
import test.surittec.leocompiler.client.MeusClientes.model.Endereco;
import test.surittec.leocompiler.client.MeusClientes.model.Telefones;
import test.surittec.leocompiler.client.MeusClientes.repository.ClientesRepository;
import test.surittec.leocompiler.client.MeusClientes.repository.EmailsRepository;
import test.surittec.leocompiler.client.MeusClientes.repository.EnderecoRepository;
import test.surittec.leocompiler.client.MeusClientes.repository.TelefoneRepository;
 


@RestController
public class EmailsController {
	private final ClientesRepository  clientesRepository;
	private final EmailsRepository emailRepository;
	
	@Autowired
	public EmailsController( ClientesRepository  clientesRepository, EmailsRepository emailRepository) {
		this.clientesRepository = clientesRepository;
		this.emailRepository = emailRepository;
	}
	
	@GetMapping("/emails")
	public List<Emails> getAllClientes( ){
		return emailRepository.findAll();
	}
	
	@PostMapping("/emails")
	public ResponseEntity<Emails> createClientes( @Valid @RequestBody Emails item) {
 		
		Emails resposta = emailRepository.save(item);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(resposta.getId()).toUri();

        return ResponseEntity.created(location).body(resposta);
        
	}
	
	@GetMapping("/emails/{id}")
	public Emails getEnderecoById(@PathVariable(value = "id") Long id) {
	    return emailRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Note", "id", id));
	}
	

}
