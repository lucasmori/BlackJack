import java.util.ArrayList;

public class Jogador {
    private ArrayList<Carta> mao = new ArrayList<Carta>();
    private int pontos = 0;

    protected ArrayList<Carta> pegar(ArrayList<Carta> baralho) {
        mao.add(baralho.get(0));
        baralho.remove(0);
        return mao;
    }

    protected int somar(ArrayList<Carta> maoJogador) {
        pontos = 0;
        for (int i = 0; i < maoJogador.size(); i++) {
            pontos += maoJogador.get(i).carta;
        }
        return pontos;
    }

    public ArrayList<Carta> getMao() {
        return mao;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

}