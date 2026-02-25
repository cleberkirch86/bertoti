package com.example;

public class Empresa extends Cliente {

    public Empresa(String nome, String email) {
        super(nome, email);
    }

    @Override
    public double calcularEmprestimo() {
        throw new UnsupportedOperationException("Erro: Empresa sem permissao de emprestimo.");
    }
}
