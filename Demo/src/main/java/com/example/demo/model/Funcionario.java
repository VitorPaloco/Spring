package com.example.demo.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Funcionario extends Pessoa  {

    // Variaveis
    @NotNull
    @Min(value = 1500)
    @Max(value = 5000)
    private double salario;

    @NotNull
    @Min(value = 1)
    @Max(value = 5)
    private int departamentoPertencente;

    public Funcionario() {
    }

    public Funcionario(Long id, String nome, String cpf, int dataNascimento, double salario, int departamentoPertencente) {
        super(id, nome, cpf, dataNascimento);
        this.salario = salario;
        this.departamentoPertencente = departamentoPertencente;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getDepartamentoPertencente() {
        return departamentoPertencente;
    }

    public void setDepartamentoPertencente(int departamentoPertencente) {
        this.departamentoPertencente = departamentoPertencente;
    }
}
