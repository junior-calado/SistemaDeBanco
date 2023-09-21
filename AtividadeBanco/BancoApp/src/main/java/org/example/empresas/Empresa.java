package org.example.empresas;

import org.example.conta.ContaBancaria;
import org.example.conta.Enum.TipoConta;
import org.example.conta.Excetions.ContaException;
import org.example.conta.tipoDeConta.ContaCorrente;
import org.example.conta.tipoDeConta.ContaPoupanca;
import org.example.conta.tipoDeConta.ContaSalario;

public class Empresa {

    private String nome;
    private String cnpj;


    //Criando conta
    public  ContaBancaria criarContaBancaria(TipoConta tipoConta,String titular, String numeroConta, double limiteMinimo) {
        ContaBancaria novaConta = null;

        switch (tipoConta) {
            case POUPANCA:
                novaConta = new ContaPoupanca("Jose", "123321", 50.0);
                break;
            case SALARIO:
                novaConta = new ContaSalario("Jose", "123321", 50.0);
                break;
            case CORRENTE:
                novaConta = new ContaCorrente("Jose", "123321", 50.0);
                break;
            case CONJUNTA:

                break;
            default:
                throw new ContaException("Tipo de conta invalida");
        }
        return novaConta;
    }


}
