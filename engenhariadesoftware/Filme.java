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
