package org.example.pessoa;

import org.example.conta.ContaBancaria;
import org.example.conta.Enum.TipoCliente;
import org.example.conta.Enum.TipoConta;
import org.example.conta.Excetions.ContaException;
import org.example.conta.tipoDeConta.ContaCorrente;
import org.example.conta.tipoDeConta.ContaPoupanca;
import org.example.conta.tipoDeConta.ContaSalario;

public class Pessoa {

    private String nome;
    private String cpf;
    private String rg;
    private String mail;
    private String telefone;
    private String endereco;
    private TipoCliente tipo;
    private Double salario;

    public Pessoa(String nome, String cpf, String rg, String mail, String telefone,
                  String endereco, TipoCliente tipo, Double salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.mail = mail;
        this.telefone = telefone;
        this.endereco = endereco;
        this.tipo = tipo;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return salario;
    }
}
