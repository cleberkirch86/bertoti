package com.example;

public class Estudante extends Cliente {

    public Estudante(String nome, String email) {
        super(nome, email);
    }

    @Override
    public double calcularEmprestimo() {
        throw new UnsupportedOperationException("Erro: Estudante sem credito.");
    }
}
