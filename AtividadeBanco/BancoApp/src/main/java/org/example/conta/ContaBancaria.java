package org.example.conta;

import org.example.conta.Enum.TipoConta;
import org.example.conta.Excetions.ContaException;
import org.example.conta.tipoDeConta.ContaCorrente;
import org.example.conta.tipoDeConta.ContaPoupanca;
import org.example.pessoa.Pessoa;

import java.util.List;

public class ContaBancaria {
    private String numeroConta;
    private double saldo;
    private TipoConta tipo;
    private Pessoa titular;
    private List<Transacao> transacoes;

    //Constructor
    public ContaBancaria(String numeroConta, double saldo, TipoConta tipo, Pessoa nomeDaConta) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.tipo = tipo;
        this.titular = nomeDaConta;
    }

    //Criando conta
    /*public ContaBancaria criarContaBancaria(String numeroConta, double saldo, TipoConta tipo,
                                             Pessoa nomeDaConta, double limiteMinimo) {
        ContaBancaria novaConta = null;

        switch (tipo) {
            case POUPANCA:
                //tem que ter um limite minimo para ser criada
                if (limiteMinimo < 50.00) {
                    throw new ContaException("Erro ao criar a conta poupanca!! Voce precisa de um limite minimo de pelo menos R$50,00");
                } else {
                    novaConta = new ContaPoupanca(numeroConta, saldo, tipo, nomeDaConta, limiteMinimo);
                    System.out.println("Conta criada com sucesso");
                }
                break;
            case SALARIO:
                novaConta = new ContaSalario(numeroConta, saldo, tipo, nomeDaConta, limiteMinimo);
                break;
            case CORRENTE:
                novaConta = new ContaCorrente(numeroConta, saldo, tipo, nomeDaConta, limiteMinimo);
                break;
            case CONJUNTA:

                break;
            default:
                throw new ContaException("Tipo de conta invalida");
        }
        return novaConta;

    }*/


    /*public String criarContaBancaria(String numeroConta, double saldo, TipoConta tipo,
                                     Pessoa nomeDaConta, double limiteMinimo) {
        ContaBancaria novaConta = null;
        double taxaJuros = 12.75;
        String mensagem = "";

        switch (tipo) {
            case POUPANCA:
                // Tem que ter um limite mínimo para ser criada
                if (limiteMinimo < 50.00) {
                    throw new ContaException("Erro ao criar a conta poupança!! Você precisa de um limite mínimo de pelo menos R$50,00");
                } else {
                    novaConta = new ContaPoupanca(numeroConta, saldo, tipo, nomeDaConta, limiteMinimo, taxaJuros);//Tem que fazer o metodo para imprimir detalhes da conta
                    mensagem = "Conta criada com sucesso";
                }
                break;
            case SALARIO:
                novaConta = new ContaSalario(numeroConta, saldo, tipo, nomeDaConta);
                mensagem = "Conta criada com sucesso";
                break;
            case CORRENTE:
                novaConta = new ContaCorrente(numeroConta, saldo, tipo, nomeDaConta);
                mensagem = "Conta criada com sucesso";
                break;
            default:
                throw new ContaException("Tipo de conta inválida");
        }

        return mensagem;
    }*/

    //Metodo para criar conta Poupanca
    //verificar esse limite minimo
    public ContaPoupanca criarContaPoupanca(String numeroConta, double saldo, TipoConta tipo,
                                            Pessoa nomeDaConta, double limiteMinimo) {
        ContaBancaria novaConta = null;
        String mensagem = "";

        // Tem que ter um limite mínimo para ser criada
        if (limiteMinimo < 50.00) {
            throw new ContaException("Erro ao criar a conta poupança!! Você precisa de um limite mínimo de pelo menos R$50,00");
        } else {
            novaConta = new ContaPoupanca(numeroConta, saldo, tipo, nomeDaConta, limiteMinimo);//Tem que fazer o metodo para imprimir detalhes da conta
        }
        return (ContaPoupanca) novaConta;
    }


    //Metodo para criar conta Corrente
    public ContaCorrente criarContaCorrente(String numeroConta, double saldo, TipoConta tipo,
                                                    Pessoa nomeDaConta, double limiteMinimo) {
        ContaBancaria novaConta = null;
        String mensagem = "";

        // Tem que ter um limite mínimo para ser criada
        if (limiteMinimo < 50.00) {
            throw new ContaException("Erro ao criar a conta poupança!! Você precisa de um limite mínimo de pelo menos R$50,00");
        } else {
            novaConta = new ContaPoupanca(numeroConta, saldo, tipo, nomeDaConta, limiteMinimo);//Tem que fazer o metodo para imprimir detalhes da conta
        }
        return (ContaCorrente) novaConta;
    }


    public void depositar(double valor) {
        if (valor <= 0) {
            throw new ContaException("O valor do depósito tem que ser maior que 0");
        } else {
            this.saldo += valor;
            Transacao transacao = new Transacao("Depósito", valor);//Verificar a classe Transacao
            this.transacoes.add(transacao);
            System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
        }
    }

    public void pagar(double valor) {
        if (valor <= 0) {
            throw new ContaException("O valor do depósito tem que ser maior que 0");
        } else if (valor > this.saldo) {
            throw new ContaException("Saldo insuficiente para realizar o pagamento.");
        } else {
            this.saldo -= valor;
            Transacao transacao = new Transacao("Pagamento", -valor); // O valor do pagamento é negativo
            this.transacoes.add(transacao);
            System.out.println("Pagamento de R$" + valor + " realizado com sucesso.");
        }
    }

    public void realizarTransacao(String descricao, double valor) {
        if (valor < 0 && Math.abs(valor) > saldo) {
            // Verificação para transações de débito (saques, pagamentos, transferências)
            System.out.println("Saldo insuficiente para realizar a transação.");
        } else {
            // Atualizar o saldo e registrar a transação
            saldo += valor;
            Transacao transacao = new Transacao(descricao, valor);
            transacoes.add(transacao);
        }
    }

    public List<Transacao> gerarExtrato() {
        return transacoes;
    }

    public double calcularSaldo() {
        double saldoAtual = 0;
        for (Transacao transacao : transacoes) {
            saldoAtual += transacao.getValor();
        }
        return saldoAtual;
    }

    public void exibirExtrato() {
        System.out.println("Extrato da Conta " + numeroConta + ":");
        for (Transacao transacao : transacoes) {
            System.out.println(transacao);
        }
        System.out.println("Saldo Atual: R$" + calcularSaldo());
    }


    // Getters e setters

    public String getNumeroConta() {
        return numeroConta;
    }

    public TipoConta getTipo() {
        return tipo;
    }

    public Pessoa getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setTitular(Pessoa titular) {
        this.titular = titular;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setTipo(TipoConta tipo) {
        this.tipo = tipo;
    }

    public void setTransacoes(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }
}
