package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.excessao.ErroDeConversaoDoAnoExeception;

public class Titulo implements Comparable<Titulo>{
    private String nome;
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }
    public Titulo(TituloOmdb tituloOmdb) {
        this.nome = tituloOmdb.title();
        if(tituloOmdb.year().length() > 4) {
            throw new ErroDeConversaoDoAnoExeception("Ano com mais de 4 caracteres.");
        }
        this.anoDeLancamento = converteStringParaInt(tituloOmdb.year());
        this.duracaoEmMinutos = converteStringParaInt(tituloOmdb.runtime());
    }

    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void setTotalDeAvaliacoes(int totalDeAvaliacoes) {
        this.totalDeAvaliacoes = totalDeAvaliacoes;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void exibeFichaTecnica() {
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de lançamento: " + anoDeLancamento);
    }

    public void avaliaFilme(double nota) {
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    public double pegaMediaDasAvaliacoes() {
        return somaDasAvaliacoes/totalDeAvaliacoes;
    }

    @Override
    public int compareTo(Titulo titulo) {
        return this.getNome().compareTo(titulo.getNome());
    }

    private int converteStringParaInt(String texto) {
        if(texto != "") {
            // Remove os caracteres não numéricos
            String parteNumerica = texto.replaceAll("[^0-9]", "");
            // Converte a string resultante para um inteiro
            return Integer.parseInt(parteNumerica);
        } 
        return 0;
    }

    public String toString() {
        return "(Filme: " + this.getNome() + " (" + this.getAnoDeLancamento() + "), duração: " + this.getDuracaoEmMinutos() + " minutos.)";
    }
}
