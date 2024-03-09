package br.com.alura.screenmatch.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso chefão", 1970);
        meuFilme.avaliaFilme(9);
        Filme outroFilme = new Filme("Avatar", 2023);
        outroFilme.avaliaFilme(6);
        Filme filmeDoPaulo = new Filme("Dogville", 2003); 
        filmeDoPaulo.avaliaFilme(10);
        Serie lost = new Serie("Lost", 2000);

        List<Titulo> lista = new ArrayList<>();
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(filmeDoPaulo);
        lista.add(lost);

        for (Titulo item : lista) {
            System.out.println(item.getNome());
            if(item instanceof Filme) {
                Filme filme = (Filme) item;
                System.out.println(filme.getClassificacao());
            }
        }

        List<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Silvester Stalone");
        buscaPorArtista.add("Nicolas Cage");
        buscaPorArtista.add("Jodie Foster");
        buscaPorArtista.add("Meryl Streep");
        buscaPorArtista.add("Scarlett Johansson");
        System.out.println(buscaPorArtista);

        Collections.sort(buscaPorArtista);
        Collections.sort(lista);
        System.out.println("Depois da ordenação:");
        System.out.println(buscaPorArtista);
        System.out.println(lista);
        System.out.println("Lista ordenada por ano:");
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println(lista);
    }
}
