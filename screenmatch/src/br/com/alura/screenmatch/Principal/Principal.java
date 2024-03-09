package br.com.alura.screenmatch.Principal;
import java.util.ArrayList;

import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroDeRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso chefão", 1970);
        meuFilme.setDuracaoEmMinutos(180);
        System.out.println("Duração em minutos: " + meuFilme.getDuracaoEmMinutos());
        meuFilme.exibeFichaTecnica();
        meuFilme.avaliaFilme(8);
        meuFilme.avaliaFilme(5);
        meuFilme.avaliaFilme(10);
        System.out.println("Total de avaliações: " + meuFilme.getTotalDeAvaliacoes());
        System.out.println("Média das avaliações: " + meuFilme.pegaMediaDasAvaliacoes());

        System.out.println();

        Filme outroFilme = new Filme("Avatar", 2023);
        outroFilme.setDuracaoEmMinutos(100);
        System.out.println("Duração em minutos: " + outroFilme.getDuracaoEmMinutos());
        outroFilme.exibeFichaTecnica();
        outroFilme.avaliaFilme(9);
        outroFilme.avaliaFilme(9.5);
        outroFilme.avaliaFilme(10);
        System.out.println("Total de avaliações: " + outroFilme.getTotalDeAvaliacoes());
        System.out.println("Média das avaliações: " + outroFilme.pegaMediaDasAvaliacoes());

        System.out.println();

        Serie lost = new Serie("Lost", 2000);
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);
        System.out.println("Duração em minutos: " + lost.getDuracaoEmMinutos());
        lost.exibeFichaTecnica();

        System.out.println();

        CalculadoraDeTempo calculadoraDeTempo = new CalculadoraDeTempo();
        calculadoraDeTempo.inclui(meuFilme);
        calculadoraDeTempo.inclui(outroFilme);
        calculadoraDeTempo.inclui(lost);

        System.out.println();

        System.out.println("Tempo total: " + calculadoraDeTempo.getTempoTotal());

        System.out.println();

        FiltroDeRecomendacao filtro = new FiltroDeRecomendacao();
        filtro.filtra(meuFilme);

        System.out.println();

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalDeVisualizacoes(300);
        filtro.filtra(episodio);

        System.out.println();

        Filme filmeDoPaulo = new Filme("Dogville", 2003);
        filmeDoPaulo.setDuracaoEmMinutos(200);
        filmeDoPaulo.avaliaFilme(10);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();

        listaDeFilmes.add(filmeDoPaulo);
        listaDeFilmes.add(meuFilme);
        listaDeFilmes.add(outroFilme);
        System.out.println("Tamanho da lista: " + listaDeFilmes.size());
        System.out.println("Primeiro filme: " + listaDeFilmes.get(0).getNome());
        System.out.println(listaDeFilmes);
        System.out.println(listaDeFilmes.toString());
        
    }
}
