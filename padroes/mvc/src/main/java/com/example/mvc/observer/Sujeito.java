package com.example.mvc.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Sujeito {
    private List<Observador> observadores = new ArrayList<>();

    public void registrar(Observador o) {
        observadores.add(o);
    }

    public void notificar() {
        for (Observador o : observadores) {
            o.atualizar();
        }
    }
}
