package com.example;

// Cliente Aposentado - ÚNICO que deveria ter o método de empréstimo
public class Aposentado extends Cliente {

    public Aposentado(String nome, String email) {
        super(nome, email);
    }

    @Override
    public double calcularEmprestimo() {
        // Lógica de empréstimo específica para aposentados
        System.out.println("Cálculo de empréstimo para o aposentado: " + getNome());
        return 10000.00; // Exemplo de valor de empréstimo
    }
}
