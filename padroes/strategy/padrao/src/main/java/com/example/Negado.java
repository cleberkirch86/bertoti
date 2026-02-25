package com.example;

public class Negado implements VerificadorEmprestimo {
    @Override
    public void verificar(Cliente cliente) {
        System.out.println("Empréstimo negado para: " + cliente.getNome());
    }
}
