package com.example.demo.service;

import com.example.demo.model.Funcionario;
import com.example.demo.model.Gerente;
import com.example.demo.repository.GerenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GerenteService implements Interface<Gerente> {

    @Autowired
    GerenteRepository gerenteRepository;

    @Override
    public List<Gerente> listar() {
        return gerenteRepository.findAll();
    }

    @Override
    public Gerente criar(Gerente gerente) {
        return gerenteRepository.save(gerente);
    }

    @Override
    public Gerente atualizar(Gerente gerente, Long id) {
        if (verificarPorID(id)) {
            gerente.setId(id);
            return gerenteRepository.save(gerente);
        }
        return null;
    }

    @Override
    public boolean verificarPorID(Long id) {
        return gerenteRepository.existsById(id);
    }

    @Override
    public boolean deletar(Long id) {
        if (verificarPorID(id)) {
            gerenteRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public long qtd() {
        return gerenteRepository.count();
    }

    @Override
    public Optional<Gerente> buscaPorID(Long id) {
        return gerenteRepository.findById(id);
    }

    @Override
    public Optional<Gerente> buscaPorNome(String nome) {
        return gerenteRepository.findByNome(nome);
    }

    public String visualizarSenha(Long id) {
        Optional<Gerente> gerenteOptional = gerenteRepository.findById(id);
        if (gerenteOptional.isPresent()) {
            Gerente gerente = gerenteOptional.get();
            return gerente.getSenha();
        } else {
            return null;
        }
    }
}

