package com.devSystem.SistEstoque.repository;

import com.devSystem.SistEstoque.model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
    Optional<Estoque> findByNomeProduto(String nomeProduto);
}
