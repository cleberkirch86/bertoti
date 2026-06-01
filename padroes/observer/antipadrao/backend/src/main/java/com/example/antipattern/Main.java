package com.example.antipattern;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EditorWithoutPattern editor = new EditorWithoutPattern();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Editor Events Menu (Antipadrão) ---");
            System.out.println("1. Open File");
            System.out.println("2. Save File");
            System.out.println("3. Close File");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter file path to open: ");
                    String openPath = scanner.nextLine();
                    editor.openFile(openPath);
                    break;
                case 2:
                    try {
                        editor.saveFile();
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                     try {
                        editor.closeFile();
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
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
}
