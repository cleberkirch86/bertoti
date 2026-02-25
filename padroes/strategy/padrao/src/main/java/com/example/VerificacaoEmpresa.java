package com.example;

public class VerificacaoEmpresa implements VerificadorEmprestimo {
    @Override
    public void verificar(Cliente cliente) {
        // Lógica de verificação para empresa
        new Negado().verificar(cliente);
    }
}
