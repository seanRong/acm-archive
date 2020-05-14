package Mar14;

import java.util.*;

public class Cipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String enc = sc.next();
        String key = sc.next();
        StringBuilder res = new StringBuilder();
        for (int i=0;i<enc.length();i++) {
            char cur = enc.charAt(i);
            char curkey = key.charAt(i);
            int move = (int) curkey - 65;
//            System.out.println(move);
            int base = (int) cur;
            if (i % 2 == 0) {
                base -= move;
            } else {
                base += move;
            }
            if (base < 65) {
                base += 26;
            } else if (base > 90) {
                base -= 26;
            }
            res.append((char) base);
        }
        System.out.println(res);
    }
}
