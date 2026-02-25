package com.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        
        clientes.add(new Cliente("Joao", new VerificacaoAposentado()));
        clientes.add(new Cliente("Maria", new VerificacaoClienteComum()));
        clientes.add(new Cliente("Pedro", new VerificacaoEstudante()));
        clientes.add(new Cliente("Empresa Ltda", new VerificacaoEmpresa()));

        for (Cliente c : clientes) {
            System.out.println("Verificando cliente: " + c.getNome());
            c.verificarEmprestimo();
        }
    }
}
