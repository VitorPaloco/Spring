package com.example.demo.controller;

import com.example.demo.model.Gerente;
import com.example.demo.repository.GerenteRepository;
import com.example.demo.service.GerenteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gerentes")
public class GerenteController {

    @Autowired
    GerenteService gerenteService;

    @GetMapping
    public List<Gerente> listarGerentes() {
        return gerenteService.listarGerentes();
    }

    @PostMapping
    public Gerente criar(@Valid @RequestBody Gerente gerente) {
        return gerenteService.criar(gerente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@RequestBody Gerente gerente, @PathVariable Long id) {
        //return funcionarioService.atualizar(funcionario, id);
        if(gerenteService.atualizar(gerente, id) == null) {
            //O id não foi encontrado
            //return ResponseEntity.notFound().build();
            String mensagem = "O id informado não existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
            //O id foi encontrado
            return ResponseEntity.ok(gerente);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        if(gerenteService.deletar(id)) {
            String mensagem = "O id " + id + " foi removido com sucesso.";
            return ResponseEntity.status(HttpStatus.OK).body(mensagem);
        } else {
            String mensagem = "O id informado não existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
    }

    @GetMapping("/qtd")
    public int qtdGerentes() {
        return (int) gerenteService.qtdGerentes();
    }

    @GetMapping("/{id}/senha")
    public ResponseEntity<String> visualizarSenha(@PathVariable Long id) {
        String senha = gerenteService.visualizarSenha(id);
        if (senha != null) {
            return ResponseEntity.ok(senha);
        } else {
            String mensagem = "O id " + id + " foi removido com sucesso.";
            return ResponseEntity.status(HttpStatus.OK).body(mensagem);
        }
    }

}
