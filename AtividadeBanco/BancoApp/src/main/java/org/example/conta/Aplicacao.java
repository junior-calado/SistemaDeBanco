package org.example.conta;

public class Aplicacao {
    private double valor;
    private double juros;
    private int meses;

    public Aplicacao(double valor, double juros, int meses) {
        this.valor = valor;
        this.juros = juros;
        this.meses = meses;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getJuros() {
        return juros;
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }

    public int getMeses() {
        return meses;
    }

    public void setMeses(int meses) {
        this.meses = meses;
    }

    public double calcularRendimento() {
        // Implemente a lógica para calcular o rendimento da aplicação com base no valor, juros e meses
        double rendimento = valor * (juros / 100) * meses;
        return rendimento;
    }

    @Override
    public String toString() {
        return "Aplicacao{" +
                "valor=" + valor +
                ", juros=" + juros +
                ", meses=" + meses +
                '}';
    }
}
