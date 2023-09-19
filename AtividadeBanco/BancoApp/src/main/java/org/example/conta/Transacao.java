package org.example.conta;

import org.example.conta.Enum.StatusTransacao;

import java.util.Date;

public class Transacao {
    private String descricao;
    private Date dataHora;
    private double valor;
    private String numeroConta;
    private String categoria;
    private StatusTransacao status;
    private String idTransacao;



    //Ver o construtor certo
    public Transacao(String descricao, double valor) {
        this.descricao = descricao;
        this.dataHora = new Date(); // Data e hora atuais
        this.valor = valor;
        this.numeroConta = numeroConta;
        this.categoria = categoria;
        this.status = StatusTransacao.CONCLUIDA; // Status padrão
        this.idTransacao = gerarIdUnico(); // Gera um ID único para a transação
    }

    public String getDescricao() {
        return descricao;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public double getValor() {
        return valor;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getCategoria() {
        return categoria;
    }

    public StatusTransacao getStatus() {
        return status;
    }

    public void setStatus(StatusTransacao status) {
        this.status = status;
    }

    public String getIdTransacao() {
        return idTransacao;
    }

    private String gerarIdUnico() {
        // Implemente lógica para gerar um ID único (pode ser um UUID, sequência única, etc.)
        // Este é apenas um exemplo simples.
        return "ID-" + System.currentTimeMillis();
    }
}

