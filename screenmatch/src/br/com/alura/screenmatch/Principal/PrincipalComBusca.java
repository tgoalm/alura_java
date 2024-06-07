package br.com.alura.screenmatch.Principal;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.alura.screenmatch.excessao.ErroDeConversaoDoAnoExeception;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        String titulo = "";
        Scanner in = new Scanner(System.in);
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .setPrettyPrinting()
                    .create();

        while (!titulo.equalsIgnoreCase("sair")) {
            System.out.println("Digite o nome do filme:");
            titulo = in.nextLine();

            if(titulo.equalsIgnoreCase("sair")) {
                break;
            }

            String endereco = "http://www.omdbapi.com/?t=" + titulo.replace(" ", "+") + "&apikey=1818ea3f";
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
                HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

                System.out.println(response.body());
                
                TituloOmdb tituloOmdb = gson.fromJson(response.body(), TituloOmdb.class);
                System.out.println(tituloOmdb);
                Titulo tituloJson = new Titulo(tituloOmdb);
                System.out.println(tituloJson);
                titulos.add(tituloJson);

            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro:");
                System.out.println(e.getMessage());
            }  catch (IllegalArgumentException e) {
                System.out.println("Erro no título informado.");
            }  catch (ErroDeConversaoDoAnoExeception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(titulos);
        FileWriter fw = new FileWriter("filmes.json");
        fw.write(gson.toJson(titulos));
        fw.close();
        System.out.println("O programa finalizou corretamente.");
    }
}