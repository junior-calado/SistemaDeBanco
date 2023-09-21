package org.example.conta.Enum;

public enum TipoConta {
    POUPANCA("Conta Poupança"),
    SALARIO("Conta Salário"),
    CORRENTE("Conta Corrente");

    private final String descricao;

    TipoConta(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

