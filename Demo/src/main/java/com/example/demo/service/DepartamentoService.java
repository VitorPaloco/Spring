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
public class DepartamentoService {

    @Autowired
    DepartamentoRepository departamentoRepository;
    @Autowired
    FuncionarioRepository funcionarioRepository;

    public List<Departamento> listarDepartamentos() {
        return departamentoRepository.findAll();
    }
    public boolean verificaID(Long id) {
        if(departamentoRepository.existsById(id)) {
            return true;
        } else {
            return false;
        }
    }

    public Departamento criar(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }
    public Departamento atualizar(Departamento departamento, Long id) {
        if(verificaID(id)) {
            //verdadeiro
            departamento.setId(id);
            return departamentoRepository.save(departamento);
        }
        return null;
    }

    public boolean deletar(Long id) {
        if(verificaID(id)) {
            departamentoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public long qtdDepartamentos() {
        return DepartamentoRepository.count();
    }

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





    @Autowired
    private DepartamentoRepository DepartamentoRepository;

}

