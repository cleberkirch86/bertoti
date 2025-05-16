# Engenharia de Software - BERTOTI

## Atividade 1 – Comentar os trechos do livro "Software Engineering at Google"
 
  O primeiro trecho destaca como, ao longo dos anos, sempre se teve diferença na visão das pessoas entre dizer que você é um **“Programador”** — visto como um trabalho, algo mais intangível — e um **“Engenheiro de Software”** — respeitado como outros engenheiros —, embora na prática os dois sejam parecidos e interlaçados.

## Atividade 2 – Comentar os trechos do segundo artigo

  O segundo trecho destaca como os engenheiros de software pensam na **“programação ao longo do tempo”**. O engenheiro leva em conta a **escalabilidade** do projeto, o **ciclo de vida** da aplicação, os **trade-offs** e até o **custo**.

## Atividade 3 – Listar e explicar 3 exemplos de trade-offs

1. **Desempenho × Segurança**  
   Implementar segurança de alto nível costuma comprometer o desempenho da aplicação, então é necessário avaliar quantos níveis de segurança a aplicação realmente precisa.

2. **Escalabilidade × Complexidade**  
   Decidir se a aplicação rodará em um ambiente de nuvem controlado, com funcionalidades limitadas, ou em um ambiente próprio, com maior controle sobre as variáveis, mas alcance potencialmente mais restrito.

3. **Requisitos × Viabilidade Técnica**  
   Queremos uma aplicação que rode **“em qualquer dispositivo”** (solução mais simples, porém restrita em recursos) ou uma aplicação mais robusta, com variados recursos, mas que seja mais pesada e rode em menos plataformas?

## Atividade 4 – Diagrama UML da classe **Filme**

![image](https://github.com/user-attachments/assets/7e52cb60-ed0c-403d-83c0-4ddbeabeef47)

> *Figura: Diagrama de classes UML da entidade `Filme`.*

![image](https://github.com/user-attachments/assets/aefefc2a-8712-41c8-b4f0-2e304773fb5a)


## Atividade 5 - Classes Java

public class Filme {
    private String titulo;
    private int duracao; // em minutos
    private String horario; // horário da exibição

    public Filme(String titulo, int duracao, String horario) {
        this.titulo = titulo;
        this.duracao = duracao;
        this.horario = horario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "titulo='" + titulo + '\'' +
                ", duracao=" + duracao +
                ", horario='" + horario + '\'' +
                '}';
    }
}


import java.util.List;
import java.util.LinkedList;

public class SalaFilme {
    private String nomeSala;
    private List<Filme> filmes = new LinkedList<Filme>();

    public SalaFilme(String nomeSala) {
        this.nomeSala = nomeSala;
    }

    public String getNomeSala() {
        return nomeSala;
    }

    public void setNomeSala(String nomeSala) {
        this.nomeSala = nomeSala;
    }

    public void addFilme(Filme filme) {
        filmes.add(filme);
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public List<Filme> buscarFilmePorTitulo(String titulo) {
        List<Filme> encontrados = new LinkedList<Filme>();
        for (Filme filme : filmes) {
            if (filme.getTitulo().equalsIgnoreCase(titulo)) {
                encontrados.add(filme);
            }
        }
        return encontrados;
    }

    @Override
    public String toString() {
        return "SalaFilme{" +
                "nomeSala='" + nomeSala + '\'' +
                ", filmes=" + filmes +
                '}';
    }
}



## Atividade 6 – Diagrama UML da classe **Filme**

public class TestarSalaFilme {
    public static void main(String[] args) {
        // Criando alguns filmes
        Filme filme1 = new Filme("O Senhor dos Anéis", 178, "14:00");
        Filme filme2 = new Filme("Matrix", 136, "17:00");
        Filme filme3 = new Filme("Star Wars", 121, "20:00");

        // Criando uma sala e adicionando os filmes
        SalaFilme sala1 = new SalaFilme("Sala 1");
        sala1.addFilme(filme1);
        sala1.addFilme(filme2);
        sala1.addFilme(filme3);

        // Exibindo as informações da sala e dos filmes
        System.out.println(sala1);

        // Buscando filmes por título
        System.out.println("Filmes com título 'Matrix': " + sala1.buscarFilmePorTitulo("Matrix"));
    }
}
