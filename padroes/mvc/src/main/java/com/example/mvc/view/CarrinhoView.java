package com.example.mvc.view;

import com.example.mvc.model.Carrinho;
import com.example.mvc.model.Item;
import com.example.mvc.observer.Observador;

public class CarrinhoView implements Observador {
    private Carrinho model;

    public CarrinhoView(Carrinho model) {
        this.model = model;
        this.model.registrar(this);
    }

    @Override
    public void atualizar() {
        System.out.println("\n--- TELA DO CARRINHO ATUALIZADA ---");
        for (Item item : model.getItens()) {
            System.out.println("- " + item.getNome() + ": R$ " + item.getPreco());
        }
        System.out.println("Subtotal: R$ " + model.getSubtotal());
    }
}
