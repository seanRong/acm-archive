package Mar14;

import java.util.*;

public class Fib {
    static HashMap<Integer,Long> save = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int i=0;i<q;i++) {
            HashMap<Long,Integer> modsave = new HashMap<>();  //val, index
//            modsave.put(1,0);
            int mod = sc.nextInt();
            int index = 2;
            while (!modsave.containsKey((fib(index) % mod))) {
                modsave.put((fib(index) % mod), index);
//                System.out.println((fib(index) % mod));
                index++;
            }
//            System.out.println(modsave);
            System.out.println(modsave.get((fib(index) % mod)));
            modsave.clear();
        }
    }

    static long fib(int n) {
        if (n == 0 || n== 1) {
            return 1;
        }
        if (save.containsKey(n)) {
            return save.get(n);
        } else {
            long curr = fib(n-1) + fib(n-2);
            save.put(n,curr);
            return curr;
        }
    }
}
