
package questao3;

class BateriaFraca extends Exception {}
class VeiculoOcupado extends Exception {}

public class aluguelPatinetes {
    int bateria = 15;
    boolean emUso = false;
    boolean cronometro = false;

    public void destravar() throws BateriaFraca, VeiculoOcupado {
        if (emUso) {
            throw new VeiculoOcupado();
        }
        if (bateria < 20) {
            throw new BateriaFraca();
        }

        cronometro = true;
        System.out.println("Patinete destravado!");
        System.out.println("O cronômetro de cobrança iniciado.");
    }

    public static void main(String[] args) {
        aluguelPatinetes p = new aluguelPatinetes();

        try {
            p.destravar();
        } catch (BateriaFraca e) {
            System.out.println("Erro: Bateria fraca.");
            System.out.println("Nao foi possivel destravar.");

        } catch (VeiculoOcupado e) {
            System.out.println("Erro: Patinete em uso.");
        }

        if (!p.cronometro) {
            System.out.println("O cronômetro nao foi iniciado.");
        }
    }
}

