package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o tipo de cliente (aposentado, comum, estudante, empresa):");
        String tipoCliente = scanner.nextLine().toLowerCase();

        VerificadorEmprestimo verificador;

        switch (tipoCliente) {
            case "aposentado":
                verificador = new VerificacaoAposentado();
                break;
            case "comum":
                verificador = new VerificacaoClienteComum();
                break;
            case "estudante":
                verificador = new VerificacaoEstudante();
                break;
            case "empresa":
                verificador = new VerificacaoEmpresa();
                break;
            default:
                System.out.println("Tipo de cliente inválido.");
                return;
        }

        System.out.println("Digite o nome do cliente:");
        String nomeCliente = scanner.nextLine();

        Cliente cliente = new Cliente(nomeCliente, verificador);
        cliente.verificarEmprestimo();
        
        scanner.close();
    }
}
