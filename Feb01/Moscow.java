package Feb01;

import java.util.*;

public class Moscow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt();
        int m = sc.nextInt();
        int h = sc.nextInt();
        int total = sc.nextInt();
        if (e > 0 && m > 0 && h > 0 && (e + m + h) >= total && total >= 3) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
