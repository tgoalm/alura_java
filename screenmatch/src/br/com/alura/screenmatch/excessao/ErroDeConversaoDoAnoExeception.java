package br.com.alura.screenmatch.excessao;

public class ErroDeConversaoDoAnoExeception extends RuntimeException{
    public String mensagem;

    public ErroDeConversaoDoAnoExeception(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
