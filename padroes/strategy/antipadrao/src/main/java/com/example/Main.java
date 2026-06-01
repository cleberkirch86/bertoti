package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        Cliente cliente = null;

        do {
            System.out.println("\n--- Strategy Antipattern Menu ---");
            System.out.println("1. Criar Cliente");
            System.out.println("2. Calcular Empréstimo");
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
                        try {
                            double valor = cliente.calcularEmprestimo();
                            System.out.println("Emprestimo: " + valor);
                        } catch (UnsupportedOperationException e) {
                            System.err.println("ERRO: " + e.getMessage());
                        }
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
        System.out.print("Tipo de cliente (1. Aposentado, 2. Cliente Comum, 3. Estudante, 4. Empresa): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Email do cliente: ");
        String email = scanner.nextLine();

        switch (tipo) {
            case 1:
                return new Aposentado(nome, email);
            case 2:
                return new ClienteComum(nome, email);
            case 3:
                return new Estudante(nome, email);
            case 4:
                return new Empresa(nome, email);
            default:
                System.out.println("Tipo de cliente inválido.");
                return null;
        }
    }
}
