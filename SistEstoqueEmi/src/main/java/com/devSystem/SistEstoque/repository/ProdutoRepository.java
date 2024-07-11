package com.devSystem.SistEstoque.repository;

import com.devSystem.SistEstoque.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
