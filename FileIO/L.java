package FileIO;

import java.io.*;
import java.util.*;
import java.lang.*;

public class L {

    public static void main(String args[]) throws FileNotFoundException {
//        File text = new File("looking.in");
//        Scanner sc = new Scanner(text);
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
        for (int c=0;c<cases;c++) {
            int meal = sc.nextInt();
            int limit = sc.nextInt();
            int take = 0;
            int iMeal = sc.nextInt();
            for (int m=1;m<meal;m++) {
                int kMeal = sc.nextInt();
                if ((Integer.bitCount(iMeal|kMeal) - Integer.bitCount(iMeal)) > 0 && take < limit) {
                    iMeal = iMeal|kMeal;
                    take++;
                }
            }

            System.out.println(iMeal);
        }
    }
}
