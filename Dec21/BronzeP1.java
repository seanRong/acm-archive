//package Dec21;

import java.io.*;
import java.util.*;
import java.lang.*;

public class BronzeP1 {
    public static void main(String args[]) throws IOException {
        File text = new File("herding.in");
        Scanner sc = new Scanner(text);
//        Scanner sc = new Scanner(System.in);

        ArrayList<Long> farm = new ArrayList<>();
        long b = sc.nextLong();
        long e = sc.nextLong();
        long m = sc.nextLong();
        farm.add(b);
        farm.add(e);
        farm.add(m);

        Collections.sort(farm);
        long diff1 = farm.get(1) - farm.get(0);
        long diff2 = farm.get(2) - farm.get(1);

        long max = Math.max(diff1, diff2) - 1;
        long min = 2;
        if (diff1 == 1 && diff2 == 1) {
            min = 0;
        } else if (diff1 == 2 || diff2 == 2) {
            min = 1;
        }



//        System.out.println(min);
//        System.out.println(max);

        FileWriter fileWriter = new FileWriter("herding.out");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(min + "\n");
        printWriter.print(max);

        printWriter.close();


    }
}
