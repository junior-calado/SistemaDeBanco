package org.example;

import org.example.conta.ContaBancaria;
import org.example.conta.ContaConjunta;
import org.example.conta.Enum.TipoCliente;
import org.example.conta.Enum.TipoConta;
import org.example.conta.tipoDeConta.ContaCorrente;
import org.example.conta.tipoDeConta.ContaPoupanca;
import org.example.conta.tipoDeConta.ContaSalario;
import org.example.pessoa.Pessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContaTest {

    @Test
    public void testParaCriarContaPoupanca() {

        Pessoa rafa = new Pessoa("rafael gonsalves", "12345678900", "789456123", "user@email.com",
                "44 9 9988-9988","Rua JK",
                TipoCliente.PESSOA_LIVRE, 5000.00 );
        //Gerou uma pessoa

        //gerar a conta POUPANCA da pessoa
        ContaBancaria contaRafaPoupanca = new ContaBancaria("1357", 5000.0, TipoConta.SALARIO, rafa);
        ContaPoupanca contaPoupanca = contaRafaPoupanca.criarContaPoupanca(TipoConta.POUPANCA, rafa, 50.00);


        assertEquals("Conta Poupança - Número: 1357\n" +
                "Titular: rafael gonsalves\n" +
                "Rendimentos: 16.025426690811084\n" +
                "Saldo Atual: R$5000.0", contaPoupanca.toString());
    }


    @Test
    public void testParaCriarContaCorrente() {

        Pessoa rafa = new Pessoa("rafael gonsalves", "12345678900", "789456123", "user@email.com",
                "44 9 9988-9988","Rua JK",
                TipoCliente.PESSOA_LIVRE, 5000.00 );

        ContaBancaria contaRafaCorrente = new ContaBancaria("123321", 3000.0, TipoConta.CORRENTE, rafa);
        ContaCorrente contaCorrente = contaRafaCorrente.criarContaCorrente(rafa, TipoConta.CORRENTE, 50.00);

        assertEquals("Conta Corrente - Número: 123321\n" +
                "Titular: rafael gonsalves\n" +
                "Saldo Atual: R$3000.0", contaCorrente.toString());

    }

    @Test
    public void testParaCriarContaSalario() {

        Pessoa rafa = new Pessoa("rafael gonsalves", "12345678900", "789456123", "user@email.com",
                "44 9 9988-9988","Rua JK",
                TipoCliente.PESSOA_LIVRE, 5000.00 );

        //Gerar a conta SALARIO da Pessoa
        ContaBancaria contaRafaSalario = new ContaBancaria("123321", 50000.0, TipoConta.CORRENTE, rafa);
        ContaSalario contaSalario = contaRafaSalario.criarContaSalario(TipoConta.CORRENTE, 1000.0);


        assertEquals("Conta Salário - Número: 123321\n" +
                "Titular: rafael gonsalves\n" +
                "Saldo Atual: R$50000.0", contaSalario.toString());
    }


    @Test
    public void testParaCriarContaConjunta() {
    //GERANDO A PESSOA AMARRADA
        Pessoa iza = new Pessoa("Izabela Almeida", "98765432100", "634821653", "user@email.com",
                "44 9 9988-9988","Rua JK",
                TipoCliente.PESSOA_AMARRADA, 5000.00 );
        Pessoa fer = new Pessoa("Fernando Almeida", "92345672100", "61234521", "user@email.com",
                "44 9 9988-9988","Rua JK",
                TipoCliente.PESSOA_AMARRADA, 2000.00 );

//Gerar a conta Conjunta
        ContaConjunta contaIzaFerConjunta = new ContaConjunta(iza, fer, "13579", TipoConta.CONJUNTA);


        assertEquals("Conta Conjunta - Número: 13579\n" +
                " Titular principal: Izabela Almeida\n" +
                "Titular secundario: Fernando Almeida\n" +
                "Saldo Atual: R$7000.0", contaIzaFerConjunta.toString());

    }

}
