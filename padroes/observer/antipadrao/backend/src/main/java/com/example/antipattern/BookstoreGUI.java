package com.example.antipattern;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BookstoreGUI {
    private final JTextArea logArea = new JTextArea(15, 40);
    private final JTextField titleField = new JTextField(20);
    private final JTextField priceField = new JTextField(10);

    public void display() {
        JFrame frame = new JFrame("Livraria (Antipadrao - Fixo)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        // Painel de entrada
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        inputPanel.add(new JLabel("Título do Livro:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Preço:"));
        inputPanel.add(priceField);

        JButton addButton = new JButton("Adicionar Livro");
        addButton.addActionListener(e -> addBook());
        inputPanel.add(addButton);

        // Área de Log
        logArea.setEditable(false);
        logArea.setBackground(new Color(240, 240, 240));
        
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(logArea), BorderLayout.CENTER);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void addBook() {
        String title = titleField.getText();
        String price = priceField.getText();

        if (title.isEmpty() || price.isEmpty()) return;

        logArea.append("\n=== Processando Livro: " + title + " ===\n");

        // Logica de notificacao hardcoded dentro da UI/Negocio
        // Simula Estoque
        logArea.append("[ESTOQUE] Livro '" + title + "' adicionado ao inventário.\n");
        
        // Simula Marketing
        logArea.append("[MARKETING] Newsletter enviada para clientes interessados em '" + title + "'.\n");

        // Simula Log de Auditoria
        String ts = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        logArea.append("[AUDIT] " + ts + " | Livro inserido no sistema.\n");

        titleField.setText("");
        priceField.setText("");
    }
}
