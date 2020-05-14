//package ProgNova;
//
//import sun.text.normalizer.UCharacter;
//
//import java.lang.reflect.Array;
//import java.util.*;
//
//public class A {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        HashMap<Integer,ArrayList<Integer>> translateA = new HashMap<>();
//        HashMap<Integer,,ArrayList<Integer>> translateS = new HashMap<>();
//        HashMap<Integer,,ArrayList<Integer>> translateE = new HashMap<>();
//        translateA.put(0, new ArrayList<Integer>(Arrays.asList(8)));
//        translateE.put(0, new ArrayList<Integer>(Arrays.asList(6,9)));
//        translateA.put(1,new ArrayList<Integer>(Arrays.asList(7)));
//        translateE.put(2,new ArrayList<Integer>(Arrays.asList(3)));
//        translateE.put(3,new ArrayList<Integer>(Arrays.asList(2)));
//        translateA.put(3,new ArrayList<Integer>(Arrays.asList(9)));
//        translateA.put(5,new ArrayList<Integer>(Arrays.asList(6,9)));
//        translateS.put(6,new ArrayList<Integer>(Arrays.asList(5)));
//        translateA.put(6,new ArrayList<Integer>(Arrays.asList(8)));
//        translateS.put(7,new ArrayList<Integer>(Arrays.asList(1)));
//        translateS.put(8,new ArrayList<Integer>(Arrays.asList(0,6,9)));
//        translateA.put(9,new ArrayList<Integer>(Arrays.asList(8)));
//        translateS.put(9,new ArrayList<Integer>(Arrays.asList(5)));
//        ArrayList<Integer> diffs = new ArrayList<>();
//        boolean ok = false;
//        String ori = Integer.toString(sc.nextInt());
//        String targ = Integer.toString(sc.nextInt());
//        int diffcount = 0;
//        for (int i = 0; i < ori.length(); i++){
//            if (ori.charAt(i) != targ.charAt(i)) {
//                diffs.add((int) ori.charAt(i));
//                diffs.add((int) targ.charAt(i));
//                diffcount++;
//            }
//        }
//        if (diffcount == 1) {
//            int l = translateE.get(diffs.get(0)).size();
//            for (int j=0;j<l;j++) {
//                if (translateE.get(diffs.get(0)).get(j) == diffs.get(1)) {
//                    ok = true;
//                }
//            }
//
//        }
//
//        if (diffcount == 2) {
//
//        }
//
//
//
//        if (diffcount > 2) {
//            ok = false;
//        } else if (diffcount == 0) {
//            ok = true;
//        }
//
//        if (ok) {
//            System.out.println("yes");
//        } else {
//            System.out.println("no");
//        }
//    }
//}
