package com.example.demo.repository;

import com.example.demo.model.Funcionario;
import com.example.demo.model.Gerente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GerenteRepository extends JpaRepository<Gerente, Long> {
    Optional<Gerente> findByNome(String nome);
}
