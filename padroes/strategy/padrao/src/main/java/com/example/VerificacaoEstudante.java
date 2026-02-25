package com.example;

public class VerificacaoEstudante implements VerificadorEmprestimo {
    @Override
    public void verificar(Cliente cliente) {
        // Lógica de verificação para estudante
        new Negado().verificar(cliente);
    }
}
