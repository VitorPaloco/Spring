package com.example.demo.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Funcionario extends Pessoa  {

    // Variaveis

    @Min(value = 1500)
    @Max(value = 5000)
    private double salario;

    @NotNull
    @Min(value = 1)
    @Max(value = 5)
    private int departamentoPertencente;

    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;


}
