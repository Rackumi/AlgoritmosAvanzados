public class Practica_4 {

    public static int f (int x, int y) {
        if (x==0)
            return y;
        else if (y==0)
            return x;
        else
            return f(x,y-1) + f(x-1,y) + f(x-1,y-1);
    }

    private static int[][] tabla1;

    private static int a = 0;

    public static int f2 (int x, int y) {
        tabla1 = new int[x+1][y+1];
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                tabla1[i][j] = -1;
            }
        }
        m(x,y);
        a++;
        return tabla1[x][y];
    }

    private static void m (int x, int y) {
        if(tabla1[x][y] == -1){
            if (x == 0)
                tabla1[x][y] = y;
            else if (y == 0)
                tabla1[x][y] = x;
            else {
                m(x,y-1);
                m(x-1,y);
                m(x-1,y-1);
                tabla1[x][y] = tabla1[x][y-1] + tabla1[x-1][y] + tabla1[x-1][y-1];
            }
        }
        a++;
    }

    public static int f3 (int x, int y) {
        int[][] tabla = new int[x + 1][y + 1];
        for (int i = 0; i <= x; i++)
            for (int j = 0; j <= y; j++)
                if (i == 0)
                    tabla[i][j] = j;
                else if (j == 0)
                    tabla[i][j] = i;
                else
                    tabla[i][j] = tabla[i][j-1] + tabla[i-1][j] + tabla[i-1][j-1];
        return tabla[x][y];
    }

    public static void main(String[] args) {
        f2(8,10);
        System.out.println(a);
    }

}
