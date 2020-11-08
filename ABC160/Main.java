package ABC160;

import java.util.*;
import java.io.*;

public class Main {

    private final static int MOD = (int)1e9 + 7;

    private int N;
    private List<Integer>[] adj;
    private long[] dp;
    private int[] size;
    private long[] fact, invfact;
    private long[] res;

    public Main(FastScanner in, PrintWriter out) {
        N = in.nextInt();
        adj = new List[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList();
        }
        for (int i = 0; i < N - 1; i++) {
            int u = in.nextInt() - 1;
            int v = in.nextInt() - 1;
            adj[u].add(v);
            adj[v].add(u);
        }

        fact = new long[N + 1];
        fact[0] = 1;
        for (int i = 1; i <= N; i++)
            fact[i] = fact[i - 1] * i % MOD;

        invfact = new long[N + 1];
        invfact[0] = 1;
        for (int i = 1; i <= N; i++)
            invfact[i] = invfact[i - 1] * powm(i, MOD - 2) % MOD;

        dp = new long[N];
        size = new int[N];
        dfs(0, -1);

        for (int i = 0; i < N; i++) {
            System.out.println(size[i]);
            System.out.println(dp[i]);
        }

//        res = new long[N];
//        dfs2(0, -1, 1);
//        for (long x : res)
//            out.println(x);
    }

    private void dfs(int u, int p) {
        for (int v : adj[u]) {
            if (v == p) continue;
            dfs(v, u);
            size[u] += size[v];
        }
//        System.out.println("node " + u + " size " + size[u]);
        long res = fact[size[u]];
        for (int v : adj[u]) {
            if (v == p) continue;
            res = res * dp[v] % MOD;
            res = res * invfact[size[v]] % MOD;
        }
        dp[u] = res;
        size[u]++;
    }

    // rerooting the tree
    // dpp -- assuming parent node p does not have u as child
    // how many ways it has to distribute integers from 1
    private void dfs2(int u, int p, long dpp) {
        // calculate the contribution from parent
        int psz = N - size[u];
        res[u] = fact[N - 1] * invfact[psz] % MOD;
        res[u] = res[u] * dpp % MOD;

        // calculate the contribution from children
        for (int v : adj[u]) {
            if (v == p) continue;
            res[u] = res[u] * dp[v] % MOD * invfact[size[v]] % MOD;
        }

        // visit all children
        for (int v : adj[u]) {
            if (v == p) continue;
            // if node u does not have v as child,
            // how many way it has to distribute integer from 1
            long x = res[u];
            x = x * invfact[N - 1] % MOD;
            x = x * fact[N - 1 - size[v]] % MOD;
            x = x * fact[size[v]] % MOD;
            x = x * powm(dp[v], MOD - 2) % MOD;
            dfs2(v, u, x);
        }
    }

    private int gcd(int a, int b) {
        while (true) {
            if (b == 0) return a;
            int tmp = a;
            a = b;
            b = tmp % b;
        }
    }

    private long powm(long x, long p) {
        long res = 1;
        while (p > 0) {
            if (p % 2 == 1)
                res = res * x % MOD;
            x = x * x % MOD;
            p /= 2;
        }
        return res;
    }


    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        // Scanner in = new Scanner(
        // new BufferedReader(new InputStreamReader(System.in)));
        FastScanner in = new FastScanner(System.in);

        Main sol = new Main(in, out);

        out.close();
    }
}


class FastScanner{
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;

    public FastScanner(InputStream stream)
    {
        this.stream = stream;
    }

    int read()
    {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars){
            curChar = 0;
            try{
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    boolean isSpaceChar(int c)
    {
        return c==' '||c=='\n'||c=='\r'||c=='\t'||c==-1;
    }

    boolean isEndline(int c)
    {
        return c=='\n'||c=='\r'||c==-1;
    }

    int nextInt()
    {
        return Integer.parseInt(next());
    }

    long nextLong()
    {
        return Long.parseLong(next());
    }

    double nextDouble()
    {
        return Double.parseDouble(next());
    }

    String next(){
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do{
            res.appendCodePoint(c);
            c = read();
        }while(!isSpaceChar(c));
        return res.toString();
    }

    String nextLine(){
        int c = read();
        while (isEndline(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do{
            res.appendCodePoint(c);
            c = read();
        }while(!isEndline(c));
        return res.toString();
    }
}
