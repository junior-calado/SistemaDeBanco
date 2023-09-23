package org.example.conta.tipoDeConta;

import org.example.conta.ContaBancaria;
import org.example.conta.Enum.TipoConta;
import org.example.conta.Transacao;
import org.example.pessoa.Pessoa;

public class ContaCorrente extends ContaBancaria {
    private double limiteChequeEspecial;

    public ContaCorrente(String numeroConta, double saldo, TipoConta tipo, Pessoa nomeDaConta, double limiteChequeEspecial) {
        super(numeroConta, saldo, tipo, nomeDaConta);
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
        if (valor == 0) {
            System.out.println("O valor da transação deve ser diferente de zero.");
        } else {
            double novoSaldo = getSaldo() + valor;
            if (novoSaldo >= -limiteChequeEspecial) {
                // Transação permitida, atualiza o saldo
                setSaldo(novoSaldo);
                Transacao transacao = new Transacao(descricao, valor);
                System.out.println("Transação de " + descricao + " no valor de R$" + valor + " realizada com sucesso.");
            } else {
                System.out.println("Saldo insuficiente para realizar a transação.");
            }
        }
    }

    @Override
    public String toString() {
        return "Conta Corrente - Número: " + getNumeroConta() +
                "\nTitular: " + getTitular().getNome() +
                "\nSaldo Atual: R$" + getSaldo();
    }

    //Parei aqui. Tem que acabar essa classe da Conta corrente, fazer outros metodos e jogar no main direito e arrumar tambem na classe ContaBancaria
}

