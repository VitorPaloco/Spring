package com.example.demo.controller;

import com.example.demo.model.Departamento;
import com.example.demo.repository.DepartamentoRepository;
import com.example.demo.service.DepartamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

    @Autowired
    DepartamentoService departamentoService;

    @GetMapping
    public List<Departamento> listarDepartamentos() {
        return departamentoService.listarDepartamentos();
    }

    @PostMapping
    public Departamento criar(@Valid @RequestBody Departamento departamento) {
        return departamentoService.criar(departamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@RequestBody Departamento departamento, @PathVariable Long id) {
        //return departamentoService.atualizar(departamento, id);
        if(departamentoService.atualizar(departamento, id) == null) {
            //O id não foi encontrado
            //return ResponseEntity.notFound().build();
            String mensagem = "O id informado não existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
            //O id foi encontrado
            return ResponseEntity.ok(departamento);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        if(departamentoService.deletar(id)) {
            String mensagem = "O id " + id + " foi removido com sucesso.";
            return ResponseEntity.status(HttpStatus.OK).body(mensagem);
        } else {
            String mensagem = "O id informado não existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
    }

    @GetMapping("/qtd")
    public int qtdDepartamentos() {
        return (int) departamentoService.qtdDepartamentos();
    }
}
