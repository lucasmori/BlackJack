import java.util.ArrayList;

public class JogadorPessoa extends Jogador {

    protected int atualizar(ArrayList<Carta> maoJogador) {
        setPontos(somar(maoJogador));
        return getPontos();
    }

    protected ArrayList<Carta> mostrarMao() {
        return getMao();
    }
}
