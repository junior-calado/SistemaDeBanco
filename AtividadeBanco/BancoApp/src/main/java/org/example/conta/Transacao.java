package org.example.conta;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Transacao {
    private List<Transacao> transacoes;
    private LocalDateTime dataHora;
    private double valor;

    public Transacao(List<Transacao> transacoes, double valor) {
        this.transacoes = transacoes;
        this.dataHora = dataHora;
        this.valor = valor;
    }

    public Transacao(String financiamento, double valorFinanciado) {
        this.transacoes = new ArrayList<>();
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void adicionarTransacao(String descricao, double valor) {
        LocalDateTime dataHora = LocalDateTime.now();
        Transacao transacao = new Transacao(descricao, valor);
        transacoes.add(transacao);
    }

    public List<Transacao> obterTransacoesPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal) {
        List<Transacao> transacoesNoPeriodo = new ArrayList<>();
        for (Transacao transacao : transacoes) {
            LocalDateTime dataTransacao = transacao.getDataHora();
            if (dataTransacao.isAfter(dataInicial) && dataTransacao.isBefore(dataFinal)) {
                transacoesNoPeriodo.add(transacao);
            }
        }
        return transacoesNoPeriodo;
    }

    public double calcularSaldo() {
        double saldo = 0;
        for (Transacao transacao : transacoes) {
            saldo += transacao.getValor();
        }
        return saldo;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}

