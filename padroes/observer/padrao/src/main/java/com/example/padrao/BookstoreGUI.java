package com.example.padrao;

import com.example.padrao.observer.BookEventListener;
import com.example.padrao.observer.BookEventManager;

import javax.swing.*;
import java.awt.*;

public class BookstoreGUI {
    private final BookEventManager events = new BookEventManager();
    private final JTextArea logArea = new JTextArea(15, 40);
    private final JTextField titleField = new JTextField(20);

    public void display() {
        JFrame frame = new JFrame("Livraria (Padrao - Flexivel)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        // Painel de entrada
        JPanel inputPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel bookData = new JPanel(new FlowLayout(FlowLayout.LEFT));
        bookData.add(new JLabel("Livro:"));
        bookData.add(titleField);
        inputPanel.add(bookData);

        // Painel de Assinaturas (Checkboxes)
        JPanel subscribePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        subscribePanel.add(new JLabel("Notificar:"));
        
        JCheckBox stockBox = createSubscriberBox("Estoque", "[ESTOQUE] Atualizando inventario para: ");
        JCheckBox marketingBox = createSubscriberBox("Marketing", "[MARKETING] Newsletter enviada: ");
        
        subscribePanel.add(stockBox);
        subscribePanel.add(marketingBox);
        inputPanel.add(subscribePanel);

        JButton addButton = new JButton("Adicionar Livro");
        addButton.addActionListener(e -> {
            String title = titleField.getText();
            if (!title.isEmpty()) {
                logArea.append("\n--- Evento Gerado: " + title + " ---\n");
                events.notify("new_book", title);
                titleField.setText("");
            }
        });
        inputPanel.add(addButton);

        // Área de Log
        logArea.setEditable(false);
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(logArea), BorderLayout.CENTER);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JCheckBox createSubscriberBox(String label, String prefix) {
        JCheckBox box = new JCheckBox(label);
        BookEventListener listener = (type, title) -> logArea.append(prefix + title + "\n");
        
        box.addActionListener(e -> {
            if (box.isSelected()) {
                events.subscribe("new_book", listener);
            } else {
                events.unsubscribe("new_book", listener);
            }
        });
        return box;
    }
}
