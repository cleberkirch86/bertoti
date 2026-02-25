package com.example;

// Cliente Empresa - Forçado a implementar um método que não usa
public class Empresa extends Cliente {

    public Empresa(String nome, String email) {
        super(nome, email);
    }

    @Override
    public double calcularEmprestimo() {
        // Este cliente não tem direito a empréstimo.
        throw new UnsupportedOperationException("Empresa não tem direito a empréstimo.");
    }
}
