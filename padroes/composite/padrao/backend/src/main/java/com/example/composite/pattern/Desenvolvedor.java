package com.example.composite.pattern;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("desenvolvedor")
public class Desenvolvedor implements Empregado {
    private String nome;
    private double salario;

    public Desenvolvedor(String nome, double salario) {
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
        System.out.println("Desenvolvedor: " + nome + " | Salário: " + salario);
    }
}
