package com.example.padrao.observer;

import java.util.*;

public class BookEventManager {
    private final Map<String, List<BookEventListener>> listeners = new HashMap<>();

    public void subscribe(String eventType, BookEventListener listener) {
        listeners.computeIfAbsent(eventType, k -> new ArrayList<>()).add(listener);
    }

    public void unsubscribe(String eventType, BookEventListener listener) {
        List<BookEventListener> users = listeners.get(eventType);
        if (users != null) users.remove(listener);
    }

    public void notify(String eventType, String bookTitle) {
        List<BookEventListener> users = listeners.getOrDefault(eventType, Collections.emptyList());
        for (BookEventListener listener : users) {
            listener.onBookUpdate(eventType, bookTitle);
        }
    }
}
