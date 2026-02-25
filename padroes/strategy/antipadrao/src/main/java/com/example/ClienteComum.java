package com.example;

// Cliente Comum - Forçado a implementar um método que não usa
public class ClienteComum extends Cliente {

    public ClienteComum(String nome, String email) {
        super(nome, email);
    }

    @Override
    public double calcularEmprestimo() {
        // Este cliente não tem direito a empréstimo.
        // Lançar exceção ou retornar zero são sinais do anti-padrão.
        throw new UnsupportedOperationException("Cliente comum não tem direito a empréstimo.");
    }
}
