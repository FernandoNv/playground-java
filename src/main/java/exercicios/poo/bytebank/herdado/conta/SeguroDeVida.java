package exercicios.poo.bytebank.herdado.conta;

public class SeguroDeVida implements Tributavel {

    @Override
    public double getValorImposto() {
        return 42;
    }

}
