public class Regras {

    protected static int vencedor(int pontosPessoa, int pontosComputador) {
        if (pontosPessoa > 21 && pontosComputador > 21) {
            return 0;
        } else if ((pontosComputador > 21) || (pontosPessoa <= 21 && pontosPessoa > pontosComputador)) {
            return 1;
        } else if ((pontosPessoa > 21 || (pontosComputador <= 21 && pontosPessoa < pontosComputador))) {
            return 2;
        } else {
            return 3;
        }
    }
}
