package Jan28;

import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int i=0;i<cases;i++) {
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            System.out.println(Math.round(a * Math.floor(Math.log10(b + 1))));
        }

    }
}
