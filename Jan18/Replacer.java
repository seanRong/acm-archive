package Jan18;

import java.util.Scanner;

public class Replacer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String garbage = sc.next();
        garbage.replaceAll("⊕", "^");
//        garbage.replaceAll("∨", "||");
        System.out.println(garbage);

    }


}
