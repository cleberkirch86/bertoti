package com.example.mvc;

import com.example.mvc.controller.CarrinhoController;
import com.example.mvc.model.*;
import com.example.mvc.view.CarrinhoView;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {
        // MVC Setup
        Carrinho model = new Carrinho();
        CarrinhoView view = new CarrinhoView(model);
        CarrinhoController controller = new CarrinhoController(model);

        // Exemplo de Composite
        Item p1 = new Produto("Laptop", 4000);
        Item p2 = new Produto("Mouse", 100);
        
        Kit kitGamer = new Kit("Kit Gamer");
        kitGamer.adicionar(p1);
        kitGamer.adicionar(p2);

        // Ações do Controller
        System.out.println("\n=== EXECUÇÃO MVC INTEGRADO ===");
        controller.adicionarAoCarrinho(new Produto("Monitor", 1200));
        controller.adicionarAoCarrinho(kitGamer);

        // Exemplo de Strategy
        controller.setEstrategia(total -> total * 0.95); // 5% desconto à vista
        System.out.println("\nTotal com desconto à vista (5%): R$ " + controller.calcularTotal());
    }
}
