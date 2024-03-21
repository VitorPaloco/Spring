package com.example.demo.service;

import com.example.demo.model.Departamento;
import com.example.demo.repository.DepartamentoRepository;
import com.example.demo.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    @Autowired
    DepartamentoRepository departamentoRepository;

    public List<Departamento> listarDepartamentos() {
        return departamentoRepository.findAll();
    }
    private boolean verificaID(Long id) {
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

    @Autowired
    private DepartamentoRepository DepartamentoRepository;

    public long qtdDepartamentos() {
        return DepartamentoRepository.count();
    }



}

