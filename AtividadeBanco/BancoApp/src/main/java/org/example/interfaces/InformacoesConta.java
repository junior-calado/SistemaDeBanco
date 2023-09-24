package org.example.interfaces;

import org.example.conta.Enum.TipoConta;
import org.example.pessoa.Pessoa;

public interface InformacoesConta {
    String getNumeroConta();
    TipoConta getTipoConta();
    Pessoa getTitular();
    double getSaldo();
}
