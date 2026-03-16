package com.example.antipadrao;

import com.example.antipattern.EditorWithoutPattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ObserverAntiPatternTest {

    @Test
    @DisplayName("Editor executa operações sem lançar exceção")
    void editorRunsWithoutException() {
        EditorWithoutPattern editor = new EditorWithoutPattern();
        assertDoesNotThrow(() -> {
            editor.openFile("teste.txt");
            editor.saveFile();
            editor.closeFile();
        });
    }
}
