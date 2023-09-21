package org.example.conta;

import org.example.conta.ContaBancaria;
import org.example.conta.Enum.TipoConta;
import org.example.conta.Excetions.ContaException;
import org.example.conta.tipoDeConta.ContaCorrente;
import org.example.conta.tipoDeConta.ContaPoupanca;
import org.example.conta.tipoDeConta.ContaSalario;
import org.example.pessoa.Pessoa;

import java.util.List;

public class ContaConjunta{

    private Pessoa titular1;
    private Pessoa titular2;
    private String numeroConta;
    private double saldo;
    private TipoConta tipo;
    private List<Transacao> transacoes;

    private double limiteSaqueDiario;






    public String criarContaConjunta(Pessoa titular1, Pessoa titular2, String numeroConta, double saldo, TipoConta tipo) {



        return null;
    }



}
