package com.example;

public class VerificacaoAposentado implements VerificadorEmprestimo {
    @Override
    public void verificar(Cliente cliente) {
        // Lógica de verificação para aposentado
        new Aprovado().verificar(cliente);
    }
}
