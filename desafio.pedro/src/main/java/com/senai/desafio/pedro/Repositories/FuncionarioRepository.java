package com.senai.desafio.pedro.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.senai.desafio.pedro.entities.Funcionarios;

public interface FuncionarioRepository extends JpaRepository<Funcionarios, Long>{
	@Query("SELECT f FROM Funcionario f WHERE LOWER(f.funnome) LIKE LOWER(CONCAT('%', :funnome, '%'))")
	List<Funcionarios> findByNomeContaining(@Param("funnome") String funnome);
}
