# Projeto 2-3: API RESTful de Gerenciamento de Livros

Este projeto consiste em uma aplicação Spring Boot que implementa uma API RESTful para gerenciamento de livros. A aplicação permite realizar operações CRUD (Criar, Ler, Atualizar, Deletar) em uma coleção de livros, além de fornecer uma interface web simples para interação.

## Funcionalidades

*   **API RESTful:**
    *   Listar todos os livros.
    *   Obter detalhes de um livro específico por ID.
    *   Adicionar um novo livro.
    *   Atualizar informações de um livro existente.
    *   Remover um livro.
*   **Interface Web Simples:** Uma página HTML estática com JavaScript para interagir com a API.

## Tecnologias Utilizadas

*   **Java 17+:** Linguagem de programação.
*   **Spring Boot:** Framework para construção de aplicações Java robustas e escaláveis.
*   **Maven:** Ferramenta de automação de build e gerenciamento de dependências.
*   **HTML, CSS, JavaScript:** Para a interface web.

## Como Executar o Projeto

Para executar este projeto, siga os passos abaixo:

1.  **Pré-requisitos:**
    *   Java Development Kit (JDK) 17 ou superior instalado.
    *   Maven instalado (geralmente já vem com o Spring Boot CLI ou pode ser baixado separadamente).

2.  **Clonar o Repositório:**
    ```bash
    git clone <URL_DO_SEU_REPOSITORIO>
    cd projeto2-3
    ```
    *(Substitua `<URL_DO_SEU_REPOSITORIO>` pela URL real do seu repositório Git)*

3.  **Compilar e Executar:**
    Você pode compilar e executar a aplicação usando o Maven:
    ```bash
    ./mvnw spring-boot:run
    ```
    Ou, se preferir, pode gerar o JAR executável e depois executá-lo:
    ```bash
    ./mvnw clean package
    java -jar target/projeto2-3-0.0.1-SNAPSHOT.jar
    ```
    A aplicação será iniciada na porta padrão 8080.

## Endpoints da API

A API estará disponível em `http://localhost:8080`.

*   **GET /livros:** Retorna uma lista de todos os livros.
    *   Exemplo de resposta: `Prints/getlivros.png`
*   **GET /livros/{id}:** Retorna os detalhes de um livro específico.
*   **POST /livros:** Adiciona um novo livro.
    *   Corpo da requisição (Exemplo):
        ```json
        {
            "titulo": "O Senhor dos Anéis",
            "autor": "J.R.R. Tolkien",
            "anoPublicacao": 1954
        }
        ```
    *   Exemplo de resposta: `Prints/postlivros.png`
*   **PUT /livros/{id}:** Atualiza um livro existente.
*   **DELETE /livros/{id}:** Remove um livro.

## Interface Web

A interface web simples pode ser acessada em `http://localhost:8080/index.html`.
Ela permite visualizar e interagir com os endpoints da API.
*   Exemplo de interação: `Prints/getaposopost.png`

## Estrutura do Projeto

```
.
├───pom.xml
├───src/main/java/Lab3/
│   ├───ControladorRestApi.java
│   ├───Livro.java
│   └───LivrosDemonstracao.java
├───src/main/resources/static/
│   ├───index.html
│   └───script.js
└───Prints/
    ├───getaposopost.png
    ├───getlivros.png
    └───postlivros.png
```

