
public class Practica_1 {

    public static void main(String[] args) {

        int a = tareasYaOrdenadas(new int[]{1, 2, 3, 4, 5}, 2);
        System.out.println(a);

        a = tareasSinOrdenar(new int[]{5, 3, 4, 1, 2}, 2);
        System.out.println(a);
    }

    public static int tareasYaOrdenadas(int[] ts, int n) {

        int duracion = 0;
        int[] procesadores = new int[n];
        int procAct = 0;

        for (int t : ts) {
            procesadores[procAct] += t;

            duracion += procesadores[procAct];

            if (procAct == n-1)
                procAct = 0;
            else
                procAct++;
        }

        return duracion;
    }

    public static int tareasSinOrdenar(int[] ts, int n) {
        int[] ts2 = ordenarIndices(ts);

        int duracion = 0;
        int[] procesadores = new int[n];
        int procAct = 0;


        for (int i : ts2) {
            procesadores[procAct] += ts[i];

            duracion += procesadores[procAct];

            if (procAct == n-1)
                procAct = 0;
            else
                procAct++;
        }

        return duracion;
    }

    private static int[] ordenarIndices (int[] v1) {
        int[] v2 = new int[v1.length];
        v2[0] = 0;
        for (int i=1; i<v1.length; i++) {
            int aux = v1[i];
            int j;
            for (j=i-1; j>=0 && v1[v2[j]]>aux; j--)
                v2[j+1] = v2[j];
            v2[j+1] = i;
        }
        return v2;
    }

}
