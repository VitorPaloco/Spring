package com.example.demo.controller;

import com.example.demo.model.Departamento;
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

    @GetMapping("/{id}")
    public Optional<Departamento> buscarPorID(@PathVariable Long id) {
        return departamentoService.buscaPorID(id);
    }

    @GetMapping("/qtd")
    public int qtdDepartamentos() {
        return (int) departamentoService.qtdDepartamentos();
    }




    @PostMapping
    public Departamento criar(@Valid @RequestBody Departamento departamento) {
        return departamentoService.criar(departamento);
    }

    @PostMapping("/{idDepartamento}/adicionarFuncionario/{idFuncionario}")
    public ResponseEntity<?> adicionarFuncionarioDepartamento(@PathVariable Long idDepartamento, @PathVariable Long idFuncionario) {
        Departamento departamento = departamentoService.atribuirFuncionarioDepartamento(idDepartamento, idFuncionario);
        if (departamento != null) {
            String mensagem = "Funcionário adicionado ao departamento com sucesso.";
            return ResponseEntity.status(HttpStatus.OK).body(mensagem);
        } else {
            String mensagem;
            if (!departamentoService.verificaID(idDepartamento)) {
                mensagem = "O departamento com o ID " + idDepartamento + " não foi encontrado.";
            } else {
                mensagem = "O funcionário com o ID " + idFuncionario + " não foi encontrado.";
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
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
}
