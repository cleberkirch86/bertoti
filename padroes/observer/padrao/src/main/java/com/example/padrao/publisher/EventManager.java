package com.example.padrao.publisher;

import com.example.padrao.subscriber.EventListener;
import java.util.*;

public class EventManager {
    private final Map<String, List<EventListener>> listeners = new HashMap<>();

    public void subscribe(String eventType, EventListener listener) {
        listeners
                .computeIfAbsent(eventType, k -> new ArrayList<>())
                .add(listener);
        System.out.printf("[EventManager] Subscriber '%s' registrado para evento '%s'%n",
                listener.getClass().getSimpleName(), eventType);
    }

    public void unsubscribe(String eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        if (users != null) {
            users.remove(listener);
            System.out.printf("[EventManager] Subscriber '%s' removido do evento '%s'%n",
                    listener.getClass().getSimpleName(), eventType);
        }
    }

    public void notify(String eventType, String fileName) {
        List<EventListener> users = listeners.getOrDefault(eventType, Collections.emptyList());
        System.out.printf("%n[EventManager] Disparando evento '%s' para %d subscriber(s)...%n",
                eventType, users.size());
        for (EventListener listener : users) {
            listener.update(eventType, fileName);
        }
    }
}
