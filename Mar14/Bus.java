package Mar14;

import java.util.*;

public class Bus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        int curr = start;
        ArrayList<Integer> walkTimes = new ArrayList<>();
        ArrayList<Integer> rideTimes = new ArrayList<>();
        ArrayList<Integer> busIntervals = new ArrayList<>();
        int n = sc.nextInt();
        for (int i =0;i<n+1;i++) {
            walkTimes.add(sc.nextInt());
        }
        for (int i =0;i<n;i++) {
            rideTimes.add(sc.nextInt());
        }
        for (int i =0;i<n;i++) {
            busIntervals.add(sc.nextInt());
        }
        for (int i =0;i<n;i++) {
            curr += walkTimes.get(i);
            if (curr % busIntervals.get(i) != 0) {
                curr += (busIntervals.get(i) - curr % busIntervals.get(i));
            }
            curr += rideTimes.get(i);
        }
        curr += walkTimes.get(n);
        if (curr > end) {
            System.out.println("no");
        } else {
            System.out.println("yes");
        }
    }
}
