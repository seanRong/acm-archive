package Jan25;

import java.io.*;
import java.util.*;

public class A {
    public static void main(String[] args) throws IOException{
        File text = new File("auxiliary.in");
        Scanner sc = new Scanner(text);
//        HashMap<Integer, Integer> sevenseg = new HashMap<>();
        BufferedWriter writer = new BufferedWriter(new FileWriter("auxiliary.out"));
//        sevenseg.put(2, 1);  // 2 for 1
//        sevenseg.put(4, 4);  // 4 for 4
//        sevenseg.put(5, 5);  // 4 for 4
//        sevenseg.put(6, 9);  // 6 for 9
//        sevenseg.put(3, 7); // 3 for 7
//        sevenseg.put(7, 8); // 7 for 8

        int targ = sc.nextInt();
        int res = 0;
        res += (Math.floor(targ / 3) * 7);
        int targRem = (targ % 3);
//        System.out.println(res);
//        System.out.println(targ);
        if (targRem == 1) {
            res -= 3;
        } else if (targRem == 2) {
            res += 1;
        }

        if (res < 0) {
            res = 0;
        }

        if (targ != 2) {
            writer.write(String.valueOf(res));
        } else {
            writer.write("1");
        }
        writer.close();
    }
}
