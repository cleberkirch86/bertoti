package com.example;

public class VerificacaoClienteComum implements VerificadorEmprestimo {
    @Override
    public void verificar(Cliente cliente) {
        new Negado().verificar(cliente);
    }
}
