package ubcpc2020;

import java.util.*;

public class G {
    static int solCount = 0;
    static HashMap<Integer,int[]> digitPrimeMap = new HashMap<>();
    static int m;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int res = 0;
        int[] rtprimecounts = {4,9,14,16,15,12,8,5};
        int[] rtprimes = {2, 3, 5, 7, 23, 29, 31, 37, 53, 59, 71, 73, 79, 233, 239, 293, 311, 313, 317, 373, 379, 593, 599, 719, 733, 739, 797, 2333, 2339, 2393, 2399, 2939, 3119, 3137, 3733, 3739, 3793, 3797, 5939, 7193, 7331, 7333, 7393, 23333, 23339, 23399, 23993, 29399, 31193, 31379, 37337, 37339, 37397, 59393, 59399, 71933, 73331, 73939, 233993, 239933, 293999, 373379, 373393, 593933, 593993, 719333, 739391, 739393, 739397, 739399, 2339933, 2399333, 2939999, 3733799, 5939333, 7393913, 7393931, 7393933, 23399339, 29399999, 37337999, 59393339, 73939133};
        int cnt = 0;
        for (int i=0;i<rtprimecounts.length;i++){
            int[] temp = new int[rtprimecounts[i]];
            for (int j=0;j<rtprimecounts[i];j++) {
                temp[j] = rtprimes[cnt];
                cnt++;
            }
            digitPrimeMap.put(i+1, temp);
        }

        n = sc.nextInt();
        m = sc.nextInt();
        int[] nlist = digitPrimeMap.get(n);
        int[] mlist = digitPrimeMap.get(m);
        int[][] nsplitlist = new int[nlist.length][n];
        int[][] msplitlist = new int[mlist.length][m];
        for (int i=0;i<nlist.length;i++) {
            int t = nlist[i];
            for (int j=n-1;j>=0;j--) {
                nsplitlist[i][j] = t % 10;
                t = t/10;
            }
        }
        for (int i=0;i<mlist.length;i++) {
            int t = mlist[i];
            for (int j=m-1;j>=0;j--) {
                msplitlist[i][j] = t % 10;
                t = t/10;
            }
        }
        for (int i=0;i<msplitlist.length;i++) {
            int leadDigit = msplitlist[i][0];
            for (int j=0;j<nsplitlist.length;j++) {
                if (nsplitlist[j][0] == leadDigit) {
                    int[][] matrix = new int[n][m];
                    matrix[0] = msplitlist[i];
//                    System.out.println("gen pair " + Arrays.toString(msplitlist[i]) + " " + Arrays.toString(nsplitlist[j]));
                    generate(matrix, nsplitlist[j], msplitlist, nsplitlist, n, 1);
                }
            }
        }
        System.out.println(solCount);



    }

    static void generate(int[][] matrix, int[] nvalue, int[][] msplitlist, int[][] nsplitlist, int n, int currRow){
        if (currRow == n) {
            validate(matrix,msplitlist,nsplitlist);
            return;
        }
        int digit = nvalue[currRow];
        for (int j=0;j< msplitlist.length;j++) {
            if (msplitlist[j][0] == digit) {
                matrix[currRow] = msplitlist[j];
                generate(matrix, nvalue, msplitlist,nsplitlist, n, currRow+1);
            }
        }
    }

    static void validate(int[][] matrix,int[][] msplitlist, int[][] nsplitlist) {
//        System.out.println(Arrays.deepToString(matrix));
        for (int i=0;i<m;i++) {
            int[] t = new int[n];
            for (int j=0;j<n;j++) {
                t[j] = matrix[j][i];
            }
            boolean bad = true;
            for (int a=0;a<nsplitlist.length;a++) {
                if (Arrays.equals(nsplitlist[a],t)) bad = false;
            }
            if (bad) return;
        }
        solCount++;
        return;
    }
}
