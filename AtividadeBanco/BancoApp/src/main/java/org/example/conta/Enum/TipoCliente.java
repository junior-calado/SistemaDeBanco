package org.example.conta.Enum;

public enum TipoCliente {
    PESSOA_FISICA("Pessoa Física"),
    PESSOA_JURIDICA("Pessoa Jurídica");

    //descrição associada a cada valor enum
    //exibir informações para o usuário quando necessário.

    private final String descricao;

    TipoCliente(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

