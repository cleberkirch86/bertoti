package com.example.antipattern;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Configura o visual do sistema
        SwingUtilities.invokeLater(() -> {
            new BookstoreGUI().display();
        });
    }
}
