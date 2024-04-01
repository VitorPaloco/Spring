package com.example.demo.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa  {

    // Variaveis
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 30)
    @Column(nullable = false)
    private String nome;

    @NotNull
    @Size(min = 11, max = 14)
    @Column(nullable = false)
    private String cpf;

    @NotNull
    @Size(min = 8, max = 8)
    private int dataNascimento;

}
