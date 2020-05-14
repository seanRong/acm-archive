package Mar07;

import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> votes = new HashMap<>();
        int gothru = sc.nextInt();
        int max = -999;
        for (int i = 0; i<gothru;i++) {
            String cur = sc.next();
            if (votes.containsKey(cur)) {
                int was = votes.get(cur);
                votes.put(cur, was+1);
                if ((was + 1) > max) {
                    max = (was + 1);
                }
            } else {
                votes.put(cur, 1);
            }
        }
        ArrayList<String> toprint = new ArrayList<>();
        for (Map.Entry<String, Integer> e : votes.entrySet()) {
            if (e.getValue() == max) {
                toprint.add(e.getKey());
            }
        }
        Collections.sort(toprint);
        for (int i = 0; i<toprint.size(); i++) {
            System.out.println(toprint.get(i));
        }
    }
}
