package Mar07;

import java.util.Scanner;

public class BinTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int i =0; i<cases; i++) {
            int nodes = sc.nextInt();
            for (int j=0;j<nodes;j++) {
                sc.nextLine();
            }
            if (nodes % 2 == 1) {
                System.out.println("Alice");
            } else {
                System.out.println("Bob");
            }
        }
    }
}
