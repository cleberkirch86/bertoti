package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Main implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("\n=== EXECUÇÃO STRATEGY ANTIPADRÃO ===");
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
                System.err.println("ERRO: " + e.getMessage());
            }
            System.out.println("-------------------------");
        }
    }
}
