package com.example.mvc.controller;

import com.example.mvc.model.Carrinho;
import com.example.mvc.model.Item;
import com.example.mvc.strategy.EstrategiaDesconto;

public class CarrinhoController {
    private Carrinho model;
    private EstrategiaDesconto estrategia;

    public CarrinhoController(Carrinho model) {
        this.model = model;
    }

    public void setEstrategia(EstrategiaDesconto estrategia) {
        this.estrategia = estrategia;
    }

    public void adicionarAoCarrinho(Item item) {
        model.adicionarItem(item);
    }

    public double calcularTotal() {
        double subtotal = model.getSubtotal();
        if (estrategia != null) {
            return estrategia.aplicar(subtotal);
        }
        return subtotal;
    }
}
