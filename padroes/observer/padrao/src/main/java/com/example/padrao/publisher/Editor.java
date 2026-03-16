package com.example.padrao.publisher;

public class Editor {
    public final EventManager events;
    private String currentFile;

    public Editor() {
        this.events = new EventManager();
    }

    public void openFile(String path) {
        this.currentFile = path;
        System.out.printf("%n=== Editor: abrindo arquivo '%s' ===%n", path);
        events.notify("open", currentFile);
    }

    public void saveFile() {
        if (currentFile == null) {
            throw new IllegalStateException("Nenhum arquivo aberto.");
        }
        System.out.printf("%n=== Editor: salvando arquivo '%s' ===%n", currentFile);
        events.notify("save", currentFile);
    }

    public void closeFile() {
        if (currentFile == null) {
            throw new IllegalStateException("Nenhum arquivo aberto.");
        }
        System.out.printf("%n=== Editor: fechando arquivo '%s' ===%n", currentFile);
        events.notify("close", currentFile);
        this.currentFile = null;
    }
}
