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
