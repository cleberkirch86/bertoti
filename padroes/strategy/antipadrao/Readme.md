# Anti-Padrão: Herança Inadequada

Este projeto demonstra um anti-padrão comum no uso de herança em Orientação a Objetos.

## O Cenário

Temos uma classe base abstrata `Cliente` e quatro subclasses:
- `Aposentado`
- `ClienteComum`
- `Estudante`
- `Empresa`

O problema surge porque a classe `Cliente` define um método abstrato `calcularEmprestimo()`. A intenção é que apenas clientes do tipo `Aposentado` possam ter um empréstimo. No entanto, ao forçar este método na classe base, todas as outras subclasses (`ClienteComum`, `Estudante`, `Empresa`) são obrigadas a fornecer uma implementação para um método que não faz sentido para elas.

## O Anti-Padrão na Prática

No código, as classes que não têm direito a empréstimo resolvem o problema de duas maneiras, ambas ruins:
1.  **Lançando uma `UnsupportedOperationException`**: Isso quebra o **Princípio de Substituição de Liskov (LSP)**. O LSP afirma que objetos de uma superclasse devem ser substituíveis por objetos de suas subclasses sem quebrar a aplicação. Ao lançar uma exceção, a substituição falha, pois o comportamento esperado (calcular um empréstimo) não é cumprido.
2.  **Retornando um valor padrão (como 0)**: Isso pode levar a bugs silenciosos, onde o código cliente não percebe que a operação não foi realmente executada.

O `Main.java` demonstra que, para iterar sobre uma lista de `Cliente` e tentar calcular o empréstimo, somos forçados a envolver a chamada em um bloco `try-catch`, o que é um forte indício de que a abstração está errada.

## Estrutura do Projeto

```
.
└── src
    └── main
        └── java
            └── com
                └── example
                    ├── Cliente.java          (Classe base abstrata com o método problemático)
                    ├── Aposentado.java       (A única classe onde o método faz sentido)
                    ├── ClienteComum.java     (Forçada a implementar o método)
                    ├── Estudante.java        (Forçada a implementar o método)
                    ├── Empresa.java          (Forçada a implementar o método)
                    └── Main.java             (Demonstração do problema)
```

## Conclusão

Este é um anti-padrão porque a herança foi usada para modelar uma relação "é um" (`Aposentado` **é um** `Cliente`) sem respeitar o comportamento compartilhado. Nem todo cliente "tem um" comportamento de empréstimo.

A solução correta para este problema seria utilizar o **Padrão Strategy**, onde o comportamento de cálculo de empréstimo seria extraído para uma interface separada (ex: `PoliticaDeEmprestimo`) e as classes que podem ter empréstimo a implementariam ou a receberiam por composição.
Criei os arquivos Java para ilustrar o anti-padrão de herança que você solicitou.

- **`src/main/java/com/example/`**: Contém as classes `Cliente`, `Aposentado`, `ClienteComum`, `Estudante`, `Empresa` e `Main`.
- **`out/`**: Contém os arquivos `.class` compilados.
- **`Readme.md`**: Explica em detalhes o anti-padrão, o problema e a solução recomendada (usar o Padrão Strategy).

Executei o programa e a saída, como pode ser vista no histórico, demonstra claramente o problema: apenas o cliente `Aposentado` consegue calcular o empréstimo, enquanto os outros lançam uma exceção, forçando o uso de `try-catch` e quebrando o princípio de Liskov.

Se precisar de mais alguma coisa, basta pedir.
Se precisar de mais alguma coisa, basta pedir.
.