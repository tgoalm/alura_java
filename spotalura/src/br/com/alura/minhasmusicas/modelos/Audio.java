package br.com.alura.minhasmusicas.modelos;

public class Audio {
    private String titulo;
    private int totalDeReproducoes;
    private int totalDeCurtidas;
    private int Classificacao;
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTotalDeReproducoes() {
        return totalDeReproducoes;
    }

    public int getTotalDeCurtidas() {
        return totalDeCurtidas;
    }

    public int getClassificacao() {
        return Classificacao;
    }
    public void curte() {
        this.totalDeCurtidas++;
    }

    public void reproduz() {
        this.totalDeReproducoes++;
    }
}
