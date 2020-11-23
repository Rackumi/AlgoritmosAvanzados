public class Practica_3b {

    private static int nodosBT = 0;
    private static int nodosBTPoda = 0;

    public static int sedesH1 (int[] c0, int[] c1, int f){
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
            if(c1[i] > c0[i]){
                coste += c0[i];
                if(actual == 1)
                    coste += f;
                actual = 0;
            } else {
                coste += c1[i];
                if(actual == 0)
                    coste +=f;
                actual = 1;
            }
        }
        return coste;
    }

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
            nodosBT++;
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
            nodosBT++;
        return acc;
    }

    private static int btMaxpoda;

    public static int sedesBTPoda_Wrapper (int[] c0, int[] c1, int f){
        btMaxpoda = Integer.MAX_VALUE;
        return sedesBTPoda(c0, c1, f, 0, 0, -1);
    }

    private static int sedesBTPoda(int[] c0, int[] c1, int f, int i, int acc, int anterior){
        if(i < c0.length){
            nodosBTPoda++;
            int valorAux = -1;

            int valorActual;
            if(anterior == 1)
                valorActual = acc + c0[i] + f;
            else
                valorActual = acc + c0[i];

            if(valorActual < btMaxpoda)
                valorAux = sedesBTPoda(c0, c1, f, i+1, valorActual, 0);
            if(valorAux != -1 && valorAux < btMaxpoda)
                btMaxpoda = valorAux;

            if(anterior == 0)
                valorActual = acc + c1[i] + f;
            else
                valorActual = acc + c1[i];

            if(valorActual < btMaxpoda)
                valorAux = sedesBTPoda(c0, c1, f, i+1, valorActual, 1);
            if(valorAux != -1 && valorAux < btMaxpoda)
                btMaxpoda = valorAux;
            return btMaxpoda;
        } else
            nodosBTPoda++;
        return acc;
    }

    public static void main(String[] args) {
        int coste = sedesH1(new int[]{20,23,27,2,41,23,22,16,44,2,29,5}, new int[]{14,34,1,29,3,14,45,4,43,4,12,15}, 5);
        System.out.print("Coste total calculado por el algoritmo H1: ");
        System.out.println(coste);

        coste = sedesH2(new int[]{20,23,27,2,41,23,22,16,44,2,29,5}, new int[]{14,34,1,29,3,14,45,4,43,4,12,15}, 5);
        System.out.print("Coste total calculado por el algoritmo H2: ");
        System.out.println(coste);

        coste = sedesBT_Wrapper(new int[]{20,23,27,2,41,23,22,16,44,2,29,5}, new int[]{14,34,1,29,3,14,45,4,43,4,12,15}, 5);
        System.out.print("Coste total calculado por el algoritmo BT: ");
        System.out.println(coste);
        System.out.println("Numero de nodos: " + nodosBT);

        coste = sedesBTPoda_Wrapper(new int[]{20,23,27,2,41,23,22,16,44,2,29,5}, new int[]{14,34,1,29,3,14,45,4,43,4,12,15}, 5);
        System.out.print("Coste total calculado por el algoritmo BT con poda: ");
        System.out.println(coste);
        System.out.println("Numero de nodos: " + nodosBTPoda);
    }

}
