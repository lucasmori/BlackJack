import java.util.ArrayList;
import java.util.Scanner;

public class Jogo {

    public static void main(String[] args) {
        Baralho baralho = new Baralho();
        ArrayList<Carta> deck;

        JogadorPessoa humano = new JogadorPessoa();
        JogadorComputador pc = new JogadorComputador();

        int vencedor = 0;
        double humanoDinheiro = 100.00;

        deck = baralho.gerarBaralho();

        humano.pegar(deck);
        humano.pegar(deck);

        Scanner scanner = new Scanner(System.in); // input do humano


        //loop
        while (humanoDinheiro > 0) {
            System.out.println("Voce tem R$" + humanoDinheiro + ", quanto deseja apostas?");
            double humanoAposta = scanner.nextDouble();

            if (humanoAposta > humanoDinheiro) {
                System.out.println("Voce não pode apostas mais do que voce tem.");
                break;
            }


            while (true) {
                System.out.println("Voce recebeu duas cartas do baralho");
                System.out.println("Voce esta com essas cartas em sua mão:");
                for (int i = 0; i < humano.mostrarMao().size(); i++) {
                    System.out.println(humano.mostrarMao().get(i).naipe + " : " + humano.mostrarMao().get(i).carta);
                }
                System.out.println("\nSua pontuação: " + humano.atualizar(humano.getMao()));

                // O que voce quer fazer?
                System.out.println("Voce gostaria de (1)continuar ou (2)parar?");
                int response = scanner.nextInt();

                //Escolheu 1
                if (response == 1) {
                    humano.pegar(deck);
                    System.out.println("\nSua pontuação: " + humano.atualizar(humano.getMao()));

                    if (humano.getPontos() > 21) {
                        System.out.println("Estourou. Com o valor de: " + humano.atualizar(humano.getMao()) + " pontos.");
                        humanoDinheiro -= humanoAposta;
                        break;
                    }
                }
                // parar de jogar
                if (response == 2) {
                    break;
                }
            }
            while (pc.atualizar(pc.getMao())) {
                pc.pegar(deck);
            }
            vencedor = Regras.vencedor(humano.getPontos(), pc.getPontos());
            if (vencedor == 0) {
                System.out.println("\nOs dois jogadores estouraram");

            } else if (vencedor == 1) {
                System.out.println("\nO Humano venceu!");
                humanoDinheiro += humanoAposta;

            } else if (vencedor == 2) {
                System.out.println("\nO PC venceu!");
                humanoDinheiro -= humanoAposta;

            } else {
                System.out.println("\nEmpate no jogo!");
            }

            System.out.println("Pressione (1) para mostrar as maos ou (2) para sair.");

            int mostrarMaos = scanner.nextInt();
            if (mostrarMaos == 1) {
                System.out.println("\n\t\t-MAO DA PESSOA-");
                for (int i = 0; i < humano.mostrarMao().size(); i++) {
                    System.out.println(humano.mostrarMao().get(i).naipe + " : " + humano.mostrarMao().get(i).carta);
                }
                System.out.println("Com o total de: " + humano.getPontos() + " pontos.");
                System.out.println("\n\t\t-MAO DO COMPUTADOR-");
                for (int i = 0; i < pc.mostrarMao().size(); i++) {
                    System.out.println(pc.mostrarMao().get(i).naipe + " : " + pc.mostrarMao().get(i).carta);
                }
                System.out.println("Com o total de: " + pc.getPontos() + " pontos.");
                System.out.println();
            } else {
                scanner.close();
                break;
            }
        }
    }
}
