package br.com.nikisgabriel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//annotation para especificar classe de inicialização do spring
@SpringBootApplication
// @RestController basicamente diz que essa classe se comunica com o browser
@RestController // vem no pacote spring web
//@RequestMapping(path = "teste") para definir um prefixo padrão ao controller
public class VendasApplication {
	
	@Autowired
	@Qualifier("applicationName") // busca o Bean identificado por essa name
	private String byConfiguration;
	
	@Value("${valor.test:default value}") // maneira de buscar valores do .properties
	private String byProperties;

	// a maneira extensa para chamar método
	@RequestMapping(method = RequestMethod.GET, path = "/hello")
	public String helloWorld() {
		return "Hello World! " + byConfiguration + " " + byProperties;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
