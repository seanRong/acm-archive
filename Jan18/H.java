package Jan18;

import java.io.*;
import java.util.*;

public class H {
    public static void main(String args[]) throws IOException {
        File text = new File("horrible.in");
        Scanner sc = new Scanner(text);
//        Scanner sc = new Scanner(System.in);
        BufferedWriter writer = new BufferedWriter(new FileWriter("horrible.out"));

        int n = sc.nextInt();
        int eps = n*(2*n-1) - 2*(n - 2);
        if (n == 1) {
            eps = 1;
        }
        writer.append(eps + "\n");
        if (n != 1){
            writer.append("2 -1 \n");
        }
        for (int i = 1; i <= (n-1); i++) {
            writer.append(i + "  0 \n");
            LinkedList<String> pos = new LinkedList();
            LinkedList<String> neg = new LinkedList();
            for (int j = 1; j <= n; j++) {
                if (j != i) {
                    pos.addLast(j + " " + i + "\n");
                }
                if (j != (i+1)) {
                    neg.addLast(j + " -" + (i+1)  + "\n");
                }
            }
            for (int j = 1; j <= (n-1); j++) {
                writer.append(pos.pop());
                writer.append(neg.pop());
            }
        }
        writer.append(n + "  0 \n");

        if (n != 1) {
            writer.append("1 " + n + "\n");
        }
        writer.close();
    }
}
