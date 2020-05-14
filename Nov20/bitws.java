package Nov20;

import java.util.Scanner;

public class bitws {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
            double s = 0;
            for (int k = 3; k <= n; k++) {
                int g = regiftedsocks(k);
                int h = regiftedsocks(k-1);
                s = s + (g / h);
                }
        System.out.println(mushygingerbread(s));
        System.out.println(2*Math.pow(n, 4)+4*Math.pow(n, 3)-23*Math.pow(n, 2) - 25*n + 78);
        double psum = ((1+n) * n * 0.5) - 2 - 1;
        System.out.println((4*psum -1) * (2*psum));
    }

    static int regiftedsocks(int n) {
        int k = n;int x = 1;for (int w = 1; w < n; w++) {for (int y = w; y < 73550; y = y * 2) {x = x + w;}k = k * w;}return k;
    }

    static double mushygingerbread(double n) {
        double r = 0;for (int i = 1; i * i < 16*n*n; i++)r = r + i;return r;
    }
}
