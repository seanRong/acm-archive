package Jan18;

import java.io.*;
import java.util.*;

public class C {
    public static void main(String[] args) throws IOException {
        File text = new File("commuting.in");
        Scanner sc = new Scanner(text);
        BufferedWriter writer = new BufferedWriter(new FileWriter("commuting.out"));
        ArrayList<Integer> f = new ArrayList<>();
        int count = sc.nextInt();
        boolean flag = false;
        int bottom = -1;
        for (int i=1; i <= count; i++) {
            int next = sc.nextInt();
            if (flag) {
                writer.append(String.valueOf(bottom) + " ");
            } else if (next == i) {
                flag = true;
                if (bottom == -1){
                    bottom = next;
                }
                writer.append(String.valueOf(i) + " ");
            } else {
                writer.append(String.valueOf(i) + " ");
            }
        }

        writer.close();
    }
}
