//package Dec21;

import java.awt.*;
import java.awt.geom.Point2D;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Traffic {
    public static void main(String args[]) throws IOException {
        File text = new File("traffic.in");
        Scanner sc = new Scanner(text);
        ArrayList<Sensor> sensors = new ArrayList<>();
//        Scanner sc = new Scanner(System.in);
        int segments = sc.nextInt();
        for (int i=0;i< segments;i++) {
            sensors.add(new Sensor(sc.next(), sc.nextInt(), sc.nextInt()));
        }

        Sensor origin = null;

        for (Sensor s: sensors) {
            if (s.isNone()) {
                origin = s;
                break;

            }
        }

        int originUpper = origin.upper;
        int originLower = origin.lower;

        for (int i = sensors.indexOf(origin); i<sensors.size(); i++) {
            Sensor curr = sensors.get(i);
            if (curr.ramp.equals("on")) {
                originUpper += curr.upper;
                originLower += curr.lower;
            } else if (curr.ramp.equals("off")) {
                originUpper -= curr.lower;
                originLower -= curr.upper;
            } else {
                originUpper = Math.min(originUpper, curr.upper);
                originLower = Math.max(originLower, curr.lower);
            }
            originUpper = Math.max(0, originUpper);
            originLower = Math.max(0, originLower);
            System.out.println(originLower);
            System.out.println(originUpper);
        }

        int endUpper = originUpper;
        int endLower = originLower;


        originUpper = endUpper;
        originLower = endLower;

        for (int i = sensors.size() - 1; i>-1; i--) {
            Sensor curr = sensors.get(i);
            if (curr.ramp.equals("off")) {
                originUpper += curr.upper;
                originLower += curr.lower;
            } else if (curr.ramp.equals("on")) {
                originUpper -= curr.lower;
                originLower -= curr.upper;
            } else {
                originUpper = Math.min(originUpper, curr.upper);
                originLower = Math.max(originLower, curr.lower);
            }
            originUpper = Math.max(0, originUpper);
            originLower = Math.max(0, originLower);

        }

        int startUpper = originUpper;
        int startLower = originLower;

//        System.out.println("start: " + startLower + ", " + startUpper);
//        System.out.println("end: " + endLower + ", " + endUpper);





        FileWriter fileWriter = new FileWriter("traffic.out");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(startLower + " " + startUpper + "\n");
        printWriter.print(endLower + " " + endUpper);

        printWriter.close();


    }

    public static class Sensor {
        public int upper;
        public int lower;
        public String ramp;

        public Sensor(String r, int l, int u){
            upper = u;
            lower = l;
            ramp = r;
        }

        public boolean isNone() {
            return !(this.ramp.equals("on") || this.ramp.equals("off"));
        }
    }
}
