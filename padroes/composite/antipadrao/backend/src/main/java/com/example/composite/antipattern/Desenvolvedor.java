package com.example.composite.antipattern;

public class Desenvolvedor {
    private String nome;
    private double salario;

    public Desenvolvedor(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }
}
