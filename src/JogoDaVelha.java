import java.util.Scanner;

public class JogoDaVelha {
    private Mapa jogoMapa;
    private PC jogoPC;
    private Jogador jogoJogador;

    private JogoDaVelha() {
        Scanner teclado = new Scanner(System.in);

        this.jogoMapa = new Mapa();
        this.jogoPC = new PC(jogoMapa);
        this.jogoJogador = new Jogador(jogoMapa);

        char letraEscolhida;
        do
        {
            jogar(teclado);

            System.out.println("Deseja jogar novamente (s/n)?");
            letraEscolhida = teclado.next().charAt(0);
        }
        while (letraEscolhida == 's');
    }

    private void jogar(Scanner teclado) {
        this.jogoMapa.limpar();

        int escolhaIniciante = this.jogoMapa.sortear(1, 2); // 1 - pessoa 2 - computador
        
        for (int qtdeJogadas = 0; qtdeJogadas <= 9; qtdeJogadas++) {
            this.jogoMapa.desenhar(qtdeJogadas);

            if (escolhaIniciante == 1) {
                if (jogoJogador.jogar(teclado))
                {
                    this.jogoMapa.desenhar(qtdeJogadas + 1);
                    break;
                }

                escolhaIniciante = 2;
            }
            else {
                if (jogoPC.jogar())
                {
                    this.jogoMapa.desenhar(qtdeJogadas + 1);
                    break;
                }
                escolhaIniciante = 1;
            }
        }

    }
    public static void main(String[] args) {
        new JogoDaVelha();
    }
}
