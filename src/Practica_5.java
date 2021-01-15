public class Practica_5 {

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

//    private static int[][] tabla;
//    private static int[] c0, c1;
//    private static int f;
//
//    public static int sedesDinWrapper (int[] c0_, int[] c1_, int f_) {
//        c0 = c0_;
//        c1 = c1_;
//        f = f_;
//        tabla = new int[c0.length + 1][2];
//        for (int i = 0; i < c0.length; i++) {
//            tabla[i][0] = -1;
//            tabla[i][1] = -1;
//        }
//        sedesDin(0,0);
//
//        int[] decisiones = new int[c0.length];
//        for (int i = 0; i < c0.length; i++) {
//            if(tabla[i+1][0] < tabla[i+1][1]){
//                decisiones[i] = 0;
//            } else
//                decisiones[i] = 1;
//        }
//
//        for (int i = 0; i < decisiones.length; i++) {
//            if(i == 0)
//                System.out.print("Decisiones : {");
//            System.out.print(decisiones[i]);
//            if(i != decisiones.length -1){
//                System.out.print(", ");
//            }
//        }
//        System.out.println("}");
//
//        return tabla[0][0];
//    }
//
//    public static void sedesDin(int i, int a) {
//        if(tabla[i][a] == -1){
//            if (i == c0.length)
//                tabla[i][a] = 0;
//            else if (i == 0) {
//                sedesDin(i+1, 0);
//                sedesDin(i+1, 1);
//                tabla[i][a] = Math.min((c0[i] + tabla[i+1][0]), (c1[i] + tabla[i+1][1]));
//            } else {
//                sedesDin(i+1, 0);
//                sedesDin(i+1, 1);
//                tabla[i][a] = Math.min((c0[i] + tabla[i+1][0] + a * f), (c1[i] + tabla[i+1][1] - (a-1) * f));
//            }
//        }
//    }


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

        int[] decisiones = new int[c0.length];
        for (int i = 0; i < c0.length; i++) {
            if(c0[i] + tabla[i+1][0] < c1[i] + tabla[i+1][1]){
                decisiones[i] = 0;
            } else
                decisiones[i] = 1;
        }

        for (int i = 0; i < decisiones.length; i++) {
            if(i == 0)
                System.out.print("Decisiones : {");
            System.out.print(decisiones[i]);
            if(i != decisiones.length -1){
                System.out.print(", ");
            }
        }
        System.out.println("}");

        return tabla[0][0];
    }



    public static void main(String[] args) {
        int coste = sedesRecWrapper(new int[]{20, 23, 27, 2, 41, 23, 22, 16, 44, 2, 29, 5}, new int[]{14, 34, 1, 29, 3, 14, 45, 4, 43, 4, 12, 15}, 5);
        System.out.print("Coste rec: ");//     0   1   2  3   4   5   6   7   8  9  10  11             0   1  2   3  4   5   6  7   8  9  10  11
        System.out.println(coste);

//        coste = sedesDinWrapper(new int[]{20, 23, 27, 2, 41, 23, 22, 16, 44, 2, 29, 5}, new int[]{14, 34, 1, 29, 3, 14, 45, 4, 43, 4, 12, 15}, 5);
//        System.out.print("Coste tabla: ");
//        System.out.println(coste);

        coste = sedesDin(new int[]{20, 23, 27, 2, 41, 23, 22, 16, 44, 2, 29, 5}, new int[]{14, 34, 1, 29, 3, 14, 45, 4, 43, 4, 12, 15}, 5);
        System.out.print("Coste tabla: ");
        System.out.println(coste);
    }

}
