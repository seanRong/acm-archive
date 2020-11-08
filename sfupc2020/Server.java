package sfupc2020;

import java.io.*;
import java.util.*;

public class Server {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int r = sc.nextInt();
            if (r <= 0) System.exit(0);
            double root = Math.sqrt(r);
            double rootf = Math.floor(root);
            double rootc = Math.ceil(root);
            double resc = r/rootc + rootc;
            double resf = r/rootf + rootf;
            double min = (Math.min(Math.min(resc, resf), r));
            if (r==min) {
                System.out.println(0);
            } else if (resc==min && resf==min) {
                System.out.println((int)Math.min(rootc,rootf));
            } else if (resc==min) {
                System.out.println((int)rootc);
            } else if (resf==min) {
                System.out.println((int)rootf);
            }
        }
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}