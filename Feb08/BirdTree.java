package Feb08;

import java.util.*;

public class BirdTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();
        for (int n=0;n<times;n++) {
            String dec = sc.next();
            String[] t = dec.split("/");
            int numerator = Integer.valueOf(t[0]);
            int denominator = Integer.valueOf(t[1]);
//            System.out.println(numerator);
//            System.out.println(denominator);
            StringBuffer sb = new StringBuffer();
//        double actual = numerator/denominator;
            while (numerator != denominator) {
                if (numerator > denominator) {
                    numerator -= denominator;
                    int temp = numerator;
                    numerator = denominator;
                    denominator = temp;
                    sb.append("R");
                } else if (denominator > numerator) {
                    int temp = numerator;
                    numerator = denominator;
                    denominator = temp;
                    numerator -= denominator;
                    sb.append("L");
                }
            }
            System.out.println(sb);
        }



    }
}
