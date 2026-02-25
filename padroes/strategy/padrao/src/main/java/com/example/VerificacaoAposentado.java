package com.example;

public class VerificacaoAposentado implements VerificadorEmprestimo {
    @Override
    public void verificar(Cliente cliente) {
        new Aprovado().verificar(cliente);
    }
}
