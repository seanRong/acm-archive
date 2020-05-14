//package Dec21;

import java.awt.*;
import java.awt.geom.Point2D;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class revegetate {
    public static void main(String args[]) throws IOException {
        File text = new File("revegetate.in");
        Scanner sc = new Scanner(text);
//        Scanner sc = new Scanner(System.in);
        int pastureCount = sc.nextInt();
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for (int i =0; i< pastureCount;i++) {
            graph.put(i + 1, new ArrayList<>());
        }
        int cows = sc.nextInt();
        for (int i =0; i<cows;i++){
            int f = sc.nextInt();
            int s = sc.nextInt();
            graph.get(f).add(s);
            graph.get(s).add(f);
        }
        ArrayList<ArrayList<Integer>> colors = new ArrayList<>();

        for (int i=0;i<pastureCount;i++) {
            ArrayList<Integer> four = new ArrayList<>();
            four.add(1);
            four.add(2);
            four.add(3);
            four.add(4);
            colors.add(four);
        }
//        System.out.println(graph.get(1));
//        System.out.println(colors.get(0));
        for (int i=0;i<pastureCount;i++) {
            while (colors.get(i).size() > 1) {
                colors.get(i).remove(colors.get(i).size() - 1);
            }
            int currColor = colors.get(i).get(0);
//            System.out.println(colors.get(i));
            ArrayList<Integer> toBeRemoved = graph.get(i+1);
//            System.out.println(toBeRemoved);
            if (toBeRemoved.size() > 0) {
                for (int j=0; j<toBeRemoved.size();j++) {
//                    System.out.println("removing from " + (toBeRemoved.get(j) - 1));
//                    System.out.println(colors.get(3));
                    colors.get(toBeRemoved.get(j) - 1).remove(Integer.valueOf(currColor));
                }
            }

        }
        StringBuffer sb = new StringBuffer();
        for (int i=0; i< colors.size(); i++) {
            sb.append(String.valueOf(colors.get(i).get(0)));
        }
//        System.out.println(sb);





        FileWriter fileWriter = new FileWriter("revegetate.out");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(sb);
        printWriter.close();


    }
}
