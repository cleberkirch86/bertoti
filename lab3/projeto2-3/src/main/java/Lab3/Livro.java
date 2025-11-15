package Lab3;

import java.util.UUID;

public class Livro {
    private final String id;
    private String nome;

    public Livro(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Livro(String nome) {
        this(UUID.randomUUID().toString(), nome);
    }

    public Livro() {
        this.id = UUID.randomUUID().toString();
        this.nome = "";
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
