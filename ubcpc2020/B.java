package ubcpc2020;
import java.util.*;


public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int itemCnt = sc.nextInt();
        int boxes = sc.nextInt();
        int res = 0;
        int[] items = new int[itemCnt];
        int start = 1;
        int end = 0;
        for (int i=0;i<itemCnt;i++){
            items[i] = sc.nextInt();
            end += items[i];
        }
        while (start <= end) {
            int mid = (start + end)/ 2;
            if (verify(items, mid, itemCnt, boxes)) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(res);
    }
    static boolean verify(int[] items, int mid, int itemCnt, int boxes) {
        int cnt = 0;
        int sum  = 0;
        for (int i=0;i<itemCnt;i++) {
            if (items[i] > mid) return false;
            sum += items[i];
            if (sum > mid) {
                cnt++;
                sum = items[i];
            }
        }
        cnt++;

        return !(cnt > boxes);
    }
}
