# Diagramas de Classe

### Anti-padrão (Herança)
Nesse modelo a classe Cliente obriga todo mundo a ter o método de empréstimo, mesmo quem não pode.

```mermaid
classDiagram
    class Cliente {
        <<abstract>>
        +String nome
        +calcularEmprestimo()* double
    }
    Cliente <|-- Aposentado
    Cliente <|-- ClienteComum
    Cliente <|-- Empresa
    Cliente <|-- Estudante
```

---

### Padrão Strategy
Aqui a lógica de verificação foi separada em uma interface. O Cliente só "usa" o verificador que ele precisar.

```mermaid
classDiagram
    class Cliente {
        +String nome
        +VerificadorEmprestimo verificador
        +verificarEmprestimo() void
    }
    class VerificadorEmprestimo {
        <<interface>>
        +verificar(Cliente c) void
    }
    class VerificacaoAposentado {
        +verificar(Cliente c) void
    }
    class VerificacaoClienteComum {
        +verificar(Cliente c) void
    }
    class Aprovado {
        +verificar(Cliente c) void
    }
    class Negado {
        +verificar(Cliente c) void
    }

    Cliente --> VerificadorEmprestimo
    VerificadorEmprestimo <|.. VerificacaoAposentado
    VerificadorEmprestimo <|.. VerificacaoClienteComum
    VerificadorEmprestimo <|.. Aprovado
    VerificadorEmprestimo <|.. Negado
```
