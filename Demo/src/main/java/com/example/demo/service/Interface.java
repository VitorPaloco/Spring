package com.example.demo.service;
import java.util.List;
import java.util.Optional;

public interface Interface<T> {
    List<T> listar();
    T criar(T objeto);
    T atualizar(T objeto, Long id);
    boolean verificarPorID(Long id);
    boolean deletar(Long id);
    long qtd();
    Optional<T> buscaPorID(Long id);

}

