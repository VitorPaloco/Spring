package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Gerente extends Funcionario {

    @NotNull
    @Size(min = 5, max = 15)
    private String senha;

    @NotNull
    @Min(value = 1)
    private int numFuncGerenciados;

    public Gerente() {
    }

    public Gerente(Long id, String nome, String cpf, int dataNascimento, double salario, int departamentoPertencente, String senha, int numFuncGerenciados) {
        super(id, nome, cpf, dataNascimento, salario, departamentoPertencente);
        this.senha = senha;
        this.numFuncGerenciados = numFuncGerenciados;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getNumFuncGerenciados() {
        return numFuncGerenciados;
    }

    public void setNumFuncGerenciados(int numFuncGerenciados) {
        this.numFuncGerenciados = numFuncGerenciados;
    }
}
