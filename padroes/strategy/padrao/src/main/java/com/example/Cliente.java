package com.example;

// Contexto que utiliza a Strategy
public class Cliente {
    private String nome;
    private VerificadorEmprestimo verificador;

    public Cliente(String nome, VerificadorEmprestimo verificador) {
        this.nome = nome;
        this.verificador = verificador;
    }

    public String getNome() {
        return nome;
    }

    public void verificarEmprestimo() {
        verificador.verificar(this);
    }
}
