package org.example.conta.tipoDeConta;

import org.example.conta.ContaBancaria;
import org.example.conta.Enum.TipoConta;
import org.example.pessoa.Pessoa;

import java.util.List;

public class ContaSalario extends ContaBancaria {
    private double limiteSaqueDiario;

    public ContaSalario(String numeroConta, Pessoa titular, double limiteSaqueDiario) {
        super(numeroConta, TipoConta.SALARIO, titular);
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

