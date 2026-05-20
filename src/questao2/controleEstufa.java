package questao2;

import java.util.Scanner;

class LeituraInconsistente extends Exception {}
class FalhaNoAtuador extends Exception {}

public class controleEstufa {

    boolean falhaNoSistema = false;

    public void verificarTemperatura(double temperatura) throws LeituraInconsistente, FalhaNoAtuador {
        try {
            if (temperatura >= 100 || temperatura <= -50) {
                throw new LeituraInconsistente();
            }

            if (temperatura > 35) {
                if (falhaNoSistema) throw new FalhaNoAtuador();
                System.out.println("Ventilador ligado.");
            } else if (temperatura < 10) {
                if (falhaNoSistema) throw new FalhaNoAtuador();
                System.out.println("Aquecedor ligado.");
            } else {
                System.out.println("Temperatura estabilizada.");
            }

        } finally {
            System.out.println("Registro de atividade atualizado no sistema.");
        }
    }

    public static void main(String[] args) {
        controleEstufa estufa = new controleEstufa();
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite a leitura do sensor: ");
        double leitura = entrada.nextDouble();

        try {
            estufa.verificarTemperatura(leitura);
        } catch (LeituraInconsistente e) {
            System.out.println("Erro!! Leitura do sensor incorreta.");
        } catch (FalhaNoAtuador e) {
            System.out.println("Erro!!!! O atuador nao respondeu ao comando.");
        }

        entrada.close();
    }
}