package org.example.conta.tipoDeConta;

import org.example.conta.ContaBancaria;
import org.example.conta.Enum.TipoConta;
import org.example.pessoa.Pessoa;

public class ContaSalario extends ContaBancaria {
    private double limiteSaqueDiario;

    public ContaSalario(String numeroConta, double saldo, TipoConta tipo, Pessoa nomeDaConta) {
        super(numeroConta, saldo, tipo, nomeDaConta);
        this.limiteSaqueDiario = limiteSaqueDiario;
    }

    public double getLimiteSaqueDiario() {
        return limiteSaqueDiario;
    }

    public void setLimiteSaqueDiario(double limiteSaqueDiario) {
        this.limiteSaqueDiario = limiteSaqueDiario;
    }

    @Override
    public void realizarTransacao(String descricao, double valor) {
        if (valor < 0 && Math.abs(valor) > limiteSaqueDiario) {
            System.out.println("Limite de saque diário excedido.");
        } else {
            super.realizarTransacao(descricao, valor);
        }
    }

    // Outros métodos específicos de ContaSalario, se necessário...
}

