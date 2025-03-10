public class TesteSalaFilme {
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
