package org.example.conta;

import org.example.conta.Enum.TipoConta;

import java.util.ArrayList;
import java.util.List;

public class ContaBancaria {
    private String numeroConta;
    private double saldo;
    private TipoConta tipo;
    private String  titular;
    private List<Transacao> transacoes;

    public ContaBancaria(String numeroConta, TipoConta tipo, String titular) {
        this.numeroConta = numeroConta;
        this.tipo = tipo;
        this.titular = titular;
        this.saldo = 0.0; // Saldo inicial zero
        transacoes = new ArrayList<>();
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            transacoes.add(new Transacao("Depósito", valor));
        } else {
            // Lógica para tratar depósitos inválidos (por exemplo, valor negativo)
        }
    }

    public void pagar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            transacoes.add(new Transacao("Pagamento", -valor));
        } else {
            // Lógica para tratar pagamentos inválidos (por exemplo, saldo insuficiente)
        }
    }

    public double verificarSaldo() {
        return saldo;
    }

    public void realizarTransacao(String descricao, double valor) {
        if (valor < 0 && Math.abs(valor) > saldo) {
            // Verificação para transações de débito (saques, pagamentos, transferências)
            System.out.println("Saldo insuficiente para realizar a transação.");
        } else {
            // Atualizar o saldo e registrar a transação
            saldo += valor;
            Transacao transacao = new Transacao(descricao, valor);
            transacoes.add(transacao);
        }
    }

    public List<Transacao> gerarExtrato() {
        return transacoes;
    }

    // Outros métodos da classe ContaBancaria, como métodos relacionados a financiamento e aplicações.

    // Getters e setters para os atributos númeroConta, tipo e titular.

    public String getNumeroConta() {
        return numeroConta;
    }

    public TipoConta getTipo() {
        return tipo;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }
}
