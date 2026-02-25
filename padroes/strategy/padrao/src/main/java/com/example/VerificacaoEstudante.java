package com.example;

public class VerificacaoEstudante implements VerificadorEmprestimo {
    @Override
    public void verificar(Cliente cliente) {
        new Negado().verificar(cliente);
    }
}
