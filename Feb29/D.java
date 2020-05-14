package Feb29;

import java.util.*;

public class D {
    long mod = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        long res = (long) (fastExp(2, n) - 1);
        res -= (choose(n, a));
        if (res < 0) {
            res += 1000000007;
            res = res % 1000000007;
        }
        res -= (choose(n,b));
        if (res < 0) {
            res += 1000000007;
            res = res % 1000000007;
        }
        System.out.println(res);
    }

    static long choose(int a, int b) {
        long mod = 1000000007;
        long top = 1;
        long bot = 1;
        if ((a - b) > b) {
            for (int i=((a-b)+1);i<=a ;i++) {
                top = (top * i) % mod;
            }
            for (int j=1; j<=b;j++) {
                bot = (bot*j) % mod;
            }
        } else {
            for (int j=(b+1);j<=a ;j++) {
                top = (top*j) % mod;
            }
            for (int i=1;i<=(a-b);i++) {
                bot = (bot*i) % mod;
            }
        }
        return ((top * (fastExp(bot, 1000000005))) % mod);
    }

    static long fastExp(long base, long power) {
        long mod = 1000000007;

        if (power == 0) {
            return 1;
        }
        long ans = fastExp(base, (power/2));
        if (power % 2 == 1) {
            long temp = (ans*base) % mod;
            return (temp*ans) % mod;
        } else {
            return (ans*ans) % mod;
        }
    }
}
