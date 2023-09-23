package org.example.conta.tipoDeConta;

import org.example.conta.Aplicacao;
import org.example.conta.ContaBancaria;
import org.example.conta.Enum.TipoConta;
import org.example.conta.Transacao;
import org.example.pessoa.Pessoa;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class ContaPoupanca extends ContaBancaria {
    private double limiteMinimo;
    private double taxaRendimento;

    private List<Transacao> transacao;
    private LocalDateTime dataAbertura;

    public ContaPoupanca( String numeroConta, double saldo, TipoConta tipo, Pessoa nomeDaConta,
                         double limiteMinimo) {
        super(numeroConta, saldo, tipo, nomeDaConta);
        this.limiteMinimo = limiteMinimo;
        this.taxaRendimento = 0.03; // Taxa de rendimento padrão (3% ao ano)
        this.dataAbertura = LocalDateTime.of(2013, Month.JANUARY, 1, 0, 0, 0);
        //this.dataAbertura = LocalDateTime.now();
    }

    //getter and Setters
    public double getLimiteMinimo() {
        return limiteMinimo;
    }

    public void setLimiteMinimo(double limiteMinimo) {
        this.limiteMinimo = limiteMinimo;
    }

    public List<Transacao> getTransacao() {
        return transacao;
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }


    @Override
    public void realizarTransacao(String descricao, double valor) {
        if (valor == 0) {
            System.out.println("O valor da transação deve ser diferente de zero.");
        } else {
            double novoSaldo = getSaldo() - valor;
            if (novoSaldo >= limiteMinimo) {
                // Transação permitida, atualiza o saldo
                setSaldo(novoSaldo);
                Transacao transacao = new Transacao(descricao, valor);
                System.out.println("Transação de " + descricao + " no valor de R$" + valor + " realizada com sucesso.");
            } else {
                System.out.println("Saldo insuficiente para realizar a transação.");
            }
        }
    }

    public double consultarRendimentos() {
        // Calcular os rendimentos com base na taxa de rendimento e no tempo decorrido
        LocalDateTime dataAtual = LocalDateTime.now();
        LocalDateTime dataAbertura = getDataAbertura();
        long meses = dataAbertura.until(dataAtual, ChronoUnit.MONTHS);

        double saldoAtual = getSaldo();
        double taxaJurosMensal = taxaRendimento / 12.0 / 100.0; // Taxa de juros mensal

        // Fórmula de juros compostos: Saldo * (1 + taxa de juros mensal)^meses - Saldo
        double rendimentos = saldoAtual * (Math.pow(1 + taxaJurosMensal, meses) - 1);

        return rendimentos;
    }

    @Override
    public String toString() {
        return "Conta Poupança - Número: " + getNumeroConta() +
                "\nTitular: " + getTitular().getNome() +
                "\nRendimentos: " + consultarRendimentos() +
                "\nSaldo Atual: R$" + getSaldo();
    }


}

