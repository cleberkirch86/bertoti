package com.example;

// Concrete Strategy
public class Aprovado implements VerificadorEmprestimo {
    @Override
    public void verificar(Cliente cliente) {
        System.out.println("Empréstimo aprovado para " + cliente.getNome());
    }
}
