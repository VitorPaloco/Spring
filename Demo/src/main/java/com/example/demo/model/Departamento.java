package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Departamento {

    // Variaveis
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    @NotNull
    @Size(min = 2, max = 30)

    private String descricao;
    @Size(min = 2, max = 30)

    @OneToMany(mappedBy = "departamento")
    private List<Funcionario> funcionariosByDepartamento = new ArrayList<>();

    // Construct
    public Departamento() {
    }

    public Departamento(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    // GET AND SET
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Funcionario> getFuncionarios() { return funcionariosByDepartamento; }

    public void setFuncionarios(List<Funcionario> funcionarios) { this.funcionariosByDepartamento = funcionariosByDepartamento; }
}