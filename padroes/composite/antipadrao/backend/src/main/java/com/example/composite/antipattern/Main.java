package com.example.composite.antipattern;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<String, Departamento> departamentos = new HashMap<>();

    public static void main(String[] args) {
        // Sample structure
        Departamento ti = new Departamento("TI");
        ti.addGerente(new Gerente("Alice", 10000));
        ti.addDesenvolvedor(new Desenvolvedor("Bob", 5000));
        ti.addDesenvolvedor(new Desenvolvedor("Charlie", 6000));
        departamentos.put("TI", ti);

        Departamento rh = new Departamento("RH");
        rh.addGerente(new Gerente("Maria", 9000));
        rh.addDesenvolvedor(new Desenvolvedor("David", 4000));
        departamentos.put("RH", rh);


        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Menu (Antipadrão) ---");
            System.out.println("1. Adicionar Empregado");
            System.out.println("2. Calcular Folha de Pagamento de Departamento");
            System.out.println("3. Criar Novo Departamento");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    adicionarEmpregado(scanner);
                    break;
                case 2:
                    calcularFolhaPagamento(scanner);
                    break;
                case 3:
                    criarDepartamento(scanner);
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

    private static void adicionarEmpregado(Scanner scanner) {
        System.out.print("Nome do departamento: ");
        String nomeDepartamento = scanner.nextLine();
        Departamento departamento = departamentos.get(nomeDepartamento);

        if (departamento == null) {
            System.out.println("Departamento não encontrado.");
            return;
        }

        System.out.print("Tipo de empregado (1. Desenvolvedor, 2. Gerente): ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Nome do empregado: ");
        String nome = scanner.nextLine();
        System.out.print("Salário do empregado: ");
        double salario = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        if (tipo == 1) {
            departamento.addDesenvolvedor(new Desenvolvedor(nome, salario));
            System.out.println("Desenvolvedor adicionado.");
        } else if (tipo == 2) {
            departamento.addGerente(new Gerente(nome, salario));
            System.out.println("Gerente adicionado.");
        } else {
            System.out.println("Tipo de empregado inválido.");
        }
    }

    private static void calcularFolhaPagamento(Scanner scanner) {
        System.out.print("Nome do departamento: ");
        String nomeDepartamento = scanner.nextLine();
        Departamento departamento = departamentos.get(nomeDepartamento);

        if (departamento == null) {
            System.out.println("Departamento não encontrado.");
            return;
        }

        System.out.println("Folha de pagamento do departamento " + nomeDepartamento + ": " + departamento.calcularFolhaPagamento());
    }

    private static void criarDepartamento(Scanner scanner) {
        System.out.print("Nome do novo departamento: ");
        String nomeDepartamento = scanner.nextLine();
        if (departamentos.containsKey(nomeDepartamento)) {
            System.out.println("Departamento já existe.");
        } else {
            departamentos.put(nomeDepartamento, new Departamento(nomeDepartamento));
            System.out.println("Departamento " + nomeDepartamento + " criado.");
        }
    }
}
