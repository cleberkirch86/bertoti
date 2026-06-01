package com.example.padrao;

import com.example.padrao.publisher.Editor;
import com.example.padrao.subscriber.EmailListener;
import com.example.padrao.subscriber.EventListener;
import com.example.padrao.subscriber.LogListener;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();
        Map<String, EventListener> listeners = new HashMap<>();
        listeners.put("email1", new EmailListener("admin@example.com"));
        listeners.put("log1", new LogListener("app.log"));

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Editor Events Menu ---");
            System.out.println("1. Subscribe Listener");
            System.out.println("2. Unsubscribe Listener");
            System.out.println("3. Open File");
            System.out.println("4. Save File");
            System.out.println("5. Close File");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    manageSubscription(scanner, editor, listeners, true);
                    break;
                case 2:
                    manageSubscription(scanner, editor, listeners, false);
                    break;
                case 3:
                    System.out.print("Enter file path to open: ");
                    String openPath = scanner.nextLine();
                    editor.openFile(openPath);
                    break;
                case 4:
                    editor.saveFile();
                    break;
                case 5:
                    editor.closeFile();
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

    private static void manageSubscription(Scanner scanner, Editor editor, Map<String, EventListener> listeners, boolean subscribe) {
        System.out.print("Enter listener name (email1, log1): ");
        String listenerName = scanner.nextLine();
        EventListener listener = listeners.get(listenerName);

        if (listener == null) {
            System.out.println("Listener não encontrado.");
            return;
        }

        System.out.print("Enter event type (open, save, close): ");
        String eventType = scanner.nextLine();

        if (subscribe) {
            editor.events.subscribe(eventType, listener);
        } else {
            editor.events.unsubscribe(eventType, listener);
        }
    }
}
