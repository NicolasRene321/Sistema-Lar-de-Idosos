package com.devSystem.SistEstoque.repository;

import com.devSystem.SistEstoque.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
