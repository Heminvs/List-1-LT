package questao1;

import java.util.Scanner;

class SaldoInsuficiente extends Exception {}
class FaltaDeCedulas extends Exception {}

public class caixaeletronico {
    double saldo = 100.0;
    double notasNoCaixa = 80.0;

    public void sacar(double valor) throws SaldoInsuficiente, FaltaDeCedulas {
        if (valor > saldo) {
            throw new SaldoInsuficiente();
        }

        saldo -= valor;

        try {
            if (valor > notasNoCaixa) {
                throw new FaltaDeCedulas();
            }
            notasNoCaixa -= valor;

        } catch (FaltaDeCedulas e) {
            saldo += valor;
            throw e;
        }
    }

    public static void main(String[] args) {
        caixaeletronico caixa = new caixaeletronico();
        Scanner entrada = new Scanner(System.in);

        System.out.println("Saldo inicial: R$ " + caixa.saldo);
        System.out.print("Digite o valor do saque: R$ ");

        double valorDesejado = entrada.nextDouble();

        try {
            System.out.println("Tentando sacar R$ " + valorDesejado + "...");
            caixa.sacar(valorDesejado);
            System.out.println("Saque realizado com sucesso!");

        } catch (SaldoInsuficiente e) {
            System.out.println("Erro: Saldo insuficiente na conta.");
        } catch (FaltaDeCedulas e) {
            System.out.println("Erro: O caixa não possui cédulas suficientes para este valor.");
        }

        System.out.println("Saldo final: R$ " + caixa.saldo);

        entrada.close();
    }
}

