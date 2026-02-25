package com.example;

public class ClienteComum extends Cliente {

    public ClienteComum(String nome, String email) {
        super(nome, email);
    }

    @Override
    public double calcularEmprestimo() {
        throw new UnsupportedOperationException("Erro: Cliente comum não possui crédito.");
    }
}
