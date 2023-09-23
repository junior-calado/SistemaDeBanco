package org.example;


import org.example.conta.ContaBancaria;
import org.example.conta.ContaConjunta;
import org.example.conta.Enum.TipoCliente;
import org.example.conta.Enum.TipoConta;
import org.example.conta.tipoDeConta.ContaCorrente;
import org.example.conta.tipoDeConta.ContaPoupanca;
import org.example.conta.tipoDeConta.ContaSalario;
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

        Pessoa rafa = new Pessoa("rafael gonsalves", "12345678900", "789456123", "user@email.com",
                                    "44 9 9988-9988","Rua JK",
                                    TipoCliente.PESSOA_LIVRE, 5000.00 );

        //Gerou uma pessoa

        //gerar a conta POUPANCA da pessoa
        ContaBancaria contaRafaPoupanca = new ContaBancaria("1357", 5000.0, TipoConta.SALARIO, rafa);
        ContaPoupanca contaPoupanca = contaRafaPoupanca.criarContaPoupanca(TipoConta.POUPANCA, rafa, 50.00);


        System.out.println("##############################################");
        System.out.println("############Conta Poupanca Gerada#############");
        System.out.println("##############################################");
        System.out.println(contaPoupanca.toString());


        System.out.println(" ");

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////realizando transaçoes conta Poupanca/////////////////////////////////////////
        contaPoupanca.realizarTransacao("teste de 1000", 1000.00);
        System.out.println("##############################################");
        System.out.println("############Conta Poupanca Gerada#############");
        System.out.println("##############################################");
        System.out.println(contaPoupanca.toString());



        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////CONTA CORRENTE/////////////////////////////////////////////////////

        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");



        //Gerar a conta CORRENTE da Pessoa
        ContaBancaria contaRafaCorrente = new ContaBancaria("123321", 5000.0, TipoConta.CORRENTE, rafa);
        ContaCorrente contaCorrente = contaRafaCorrente.criarContaCorrente(rafa, TipoConta.CORRENTE, 50.00);


        System.out.println("##############################################");
        System.out.println("############Conta Corrente Gerada#############");
        System.out.println("##############################################");
        System.out.println(contaCorrente.toString());


        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////CONTA SALARIO//////////////////////////////////////////////////////
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");



        //Gerar a conta SALARIO da Pessoa
        ContaBancaria contaRafaSalario = new ContaBancaria("123321", 500.0, TipoConta.CORRENTE, rafa);
        ContaSalario contaSalario = contaRafaSalario.criarContaSalario(TipoConta.CORRENTE, 1000.0);


        System.out.println("##############################################");
        System.out.println("############Conta Salario Gerada##############");
        System.out.println("##############################################");
        System.out.println(contaSalario.toString());

        System.out.println(" ");

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////realizando transaçoes conta salario//////////////////////////////////////////
        contaSalario.realizarTransacao("teste de 1000", 1000.00);
        System.out.println("##############################################");
        System.out.println("############Conta Salario Gerada##############");
        System.out.println("##############################################");
        System.out.println(contaSalario.toString());







        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////CONTA CONJUNTA//////////////////////////////////////////////////////
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");


        //GERANDO A PESSOA AMARRADA
        Pessoa iza = new Pessoa("Izabela Almeida", "98765432100", "634821653", "user@email.com",
                "44 9 9988-9988","Rua JK",
                TipoCliente.PESSOA_AMARRADA, 5000.00 );
        Pessoa fer = new Pessoa("Fernando Almeida", "92345672100", "61234521", "user@email.com",
                "44 9 9988-9988","Rua JK",
                TipoCliente.PESSOA_AMARRADA, 2000.00 );


        //Gerar a conta Conjunta
        ContaConjunta contaIzaFerConjunta = new ContaConjunta(iza, fer, "13579", TipoConta.CONJUNTA);

        System.out.println("##############################################");
        System.out.println("############Conta Conjunta Gerada##############");
        System.out.println("##############################################");
        System.out.println(contaIzaFerConjunta.toString());

        System.out.println(" ");

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////realizando transaçoes conta Conjunta//////////////////////////////////////////
        contaIzaFerConjunta.realizarTransacao("teste de 1000", 1000.00);
        System.out.println("##############################################");
        System.out.println("############Conta Salario Gerada##############");
        System.out.println("##############################################");
        System.out.println(contaIzaFerConjunta.toString());



        //terminar de ver a parte de transacoes.add()
    }
}