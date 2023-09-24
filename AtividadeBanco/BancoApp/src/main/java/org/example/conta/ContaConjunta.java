package org.example.conta;

import org.example.conta.Enum.TipoConta;
import org.example.conta.Excetions.ContaException;
import org.example.pessoa.Pessoa;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ContaConjunta {
    private Pessoa titular1;
    private Pessoa titular2;
    private String numeroConta;
    private double saldo;
    private TipoConta tipo;


    private List<Transacao> transacoes;

    /*public ContaConjunta(String numeroConta, List<Pessoa> titulares) {
        super(numeroConta, TipoConta.CONJUNTA, titulares.get(0)); // Use o primeiro titular como titular principal
        this.titulares = titulares;
    }*/


    //cria a conta aqui, esse nao precisa de um "criarContaConjunta"
    public ContaConjunta(Pessoa titular1, Pessoa titular2, String numeroConta, TipoConta tipo) {
        this.titular1 = titular1;
        this.titular2 = titular2;
        this.numeroConta = numeroConta;
        this.saldo = titular1.getSaldo() + titular2.getSaldo();
        this.tipo = tipo;
        this.transacoes = transacoes;
    }

    public void realizarTransacao(String descricao, double valor) {
        if (valor == 0) {
            System.out.println("O valor da transação deve ser diferente de zero.");
        } else {
            if (valor <= saldo) {
                // Transação permitida, atualiza o saldo
                double novoSaldo = getSaldo() - valor;
                setSaldo(novoSaldo);
                //Transacao transacao = new Transacao(descricao, -valor);
                //transacoes.add(transacao);
                System.out.println("Transação de " + descricao + " no valor de R$" + valor + " realizada com sucesso.");
            } else {
                System.out.println("Saldo insuficiente");
            }
        }
    }

    //GETTERS AND SETTERS

    public Pessoa getTitular1() {
        return titular1;
    }

    public void setTitular1(Pessoa titular1) {
        this.titular1 = titular1;
    }

    public Pessoa getTitular2() {
        return titular2;
    }

    public void setTitular2(Pessoa titular2) {
        this.titular2 = titular2;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public TipoConta getTipo() {
        return tipo;
    }

    public void setTipo(TipoConta tipo) {
        this.tipo = tipo;
    }


    @Override
    public String toString() {
        /*StringBuilder titularesStr = new StringBuilder();
        for (Pessoa titular : titulares) {
            titularesStr.append(titular.getNome()).append(", ");
        }
        titularesStr.delete(titularesStr.length() - 2, titularesStr.length()); // Remova a vírgula extra no final
        */

        return "Conta Conjunta - Número: " + getNumeroConta() +
                "\n Titular principal: " + titular1.getNome() +
                "\nTitular secundario: " + titular2.getNome() +
                "\nSaldo Atual: R$" + getSaldo();
    }

}

