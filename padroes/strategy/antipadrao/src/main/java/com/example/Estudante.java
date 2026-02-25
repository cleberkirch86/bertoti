package com.example;

// Cliente Estudante - Forçado a implementar um método que não usa
public class Estudante extends Cliente {

    public Estudante(String nome, String email) {
        super(nome, email);
    }

    @Override
    public double calcularEmprestimo() {
        // Este cliente não tem direito a empréstimo.
        throw new UnsupportedOperationException("Estudante não tem direito a empréstimo.");
    }
}
