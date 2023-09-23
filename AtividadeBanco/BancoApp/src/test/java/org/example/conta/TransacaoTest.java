package org.example.conta;

import org.example.conta.Enum.TipoCliente;
import org.example.conta.Enum.TipoConta;
import org.example.conta.tipoDeConta.ContaSalario;
import org.example.pessoa.Pessoa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransacaoTest {


    @Test
    public void realizandoTransacaoContaSalario(){


        Pessoa rafa = new Pessoa("rafa golsalves", "12345678900",
                "789456123","user@email.com",
                "44 9 9988-9988","Rua JK",
                TipoCliente.PESSOA_LIVRE, 5000.00 );


        //Gerar a conta SALARIO da Pessoa
        ContaBancaria contaRafaSalario = new ContaBancaria("123321", 5000.0, TipoConta.CORRENTE, rafa);
        ContaSalario contaSalario = contaRafaSalario.criarContaSalario(TipoConta.CORRENTE, 1000.0);

        contaSalario.realizarTransacao("teste de 1000", 1000.00);

        assertEquals(contaSalario.toString(), contaSalario.toString());



    }
}
