public class Practica_2 {

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

    public static void main(String[] args) {
        int coste = sedesH1(new int[]{1,3,20,30}, new int[]{50,20,2,4}, 10);
        System.out.print("Coste total calculado por el algoritmo H1: ");
        System.out.println(coste);
        coste = sedesH2(new int[]{1,3,20,30}, new int[]{50,20,2,4}, 10);
        System.out.print("Coste total calculado por el algoritmo H2: ");
        System.out.println(coste);
    }

}
