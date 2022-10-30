package br.com.nikisgabriel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nikisgabriel.model.Cliente;
import br.com.nikisgabriel.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
	List<Pedido> findByCliente(Cliente cliente);
}
