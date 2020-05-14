package Mar07;

import java.util.*;

public class Label {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int i = 0; i <cases; i++) {
            int radix = sc.nextInt();
            int target = sc.nextInt();
            int basis = 10 - radix;
            StringBuilder sb = new StringBuilder();
            if (radix == 10) {
                System.out.println(target - 1);   //rmbr 0 indexed
            } else {
                while (target >= 0) {
                    int biggestCanFit = 0;
                    for (int j=10;j>-1;j--) {
                        if (Math.pow(radix,j) <= target) {
                            biggestCanFit = j;
//                            System.out.println(biggestCanFit);
                            break;
                        }
                    }
                    for (int k=0; k<radix; k++) {
                        if (target - (k * Math.pow(radix, biggestCanFit)) < 0 ) {
                            sb.append(k-1);
                            target -= (k-1) * Math.pow(radix, biggestCanFit);
//                            System.out.println(target);
                            break;
                        }
                    }
                    if (target == 0) {
                        sb.append(0);
                        break;
                    }
                }
                HashMap<String,String> translator = new HashMap<>();
//                HashMap<String,String> translator = new HashMap<>();
                for (int a = 0;a<radix;a++) {
                    translator.put(String.valueOf(a), String.valueOf(10-radix+a));
                }
                System.out.println(translator);
                String interim = sb.toString();
                int converted = Integer.valueOf(interim);
                converted -= 1;
                String c = String.valueOf(converted);
                StringBuilder secondary = new StringBuilder(c);
                for (int a = 0; a<secondary.length()-1;a++) {
                    String original = secondary.substring(a, a+1);
                    secondary.replace(a,a+1, translator.get(original));
                }
                System.out.println(secondary);
            }
        }
    }
}
