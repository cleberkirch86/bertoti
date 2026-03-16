package com.example.padrao;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BookstoreGUI().display();
        });
    }
}
