package com.example.mvc.model;

import java.util.ArrayList;
import java.util.List;

public class Kit implements Item {
    private String nome;
    private List<Item> itens = new ArrayList<>();

    public Kit(String nome) {
        this.nome = nome;
    }

    public void adicionar(Item item) { itens.add(item); }

    public String getNome() { return nome + " (Kit)"; }
    
    public double getPreco() {
        double total = 0;
        for (Item item : itens) {
            total += item.getPreco();
        }
        return total * 0.9; // 10% de desconto no kit
    }
}
