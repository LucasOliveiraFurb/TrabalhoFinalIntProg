public class Mapa {
    private char[][] mapa = new char[3][3]; //precisa inicializa?

    public int sortear(int inicio, int fim) {
        return (int) ((Math.random() * fim) - inicio);
    }

    public void limpar() {
        for (int linha = 0; linha < mapa.length; linha++) {
            for (int coluna = 0; coluna < mapa.length; coluna++) {
                this.mapa[linha][coluna] = ' ';
            }
        }
    }

    public void desenhar(int jogada) {
        System.out.println("------------- .. jogada: " + jogada);
        System.out.println("| " + mapa[0][0] + " | " + mapa[0][1] + " | " + mapa[0][2] + " |");
        System.out.println("-------------");
        System.out.println("| " + mapa[1][0] + " | " + mapa[1][1] + " | " + mapa[1][2] + " |");
        System.out.println("-------------");
        System.out.println("| " + mapa[2][0] + " | " + mapa[2][1] + " | " + mapa[2][2] + " |");
        System.out.println("----------------------------");
    }

    public boolean jogar(int l, int c, char jogador) {

        if (this.mapa[l][c] == ' ')
        {
            this.mapa[l][c] = jogador;
            return true;
        }

        if (jogador != 'O')
            System.out.println("posição inválida!");
    
        return false;
    }

    public boolean verificarGanhador(char jogador) {
        //linha
        if ((mapa[0][0] == jogador && mapa[0][1] == jogador && mapa[0][2] == jogador) 
        || (mapa[1][0] == jogador && mapa[1][1] == jogador && mapa[1][2] == jogador) 
        || (mapa[2][0] == jogador && mapa[2][1] == jogador && mapa[2][2] == jogador)) {
            return true;
        }

        //coluna
        if ((mapa[0][0] == jogador && mapa[1][0] == jogador && mapa[2][0] == jogador) 
        || (mapa[0][1] == jogador && mapa[1][1] == jogador && mapa[2][1] == jogador) 
        || (mapa[0][2] == jogador && mapa[1][2] == jogador && mapa[2][2] == jogador)) {
            return true;
        }

        //diagonal
        if ((mapa[0][0] == jogador && mapa[1][1] == jogador && mapa[2][2] == jogador) 
        || (mapa[0][2] == jogador && mapa[1][1] == jogador && mapa[2][0] == jogador)) {
            return true;
        }

        return false;
    }
}
