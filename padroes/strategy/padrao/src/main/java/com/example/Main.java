package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("\n=== EXECUÇÃO STRATEGY PADRÃO ===");
        
        // Simulação de diferentes tipos de clientes
        System.out.println("Cenário 1: Cliente Aposentado");
        Cliente c1 = new Cliente("João Aposentado", new Aprovado());
        c1.verificarEmprestimo();

        System.out.println("\nCenário 2: Cliente Estudante");
        Cliente c2 = new Cliente("Maria Estudante", new Negado());
        c2.verificarEmprestimo();
    }
}
