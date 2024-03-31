package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Funcionario extends Pessoa  {

    // Variaveis

    private double salario;

    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    // Construct
    public Funcionario() {
    }

    public Funcionario(Long id, String nome, String cpf, int dataNascimento, double salario) {
        super(id, nome, cpf, dataNascimento);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

}
