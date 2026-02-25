# Exemplo de Anti-padrão (Herança)

Este código mostra o problema de colocar métodos na classe base que nem todo mundo usa.

### Problema:
A classe `Cliente` tem o método `calcularEmprestimo()`, mas só o `Aposentado` devia ter isso. 
As outras classes (`ClienteComum`, `Estudante`, `Empresa`) são obrigadas a implementar o método e acabam jogando `UnsupportedOperationException`.

Isso quebra o princípio de Liskov (LSP) porque você não pode tratar todo Cliente do mesmo jeito sem explodir um erro.

### Como rodar:
`mvn compile`
`mvn exec:java`
