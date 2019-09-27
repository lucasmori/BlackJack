import java.util.ArrayList;
import java.util.Collections;

public class Baralho {
    private int[] cartas = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private String[] naipes = {"ESPADA", "OURO", "COPAS", "PAUS"};
    private ArrayList<Carta> deck = new ArrayList<Carta>();

    protected ArrayList<Carta> gerarBaralho() {
        for (int i = 0; i < cartas.length; i++) {
            for (int j = 0; j < naipes.length; j++) {
                deck.add(new Carta(naipes[j], cartas[i]));
            }
        }
        Collections.shuffle(deck);
        return deck;
    }
}
