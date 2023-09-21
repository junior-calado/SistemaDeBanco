package org.example;


import org.example.conta.ContaBancaria;
import org.example.conta.Enum.TipoCliente;
import org.example.conta.Enum.TipoConta;
import org.example.conta.tipoDeConta.ContaCorrente;
import org.example.conta.tipoDeConta.ContaPoupanca;
import org.example.pessoa.Pessoa;

public class Main {
    public static void main(String[] args) {


      /*Ações:
        Transações bancárias (depósitos e pagamentos)
        Saldo
        Extrato por período
        Financiamento
        Aplicações*/

        //FAZENDO PARA PESSOA PRIMEIRO

        Pessoa rafa = new Pessoa("rafa golsalves", "12345678900", "789456123", "user@email.com",
                                    "44 9 9988-9988","Rua JK",
                                    TipoCliente.PESSOA_LIVRE, 5000.00 );
        //Gerou uma pessoa

        //gerar a conta POUPANCA da pessoa
        ContaBancaria contaRafaPoupanca = new ContaBancaria("1357", 50.0, TipoConta.SALARIO, rafa);
        ContaPoupanca contaPoupanca = contaRafaPoupanca.criarContaPoupanca("12345", 1000.0, TipoConta.POUPANCA, rafa, 50.00);

        double rendimentos = contaPoupanca.consultarRendimentos();


        System.out.println("#####################################");
        System.out.println("############Conta Gerada#############");
        System.out.println("#####################################");
        System.out.println(contaPoupanca.toString());


        //Gerar a conta CORRENTE da Pessoa
        ContaBancaria contaRafaCorrente = new ContaBancaria("135123", 50.0, TipoConta.CORRENTE, rafa);
        ContaCorrente contaCorrente = contaRafaCorrente.criarContaCorrente("12345", 1000.0, TipoConta.POUPANCA, rafa, 50.00);


        System.out.println("#####################################");
        System.out.println("############Conta Gerada#############");
        System.out.println("#####################################");
        System.out.println(contaCorrente.toString());
    }
}