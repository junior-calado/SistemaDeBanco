package org.example.conta.tipoDeConta;

import org.example.conta.ContaBancaria;
import org.example.conta.Enum.TipoConta;

public class ContaCorrente extends ContaBancaria {
    private double limiteChequeEspecial;

    public ContaCorrente(String titular, String numeroConta, double limiteChequeEspecial) {
        super(numeroConta, TipoConta.CORRENTE, titular);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public void setLimiteChequeEspecial(double limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public void realizarTransacao(String descricao, double valor) {
        if (valor < 0 && Math.abs(valor) > (getSaldo() + limiteChequeEspecial)) {
            System.out.println("Limite de cheque especial excedido.");
        } else {
            super.realizarTransacao(descricao, valor);
        }
    }

}

