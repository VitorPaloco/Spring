package com.example.demo.repository;

import com.example.demo.model.Gerente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GerenteRepository extends JpaRepository<Gerente, Long> {
}
