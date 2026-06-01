package com.example.mvc.model;

import com.example.mvc.observer.Sujeito;
import java.util.ArrayList;
import java.util.List;

public class Carrinho extends Sujeito {
    private List<Item> itens = new ArrayList<>();

    public void adicionarItem(Item item) {
        itens.add(item);
        notificar();
    }

    public List<Item> getItens() {
        return itens;
    }

    public double getSubtotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.getPreco();
        }
        return total;
    }
}
