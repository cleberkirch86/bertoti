package com.example.composite.antipattern;

import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private String nome;
    private List<Gerente> gerentes = new ArrayList<>();
    private List<Desenvolvedor> desenvolvedores = new ArrayList<>();

    public Departamento(String nome) {
        this.nome = nome;
    }

    public void addGerente(Gerente g) {
        gerentes.add(g);
    }

    public void addDesenvolvedor(Desenvolvedor d) {
        desenvolvedores.add(d);
    }

    public double calcularFolhaPagamento() {
        double total = 0;
        for (Gerente g : gerentes) {
            total += g.getSalario();
        }
        for (Desenvolvedor d : desenvolvedores) {
            total += d.getSalario();
        }
        return total;
    }
}
