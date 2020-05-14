package DP;

import java.io.*;
import java.util.*;
import java.lang.*;

public class VacationDP {

    public static void main(String args[])  {
        Scanner sc = new Scanner(System.in);
        // int[][] arr = [][]
        ArrayList<Integer> aList = new ArrayList();
        ArrayList<Integer> bList = new ArrayList();
        ArrayList<Integer> cList = new ArrayList();

        int days = sc.nextInt();
        for (int d=0;d<days;d++) {
            aList.add(sc.nextInt());
            bList.add(sc.nextInt());
            cList.add(sc.nextInt());
        }

        ArrayList<ArrayList<Integer>> plan = new ArrayList<>();
        plan.add(aList);
        plan.add(bList);
        plan.add(cList);

        for (int i=1; i<days;i++){
            plan.get(0).set(i, plan.get(0).get(i) + Math.max(plan.get(1).get(i-1), plan.get(2).get(i-1)));
            plan.get(1).set(i, plan.get(1).get(i) + Math.max(plan.get(0).get(i-1), plan.get(2).get(i-1)));
            plan.get(2).set(i, plan.get(2).get(i) + Math.max(plan.get(1).get(i-1), plan.get(0).get(i-1)));
        }
//        writer.write(plan);

        System.out.println(Math.max(plan.get(2).get(days-1), Math.max(plan.get(0).get(days-1), plan.get(1).get(days-1))));

    }


}
