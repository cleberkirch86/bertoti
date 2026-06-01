package com.example.composite.pattern;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static Departamento empresa = new Departamento("Empresa");

    public static void main(String[] args) {
        // Sample structure
        Departamento ti = new Departamento("TI");
        ti.adicionar(new Gerente("Carlos", 30000));
        ti.adicionar(new Desenvolvedor("Ana", 12000));
        ti.adicionar(new Desenvolvedor("Pedro", 12000));

        Departamento rh = new Departamento("RH");
        rh.adicionar(new Gerente("Maria", 25000));
        rh.adicionar(new Desenvolvedor("João", 10000));

        empresa.adicionar(ti);
        empresa.adicionar(rh);

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Adicionar Empregado");
            System.out.println("2. Adicionar Departamento");
            System.out.println("3. Mostrar Detalhes da Empresa");
            System.out.println("4. Calcular Salário Total da Empresa");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    adicionarEmpregado(scanner);
                    break;
                case 2:
                    adicionarDepartamento(scanner);
                    break;
                case 3:
                    mostrarDetalhes(empresa, 0);
                    break;
                case 4:
                    System.out.println("Salário total da empresa: " + empresa.getSalario());
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
        Departamento departamento = findDepartamento(empresa, nomeDepartamento);

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
            departamento.adicionar(new Desenvolvedor(nome, salario));
            System.out.println("Desenvolvedor adicionado.");
        } else if (tipo == 2) {
            departamento.adicionar(new Gerente(nome, salario));
            System.out.println("Gerente adicionado.");
        } else {
            System.out.println("Tipo de empregado inválido.");
        }
    }
    
    private static void adicionarDepartamento(Scanner scanner) {
        System.out.print("Nome do departamento pai: ");
        String nomeDepartamentoPai = scanner.nextLine();
        Departamento pai = findDepartamento(empresa, nomeDepartamentoPai);

        if (pai == null) {
            System.out.println("Departamento pai não encontrado.");
            return;
        }

        System.out.print("Nome do novo departamento: ");
        String nomeNovoDepartamento = scanner.nextLine();
        pai.adicionar(new Departamento(nomeNovoDepartamento));
        System.out.println("Departamento adicionado.");
    }

    private static Departamento findDepartamento(Departamento root, String nome) {
        if (root.getNome().equalsIgnoreCase(nome)) {
            return root;
        }
        for (Empregado e : root.getEmpregados()) {
            if (e instanceof Departamento) {
                Departamento d = findDepartamento((Departamento) e, nome);
                if (d != null) {
                    return d;
                }
            }
        }
        return null;
    }

    private static void mostrarDetalhes(Empregado empregado, int nivel) {
        for (int i = 0; i < nivel; i++) {
            System.out.print("  ");
        }

        if (empregado instanceof Departamento) {
            System.out.println("- Departamento: " + empregado.getNome());
            List<Empregado> subempregados = ((Departamento) empregado).getEmpregados();
            for (Empregado sub : subempregados) {
                mostrarDetalhes(sub, nivel + 1);
            }
        } else {
            System.out.print("- ");
            empregado.mostrarDetalhes();
        }
    }
}
