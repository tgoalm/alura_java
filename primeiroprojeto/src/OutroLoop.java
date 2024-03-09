import java.util.Scanner;

public class OutroLoop {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        double notaDoFilme = 0;
        double mediaDaNota = 0;
        int qtdDeNotas = 0;

        while (notaDoFilme != -1) {
            System.out.println("Digite nota ou -1 para encerrar: ");
            notaDoFilme = leitura.nextDouble();
            if(notaDoFilme != -1) {
                mediaDaNota += notaDoFilme;
                qtdDeNotas++;
            }
        } 

        if(mediaDaNota == 0) {
            System.out.println("Não foram informadas notas suficientes.");
        } else {
            System.out.println("Média das notas: " + mediaDaNota / qtdDeNotas);
        }
        leitura.close();
    }
}
