//package Nov20;

import java.util.*;

public class HalfCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int radius = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        double res = radius - Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        res = Math.min(res, y);
        System.out.println(res);
    }


}
