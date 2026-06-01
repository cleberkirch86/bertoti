package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        Cliente cliente = null;

        do {
            System.out.println("\n--- Strategy Pattern Menu ---");
            System.out.println("1. Criar Cliente e Definir Estratégia de Empréstimo");
            System.out.println("2. Verificar Empréstimo");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    cliente = criarCliente(scanner);
                    break;
                case 2:
                    if (cliente != null) {
                        cliente.verificarEmprestimo();
                    } else {
                        System.out.println("Crie um cliente primeiro.");
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static Cliente criarCliente(Scanner scanner) {
        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();

        System.out.print("Estratégia de empréstimo (1. Aprovado, 2. Negado): ");
        int estrategiaChoice = scanner.nextInt();
        scanner.nextLine(); 

        VerificadorEmprestimo estrategia;
        if (estrategiaChoice == 1) {
            estrategia = new Aprovado();
        } else {
            estrategia = new Negado();
        }

        System.out.println("Cliente criado com a estratégia definida.");
        return new Cliente(nome, estrategia);
    }
}
