package com.example.demo.service;

import com.example.demo.model.Funcionario;
import com.example.demo.model.Gerente;
import com.example.demo.repository.FuncionarioRepository;
import com.example.demo.repository.GerenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class GerenteService {

    @Autowired
    GerenteRepository gerenteRepository;

    public List<Gerente> listarGerentes() {
        return gerenteRepository.findAll();
    }
    private boolean verificaID(Long id) {
        if(gerenteRepository.existsById(id)) {
            return true;
        } else {
            return false;
        }
    }

    public Gerente criar(Gerente gerente) {
        return gerenteRepository.save(gerente);
    }
    public Gerente atualizar(Gerente gerente, Long id) {
        if(verificaID(id)) {
            //verdadeiro
            gerente.setId(id);
            return gerenteRepository.save(gerente);
        }
        return null;
    }
    public boolean deletar(Long id) {
        if(verificaID(id)) {
            gerenteRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public long qtdGerentes() {
        return gerenteRepository.count();
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


