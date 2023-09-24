package org.example.conta;

import org.example.conta.Enum.TipoConta;
import org.example.conta.Excetions.ContaException;
import org.example.conta.tipoDeConta.ContaCorrente;
import org.example.conta.tipoDeConta.ContaPoupanca;
import org.example.conta.tipoDeConta.ContaSalario;
import org.example.interfaces.InformacoesConta;
import org.example.pessoa.Pessoa;

import java.util.List;

public class ContaBancaria implements InformacoesConta {
    private String numeroConta;
    private double saldo;
    private TipoConta tipo;
    private Pessoa titular;
    private List<Transacao> transacoes;


    private Financiamento financiamento;

    //Constructor
    public ContaBancaria(String numeroConta, double saldo, TipoConta tipo, Pessoa nomeDaConta) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.tipo = tipo;
        this.titular = nomeDaConta;
        this.financiamento = new Financiamento(0.0, 0);
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
    public ContaPoupanca criarContaPoupanca(TipoConta tipo,
                                            Pessoa nomeDaConta, double limiteMinimo) {
        ContaBancaria novaConta = null;
        String mensagem = "";

        // Tem que ter um limite mínimo para ser criada
        if (limiteMinimo < 50.00) {
            throw new ContaException("Erro ao criar a conta poupança!! Você precisa de um limite mínimo de pelo menos R$50,00");
        } else {
            novaConta = new ContaPoupanca(this.numeroConta, this.saldo, tipo, nomeDaConta, limiteMinimo);//Tem que fazer o metodo para imprimir detalhes da conta
        }
        return (ContaPoupanca) novaConta;
    }


    //Metodo para criar conta Corrente
    //talvez tirar o limite de cheque
    public ContaCorrente criarContaCorrente(Pessoa nomeDaConta,
                                            TipoConta tipo, double limiteCheque) {
        ContaBancaria novaConta = null;

        novaConta = new ContaCorrente(this.numeroConta, this.saldo, tipo, nomeDaConta, limiteCheque);//Tem que fazer o metodo para imprimir detalhes da conta

        return (ContaCorrente) novaConta;
    }

    //Metodo para criar conta Salario
    public ContaSalario criarContaSalario(TipoConta tipo, double limiteSaqueDiario) {
        ContaBancaria novaConta = null;

        novaConta = new ContaSalario(this.numeroConta, this.titular, this.saldo, tipo, limiteSaqueDiario);//Tem que fazer o metodo para imprimir detalhes da conta

        return (ContaSalario) novaConta;
    }







    public double solicitarFinanciamento(double valorSolicitado) {
        if (valorSolicitado <= 0) {
            throw new IllegalArgumentException("O valor do financiamento deve ser maior que zero.");
        }

        double valorParcela = financiamento.calcularValorParcela(valorSolicitado);

        // Execute a lógica de processamento do financiamento
        // Por exemplo, adicione o valor do financiamento ao saldo da conta

        // Neste exemplo, apenas retornaremos o valor do financiamento
        double valorFinanciado = valorSolicitado;

        // Registre a transação de financiamento
        Transacao transacao = new Transacao("Financiamento", valorFinanciado);
        transacoes.add(transacao);

        // Atualize o saldo da conta (adicione o valor do financiamento)
        saldo += valorFinanciado;

        // Retorne o valor efetivamente financiado
        return valorFinanciado;
    }












    public void depositar(double valor) {
        if (valor <= 0) {
            throw new ContaException("O valor do depósito tem que ser maior que 0");
        } else {
            this.saldo += valor;
            Transacao transacao = new Transacao("Depósito", valor);
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



    public TipoConta getTipo() {
        return tipo;
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



    @Override
    public String getNumeroConta() {
        return numeroConta;
    }

    @Override
    public TipoConta getTipoConta() {
        return tipo;
    }

    @Override
    public Pessoa getTitular() {
        return titular;
    }

    @Override
    public double getSaldo() {
        return saldo;
    }


}
