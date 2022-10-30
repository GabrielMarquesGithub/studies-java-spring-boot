package br.com.nikisgabriel;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import br.com.nikisgabriel.model.Cliente;
import br.com.nikisgabriel.model.Pedido;
import br.com.nikisgabriel.repositories.ClienteRepository;
import br.com.nikisgabriel.repositories.PedidoRepository;

//annotation para especificar classe de inicialização do spring
@SpringBootApplication
// @RestController basicamente diz que essa classe se comunica com o browser
@RestController // vem no pacote spring web
//@RequestMapping(path = "teste") para definir um prefixo padrão ao controller
public class VendasApplication {

	// a maneira extensa para chamar método
	@Bean
	public CommandLineRunner init(@Autowired ClienteRepository repository, @Autowired PedidoRepository repository2) {
		return args -> {
			Cliente c1 = new Cliente("Gabriel");
			Cliente c2 = new Cliente("Leonardo");
			Cliente c3 = new Cliente("Pablão");

			repository.save(c1);
			repository.save(c2);
			repository.save(c3);

			Pedido p1 = new Pedido();
			p1.setCliente(c3);
			p1.setDataPedido(new Date());
			p1.setTotal(new BigDecimal(2000.50));

			repository2.save(p1);
			
			Pedido p2 = new Pedido();
			p2.setCliente(c3);
			p2.setDataPedido(new Date());
			p2.setTotal(new BigDecimal(1550.50));

			repository2.save(p2);

			repository2.findByCliente(c3).forEach(p -> System.out.println(p.getTotal()));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
