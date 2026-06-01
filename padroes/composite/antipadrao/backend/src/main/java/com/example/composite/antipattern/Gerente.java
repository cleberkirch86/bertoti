package com.example.composite.antipattern;

public class Gerente {
    private String nome;
    private double salario;

    public Gerente(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }
}
