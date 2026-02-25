package com.example;

// Classe base para todos os clientes
public abstract class Cliente {
    private String nome;
    private String email;

    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    // Método de empréstimo que não se aplica a todos os clientes (ANTI-PADRÃO)
    public abstract double calcularEmprestimo();
}
