package com.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Aposentado("João Silva", "joao.silva@email.com"));
        clientes.add(new ClienteComum("Maria Souza", "maria.souza@email.com"));
        clientes.add(new Estudante("Pedro Martins", "pedro.martins@email.com"));
        clientes.add(new Empresa("Empresa X", "contato@empresax.com"));

        for (Cliente c : clientes) {
            System.out.println("Cliente: " + c.getNome());
            try {
                double valor = c.calcularEmprestimo();
                System.out.println("Emprestimo: " + valor);
            } catch (UnsupportedOperationException e) {
                System.err.println(e.getMessage());
            }
            System.out.println("-------------------------");
        }
    }
}
