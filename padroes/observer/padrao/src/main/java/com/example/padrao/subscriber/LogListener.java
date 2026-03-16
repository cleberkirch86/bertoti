package com.example.padrao.subscriber;

public class LogListener implements EventListener {
    private final String logFile;

    public LogListener(String logFile) {
        this.logFile = logFile;
    }

    @Override
    public void update(String eventType, String fileName) {
        System.out.printf("[LOG -> %s] Alguém realizou a operação '%s' no arquivo: %s%n", 
                logFile, eventType, fileName);
    }
}
