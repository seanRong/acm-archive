package ubcpc2020;
import java.util.*;

public class F {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int[][] adj = new int[v+1][v+1];
        Map<Integer,Integer> connectionCount = new HashMap<>();
        for (int i=1;i<=v;i++) {
            StringBuilder builder = new StringBuilder();
            builder.append("? ");
            builder.append(v-1 + " ");
            for (int j=1;j<=v;j++) {
                if (j != i) {
                    builder.append(j + " ");
                }
            }
            String text = builder.toString();
            System.out.println(text);
            System.out.flush();
            int conns = sc.nextInt();
            if (conns == -1 ) {
                System.exit(0);
            }
            connectionCount.put(i, conns);
        }
        if (v >= 3) {
        for (int i=1;i<=v;i++) {
            for (int k = 1; k <= v; k++) {
                if (k == i) {
                    continue;
                }
                StringBuilder builder = new StringBuilder();
                builder.append("? ");
                builder.append(v - 2 + " ");
                for (int j = 1; j <= v; j++) {
                    if (j != i && j != k) {
                        builder.append(j + " ");
                    }
                }
                String text = builder.toString();
                System.out.println(text);
                System.out.flush();
                int conns = sc.nextInt();
                if (conns == -1) {
                    System.exit(0);
                }
                if (connectionCount.get(i) + connectionCount.get(k) - conns == 2) {
                    adj[i][k] = 1;
                }
            }
         }
            System.out.println("!");
            for (int i=1;i<adj.length;i++) {
                StringBuilder builder = new StringBuilder();
                for (int j=1;j<adj[i].length;j++) {
                    builder.append(adj[j][i] + " ");
                }
                String text = builder.toString();
                System.out.println(text);
            }
        } else {
            System.out.println("? 1 1");
            int ans = sc.nextInt();
            if (ans == -1) System.exit(0);
            if (ans == 1) {
                System.out.println("!");
                System.out.println("0 1");
                System.out.println("1 0");
            }
            if (ans == 0) {
                System.out.println("!");
                System.out.println("0 0");
                System.out.println("0 0");
            }
        }
        System.exit(0);

    }
}
