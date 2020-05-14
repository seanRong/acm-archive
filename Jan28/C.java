package Jan28;

import java.lang.reflect.Array;
import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m  = sc.nextInt();
        double[][] grid = new double[n][2*m]; //row then col
        for (int i=0;i<n;i++) {
            Array.set(grid[i], 0, 1);
        }

        for (int j=1;j<(2*m);j++) {
            double sofar = 0;
            for (int i=n-1; i>-1;i--) {
                sofar += grid[i][j-1];
                sofar = (sofar % (Math.pow(10, 9) + 7));
                Array.set(grid[i], j, (grid[i][j] + sofar) % (Math.pow(10, 9) + 7));
            }
        }

//ARR printer
//        for (int i=0; i<n;i++) {
//            for (int j=0;j<(2*m);j++) {
//                System.out.println(grid[i][j]);
//            }
//        }

        double res = 0;

        for (int a=0;a<n;a++) {
            res += grid[a][2*m - 1];
            res = res % (Math.pow(10, 9) + 7);
        }

        System.out.println((int) res);
    }


}
