package ubcpc2020;
import java.util.*;

public class H {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // home is building 0
        int days = sc.nextInt();
        int buildings = sc.nextInt();
        int[] buildingHistory = new int[3*days+1];
        int[] weatherHistory = new int[3*days];
        HashMap<Integer,Integer> umbrellaStatus = new HashMap<>();
        umbrellaStatus.put(0,2);
        for (int i=1;i<buildings;i++) {
            umbrellaStatus.put(i, 0);
        }
        buildingHistory[0] = 0;
        int cnt = 1;
        for (int d=0;d<days;d++){
            for (int b=0;b<2;b++) {
                buildingHistory[cnt] = sc.nextInt();
                cnt++;
            }
            buildingHistory[cnt] = 0;
            cnt++;
        }
        for (int d=0;d<days;d++){
            String forecast = sc.next();
            for (int i=0;i<3;i++) {
                if (forecast.charAt(i) == 82) {
                    weatherHistory[3*d+i] = 1;
                } else {
                    weatherHistory[3*d+i] = 0;

                }
            }
        }
        System.out.println(Arrays.toString(buildingHistory));
        System.out.println(Arrays.toString(weatherHistory));
    }
}