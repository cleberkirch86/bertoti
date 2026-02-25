package com.example;

public class VerificacaoClienteComum implements VerificadorEmprestimo {
    @Override
    public void verificar(Cliente cliente) {
        // Lógica de verificação para cliente comum
        new Negado().verificar(cliente);
    }
}
