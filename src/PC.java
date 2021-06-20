public class PC {
    private final char letra = 'O';
    private Mapa mapa;

    public PC(Mapa mapa) {
        this.mapa = mapa;
    }

    public boolean jogar() {
        int linha = 0;
        int coluna = 0;

        do {
            linha = this.mapa.sortear(0, 3);
            coluna = this.mapa.sortear(0, 3);
        }
        while (!this.mapa.jogar(linha, coluna, letra));

        System.out.println("PC[" + linha + "," + coluna + "]");

        if (this.mapa.verificarGanhador(letra))
        {
            System.out.println("...PC GANHOU!");
            return true;
        }

        return false;
    }
}
