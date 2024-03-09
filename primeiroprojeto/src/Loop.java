import java.util.Scanner;

public class Loop {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        double notaDoFilme = 0;
        double mediaDaNota = 0;

        for (int i = 0; i < 3; i++) {
            System.out.println("Dê sua nota ao filme: ");
            notaDoFilme = leitura.nextDouble();
            mediaDaNota += notaDoFilme;
        }

        System.out.println("Média das notas: " + mediaDaNota / 3);
        leitura.close();
    }
}
