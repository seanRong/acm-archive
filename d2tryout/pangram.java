package d2tryout;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class pangram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int i=0;i<cases;i++) {
            ArrayList<Character> alphabet = new ArrayList<Character>();
            for (char c = 'a'; c <= 'z'; c++) {
                alphabet.add(c);
            }
            String sent = sc.next();
            sent += sc.nextLine();
            sent = sent.toLowerCase();
            for (char c: sent.toCharArray()) {
                alphabet.remove(Character.valueOf(c));
            }
//            System.out.println(sent);
            if (alphabet.size() == 0) {
                System.out.println("pangram");
            } else {
                String str = alphabet.stream().map(e->e.toString()).collect(Collectors.joining());
                System.out.println("missing " + str);
            }
//            System.out.println(alphabet);
        }
    }

}
