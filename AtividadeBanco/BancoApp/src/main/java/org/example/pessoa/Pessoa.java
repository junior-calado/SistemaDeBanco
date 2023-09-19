package org.example.pessoa;

import org.example.conta.ContaBancaria;
import org.example.conta.Enum.TipoCliente;
import org.example.conta.Enum.TipoConta;
import org.example.conta.tipoDeConta.ContaCorrente;
import org.example.conta.tipoDeConta.ContaPoupanca;
import org.example.conta.tipoDeConta.ContaSalario;

import static org.example.conta.Enum.TipoConta.*;

public class Pessoa {

    private String nome;
    private String cpf;
    private String mail;
    private TipoCliente tipo;
    private Double salario;


    public ContaBancaria criarContaBancaria(TipoConta tipoConta) {
        ContaBancaria novaConta = null;

        switch (tipoConta) {
            case POUPANCA:
                novaConta = new ContaPoupanca("Jose", "123321", 50.0);
                break;
            case SALARIO:
                //novaConta = new ContaSalario();
                break;
            case CORRENTE:
                //novaConta = new ContaCorrente();
                break;
            default:
                // Lógica para lidar com tipos de conta desconhecidos
                break;
        }
    }//Parei aqui, falta implementar metodos de Exception, mas tem que terminar primeiro os metodos de criar conta.
}
