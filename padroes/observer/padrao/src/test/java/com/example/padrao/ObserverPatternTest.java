package com.example.padrao;

import com.example.padrao.publisher.Editor;
import com.example.padrao.subscriber.EventListener;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ObserverPatternTest {

    static class CapturingListener implements EventListener {
        final List<String> received = new ArrayList<>();
        @Override
        public void update(String eventType, String fileName) {
            received.add(eventType + ":" + fileName);
        }
    }

    @Test
    @DisplayName("Subscriber registrado recebe notificação do evento correto")
    void subscriberReceivesNotificationForCorrectEvent() {
        Editor editor = new Editor();
        CapturingListener listener = new CapturingListener();
        editor.events.subscribe("open", listener);
        editor.openFile("documento.txt");
        assertEquals(1, listener.received.size());
        assertEquals("open:documento.txt", listener.received.get(0));
    }
}
