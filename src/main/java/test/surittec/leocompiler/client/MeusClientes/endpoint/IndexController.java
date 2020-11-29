package test.surittec.leocompiler.client.MeusClientes.endpoint;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import test.surittec.leocompiler.client.MeusClientes.repository.ClientesRepository;
 


@RestController
public class IndexController {
	private final ClientesRepository  clientesRepository;
 	
	@Autowired
	public IndexController( ClientesRepository  clientesRepository) {
		this.clientesRepository = clientesRepository;
 	}
	
	@GetMapping("/login")
	public Login auth( @AuthenticationPrincipal UserDetails userDetails ){
		List<String> list = new ArrayList<String>();
		for ( GrantedAuthority o : userDetails.getAuthorities()) {	
			list.add(o.getAuthority());
		}
		return new Login(userDetails.getUsername(),list) ;
	}
	 

	class Login {
		public String username;
		public List<String> authorities ;
		public Login(String username, List<String> list) {
			super();
			this.username = username;
			this.authorities = list;
		}
		
	}
}
