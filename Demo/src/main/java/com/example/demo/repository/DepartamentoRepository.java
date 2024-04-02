package com.example.demo.repository;

import com.example.demo.model.Departamento;
import com.example.demo.model.Gerente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartamentoRepository extends JpaRepository<Departamento,Long> {
    Optional<Departamento> findByNome(String nome);
}
