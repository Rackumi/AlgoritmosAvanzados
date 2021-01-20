public class Practica_1 {

    public static void main(String[] args) {

        int a = tareasIdeal(new int[]{1, 2, 3, 4, 5}, 2);
        System.out.println(a);

        a = tareasReal(new int[]{5, 3, 4, 1, 2}, 2);
        System.out.println(a);

    }

    /**
     * @param ts es un vector que contiene los tiempos de ejecución de las tareas
     * @param n es el numero de procesadores disponibles
     * @return el tiempo total de espera de todas las tareas
     */
    public static int tareasIdeal(int[] ts, int n) {
        int duracionTotal = 0; //duracion total inicializada a 0
        int[] procesadores = new int[n]; //declaramos e inicializamos el array de los procesadores de tamaño n
        int procAct = 0; //empezamos con el primer procesador

        for (int t : ts) { //recorremos el array de tareas con un for each
            procesadores[procAct] += t; //calculamos el tiempo de espera de esa actividad

            duracionTotal += procesadores[procAct]; //vamos acumulando el tiempo de espera de cada actividad

            if (procAct == n-1) //con esta condición vamos cambiando de procesador
                procAct = 0;
            else
                procAct++;
        }

        return duracionTotal; //finalmente devolvemos el resultado acumulado
    }

    /**
     * @param ts es un vector que contiene los tiempos de ejecución de las tareas
     * @param n es el numero de procesadores disponibles
     * @return el tiempo total de espera de todas las tareas
     */
    public static int tareasReal(int[] ts, int n) {
        int[] ts2 = ordenarIndices(ts); //ordenamos los indices del array con el metodo ordenarIndices

        int duracionTotal = 0; //duracion total inicializada a 0
        int[] procesadores = new int[n]; //declaramos e inicializamos el array de los procesadores de tamaño n
        int procAct = 0; //empezamos con el primer procesador

        for (int i : ts2) { //recorremos el array de tareas ordenado con un for each
            procesadores[procAct] += ts[i]; //calculamos el tiempo de espera de esa actividad

            duracionTotal += procesadores[procAct]; //vamos acumulando el tiempo de espera de cada actividad

            if (procAct == n-1) //con esta condición vamos cambiando de procesador
                procAct = 0;
            else
                procAct++;
        }

        return duracionTotal; //finalmente devolvemos el resultado acumulado
    }

    /**
     * @param v1 es el array a ordenar
     * @return el array ordenado
     */
    private static int[] ordenarIndices(int[] v1) {
        return new int[] {0};
    }

}
