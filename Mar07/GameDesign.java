package Mar07;

import java.util.*;

public class GameDesign {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int kay;
        kay = sc.nextInt();
        boolean ok = false;
        ArrayList<Integer> solutions = new ArrayList<>();
        if (kay == 2) {
            System.out.println(2);
            System.out.println(1);
            System.out.println("1 1");
        } else {
            while (!ok) {
                int k = kay;
                boolean possiblePrime = false;
                while (k > 2 && !possiblePrime) {
                    int goUpTo = (int) Math.ceil(Math.sqrt(k));
                    for (int i = goUpTo; i > 1; i--) {
                        if (k % i == 0) {
//                        System.out.println("got " + i);
                            int tempsum = 0;
                            for (int j=0;j<solutions.size();j++) {
                                tempsum += solutions.get(j);
                            }
                            if ((i + tempsum + (k/i)) < 10000) {
                                solutions.add(i);
                                k = k/i;
                            }
                        }
//                        if (k == 2){
//                            solutions.add(k);
//                        }
                        if (i == 2 && solutions.isEmpty()) {  // could fail for 2 base case
                            possiblePrime = true;
                            solutions.add(100000);
                        }
                    }
                }
                int sum = 0;
                for (int i=0;i<solutions.size();i++) {
                    sum += solutions.get(i);
                }
                if (sum > 10000) {
                    kay += 1;
                    solutions.clear();
                } else {
                    ok = true;
                }
            }
        System.out.println(solutions);
            int l1 = 0;
            for (int i=0;i<solutions.size();i++) {
                l1 += (solutions.get(i));
            }
            l1 += 1;
            System.out.println(l1);   // first line, number of nodes
            int currparent = 0;
            StringBuilder l2 = new StringBuilder();
            for (int i=0;i<solutions.size();i++) {
                for (int j=0;j<solutions.get(i);j++){
                    if (j==0) {
                        l2.append(1 + " ");
                    } else {
                        l2.append((currparent + i) + " ");
                    }
                }
                currparent += solutions.get(i);
            }
            System.out.println(l2);
            StringBuilder l3 = new StringBuilder();
            for (int i=0;i<l1;i++) {
                l3.append(1 + " ");
            }
            System.out.println(l3);
        }

    }
}
