package Jan22;

import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int i = 0; i<cases; i++) {
            int counter = 0;
            int first = sc.nextInt();
            int second = sc.nextInt();
            while (first != second) {
                if (first > second) {
                    second += counter;
                    System.out.println(first);
                    System.out.println(second);
                } else {
                    first += counter;
                    System.out.println(first);
                    System.out.println(second);
                }
                counter++;
            }

            System.out.println(counter);
        }
    }
}
