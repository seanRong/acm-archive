package Jan18;

import java.io.FileNotFoundException;
import java.util.*;

public class E {
    public static void main(String args[]) throws FileNotFoundException {
//        File text = new File("baklava.in");
//        Scanner sc = new Scanner(text);
        Scanner sc = new Scanner(System.in);


        int cases = sc.nextInt();
        for (int i=0;i<cases;i++) {
            int sides = sc.nextInt();
            double regularAngle = (Math.PI*(sides - 2))/sides;
            double area = 1.0;
            double sideLength = Math.sqrt(4/(sides*(1/Math.tan(Math.PI/sides))));
            double nextSideLength = ((sideLength/2)/(Math.sin((Math.PI - regularAngle)/2))) * Math.sin(regularAngle);
            double s = (sideLength+nextSideLength)/2;
            double oldArea = area;
            area -= (sides * Math.sqrt(s*(s-nextSideLength)*Math.pow(s-(sideLength/2), 2)));
            double ratio = area/oldArea;
//            System.out.println(area/oldArea);
            double res = 1.0/(1.0-ratio);
            System.out.println((double)Math.round((Math.pow(10, 4) * res) * 100000d) / 100000d);
        }


    }
}
