package Jan08;

import java.util.*;

public class Triangulation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sides = sc.nextInt();
        int weight = 0;
        int curr = 2;
        for (int i=0; i < sides - 2; i++) {
            weight += (curr * (curr+1));
            curr++;
        }
        System.out.println(weight);
    }
}
