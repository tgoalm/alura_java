import java.util.Scanner;

public class Conta {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        String nomeDoCliente = "Não informado.";
        String tipoDeConta = "Não informado.";
        double saldoDaConta = 0;
        int operacao = 0;
        String menu = //
            "Operações\r\n" + //
            "\r\n" + //
            "1- Consultar saldos\r\n" + //
            "2- Receber valor\r\n" + //
            "3- Transferir valor\r\n" + //
            "4- Sair\r\n" + //
            "\r\n" + //
            "Digite a opção desejada:\r\n";

        System.out.println("Digite o nome do cliente: ");
        nomeDoCliente = leitura.nextLine();
        System.out.println("Digite o tipo de conta do cliente: ");
        tipoDeConta = leitura.nextLine();
        System.out.println("Digite o saldo do cliente: ");
        saldoDaConta = leitura.nextDouble();

        System.out.println(//
            "***********************************************************\n" + //
            "Dados iniciais do cliente: \n\nNome: " + nomeDoCliente + //
            "\nTipo de conta: " + tipoDeConta + //
            "\nSaldo da conta: " + saldoDaConta + //
            "\n***********************************************************\n\n"
        );
        
        while (operacao != 4) {
            System.out.println(menu);
            operacao = leitura.nextInt();

            if (operacao == 1) {
                System.out.println("Saldo: " + saldoDaConta + "\n\n");
            } else if (operacao == 2) {
                System.out.println("Digite o valor à receber: ");
                double valor = leitura.nextDouble();
                if(valor <= 0) {
                    System.out.println("Digite um valor maior que 0 (zero).\n\n2");
                } else {
                    saldoDaConta += valor;
                    System.out.println("Saldo Atualizado: " + saldoDaConta + "\n\n");
                }   
            } else if (operacao == 3) {
                System.out.println("Digite o valor à transferir: ");
                double valor = leitura.nextDouble();
                if(valor <= saldoDaConta) {
                    saldoDaConta -= valor;
                    System.out.println("Saldo Atualizado: " + saldoDaConta + "\n\n");
                } else {
                    System.out.println("Valor à transferir deve ser maior que o saldo de sua conta: " + saldoDaConta + "\n\n");
                }
            } else if (operacao == 4) {
                System.out.println("Tchau!");
                break;
            } else if (operacao != 1 || operacao != 2 || operacao != 3 || operacao != 4 ) {
                System.out.println("Digite uma opção válida\n\n");
            }
        }
        leitura.close();
    }
}