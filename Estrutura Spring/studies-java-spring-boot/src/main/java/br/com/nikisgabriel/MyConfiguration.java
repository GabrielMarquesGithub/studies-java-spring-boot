package br.com.nikisgabriel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// annotation @Profile define que alguma config será utilizada em um ambiente especifico
// @Profile("development") 
public class MyConfiguration {

	// esse objeto será criado no contexto da aplicação para poder ser usado em toda a aplicação 
	@Bean(name = "applicationName") // o atributo name é utilizado para identificar o Bean		
	public String applicationName() {
		return "vim da configuration";
	}
}
