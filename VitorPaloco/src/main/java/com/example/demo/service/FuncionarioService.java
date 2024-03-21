package com.example.demo.service;

import com.example.demo.model.Departamento;
import com.example.demo.model.Funcionario;
import com.example.demo.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    public List<Funcionario> listarFuncionarios() {
        return funcionarioRepository.findAll();
    }
    private boolean verificaID(Long id) {
        if(funcionarioRepository.existsById(id)) {
            return true;
        } else {
            return false;
        }
    }

    public Funcionario criar(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }
    public Funcionario atualizar(Funcionario funcionario, Long id) {
        if(verificaID(id)) {
            //verdadeiro
            funcionario.setId(id);
            return funcionarioRepository.save(funcionario);
        }
        return null;
    }
    public boolean deletar(Long id) {
        if(verificaID(id)) {
            funcionarioRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public long qtdFuncionarios() {
        return FuncionarioRepository.count();
    }




    @Autowired
    private FuncionarioRepository FuncionarioRepository;


}

