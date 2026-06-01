package com.example.antipattern;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import javax.swing.SwingUtilities;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Main.class)
                .headless(false)
                .run(args);

        SwingUtilities.invokeLater(() -> {
            new BookstoreGUI().display();
        });
    }
}
