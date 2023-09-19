package org.example.conta.Enum;

public enum StatusTransacao {
    CONCLUIDA("Concluída"),
    PENDENTE("Pendente"),
    CANCELADA("Cancelada"),
    FALHA("Falha"),
    OUTROS("Outros");

    private final String descricao;

    StatusTransacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
