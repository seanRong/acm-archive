package Feb01;

import java.lang.reflect.Array;
import java.util.*;

public class SimpleQuery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        ArrayList<Integer> toPrint = new ArrayList();
        for (int i =0;i<cases;i++) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            for (int j=0; j<n; j++) {
                ArrayList<Integer> arr = new ArrayList();
                arr.add(sc.nextInt());
                for (int k=0;k<q;k++) {
                    for (int m=0;m<4;m++) {
                        int l = sc.nextInt();
                        int r = sc.nextInt();
                        int u = sc.nextInt();
                        int v = sc.nextInt();
                        ArrayList<Integer> sublist = (ArrayList<Integer>) arr.subList(l, r);
                        ArrayList<Integer> subsublist = (ArrayList<Integer>) sublist.subList(u, v);
                        Set freq = new HashSet(subsublist);
//                        Collections.frequency(freq, )
                    }
                }
            }

        }
    }
}
