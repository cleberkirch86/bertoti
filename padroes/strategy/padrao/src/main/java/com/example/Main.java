package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Sistema de Crédito ---");
        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();
        
        System.out.print("Tipo do cliente (aposentado, comum, estudante, empresa): ");
        String tipo = scanner.nextLine().toLowerCase();

        // A "Única classe" (Main/Factory) que decide se pode ou não pode
        VerificadorEmprestimo strategy;
        if (tipo.equals("aposentado")) {
            strategy = new Aprovado();
        } else {
            strategy = new Negado();
        }

        Cliente cliente = new Cliente(nome, strategy);
        cliente.verificarEmprestimo();
        
        scanner.close();
    }
}
