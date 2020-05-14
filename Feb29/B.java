package Feb29;

import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double val = sc.nextInt();
        double base = sc.nextInt();
        double count = 0;
        while (val >= base) {
            val = (val/base);
            count++;
        }
        System.out.println((int) (count + 1));
    }
}
