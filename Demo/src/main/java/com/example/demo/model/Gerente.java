package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
public class Gerente extends Funcionario {
    // Variaveis
    private String senha;
    @NotNull

    private int numFuncGerenciados;
    @NotNull
    @Min(value = 1)

    // Construct
    public Gerente() {
    }

    public Gerente(Long id, String nome, String cpf, int dataNascimento, double salario, String senha, int numFuncGerenciados) {
        super(id, nome, cpf, dataNascimento, salario);
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
