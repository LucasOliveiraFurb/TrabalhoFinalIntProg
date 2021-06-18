import java.util.Scanner;

public class Jogador {
    private final char letra = 'X';
    private Mapa mapa;

    public Jogador(Mapa mapa) {
        this.mapa = mapa;
    }

    public boolean jogar(Scanner teclado) {
        int linha = 0;
        int coluna = 0;

        do {
            System.out.println("Jogador ..");
            System.out.print("  linha: ");
            linha = teclado.nextInt();
            System.out.print("  coluna: ");
            coluna = teclado.nextInt();
        }
        while ((linha < 0 || linha > 2) || (coluna < 0 || coluna > 2)
              || !this.mapa.jogar(linha, coluna, letra));

        if (this.mapa.verificarGanhador(letra))
        {
            System.out.println("...Jogador GANHOU!");
            return true;
        }

        return false;
    }
}
