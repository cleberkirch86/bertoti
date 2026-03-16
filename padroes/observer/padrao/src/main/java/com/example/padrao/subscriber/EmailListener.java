package com.example.padrao.subscriber;

public class EmailListener implements EventListener {
    private final String email;

    public EmailListener(String email) {
        this.email = email;
    }

    @Override
    public void update(String eventType, String fileName) {
        System.out.printf("[EMAIL -> %s] Notificação: O arquivo '%s' foi processado (Evento: %s)%n", 
                email, fileName, eventType);
    }
}
