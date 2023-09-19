package org.example.conta;

import org.example.pessoa.Pessoa;

public class Conta {

    private Pessoa nome;
    private Pessoa cpf;
    private Pessoa mail;
    private Integer numConta;
    private Double saldo;


    public Conta(Pessoa nome, Pessoa cpf, Pessoa mail, Integer numConta, Double saldo) {
        this.nome = nome;
        this.cpf = cpf;
        this.mail = mail;
        this.numConta = numConta;
        this.saldo = saldo;
    }



    public void criarConta() {


    }



}
