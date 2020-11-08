package d2tryout;
import java.util.*;
public class simon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ins = sc.nextInt();
        for (int i=0;i<ins;i++) {
            String sent = sc.next();
            sent += sc.nextLine();
            if (sent.length() < 10) continue;
            String t = sent.substring(0, 10);
            String s = "Simon says";
            if (t.equals(s)) {
                System.out.println(sent.substring(10, sent.length()));
            }
//            System.out.println(t);
        }
    }
}
