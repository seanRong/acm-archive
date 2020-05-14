package Feb29;

import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double best = 999999999;
        ArrayList<Integer> locations = new ArrayList<>();
        int people = sc.nextInt();
        for (int i=0;i<people;i++){
            locations.add(sc.nextInt());
        }
        int locationlength = locations.size();
        for (int i=0;i<101;i++) {
            double thisres = 0;
            for (int j=0;j<locationlength;j++) {
                thisres += Math.pow(Math.abs(i-locations.get(j)), 2);
            }
            if (thisres < best) {
                best = thisres;
            }
        }
        System.out.println((int) best);

    }
}
