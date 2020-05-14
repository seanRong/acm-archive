package Jan22;

import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int i=0;i<cases;i++) {
            String pwd = sc.next();
            String hashed = sc.next();
            char[] pwdarr = pwd.toCharArray();
            Arrays.sort(pwdarr);
//            System.out.println(pwdarr);
            boolean ok = false;
            for (int j=0;j<hashed.length()-pwd.length() + 1;j++) {
                    String temp = hashed.substring(j, j+pwd.length());
                    char[] t = temp.toCharArray();
                    Arrays.sort(t);
//                    System.out.println(t);
                    if (Arrays.equals(pwdarr, t)) {
                        ok = true;
                    }
            }
            if (ok) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}
