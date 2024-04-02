package com.example.demo.service;

import com.example.demo.model.Departamento;
import com.example.demo.model.Gerente;
import com.example.demo.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService implements Interface<Departamento> {

    @Autowired
    DepartamentoRepository departamentoRepository;

    @Override
    public List<Departamento> listar() {
        return departamentoRepository.findAll();
    }

    @Override
    public Departamento criar(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    @Override
    public Departamento atualizar(Departamento departamento, Long id) {
        if (verificarPorID(id)) {
            departamento.setId(id);
            return departamentoRepository.save(departamento);
        }
        return null;
    }

    @Override
    public boolean verificarPorID(Long id) {
        return departamentoRepository.existsById(id);
    }

    @Override
    public boolean deletar(Long id) {
        if (verificarPorID(id)) {
            departamentoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public long qtd() {
        return departamentoRepository.count();
    }

    @Override
    public Optional<Departamento> buscaPorID(Long id) {
        return departamentoRepository.findById(id);
    }

    @Override
    public Optional<Departamento> buscaPorNome(String nome) {
        return departamentoRepository.findByNome(nome);
    }
}

