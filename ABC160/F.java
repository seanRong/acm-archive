package ABC160;

import java.util.*;

public class F {
    public static void main(String[] args) {
        F f = new F();
    }
    Scanner sc = new Scanner(System.in);
    int mod = 1000000007;
    int n;
    int[] size;
    long[] factorial ;
    long[] invFactorial;
    long[] combos;
    ArrayList<Integer> [] adj;
    public F() {
        n = sc.nextInt();
        adj = new ArrayList[n+1];
        size = new int[n+1];
        combos = new long[n+1];

        factorial= new long[n+1];
        invFactorial = new long[n+1];
        factorial[0] = 1;
        for (int i = 1; i<n;i++){
            factorial[i] = (factorial[i-1] * i) % mod;
//            System.out.println(factorial[i]);
        }

        invFactorial[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            invFactorial[i] = (invFactorial[i-1] * power(i, mod - 2))  % mod;
//            System.out.println(invFactorial[i]);
        }

        for (int i = 0; i < n+1; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i=0;i<n-1;i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            adj[to].add(from);
            adj[from].add(to);
        }

        for (int i = 1 ;i<n+1;i++) {
            init(i, -1);
            System.out.println(combos[i]);
            size = new int[n+1];
            combos = new long[n+1];
        }
    }

    void init(int node, int parent) {
        for (int child: adj[node]) {
            if (child == parent) {
                continue;
            }
            init(child, node);
            size[node] += size[child];
        }
        long res = factorial[size[node]];
        for (int child: adj[node]) {
            if (child == parent) {
                continue;
            }
            res = (res * combos[child]) % mod;
            res = (res * invFactorial[size[child]]) % mod;
        }
        combos[node] = res;
        size[node]++;
    }



    long power(long base, long exp) {
        long res = 1;
        while (exp > 0) {
            if (exp % 2 == 1) {
                res = res * base % mod;
            }
            base = base * base % mod;
            exp = exp/2;
        }
        return res;
    }
}
