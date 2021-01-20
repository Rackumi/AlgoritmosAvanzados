import java.util.Random;

public class Practica_6 {

    public static int menosCajasProb (int[] ps, int c) {
        int[] cajas = new int[ps.length];
        Random random = new Random();
        int caja;
        for(int i: ps){
            do {
                caja = random.nextInt(ps.length);
            }while (c - cajas[caja] < i);
            cajas[caja] += i;
        }
        int numCajas = 0;
        for(int uwu: cajas)
            if(uwu > 0)
                numCajas++;
        return numCajas;
    }

    public static int menosCajasProbX10 (int[] ps, int c) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            min = Math.min(min, menosCajasProb(ps, c));
        }
        return min;
    }

    public static int menosCajasProbMejora (int[] ps, int c) {
        int[] cajas = new int[ps.length];
        Random random = new Random();
        int caja;
        int cajasOcupadas = 0;
        for (int p : ps) {
            do {
                caja = random.nextInt(cajasOcupadas + 1);
            } while (c - cajas[caja] < p);
            if (cajas[caja] == 0)
                cajasOcupadas++;
            cajas[caja] += p;
        }
        return cajasOcupadas;
    }

    public static int menosCajasBack (int[] ps, int c) {
        int[] cajas = new int[ps.length];
        cajas[0] = c-ps[0];
        for (int i=1; i<ps.length; i++)
            cajas[i] = c;
        int[] cajasOpt = new int[ps.length];
        return buscarCajas (ps, 1, 1, cajas, ps.length, cajasOpt);
    }

    private static int buscarCajas (int[] ps, int i, int n, int[] cajas, int nOpt, int[] cajasOpt) {
        // versión basada en el esquema de la técnica de vuelta atrás para solución óptima
        for (int j=1; j<=n+1; j++)
            if (ps[i]<=cajas[j-1]) {
                cajas[j-1] -= ps[i];
                int nn = Math.max(n,j);
                if (i==ps.length-1) {
                    if (n<nOpt) {
                        nOpt = nn;
                        System.arraycopy(cajas, 0, cajasOpt, 0, nn);
                    }
                }
                else
                    nOpt = buscarCajas (ps, i+1, nn, cajas, nOpt, cajasOpt);
                cajas [j-1] += ps[i];
            }
        return nOpt;
    }

}
