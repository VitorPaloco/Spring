package com.example.demo.controller;

import com.example.demo.model.Departamento;
import com.example.demo.model.Gerente;
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
        return departamentoService.listar();
    }
    @GetMapping("/{id}")
    public Optional<Departamento> buscarPorID(@PathVariable Long id) {
        return departamentoService.buscaPorID(id);
    }
    @GetMapping("/qtd")
    public int qtdDepartamentos() {
        return (int) departamentoService.qtd();
    }

    @PostMapping
    public Departamento criar(@Valid @RequestBody Departamento departamento) {
        return departamentoService.criar(departamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@RequestBody Departamento departamento, @PathVariable Long id) {
        if(departamentoService.atualizar(departamento, id) == null) {
            String mensagem = "O id informado não existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
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

    @GetMapping("/{nome}")
    public Optional<Departamento> buscaPorNome(@PathVariable String nome) { return departamentoService.buscaPorNome(nome); }
}
