public class Practica_5_Algorex {

    public static int sedesH2 (int[] c0, int[] c1, int f){
        int actual;
        int coste;
        if(c1[0] > c0[0]){
            coste = c0[0];
            actual = 0;
        } else {
            coste = c1[0];
            actual = 1;
        }
        for (int i = 1; i < c0.length; i++) {
            if(actual == 1){
                if(c1[i] > c0[i] + f){
                    coste += c0[i] + f;
                    actual = 0;
                } else
                    coste += c1[i];
            } else {
                if(c0[i] > c1[i] + f){
                    coste += c1[i] + f;
                    actual = 1;
                } else
                    coste += c0[i];
            }
        }
        return coste;
    }

    private static int btMax;

    public static int sedesBT_Wrapper (int[] c0, int[] c1, int f){
        btMax = Integer.MAX_VALUE;
        sedesBT(c0, c1, f, 0, 0, -1);
        return btMax;
    }

    private static int sedesBT(int[] c0, int[] c1, int f, int i, int acc, int anterior){
        if(i < c0.length){
            int valorAux;
            int valorActual;
            if(anterior == 1)
                valorActual = acc + c0[i] + f;
            else
                valorActual = acc + c0[i];

            valorAux = sedesBT(c0, c1, f, i+1, valorActual, 0);
            if(valorAux < btMax)
                btMax = valorAux;

            if(anterior == 0)
                valorActual = acc + c1[i] + f;
            else
                valorActual = acc + c1[i];

            valorAux = sedesBT(c0, c1, f, i+1, valorActual, 1);
            if(valorAux < btMax)
                btMax = valorAux;
            return btMax;
        } else
            return acc;
    }

    public static int sedesRecWrapper (int[] c0, int[] c1, int f){
        return sedesRec(c0, c1, f, 0, 0);
    }

    public static int sedesRec (int[] c0, int[] c1, int f, int i, int a){
        if(i == c0.length)
            return 0;
        else if(i == 0)
            return Math.min((c0[i] + sedesRec(c0, c1, f, i+1, 0)), (c1[i] + sedesRec(c0, c1, f, i+1, 1)));
        else
        if(a == 0)
            return Math.min((c0[i] + sedesRec(c0, c1, f, i+1, 0)), (c1[i] + sedesRec(c0, c1, f, i+1, 1) + f));
        else
            return Math.min((c0[i] + sedesRec(c0, c1, f, i+1, 0) + f), (c1[i] + sedesRec(c0, c1, f, i+1, 1)));
    }

    public static int sedesDin (int[] c0, int[] c1, int f) {
        int[][] tabla = new int[c0.length + 1][2];

        for (int i = c0.length; i >= 0; i--) {
            if(i == c0.length){
                tabla[i][0] = 0;
                tabla[i][1] = 0;
            }else if(i == 0){
                tabla[i][0] = Math.min((c0[i] + tabla[i+1][0]), (c1[i] + tabla[i+1][1]));
            } else {
                tabla[i][0] = Math.min((c0[i] + tabla[i + 1][0]), (c1[i] + tabla[i + 1][1] + f));
                tabla[i][1] = Math.min((c0[i] + tabla[i + 1][0] + f), (c1[i] + tabla[i + 1][1]));
            }
        }

        return tabla[0][0];
    }


}
