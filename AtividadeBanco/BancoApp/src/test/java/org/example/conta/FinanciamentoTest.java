package org.example.conta;

import org.example.conta.Enum.TipoCliente;
import org.example.conta.Enum.TipoConta;
import org.example.pessoa.Pessoa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FinanciamentoTest {

    @Test
    public void testSolicitarFinanciamento() {

        Pessoa rafa = new Pessoa("rafael gonsalves", "12345678900", "789456123", "user@email.com",
                "44 9 9988-9988","Rua JK",
                TipoCliente.PESSOA_LIVRE, 5000.00 );


        // Crie uma instância de ContaBancaria (ou use um objeto mock, se necessário)
        ContaBancaria conta = new ContaBancaria("1357", 5000.0, TipoConta.SALARIO, rafa);

        // Solicite um financiamento de R$ 1000
        double valorSolicitado = 1000.0;
        double valorFinanciado = conta.solicitarFinanciamento(valorSolicitado);

        // Verifique se o valor financiado é igual ao valor solicitado
        assertEquals(valorSolicitado, valorFinanciado, 0.01);
    }
}
