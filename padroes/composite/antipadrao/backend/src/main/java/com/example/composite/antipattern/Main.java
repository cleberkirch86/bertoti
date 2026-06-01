package com.example.composite.antipattern;

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
        Departamento ti = new Departamento("TI");
        
        ti.addGerente(new Gerente("Alice", 10000));
        ti.addDesenvolvedor(new Desenvolvedor("Bob", 5000));
        ti.addDesenvolvedor(new Desenvolvedor("Charlie", 6000));

        System.out.println("\n=== EXECUÇÃO COMPOSITE ANTIPADRÃO ===");
        System.out.println("Total da folha de pagamento do departamento " + ti.calcularFolhaPagamento());
    }
}
