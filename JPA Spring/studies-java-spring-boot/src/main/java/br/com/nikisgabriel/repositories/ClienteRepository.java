package br.com.nikisgabriel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.nikisgabriel.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	// A interface repository disponibilizada pelo spring permite métodos
	// personalizados
	// Algumas query menos complexas podem ser criadas utilizando apenas o nome dos
	// métodos
	// find - indica ação
	// By - indica que será buscado por alguma características
	// Nome - em terceiro deve ser colocado o atributo / coluna a ser buscada
	// Containing - Indica a maneira de comparação usado em SQL
	List<Cliente> findByNomeContaining(String nome);

	// Exemplo de uma query complexa
	List<Cliente> findByNomeContainingOrIdOrderById(String nome, Integer id);

	Cliente findOneById(Integer id);

	// Criar uma query
	@Query("select c from Cliente c where c.nome like :nome")
	List<Cliente> encontrarPorNome(@Param("nome") String nome);

	// Criar uma com fetch
	@Query("select c from Cliente c left join fetch c.pedidos p where c.id = :id")
	Cliente encontrarPorIdFetchPedidos(@Param("id") Integer nome);
}
