package d2tryout;
import java.util.*;
public class message {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for(int c = 0;c<cases;c++) {
            String msg = sc.next();
            int nearest_sq = (int) Math.pow(Math.ceil(Math.sqrt(msg.length())), 2);
            int pad = nearest_sq - msg.length();
            for (int a=0;a<pad;a++) {
                msg += "*";
            }
            int k = (int) Math.sqrt(nearest_sq);
            int index = 0;
            int[][] grid = new int[k][k];
            for (int i=0;i<k;i++) {
                for (int j=0;j<k;j++) {
                    grid[i][j] = msg.charAt(index);
                    index++;
                }
            }
            int[][] rotated = new int[k][k];
            for (int i=0;i<k;i++) {
                for (int j=0;j<k;j++) {
                    rotated[i][j] = grid[k - j - 1][i];
                }
            }
            StringBuilder res = new StringBuilder();
            for (int i=0;i<k;i++) {
                for (int j=0;j<k;j++) {
                    if (rotated[i][j] != 42) {
                        res.append(Character.valueOf((char) rotated[i][j]));
                    }
                }
            }
            System.out.println(res);
        }
    }
}
