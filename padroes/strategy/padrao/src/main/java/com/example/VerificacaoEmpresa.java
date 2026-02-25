package com.example;

public class VerificacaoEmpresa implements VerificadorEmprestimo {
    @Override
    public void verificar(Cliente cliente) {
        new Negado().verificar(cliente);
    }
}
