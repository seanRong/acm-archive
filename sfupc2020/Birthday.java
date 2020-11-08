package sfupc2020;
import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class Birthday {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double p = (double) sc.nextInt();
        double d = (double) sc.nextInt();
        if (p > d) {
            System.out.println("1.000000");
        } else {
            double res = 1;
            for (int i=0;i<p;i++) {
                res *= ((d-i)/d);
            }
            res = 1 - res;
            DecimalFormat df = new DecimalFormat("0.000000");
            System.out.println(df.format(new BigDecimal(res).setScale(6, RoundingMode.HALF_UP).doubleValue()));
        }
    }
}