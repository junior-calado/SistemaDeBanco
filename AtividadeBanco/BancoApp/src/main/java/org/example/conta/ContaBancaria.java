package org.example.conta;

import org.example.conta.Enum.TipoConta;
import org.example.conta.Excetions.ContaException;

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
        if (valor <= 0) {
            throw new ContaException("O valor do depósito tem que ser maior que 0");
        } else {
            this.saldo += valor;
            Transacao transacao = new Transacao("Depósito", valor);//Verificar a classe Transacao
            this.transacoes.add(transacao);
            System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
        }
    }

    public void pagar(double valor) {
        if (valor <= 0) {
            throw new ContaException("O valor do depósito tem que ser maior que 0");
        } else if (valor > this.saldo) {
            throw new ContaException("Saldo insuficiente para realizar o pagamento.");
        } else {
            this.saldo -= valor;
            Transacao transacao = new Transacao("Pagamento", -valor); // O valor do pagamento é negativo
            this.transacoes.add(transacao);
            System.out.println("Pagamento de R$" + valor + " realizado com sucesso.");
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
