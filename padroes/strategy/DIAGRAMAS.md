# Diagramas de Classe (Simplificados)

### Anti-padrão
Todo mundo herda o método e é obrigado a implementar, mesmo dando erro.

```mermaid
classDiagram
    class Cliente {
        <<abstract>>
        +String nome
        +calcularEmprestimo()* double
    }
    Cliente <|-- Aposentado
    Cliente <|-- ClienteComum
```

---

### Padrão Strategy
A lógica de "aprovar ou negar" fica em estratégias separadas. A decisão de qual usar fica centralizada (na Main ou Factory), mas o Cliente não precisa saber disso.

```mermaid
classDiagram
    class Cliente {
        +String nome
        +VerificadorEmprestimo strategy
        +verificarEmprestimo() void
    }
    class VerificadorEmprestimo {
        <<interface>>
        +verificar(Cliente c) void
    }
    class Aprovado {
        +verificar(Cliente c) void
    }
    class Negado {
        +verificar(Cliente c) void
    }

    Cliente --> VerificadorEmprestimo
    VerificadorEmprestimo <|.. Aprovado
    VerificadorEmprestimo <|.. Negado
```
