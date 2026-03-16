package com.example.padrao.observer;

public interface BookEventListener {
    void onBookUpdate(String eventType, String bookTitle);
}
