package org.example.conta.tipoDeConta;

import org.example.conta.ContaBancaria;
import org.example.conta.Enum.TipoConta;

public class ContaConjunta extends ContaBancaria {

    private String titular1;
    private String titular2;

    private double limiteSaqueDiario;


    public ContaConjunta(String numeroConta, TipoConta tipo, String titular, String titular1, String titular2, double limiteSaqueDiario) {
        super(numeroConta, tipo, titular);
        this.titular1 = titular1;
        this.titular2 = titular2;
        this.limiteSaqueDiario = limiteSaqueDiario;
    }

    public ContaConjunta(String titular, String numeroConta, double limiteSaqueDiario) {
        super(numeroConta, TipoConta.SALARIO, titular);
        this.limiteSaqueDiario = limiteSaqueDiario;
    }

    public ContaConjunta(String numeroConta, TipoConta tipo, String titular) {
        super(numeroConta, tipo, titular);
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

}
