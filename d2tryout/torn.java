package d2tryout;

import java.util.*;
import java.io.*;

public class torn {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        int pieces = sc.nextInt();
        Map<String, ArrayList<String>> adj_list = new HashMap<>();
        for (int i=0;i<pieces;i++) {
            String[] list = sc.nextLine().split(" ");
            ArrayList<String> t = new ArrayList<>();
            if (adj_list.containsKey(list[0])) {
                for (int s = 1; s < list.length; s++) {
                    if (!adj_list.get(list[0]).contains(list[s])) adj_list.get(list[0]).add(list[s]);
                }
            } else {
                for (int s = 1; s < list.length; s++) {
                    t.add(list[s]);
                    if (adj_list.containsKey(list[s])) {
                        if (!adj_list.get(list[s]).contains(list[0])) {
                            adj_list.get(list[s]).add(list[0]);
                        }
                    } else {
                        ArrayList<String> te = new ArrayList<>();
                        t.add(list[0]);
                        adj_list.put(list[s], te);
                    }
                }
                adj_list.put((list[0]),t);
            }
        }

        String start = sc.next();
        String end = sc.next();
        dfsRecursive(start, start, end, adj_list, new HashMap<String, Boolean>(), new HashMap<String, String>());
        System.out.println("no route found\n");
    }

    static void dfsRecursive(String curr, String start, String end, Map<String, ArrayList<String>> adj_list,
                             Map<String, Boolean> visited, HashMap<String, String> parents) {
        visited.put(curr, true);
        if (curr.equals(end)) {
            String listString = "";
            Stack<String> r = new Stack<>();
            String c = curr;
            r.push(c);
            while (!c.equals(start)) {
                r.push(c = parents.get(c));
            }
            while (!r.empty()) {
                listString += r.pop() + " ";
            }
            System.out.println(listString);
            System.exit(0);
        }


        for (String dest: adj_list.get(curr)) {
            if (!visited.getOrDefault(dest, false)) {
                parents.put(dest, curr);
                dfsRecursive(dest, start, end, adj_list, visited, parents);
            }
        }
    }

    static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }
}

