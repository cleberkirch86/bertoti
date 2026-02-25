package com.example;

public class Aposentado extends Cliente {

    public Aposentado(String nome, String email) {
        super(nome, email);
    }

    @Override
    public double calcularEmprestimo() {
        System.out.println("Calculando emprestimo: " + getNome());
        return 10000.00;
    }
}
