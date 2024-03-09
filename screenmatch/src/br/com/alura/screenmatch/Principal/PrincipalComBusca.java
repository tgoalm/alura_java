package br.com.alura.screenmatch.Principal;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o nome do filme:");
        var titulo = in.nextLine();
        String endereco = "http://www.omdbapi.com/?t=" + titulo + "&apikey=1818ea3f";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build();
        HttpResponse<String> response = client
            .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}
