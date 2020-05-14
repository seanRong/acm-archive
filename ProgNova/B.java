package ProgNova;

import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> counters = new ArrayList<>();
        counters.add(sc.nextInt());
        counters.add(sc.nextInt());
        int served = 0;
        for (int i=0;i<n;i++) {
            int customer = sc.nextInt();
            Collections.sort(counters);
            System.out.println(counters);
            boolean ok = false;
            for (int j=0; j<2;j++) {
                int currCounter = counters.get(j);
                if (currCounter >= customer) {
                    counters.set(j, (currCounter - customer));
                    served++;
                    ok = true;
                    break;
                }
            }
            if (!ok) {
                break;
            }
        }
        System.out.println(served);

    }
}
