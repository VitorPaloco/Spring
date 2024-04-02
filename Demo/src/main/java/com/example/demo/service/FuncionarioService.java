package com.example.demo.service;

import com.example.demo.model.Funcionario;
import com.example.demo.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService implements Interface<Funcionario> {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Override
    public List<Funcionario> listar() {
        return funcionarioRepository.findAll();
    }

    @Override
    public Funcionario criar(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @Override
    public Funcionario atualizar(Funcionario funcionario, Long id) {
        if (verificarPorID(id)) {
            funcionario.setId(id);
            return funcionarioRepository.save(funcionario);
        }
        return null;
    }

    @Override
    public boolean verificarPorID(Long id) {
        return funcionarioRepository.existsById(id);
    }

    @Override
    public boolean deletar(Long id) {
        if (verificarPorID(id)) {
            funcionarioRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public long qtd() {
        return funcionarioRepository.count();
    }

    @Override
    public Optional<Funcionario> buscaPorID(Long id) {
        return funcionarioRepository.findById(id);
    }

    @Override
    public Optional<Funcionario> buscaPorNome(String nome) {
        return funcionarioRepository.findByNome(nome);
    }
}

