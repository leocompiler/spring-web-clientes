package test.surittec.leocompiler.client.MeusClientes.endpoint;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	@RequestMapping("/clientes")
	public String clientes( ) {
		return "index";
	}

}
