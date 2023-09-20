package org.example.conta.tipoDeConta;

import org.example.conta.Aplicacao;
import org.example.conta.ContaBancaria;
import org.example.conta.Enum.TipoConta;
import org.example.conta.Transacao;

import java.util.ArrayList;
import java.util.List;

public class ContaPoupanca extends ContaBancaria {
    private double limiteMinimo;
    private List<Aplicacao> aplicacoes;

    public ContaPoupanca(String titular, String numeroConta, double limiteMinimo) {
        super(numeroConta, TipoConta.POUPANCA, titular);
        this.limiteMinimo = limiteMinimo;
        this.aplicacoes = new ArrayList<>();
    }

    public double getLimiteMinimo() {
        return limiteMinimo;
    }

    public void setLimiteMinimo(double limiteMinimo) {
        this.limiteMinimo = limiteMinimo;
    }

    public List<Aplicacao> getAplicacoes() {
        return aplicacoes;
    }

    public void fazerAplicacao(double valor, int meses) {
        if (valor > 0 && meses > 0 && verificarSaldo() >= valor) {
            double juros = calcularJuros(valor, meses);
            Aplicacao aplicacao = new Aplicacao(valor, juros, meses);
            aplicacoes.add(aplicacao);
            realizarTransacao("Aplicação", -valor);
        } else {
            // Lógica para lidar com aplicação inválida
        }
    }

    private double calcularJuros(double valor, int meses) {
        // Implemente a lógica de cálculo de juros adequada para a sua aplicação
        // Este é apenas um exemplo simples
        double taxaJurosAnual = 0.05; // 5% de taxa de juros anual
        double taxaJurosMensal = taxaJurosAnual / 12;
        return valor * taxaJurosMensal * meses;
    }

    // Outros métodos da classe ContaPoupanca, como consultar rendimentos, etc.
}

