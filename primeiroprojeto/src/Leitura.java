import java.util.Scanner;

public class Leitura {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        System.out.println("Digite seu filme favorito: ");
        String filme = leitura.nextLine();
        System.out.println("Qual o ano de lançamento ");
        int anoDeLancamento = leitura.nextInt();
        System.out.println("Dê sua nota ao filme: ");
        double notaDoFilme = leitura.nextDouble();
        System.out.println("Filme: " + filme + " - Ano de lançamento: " + anoDeLancamento + " - Nota: " + notaDoFilme);

        leitura.close();
    }
}
