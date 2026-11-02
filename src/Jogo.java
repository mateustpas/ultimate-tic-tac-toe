import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Jogo {
    private static int[] jogo = new int[81];
    private static int[] jogao = new int[9];
    private static int jogador = 1;

    public static final String[] regioes = {"NORDESTE","NORTE","NOROESTE","LESTE","CENTRAL","OESTE","SUDESTE","SUL","SUDOESTE"};
    public  final char[] simbolos = {'_','X','O'};

    public Jogo() {};

    public static int[] getJogo() {return jogo;}
    public static void setJogo(int[] jogo) {Jogo.jogo = jogo;}

    public static int[] getJogao() {return jogao;}
    public static void setJogao(int[] jogao) {Jogo.jogao = jogao;}

    public static int getJogador() {return jogador;}
    public static void setJogador(int jogador) {Jogo.jogador = jogador;}

    public boolean jogada(int jogador, int grade, int posicao) {
        if (jogo[(grade-1)*9+posicao-1] != 0) {
            return false;
        }
        getJogo()[(grade-1)*9+posicao-1] = jogador;
        return true;
    }
    public void alterar_jogador() {jogador = (jogador == 1) ? 2 : 1;}

    public void exibir() {
        for (int megalinhas = 0; megalinhas<3; megalinhas++) {
            for (int minilinhas = 0; minilinhas < 3; minilinhas++) {
                for (int tabuleiro = 0; tabuleiro < 3; tabuleiro++) {
                    for (int elemento = 0; elemento < 3; elemento++) {
                        int slot = getJogo()[elemento + tabuleiro * 9 + minilinhas * 3 + megalinhas*27];
                        System.out.printf("%c ",simbolos[slot]);
                    }
                    System.out.print("   ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
    public void limpar_tela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public boolean checar_vitoria(int[] jogo, int jogador) {
        if (jogo.length != 9) {throw new IllegalArgumentException();}

        int c=0;
        //LINHAS
        for (int linha = 0; linha < 3; linha++) {
            c=0;
            for (int elemento = 0; elemento < 3; elemento++) {if (jogo[elemento + linha * 3] == jogador) {c++;} else {c = 0;}}
            if (c==3) {return true;}}
        //COLUNAS
        for (int coluna = 0; coluna<3; coluna++) {
            c=0;
            for (int elemento = 0; elemento < 3; elemento++) {if (jogo[coluna + elemento * 3] == jogador) {c++;} else {c = 0;}}
            if (c==3) {return true;}}

        //DIAGONAL
        c=0; for (int elemento = 0; elemento < 3; elemento++) {if (jogo[elemento + elemento * 3] == jogador) {c++;} else {c = 0;}}; if (c==3) {return true;}
        c=0; for (int elemento = 0; elemento < 3; elemento++) {if (jogo[2 - elemento + elemento * 3] == jogador) {c++;} else {c = 0;}} if(c==3) {return true;}

        return false;
    }

    public void atualizar_jogao(int quadrante, int jogador) {jogao[quadrante] = jogador;}

    public void iniciar_jogo() {
        Scanner scanner = new Scanner(System.in);
        //Cortesia
        limpar_tela();
        System.out.println("Iniciando o mega jogo-da-velha!");
        System.out.println("Comece o jogo!\n Digite primeiro o quadrante e depois a coordenada!");

        int quadrante = scanner.nextInt();
        int casa = scanner.nextInt();

        //Jogada inicial
        jogada(this.jogador, quadrante, casa);
        int proxima = casa;

        while (true) {
            limpar_tela();
            exibir();
            for (int i = 0; i<9;i++) {
                if(checar_vitoria(Arrays.copyOfRange(jogo,(i*9),(i*9)+9),jogador)) {
                    if (jogao[i] == 0) {
                        jogao[i] = jogador;
                        System.out.printf("Quadrante %s dominado pelo [%c]\n",regioes[i],simbolos[jogador]);}
                    for (int k = 0; k<3;k++) {
                        for (int m = 0; m<3;m++) {
                            System.out.printf("%c ", simbolos[jogao[k*3+m]]);
                        }
                        System.out.println();
                    }
                    System.out.println();
                }
            }
            if (checar_vitoria(jogao, this.jogador)) {break;}
            alterar_jogador();


            System.out.printf("Jogador [%c], faça sua jogada no quadrante %s!",simbolos[jogador], regioes[casa-1]);
            System.out.println();

            while(true) {
                int posicao = scanner.nextInt();
                if(jogada(this.jogador, casa, posicao)) {casa = posicao; break;}
                System.out.println("Posição ocupada, tente outra!");

            }


        }
        System.out.printf("!!!!!O JOGO ACABOU!!!!!\nO JOGADOR [%c] VENCEU O MEGA JOGO-DA-VELHA!\n",simbolos[jogador]);

    }

}

