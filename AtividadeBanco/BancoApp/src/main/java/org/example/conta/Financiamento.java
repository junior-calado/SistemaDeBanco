package org.example.conta;


public class Financiamento {
    private double taxaJuros;
    private int numeroParcelas;

    public Financiamento(double taxaJuros, int numeroParcelas) {
        this.taxaJuros = 9;
        this.numeroParcelas = numeroParcelas;
    }

    public double calcularValorParcela(double valorSolicitado) {
        // Lógica para calcular o valor de cada parcela do financiamento
        // Você pode usar a fórmula de financiamento ou lógica personalizada aqui
        double valorParcela = valorSolicitado / numeroParcelas;
        double juros = valorParcela * (taxaJuros / 100);
        valorParcela += juros;

        return valorParcela;
    }
}
