package d2tryout;
import java.util.*;

public class bet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] C = new int[11][11];
        for (int k = 1; k <= 10; k++) C[0][k] = 0;
        for (int n = 0; n <= 10; n++) C[n][0] = 1;

        for (int n = 1; n <= 10; n++)
            for (int k = 1; k <= 10; k++)
                C[n][k] = C[n-1][k-1] + C[n-1][k];
        int cases = sc.nextInt();
        for (int i=0;i<cases;i++) {
            float acc = 0;
            int r = sc.nextInt();
            int s = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int w = sc.nextInt();
            float success = (float) (s - r + 1) / (float) s;
            float fail = 1-success;
            for (int xinc = x; xinc <= y; xinc++) {
                float res = (float) ((float) C[y][xinc] * Math.pow(success, xinc) * Math.pow(fail, y-xinc));
                acc += res;
            }
            if (acc*w > 1) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
//            System.out.println(acc*w);
        }
    }
}
