package com.example.antipattern;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EditorWithoutPattern {

    private String currentFile;
    private final boolean loggingEnabled = true;
    private final String logFile = "/var/log/app.log";
    private final boolean emailEnabled = true;
    private final String adminEmail = "admin@empresa.com";
    private final boolean auditEnabled = true;

    public void openFile(String path) {
        this.currentFile = path;
        System.out.printf("%n=== Editor: abrindo arquivo '%s' ===%n", path);

        if (loggingEnabled) {
            System.out.printf("[LOG -> %s] Alguém abriu o arquivo: %s%n", logFile, currentFile);
        }

        if (auditEnabled) {
            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            System.out.printf("[AUDIT] %s | Evento: OPEN     | Arquivo: %s%n",
                    timestamp, currentFile);
        }
    }

    public void saveFile() {
        if (currentFile == null) {
            throw new IllegalStateException("Nenhum arquivo aberto.");
        }
        System.out.printf("%n=== Editor: salvando arquivo '%s' ===%n", currentFile);

        if (emailEnabled) {
            System.out.printf("[EMAIL -> %s] Atenção: arquivo modificado -> %s%n",
                    adminEmail, currentFile);
        }

        if (auditEnabled) {
            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            System.out.printf("[AUDIT] %s | Evento: SAVE     | Arquivo: %s%n",
                    timestamp, currentFile);
        }
    }

    public void closeFile() {
        if (currentFile == null) {
            throw new IllegalStateException("Nenhum arquivo aberto.");
        }
        System.out.printf("%n=== Editor: fechando arquivo '%s' ===%n", currentFile);

        if (auditEnabled) {
            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            System.out.printf("[AUDIT] %s | Evento: CLOSE    | Arquivo: %s%n",
                    timestamp, currentFile);
        }
        this.currentFile = null;
    }
}
