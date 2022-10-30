package br.com.nikisgabriel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nikisgabriel.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {}
