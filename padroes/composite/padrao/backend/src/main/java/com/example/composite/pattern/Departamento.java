package com.example.composite.pattern;

import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.List;

@JsonTypeName("departamento")
public class Departamento implements Empregado {
    private String nome;
    private List<Empregado> empregados = new ArrayList<>();

    public Departamento(String nome) {
        this.nome = nome;
    }

    public void adicionar(Empregado e) {
        empregados.add(e);
    }

    public void remover(Empregado e) {
        empregados.remove(e);
    }

    @Override
    public String getNome() {
        return nome;
    }

    public List<Empregado> getEmpregados() {
        return empregados;
    }

    @Override
    public double getSalario() {
        double total = 0;
        for (Empregado e : empregados) {
            total += e.getSalario();
        }
        return total;
    }

    @Override
    public void mostrarDetalhes() {
        // A ser implementado ou removido
    }
}
