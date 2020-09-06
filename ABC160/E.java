package ABC160;

import java.util.*;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long deliciousness = 0;
        long targetRed = sc.nextLong();
        long targetGreen = sc.nextLong();
        long totalRed = sc.nextLong();
        long totalGreen = sc.nextLong();
        long totalColorless = sc.nextLong();
        PriorityQueue<Long> redpq = new PriorityQueue<>();
        PriorityQueue<Long> greenpq = new PriorityQueue<>();
        PriorityQueue<Long> colorlesspq = new PriorityQueue<>();

        for (long i=0;i<totalRed;i++){
            redpq.add(sc.nextLong());
        }
        for (long i=0;i<totalGreen;i++){
            greenpq.add(sc.nextLong());
        }
        for (long i=0;i<totalColorless;i++){
            colorlesspq.add(sc.nextLong());
        }
        while (redpq.size() > targetRed) {
            redpq.poll();
        }
        while (greenpq.size() > targetGreen) {
            greenpq.poll();
        }

        while (!colorlesspq.isEmpty()) {
            long top = colorlesspq.poll();
            long redTop = redpq.peek();
            long greenTop = greenpq.peek();
            if (top > redTop || top > greenTop) {
                if ((top - redTop) > (top - greenTop)) {
                    redpq.poll();
                    redpq.add(top);
                } else {
                    greenpq.poll();
                    greenpq.add(top);
                }
            }
        }

        while(!greenpq.isEmpty()) {
            deliciousness += greenpq.poll();
        }
        while(!redpq.isEmpty()) {
            deliciousness += redpq.poll();
        }
        System.out.println(deliciousness);
    }
}
