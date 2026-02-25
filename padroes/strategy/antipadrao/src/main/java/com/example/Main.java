package com.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Aposentado("João Silva", "joao.silva@example.com"));
        clientes.add(new ClienteComum("Maria Souza", "maria.souza@example.com"));
        clientes.add(new Estudante("Pedro Martins", "pedro.martins@example.com"));
        clientes.add(new Empresa("Tech Solutions Ltda", "contato@techsolutions.com"));

        System.out.println("\n--- Demonstração do Anti-Padrão ---");

        for (Cliente cliente : clientes) {
            System.out.println("\nProcessando cliente: " + cliente.getNome());
            try {
                // Tentamos chamar um método que só faz sentido para um dos clientes
                double emprestimo = cliente.calcularEmprestimo();
                System.out.println("Valor do empréstimo aprovado: R$ " + String.format("%.2f", emprestimo));
            } catch (UnsupportedOperationException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        System.out.println("\n--- Conclusao do Anti-Padrao ---");
        System.out.println("O codigo é forcado a usar try-catch para lidar com operacoes");
        System.out.println("que não se aplicam a todas as subclasses, violando o LSP (Liskov Substitution Principle).");
        System.out.println("A herança foi usada de forma inadequada, pois nem todo 'Cliente' pode ter um 'empréstimo'.");
        System.out.println("Uma solução melhor seria usar composição e interfaces (Padrão Strategy).");
    }
}
