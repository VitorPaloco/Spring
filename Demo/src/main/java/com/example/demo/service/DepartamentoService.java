package com.example.demo.service;

import com.example.demo.model.Departamento;
import com.example.demo.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public long qtdDepartamentos() {
        return DepartamentoRepository.count();
    }

    public Optional<Departamento> buscaPorID(Long id) {
        return departamentoRepository.findById(id);
    }

    @Autowired
    private DepartamentoRepository DepartamentoRepository;
}

