package com.example.demo.service;

import com.example.demo.model.Departamento;
import com.example.demo.model.Funcionario;
import com.example.demo.repository.DepartamentoRepository;
import com.example.demo.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService implements Interface<Departamento> {

    @Autowired
    DepartamentoRepository departamentoRepository;
    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Override
    public List<Departamento> listar() {
        return departamentoRepository.findAll();
    }
    @Override
    public boolean verificarPorID(Long id) {
        return departamentoRepository.existsById(id);
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
    public Departamento atribuirFuncionarioDepartamento(Long idDepartamento, Long idFuncionario) {
        Optional<Departamento> optionalDepartamento = departamentoRepository.findById(idDepartamento);
        Optional<Funcionario> optionalFuncionario = funcionarioRepository.findById(idFuncionario);

        if (optionalDepartamento.isPresent() && optionalFuncionario.isPresent()) {
            Departamento departamento = optionalDepartamento.get();
            Funcionario funcionario = optionalFuncionario.get();

            // Define o departamento para o funcionário
            funcionario.setDepartamento(departamento);
            funcionarioRepository.save(funcionario);

            return departamento;
        }

        return null; // Ou lança uma exceção indicando que o departamento ou funcionário não foi encontrado
    }

}

