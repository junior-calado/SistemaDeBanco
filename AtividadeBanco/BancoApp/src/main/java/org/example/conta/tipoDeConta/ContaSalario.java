package org.example.conta.tipoDeConta;

import org.example.conta.ContaBancaria;
import org.example.conta.Enum.TipoConta;
import org.example.conta.Transacao;
import org.example.pessoa.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class ContaSalario extends ContaBancaria {
    private double limiteSaqueDiario;
    private List<Transacao> transacoes;

   /* public ContaSalario(String numeroConta, Pessoa titular, double limiteSaqueDiario, TipoConta tipo, double saqueDiario) {
        super(numeroConta, TipoConta.SALARIO, titular);
        this.limiteSaqueDiario = limiteSaqueDiario;
        this.transacoes = new ArrayList<>();
    }*/
    public ContaSalario(String numeroConta, Pessoa nomeDaConta, double saldo, TipoConta tipo,  double limiteSaqueDiario) {
        super(numeroConta, saldo, tipo, nomeDaConta);
        this.limiteSaqueDiario = limiteSaqueDiario;
        this.transacoes = new ArrayList<>();
    }


    public double getLimiteSaqueDiario() {
        return limiteSaqueDiario;
    }

    public void setLimiteSaqueDiario(double limiteSaqueDiario) {
        this.limiteSaqueDiario = limiteSaqueDiario;
    }

    @Override
    public void realizarTransacao(String descricao, double valor) {
        if (valor == 0) {
            System.out.println("O valor da transação deve ser diferente de zero.");
        } else {
            if (valor <= limiteSaqueDiario) {
                // Transação permitida, atualiza o saldo
                double novoSaldo = getSaldo() - valor;
                setSaldo(novoSaldo);
                Transacao transacao = new Transacao(descricao, -valor);
                transacoes.add(transacao);
                System.out.println("Transação de " + descricao + " no valor de R$" + valor + " realizada com sucesso.");
            } else {
                System.out.println("Limite de saque diário excedido.");
            }
        }
    }


    @Override
    public String toString() {
        return "Conta Salário - Número: " + getNumeroConta() +
                "\nTitular: " + getTitular().getNome() +
                "\nSaldo Atual: R$" + getSaldo();
    }
}

