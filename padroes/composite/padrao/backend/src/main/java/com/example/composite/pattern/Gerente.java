package com.example.composite.pattern;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("gerente")
public class Gerente implements Empregado {
    private String nome;
    private double salario;

    public Gerente(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public double getSalario() {
        return salario;
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("Gerente: " + nome + " | Salário: " + salario);
    }
}
