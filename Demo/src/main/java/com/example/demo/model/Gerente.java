package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
public class Gerente extends Funcionario {
    // Variaveis
    @NotNull
    private String senha;

    @NotNull
    @Min(value = 1)
    private int numFuncGerenciados;

}
