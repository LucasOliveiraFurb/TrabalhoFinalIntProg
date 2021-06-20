public class Mapa {
    private char[][] mapa = new char[3][3];

    public int sortear(int inicio, int fim) {
        return (int) ((Math.random() * fim) - inicio);
    }

    public void limpar() {
        for (int linha = 0; linha < this.mapa.length; linha++) {
            for (int coluna = 0; coluna < this.mapa.length; coluna++) {
                this.mapa[linha][coluna] = ' ';
            }
        }
    }

    public void desenhar(int jogada) {
        System.out.println("------------- .. jogada: " + jogada);
        System.out.println("| " + this.mapa[0][0] + " | " + this.mapa[0][1] + " | " + this.mapa[0][2] + " |");
        System.out.println("-------------");
        System.out.println("| " + this.mapa[1][0] + " | " + this.mapa[1][1] + " | " + this.mapa[1][2] + " |");
        System.out.println("-------------");
        System.out.println("| " + this.mapa[2][0] + " | " + this.mapa[2][1] + " | " + this.mapa[2][2] + " |");
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
        if ((this.mapa[0][0] == jogador && this.mapa[0][1] == jogador && this.mapa[0][2] == jogador) 
        || (this.mapa[1][0] == jogador && this.mapa[1][1] == jogador && this.mapa[1][2] == jogador) 
        || (this.mapa[2][0] == jogador && this.mapa[2][1] == jogador && this.mapa[2][2] == jogador)) {
            return true;
        }

        //coluna
        if ((this.mapa[0][0] == jogador && this.mapa[1][0] == jogador && this.mapa[2][0] == jogador) 
        || (this.mapa[0][1] == jogador && this.mapa[1][1] == jogador && this.mapa[2][1] == jogador) 
        || (this.mapa[0][2] == jogador && this.mapa[1][2] == jogador && this.mapa[2][2] == jogador)) {
            return true;
        }

        //diagonal
        if ((this.mapa[0][0] == jogador && this.mapa[1][1] == jogador && this.mapa[2][2] == jogador) 
        || (this.mapa[0][2] == jogador && this.mapa[1][1] == jogador && this.mapa[2][0] == jogador)) {
            return true;
        }

        return false;
    }
}
