package Jan28;

import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int i=0;i<cases;i++) {
            double remaining = sc.nextDouble();
            double runtime = sc.nextDouble();
            if (runtime <= remaining) {
                System.out.println("YES");
            } else {
                boolean ok = false;
                for (int j=1;j<Math.sqrt(runtime);j++) {
                    if ((j+Math.ceil(runtime/(j+1))) <= remaining) {
                        System.out.println("YES");
                        ok = true;
                        break;
                    }
                }
                if (!ok) {
                    System.out.println("NO");
                }
            }
        }
    }
}
