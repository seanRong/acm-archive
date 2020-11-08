package sfupc2020;

import java.util.Scanner;

public class Color {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int i =0;i<cases;i++) {
            String color = sc.next();
            String red = color.substring(1,3);
            String green = color.substring(3,5);
            String blue = color.substring(5,7);
            int redInt = Long.decode("0x" + red).intValue();
            int greenInt = Long.decode("0x" + green).intValue();
            int blueInt = Long.decode("0x" + blue).intValue();
            int max = Math.max(Math.max(greenInt,blueInt),redInt);
            if (greenInt == blueInt && greenInt == redInt && redInt == blueInt) {
                System.out.println("grey");
            } else           if (greenInt == max) {
                if (redInt == max) {
                    System.out.println("yellow");
                } else if (blueInt == max) {
                    System.out.println("cyan");
                } else {
                    System.out.println("green");
                }
            } else             if (redInt == max) {
                if (blueInt == max) {
                    System.out.println("magenta");
                } else {
                    System.out.println("red");
                }
            } else             if (blueInt == max ) System.out.println("blue");
       }
    }
}
